/**  
 * SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
 * colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
 * información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
 * fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
 * procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
 * para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
 *
 * INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
 * en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
 * aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
 * del SemanticWebBuilder 4.0.
 *
 * INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
 * siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
 * dirección electrónica:
 *  http://www.semanticwebbuilder.org
 **/
package org.semanticwb.model.base;


// TODO: Auto-generated Javadoc
/**
 * The Class TextAreaBase.
 */
public abstract class TextAreaBase extends org.semanticwb.model.base.FormElementBase 
{
    
    /** The Constant swbxf_textAreaRows. */
    public static final org.semanticwb.platform.SemanticProperty swbxf_textAreaRows=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#textAreaRows");
    
    /** The Constant swbxf_textAreaCols. */
    public static final org.semanticwb.platform.SemanticProperty swbxf_textAreaCols=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#textAreaCols");
    
    /** The Constant swbxf_TextArea. */
    public static final org.semanticwb.platform.SemanticClass swbxf_TextArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#TextArea");
    
    /** The Constant sclass. */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#TextArea");

    /**
     * The Class ClassMgr.
     */
    public static class ClassMgr
    {

        /**
         * List text areas.
         * 
         * @param model the model
         * @return the java.util. iterator
         */
        public static java.util.Iterator<org.semanticwb.model.TextArea> listTextAreas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.TextArea>(it, true);
        }

        /**
         * List text areas.
         * 
         * @return the java.util. iterator
         */
        public static java.util.Iterator<org.semanticwb.model.TextArea> listTextAreas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.TextArea>(it, true);
        }

        /**
         * Gets the text area.
         * 
         * @param id the id
         * @param model the model
         * @return the text area
         */
        public static org.semanticwb.model.TextArea getTextArea(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.TextArea)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        /**
         * Creates the text area.
         * 
         * @param id the id
         * @param model the model
         * @return the org.semanticwb.model. text area
         */
        public static org.semanticwb.model.TextArea createTextArea(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.TextArea)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        /**
         * Removes the text area.
         * 
         * @param id the id
         * @param model the model
         */
        public static void removeTextArea(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        /**
         * Checks for text area.
         * 
         * @param id the id
         * @param model the model
         * @return true, if successful
         */
        public static boolean hasTextArea(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTextArea(id, model)!=null);
        }
    }

    /**
     * Instantiates a new text area base.
     * 
     * @param base the base
     */
    public TextAreaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /**
     * Gets the rows.
     * 
     * @return the rows
     */
    public int getRows()
    {
        return getSemanticObject().getIntProperty(swbxf_textAreaRows);
    }

    /**
     * Sets the rows.
     * 
     * @param value the new rows
     */
    public void setRows(int value)
    {
        getSemanticObject().setIntProperty(swbxf_textAreaRows, value);
    }

    /**
     * Gets the cols.
     * 
     * @return the cols
     */
    public int getCols()
    {
        return getSemanticObject().getIntProperty(swbxf_textAreaCols);
    }

    /**
     * Sets the cols.
     * 
     * @param value the new cols
     */
    public void setCols(int value)
    {
        getSemanticObject().setIntProperty(swbxf_textAreaCols, value);
    }

    /**
     * Removes the.
     */
    public void remove()
    {
        getSemanticObject().remove();
    }

    /**
     * List related objects.
     * 
     * @return the java.util. iterator
     */
    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
