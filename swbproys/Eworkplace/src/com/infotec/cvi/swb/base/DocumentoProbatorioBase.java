package com.infotec.cvi.swb.base;


   /**
   * Elemento utilizado para guardar los Documentos Probatorios que respalda la información del CV capturada por el usuario 
   */
public abstract class DocumentoProbatorioBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Iconable
{
   /**
   * Almacena el nombre del archivo electrónico PDF de la Justificación Técnica
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fileJustificacionTecnica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileJustificacionTecnica");
   /**
   * Almacena el nombre del archivo electrónico PDF del Acta de Matrimonio
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fileActaMatrimonio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileActaMatrimonio");
   /**
   * Almacena los nombres de los archivos electrónico PDF del Comprobante de los estudios
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasFilesComprobanteEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasFilesComprobanteEstudio");
   /**
   * Almacena el nombre del archivo electrónico PDF del Comprobante de domicilio
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fileComprobanteDomicilio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileComprobanteDomicilio");
   /**
   * Almacena los nombres de los archivos electrónicos PDF de las Identificaciones Oficialesl
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasFilesIdentificacionOficial=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasFilesIdentificacionOficial");
   /**
   * Almacena el nombre del archivo electrónico PDF del Comprobante del Número de Seguridad Social
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fileNumeroSeguridadSocial=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileNumeroSeguridadSocial");
   /**
   * Almacena el nombre del archivo electrónico PDF de la Carta de Depósito Bancario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fileCartaDepositoBancario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileCartaDepositoBancario");
   /**
   * Almacena los nombres de los archivos electrónico PDF de la copia de actas de nacimiento de los hijos
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasActasNacimientoFamiliares=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasActasNacimientoFamiliares");
   /**
   * Almacena el nombre del archivo electrónico PDF del Acta de Nacimiento
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fileActaNacimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileActaNacimiento");
   /**
   * Almacena el nombre del archivo electrónico PDF de la copia del RFC
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fileCopiaRFC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileCopiaRFC");
    public static final org.semanticwb.platform.SemanticProperty intranet_fileCartaProtesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileCartaProtesta");
   /**
   * Almacena el nombre del archivo electrónico PDF de una foto tamaño infantil de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fileFotoTamInfantil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileFotoTamInfantil");
   /**
   * Almacena el nombre del archivo electrónico PDF del CURP
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fileCURP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileCURP");
   /**
   * Elemento utilizado para guardar los Documentos Probatorios que respalda la información del CV capturada por el usuario
   */
    public static final org.semanticwb.platform.SemanticClass intranet_DocumentoProbatorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DocumentoProbatorio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DocumentoProbatorio");

    public static class ClassMgr
    {
       /**
       * Returns a list of DocumentoProbatorio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DocumentoProbatorio> listDocumentoProbatorios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DocumentoProbatorio>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.DocumentoProbatorio for all models
       * @return Iterator of com.infotec.cvi.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DocumentoProbatorio> listDocumentoProbatorios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DocumentoProbatorio>(it, true);
        }

        public static com.infotec.cvi.swb.DocumentoProbatorio createDocumentoProbatorio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.DocumentoProbatorio.ClassMgr.createDocumentoProbatorio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.DocumentoProbatorio
       * @param id Identifier for com.infotec.cvi.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.cvi.swb.DocumentoProbatorio
       * @return A com.infotec.cvi.swb.DocumentoProbatorio
       */
        public static com.infotec.cvi.swb.DocumentoProbatorio getDocumentoProbatorio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.DocumentoProbatorio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.DocumentoProbatorio
       * @param id Identifier for com.infotec.cvi.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.cvi.swb.DocumentoProbatorio
       * @return A com.infotec.cvi.swb.DocumentoProbatorio
       */
        public static com.infotec.cvi.swb.DocumentoProbatorio createDocumentoProbatorio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.DocumentoProbatorio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.DocumentoProbatorio
       * @param id Identifier for com.infotec.cvi.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.cvi.swb.DocumentoProbatorio
       */
        public static void removeDocumentoProbatorio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.DocumentoProbatorio
       * @param id Identifier for com.infotec.cvi.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.cvi.swb.DocumentoProbatorio
       * @return true if the com.infotec.cvi.swb.DocumentoProbatorio exists, false otherwise
       */

        public static boolean hasDocumentoProbatorio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDocumentoProbatorio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.DocumentoProbatorio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.DocumentoProbatorio
       * @return Iterator with all the com.infotec.cvi.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DocumentoProbatorio> listDocumentoProbatorioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DocumentoProbatorio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DocumentoProbatorio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DocumentoProbatorio> listDocumentoProbatorioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DocumentoProbatorio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DocumentoProbatorio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.DocumentoProbatorio
       * @return Iterator with all the com.infotec.cvi.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DocumentoProbatorio> listDocumentoProbatorioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DocumentoProbatorio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.DocumentoProbatorio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.DocumentoProbatorio
       */

        public static java.util.Iterator<com.infotec.cvi.swb.DocumentoProbatorio> listDocumentoProbatorioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.DocumentoProbatorio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a DocumentoProbatorioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the DocumentoProbatorio
   */
    public DocumentoProbatorioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FileJustificacionTecnica property
* @return String with the FileJustificacionTecnica
*/
    public String getFileJustificacionTecnica()
    {
        return getSemanticObject().getProperty(intranet_fileJustificacionTecnica);
    }

/**
* Sets the FileJustificacionTecnica property
* @param value long with the FileJustificacionTecnica
*/
    public void setFileJustificacionTecnica(String value)
    {
        getSemanticObject().setProperty(intranet_fileJustificacionTecnica, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

/**
* Gets the FileActaMatrimonio property
* @return String with the FileActaMatrimonio
*/
    public String getFileActaMatrimonio()
    {
        return getSemanticObject().getProperty(intranet_fileActaMatrimonio);
    }

/**
* Sets the FileActaMatrimonio property
* @param value long with the FileActaMatrimonio
*/
    public void setFileActaMatrimonio(String value)
    {
        getSemanticObject().setProperty(intranet_fileActaMatrimonio, value);
    }

    public java.util.Iterator<String> listFilesComprobanteEstudios()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(intranet_hasFilesComprobanteEstudio);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addFilesComprobanteEstudio(String value)
    {
        getSemanticObject().addLiteralProperty(intranet_hasFilesComprobanteEstudio, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllFilesComprobanteEstudio()
    {
        getSemanticObject().removeProperty(intranet_hasFilesComprobanteEstudio);
    }

    public void removeFilesComprobanteEstudio(String value)
    {
        getSemanticObject().removeLiteralProperty(intranet_hasFilesComprobanteEstudio,new org.semanticwb.platform.SemanticLiteral(value));
    }

/**
* Gets the IconClass property
* @return String with the IconClass
*/
    public String getIconClass()
    {
        return getSemanticObject().getProperty(swb_iconClass);
    }

/**
* Sets the IconClass property
* @param value long with the IconClass
*/
    public void setIconClass(String value)
    {
        getSemanticObject().setProperty(swb_iconClass, value);
    }

/**
* Gets the FileComprobanteDomicilio property
* @return String with the FileComprobanteDomicilio
*/
    public String getFileComprobanteDomicilio()
    {
        return getSemanticObject().getProperty(intranet_fileComprobanteDomicilio);
    }

/**
* Sets the FileComprobanteDomicilio property
* @param value long with the FileComprobanteDomicilio
*/
    public void setFileComprobanteDomicilio(String value)
    {
        getSemanticObject().setProperty(intranet_fileComprobanteDomicilio, value);
    }

    public java.util.Iterator<String> listFilesIdentificacionOficials()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(intranet_hasFilesIdentificacionOficial);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addFilesIdentificacionOficial(String value)
    {
        getSemanticObject().addLiteralProperty(intranet_hasFilesIdentificacionOficial, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllFilesIdentificacionOficial()
    {
        getSemanticObject().removeProperty(intranet_hasFilesIdentificacionOficial);
    }

    public void removeFilesIdentificacionOficial(String value)
    {
        getSemanticObject().removeLiteralProperty(intranet_hasFilesIdentificacionOficial,new org.semanticwb.platform.SemanticLiteral(value));
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

/**
* Gets the FileNumeroSeguridadSocial property
* @return String with the FileNumeroSeguridadSocial
*/
    public String getFileNumeroSeguridadSocial()
    {
        return getSemanticObject().getProperty(intranet_fileNumeroSeguridadSocial);
    }

/**
* Sets the FileNumeroSeguridadSocial property
* @param value long with the FileNumeroSeguridadSocial
*/
    public void setFileNumeroSeguridadSocial(String value)
    {
        getSemanticObject().setProperty(intranet_fileNumeroSeguridadSocial, value);
    }

/**
* Gets the FileCartaDepositoBancario property
* @return String with the FileCartaDepositoBancario
*/
    public String getFileCartaDepositoBancario()
    {
        return getSemanticObject().getProperty(intranet_fileCartaDepositoBancario);
    }

/**
* Sets the FileCartaDepositoBancario property
* @param value long with the FileCartaDepositoBancario
*/
    public void setFileCartaDepositoBancario(String value)
    {
        getSemanticObject().setProperty(intranet_fileCartaDepositoBancario, value);
    }

    public java.util.Iterator<String> listActasNacimientoFamiliareses()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(intranet_hasActasNacimientoFamiliares);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addActasNacimientoFamiliares(String value)
    {
        getSemanticObject().addLiteralProperty(intranet_hasActasNacimientoFamiliares, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllActasNacimientoFamiliares()
    {
        getSemanticObject().removeProperty(intranet_hasActasNacimientoFamiliares);
    }

    public void removeActasNacimientoFamiliares(String value)
    {
        getSemanticObject().removeLiteralProperty(intranet_hasActasNacimientoFamiliares,new org.semanticwb.platform.SemanticLiteral(value));
    }

/**
* Gets the FileActaNacimiento property
* @return String with the FileActaNacimiento
*/
    public String getFileActaNacimiento()
    {
        return getSemanticObject().getProperty(intranet_fileActaNacimiento);
    }

/**
* Sets the FileActaNacimiento property
* @param value long with the FileActaNacimiento
*/
    public void setFileActaNacimiento(String value)
    {
        getSemanticObject().setProperty(intranet_fileActaNacimiento, value);
    }

/**
* Gets the FileCopiaRFC property
* @return String with the FileCopiaRFC
*/
    public String getFileCopiaRFC()
    {
        return getSemanticObject().getProperty(intranet_fileCopiaRFC);
    }

/**
* Sets the FileCopiaRFC property
* @param value long with the FileCopiaRFC
*/
    public void setFileCopiaRFC(String value)
    {
        getSemanticObject().setProperty(intranet_fileCopiaRFC, value);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FileCartaProtesta property
* @return String with the FileCartaProtesta
*/
    public String getFileCartaProtesta()
    {
        return getSemanticObject().getProperty(intranet_fileCartaProtesta);
    }

/**
* Sets the FileCartaProtesta property
* @param value long with the FileCartaProtesta
*/
    public void setFileCartaProtesta(String value)
    {
        getSemanticObject().setProperty(intranet_fileCartaProtesta, value);
    }

/**
* Gets the FileFotoTamInfantil property
* @return String with the FileFotoTamInfantil
*/
    public String getFileFotoTamInfantil()
    {
        return getSemanticObject().getProperty(intranet_fileFotoTamInfantil);
    }

/**
* Sets the FileFotoTamInfantil property
* @param value long with the FileFotoTamInfantil
*/
    public void setFileFotoTamInfantil(String value)
    {
        getSemanticObject().setProperty(intranet_fileFotoTamInfantil, value);
    }

/**
* Gets the FileCURP property
* @return String with the FileCURP
*/
    public String getFileCURP()
    {
        return getSemanticObject().getProperty(intranet_fileCURP);
    }

/**
* Sets the FileCURP property
* @param value long with the FileCURP
*/
    public void setFileCURP(String value)
    {
        getSemanticObject().setProperty(intranet_fileCURP, value);
    }
}
