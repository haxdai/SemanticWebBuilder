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
 
package org.semanticwb.model.comm.base;


// TODO: Auto-generated Javadoc
/**
 * The Class CompanySiteBase.
 */
public class CompanySiteBase extends org.semanticwb.model.comm.MicroSite implements org.semanticwb.model.Referensable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Undeleteable,org.semanticwb.model.RoleRefable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Rankable,org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Trashable,org.semanticwb.model.Activeable,org.semanticwb.model.Viewable,org.semanticwb.model.Resourceable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Filterable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Indexable
{
    
    /** The Constant swbcomm_CompanySite. */
    public static final org.semanticwb.platform.SemanticClass swbcomm_CompanySite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#CompanySite");
    
    /** The Constant sclass. */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#CompanySite");

    /**
     * Instantiates a new company site base.
     * 
     * @param base the base
     */
    public CompanySiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /**
     * List company sites.
     * 
     * @param model the model
     * @return the java.util. iterator
     */
    public static java.util.Iterator<org.semanticwb.model.comm.CompanySite> listCompanySites(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.comm.CompanySite>(it, true);
    }

    /**
     * List company sites.
     * 
     * @return the java.util. iterator
     */
    public static java.util.Iterator<org.semanticwb.model.comm.CompanySite> listCompanySites()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.comm.CompanySite>(it, true);
    }

    /**
     * Gets the company site.
     * 
     * @param id the id
     * @param model the model
     * @return the company site
     */
    public static org.semanticwb.model.comm.CompanySite getCompanySite(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.comm.CompanySite)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    /**
     * Creates the company site.
     * 
     * @param id the id
     * @param model the model
     * @return the org.semanticwb.model.comm. company site
     */
    public static org.semanticwb.model.comm.CompanySite createCompanySite(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.comm.CompanySite)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    /**
     * Removes the company site.
     * 
     * @param id the id
     * @param model the model
     */
    public static void removeCompanySite(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    /**
     * Checks for company site.
     * 
     * @param id the id
     * @param model the model
     * @return true, if successful
     */
    public static boolean hasCompanySite(String id, org.semanticwb.model.SWBModel model)
    {
        return (getCompanySite(id, model)!=null);
    }
}
