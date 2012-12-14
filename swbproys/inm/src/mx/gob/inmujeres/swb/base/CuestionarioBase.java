package mx.gob.inmujeres.swb.base;


public abstract class CuestionarioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass inm_Pregunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Pregunta");
    public static final org.semanticwb.platform.SemanticProperty inm_hasPreguntas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#hasPreguntas");
    public static final org.semanticwb.platform.SemanticClass inm_Nivel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Nivel");
    public static final org.semanticwb.platform.SemanticProperty inm_nivel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#nivel");
    public static final org.semanticwb.platform.SemanticClass inm_Cuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Cuestionario");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Cuestionario");

    public static class ClassMgr
    {
       /**
       * Returns a list of Cuestionario for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Cuestionario for all models
       * @return Iterator of mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario>(it, true);
        }

        public static mx.gob.inmujeres.swb.Cuestionario createCuestionario(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Cuestionario.ClassMgr.createCuestionario(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return A mx.gob.inmujeres.swb.Cuestionario
       */
        public static mx.gob.inmujeres.swb.Cuestionario getCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Cuestionario)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return A mx.gob.inmujeres.swb.Cuestionario
       */
        public static mx.gob.inmujeres.swb.Cuestionario createCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Cuestionario)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       */
        public static void removeCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return true if the mx.gob.inmujeres.swb.Cuestionario exists, false otherwise
       */

        public static boolean hasCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCuestionario(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined Preguntas
       * @param value Preguntas of the type mx.gob.inmujeres.swb.Pregunta
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByPreguntas(mx.gob.inmujeres.swb.Pregunta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_hasPreguntas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined Preguntas
       * @param value Preguntas of the type mx.gob.inmujeres.swb.Pregunta
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByPreguntas(mx.gob.inmujeres.swb.Pregunta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_hasPreguntas,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined Nivel
       * @param value Nivel of the type mx.gob.inmujeres.swb.Nivel
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByNivel(mx.gob.inmujeres.swb.Nivel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_nivel, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Cuestionario with a determined Nivel
       * @param value Nivel of the type mx.gob.inmujeres.swb.Nivel
       * @return Iterator with all the mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarioByNivel(mx.gob.inmujeres.swb.Nivel value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_nivel,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CuestionarioBase.ClassMgr getCuestionarioClassMgr()
    {
        return new CuestionarioBase.ClassMgr();
    }

   /**
   * Constructs a CuestionarioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Cuestionario
   */
    public CuestionarioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the mx.gob.inmujeres.swb.Pregunta
   * @return A GenericIterator with all the mx.gob.inmujeres.swb.Pregunta
   */

    public org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta> listPreguntases()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Pregunta>(getSemanticObject().listObjectProperties(inm_hasPreguntas));
    }

   /**
   * Gets true if has a Preguntas
   * @param value mx.gob.inmujeres.swb.Pregunta to verify
   * @return true if the mx.gob.inmujeres.swb.Pregunta exists, false otherwise
   */
    public boolean hasPreguntas(mx.gob.inmujeres.swb.Pregunta value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(inm_hasPreguntas,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Preguntas
   * @param value mx.gob.inmujeres.swb.Pregunta to add
   */

    public void addPreguntas(mx.gob.inmujeres.swb.Pregunta value)
    {
        getSemanticObject().addObjectProperty(inm_hasPreguntas, value.getSemanticObject());
    }
   /**
   * Removes all the Preguntas
   */

    public void removeAllPreguntas()
    {
        getSemanticObject().removeProperty(inm_hasPreguntas);
    }
   /**
   * Removes a Preguntas
   * @param value mx.gob.inmujeres.swb.Pregunta to remove
   */

    public void removePreguntas(mx.gob.inmujeres.swb.Pregunta value)
    {
        getSemanticObject().removeObjectProperty(inm_hasPreguntas,value.getSemanticObject());
    }

   /**
   * Gets the Preguntas
   * @return a mx.gob.inmujeres.swb.Pregunta
   */
    public mx.gob.inmujeres.swb.Pregunta getPreguntas()
    {
         mx.gob.inmujeres.swb.Pregunta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_hasPreguntas);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Pregunta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Nivel
   * @param value Nivel to set
   */

    public void setNivel(mx.gob.inmujeres.swb.Nivel value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_nivel, value.getSemanticObject());
        }else
        {
            removeNivel();
        }
    }
   /**
   * Remove the value for Nivel property
   */

    public void removeNivel()
    {
        getSemanticObject().removeProperty(inm_nivel);
    }

   /**
   * Gets the Nivel
   * @return a mx.gob.inmujeres.swb.Nivel
   */
    public mx.gob.inmujeres.swb.Nivel getNivel()
    {
         mx.gob.inmujeres.swb.Nivel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_nivel);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Nivel)obj.createGenericInstance();
         }
         return ret;
    }
}
