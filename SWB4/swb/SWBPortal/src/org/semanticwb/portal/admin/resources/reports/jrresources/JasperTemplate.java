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
 

package org.semanticwb.portal.admin.resources.reports.jrresources;

public enum JasperTemplate {
    RES_APPEARED("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/AppearedResRep.jasper"),
    RES_APPEARED_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/AppearedResHtmlRep.jasper"),
    GLOBAL_DAILY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/GlobalDailyRep.jasper"),
    GLOBAL_DAILY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/GlobalDailyGraphRep.jasper"),
    GLOBAL_DAILY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/GlobalDailyHtmlRep.jasper"),
    GLOBAL_MONTHLY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/GlobalRep.jasper"),
    GLOBAL_MONTHLY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/GlobalGraphRep.jasper"),
    GLOBAL_MONTHLY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/GlobalHtmlRep.jasper"),
    DEVICE_DAILY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/DevicesDailyRep.jasper"),
    DEVICE_DAILY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/DevicesDailyGraphRep.jasper"),
    DEVICE_DAILY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/DevicesDailyHtmlRep.jasper"),
    DEVICE_MONTHLY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/DevicesRep.jasper"),
    DEVICE_MONTHLY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/DevicesGraphRep.jasper"),
    DEVICE_MONTHLY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/DevicesHtmlRep.jasper"),
    LANGUAGE_DAILY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/LanguageDailyRep.jasper"),
    LANGUAGE_DAILY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/LanguageDailyGraphRep.jasper"),
    LANGUAGE_DAILY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/LanguageDailyHtmlRep.jasper"),
    LANGUAGE_MONTHLY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/LanguagesRep.jasper"),
    LANGUAGE_MONTHLY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/LanguagesGraphRep.jasper"),
    LANGUAGE_MONTHLY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/LanguagesHtmlRep.jasper"),
    LOGGED_UNIQUE_DAILY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UniqueUsersDailyRep.jasper"),
    LOGGED_UNIQUE_DAILY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UniqueUsersDailyGraphRep.jasper"),
    LOGGED_UNIQUE_DAILY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UniqueUsersDailyHtmlRep.jasper"),
    LOGGED_UNIQUE_MONTHLY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UniqueUsersRep.jasper"),
    LOGGED_UNIQUE_MONTHLY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UniqueUsersGraphRep.jasper"),
    LOGGED_UNIQUE_MONTHLY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UniqueUsersHtmlRep.jasper"),
    USER_LOGGED_DAILY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UsersDailyRep.jasper"),
    USER_LOGGED_DAILY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UsersDailyGraphRep.jasper"),
    USER_LOGGED_DAILY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UsersDailyHtmlRep.jasper"),
    USER_LOGGED_MONTHLY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UsersRep.jasper"),
    USER_LOGGED_MONTHLY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UsersGraphRep.jasper"),
    USER_LOGGED_MONTHLY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UsersHtmlRep.jasper"),
    SECTION_DAILY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SectionsDailyRep.jasper"),
    SECTION_DAILY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SectionsDailyGraphRep.jasper"),
    SECTION_DAILY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SectionsDailyHtmlRep.jasper"),
    SECTION_MONTHLY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SectionsRep.jasper"),
    SECTION_MONTHLY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SectionsGraphRep.jasper"),
    SECTION_MONTHLY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SectionsHtmlRep.jasper"),    
    RESOURCE_DAILY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/ResourcesDailyRep.jasper"),
    RESOURCE_DAILY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/ResourcesDailyGraphRep.jasper"),
    RESOURCE_DAILY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/ResourcesDailyHtmlRep.jasper"),
    RESOURCE_MONTHLY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/ResourcesRep.jasper"),
    RESOURCE_MONTHLY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/ResourcesGraphRep.jasper"),
    RESOURCE_MONTHLY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/ResourcesHtmlRep.jasper"),    
    SESSION_DAILY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SessionsDailyRep.jasper"),
    SESSION_DAILY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SessionsDailyGraphRep.jasper"),
    SESSION_DAILY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SessionsDailyHtmlRep.jasper"),
    SESSION_MONTHLY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SessionsRep.jasper"),
    SESSION_MONTHLY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SessionsGraphRep.jasper"),
    SESSION_MONTHLY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/SessionsHtmlRep.jasper"),
    USER_TYPES_DAILY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UserTypesDailyRep.jasper"),
    USER_TYPES_DAILY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UserTypesDailyGraphRep.jasper"),
    USER_TYPES_DAILY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UserTypesDailyHtmlRep.jasper"),
    USER_TYPES_MONTHLY("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UserTypesRep.jasper"),
    USER_TYPES_MONTHLY_GRAPH("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UserTypesGraphRep.jasper"),
    USER_TYPES_MONTHLY_HTML("/org/semanticwb/portal/admin/resources/reports/jrresources/templates/UserTypesHtmlRep.jasper");
    
    private final String jasperFileName;
    
    JasperTemplate(String jasperFileName){
        this.jasperFileName = jasperFileName;
    }   
    
    public String getTemplatePath() {
        return jasperFileName;
    }
}
