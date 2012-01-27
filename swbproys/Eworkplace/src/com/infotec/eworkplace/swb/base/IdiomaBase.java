package com.infotec.eworkplace.swb.base;


public abstract class IdiomaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Lectura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Lectura");
    public static final org.semanticwb.platform.SemanticProperty intranet_lectura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#lectura");
    public static final org.semanticwb.platform.SemanticClass intranet_Conversacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Conversacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_conversacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#conversacion");
    public static final org.semanticwb.platform.SemanticClass intranet_Idiomas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idiomas");
    public static final org.semanticwb.platform.SemanticProperty intranet_idiomas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#idiomas");
    public static final org.semanticwb.platform.SemanticClass intranet_Escritura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Escritura");
    public static final org.semanticwb.platform.SemanticProperty intranet_escritura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#escritura");
    public static final org.semanticwb.platform.SemanticClass intranet_Idioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idioma");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idioma");

    public static class ClassMgr
    {
       /**
       * Returns a list of Idioma for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Idioma for all models
       * @return Iterator of com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma>(it, true);
        }

        public static com.infotec.eworkplace.swb.Idioma createIdioma(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Idioma.ClassMgr.createIdioma(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return A com.infotec.eworkplace.swb.Idioma
       */
        public static com.infotec.eworkplace.swb.Idioma getIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Idioma)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return A com.infotec.eworkplace.swb.Idioma
       */
        public static com.infotec.eworkplace.swb.Idioma createIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Idioma)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       */
        public static void removeIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return true if the com.infotec.eworkplace.swb.Idioma exists, false otherwise
       */

        public static boolean hasIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            return (getIdioma(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Idioma with a determined Lectura
       * @param value Lectura of the type com.infotec.eworkplace.swb.Lectura
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return Iterator with all the com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomaByLectura(com.infotec.eworkplace.swb.Lectura value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_lectura, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Idioma with a determined Lectura
       * @param value Lectura of the type com.infotec.eworkplace.swb.Lectura
       * @return Iterator with all the com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomaByLectura(com.infotec.eworkplace.swb.Lectura value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_lectura,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Idioma with a determined Conversacion
       * @param value Conversacion of the type com.infotec.eworkplace.swb.Conversacion
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return Iterator with all the com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomaByConversacion(com.infotec.eworkplace.swb.Conversacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_conversacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Idioma with a determined Conversacion
       * @param value Conversacion of the type com.infotec.eworkplace.swb.Conversacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomaByConversacion(com.infotec.eworkplace.swb.Conversacion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_conversacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Idioma with a determined Idiomas
       * @param value Idiomas of the type com.infotec.eworkplace.swb.Idiomas
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return Iterator with all the com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomaByIdiomas(com.infotec.eworkplace.swb.Idiomas value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_idiomas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Idioma with a determined Idiomas
       * @param value Idiomas of the type com.infotec.eworkplace.swb.Idiomas
       * @return Iterator with all the com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomaByIdiomas(com.infotec.eworkplace.swb.Idiomas value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_idiomas,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Idioma with a determined Escritura
       * @param value Escritura of the type com.infotec.eworkplace.swb.Escritura
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return Iterator with all the com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomaByEscritura(com.infotec.eworkplace.swb.Escritura value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_escritura, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Idioma with a determined Escritura
       * @param value Escritura of the type com.infotec.eworkplace.swb.Escritura
       * @return Iterator with all the com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomaByEscritura(com.infotec.eworkplace.swb.Escritura value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_escritura,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a IdiomaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Idioma
   */
    public IdiomaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Lectura
   * @param value Lectura to set
   */

    public void setLectura(com.infotec.eworkplace.swb.Lectura value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_lectura, value.getSemanticObject());
        }else
        {
            removeLectura();
        }
    }
   /**
   * Remove the value for Lectura property
   */

    public void removeLectura()
    {
        getSemanticObject().removeProperty(intranet_lectura);
    }

   /**
   * Gets the Lectura
   * @return a com.infotec.eworkplace.swb.Lectura
   */
    public com.infotec.eworkplace.swb.Lectura getLectura()
    {
         com.infotec.eworkplace.swb.Lectura ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_lectura);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Lectura)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Conversacion
   * @param value Conversacion to set
   */

    public void setConversacion(com.infotec.eworkplace.swb.Conversacion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_conversacion, value.getSemanticObject());
        }else
        {
            removeConversacion();
        }
    }
   /**
   * Remove the value for Conversacion property
   */

    public void removeConversacion()
    {
        getSemanticObject().removeProperty(intranet_conversacion);
    }

   /**
   * Gets the Conversacion
   * @return a com.infotec.eworkplace.swb.Conversacion
   */
    public com.infotec.eworkplace.swb.Conversacion getConversacion()
    {
         com.infotec.eworkplace.swb.Conversacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_conversacion);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Conversacion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Idiomas
   * @param value Idiomas to set
   */

    public void setIdiomas(com.infotec.eworkplace.swb.Idiomas value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_idiomas, value.getSemanticObject());
        }else
        {
            removeIdiomas();
        }
    }
   /**
   * Remove the value for Idiomas property
   */

    public void removeIdiomas()
    {
        getSemanticObject().removeProperty(intranet_idiomas);
    }

   /**
   * Gets the Idiomas
   * @return a com.infotec.eworkplace.swb.Idiomas
   */
    public com.infotec.eworkplace.swb.Idiomas getIdiomas()
    {
         com.infotec.eworkplace.swb.Idiomas ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_idiomas);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Idiomas)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Escritura
   * @param value Escritura to set
   */

    public void setEscritura(com.infotec.eworkplace.swb.Escritura value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_escritura, value.getSemanticObject());
        }else
        {
            removeEscritura();
        }
    }
   /**
   * Remove the value for Escritura property
   */

    public void removeEscritura()
    {
        getSemanticObject().removeProperty(intranet_escritura);
    }

   /**
   * Gets the Escritura
   * @return a com.infotec.eworkplace.swb.Escritura
   */
    public com.infotec.eworkplace.swb.Escritura getEscritura()
    {
         com.infotec.eworkplace.swb.Escritura ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_escritura);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Escritura)obj.createGenericInstance();
         }
         return ret;
    }
}
