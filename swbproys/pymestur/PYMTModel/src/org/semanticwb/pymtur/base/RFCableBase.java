package org.semanticwb.pymtur.base;


public abstract class RFCableBase extends org.semanticwb.model.base.GenericObjectBase 
{
       public static final org.semanticwb.platform.SemanticClass pymtur_RfcType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RfcType");
       public static final org.semanticwb.platform.SemanticProperty pymtur_rfcType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcType");
       public static final org.semanticwb.platform.SemanticProperty pymtur_codigo_postal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#codigo_postal");
       public static final org.semanticwb.platform.SemanticProperty pymtur_rfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfc");
       public static final org.semanticwb.platform.SemanticProperty pymtur_numero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#numero");
       public static final org.semanticwb.platform.SemanticProperty pymtur_nombre_o_razon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#nombre_o_razon");
       public static final org.semanticwb.platform.SemanticProperty pymtur_calle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#calle");
       public static final org.semanticwb.platform.SemanticProperty pymtur_colonia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#colonia");
       public static final org.semanticwb.platform.SemanticProperty pymtur_ciudad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#ciudad");
       public static final org.semanticwb.platform.SemanticClass pymtur_RFCable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RFCable");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RFCable");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.pymtur.RFCable> listRFCables(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RFCable>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.pymtur.RFCable> listRFCables()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RFCable>(it, true);
       }

       public static org.semanticwb.pymtur.RFCable getRFCable(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.RFCable)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.pymtur.RFCable createRFCable(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.RFCable)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeRFCable(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasRFCable(String id, org.semanticwb.model.SWBModel model)
       {
           return (getRFCable(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.pymtur.RFCable> listRFCableByRfcType(org.semanticwb.pymtur.RfcType rfctype,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RFCable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_rfcType, rfctype.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.RFCable> listRFCableByRfcType(org.semanticwb.pymtur.RfcType rfctype)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RFCable> it=new org.semanticwb.model.GenericIterator(rfctype.getSemanticObject().getModel().listSubjects(pymtur_rfcType,rfctype.getSemanticObject()));
       return it;
   }
    }

    public RFCableBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setRfcType(org.semanticwb.pymtur.RfcType value)
    {
        getSemanticObject().setObjectProperty(pymtur_rfcType, value.getSemanticObject());
    }

    public void removeRfcType()
    {
        getSemanticObject().removeProperty(pymtur_rfcType);
    }


    public org.semanticwb.pymtur.RfcType getRfcType()
    {
         org.semanticwb.pymtur.RfcType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_rfcType);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.RfcType)obj.createGenericInstance();
         }
         return ret;
    }

    public String getCodigo_postal()
    {
        return getSemanticObject().getProperty(pymtur_codigo_postal);
    }

    public void setCodigo_postal(String value)
    {
        getSemanticObject().setProperty(pymtur_codigo_postal, value);
    }

    public String getRfc()
    {
        return getSemanticObject().getProperty(pymtur_rfc);
    }

    public void setRfc(String value)
    {
        getSemanticObject().setProperty(pymtur_rfc, value);
    }

    public String getNumero()
    {
        return getSemanticObject().getProperty(pymtur_numero);
    }

    public void setNumero(String value)
    {
        getSemanticObject().setProperty(pymtur_numero, value);
    }

    public String getNombre_o_razon()
    {
        return getSemanticObject().getProperty(pymtur_nombre_o_razon);
    }

    public void setNombre_o_razon(String value)
    {
        getSemanticObject().setProperty(pymtur_nombre_o_razon, value);
    }

    public String getCalle()
    {
        return getSemanticObject().getProperty(pymtur_calle);
    }

    public void setCalle(String value)
    {
        getSemanticObject().setProperty(pymtur_calle, value);
    }

    public String getColonia()
    {
        return getSemanticObject().getProperty(pymtur_colonia);
    }

    public void setColonia(String value)
    {
        getSemanticObject().setProperty(pymtur_colonia, value);
    }

    public String getCiudad()
    {
        return getSemanticObject().getProperty(pymtur_ciudad);
    }

    public void setCiudad(String value)
    {
        getSemanticObject().setProperty(pymtur_ciudad, value);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
