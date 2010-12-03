package org.semanticwb.ecosikan.innova.base;


public abstract class ThemeManagerBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Theme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Theme");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_hasThemes=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#hasThemes");
    public static final org.semanticwb.platform.SemanticClass ecoskn_ThemeManager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#ThemeManager");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#ThemeManager");

    public ThemeManagerBase()
    {
    }

   /**
   * Constructs a ThemeManagerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ThemeManager
   */
    public ThemeManagerBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   /**
   * Gets all the org.semanticwb.ecosikan.innova.Theme
   * @return A GenericIterator with all the org.semanticwb.ecosikan.innova.Theme
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme> listThemeses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Theme>(getSemanticObject().listObjectProperties(ecoskn_hasThemes));
    }

   /**
   * Gets true if has a Themes
   * @param value org.semanticwb.ecosikan.innova.Theme to verify
   * @return true if the org.semanticwb.ecosikan.innova.Theme exists, false otherwise
   */
    public boolean hasThemes(org.semanticwb.ecosikan.innova.Theme value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ecoskn_hasThemes,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Themes
   * @param value org.semanticwb.ecosikan.innova.Theme to add
   */

    public void addThemes(org.semanticwb.ecosikan.innova.Theme value)
    {
        getSemanticObject().addObjectProperty(ecoskn_hasThemes, value.getSemanticObject());
    }
   /**
   * Removes all the Themes
   */

    public void removeAllThemes()
    {
        getSemanticObject().removeProperty(ecoskn_hasThemes);
    }
   /**
   * Removes a Themes
   * @param value org.semanticwb.ecosikan.innova.Theme to remove
   */

    public void removeThemes(org.semanticwb.ecosikan.innova.Theme value)
    {
        getSemanticObject().removeObjectProperty(ecoskn_hasThemes,value.getSemanticObject());
    }

   /**
   * Gets the Themes
   * @return a org.semanticwb.ecosikan.innova.Theme
   */
    public org.semanticwb.ecosikan.innova.Theme getThemes()
    {
         org.semanticwb.ecosikan.innova.Theme ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_hasThemes);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Theme)obj.createGenericInstance();
         }
         return ret;
    }
}
