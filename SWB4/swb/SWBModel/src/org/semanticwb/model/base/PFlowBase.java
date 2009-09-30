package org.semanticwb.model.base;


public class PFlowBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Trashable,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.XMLable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass swb_PFlowRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#PFlowRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasPFlowRefInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasPFlowRefInv");
    public static final org.semanticwb.platform.SemanticClass swb_PFlowInstance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#PFlowInstance");
    public static final org.semanticwb.platform.SemanticProperty swb_hasPFlowInstance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasPFlowInstance");
    public static final org.semanticwb.platform.SemanticClass swb_PFlow=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#PFlow");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#PFlow");

    public PFlowBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlows(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlows()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow>(it, true);
    }

    public static org.semanticwb.model.PFlow createPFlow(org.semanticwb.model.SWBModel model)
    {
        long id=model.getSemanticObject().getModel().getCounter(sclass);
        return org.semanticwb.model.PFlow.createPFlow(String.valueOf(id), model);
    }

    public static org.semanticwb.model.PFlow getPFlow(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.PFlow)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.PFlow createPFlow(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.PFlow)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removePFlow(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasPFlow(String id, org.semanticwb.model.SWBModel model)
    {
        return (getPFlow(id, model)!=null);
    }

    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
    }

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlowByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlowByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

    public String getXml()
    {
        return getSemanticObject().getProperty(swb_xml);
    }

    public void setXml(String value)
    {
        getSemanticObject().setProperty(swb_xml, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlowRef> listPFlowRefInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlowRef>(getSemanticObject().listObjectProperties(swb_hasPFlowRefInv));
    }

    public boolean hasPFlowRefInv(org.semanticwb.model.PFlowRef pflowref)
    {
        if(pflowref==null)return false;
        return getSemanticObject().hasObjectProperty(swb_hasPFlowRefInv,pflowref.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlowByPFlowRefInv(org.semanticwb.model.PFlowRef haspflowrefinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasPFlowRefInv, haspflowrefinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlowByPFlowRefInv(org.semanticwb.model.PFlowRef haspflowrefinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow> it=new org.semanticwb.model.GenericIterator(haspflowrefinv.getSemanticObject().getModel().listSubjects(swb_hasPFlowRefInv,haspflowrefinv.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.PFlowRef getPFlowRefInv()
    {
         org.semanticwb.model.PFlowRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasPFlowRefInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.PFlowRef)obj.createGenericInstance();
         }
         return ret;
    }

    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_active, value);
    }

    public boolean isDeleted()
    {
        return getSemanticObject().getBooleanProperty(swb_deleted);
    }

    public void setDeleted(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_deleted, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlowInstance> listPFlowInstances()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlowInstance>(getSemanticObject().listObjectProperties(swb_hasPFlowInstance));
    }

    public boolean hasPFlowInstance(org.semanticwb.model.PFlowInstance pflowinstance)
    {
        if(pflowinstance==null)return false;
        return getSemanticObject().hasObjectProperty(swb_hasPFlowInstance,pflowinstance.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlowByPFlowInstance(org.semanticwb.model.PFlowInstance haspflowinstance,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasPFlowInstance, haspflowinstance.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlowByPFlowInstance(org.semanticwb.model.PFlowInstance haspflowinstance)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow> it=new org.semanticwb.model.GenericIterator(haspflowinstance.getSemanticObject().getModel().listSubjects(swb_hasPFlowInstance,haspflowinstance.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.PFlowInstance getPFlowInstance()
    {
         org.semanticwb.model.PFlowInstance ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasPFlowInstance);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.PFlowInstance)obj.createGenericInstance();
         }
         return ret;
    }

    public void setCreator(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
    }

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlowByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.PFlow> listPFlowByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlow> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }

    public org.semanticwb.model.WebSite getWebSite()
    {
        return (org.semanticwb.model.WebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
