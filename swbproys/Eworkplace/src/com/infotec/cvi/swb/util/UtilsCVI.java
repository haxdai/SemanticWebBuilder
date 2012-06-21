/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.util;

import com.infotec.cvi.swb.Academia;
import com.infotec.cvi.swb.CV;
import java.text.DecimalFormat;

/**
 * Utilerias para la operacion del modulo CVI
 *
 * @author juan.fernandez
 */
public class UtilsCVI {
    
    
    /**
         * Verifica si el CV esta completo; es decir, si está al 100%<br>
         * 
         * @param cv a Curriculum Vitae a verificar si está completo
         * @return un booleano indicando true si está completo o false si está incompleto
         */
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
    
    /**
         * Verifica el porcentaje de avance del CV<br>
         * 
         * @param cv a Curriculum Vitae a verificar avance
         * @return un String indicando el porcentaje de avance
         */
    public static String getCVIProgress(CV cv){
        
        Academia aca = cv.getAcademia();
        DecimalFormat df = new DecimalFormat("###");
        
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
        
        
        
        return df.format(100*progress)+"%";
    }
    
    /**
         * Replaces accented characters and blank spaces in the string given.
         * Makes the changes in a case sensitive manner, the following are some examples
         * of the changes this method makes: <br>
         * 
         * @param txt a string in which the characters are going to be replaced
         * @param replaceSpaces a {@code boolean} indicating if blank spaces are going to be replaced or not
         * @return a string similar to {@code txt} but with neither accented or
         * special characters nor symbols in it. un objeto string similar
         * a {@code txt} pero sin caracteres acentuados o especiales y sin s&iacute;mbolos
         * {@literal Á} is replaced by {@literal A} <br>
         * {@literal Ê} is replaced by {@literal E} <br>
         * {@literal Ï} is replaced by {@literal I} <br>
         * {@literal â} is replaced by {@literal a} <br>
         * {@literal ç} is replaced by {@literal c} <br>
         * {@literal ñ} is replaced by {@literal n} <br>
         * and blank spaces are replaced by underscore characters. 
         * <p>Reemplaza caracteres acentuados y espacios en blanco en {@code txt}.
         * Realiza los cambios respetando caracteres en may&uacute;sculas o min&uacute;sculas
         * los caracteres en blanco son reemplazados por guiones bajos, cualquier s&iacute;mbolo
         * diferente a gui&oacute;n bajo es eliminado.</p>
         */
        public static String replaceSpecialCharacters(String txt, boolean replaceSpaces)
        {
            StringBuffer ret = new StringBuffer();
            String aux = txt;
            //aux = aux.toLowerCase();
            aux = aux.replace('Á', 'A');
            aux = aux.replace('Ä', 'A');
            aux = aux.replace('Å', 'A');
            aux = aux.replace('Â', 'A');
            aux = aux.replace('À', 'A');
            aux = aux.replace('Ã', 'A');

            aux = aux.replace('É', 'E');
            aux = aux.replace('Ê', 'E');
            aux = aux.replace('È', 'E');
            aux = aux.replace('Ë', 'E');

            aux = aux.replace('Í', 'I');
            aux = aux.replace('Î', 'I');
            aux = aux.replace('Ï', 'I');
            aux = aux.replace('Ì', 'I');

            aux = aux.replace('Ó', 'O');
            aux = aux.replace('Ö', 'O');
            aux = aux.replace('Ô', 'O');
            aux = aux.replace('Ò', 'O');
            aux = aux.replace('Õ', 'O');

            aux = aux.replace('Ú', 'U');
            aux = aux.replace('Ü', 'U');
            aux = aux.replace('Û', 'U');
            aux = aux.replace('Ù', 'U');

            aux = aux.replace('Ñ', 'N');

            aux = aux.replace('Ç', 'C');
            aux = aux.replace('Ý', 'Y');

            aux = aux.replace('á', 'a');
            aux = aux.replace('à', 'a');
            aux = aux.replace('ã', 'a');
            aux = aux.replace('â', 'a');
            aux = aux.replace('ä', 'a');
            aux = aux.replace('å', 'a');

            aux = aux.replace('é', 'e');
            aux = aux.replace('è', 'e');
            aux = aux.replace('ê', 'e');
            aux = aux.replace('ë', 'e');

            aux = aux.replace('í', 'i');
            aux = aux.replace('ì', 'i');
            aux = aux.replace('î', 'i');
            aux = aux.replace('ï', 'i');

            aux = aux.replace('ó', 'o');
            aux = aux.replace('ò', 'o');
            aux = aux.replace('ô', 'o');
            aux = aux.replace('ö', 'o');
            aux = aux.replace('õ', 'o');

            aux = aux.replace('ú', 'u');
            aux = aux.replace('ù', 'u');
            aux = aux.replace('ü', 'u');
            aux = aux.replace('û', 'u');

            aux = aux.replace('ñ', 'n');

            aux = aux.replace('ç', 'c');
            aux = aux.replace('ÿ', 'y');
            aux = aux.replace('ý', 'y');

            if (replaceSpaces)
            {
                aux = aux.replace(' ', '_');
            }
            int l = aux.length();
            for (int x = 0; x < l; x++)
            {
                char ch = aux.charAt(x);
//                if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')
//                        || (ch >= 'A' && ch <= 'Z') || ch == '_')
                {
                    ret.append(ch);
                }
            }
            aux = ret.toString();
            return aux;
        }
    
}
