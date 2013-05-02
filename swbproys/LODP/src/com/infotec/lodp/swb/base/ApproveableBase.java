package com.infotec.lodp.swb.base;

public interface ApproveableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty lodp_reviewed=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#reviewed");
   /**
   * Posible aprobacion de un supervisor 
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_approved=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#approved");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Approveable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Approveable");

    public boolean isReviewed();

    public void setReviewed(boolean value);

    public boolean isApproved();

    public void setApproved(boolean value);
}
