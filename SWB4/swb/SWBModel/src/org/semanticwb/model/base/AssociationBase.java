package org.semanticwb.model.base;


public class AssociationBase extends org.semanticwb.model.SWBClass 
{
    public static class ClassMgr
    {
       public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
       public static final org.semanticwb.platform.SemanticClass swb_AssMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#AssMember");
       public static final org.semanticwb.platform.SemanticProperty swb_hasMember=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasMember");
       public static final org.semanticwb.platform.SemanticClass swb_Topic=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Topic");
       public static final org.semanticwb.platform.SemanticProperty swb_assType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#assType");
       public static final org.semanticwb.platform.SemanticClass swb_Association=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Association");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Association");

       public static java.util.Iterator<org.semanticwb.model.Association> listAssociations(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Association>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.model.Association> listAssociations()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Association>(it, true);
       }

       public static org.semanticwb.model.Association createAssociation(org.semanticwb.model.SWBModel model)
       {
           long id=model.getSemanticObject().getModel().getCounter(sclass);
           return org.semanticwb.model.Association.ClassMgr.createAssociation(String.valueOf(id), model);
       }

       public static org.semanticwb.model.Association getAssociation(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.model.Association)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.model.Association createAssociation(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.model.Association)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeAssociation(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasAssociation(String id, org.semanticwb.model.SWBModel model)
       {
           return (getAssociation(id, model)!=null);
       }
    }

    public AssociationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.AssMember> listMembers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.AssMember>(getSemanticObject().listObjectProperties(ClassMgr.swb_hasMember));
    }

    public boolean hasMember(org.semanticwb.model.AssMember assmember)
    {
        if(assmember==null)return false;
        return getSemanticObject().hasObjectProperty(ClassMgr.swb_hasMember,assmember.getSemanticObject());
    }

    public void addMember(org.semanticwb.model.AssMember value)
    {
        getSemanticObject().addObjectProperty(ClassMgr.swb_hasMember, value.getSemanticObject());
    }

    public void removeAllMember()
    {
        getSemanticObject().removeProperty(ClassMgr.swb_hasMember);
    }

    public void removeMember(org.semanticwb.model.AssMember assmember)
    {
        getSemanticObject().removeObjectProperty(ClassMgr.swb_hasMember,assmember.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.model.Association> listAssociationByMember(org.semanticwb.model.AssMember hasmember,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Association> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(ClassMgr.swb_hasMember, hasmember.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.Association> listAssociationByMember(org.semanticwb.model.AssMember hasmember)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Association> it=new org.semanticwb.model.GenericIterator(hasmember.getSemanticObject().getModel().listSubjects(ClassMgr.swb_hasMember,hasmember.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.AssMember getMember()
    {
         org.semanticwb.model.AssMember ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ClassMgr.swb_hasMember);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.AssMember)obj.createGenericInstance();
         }
         return ret;
    }

    public void setType(org.semanticwb.model.Topic value)
    {
        getSemanticObject().setObjectProperty(ClassMgr.swb_assType, value.getSemanticObject());
    }

    public void removeType()
    {
        getSemanticObject().removeProperty(ClassMgr.swb_assType);
    }

   public static java.util.Iterator<org.semanticwb.model.Association> listAssociationByType(org.semanticwb.model.Topic asstype,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Association> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(ClassMgr.swb_assType, asstype.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.Association> listAssociationByType(org.semanticwb.model.Topic asstype)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.Association> it=new org.semanticwb.model.GenericIterator(asstype.getSemanticObject().getModel().listSubjects(ClassMgr.swb_assType,asstype.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.Topic getType()
    {
         org.semanticwb.model.Topic ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ClassMgr.swb_assType);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Topic)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.WebSite getWebSite()
    {
        return (org.semanticwb.model.WebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
