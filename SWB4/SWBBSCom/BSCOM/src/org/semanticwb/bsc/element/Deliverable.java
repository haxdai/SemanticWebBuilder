package org.semanticwb.bsc.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.GenericFilterRule;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.State;
import static org.semanticwb.bsc.base.SMBase.bsc_hasSeries;
import org.semanticwb.bsc.parser.DeliverableParser;
import org.semanticwb.bsc.tracing.EvaluationRule;
import org.semanticwb.bsc.tracing.Series;
import org.semanticwb.bsc.utils.InappropriateFrequencyException;
import org.semanticwb.bsc.utils.UndefinedFrequencyException;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;

public class Deliverable extends org.semanticwb.bsc.element.base.DeliverableBase {

    public static final String names[] = {"Esfuerzo real", "Esfuerzo planeado"};

    static {
        bsc_hasSeries.registerObserver(new SemanticObserver() {
            @Override
            public void notify(SemanticObject obj, Object prop, String lang, String action) {
                if ("ADD".equalsIgnoreCase(action)) {
                    Deliverable deliverable = (Deliverable) obj.createGenericInstance();
                    // Funcionan exactamente igual indicator.getSeries() y indicator.getLastSeries()
                    Series series = deliverable.getSeries();
                    if (series != null && series.getEvaluationRule() == null) {
                        State state;
                        List<State> validStates = deliverable.listValidStates();
                        for (int i = 0; i < validStates.size(); i++) {
                            state = validStates.get(i);
                            EvaluationRule rule = EvaluationRule.ClassMgr.createEvaluationRule(deliverable.getBSC());
                            rule.setTitle("Regla para " + state.getTitle());
                            rule.setTitle("Regla para " + state.getTitle(lang), lang);
                            rule.setAppraisal(state);
                            series.addEvaluationRule(rule);
                        }
                    }
                }
            }
        });
        
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(Deliverable.class, new DeliverableParser());
    }

    public Deliverable(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    @Override
    public BSC getBSC() {
        return getInitiative().getBSC();
    }

    @Override
    public void setProgress(float value) {
        super.setProgress(value);
    }

    @Override
    public boolean updateAppraisal(Period period) {
        return getInitiative().updateAppraisal(period);
    }
    
    @Override
    public Iterator<Period> listAvailablePeriods() {
        //return getInitiative().listAvailablePeriods();
        return listAvailablePeriods(true);
    }

    @Override
    public Iterator<Period> listAvailablePeriods(boolean ascendent) {
        //return getInitiative().listAvailablePeriods(ascendent);
        return getInitiative().listPeriods(ascendent);
    }

    private List<Period> sortValidPeriods() {
        return sortValidPeriods(true);
    }

    private List<Period> sortValidPeriods(boolean ascendent) {
        //List<Period> periods = SWBUtils.Collections.copyIterator(listPeriods());
        List<Period> periods = listValidPeriods();
        if (ascendent) {
            Collections.sort(periods);
        } else {
            Collections.sort(periods, Collections.reverseOrder());
        }
        return periods;
    }

    @Override
    public List<Period> listValidPeriods() {
        List<Period> validPeriods = SWBUtils.Collections.filterIterator(super.listPeriods(), new GenericFilterRule<Period>() {
            @Override
            public boolean filter(Period p) {
                if(null==p) {
                    return true;
                }
                User user = SWBContext.getSessionUser(getBSC().getUserRepository().getId());
                if (user == null) {
                    user = SWBContext.getAdminUser();
                }
                return !p.isValid() || !user.haveAccess(p);
            }
        });
        return validPeriods;
    }
    
    @Override
    public boolean canView() {
        final WebSite scorecard = (WebSite) getSemanticObject().getModel().getModelObject().createGenericInstance();
        final User user = SWBContext.getSessionUser(scorecard.getUserRepository().getId());
        return user.haveAccess(this);
    }

    @Override
    public State getMinimumState() {
        
        return getInitiative().getMinimumState();
    }

    @Override
    public State getMaximumState() {
        return getInitiative().getMaximumState();
    }

    @Override
    public SemanticObject getParent() {
        return getInitiative().getSemanticObject();
    }

    @Override
    public boolean hasState(State value) {
        return getInitiative().hasState(value);
    }

    private List<State> sortStates() {
        return getInitiative().sortStates();
    }

    private List<State> sortStates(boolean ascendent) {
        return getInitiative().sortStates(ascendent);
    }

    @Override
    public List<State> listValidStates() {
        return getInitiative().listValidStates();
    }

    @Override
    public List<Series> listValidSerieses() {
        List<Series> validSerieses = SWBUtils.Collections.filterIterator(super.listSerieses(), new GenericFilterRule<Series>() {
            @Override
            public boolean filter(Series s) {
                //s.getUserGroup().getUserRepository().getId()
                BSC scorecard = (BSC) s.getSemanticObject().getModel().getModelObject().createGenericInstance();
                User user = SWBContext.getSessionUser(scorecard.getUserRepository().getId());
                if (user == null) {
                    user = SWBContext.getAdminUser();
                }
                return !s.isValid() || !user.haveAccess(s);
            }
        });
        return validSerieses;
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
            //f = getPeriodicity().getNumberOfPeriods();
            f = 1;
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

    public String getAutoStatusIconClass() {
        String iconClass;
        try {
            iconClass = getAutoStatus().getIconClass();
        } catch (NullPointerException npe) {
            iconClass = "swbstrgy-unknown";
        }
        return iconClass;
    }

    @Override
    public String getStatusIconClass() {
        StringBuilder iconClass = new StringBuilder();
        boolean iconClassFound = false;
        try {
            iconClass.append(getStar().getMeasure().getEvaluation().getStatus().getIconClass());
            iconClassFound = true;
        } catch (NullPointerException npe) {
        }
        if (!iconClassFound) {
            try {
                State state = this.getMinimumState();
                getStar().getMeasure().getEvaluation().setStatus(state);
                iconClass.append(getStar().getMeasure().getEvaluation().getStatus().getIconClass());
            } catch (NullPointerException ex) {
                iconClass.append("swbstrgy-unknown");
            }
        }
        return iconClass.toString();
    }

    @Override
    public String getStatusIconClass(Period period) {
        StringBuilder iconClass = new StringBuilder();
        boolean iconClassFound = false;
        try {
            iconClass.append(getStar().getMeasure(period).getEvaluation().getStatus().getIconClass());
            iconClassFound = true;
        }catch (NullPointerException npe) {
        }
        if (!iconClassFound) {
            try {
                State state = this.getMinimumState();
                getStar().getMeasure(period).getEvaluation().setStatus(state);
                iconClass.append(getStar().getMeasure(period).getEvaluation().getStatus().getIconClass());
            }catch (NullPointerException ex) {
                iconClass.append("swbstrgy-unknown");
            }
        }
        return iconClass.toString();
    }
    
    @Override
    public String getStatusTitle(Period period) {
        StringBuilder title = new StringBuilder();
        try {
            title.append(getStar().getMeasure(period).getEvaluation().getStatus().getTitle().trim());
        } catch (NullPointerException npe) {
        }
        return title.toString();
    }
    
    /**
     * Recupera el primer período de la lista de períodos asignados al
     * entregable.
     *
     * @return El período más anterior
     */
    @Override
    public Period getFirstPeriod() {
        List<Period> periods = sortValidPeriods();
        try {
            return periods.get(0);
        }catch(IndexOutOfBoundsException iobe) {
        }
        return null;
    }
    
    /**
     * Recupera el último período de la lista de períodos asignados al
     * entregable.
     *
     * @return El período más posterior
     */
    @Override
    public Period getLastPeriod() {
        List<Period> periods = sortValidPeriods(false);
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

    @Override
    public boolean isValid() {
        return super.isValid() && getInitiative().isValid();
    }
}
