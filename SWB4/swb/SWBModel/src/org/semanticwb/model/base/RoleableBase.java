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
package org.semanticwb.model.base;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleableBase.
 */
public interface RoleableBase extends org.semanticwb.model.GenericObject
{
    
    /** The Constant swb_Role. */
    public static final org.semanticwb.platform.SemanticClass swb_Role=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Role");
    
    /** The Constant swb_hasRole. */
    public static final org.semanticwb.platform.SemanticProperty swb_hasRole=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasRole");
    
    /** The Constant swb_Roleable. */
    public static final org.semanticwb.platform.SemanticClass swb_Roleable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Roleable");

    /**
     * List roles.
     * 
     * @return the org.semanticwb.model. generic iterator
     */
    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Role> listRoles();
    
    /**
     * Checks for role.
     * 
     * @param role the role
     * @return true, if successful
     */
    public boolean hasRole(org.semanticwb.model.Role role);

    /**
     * Adds the role.
     * 
     * @param role the role
     */
    public void addRole(org.semanticwb.model.Role role);

    /**
     * Removes the all role.
     */
    public void removeAllRole();

    /**
     * Removes the role.
     * 
     * @param role the role
     */
    public void removeRole(org.semanticwb.model.Role role);

    /**
     * Gets the role.
     * 
     * @return the role
     */
    public org.semanticwb.model.Role getRole();
}
