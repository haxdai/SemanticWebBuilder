package org.semanticwb.bsc.formelement;

import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.Sortable;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

/**
 * OrdinalCategorical es un FormElement para manejar valores ordinales que no
 * se repiten para instancias de una clase que comparten la misma instancia de
 * la super clase inmediata.
 * 
 * Se usa principalmente para elementos que implementan la interface StateMachinable
 * 
 * @author      Carlos Ramos Incháustegui
 * @version     %I%, %G%
 * @since       1.0
 */
public class OrdinalCategorical extends org.semanticwb.bsc.formelement.base.OrdinalCategoricalBase 
{
    private static final Logger log = SWBUtils.getLogger(OrdinalCategorical.class);
    
    public OrdinalCategorical(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    @Override
    public void validate(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName) throws FormValidateException
    {
        org.semanticwb.bsc.Sortable sortable = (Sortable) obj.getGenericInstance();
        sortable.validOrder(request, prop, propName);
    }
}
