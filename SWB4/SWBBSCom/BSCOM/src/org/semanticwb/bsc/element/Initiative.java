package org.semanticwb.bsc.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.GenericFilterRule;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.State;
import static org.semanticwb.bsc.element.Deliverable.names;
import org.semanticwb.bsc.parser.InitiativeParser;
import org.semanticwb.bsc.tracing.PeriodStatus;
import org.semanticwb.bsc.tracing.Series;
import org.semanticwb.bsc.utils.BSCUtils;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;

public class Initiative extends org.semanticwb.bsc.element.base.InitiativeBase {
    private static final Logger log = SWBUtils.getLogger(Initiative.class);
    static {
        bsc_hasDeliverable.registerObserver(new SemanticObserver() {
            @Override
            public void notify(SemanticObject obj, Object prop, String lang, String action) {
                if ("ADD".equalsIgnoreCase(action)) {
                    SWBModel model = (SWBModel) obj.getModel().getModelObject().createGenericInstance();
                    Initiative initiative = (Initiative) obj.createGenericInstance();
                    List<State> states = initiative.listValidStates();
                    Deliverable deliverable = initiative.getLastDeliverable();
                    if (!states.isEmpty() && deliverable != null) {
                        Series series;
                        for (int i = 0; i < names.length; i++) {
                            series = Series.ClassMgr.createSeries(model);
                            series.setTitle(names[i]);
                            series.setTitle(names[i], lang);
                            series.setDescription("Hito de cumplimiento");
                            series.setDescription("Hito de cumplimiento", lang);
                            series.setIndex(i);
                            series.setActive(true);
                            deliverable.addSeries(series);
                        }
                    }
                }
            }
        });

        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Initiative.class, new InitiativeParser());
    }

    public Initiative(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    public Deliverable getLastDeliverable() {
        return getDeliverable();
    }

    @Override
    public synchronized Deliverable getDeliverable() {
        Iterator<Deliverable> it = SWBComparator.sortByCreated(listDeliverables(), false);
        return it.hasNext() ? it.next() : null;
    }
    
    public Iterator<Period> listPeriods(boolean ascendent) {        
        List<Period> periods = SWBUtils.Collections.copyIterator(super.listPeriods());
        if(ascendent) {
            Collections.sort(periods);
        }else {            
            Collections.sort(periods, Collections.reverseOrder());            
        }
        return periods.iterator();
    }

    @Override
    public Iterator<Period> listAvailablePeriods() {
        return listAvailablePeriods(true);
    }

    @Override
    public Iterator<Period> listAvailablePeriods(boolean ascendent) {
        return getBSC().listPeriods(ascendent);
    }

    public List<Deliverable> listValidDeliverables() {
        List<Deliverable> validDeliverables = SWBUtils.Collections.filterIterator(super.listDeliverables(), new GenericFilterRule<Deliverable>() {
            @Override
            public boolean filter(Deliverable d) {
                /*User user = SWBContext.getSessionUser(getBSC().getUserRepository().getId());
                if (user == null) {
                    user = SWBContext.getAdminUser();
                }
                return !d.isValid() || !user.haveAccess(d);*/
                return !d.isValid();
            }
        });
        return validDeliverables;
    }

    @Override
    public List<State> listValidStates() {
        List<State> validStates = SWBUtils.Collections.filterIterator(super.listStates(), new GenericFilterRule<State>() {
            @Override
            public boolean filter(State s) {
                if (s == null) {
                    return true;
                }
                /*User user = SWBContext.getSessionUser(getBSC().getUserRepository().getId());
                if (user == null) {
                    user = SWBContext.getAdminUser();
                }
                return !s.isValid() || !user.haveAccess(s);*/
                return !s.isValid();
            }
        });
        return validStates;
    }

    @Override
    public State getMinimumState() {
        ArrayList<State> states = (ArrayList)sortStates();
        states.trimToSize();
        try {
            return states.get(0);
        }catch (IndexOutOfBoundsException e) {
        }
        return null;
    }

    @Override
    public State getMaximumState() {
        ArrayList<State> states = (ArrayList)sortStates(false);
        states.trimToSize();
        try {
            return states.get(0);
        }catch (IndexOutOfBoundsException e) {
        }
        return null;
    }

    @Override
    public PeriodStatus getPeriodStatus(Period period) {
        Iterator<PeriodStatus> appraisals = listPeriodStatuses();
        PeriodStatus appraisal;
        while (appraisals.hasNext()) {
            appraisal = appraisals.next();
            if (appraisal.getPeriod().equals(period)) {
                return appraisal;
            }
        }
        return null;
    }
    
    @Override
    public List<State> sortStates() {
        return sortStates(true);
    }

    @Override
    public List<State> sortStates(boolean ascendent) {
        List<State> states = listValidStates();
        if (ascendent) {
            Collections.sort(states);
        } else {
            Collections.sort(states, Collections.reverseOrder());
        }
        return states;
    }
    
    public boolean updateAppraisal(Period period) {
        boolean updated = Boolean.FALSE;
        // Determinar el estatus del período especificado
        State status;
        PeriodStatus appraisal = getPeriodStatus(period);
        if (appraisal == null) {
            appraisal = PeriodStatus.ClassMgr.createPeriodStatus(getBSC());
            appraisal.setPeriod(period);
            addPeriodStatus(appraisal);
        }
        status = getMaximumState();
        // Determinar el estatus de la iniciativa
        List<Deliverable> deliverables = listValidDeliverables();
        for (Deliverable deliverable : deliverables) {
            Series star = deliverable.getStar();
            if(star == null || star.getMeasure(period) == null || star.getMeasure(period).getEvaluation().getStatus() == null)
            {
                continue;
            }
            if(star.getMeasure(period).getEvaluation().getStatus().compareTo(status) < 0)
            {
                status = star.getMeasure(period).getEvaluation().getStatus();
                updated = Boolean.TRUE;
            }
        }
        if(!updated) {
            status = getMinimumState();
        }
        appraisal.setStatus(status);
        // Calcular el porcentaje de avance
        setPercentageProgress(appraisal);
        return updated;
    }
    
    @Override
    public float getPercentageProgress() {
        return super.getPercentageProgress(); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void setPercentageProgress(final PeriodStatus appraisal) {
        // Calcular el porcentaje de avance de los entregables
        Period period = appraisal.getPeriod();
        List<Deliverable> deliverables = listValidDeliverables();
        float m;
        float weighingSum = 0;
        float xwSum = 0;
        float f, value;
        // Calcular el porcentaje de avance formulado como un promedio ponderado
        for (Deliverable deliverable : deliverables) {
            Series star = deliverable.getStar();
            if(star == null) {
                log.error("No existe STAR definido en el entregable "+deliverable.getTitle());
                continue;
            }
            if(star.getMeasure(period) == null) {
                log.error("El entregable "+deliverable.getTitle()+" no mide para el periodo "+period.getTitle());
                continue;
            }
            if(deliverable.getPriority() == null) {
                log.error("No existe prioridad definida en el entregable "+deliverable.getTitle());
                continue;
            }
            value = star.getMeasure(period).getValue();
            if(Float.isNaN(value)) {
                f = 0F;
            }else {
                f = BSCUtils.Formats.round(value * deliverable.getPriority().getWeighing(), 2).floatValue();
            }
            // f puede, en un periodo dado, ser menor que el valor acumulado
            // actual ya que puede que para ese periodo no exista valor porque, 
            // tal vez, no se capturó.
            if(f>deliverable.getProgress()) {
                deliverable.setProgress(f);
            }
            xwSum += deliverable.getProgress();
            weighingSum += deliverable.getPriority().getWeighing();
        }
        m = xwSum / weighingSum;
        if(!Float.isInfinite(m) && !Float.isNaN(m)) {
            m = BSCUtils.Formats.round(m, 2).floatValue();
            if(getPercentageProgress()<m) {
                setPercentageProgress(m);
            }
        }
    }

//    public String getAutoStatusIconClass() {
//        StringBuilder iconClass = new StringBuilder();
//        try {
//            iconClass.append(getStatusAssigned().getIconClass());
//        } catch (NullPointerException npe) {
//            iconClass.append("swbstrgy-unknown");
//        }
//        return iconClass.toString();
//    }
    
    @Override
    public boolean canView() {
        final WebSite scorecard = (WebSite) getSemanticObject().getModel().getModelObject().createGenericInstance();
        final User user = SWBContext.getSessionUser(scorecard.getUserRepository().getId());
        return user.haveAccess(this) && isValid();
    }

    @Override
    public String getStatusIconClass() {
        StringBuilder iconClass = new StringBuilder();
        try {
            iconClass.append(getPeriodStatus().getStatus().getIconClass());
        } catch (NullPointerException npe) {
            iconClass.append("swbstrgy-unknown");
        }
        return iconClass.toString();
    }

    @Override
    public String getStatusIconClass(Period period) {
        String iconClass;
        try {
            iconClass = getPeriodStatus(period).getStatus().getIconClass();
        } catch (NullPointerException npe) {
            iconClass = "swbstrgy-unknown";
        }
        return iconClass;
    }
    
    @Override
    public String getStatusTitle(Period period) {
        String title;
        try {
            title = getPeriodStatus(period).getStatus().getTitle();
        } catch (NullPointerException npe) {
            title = "";
        }
        return title;
    }
    
    /**
     * Recupera el primer período de la lista de períodos asignados a la
     * iniciativa.
     *
     * @return El período más anterior
     */
    @Override
    public Period getFirstPeriod() {
        List<Period> periods = SWBUtils.Collections.copyIterator(listPeriods(true));
        try {
            return periods.get(0);
        }catch(IndexOutOfBoundsException iobe) {
        }
        return null;
    }
    
    /**
     * Recupera el último período de la lista de períodos asignados a la
     * iniciativa.
     *
     * @return El período más posterior
     */
    @Override
    public Period getLastPeriod() {
        List<Period> periods = SWBUtils.Collections.copyIterator(listPeriods(false));
        try {
            return periods.get(0);
        }catch(IndexOutOfBoundsException iobe) {
        }
        return null;
    }
    
    @Override
    public Period getNextPeriod() {
        return null;
    }
}
