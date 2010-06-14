/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.sieps.search;
import java.util.Map;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.IndexTerm;
import org.semanticwb.portal.indexer.parser.GenericParser;
import org.semanticwb.sieps.Empresa;

/**
 * IndexParser for Empresas.
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class EmpresaParser extends GenericParser {
    public static final String ATT_NAME = "name";

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Empresa";
    }

    @Override
    public String getType(Searchable gen) {
        return "Empresa";
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return "";
        //return ((Empresa)gen).getDescription(lang);
    }

    @Override
    public String getUrl(Searchable gen) {
        return "#";
    }

    @Override
    public String getPath(Searchable gen, String lang) {
        String ret = null;

        /*HashMap arg = new HashMap();
        arg.put("separator", " | ");
        arg.put("links", "false");
        arg.put("language", lang);
        WebPage page=((Empresa)gen).getWebPage();
        ret=page.getPath(arg);
        */
        return ret;
    }

    @Override
    public String getIndexDescription(Searchable gen) {
        //return ((Empresa)gen).getDescription();
        return "";
    }

    @Override
    public String getIndexTags(Searchable gen) {
        //return ((Empresa)gen).getTags();
        return "";
    }


    @Override
    public String getImage(Searchable gen) {
        Empresa emp = (Empresa)gen;
        return SWBPortal.getWebWorkPath() + emp.getWorkPath() + "/" + emp.getLogo();

    }

    private WebPage getWebPage(Searchable gen) {
        //return ((ServiceProvider)gen).getWebPage();
        return null;
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

    public String getName(Searchable gen) {
        return ((Empresa)gen).getName();
    }

    @Override
    public boolean canUserView(Searchable gen, User user) {
        boolean ret = super.canUserView(gen, user);//Verificar reglas y filtros de SWB
        return ret;
    }

    @Override
    public Map<String, IndexTerm> getIndexTerms(Searchable gen) {
        Map map = super.getIndexTerms(gen);
        map.put(ATT_NAME, new IndexTerm(ATT_NAME, getName(gen), false, IndexTerm.INDEXED_ANALYZED));
        return map;
    }
}