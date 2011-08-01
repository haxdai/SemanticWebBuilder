package org.semanticwb.promexico.base;


public abstract class SlideButtonBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty promx_btnNewWindow=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#btnNewWindow");
    public static final org.semanticwb.platform.SemanticProperty promx_btnRedirect=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#btnRedirect");
    public static final org.semanticwb.platform.SemanticProperty promx_btnTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#btnTitle");
    public static final org.semanticwb.platform.SemanticClass promx_SlideButton=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#SlideButton");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#SlideButton");

    public static class ClassMgr
    {
       /**
       * Returns a list of SlideButton for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.SlideButton
       */

        public static java.util.Iterator<org.semanticwb.promexico.SlideButton> listSlideButtons(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.SlideButton>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.SlideButton for all models
       * @return Iterator of org.semanticwb.promexico.SlideButton
       */

        public static java.util.Iterator<org.semanticwb.promexico.SlideButton> listSlideButtons()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.SlideButton>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.SlideButton
       * @param id Identifier for org.semanticwb.promexico.SlideButton
       * @param model Model of the org.semanticwb.promexico.SlideButton
       * @return A org.semanticwb.promexico.SlideButton
       */
        public static org.semanticwb.promexico.SlideButton getSlideButton(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.SlideButton)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.SlideButton
       * @param id Identifier for org.semanticwb.promexico.SlideButton
       * @param model Model of the org.semanticwb.promexico.SlideButton
       * @return A org.semanticwb.promexico.SlideButton
       */
        public static org.semanticwb.promexico.SlideButton createSlideButton(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.SlideButton)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.SlideButton
       * @param id Identifier for org.semanticwb.promexico.SlideButton
       * @param model Model of the org.semanticwb.promexico.SlideButton
       */
        public static void removeSlideButton(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.SlideButton
       * @param id Identifier for org.semanticwb.promexico.SlideButton
       * @param model Model of the org.semanticwb.promexico.SlideButton
       * @return true if the org.semanticwb.promexico.SlideButton exists, false otherwise
       */

        public static boolean hasSlideButton(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSlideButton(id, model)!=null);
        }
    }

   /**
   * Constructs a SlideButtonBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SlideButton
   */
    public SlideButtonBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the BtnNewWindow property
* @return boolean with the BtnNewWindow
*/
    public boolean isBtnNewWindow()
    {
        return getSemanticObject().getBooleanProperty(promx_btnNewWindow);
    }

/**
* Sets the BtnNewWindow property
* @param value long with the BtnNewWindow
*/
    public void setBtnNewWindow(boolean value)
    {
        getSemanticObject().setBooleanProperty(promx_btnNewWindow, value);
    }

/**
* Gets the BtnRedirect property
* @return String with the BtnRedirect
*/
    public String getBtnRedirect()
    {
        return getSemanticObject().getProperty(promx_btnRedirect);
    }

/**
* Sets the BtnRedirect property
* @param value long with the BtnRedirect
*/
    public void setBtnRedirect(String value)
    {
        getSemanticObject().setProperty(promx_btnRedirect, value);
    }

/**
* Gets the BtnTitle property
* @return String with the BtnTitle
*/
    public String getBtnTitle()
    {
        return getSemanticObject().getProperty(promx_btnTitle);
    }

/**
* Sets the BtnTitle property
* @param value long with the BtnTitle
*/
    public void setBtnTitle(String value)
    {
        getSemanticObject().setProperty(promx_btnTitle, value);
    }
}
