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
package org.semanticwb.process.model.base;


public abstract class ThrowEventBase extends org.semanticwb.process.model.Event implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass swp_ThrowEvent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#ThrowEvent");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#ThrowEvent");

    public static class ClassMgr
    {
       /**
       * Returns a list of ThrowEvent for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEvents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.model.ThrowEvent for all models
       * @return Iterator of org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEvents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent>(it, true);
        }
       /**
       * Gets a org.semanticwb.process.model.ThrowEvent
       * @param id Identifier for org.semanticwb.process.model.ThrowEvent
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return A org.semanticwb.process.model.ThrowEvent
       */
        public static org.semanticwb.process.model.ThrowEvent getThrowEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.ThrowEvent)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.model.ThrowEvent
       * @param id Identifier for org.semanticwb.process.model.ThrowEvent
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return A org.semanticwb.process.model.ThrowEvent
       */
        public static org.semanticwb.process.model.ThrowEvent createThrowEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.ThrowEvent)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.model.ThrowEvent
       * @param id Identifier for org.semanticwb.process.model.ThrowEvent
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       */
        public static void removeThrowEvent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.model.ThrowEvent
       * @param id Identifier for org.semanticwb.process.model.ThrowEvent
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return true if the org.semanticwb.process.model.ThrowEvent exists, false otherwise
       */

        public static boolean hasThrowEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getThrowEvent(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByChild(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByChild(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByParent(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_parent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByParent(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_parent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByContainer(org.semanticwb.process.model.Containerable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_container, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByContainer(org.semanticwb.process.model.Containerable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_container,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined FlowObjectInstance
       * @param value FlowObjectInstance of the type org.semanticwb.process.model.FlowNodeInstance
       * @param model Model of the org.semanticwb.process.model.ThrowEvent
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByFlowObjectInstance(org.semanticwb.process.model.FlowNodeInstance value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasFlowNodeInstanceInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.ThrowEvent with a determined FlowObjectInstance
       * @param value FlowObjectInstance of the type org.semanticwb.process.model.FlowNodeInstance
       * @return Iterator with all the org.semanticwb.process.model.ThrowEvent
       */

        public static java.util.Iterator<org.semanticwb.process.model.ThrowEvent> listThrowEventByFlowObjectInstance(org.semanticwb.process.model.FlowNodeInstance value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ThrowEvent> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasFlowNodeInstanceInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ThrowEventBase.ClassMgr getThrowEventClassMgr()
    {
        return new ThrowEventBase.ClassMgr();
    }

   /**
   * Constructs a ThrowEventBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ThrowEvent
   */
    public ThrowEventBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
