package com.infotec.lodp.swb.base;


public abstract class TagBase extends org.semanticwb.model.base.GenericObjectBase 
{
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticProperty lodp_tagName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#tagName");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Tag=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Tag");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Tag");

    public static class ClassMgr
    {
       /**
       * Returns a list of Tag for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Tag
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Tag> listTags(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Tag>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Tag for all models
       * @return Iterator of com.infotec.lodp.swb.Tag
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Tag> listTags()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Tag>(it, true);
        }

        public static com.infotec.lodp.swb.Tag createTag(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.Tag.ClassMgr.createTag(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.Tag
       * @param id Identifier for com.infotec.lodp.swb.Tag
       * @param model Model of the com.infotec.lodp.swb.Tag
       * @return A com.infotec.lodp.swb.Tag
       */
        public static com.infotec.lodp.swb.Tag getTag(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Tag)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Tag
       * @param id Identifier for com.infotec.lodp.swb.Tag
       * @param model Model of the com.infotec.lodp.swb.Tag
       * @return A com.infotec.lodp.swb.Tag
       */
        public static com.infotec.lodp.swb.Tag createTag(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Tag)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Tag
       * @param id Identifier for com.infotec.lodp.swb.Tag
       * @param model Model of the com.infotec.lodp.swb.Tag
       */
        public static void removeTag(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Tag
       * @param id Identifier for com.infotec.lodp.swb.Tag
       * @param model Model of the com.infotec.lodp.swb.Tag
       * @return true if the com.infotec.lodp.swb.Tag exists, false otherwise
       */

        public static boolean hasTag(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTag(id, model)!=null);
        }
    }

    public static TagBase.ClassMgr getTagClassMgr()
    {
        return new TagBase.ClassMgr();
    }

   /**
   * Constructs a TagBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Tag
   */
    public TagBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in Tag object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in Tag object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }

/**
* Gets the TagName property
* @return String with the TagName
*/
    public String getTagName()
    {
        return getSemanticObject().getProperty(lodp_tagName);
    }

/**
* Sets the TagName property
* @param value long with the TagName
*/
    public void setTagName(String value)
    {
        getSemanticObject().setProperty(lodp_tagName, value);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
