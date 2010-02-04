package org.semanticwb.process.model.base;


public abstract class InclusiveGatewayBase extends org.semanticwb.process.model.Gateway implements org.semanticwb.model.Descriptiveable,org.semanticwb.process.model.Gateable,org.semanticwb.process.model.Assignable
{
       public static final org.semanticwb.platform.SemanticClass swp_InclusiveGateway=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/swp#InclusiveGateway");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/swp#InclusiveGateway");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGateways(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGateways()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway>(it, true);
       }

       public static org.semanticwb.process.model.InclusiveGateway getInclusiveGateway(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.process.model.InclusiveGateway)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.process.model.InclusiveGateway createInclusiveGateway(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.process.model.InclusiveGateway)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeInclusiveGateway(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasInclusiveGateway(String id, org.semanticwb.model.SWBModel model)
       {
           return (getInclusiveGateway(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGatewayByGate(org.semanticwb.process.model.Gate hasgate,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swp_hasGate, hasgate.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGatewayByGate(org.semanticwb.process.model.Gate hasgate)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway> it=new org.semanticwb.model.GenericIterator(hasgate.getSemanticObject().getModel().listSubjects(swp_hasGate,hasgate.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGatewayByCategory(org.semanticwb.process.model.Category hascategory,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swp_hasCategory, hascategory.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGatewayByCategory(org.semanticwb.process.model.Category hascategory)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway> it=new org.semanticwb.model.GenericIterator(hascategory.getSemanticObject().getModel().listSubjects(swp_hasCategory,hascategory.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGatewayByAssignment(org.semanticwb.process.model.Assignment hasassignment,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swp_hasAssignment, hasassignment.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGatewayByAssignment(org.semanticwb.process.model.Assignment hasassignment)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway> it=new org.semanticwb.model.GenericIterator(hasassignment.getSemanticObject().getModel().listSubjects(swp_hasAssignment,hasassignment.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGatewayByDefaultGate(org.semanticwb.process.model.Gate defaultgate,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swp_defaultGate, defaultgate.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.process.model.InclusiveGateway> listInclusiveGatewayByDefaultGate(org.semanticwb.process.model.Gate defaultgate)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.process.model.InclusiveGateway> it=new org.semanticwb.model.GenericIterator(defaultgate.getSemanticObject().getModel().listSubjects(swp_defaultGate,defaultgate.getSemanticObject()));
       return it;
   }
    }

    public InclusiveGatewayBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
