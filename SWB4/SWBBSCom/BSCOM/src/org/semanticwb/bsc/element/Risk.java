package org.semanticwb.bsc.element;

import java.util.Calendar;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;
import org.semanticwb.bsc.tracing.Control;
import org.semanticwb.bsc.tracing.Factor;
import org.semanticwb.platform.SemanticObject;

public class Risk extends org.semanticwb.bsc.element.base.RiskBase {

    public Risk(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    /**
     * Obtiene el prefijo en base al a&ntilde;o actual seguido de un n&uacute;mero consecutivo. 
     * @return el objeto String que representa el prefijo para un Riesgo
     */
    @Override
    public String getPrefix() {
        String prefix = super.getPrefix();
        if(prefix == null) {
            final int y = Calendar.getInstance().get(Calendar.YEAR);
            prefix = y+"_"+getConsecutive();
            setPrefix(prefix);
            setYearRisk(y);
        }
        return prefix;
    }
    
    /**
     * Almacena el prefijo del Riesgo actual.
     * @param value el objeto String que representa el prefijo de un Riesgo
     */
    @Override
    public void setPrefix(String value) {
        super.setPrefix(value);
    }

    /**
     * Obtiene el siguiente prefijo consecutivo para un Riesgo.
     * @return el objeto String que representa el siguiente prefijo para un Riesgo
     */
    private synchronized int getConsecutive() {
        int consecutive = 0;
        SortedSet<Integer> map = new TreeSet<Integer>();
        Iterator<SemanticObject> it = getBSC().getSemanticModel().listSubjects(Risk.bsc_yearRisk, Calendar.getInstance().get(Calendar.YEAR));
        while (it.hasNext()) {
            SemanticObject obj = it.next();
            String prefix = obj.getProperty(Risk.bsc_prefix, false);
            if(prefix != null && prefix.lastIndexOf("_") > -1) {
                prefix = prefix.substring(prefix.lastIndexOf("_") + 1);
                int serial = Integer.parseInt(prefix);
                map.add(serial);
            }
        }
        //Collections.sort(map);
        try {
            consecutive = map.last();  //map.get(map.size() - 1;
        }catch(NoSuchElementException nse) {
            consecutive = 0;
        }finally {
            consecutive++;
        }
        return consecutive;
    }
    
    /**
     * Calcula el cuadrante del mapa de riesgos en que aparecer&aacute; el riesgo en base a los valores del nivel de impacto
     * y la probabilidad, tanto para la evaluaci&oacute;n inicial como para la final
     * @param initial indica si el cuadrante a calcular es de la evaluaci&oacute;n inicial {@code true}, o de la final {@code false}
     * @return el n&uacute;mero del cuadrante en el mapa de riesgos en que aparecer&aacute; este riesgo
     */
    public synchronized short calculateQuadrant(boolean initial) {
        
        short quadrant = 0;
        if (initial) {
            if (this.getIniAssessmentImpactLevel() > 5 && this.getIniAssessmentLikelihood() > 5) {
                quadrant = 1;
            } else if (this.getIniAssessmentImpactLevel() <= 5 && this.getIniAssessmentLikelihood() > 5) {
                quadrant = 2;
            } else if (this.getIniAssessmentImpactLevel() > 5 && this.getIniAssessmentLikelihood() <= 5) {
                quadrant = 3;
            } else if (this.getIniAssessmentImpactLevel() <= 5 && this.getIniAssessmentLikelihood() <= 5) {
                quadrant = 4;
            }
        } else {
            
        }
        return quadrant;
    }
    
    /**
     * Calcula si el riesgo es controlado suficientemente en base a la determinaci&oacute;n de todos los controles relacionados.
     * @return {@literal SI} en caso de que la determinaci&oacute;n de todos los controles relacionados sea suficiente, {@literal NO} en caso contrario
     */
    public synchronized String calculateControled() {
        
        String controled = "SI";
        
        Iterator<Factor> factorIt = this.listFactors();
        while (factorIt != null && factorIt.hasNext()) {
            Factor factor = factorIt.next();
            Iterator<Control> controlIt = factor.listControls();
            if (controlIt != null && controlIt.hasNext()) {
                while (controlIt.hasNext()) {
                    Control control = controlIt.next();
                    if (control.getDeterminingControl().equalsIgnoreCase("no")) {
                        controled = "NO";
                        break;
                    }
                }
            } else {
                controled = "NO";
                break;
            }
        }
        
        return controled;
    }
}
