package mx.gob.inmujeres.swb.base;


public abstract class SubGrupoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_Grupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Grupo");
    public static final org.semanticwb.platform.SemanticProperty inm_inGrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#inGrupo");
    public static final org.semanticwb.platform.SemanticClass inm_SubGrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SubGrupo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SubGrupo");

    public static class ClassMgr
    {
       /**
       * Returns a list of SubGrupo for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.SubGrupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SubGrupo> listSubGrupos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SubGrupo>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.SubGrupo for all models
       * @return Iterator of mx.gob.inmujeres.swb.SubGrupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SubGrupo> listSubGrupos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SubGrupo>(it, true);
        }

        public static mx.gob.inmujeres.swb.SubGrupo createSubGrupo(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.SubGrupo.ClassMgr.createSubGrupo(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.SubGrupo
       * @param id Identifier for mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.SubGrupo
       * @return A mx.gob.inmujeres.swb.SubGrupo
       */
        public static mx.gob.inmujeres.swb.SubGrupo getSubGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.SubGrupo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.SubGrupo
       * @param id Identifier for mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.SubGrupo
       * @return A mx.gob.inmujeres.swb.SubGrupo
       */
        public static mx.gob.inmujeres.swb.SubGrupo createSubGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.SubGrupo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.SubGrupo
       * @param id Identifier for mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.SubGrupo
       */
        public static void removeSubGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.SubGrupo
       * @param id Identifier for mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.SubGrupo
       * @return true if the mx.gob.inmujeres.swb.SubGrupo exists, false otherwise
       */

        public static boolean hasSubGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSubGrupo(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.SubGrupo with a determined Grupo
       * @param value Grupo of the type mx.gob.inmujeres.swb.Grupo
       * @param model Model of the mx.gob.inmujeres.swb.SubGrupo
       * @return Iterator with all the mx.gob.inmujeres.swb.SubGrupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SubGrupo> listSubGrupoByGrupo(mx.gob.inmujeres.swb.Grupo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SubGrupo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_inGrupo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.SubGrupo with a determined Grupo
       * @param value Grupo of the type mx.gob.inmujeres.swb.Grupo
       * @return Iterator with all the mx.gob.inmujeres.swb.SubGrupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SubGrupo> listSubGrupoByGrupo(mx.gob.inmujeres.swb.Grupo value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SubGrupo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_inGrupo,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static SubGrupoBase.ClassMgr getSubGrupoClassMgr()
    {
        return new SubGrupoBase.ClassMgr();
    }

   /**
   * Constructs a SubGrupoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SubGrupo
   */
    public SubGrupoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Grupo
   * @param value Grupo to set
   */

    public void setGrupo(mx.gob.inmujeres.swb.Grupo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_inGrupo, value.getSemanticObject());
        }else
        {
            removeGrupo();
        }
    }
   /**
   * Remove the value for Grupo property
   */

    public void removeGrupo()
    {
        getSemanticObject().removeProperty(inm_inGrupo);
    }

   /**
   * Gets the Grupo
   * @return a mx.gob.inmujeres.swb.Grupo
   */
    public mx.gob.inmujeres.swb.Grupo getGrupo()
    {
         mx.gob.inmujeres.swb.Grupo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_inGrupo);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Grupo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }
}
