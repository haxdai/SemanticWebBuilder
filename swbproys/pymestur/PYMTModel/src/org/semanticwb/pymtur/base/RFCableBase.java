package org.semanticwb.pymtur.base;


public abstract class RFCableBase extends org.semanticwb.model.base.GenericObjectBase 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_domiciliofis=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#domiciliofis");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfc");
    public static final org.semanticwb.platform.SemanticProperty pymtur_nombre_o_razon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#nombre_o_razon");
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
    }

    public RFCableBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getRfcType()
    {
        return getSemanticObject().getProperty(pymtur_rfcType);
    }

    public void setRfcType(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcType, value);
    }

    public String getDomiciliofis()
    {
        return getSemanticObject().getProperty(pymtur_domiciliofis);
    }

    public void setDomiciliofis(String value)
    {
        getSemanticObject().setProperty(pymtur_domiciliofis, value);
    }

    public String getRfc()
    {
        return getSemanticObject().getProperty(pymtur_rfc);
    }

    public void setRfc(String value)
    {
        getSemanticObject().setProperty(pymtur_rfc, value);
    }

    public String getNombre_o_razon()
    {
        return getSemanticObject().getProperty(pymtur_nombre_o_razon);
    }

    public void setNombre_o_razon(String value)
    {
        getSemanticObject().setProperty(pymtur_nombre_o_razon, value);
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
