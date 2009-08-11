/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 
package org.semanticwb.repository.office.base;


public class OfficeContentBase extends org.semanticwb.repository.File implements org.semanticwb.repository.office.Descriptiveable,org.semanticwb.repository.Lockable,org.semanticwb.repository.Traceable,org.semanticwb.repository.Referenceable
{
    public static final org.semanticwb.platform.SemanticProperty swboffice_title=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#title");
    public static final org.semanticwb.platform.SemanticProperty swboffice_officetype=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#officetype");
    public static final org.semanticwb.platform.SemanticProperty jcr_uuid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.jcp.org/jcr/1.0#uuid");
    public static final org.semanticwb.platform.SemanticProperty swboffice_lastModified=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#lastModified");
    public static final org.semanticwb.platform.SemanticProperty jcr_lockIsDeep=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.jcp.org/jcr/1.0#lockIsDeep");
    public static final org.semanticwb.platform.SemanticProperty jcr_lockOwner=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.jcp.org/jcr/1.0#lockOwner");
    public static final org.semanticwb.platform.SemanticProperty swboffice_description=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/office#description");
    public static final org.semanticwb.platform.SemanticClass swboffice_OfficeContent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/office#OfficeContent");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/office#OfficeContent");

    public OfficeContentBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.repository.office.OfficeContent> listOfficeContents(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.repository.office.OfficeContent>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.repository.office.OfficeContent> listOfficeContents()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.repository.office.OfficeContent>(it, true);
    }

    public static org.semanticwb.repository.office.OfficeContent getOfficeContent(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.repository.office.OfficeContent)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.repository.office.OfficeContent createOfficeContent(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.repository.office.OfficeContent)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeOfficeContent(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasOfficeContent(String id, org.semanticwb.model.SWBModel model)
    {
        return (getOfficeContent(id, model)!=null);
    }

    public String getTitle()
    {
        return getSemanticObject().getProperty(swboffice_title);
    }

    public void setTitle(String title)
    {
        getSemanticObject().setProperty(swboffice_title, title);
    }

    public String getOfficetype()
    {
        return getSemanticObject().getProperty(swboffice_officetype);
    }

    public void setOfficetype(String officetype)
    {
        getSemanticObject().setProperty(swboffice_officetype, officetype);
    }

    public String getUuid()
    {
        return getSemanticObject().getProperty(jcr_uuid);
    }

    public void setUuid(String uuid)
    {
        getSemanticObject().setProperty(jcr_uuid, uuid);
    }

    public java.util.Date getLastModified()
    {
        return getSemanticObject().getDateProperty(swboffice_lastModified);
    }

    public void setLastModified(java.util.Date lastModified)
    {
        getSemanticObject().setDateProperty(swboffice_lastModified, lastModified);
    }

    public boolean isLockIsDeep()
    {
        return getSemanticObject().getBooleanProperty(jcr_lockIsDeep);
    }

    public void setLockIsDeep(boolean lockIsDeep)
    {
        getSemanticObject().setBooleanProperty(jcr_lockIsDeep, lockIsDeep);
    }

    public String getLockOwner()
    {
        return getSemanticObject().getProperty(jcr_lockOwner);
    }

    public void setLockOwner(String lockOwner)
    {
        getSemanticObject().setProperty(jcr_lockOwner, lockOwner);
    }

    public String getDescription()
    {
        return getSemanticObject().getProperty(swboffice_description);
    }

    public void setDescription(String description)
    {
        getSemanticObject().setProperty(swboffice_description, description);
    }
}
