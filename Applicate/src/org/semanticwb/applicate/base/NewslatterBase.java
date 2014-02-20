package org.semanticwb.applicate.base;


public abstract class NewslatterBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty app_hasEnviados=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#hasEnviados");
    public static final org.semanticwb.platform.SemanticProperty app_fecha=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#fecha");
    public static final org.semanticwb.platform.SemanticProperty app_content=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#content");
    public static final org.semanticwb.platform.SemanticProperty app_titulo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#titulo");
    public static final org.semanticwb.platform.SemanticProperty app_hasNoEnviados=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#hasNoEnviados");
    public static final org.semanticwb.platform.SemanticClass app_Newslatter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#Newslatter");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#Newslatter");

    public static class ClassMgr
    {
       /**
       * Returns a list of Newslatter for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.applicate.Newslatter
       */

        public static java.util.Iterator<org.semanticwb.applicate.Newslatter> listNewslatters(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.Newslatter>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.applicate.Newslatter for all models
       * @return Iterator of org.semanticwb.applicate.Newslatter
       */

        public static java.util.Iterator<org.semanticwb.applicate.Newslatter> listNewslatters()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.Newslatter>(it, true);
        }
       /**
       * Gets a org.semanticwb.applicate.Newslatter
       * @param id Identifier for org.semanticwb.applicate.Newslatter
       * @param model Model of the org.semanticwb.applicate.Newslatter
       * @return A org.semanticwb.applicate.Newslatter
       */
        public static org.semanticwb.applicate.Newslatter getNewslatter(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.Newslatter)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.applicate.Newslatter
       * @param id Identifier for org.semanticwb.applicate.Newslatter
       * @param model Model of the org.semanticwb.applicate.Newslatter
       * @return A org.semanticwb.applicate.Newslatter
       */
        public static org.semanticwb.applicate.Newslatter createNewslatter(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.Newslatter)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.applicate.Newslatter
       * @param id Identifier for org.semanticwb.applicate.Newslatter
       * @param model Model of the org.semanticwb.applicate.Newslatter
       */
        public static void removeNewslatter(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.applicate.Newslatter
       * @param id Identifier for org.semanticwb.applicate.Newslatter
       * @param model Model of the org.semanticwb.applicate.Newslatter
       * @return true if the org.semanticwb.applicate.Newslatter exists, false otherwise
       */

        public static boolean hasNewslatter(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNewslatter(id, model)!=null);
        }
    }

    public static NewslatterBase.ClassMgr getNewslatterClassMgr()
    {
        return new NewslatterBase.ClassMgr();
    }

   /**
   * Constructs a NewslatterBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Newslatter
   */
    public NewslatterBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public java.util.Iterator<String> listEnviadoses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(app_hasEnviados);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addEnviados(String value)
    {
        getSemanticObject().addLiteralProperty(app_hasEnviados, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllEnviados()
    {
        getSemanticObject().removeProperty(app_hasEnviados);
    }

    public void removeEnviados(String value)
    {
        getSemanticObject().removeLiteralProperty(app_hasEnviados,new org.semanticwb.platform.SemanticLiteral(value));
    }

/**
* Gets the Fecha property
* @return java.util.Date with the Fecha
*/
    public java.util.Date getFecha()
    {
        return getSemanticObject().getDateProperty(app_fecha);
    }

/**
* Sets the Fecha property
* @param value long with the Fecha
*/
    public void setFecha(java.util.Date value)
    {
        getSemanticObject().setDateProperty(app_fecha, value);
    }

/**
* Gets the Content property
* @return String with the Content
*/
    public String getContent()
    {
        return getSemanticObject().getProperty(app_content);
    }

/**
* Sets the Content property
* @param value long with the Content
*/
    public void setContent(String value)
    {
        getSemanticObject().setProperty(app_content, value);
    }

/**
* Gets the Titulo property
* @return String with the Titulo
*/
    public String getTitulo()
    {
        return getSemanticObject().getProperty(app_titulo);
    }

/**
* Sets the Titulo property
* @param value long with the Titulo
*/
    public void setTitulo(String value)
    {
        getSemanticObject().setProperty(app_titulo, value);
    }

    public java.util.Iterator<String> listNoEnviadoses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(app_hasNoEnviados);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addNoEnviados(String value)
    {
        getSemanticObject().addLiteralProperty(app_hasNoEnviados, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllNoEnviados()
    {
        getSemanticObject().removeProperty(app_hasNoEnviados);
    }

    public void removeNoEnviados(String value)
    {
        getSemanticObject().removeLiteralProperty(app_hasNoEnviados,new org.semanticwb.platform.SemanticLiteral(value));
    }
}
