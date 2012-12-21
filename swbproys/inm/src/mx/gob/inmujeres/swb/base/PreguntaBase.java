package mx.gob.inmujeres.swb.base;


public abstract class PreguntaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass inm_SubGrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SubGrupo");
    public static final org.semanticwb.platform.SemanticProperty inm_subgrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#subgrupo");
    public static final org.semanticwb.platform.SemanticProperty inm_texto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#texto");
    public static final org.semanticwb.platform.SemanticClass inm_Nivel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Nivel");
    public static final org.semanticwb.platform.SemanticProperty inm_hasNiveles=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#hasNiveles");
    public static final org.semanticwb.platform.SemanticClass inm_Score=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Score");
    public static final org.semanticwb.platform.SemanticProperty inm_scoreMax=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#scoreMax");
    public static final org.semanticwb.platform.SemanticClass inm_Pregunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Pregunta");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Pregunta");

    public static class ClassMgr
    {
       /**
       * Returns a list of Pregunta for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Pregunta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Pregunta> listPreguntas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Pregunta for all models
       * @return Iterator of mx.gob.inmujeres.swb.Pregunta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Pregunta> listPreguntas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta>(it, true);
        }

        public static mx.gob.inmujeres.swb.Pregunta createPregunta(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Pregunta.ClassMgr.createPregunta(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Pregunta
       * @param id Identifier for mx.gob.inmujeres.swb.Pregunta
       * @param model Model of the mx.gob.inmujeres.swb.Pregunta
       * @return A mx.gob.inmujeres.swb.Pregunta
       */
        public static mx.gob.inmujeres.swb.Pregunta getPregunta(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Pregunta)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Pregunta
       * @param id Identifier for mx.gob.inmujeres.swb.Pregunta
       * @param model Model of the mx.gob.inmujeres.swb.Pregunta
       * @return A mx.gob.inmujeres.swb.Pregunta
       */
        public static mx.gob.inmujeres.swb.Pregunta createPregunta(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Pregunta)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Pregunta
       * @param id Identifier for mx.gob.inmujeres.swb.Pregunta
       * @param model Model of the mx.gob.inmujeres.swb.Pregunta
       */
        public static void removePregunta(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Pregunta
       * @param id Identifier for mx.gob.inmujeres.swb.Pregunta
       * @param model Model of the mx.gob.inmujeres.swb.Pregunta
       * @return true if the mx.gob.inmujeres.swb.Pregunta exists, false otherwise
       */

        public static boolean hasPregunta(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPregunta(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Pregunta with a determined Subgrupo
       * @param value Subgrupo of the type mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.Pregunta
       * @return Iterator with all the mx.gob.inmujeres.swb.Pregunta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Pregunta> listPreguntaBySubgrupo(mx.gob.inmujeres.swb.SubGrupo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_subgrupo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Pregunta with a determined Subgrupo
       * @param value Subgrupo of the type mx.gob.inmujeres.swb.SubGrupo
       * @return Iterator with all the mx.gob.inmujeres.swb.Pregunta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Pregunta> listPreguntaBySubgrupo(mx.gob.inmujeres.swb.SubGrupo value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_subgrupo,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Pregunta with a determined Niveles
       * @param value Niveles of the type mx.gob.inmujeres.swb.Nivel
       * @param model Model of the mx.gob.inmujeres.swb.Pregunta
       * @return Iterator with all the mx.gob.inmujeres.swb.Pregunta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Pregunta> listPreguntaByNiveles(mx.gob.inmujeres.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_hasNiveles, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Pregunta with a determined Niveles
       * @param value Niveles of the type mx.gob.inmujeres.swb.Nivel
       * @return Iterator with all the mx.gob.inmujeres.swb.Pregunta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Pregunta> listPreguntaByNiveles(mx.gob.inmujeres.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_hasNiveles,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Pregunta with a determined ScoreMax
       * @param value ScoreMax of the type mx.gob.inmujeres.swb.Score
       * @param model Model of the mx.gob.inmujeres.swb.Pregunta
       * @return Iterator with all the mx.gob.inmujeres.swb.Pregunta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Pregunta> listPreguntaByScoreMax(mx.gob.inmujeres.swb.Score value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_scoreMax, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Pregunta with a determined ScoreMax
       * @param value ScoreMax of the type mx.gob.inmujeres.swb.Score
       * @return Iterator with all the mx.gob.inmujeres.swb.Pregunta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Pregunta> listPreguntaByScoreMax(mx.gob.inmujeres.swb.Score value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_scoreMax,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static PreguntaBase.ClassMgr getPreguntaClassMgr()
    {
        return new PreguntaBase.ClassMgr();
    }

   /**
   * Constructs a PreguntaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Pregunta
   */
    public PreguntaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Subgrupo
   * @param value Subgrupo to set
   */

    public void setSubgrupo(mx.gob.inmujeres.swb.SubGrupo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_subgrupo, value.getSemanticObject());
        }else
        {
            removeSubgrupo();
        }
    }
   /**
   * Remove the value for Subgrupo property
   */

    public void removeSubgrupo()
    {
        getSemanticObject().removeProperty(inm_subgrupo);
    }

   /**
   * Gets the Subgrupo
   * @return a mx.gob.inmujeres.swb.SubGrupo
   */
    public mx.gob.inmujeres.swb.SubGrupo getSubgrupo()
    {
         mx.gob.inmujeres.swb.SubGrupo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_subgrupo);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.SubGrupo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Texto property
* @return String with the Texto
*/
    public String getTexto()
    {
        return getSemanticObject().getProperty(inm_texto);
    }

/**
* Sets the Texto property
* @param value long with the Texto
*/
    public void setTexto(String value)
    {
        getSemanticObject().setProperty(inm_texto, value);
    }
   /**
   * Gets all the mx.gob.inmujeres.swb.Nivel
   * @return A GenericIterator with all the mx.gob.inmujeres.swb.Nivel
   */

    public org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Nivel> listNiveleses()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Nivel>(getSemanticObject().listObjectProperties(inm_hasNiveles));
    }

   /**
   * Gets true if has a Niveles
   * @param value mx.gob.inmujeres.swb.Nivel to verify
   * @return true if the mx.gob.inmujeres.swb.Nivel exists, false otherwise
   */
    public boolean hasNiveles(mx.gob.inmujeres.swb.Nivel value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(inm_hasNiveles,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Niveles
   * @param value mx.gob.inmujeres.swb.Nivel to add
   */

    public void addNiveles(mx.gob.inmujeres.swb.Nivel value)
    {
        getSemanticObject().addObjectProperty(inm_hasNiveles, value.getSemanticObject());
    }
   /**
   * Removes all the Niveles
   */

    public void removeAllNiveles()
    {
        getSemanticObject().removeProperty(inm_hasNiveles);
    }
   /**
   * Removes a Niveles
   * @param value mx.gob.inmujeres.swb.Nivel to remove
   */

    public void removeNiveles(mx.gob.inmujeres.swb.Nivel value)
    {
        getSemanticObject().removeObjectProperty(inm_hasNiveles,value.getSemanticObject());
    }

   /**
   * Gets the Niveles
   * @return a mx.gob.inmujeres.swb.Nivel
   */
    public mx.gob.inmujeres.swb.Nivel getNiveles()
    {
         mx.gob.inmujeres.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_hasNiveles);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ScoreMax
   * @param value ScoreMax to set
   */

    public void setScoreMax(mx.gob.inmujeres.swb.Score value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_scoreMax, value.getSemanticObject());
        }else
        {
            removeScoreMax();
        }
    }
   /**
   * Remove the value for ScoreMax property
   */

    public void removeScoreMax()
    {
        getSemanticObject().removeProperty(inm_scoreMax);
    }

   /**
   * Gets the ScoreMax
   * @return a mx.gob.inmujeres.swb.Score
   */
    public mx.gob.inmujeres.swb.Score getScoreMax()
    {
         mx.gob.inmujeres.swb.Score ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_scoreMax);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Score)obj.createGenericInstance();
         }
         return ret;
    }
}
