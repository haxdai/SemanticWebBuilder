/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.util;

import com.infotec.cvi.swb.Academia;
import com.infotec.cvi.swb.CV;

/**
 *
 * @author juan.fernandez
 */
public class UtilsCVI {
    
    public static boolean isCVIDone(CV cv){
        
        Academia aca = cv.getAcademia();
        boolean done = Boolean.FALSE;
        
        float progress = 0;
        boolean doneSchooling = aca!=null&&(aca.listGradoAcademicos().hasNext()&&(aca.isNoAplicaEstudioSuperior() || aca.listEstudioSuperiors().hasNext())&&(cv.isSinDiplomado() || cv.listDiplomados().hasNext())&&(cv.isSinCurso() || cv.listCursosTICs().hasNext())&&(cv.isSinIdioma() || cv.listIdiomas().hasNext()));
        if(doneSchooling)
            progress+=0.25;
        boolean doneExperience = (cv.isSinExperiencia() || cv.listExperienciaLaborals().hasNext())&&cv.listAreaTalentos().hasNext()&&(cv.isSinDistincion() || cv.listDistincions().hasNext());
        if(doneExperience)
            progress+=0.25;
        boolean doneCompetencies = cv.listCompetencias().hasNext();
        if(doneCompetencies)
            progress+=0.25;
        boolean doneResearchAndTeaching = (cv.isSinInvestigacion() || cv.listInvestigacions().hasNext())&&(cv.isSinDocencia() || cv.listDocencias().hasNext())&&(cv.isSinPublicacion() || cv.listPublicacions().hasNext());
        if(doneResearchAndTeaching)
            progress+=0.25;
        if(progress==1.0) done=Boolean.TRUE;
        
        return done;
    }
    
}
