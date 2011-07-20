package org.semanticwb.promexico.base;

   /**
   * Datos de un representante, se utiliza para las oficinas y para las regiones 
   */
public interface RepresentableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticProperty promx_repreEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#repreEmail");
    public static final org.semanticwb.platform.SemanticProperty promx_repreName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#repreName");
    public static final org.semanticwb.platform.SemanticProperty promx_reprePhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#reprePhone");
   /**
   * Datos de un representante, se utiliza para las oficinas y para las regiones 
   */
    public static final org.semanticwb.platform.SemanticClass promx_Representable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Representable");

    public String getRepreEmail();

    public void setRepreEmail(String value);

    public String getRepreName();

    public void setRepreName(String value);

    public String getReprePhone();

    public void setReprePhone(String value);
}
