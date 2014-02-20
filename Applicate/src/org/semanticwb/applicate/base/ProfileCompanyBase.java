package org.semanticwb.applicate.base;


public abstract class ProfileCompanyBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty app_antiguedad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#antiguedad");
    public static final org.semanticwb.platform.SemanticProperty app_imagenCompany=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#imagenCompany");
    public static final org.semanticwb.platform.SemanticProperty app_numeroEmpleados=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#numeroEmpleados");
    public static final org.semanticwb.platform.SemanticProperty app_nombreEmpresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#nombreEmpresa");
    public static final org.semanticwb.platform.SemanticProperty app_giroActividad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#giroActividad");
    public static final org.semanticwb.platform.SemanticProperty app_hasProductosServicios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#hasProductosServicios");
    public static final org.semanticwb.platform.SemanticClass app_ProfileCompany=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#ProfileCompany");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#ProfileCompany");

    public static class ClassMgr
    {
       /**
       * Returns a list of ProfileCompany for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.applicate.ProfileCompany
       */

        public static java.util.Iterator<org.semanticwb.applicate.ProfileCompany> listProfileCompanies(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.ProfileCompany>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.applicate.ProfileCompany for all models
       * @return Iterator of org.semanticwb.applicate.ProfileCompany
       */

        public static java.util.Iterator<org.semanticwb.applicate.ProfileCompany> listProfileCompanies()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.ProfileCompany>(it, true);
        }

        public static org.semanticwb.applicate.ProfileCompany createProfileCompany(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.applicate.ProfileCompany.ClassMgr.createProfileCompany(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.applicate.ProfileCompany
       * @param id Identifier for org.semanticwb.applicate.ProfileCompany
       * @param model Model of the org.semanticwb.applicate.ProfileCompany
       * @return A org.semanticwb.applicate.ProfileCompany
       */
        public static org.semanticwb.applicate.ProfileCompany getProfileCompany(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.ProfileCompany)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.applicate.ProfileCompany
       * @param id Identifier for org.semanticwb.applicate.ProfileCompany
       * @param model Model of the org.semanticwb.applicate.ProfileCompany
       * @return A org.semanticwb.applicate.ProfileCompany
       */
        public static org.semanticwb.applicate.ProfileCompany createProfileCompany(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.ProfileCompany)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.applicate.ProfileCompany
       * @param id Identifier for org.semanticwb.applicate.ProfileCompany
       * @param model Model of the org.semanticwb.applicate.ProfileCompany
       */
        public static void removeProfileCompany(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.applicate.ProfileCompany
       * @param id Identifier for org.semanticwb.applicate.ProfileCompany
       * @param model Model of the org.semanticwb.applicate.ProfileCompany
       * @return true if the org.semanticwb.applicate.ProfileCompany exists, false otherwise
       */

        public static boolean hasProfileCompany(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProfileCompany(id, model)!=null);
        }
    }

    public static ProfileCompanyBase.ClassMgr getProfileCompanyClassMgr()
    {
        return new ProfileCompanyBase.ClassMgr();
    }

   /**
   * Constructs a ProfileCompanyBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ProfileCompany
   */
    public ProfileCompanyBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Antiguedad property
* @return String with the Antiguedad
*/
    public String getAntiguedad()
    {
        return getSemanticObject().getProperty(app_antiguedad);
    }

/**
* Sets the Antiguedad property
* @param value long with the Antiguedad
*/
    public void setAntiguedad(String value)
    {
        getSemanticObject().setProperty(app_antiguedad, value);
    }

/**
* Gets the ImagenCompany property
* @return String with the ImagenCompany
*/
    public String getImagenCompany()
    {
        return getSemanticObject().getProperty(app_imagenCompany);
    }

/**
* Sets the ImagenCompany property
* @param value long with the ImagenCompany
*/
    public void setImagenCompany(String value)
    {
        getSemanticObject().setProperty(app_imagenCompany, value);
    }

/**
* Gets the NumeroEmpleados property
* @return int with the NumeroEmpleados
*/
    public int getNumeroEmpleados()
    {
        return getSemanticObject().getIntProperty(app_numeroEmpleados);
    }

/**
* Sets the NumeroEmpleados property
* @param value long with the NumeroEmpleados
*/
    public void setNumeroEmpleados(int value)
    {
        getSemanticObject().setIntProperty(app_numeroEmpleados, value);
    }

/**
* Gets the NombreEmpresa property
* @return String with the NombreEmpresa
*/
    public String getNombreEmpresa()
    {
        return getSemanticObject().getProperty(app_nombreEmpresa);
    }

/**
* Sets the NombreEmpresa property
* @param value long with the NombreEmpresa
*/
    public void setNombreEmpresa(String value)
    {
        getSemanticObject().setProperty(app_nombreEmpresa, value);
    }

/**
* Gets the GiroActividad property
* @return String with the GiroActividad
*/
    public String getGiroActividad()
    {
        return getSemanticObject().getProperty(app_giroActividad);
    }

/**
* Sets the GiroActividad property
* @param value long with the GiroActividad
*/
    public void setGiroActividad(String value)
    {
        getSemanticObject().setProperty(app_giroActividad, value);
    }

    public java.util.Iterator<String> listProductosServicioses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(app_hasProductosServicios);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addProductosServicios(String value)
    {
        getSemanticObject().addLiteralProperty(app_hasProductosServicios, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllProductosServicios()
    {
        getSemanticObject().removeProperty(app_hasProductosServicios);
    }

    public void removeProductosServicios(String value)
    {
        getSemanticObject().removeLiteralProperty(app_hasProductosServicios,new org.semanticwb.platform.SemanticLiteral(value));
    }
}
