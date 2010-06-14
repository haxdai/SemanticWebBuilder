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
import org.semanticwb.sieps.Producto;

/**
 * IndexParser for Productos.
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class ProductoParser extends GenericParser {
public static final String ATT_NAME = "name";

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Producto";
    }

    @Override
    public String getType(Searchable gen) {
        return "Producto";
    }

    @Override
    public String getSummary(Searchable gen, String lang) {
        return ((Producto)gen).getDescription(lang);
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
        return ((Producto)gen).getDescription();
    }

    @Override
    public String getIndexTags(Searchable gen) {
        //return ((Producto)gen).getTags();
        return "";
    }

    @Override
    public String getImage(Searchable gen) {
        Producto prod = (Producto)gen;
        return SWBPortal.getWebWorkPath() + prod.getWorkPath() + "/" + prod.getFoto();
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
        return ((Producto)gen).getPname();
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