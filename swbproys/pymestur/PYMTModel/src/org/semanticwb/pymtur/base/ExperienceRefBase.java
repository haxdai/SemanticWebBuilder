package org.semanticwb.pymtur.base;


public abstract class ExperienceRefBase extends org.semanticwb.model.SWBClass 
{
       public static final org.semanticwb.platform.SemanticClass pymtur_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Experience");
       public static final org.semanticwb.platform.SemanticProperty pymtur_expRefExperience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#expRefExperience");
       public static final org.semanticwb.platform.SemanticProperty pymtur_expRefPriority=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#expRefPriority");
       public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
       public static final org.semanticwb.platform.SemanticProperty pymtur_experienceRefInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#experienceRefInv");
       public static final org.semanticwb.platform.SemanticClass pymtur_ExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ExperienceRef");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ExperienceRef");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.pymtur.ExperienceRef> listExperienceRefs(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ExperienceRef>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.pymtur.ExperienceRef> listExperienceRefs()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ExperienceRef>(it, true);
       }

       public static org.semanticwb.pymtur.ExperienceRef getExperienceRef(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.ExperienceRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.pymtur.ExperienceRef createExperienceRef(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.ExperienceRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeExperienceRef(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasExperienceRef(String id, org.semanticwb.model.SWBModel model)
       {
           return (getExperienceRef(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.pymtur.ExperienceRef> listExperienceRefByExpRefExperience(org.semanticwb.pymtur.Experience exprefexperience,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_expRefExperience, exprefexperience.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ExperienceRef> listExperienceRefByExpRefExperience(org.semanticwb.pymtur.Experience exprefexperience)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ExperienceRef> it=new org.semanticwb.model.GenericIterator(exprefexperience.getSemanticObject().getModel().listSubjects(pymtur_expRefExperience,exprefexperience.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ExperienceRef> listExperienceRefByExperienceRefInv(org.semanticwb.pymtur.ServiceProvider experiencerefinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_experienceRefInv, experiencerefinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ExperienceRef> listExperienceRefByExperienceRefInv(org.semanticwb.pymtur.ServiceProvider experiencerefinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ExperienceRef> it=new org.semanticwb.model.GenericIterator(experiencerefinv.getSemanticObject().getModel().listSubjects(pymtur_experienceRefInv,experiencerefinv.getSemanticObject()));
       return it;
   }
    }

    public ExperienceRefBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setExpRefExperience(org.semanticwb.pymtur.Experience value)
    {
        getSemanticObject().setObjectProperty(pymtur_expRefExperience, value.getSemanticObject());
    }

    public void removeExpRefExperience()
    {
        getSemanticObject().removeProperty(pymtur_expRefExperience);
    }


    public org.semanticwb.pymtur.Experience getExpRefExperience()
    {
         org.semanticwb.pymtur.Experience ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_expRefExperience);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Experience)obj.createGenericInstance();
         }
         return ret;
    }

    public int getExpRefPriority()
    {
        return getSemanticObject().getIntProperty(pymtur_expRefPriority);
    }

    public void setExpRefPriority(int value)
    {
        getSemanticObject().setIntProperty(pymtur_expRefPriority, value);
    }

    public void setExperienceRefInv(org.semanticwb.pymtur.ServiceProvider value)
    {
        getSemanticObject().setObjectProperty(pymtur_experienceRefInv, value.getSemanticObject());
    }

    public void removeExperienceRefInv()
    {
        getSemanticObject().removeProperty(pymtur_experienceRefInv);
    }


    public org.semanticwb.pymtur.ServiceProvider getExperienceRefInv()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_experienceRefInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
