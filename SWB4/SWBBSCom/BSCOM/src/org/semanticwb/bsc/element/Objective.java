package org.semanticwb.bsc.element;

import java.util.Collections;
import org.semanticwb.bsc.tracing.PeriodStatus;
import org.semanticwb.model.GenericIterator;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.GenericFilterRule;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.State;
import org.semanticwb.bsc.tracing.Series;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;
import static org.semanticwb.bsc.element.Indicator.*;
import org.semanticwb.bsc.parser.ObjectiveParser;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.platform.SemanticProperty;

public class Objective extends org.semanticwb.bsc.element.base.ObjectiveBase implements Comparable<Objective>
{
    static
    {
        bsc_hasIndicator.registerObserver(new SemanticObserver() {
            @Override
            public void notify(SemanticObject obj, Object prop, String lang, String action)
            {
                if("ADD".equalsIgnoreCase(action)) {
                    SWBModel model = (SWBModel)obj.getModel().getModelObject().createGenericInstance();
                    Objective objective = (Objective)obj.createGenericInstance();
                    List<State> states = objective.listValidStates();
                    // Funcionan exactamente igual objective.getIndicator() y objective.getLastIndicator()
                    Indicator indicator = objective.getIndicator();
                    if(!states.isEmpty() && indicator!=null)
                    {
//                        indicator.addAllStates(states);
                        Series series;
                        for(int i=0; i<names.length; i++)
                        {
                            series = Series.ClassMgr.createSeries(model);
                            series.setTitle(names[i]);
                            series.setTitle(names[i], lang);
                            series.setDescription("Serie "+names[i]);
                            series.setDescription("Serie "+names[i], lang);
                            series.setIndex(i);
                            series.setActive(true);
                            indicator.addSeries(series);
                        }
                    }
                }
            }
        });
        
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Objective.class, new ObjectiveParser());
    }
    
    public Objective(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }
    
    /**
     * Obtiene el n&uacute;mero consecutivo utilizado en la asignaci&oacute;n del prefijo de un 
     * indicador.
     * @return {@code Int} Retorna un n&uacute;mero consecutivo, obtenido del objetivo que 
     * contiene los indicadores
     */
    @Override
    public synchronized int getSerial() {
        setSerial(super.getSerial()+1);
        return super.getSerial();
    }
    
    /**
     * Actualiza el n&uacute;mero consecutivo a utilizar en el prefijo de un indicador.
     * @param value N&uacute;mero entero actualizado.
     */
    @Override
    public synchronized void setSerial(int value) {
        super.setSerial(value);
    }

    /**
     * Obtiene el prefijo que identifica un objetivo. El prefijo esta definido por el prefijo de la 
     * perspectiva a la que esta asociado el objetivo, seguido de un n&uacute;mero consecutivo. 
     * @return {@code String} Regresa un string con el prefijo asociado a un objetivo.
     * <p>
     * Ejemplo:
     * </p> 
     * <p>
     * El prefijo de la perspectiva es F y el n&uacute;mero consecutivo asignado para el objetivo es 
     * 1, se obtendr&iacute;a el siguiente prefijo: 
     *  {@literal  F1 }
     * </p> 
     */
    @Override
    public String getPrefix() {
        String prefix = super.getPrefix();
        if(prefix==null) {
            try {
                prefix = getTheme().getPerspective().getPrefix().trim() + getTheme().getPerspective().getSerial();
            }catch(Exception e) {
                prefix = getTheme().getPerspective().getTitle().substring(0, 1).toUpperCase() + getTheme().getPerspective().getSerial();
            }
            setPrefix(prefix);
        }
        return prefix;
    }
    
    /**
     * Asigna el prefijo de un objetivo.
     */
    @Override
    public void setPrefix(String value) {
        super.setPrefix(value);
    }
    
    public boolean updateAppraisal(Period period)
    {
        boolean res = Boolean.FALSE;
        State status;
        PeriodStatus appraisal = getPeriodStatus(period);
        if(appraisal==null) {
            appraisal = PeriodStatus.ClassMgr.createPeriodStatus(getBSC());
            appraisal.setPeriod(period);
            addPeriodStatus(appraisal);
//            status = getMaximumState();
        }
//        else
//        {
//            status = appraisal.getStatus();
//        }
        status = getMaximumState();
System.out.println("0 periodo="+period.getTitle());
System.out.println("1 status="+status.getTitle());
        
        Iterator<Indicator> indicators = listValidIndicators().iterator();
        while(indicators.hasNext()) {
            Indicator indicator = indicators.next();
System.out.println("  indicador="+indicator.getTitle());
            Series star = indicator.getStar();
            if(star==null || star.getMeasure(period)==null || star.getMeasure(period).getEvaluation().getStatus()==null) {
                continue;
            }
System.out.println("  star="+indicator.getStar().getTitle());
System.out.println("estado de star para periodo="+star.getMeasure(period).getEvaluation().getStatus().getTitle());
            if( star.getMeasure(period).getEvaluation().getStatus().compareTo(status)<0 ) {
                status = star.getMeasure(period).getEvaluation().getStatus();
                res = Boolean.TRUE;
System.out.println("cambia valor estado.........");
            }
        }
        appraisal.setStatus(status);
        return res;
    }
    
    @Override
    public State getMinimumState() {
        List<State> states = sortStates();
        try {
            return states.get(0);
        }catch(IndexOutOfBoundsException e) {
        
        }
        return null;
    }
    
    @Override
    public State getMaximumState() {
        List<State> states = sortStates(false);
        try {
            return states.get(0);
        }catch(IndexOutOfBoundsException e) {
        
        }
        return null;
    }
    
    public State getState(Period period) {
        State status = null;
        PeriodStatus ps = getPeriodStatus(period);
        if(ps!=null) {
            status = ps.getStatus()==null?getMinimumState():ps.getStatus();
        }
        return status;
    }
    
    @Override
    public PeriodStatus getPeriodStatus(Period period) {
        Iterator<PeriodStatus> appraisals = listPeriodStatuses();
        PeriodStatus appraisal;
        while(appraisals.hasNext())
        {
            appraisal = appraisals.next();
            if(appraisal.getPeriod().equals(period))
            {
                return appraisal;
            }
        }
        return null;
    }
    
    private List<Period> sortPeriods() {
        return sortPeriods(true);
    }
    
    private List<Period> sortPeriods(boolean ascendent) {
        List<Period> periods;
        periods = SWBUtils.Collections.copyIterator(super.listPeriods());
        if(ascendent) {
            Collections.sort(periods);
        }else {             
            Collections.sort(periods, Collections.reverseOrder());            
        }
        return periods;
    }
    
    private List<State> sortStates() {
        return sortStates(true);
    }
    
    private List<State> sortStates(boolean ascendent) {
        List<State> states = listValidStates();
        if(ascendent) {
            Collections.sort(states);
        }else {            
            Collections.sort(states, Collections.reverseOrder());
        }
        return states;
    }
    
    public Indicator getLastIndicator() {
        return getIndicator();
    }

    @Override
    public synchronized Indicator getIndicator() {
        Iterator<Indicator> it = SWBComparator.sortByCreated(listIndicators(), false);
        return it.hasNext()?it.next():null;
    }
    
    @Override
    public Iterator<Period> listAvailablePeriods() {
        return getBSC().listPeriods();
    }
    
    @Override
    public Iterator<Period> listAvailablePeriods(boolean ascendent) {
        return getBSC().listPeriods(ascendent);
    }
    
    @Override
    public List<State> listValidStates() {
        List<State> validStates = SWBUtils.Collections.filterIterator(super.listStates(), new GenericFilterRule<State>() {
                                                        @Override
                                                        public boolean filter(State s) {
                                                            if(s==null) {
                                                                return true;
                                                            }
                                                            User user = SWBContext.getSessionUser(getBSC().getUserRepository().getId());
                                                            if(user==null) {
                                                                user = SWBContext.getAdminUser();
                                                            }
                                                            return !s.isValid() || !user.haveAccess(s);
                                                        }            
                                                    });
        return validStates;
    }
    
    public List<Period> listValidPeriods() {
        List<Period> validPeriods = SWBUtils.Collections.filterIterator(super.listPeriods(), new GenericFilterRule<Period>() {
                                                        @Override
                                                        public boolean filter(Period s) {
                                                            User user = SWBContext.getSessionUser(getBSC().getUserRepository().getId());
                                                            if(user==null) {
                                                                user = SWBContext.getAdminUser();
                                                            }
                                                            return !s.isValid() || !user.haveAccess(s);
                                                        }            
                                                    });
        return validPeriods;
    }
    
    public List<Indicator> listValidIndicators() {
        List<Indicator> validIndicators = SWBUtils.Collections.filterIterator(super.listIndicators(), new GenericFilterRule<Indicator>() {
                                                        @Override
                                                        public boolean filter(Indicator s) {
                                                            User user = SWBContext.getSessionUser(getBSC().getUserRepository().getId());
                                                            if(user==null) {
                                                                user = SWBContext.getAdminUser();
                                                            }
                                                            return !s.isValid() || !user.haveAccess(s);
                                                        }            
                                                    });
        return validIndicators;
    }

    @Override
    public void removePeriod(Period value) {
        super.removePeriod(value);
        GenericIterator<Indicator> gi = listIndicators();
        while(gi.hasNext()) {
            gi.next().removePeriod(value);
        }
    }

    @Override
    public void removeAllPeriod() {
        super.removeAllPeriod();
        GenericIterator<Indicator> gi = listIndicators();
        while(gi.hasNext()) {
            gi.next().removeAllPeriod();
        }
    }
    
    @Override
    public int compareTo(Objective anotherObjective)
    {
        int compare = getIndex()>anotherObjective.getIndex()?1:-1;
        return compare;
    }
    
    @Override
    public boolean isValid() {
        return super.isValid() && getTheme().isValid();
    }

    @Override
    public String getStatusIconClass() {
        String iconClass;
        try{
            iconClass = getPeriodStatus().getStatus().getIconClass();
        }catch(NullPointerException npe) {
            iconClass = getMinimumState().getIconClass();
        }
        return iconClass;
    }
    
    @Override
    public String getStatusIconClass(Period period) {
        String iconClass;
        try{
            iconClass = getPeriodStatus(period).getStatus().getIconClass();
        }catch(NullPointerException npe) {
            try {
                iconClass = getMinimumState().getIconClass();
            }catch(Exception e) {
                iconClass = "undefined";
            }
        }
        return iconClass;
    }

    @Override
    public void validOrder(HttpServletRequest request, SemanticProperty prop, String propName) throws FormValidateException {
        int ordinal;
        try {
            String value = request.getParameter(propName);
            ordinal = Integer.parseInt(value);
        }catch(NumberFormatException pe) {            
            throw new FormValidateException("El valor debe ser numérico y no puede repetirse");
        }
        
        GenericIterator<Objective> it = getTheme().listObjectives();
        while(it.hasNext()) {
            Objective o = it.next();
            if( this.equals(o) ) {
                continue;
            }
            if(o.getIndex() == ordinal) {
                throw new FormValidateException("El valor ordinal debe ser numérico y no puede repetirse");
            }
        }
    }
    
    public boolean hasInitiative(Initiative initiative) {
        Iterator<Indicator> indicators = Indicator.ClassMgr.listIndicatorByInitiative(initiative, getBSC());
        while(indicators.hasNext()) {
            Indicator indicator = indicators.next();
            if(hasIndicator(indicator)) {
                return true;
            }
        }
        return false;
    }
}
