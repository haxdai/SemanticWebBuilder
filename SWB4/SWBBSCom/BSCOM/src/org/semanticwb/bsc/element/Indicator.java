package org.semanticwb.bsc.element;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.GenericFilterRule;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.State;
import org.semanticwb.bsc.parser.IndicatorParser;
import org.semanticwb.bsc.tracing.EvaluationRule;
import org.semanticwb.bsc.tracing.Measure;
import org.semanticwb.bsc.tracing.Series;
import org.semanticwb.bsc.utils.InappropriateFrequencyException;
import org.semanticwb.bsc.utils.UndefinedFrequencyException;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;

/*
 * Clase que persiste informaci&oacute;n de un indicador. Un indicador permite informar sobre el avance para alcanzar un objetivo.
 */
public class Indicator extends org.semanticwb.bsc.element.base.IndicatorBase {

    public static final String names[] = {"Actual", "Meta", "Actual Acumulado", "Meta Acumulada"};

    static {
        bsc_hasSeries.registerObserver(new SemanticObserver() {
            @Override
            public void notify(SemanticObject obj, Object prop, String lang, String action) {
                if ("ADD".equalsIgnoreCase(action)) {
                    Indicator indicator = (Indicator) obj.createGenericInstance();
                    // Funcionan exactamente igual indicator.getSeries() y indicator.getLastSeries()
                    Series series = indicator.getSeries();
                    if (series != null && series.getEvaluationRule() == null) {
                        State state;
                        List<State> validStates = indicator.listValidStates();
                        for (int i = 0; i < validStates.size(); i++) {
                            state = validStates.get(i);
                            EvaluationRule rule = EvaluationRule.ClassMgr.createEvaluationRule(indicator.getBSC());
                            rule.setTitle("Regla para " + state.getTitle());
                            rule.setTitle("Regla para " + state.getTitle(lang), lang);
                            rule.setAppraisal(state);
                            series.addEvaluationRule(rule);
                        }
                    }
                }
            }
        });

        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Indicator.class, new IndicatorParser());
    }

    public Indicator(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    /**
     * Obtiene el prefijo para identificar un indicador. En caso de que el
     * prefijo sea nulo, asigna un prefijo en autom&aacute;tico.
     *
     * @return {@code String} Regresa un string con el prefijo asociado al
     * indicador, si el prefijo es asignado en autom&aacute;tico utiliza el
     * prefijo del objetivo seguido de un n&uacute;mero consecutivo asignado por
     * un motor.
     * <p>
     * Ejemplo:
     * </p>
     * <p>
     * El motor asigna un n&uacute;mero 1 para el Objetivo F1, se
     * obtendr&iacute;a el siguiente prefijo: {@literal  F1.1 }
     * </p>
     */
    @Override
    public String getPrefix() {
        String prefix = super.getPrefix();
        if (prefix == null) {
            try {
                prefix = getObjective().getPrefix().trim() + "." + getObjective().getSerial();
            } catch (Exception e) {
                prefix = getObjective().getTitle().substring(0, 1).toUpperCase() + "." + getObjective().getSerial();
            }
            setPrefix(prefix);
        }
        return prefix;
    }

    /**
     * Asigna un prefijo al indicador
     *
     * @param value
     */
    @Override
    public void setPrefix(String value) {
        super.setPrefix(value);
    }

    @Override
    public boolean updateAppraisal(Period period) {
        return getObjective().updateAppraisal(period);
    }

    @Override
    public boolean hasState(State value) {
        return getObjective().hasState(value);
    }

    private List<Period> sortValidPeriods() {
        return sortValidPeriods(true);
    }

    private List<Period> sortValidPeriods(boolean ascendent) {
        List<Period> periods = listValidPeriods();
        if (ascendent) {
            Collections.sort(periods);
        }else {
            Collections.sort(periods, Collections.reverseOrder());
        }
        return periods;
    }

    /**
     * Devuelve todos los períodos de medición ordenados ascendentemente
     *
     * @return A GenericIterator with all the
     * org.semanticwb.bsc.accessory.Period sorted
     * @throws org.semanticwb.bsc.utils.UndefinedFrequencyException
     * @throws org.semanticwb.bsc.utils.InappropriateFrequencyException
     */
    @Override
    public Iterator<Period> listMeasurablesPeriods() throws UndefinedFrequencyException, InappropriateFrequencyException {
        return listMeasurablesPeriods(true);
    }

    /**
     * Devuelve todos los períodos de medición ordenados.
     *
     * @param ascendent - para ordenar ascendente use ascendent=true y
     * descendentemente=false para orden descendente
     * @return A GenericIterator with all the
     * org.semanticwb.bsc.accessory.Period sorted
     * @throws org.semanticwb.bsc.utils.UndefinedFrequencyException
     * @throws org.semanticwb.bsc.utils.InappropriateFrequencyException
     */
    @Override
    public Iterator<Period> listMeasurablesPeriods(boolean ascendent) throws UndefinedFrequencyException, InappropriateFrequencyException {
        int f = 0;
        try {
            f = getPeriodicity().getNumberOfPeriods();
        } catch (Exception e) {
            throw new UndefinedFrequencyException("Frecuencia de medición indefinida.");
        }
        if (f < 1) {
            throw new InappropriateFrequencyException("Frecuencia de medición inapropiada");
        }

        List<Period> periods = sortValidPeriods();
        List<Period> measurablesPeriods = new ArrayList();
        for (int i = 1; i <= periods.size(); i++) {
            if (i % f == 0) {
                measurablesPeriods.add(periods.get(i - 1));
            }
        }
        if (ascendent) {
            Collections.sort(measurablesPeriods);
        } else {
            Collections.sort(measurablesPeriods, Collections.reverseOrder());
        }
        return measurablesPeriods.iterator();
    }

    /**
     * Recupera el primer período de la lista de períodos asignados al
     * indicador.
     *
     * @return El período más anterior
     */
    @Override
    public Period getFirstPeriod() {
        List<Period> periods = sortValidPeriods();
        try {
            return periods.get(0);
        } catch (IndexOutOfBoundsException e) {
        }
        return null;
    }

    /**
     * Recupera el último período de la lista de períodos asignados al
     * indicador.
     *
     * @return El período más posterior
     */
    @Override
    public Period getLastPeriod() {
        List<Period> periods = sortValidPeriods(false);
        try {
            return periods.get(0);
        } catch (IndexOutOfBoundsException e) {
        }
        return null;
    }
    
    @Override
    public Period getNextPeriod() {
        return null;
    }

    @Override
    public State getMinimumState() {
        return getObjective().getMinimumState();
    }

    @Override
    public State getMaximumState() {
        return getObjective().getMaximumState();
    }

    @Override
    public SemanticObject getParent() {
        return getObjective().getSemanticObject();
    }

    public Series getLastSeries() {
        return getSeries();
    }

    @Override
    public Series getSeries() {
        Iterator<Series> it = SWBComparator.sortByCreated(listSerieses(), false);
        return it.hasNext() ? it.next() : null;
    }

    @Override
    public GenericIterator<Period> listPeriods() {
        return (GenericIterator)listPeriods(true);
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
        //return getObjective().listAvailablePeriods();
        return listAvailablePeriods(true);
    }

    @Override
    public Iterator<Period> listAvailablePeriods(boolean ascendent) {
        //return getObjective().listAvailablePeriods(ascendent);
        return getObjective().listPeriods(ascendent);
    }

    @Override
    public List<Series> listValidSerieses() {
        List<Series> validSerieses = SWBUtils.Collections.filterIterator(super.listSerieses(), new GenericFilterRule<Series>() {
            @Override
            public boolean filter(Series s) {
                /*User user = SWBContext.getSessionUser(getBSC().getUserRepository().getId());
                if (user == null) {
                    user = SWBContext.getAdminUser();
                }
                return !s.isValid() || !user.haveAccess(s);*/
                return !s.isValid();
            }
        });
        return validSerieses;
    }

    @Override
    public List<Period> listValidPeriods() {
        List<Period> validPeriods = SWBUtils.Collections.filterIterator(super.listPeriods(), new GenericFilterRule<Period>() {
            @Override
            public boolean filter(Period p) {
                /*User user = SWBContext.getSessionUser(getBSC().getUserRepository().getId());
                if (user == null) {
                    user = SWBContext.getAdminUser();
                }
                return !p.isValid() || !user.haveAccess(p);*/
                return !p.isValid();
            }
        });
        return validPeriods;
    }

    @Override
    public List<State> listValidStates() {
        return getObjective().listValidStates();
    }

    /**
     * Recupera el período más próximo de medición en base a la fecha actual.
     *
     * @return El período más próximo de medición en base a la fecha actual.
     * @throws org.semanticwb.bsc.utils.UndefinedFrequencyException
     * @throws org.semanticwb.bsc.utils.InappropriateFrequencyException
     */
    public Period nearestMeasurementPeriod() 
            throws UndefinedFrequencyException, InappropriateFrequencyException
    {
        //List<Period> periods = listValidPeriods();
        //Collections.sort(periods);
        
        Iterator<Period> periods = listMeasurablesPeriods(false);
        
        Period period;
        GregorianCalendar left;
        GregorianCalendar right;        
        GregorianCalendar current = new GregorianCalendar();
        //for (Period period : periods) {
        while(periods.hasNext()) {
            period = periods.next();
            
            left = new GregorianCalendar();
            left.setTime(period.getStart());
            left.set(Calendar.HOUR, 0);
            left.set(Calendar.MINUTE, 0);
            left.set(Calendar.SECOND, 0);
            
            right = new GregorianCalendar();
            right.setTime(period.getEnd());
            right.set(Calendar.HOUR, 23);
            right.set(Calendar.MINUTE, 59);
            right.set(Calendar.SECOND, 59);
            
            if (current.compareTo(left) >= 0 && current.compareTo(right) <= 0) {
                return period;
            }
        }
        return null;
    }
    
    @Override
    public boolean canView() {
        final WebSite scorecard = (WebSite) getSemanticObject().getModel().getModelObject().createGenericInstance();
        final User user = SWBContext.getSessionUser(scorecard.getUserRepository().getId());
        return user.haveAccess(this);
    }

    @Override
    public String getStatusIconClass() {
        String iconClass;
        try {
            iconClass = getStar().getMeasure().getEvaluation().getStatus().getIconClass();
        } catch (NullPointerException npe) {
            iconClass = "swbstrgy-unknown";
        }
        return iconClass;
    }

    @Override
    public String getStatusIconClass(final Period period) {
        String iconClass = "swbstrgy-unknown";
        if(getStar()==null) {
            return iconClass;
        }
        
        Period p = period;
        Measure ms;
        while( p!=null ) {
            ms = getStar().getMeasure(p);
            if(ms!=null && ms.getEvaluation()!=null && ms.getEvaluation().getStatus()!=null) {
                iconClass = ms.getEvaluation().getStatus().getIconClass();
                return iconClass;
            }
            p = (Period)p.getPrevius();
        }
        return iconClass;
    }
    
    @Override
    public String getStatusTitle(Period period) {
        String title;
        try {
            title = getStar().getMeasure(period).getEvaluation().getStatus().getTitle();
        } catch (NullPointerException npe) {
            title = "";
        }
        return title;
    }

    @Override
    public boolean isValid() {
        return super.isValid() && getObjective().isValid();
    }
}
