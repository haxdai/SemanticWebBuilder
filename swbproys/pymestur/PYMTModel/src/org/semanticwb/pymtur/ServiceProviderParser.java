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

import java.util.HashMap;
import java.util.Map;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Role;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.IndexTerm;
import org.semanticwb.portal.indexer.parser.GenericParser;
import org.semanticwb.pymtur.util.PymturUtils;

/**
 * Parser para el indexado de proveedores de servicios en el proyecto de
 * PyMEs turísticas.
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class ServiceProviderParser extends GenericParser {
    public static final String ATT_DESTINATION = "destination";

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        String ret = "#";
        ServiceProvider sp = (ServiceProvider)gen;
        WebPage wpFicha = sp.getWebPage().getWebSite().getWebPage("ficha");
        MicroSitePyme ms = sp.getMicroSitePymeInv();

        if (wpFicha != null && sp.getPymePaqueteType() > 1) {
            ret = "Ficha";
        } else if(sp.getPymePaqueteType() >= 3 && ms != null) {
            ret = "Página Web";
        } else if (sp.getDestination() != null) {
            ret = "Destino";
        }
        return ret;
    }

    @Override
    public String getType(Searchable gen) {
        return "ServiceProvider";
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((ServiceProvider)gen).getDescription(lang);
    }

    @Override
    public String getUrl(Searchable gen) {
        String ret = "#";

        ServiceProvider sp = (ServiceProvider)gen;
        WebPage wpFicha = sp.getWebPage().getWebSite().getWebPage("ficha");
        MicroSitePyme ms = sp.getMicroSitePymeInv();

        if (wpFicha != null && sp.getPymePaqueteType() > 1) {
            ret = wpFicha.getUrl() + "?uri=" + sp.getEncodedURI() + "&act=detail";//Ficha
        } else if(sp.getPymePaqueteType() >= 3 && ms != null) {
            ret = ms.getUrl();//Pagina web
        } else if (sp.getDestination() != null) {
            ret = sp.getDestination().getUrl();//Destino
        }
        return ret;
    }

    @Override
    public String getPath(Searchable gen, String lang) {
        String ret = null;

        HashMap arg = new HashMap();
        arg.put("separator", " | ");
        arg.put("links", "false");
        arg.put("language", lang);
        WebPage page=((ServiceProvider)gen).getWebPage();
        ret=page.getPath(arg);

        return ret;
    }

    @Override
    public String getIndexDescription(Searchable gen) {
        return ((ServiceProvider)gen).getDescription();
    }

    @Override
    public String getIndexTags(Searchable gen) {
        return ((ServiceProvider)gen).getTags();
    }


    @Override
    public String getImage(Searchable gen) {
        ServiceProvider sp = (ServiceProvider)gen;
        return SWBPortal.getWebWorkPath() + sp.getWorkPath() + "/" + sp.getPhotoLogo();

    }

    private WebPage getWebPage(Searchable gen) {
        return ((ServiceProvider)gen).getWebPage();
    }

    @Override
    public String getIndexCategory(Searchable gen)
    {
        String ret="";
        WebPage page = getWebPage(gen);
        if(page != null)
        {
            ret = super.getIndexCategory(page);
        }
        return ret;
    }

    public String getDestination(Searchable gen) {
        String ret = "";
        if (((ServiceProvider)gen).getDestination() != null) {
            ret = ((ServiceProvider)gen).getDestination().getTitle();
        }
        return ret;
    }

    @Override
    public boolean canUserView(Searchable gen, User user) {
        boolean ret = super.canUserView(gen, user);//Verificar reglas y filtros de SWB

        //Si está publicado todo mundo lo puede ver
        if (ret && ((ServiceProvider)gen).getSpStatus() != PymturUtils.ESTATUS_PUBLICADO) {
            //Si no, solo los administradores pueden:
            Role role = user.getUserRepository().getRole("adminProviders");
            if (!user.isRegistered() || (user.isRegistered() && user.isSigned())) {
                if (role != null && !user.hasRole(role)) {
                    ret = false;
                }
            }
        }
//        boolean isAdminProviders = false;
//        boolean isAccepted = false;
//
//        Role role = user.getUserRepository().getRole("adminProviders");
//        if (user.isRegistered() && user.isSigned()) {
//            if (role != null && user.hasRole(role)) {
//                isAdminProviders = true;
//            }
//        }
//
//        if (((ServiceProvider)gen).getSpStatus() == 2) {
//            isAccepted = true;
//        }
//        return super.canUserView(gen, user) && (isAccepted || isAdminProviders);
        return ret;
    }

    @Override
    public Map<String, IndexTerm> getIndexTerms(Searchable gen) {
        Map map = super.getIndexTerms(gen);
        map.put(ATT_DESTINATION, new IndexTerm(ATT_DESTINATION, getDestination(gen), false, IndexTerm.INDEXED_ANALYZED));
        return map;
    }    
}