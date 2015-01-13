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
