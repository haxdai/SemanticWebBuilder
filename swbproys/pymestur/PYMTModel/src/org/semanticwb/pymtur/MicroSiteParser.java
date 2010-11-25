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

package org.semanticwb.pymtur;

import org.semanticwb.model.Role;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.User;
import org.semanticwb.portal.indexer.parser.GenericParser;
import org.semanticwb.portal.indexer.parser.WebPageParser;
import org.semanticwb.pymtur.util.PymturUtils;

/**
 * Parser for {@link Searchable} MicroSites.
 * <p>
 * Parser para MicroSitios de tipo {@link Searchable}.
 * @see org.semanticwb.portal.indexer.parser.GenericParser
 *
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class MicroSiteParser extends WebPageParser {    
    @Override
    public String getType(Searchable gen) {
        return "WebPage";  // antes:MicroSite
    }

    @Override
    public boolean canUserView(Searchable gen, User user) {
        boolean ret = super.canUserView(gen, user);

        //Si está publicado se puede presentar en el buscador
        if (ret && ((MicroSitePyme) gen).getServiceProvider().getSpStatus() != PymturUtils.ESTATUS_PUBLICADO) {
            //Si no, solo los administradores pueden verlo
            Role role = user.getUserRepository().getRole("adminProviders");
            if (!user.isRegistered() || (user.isRegistered() && user.isSigned())) {
                if (role != null && !user.hasRole(role)) {
                    ret = false;
                }
            }
        }
        return ret;
    }


}