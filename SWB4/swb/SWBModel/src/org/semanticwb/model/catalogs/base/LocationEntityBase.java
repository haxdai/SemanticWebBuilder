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
 
package org.semanticwb.model.catalogs.base;


public class LocationEntityBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Hiddenable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Filterable,org.semanticwb.model.Rankable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Expirable,org.semanticwb.model.catalogs.GeoTaggable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Trashable,org.semanticwb.model.Referensable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Indexable,org.semanticwb.model.Viewable
{
    public static final org.semanticwb.platform.SemanticClass swbc_LocationEntity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwb.org/swbcatalogs#LocationEntity");
    public static final org.semanticwb.platform.SemanticProperty swbc_belongsTo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwb.org/swbcatalogs#belongsTo");
    public static final org.semanticwb.platform.SemanticProperty swbc_longitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwb.org/swbcatalogs#longitud");
    public static final org.semanticwb.platform.SemanticProperty swbc_latitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwb.org/swbcatalogs#latitud");
    public static final org.semanticwb.platform.SemanticProperty swbc_name=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwb.org/swbcatalogs#name");
    public static final org.semanticwb.platform.SemanticProperty swbc_hasLocation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwb.org/swbcatalogs#hasLocation");
    public static final org.semanticwb.platform.SemanticProperty swbc_altitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwb.org/swbcatalogs#altitud");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwb.org/swbcatalogs#LocationEntity");

    public LocationEntityBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.catalogs.LocationEntity> listLocationEntitys(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.catalogs.LocationEntity>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.catalogs.LocationEntity> listLocationEntitys()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.catalogs.LocationEntity>(it, true);
    }

    public static org.semanticwb.model.catalogs.LocationEntity getLocationEntity(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.catalogs.LocationEntity)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.catalogs.LocationEntity createLocationEntity(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.catalogs.LocationEntity)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeLocationEntity(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasLocationEntity(String id, org.semanticwb.model.SWBModel model)
    {
        return (getLocationEntity(id, model)!=null);
    }

    public String getLongitud()
    {
        return getSemanticObject().getProperty(swbc_longitud);
    }

    public void setLongitud(String longitud)
    {
        getSemanticObject().setProperty(swbc_longitud, longitud);
    }

    public String getLatitud()
    {
        return getSemanticObject().getProperty(swbc_latitud);
    }

    public void setLatitud(String latitud)
    {
        getSemanticObject().setProperty(swbc_latitud, latitud);
    }

    public String getName()
    {
        return getSemanticObject().getProperty(swbc_name);
    }

    public void setName(String name)
    {
        getSemanticObject().setProperty(swbc_name, name);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.catalogs.LocationEntity> listLocations()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.catalogs.LocationEntity>(getSemanticObject().listObjectProperties(swbc_hasLocation));
    }

    public boolean hasLocation(org.semanticwb.model.catalogs.LocationEntity locationentity)
    {
        if(locationentity==null)return false;
        return getSemanticObject().hasObjectProperty(swbc_hasLocation,locationentity.getSemanticObject());
    }

    public org.semanticwb.model.catalogs.LocationEntity getLocation()
    {
         org.semanticwb.model.catalogs.LocationEntity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbc_hasLocation);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.catalogs.LocationEntity)obj.createGenericInstance();
         }
         return ret;
    }

    public String getAltitud()
    {
        return getSemanticObject().getProperty(swbc_altitud);
    }

    public void setAltitud(String altitud)
    {
        getSemanticObject().setProperty(swbc_altitud, altitud);
    }
}
