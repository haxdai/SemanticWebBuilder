package com.infotec.conorg.base;


public abstract class AuthorBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty conorg_authorName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#authorName");
    public static final org.semanticwb.platform.SemanticProperty conorg_authorLastName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com/conorg.owl#authorLastName");
    public static final org.semanticwb.platform.SemanticClass conorg_Author=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Author");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com/conorg.owl#Author");

    public static class ClassMgr
    {
       /**
       * Returns a list of Author for a model
       * @param model Model to find
       * @return Iterator of com.infotec.conorg.Author
       */

        public static java.util.Iterator<com.infotec.conorg.Author> listAuthors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Author>(it, true);
        }
       /**
       * Returns a list of com.infotec.conorg.Author for all models
       * @return Iterator of com.infotec.conorg.Author
       */

        public static java.util.Iterator<com.infotec.conorg.Author> listAuthors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.conorg.Author>(it, true);
        }
       /**
       * Gets a com.infotec.conorg.Author
       * @param id Identifier for com.infotec.conorg.Author
       * @param model Model of the com.infotec.conorg.Author
       * @return A com.infotec.conorg.Author
       */
        public static com.infotec.conorg.Author getAuthor(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Author)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.conorg.Author
       * @param id Identifier for com.infotec.conorg.Author
       * @param model Model of the com.infotec.conorg.Author
       * @return A com.infotec.conorg.Author
       */
        public static com.infotec.conorg.Author createAuthor(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.conorg.Author)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.conorg.Author
       * @param id Identifier for com.infotec.conorg.Author
       * @param model Model of the com.infotec.conorg.Author
       */
        public static void removeAuthor(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.conorg.Author
       * @param id Identifier for com.infotec.conorg.Author
       * @param model Model of the com.infotec.conorg.Author
       * @return true if the com.infotec.conorg.Author exists, false otherwise
       */

        public static boolean hasAuthor(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAuthor(id, model)!=null);
        }
    }

    public static AuthorBase.ClassMgr getAuthorClassMgr()
    {
        return new AuthorBase.ClassMgr();
    }

   /**
   * Constructs a AuthorBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Author
   */
    public AuthorBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the AuthorName property
* @return String with the AuthorName
*/
    public String getAuthorName()
    {
        return getSemanticObject().getProperty(conorg_authorName);
    }

/**
* Sets the AuthorName property
* @param value long with the AuthorName
*/
    public void setAuthorName(String value)
    {
        getSemanticObject().setProperty(conorg_authorName, value);
    }

/**
* Gets the AuthorLastName property
* @return String with the AuthorLastName
*/
    public String getAuthorLastName()
    {
        return getSemanticObject().getProperty(conorg_authorLastName);
    }

/**
* Sets the AuthorLastName property
* @param value long with the AuthorLastName
*/
    public void setAuthorLastName(String value)
    {
        getSemanticObject().setProperty(conorg_authorLastName, value);
    }
}
