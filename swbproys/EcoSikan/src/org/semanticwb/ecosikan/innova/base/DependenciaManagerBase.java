package org.semanticwb.ecosikan.innova.base;


public abstract class DependenciaManagerBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticClass ecoskn_Dependencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Dependencia");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasDependencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasDependencia");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticClass ecoskn_DependenciaManager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#DependenciaManager");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#DependenciaManager");

    public DependenciaManagerBase()
    {
    }

   /**
   * Constructs a DependenciaManagerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DependenciaManager
   */
    public DependenciaManagerBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Dependencia
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Dependencia
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia> listDependencias()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Dependencia>(getSemanticObject().listObjectProperties(ecoskn_hasDependencia));
    }

   /**
   * Gets true if has a Dependencia
   * @param value org.semanticwb.ecosikan.innova.Dependencia to verify
   * @return true if the org.semanticwb.ecosikan.innova.Dependencia exists, false otherwise
   */
    public boolean hasDependencia(org.semanticwb.ecosikan.innova.Dependencia value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasDependencia,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Dependencia
   * @param value org.semanticwb.ecosikan.innova.Dependencia to add
   */

    public void addDependencia(org.semanticwb.ecosikan.innova.Dependencia value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasDependencia, value.getSemanticObject());
    }
   /**
   * Removes all the Dependencia
   */

    public void removeAllDependencia()
    {
        getSemanticObject().removeProperty(ecoskn_hasDependencia);
    }
   /**
   * Removes a Dependencia
   * @param value org.semanticwb.ecosikan.innova.Dependencia to remove
   */

    public void removeDependencia(org.semanticwb.ecosikan.innova.Dependencia value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasDependencia,value.getSemanticObject());
    }

   /**
   * Gets the Dependencia
   * @return a org.semanticwb.ecosikan.innova.Dependencia
   */
    public org.semanticwb.ecosikan.innova.Dependencia getDependencia()
    {
         org.semanticwb.ecosikan.innova.Dependencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasDependencia);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Dependencia)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Resource
   * @param value Resource to set
   */

    public void setResource(org.semanticwb.model.Resource value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_semanticResourceInv, value.getSemanticObject());
        }else
        {
            removeResource();
        }
    }
   /**
   * Remove the value for Resource property
   */

    public void removeResource()
    {
        getSemanticObject().removeProperty(swb_semanticResourceInv);
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_semanticResourceInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }
}
