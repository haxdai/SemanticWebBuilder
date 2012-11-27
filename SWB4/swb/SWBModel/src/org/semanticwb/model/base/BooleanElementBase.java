/*
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
 */
package org.semanticwb.model.base;


   /**
   * Elemento para valores booleanos configurable como CheckBox, Radio y Select 
   */
public abstract class BooleanElementBase extends org.semanticwb.model.base.FormElementBase 
{
    public static final org.semanticwb.platform.SemanticProperty swbxf_booleanTrueTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#booleanTrueTitle");
   /**
   * Tipo de despliegue del elemento ("checkbox","radio","select")
   */
    public static final org.semanticwb.platform.SemanticProperty swbxf_booleanDisplayType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#booleanDisplayType");
    public static final org.semanticwb.platform.SemanticProperty swbxf_booleanDisplayFalseTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/xforms/ontology#booleanDisplayFalseTitle");
   /**
   * Elemento para valores booleanos configurable como CheckBox, Radio y Select
   */
    public static final org.semanticwb.platform.SemanticClass swbxf_BooleanElement=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#BooleanElement");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/xforms/ontology#BooleanElement");

    public static class ClassMgr
    {
       /**
       * Returns a list of BooleanElement for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.model.BooleanElement
       */

        public static java.util.Iterator<org.semanticwb.model.BooleanElement> listBooleanElements(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.BooleanElement>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.model.BooleanElement for all models
       * @return Iterator of org.semanticwb.model.BooleanElement
       */

        public static java.util.Iterator<org.semanticwb.model.BooleanElement> listBooleanElements()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.model.BooleanElement>(it, true);
        }
       /**
       * Gets a org.semanticwb.model.BooleanElement
       * @param id Identifier for org.semanticwb.model.BooleanElement
       * @param model Model of the org.semanticwb.model.BooleanElement
       * @return A org.semanticwb.model.BooleanElement
       */
        public static org.semanticwb.model.BooleanElement getBooleanElement(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.BooleanElement)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.model.BooleanElement
       * @param id Identifier for org.semanticwb.model.BooleanElement
       * @param model Model of the org.semanticwb.model.BooleanElement
       * @return A org.semanticwb.model.BooleanElement
       */
        public static org.semanticwb.model.BooleanElement createBooleanElement(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.model.BooleanElement)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.model.BooleanElement
       * @param id Identifier for org.semanticwb.model.BooleanElement
       * @param model Model of the org.semanticwb.model.BooleanElement
       */
        public static void removeBooleanElement(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.model.BooleanElement
       * @param id Identifier for org.semanticwb.model.BooleanElement
       * @param model Model of the org.semanticwb.model.BooleanElement
       * @return true if the org.semanticwb.model.BooleanElement exists, false otherwise
       */

        public static boolean hasBooleanElement(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBooleanElement(id, model)!=null);
        }
    }

    public static BooleanElementBase.ClassMgr getBooleanElementClassMgr()
    {
        return new BooleanElementBase.ClassMgr();
    }

   /**
   * Constructs a BooleanElementBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BooleanElement
   */
    public BooleanElementBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the TrueTitle property
* @return String with the TrueTitle
*/
    public String getTrueTitle()
    {
        return getSemanticObject().getProperty(swbxf_booleanTrueTitle);
    }

/**
* Sets the TrueTitle property
* @param value long with the TrueTitle
*/
    public void setTrueTitle(String value)
    {
        getSemanticObject().setProperty(swbxf_booleanTrueTitle, value);
    }

    public String getTrueTitle(String lang)
    {
        return getSemanticObject().getProperty(swbxf_booleanTrueTitle, null, lang);
    }

    public String getDisplayTrueTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swbxf_booleanTrueTitle, lang);
    }

    public void setTrueTitle(String booleanTrueTitle, String lang)
    {
        getSemanticObject().setProperty(swbxf_booleanTrueTitle, booleanTrueTitle, lang);
    }

/**
* Gets the DisplayType property
* @return String with the DisplayType
*/
    public String getDisplayType()
    {
        return getSemanticObject().getProperty(swbxf_booleanDisplayType);
    }

/**
* Sets the DisplayType property
* @param value long with the DisplayType
*/
    public void setDisplayType(String value)
    {
        getSemanticObject().setProperty(swbxf_booleanDisplayType, value);
    }

/**
* Gets the FalseTitle property
* @return String with the FalseTitle
*/
    public String getFalseTitle()
    {
        return getSemanticObject().getProperty(swbxf_booleanDisplayFalseTitle);
    }

/**
* Sets the FalseTitle property
* @param value long with the FalseTitle
*/
    public void setFalseTitle(String value)
    {
        getSemanticObject().setProperty(swbxf_booleanDisplayFalseTitle, value);
    }

    public String getFalseTitle(String lang)
    {
        return getSemanticObject().getProperty(swbxf_booleanDisplayFalseTitle, null, lang);
    }

    public String getDisplayFalseTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swbxf_booleanDisplayFalseTitle, lang);
    }

    public void setFalseTitle(String booleanDisplayFalseTitle, String lang)
    {
        getSemanticObject().setProperty(swbxf_booleanDisplayFalseTitle, booleanDisplayFalseTitle, lang);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
