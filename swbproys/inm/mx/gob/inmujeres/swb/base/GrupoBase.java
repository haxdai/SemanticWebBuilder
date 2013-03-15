package mx.gob.inmujeres.swb.base;


public abstract class GrupoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_SubGrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SubGrupo");
    public static final org.semanticwb.platform.SemanticProperty inm_hasSubGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#hasSubGroup");
    public static final org.semanticwb.platform.SemanticProperty inm_numgrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#numgrupo");
    public static final org.semanticwb.platform.SemanticClass inm_Grupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Grupo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Grupo");

    public static class ClassMgr
    {
       /**
       * Returns a list of Grupo for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Grupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Grupo> listGrupos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Grupo>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Grupo for all models
       * @return Iterator of mx.gob.inmujeres.swb.Grupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Grupo> listGrupos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Grupo>(it, true);
        }

        public static mx.gob.inmujeres.swb.Grupo createGrupo(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Grupo.ClassMgr.createGrupo(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Grupo
       * @param id Identifier for mx.gob.inmujeres.swb.Grupo
       * @param model Model of the mx.gob.inmujeres.swb.Grupo
       * @return A mx.gob.inmujeres.swb.Grupo
       */
        public static mx.gob.inmujeres.swb.Grupo getGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Grupo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Grupo
       * @param id Identifier for mx.gob.inmujeres.swb.Grupo
       * @param model Model of the mx.gob.inmujeres.swb.Grupo
       * @return A mx.gob.inmujeres.swb.Grupo
       */
        public static mx.gob.inmujeres.swb.Grupo createGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Grupo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Grupo
       * @param id Identifier for mx.gob.inmujeres.swb.Grupo
       * @param model Model of the mx.gob.inmujeres.swb.Grupo
       */
        public static void removeGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Grupo
       * @param id Identifier for mx.gob.inmujeres.swb.Grupo
       * @param model Model of the mx.gob.inmujeres.swb.Grupo
       * @return true if the mx.gob.inmujeres.swb.Grupo exists, false otherwise
       */

        public static boolean hasGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGrupo(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Grupo with a determined SubGroup
       * @param value SubGroup of the type mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.Grupo
       * @return Iterator with all the mx.gob.inmujeres.swb.Grupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Grupo> listGrupoBySubGroup(mx.gob.inmujeres.swb.SubGrupo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Grupo> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_hasSubGroup, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Grupo with a determined SubGroup
       * @param value SubGroup of the type mx.gob.inmujeres.swb.SubGrupo
       * @return Iterator with all the mx.gob.inmujeres.swb.Grupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Grupo> listGrupoBySubGroup(mx.gob.inmujeres.swb.SubGrupo value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Grupo> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_hasSubGroup,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a GrupoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Grupo
   */
    public GrupoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the mx.gob.inmujeres.swb.SubGrupo
   * @return A GenericIterator with all the mx.gob.inmujeres.swb.SubGrupo
   */

    public org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SubGrupo> listSubGroups()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SubGrupo>(getSemanticObject().listObjectProperties(inm_hasSubGroup));
    }

   /**
   * Gets true if has a SubGroup
   * @param value mx.gob.inmujeres.swb.SubGrupo to verify
   * @return true if the mx.gob.inmujeres.swb.SubGrupo exists, false otherwise
   */
    public boolean hasSubGroup(mx.gob.inmujeres.swb.SubGrupo value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(inm_hasSubGroup,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a SubGroup
   * @param value mx.gob.inmujeres.swb.SubGrupo to add
   */

    public void addSubGroup(mx.gob.inmujeres.swb.SubGrupo value)
    {
        getSemanticObject().addObjectProperty(inm_hasSubGroup, value.getSemanticObject());
    }
   /**
   * Removes all the SubGroup
   */

    public void removeAllSubGroup()
    {
        getSemanticObject().removeProperty(inm_hasSubGroup);
    }
   /**
   * Removes a SubGroup
   * @param value mx.gob.inmujeres.swb.SubGrupo to remove
   */

    public void removeSubGroup(mx.gob.inmujeres.swb.SubGrupo value)
    {
        getSemanticObject().removeObjectProperty(inm_hasSubGroup,value.getSemanticObject());
    }

   /**
   * Gets the SubGroup
   * @return a mx.gob.inmujeres.swb.SubGrupo
   */
    public mx.gob.inmujeres.swb.SubGrupo getSubGroup()
    {
         mx.gob.inmujeres.swb.SubGrupo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_hasSubGroup);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.SubGrupo)obj.createGenericInstance();
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
* Gets the Numgrupo property
* @return int with the Numgrupo
*/
    public int getNumgrupo()
    {
        return getSemanticObject().getIntProperty(inm_numgrupo);
    }

/**
* Sets the Numgrupo property
* @param value long with the Numgrupo
*/
    public void setNumgrupo(int value)
    {
        getSemanticObject().setIntProperty(inm_numgrupo, value);
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
