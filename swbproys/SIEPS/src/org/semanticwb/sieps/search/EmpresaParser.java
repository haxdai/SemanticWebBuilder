/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.sieps.search;
import java.util.Iterator;
import java.util.Map;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.indexer.IndexTerm;
import org.semanticwb.portal.indexer.parser.GenericParser;
import org.semanticwb.scian.Sector;
import org.semanticwb.sieps.Empresa;

/**
 * IndexParser for Empresas.
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class EmpresaParser extends GenericParser {
    public static final String ATT_SECTOR = "sector";
    public static final String ATT_SUBSECTOR = "subsector";
    public static final String ATT_RAMA = "rama";
    public static final String ATT_SUBRAMA = "subrama";
    public static final String ATT_CLASE = "clase";
    public static final String ATT_CSECTOR = "csector";
    public static final String ATT_CSUBSECTOR = "csubsector";
    public static final String ATT_CRAMA = "crama";
    public static final String ATT_CSUBRAMA = "csubrama";
    public static final String ATT_CCLASE = "cclase";

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
        return ((Empresa)gen).getDescripcion();
    }

    @Override
    public String getUrl(Searchable gen) {
        return "http://localhost:8888/es/sieps/Resultados_Empresas/?query=empresas&act=detail&uri="+((Empresa)gen).getEncodedURI();
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
        return ((Empresa)gen).getDescripcion();
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
        //boolean ret = super.canUserView(gen, user);//Verificar reglas y filtros de SWB
        return true;
    }

    @Override
    public Map<String, IndexTerm> getIndexTerms(Searchable gen) {
        Empresa e = (Empresa)gen;
        Map map = super.getIndexTerms(gen);
        //System.out.println("::Entering to get indexterms for " + e.getName());
        //map.put(ATT_SECTOR, new IndexTerm(ATT_SECTOR, getLabel(e.getScian().getSemanticObject(), org.semanticwb.scian.Sector.sclass,"es"), false, IndexTerm.INDEXED_ANALYZED));
        //map.put(ATT_SUBSECTOR, new IndexTerm(ATT_SUBSECTOR, getLabel(e.getScian().getSemanticObject(), org.semanticwb.scian.SubSector.sclass,"es"), false, IndexTerm.INDEXED_ANALYZED));
        //map.put(ATT_RAMA, new IndexTerm(ATT_RAMA, getLabel(e.getScian().getSemanticObject(), org.semanticwb.scian.Rama.sclass,"es"), false, IndexTerm.INDEXED_ANALYZED));
        //map.put(ATT_SUBRAMA, new IndexTerm(ATT_SUBRAMA, getLabel(e.getScian().getSemanticObject(), org.semanticwb.scian.SubRama.sclass,"es"), false, IndexTerm.INDEXED_ANALYZED));
        map.put(ATT_CLASE, new IndexTerm(ATT_CLASE, e.getScian().getSemanticObject().getLabel("es"), false, IndexTerm.INDEXED_ANALYZED));
        //map.put(ATT_CSECTOR, new IndexTerm(ATT_CSECTOR, getCode(e.getScian().getSemanticObject(), org.semanticwb.scian.Sector.sclass), false, IndexTerm.INDEXED_NO_ANALYZED));
        //map.put(ATT_CSUBSECTOR, new IndexTerm(ATT_CSUBSECTOR, getCode(e.getScian().getSemanticObject(), org.semanticwb.scian.SubSector.sclass), false, IndexTerm.INDEXED_NO_ANALYZED));
        //map.put(ATT_CRAMA, new IndexTerm(ATT_CRAMA, getCode(e.getScian().getSemanticObject(), org.semanticwb.scian.Rama.sclass), false, IndexTerm.INDEXED_NO_ANALYZED));
        //map.put(ATT_CSUBRAMA, new IndexTerm(ATT_CSUBRAMA, getCode(e.getScian().getSemanticObject(), org.semanticwb.scian.SubRama.sclass), false, IndexTerm.INDEXED_NO_ANALYZED));
        map.put(ATT_CCLASE, new IndexTerm(ATT_CCLASE, e.getScian().getCode(), false, IndexTerm.INDEXED_NO_ANALYZED));
        map.put("name", new IndexTerm("name", e.getScian().getCode(), false, IndexTerm.INDEXED_ANALYZED));
        return map;
    }

    private String getLabel(SemanticObject obj,SemanticClass clazz,String lang)
    {
        String getLabel="";
        org.semanticwb.platform.SemanticProperty prop=obj.getModel().getSemanticProperty(org.semanticwb.platform.SemanticVocabulary.RDFS_SUBCLASSOF);
//        System.out.println("--bump -1!!");
        org.semanticwb.platform.SemanticObject parent=null;
        Iterator<org.semanticwb.platform.SemanticObject> parents=obj.listObjectProperties(prop);
//        System.out.println("--bump 0!!");
//        System.out.println("--bump 1!!");
        while(parents.hasNext())
        {
//            System.out.println("--bump n!!");
            org.semanticwb.platform.SemanticObject temp=parents.next();
            if(clazz.equals(temp.getSemanticClass()))
            {
                parent=temp;
                break;
            }
        }
//        System.out.println("--bump 2!!");
        if(parent!=null)
        {
//            System.out.println("--bump parent not null!!");
            getLabel=parent.getLabel(lang);
//            System.out.println("--bump label: " + getLabel);
        }
        return getLabel;
    }

    private String getCode(SemanticObject obj,SemanticClass clazz)
    {
        String getCode="";
        org.semanticwb.platform.SemanticProperty prop=obj.getModel().getSemanticProperty(org.semanticwb.platform.SemanticVocabulary.RDFS_SUBCLASSOF);
        org.semanticwb.platform.SemanticObject parent=null;
        Iterator<org.semanticwb.platform.SemanticObject> parents=obj.listObjectProperties(prop);
        while(parents.hasNext())
        {
            org.semanticwb.platform.SemanticObject temp=parents.next();
            if(clazz.equals(temp.getSemanticClass()))
            {
                parent=temp;
                break;
            }
        }

        if(parent!=null)
        {
            Sector sector=new Sector(parent);
            getCode=sector.getCode();
        }
        return getCode;
    }
}