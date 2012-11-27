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
package org.semanticwb.process.schema.base;


public abstract class FloatBase extends org.semanticwb.process.model.DataTypes 
{
    public static final org.semanticwb.platform.SemanticProperty swps_floatValue=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/process/schema#floatValue");
    public static final org.semanticwb.platform.SemanticClass swps_Float=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process/schema#Float");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process/schema#Float");

    public static class ClassMgr
    {
       /**
       * Returns a list of Float for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.schema.Float
       */

        public static java.util.Iterator<org.semanticwb.process.schema.Float> listFloats(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.schema.Float>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.schema.Float for all models
       * @return Iterator of org.semanticwb.process.schema.Float
       */

        public static java.util.Iterator<org.semanticwb.process.schema.Float> listFloats()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.schema.Float>(it, true);
        }
       /**
       * Gets a org.semanticwb.process.schema.Float
       * @param id Identifier for org.semanticwb.process.schema.Float
       * @param model Model of the org.semanticwb.process.schema.Float
       * @return A org.semanticwb.process.schema.Float
       */
        public static org.semanticwb.process.schema.Float getFloat(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.schema.Float)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.schema.Float
       * @param id Identifier for org.semanticwb.process.schema.Float
       * @param model Model of the org.semanticwb.process.schema.Float
       * @return A org.semanticwb.process.schema.Float
       */
        public static org.semanticwb.process.schema.Float createFloat(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.schema.Float)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.schema.Float
       * @param id Identifier for org.semanticwb.process.schema.Float
       * @param model Model of the org.semanticwb.process.schema.Float
       */
        public static void removeFloat(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.schema.Float
       * @param id Identifier for org.semanticwb.process.schema.Float
       * @param model Model of the org.semanticwb.process.schema.Float
       * @return true if the org.semanticwb.process.schema.Float exists, false otherwise
       */

        public static boolean hasFloat(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFloat(id, model)!=null);
        }
    }

    public static FloatBase.ClassMgr getFloatClassMgr()
    {
        return new FloatBase.ClassMgr();
    }

   /**
   * Constructs a FloatBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Float
   */
    public FloatBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Value property
* @return float with the Value
*/
    public float getValue()
    {
        return getSemanticObject().getFloatProperty(swps_floatValue);
    }

/**
* Sets the Value property
* @param value long with the Value
*/
    public void setValue(float value)
    {
        getSemanticObject().setFloatProperty(swps_floatValue, value);
    }
}
