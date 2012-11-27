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
package org.semanticwb.domotic.model.base;


public abstract class OnGroupChangeBase extends org.semanticwb.domotic.model.DomEvent implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty swb4d_groupStat=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/domotic#groupStat");
    public static final org.semanticwb.platform.SemanticClass swb4d_DomGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/domotic#DomGroup");
    public static final org.semanticwb.platform.SemanticProperty swb4d_domGroup4Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/domotic#domGroup4Event");
    public static final org.semanticwb.platform.SemanticClass swb4d_OnGroupChange=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/domotic#OnGroupChange");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/domotic#OnGroupChange");

    public static class ClassMgr
    {
       /**
       * Returns a list of OnGroupChange for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.domotic.model.OnGroupChange
       */

        public static java.util.Iterator<org.semanticwb.domotic.model.OnGroupChange> listOnGroupChanges(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.domotic.model.OnGroupChange>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.domotic.model.OnGroupChange for all models
       * @return Iterator of org.semanticwb.domotic.model.OnGroupChange
       */

        public static java.util.Iterator<org.semanticwb.domotic.model.OnGroupChange> listOnGroupChanges()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.domotic.model.OnGroupChange>(it, true);
        }

        public static org.semanticwb.domotic.model.OnGroupChange createOnGroupChange(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.domotic.model.OnGroupChange.ClassMgr.createOnGroupChange(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.domotic.model.OnGroupChange
       * @param id Identifier for org.semanticwb.domotic.model.OnGroupChange
       * @param model Model of the org.semanticwb.domotic.model.OnGroupChange
       * @return A org.semanticwb.domotic.model.OnGroupChange
       */
        public static org.semanticwb.domotic.model.OnGroupChange getOnGroupChange(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.domotic.model.OnGroupChange)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.domotic.model.OnGroupChange
       * @param id Identifier for org.semanticwb.domotic.model.OnGroupChange
       * @param model Model of the org.semanticwb.domotic.model.OnGroupChange
       * @return A org.semanticwb.domotic.model.OnGroupChange
       */
        public static org.semanticwb.domotic.model.OnGroupChange createOnGroupChange(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.domotic.model.OnGroupChange)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.domotic.model.OnGroupChange
       * @param id Identifier for org.semanticwb.domotic.model.OnGroupChange
       * @param model Model of the org.semanticwb.domotic.model.OnGroupChange
       */
        public static void removeOnGroupChange(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.domotic.model.OnGroupChange
       * @param id Identifier for org.semanticwb.domotic.model.OnGroupChange
       * @param model Model of the org.semanticwb.domotic.model.OnGroupChange
       * @return true if the org.semanticwb.domotic.model.OnGroupChange exists, false otherwise
       */

        public static boolean hasOnGroupChange(String id, org.semanticwb.model.SWBModel model)
        {
            return (getOnGroupChange(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.domotic.model.OnGroupChange with a determined DomGroup
       * @param value DomGroup of the type org.semanticwb.domotic.model.DomGroup
       * @param model Model of the org.semanticwb.domotic.model.OnGroupChange
       * @return Iterator with all the org.semanticwb.domotic.model.OnGroupChange
       */

        public static java.util.Iterator<org.semanticwb.domotic.model.OnGroupChange> listOnGroupChangeByDomGroup(org.semanticwb.domotic.model.DomGroup value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.domotic.model.OnGroupChange> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb4d_domGroup4Event, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.domotic.model.OnGroupChange with a determined DomGroup
       * @param value DomGroup of the type org.semanticwb.domotic.model.DomGroup
       * @return Iterator with all the org.semanticwb.domotic.model.OnGroupChange
       */

        public static java.util.Iterator<org.semanticwb.domotic.model.OnGroupChange> listOnGroupChangeByDomGroup(org.semanticwb.domotic.model.DomGroup value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.domotic.model.OnGroupChange> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb4d_domGroup4Event,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.domotic.model.OnGroupChange with a determined DomAction
       * @param value DomAction of the type org.semanticwb.domotic.model.DomAction
       * @param model Model of the org.semanticwb.domotic.model.OnGroupChange
       * @return Iterator with all the org.semanticwb.domotic.model.OnGroupChange
       */

        public static java.util.Iterator<org.semanticwb.domotic.model.OnGroupChange> listOnGroupChangeByDomAction(org.semanticwb.domotic.model.DomAction value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.domotic.model.OnGroupChange> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb4d_hasDomAction, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.domotic.model.OnGroupChange with a determined DomAction
       * @param value DomAction of the type org.semanticwb.domotic.model.DomAction
       * @return Iterator with all the org.semanticwb.domotic.model.OnGroupChange
       */

        public static java.util.Iterator<org.semanticwb.domotic.model.OnGroupChange> listOnGroupChangeByDomAction(org.semanticwb.domotic.model.DomAction value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.domotic.model.OnGroupChange> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb4d_hasDomAction,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.domotic.model.OnGroupChange with a determined DomContext
       * @param value DomContext of the type org.semanticwb.domotic.model.DomContext
       * @param model Model of the org.semanticwb.domotic.model.OnGroupChange
       * @return Iterator with all the org.semanticwb.domotic.model.OnGroupChange
       */

        public static java.util.Iterator<org.semanticwb.domotic.model.OnGroupChange> listOnGroupChangeByDomContext(org.semanticwb.domotic.model.DomContext value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.domotic.model.OnGroupChange> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb4d_domEventContext, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.domotic.model.OnGroupChange with a determined DomContext
       * @param value DomContext of the type org.semanticwb.domotic.model.DomContext
       * @return Iterator with all the org.semanticwb.domotic.model.OnGroupChange
       */

        public static java.util.Iterator<org.semanticwb.domotic.model.OnGroupChange> listOnGroupChangeByDomContext(org.semanticwb.domotic.model.DomContext value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.domotic.model.OnGroupChange> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb4d_domEventContext,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static OnGroupChangeBase.ClassMgr getOnGroupChangeClassMgr()
    {
        return new OnGroupChangeBase.ClassMgr();
    }

   /**
   * Constructs a OnGroupChangeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the OnGroupChange
   */
    public OnGroupChangeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the GroupStat property
* @return String with the GroupStat
*/
    public String getGroupStat()
    {
        return getSemanticObject().getProperty(swb4d_groupStat);
    }

/**
* Sets the GroupStat property
* @param value long with the GroupStat
*/
    public void setGroupStat(String value)
    {
        getSemanticObject().setProperty(swb4d_groupStat, value);
    }
   /**
   * Sets the value for the property DomGroup
   * @param value DomGroup to set
   */

    public void setDomGroup(org.semanticwb.domotic.model.DomGroup value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb4d_domGroup4Event, value.getSemanticObject());
        }else
        {
            removeDomGroup();
        }
    }
   /**
   * Remove the value for DomGroup property
   */

    public void removeDomGroup()
    {
        getSemanticObject().removeProperty(swb4d_domGroup4Event);
    }

   /**
   * Gets the DomGroup
   * @return a org.semanticwb.domotic.model.DomGroup
   */
    public org.semanticwb.domotic.model.DomGroup getDomGroup()
    {
         org.semanticwb.domotic.model.DomGroup ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb4d_domGroup4Event);
         if(obj!=null)
         {
             ret=(org.semanticwb.domotic.model.DomGroup)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the DomiticSite
   * @return a instance of org.semanticwb.domotic.model.DomiticSite
   */
    public org.semanticwb.domotic.model.DomiticSite getDomiticSite()
    {
        return (org.semanticwb.domotic.model.DomiticSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
