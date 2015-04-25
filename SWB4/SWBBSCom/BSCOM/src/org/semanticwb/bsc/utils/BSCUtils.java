/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.bsc.utils;

import java.math.BigDecimal;
import org.semanticwb.SWBPlatform;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticProperty;

/**
 *
 * @author carlos.ramos
 */
public class BSCUtils {
    public static final SemanticProperty bsc_usrInitials = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#usrInitials");
    
    public static final String[] ColorPalette = {
        "#f44336", "#673ab7", "#03a9f4", "#4caf50", "#ffc107",
        "#e91e63", "#3f51b5", "#00bcd4", "#8bc34a", "#ff9800",
        "#9c27b0", "#2196f3", "#009688", "#cddc39", "#ff5722",
        "#d50000", "#311b92", "#01579b", "#1b5e20", "#ffab00",
        "#880e4f", "#1a237e", "#006064", "#33691e", "#ff6f00",
        "#aa00ff", "#0d47a1", "#004d40", "#827717", "#795548"
    };
    
    public static class Formats {
        public static BigDecimal round(float d, int decimalPlace) {
            BigDecimal bd = new BigDecimal(Float.toString(d));
            bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
            return bd;
        }
    }
    
    public static class BSCUser {
        public static String getInitials(final User user) {
            return user.getSemanticObject().getProperty(bsc_usrInitials);
        }
        
        public static String getInitials(final User user, final String defValue) {
            return user.getSemanticObject().getProperty(bsc_usrInitials, defValue);
        }
    }
}
