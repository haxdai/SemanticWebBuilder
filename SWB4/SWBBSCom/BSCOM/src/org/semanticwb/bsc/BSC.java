package org.semanticwb.bsc;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.GenericFilterRule;
import org.semanticwb.bsc.accessory.Differentiator;
import org.semanticwb.bsc.accessory.DifferentiatorGroup;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.State;
import org.semanticwb.bsc.element.Initiative;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.bsc.element.Risk;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class BSC extends org.semanticwb.bsc.base.BSCBase 
{
    public BSC(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public List<Initiative> listValidInitiatives() {
        List<Initiative> validInitiative = SWBUtils.Collections.filterIterator(super.listInitiatives(), new GenericFilterRule<Initiative>() {
                                                                        @Override
                                                                        public boolean filter(Initiative s) {
                                                                            System.out.println("iniciativa="+s.getTitle());
                                                                            User user = SWBContext.getSessionUser(getUserRepository().getId());
                                                                            if(user==null) {
                                                                                user = SWBContext.getAdminUser();
                                                                            }
                                                                            System.out.println("user="+user.getLogin());
                                                                            return !s.isValid() || !user.haveAccess(s);
                                                                        }            
                                                                    });
        return validInitiative;
    }
    
    private List<Period> sortPeriods() {
        return sortPeriods(true);
    }
    
    private List<Period> sortPeriods(boolean ascendent) {
        List<Period> periods = SWBUtils.Collections.copyIterator(super.listPeriods());
        if(ascendent) {
            Collections.sort(periods);
        }else {            
            Collections.sort(periods, Collections.reverseOrder());            
        }
        return periods;
    }

    @Override
    public Iterator<Period> listPeriods() {
        return sortPeriods().iterator();
    }
    
    public Iterator<Period> listPeriods(boolean ascendent) {
        return sortPeriods(ascendent).iterator();
    }
    
    private List<Period> sortPerspectives() {
        return sortPeriods(true);
    }
    
    private List<Perspective> sortPerspectives(boolean ascendent) {
        List<Perspective> perspectives = SWBUtils.Collections.copyIterator(super.listPerspectives());
        if(ascendent) {
            Collections.sort(perspectives);
        }else {            
            Collections.sort(perspectives, Collections.reverseOrder());            
        }
        return perspectives;
    }

    public List<Period> listValidPeriods() {
        List<Period> validPeriods = SWBUtils.Collections.filterIterator(listPeriods(), new GenericFilterRule<Period>() {
                                                                        @Override
                                                                        public boolean filter(Period p) {
                                                                            if(p==null) {
                                                                                return true;
                                                                            }
                                                                            User user = SWBContext.getSessionUser(getUserRepository().getId());
                                                                            if(user==null) {
                                                                                user = SWBContext.getAdminUser();
                                                                            }
                                                                            return !p.isValid() || !user.haveAccess(p);
                                                                        }            
                                                                    });
        return validPeriods;
    }
    
    public List<Perspective> listValidPerspectives() {
        List<Perspective> validPerspectives = SWBUtils.Collections.filterIterator(listPerspectives(), new GenericFilterRule<Perspective>() {
                                                                        @Override
                                                                        public boolean filter(Perspective p) {
                                                                            if(p==null) {
                                                                                return true;
                                                                            }
                                                                            User user = SWBContext.getSessionUser(getUserRepository().getId());
                                                                            if(user==null) {
                                                                                user = SWBContext.getAdminUser();
                                                                            }
                                                                            return !p.isValid() || !user.haveAccess(p);
                                                                        }            
                                                                    });
        return validPerspectives;
    }
    
    public List<Risk> listValidRisks() {
        List<Risk> validRisks = SWBUtils.Collections.filterIterator(listRisks(), new GenericFilterRule<Risk>() {
                                                                        @Override
                                                                        public boolean filter(Risk r) {
                                                                            if(r==null) {
                                                                                return true;
                                                                            }
                                                                            User user = SWBContext.getSessionUser(getUserRepository().getId());
                                                                            if(user==null) {
                                                                                user = SWBContext.getAdminUser();
                                                                            }
                                                                            return !r.isValid() || !user.haveAccess(r);
                                                                        }            
                                                                    });
        return validRisks;
    }
    
    public Document getDom()
    {
        User user = SWBContext.getSessionUser(getUserRepository().getId());
        if(user==null) {
            user = SWBContext.getAdminUser();
        }
        final String lang = user.getLanguage()==null?"es":user.getLanguage();
        
        Document  doc = SWBUtils.XML.getNewDocument();
        
        Element eroot = doc.createElement("bsc");
        eroot.setAttribute("id", getURI());        
        doc.appendChild(eroot);
        
        //title
        Element e = doc.createElement("title");
        e.appendChild(doc.createTextNode(getDisplayTitle(lang)==null ? (getTitle()==null?"Desconocido":getTitle().replaceAll("['\n]", "")) : getDisplayTitle(lang).replaceAll("['\n]", "")));
        eroot.appendChild(e);
        //mission
        e = doc.createElement("mission");
        e.appendChild(doc.createTextNode(getMission(lang)==null?(getMission()==null?"Desconocido":getMission().replaceAll("['\n]", "")):getMission(lang).replaceAll("['\n]", "")));
        eroot.appendChild(e);
        //vision
        e = doc.createElement("vision");
        e.appendChild(doc.createTextNode(getVision(lang)==null?(getVision()==null?"Desconocido":getVision().replaceAll("['\n]", "")):getVision(lang).replaceAll("['\n]", "")));
        eroot.appendChild(e);
        //logo
        e = doc.createElement("logo");
        Attr alt = doc.createAttribute("title");
        alt.setValue(getDisplayDescription(lang)==null?(getDescription()==null?"Desconocido":getDescription()):getDisplayDescription(lang));
        e.setAttributeNode(alt);
        Attr src = doc.createAttribute("src");
        if(getLogo()!=null) {
            src.setValue(getLogo());
        }
        e.setAttributeNode(src);
        eroot.appendChild(e);
        
        // lista de perspectivas
        List<Perspective> perspectives = listValidPerspectives();
        Collections.sort(perspectives);
        for(Perspective p:perspectives) {
            //perspectiva
            Element ep = doc.createElement("perspective");
            ep.setAttribute("id", p.getURI());
            ep.setAttribute("orden", Integer.toString(p.getIndex()));
            eroot.appendChild(ep);
            //prefijo
            e = doc.createElement("prefix");
            e.appendChild(doc.createTextNode(p.getPrefix()));
            ep.appendChild(e);
            //title
            e = doc.createElement("title");
            e.appendChild(doc.createTextNode(p.getDisplayTitle(lang)==null?(p.getTitle()==null?"Desconocido":p.getTitle().replaceAll("['\n]", "")):p.getDisplayTitle(lang).replaceAll("['\n]", "")));
            ep.appendChild(e);
            // lista de temas de esta perspectiva
            List<Theme> themes = p.listValidThemes();
            if(!themes.isEmpty()) {
                Element ethemes = doc.createElement("themes");
                ep.appendChild(ethemes);
                Collections.sort(themes);
                for(Theme t:themes) {
                    Element etheme = doc.createElement("theme");
                    etheme.setAttribute("id", t.getURI());
                    etheme.setAttribute("orden", Integer.toString(t.getIndex()));
                    etheme.setAttribute("hidden", Boolean.toString(t.isHidden()));
                    ethemes.appendChild(etheme);
                    //title
                    e = doc.createElement("title");
                    e.appendChild(doc.createTextNode(t.getDisplayTitle(lang)==null?(t.getTitle()==null?"Desconocido":t.getTitle().replaceAll("['\n]", "")):t.getDisplayTitle(lang).replaceAll("['\n]", "")));
                    etheme.appendChild(e);
                    
                    //relaciones tema - tema
                    Iterator<Causal> itrel = t.listCausalThemes();
                    while(itrel.hasNext()) {
                        Theme aux = (Theme)itrel.next();
                        if(!aux.isValid()) {
                            continue;
                        }
                        e = doc.createElement("rel");
                        e.setAttribute("to", aux.getURI());
                        e.setAttribute("parent", aux.getPerspective().getURI());
                        e.setAttribute("type", "theme");
                        etheme.appendChild(e);
                    }
                    //relaciones tema - objetivo
                    itrel = t.listCausalObjectives();
                    while(itrel.hasNext()) {
                        Objective aux = (Objective)itrel.next();
                        if(!aux.isValid()) {
                            continue;
                        }
                        e = doc.createElement("rel");
                        e.setAttribute("to", aux.getURI());
                        e.setAttribute("parent", aux.getTheme().getPerspective().getURI());
                        e.setAttribute("type", "objective");
                        etheme.appendChild(e);
                    }
                    
                    // lista de objetivos de este tema
                    List<Objective> objectives = t.listValidObjectives();
                    Collections.sort(objectives);
                    for(Objective o:objectives) {
                        Element eobj = doc.createElement("obj");
                        eobj.setAttribute("id", o.getURI());
                        eobj.setAttribute("href", o.getEncodedURI());
                        eobj.setAttribute("orden", Integer.toString(o.getIndex()));
                        eobj.setAttribute("status", "x");
                        etheme.appendChild(eobj);
                        //prefix
                        e = doc.createElement("prefix");
                        e.appendChild(doc.createTextNode(o.getPrefix()));
                        eobj.appendChild(e);
                        //title
                        e = doc.createElement("title");
                        e.appendChild(doc.createTextNode(o.getDisplayTitle(lang)==null?(o.getTitle()==null?"Desconocido":o.getTitle().replaceAll("['\n]", "")):o.getDisplayTitle(lang).replaceAll("['\n]", "")));
                        eobj.appendChild(e);
                        //sponsor
                        e = doc.createElement("sponsor");
                        e.appendChild(doc.createTextNode(o.getSponsor()==null?"Desconocido":o.getSponsor().getFullName().replaceAll("['\n]", "")));
                        eobj.appendChild(e);
                        //frequency
                        e = doc.createElement("frequency");
                        if(o.getPeriodicity()==null) {
                            e.appendChild(doc.createTextNode("Desconocido"));
                        }else {
                            e.appendChild(doc.createTextNode(o.getPeriodicity().getDisplayTitle(lang)==null?(o.getPeriodicity().getTitle()==null?"Desconocido":o.getPeriodicity().getTitle().replaceAll("['\n]", "")):o.getPeriodicity().getDisplayTitle(lang).replaceAll("['\n]", "")));
                        }
                        eobj.appendChild(e);
                        
                        //relaciones objetivo - tema
                        itrel = o.listCausalThemes();
                        while(itrel.hasNext()) {
                            Theme aux = (Theme)itrel.next();
                            if(!aux.isValid()) {
                                continue;
                            }
                            e = doc.createElement("rel");
                            e.setAttribute("to", aux.getURI());
                            e.setAttribute("parent", aux.getPerspective().getURI());
                            e.setAttribute("type", "theme");
                            eobj.appendChild(e);
                        }
                        //relaciones objetivo - objetivo
                        itrel = o.listCausalObjectives();
                        while(itrel.hasNext()) {
                            Objective aux = (Objective)itrel.next();
                            if(!aux.isValid()) {
                                continue;
                            }
                            e = doc.createElement("rel");
                            e.setAttribute("to", aux.getURI());
                            e.setAttribute("parent", aux.getTheme().getPerspective().getURI());
                            e.setAttribute("type", "objective");
                            eobj.appendChild(e);
                        }
                    }
                }
            }
            //diffgroup
            List<DifferentiatorGroup> diffgroups = p.listValidDifferentiatorGroups();
            if(!diffgroups.isEmpty()) {
                DifferentiatorGroup diffgroup = diffgroups.get(0);
                List<Differentiator> diffs = diffgroup.listValidDifferentiators();
                if(!diffs.isEmpty()) {
                    Element ediffgroup = doc.createElement("diffgroup");
                    ediffgroup.setAttribute("id", diffgroup.getURI());
                    ep.appendChild(ediffgroup);
                    Collections.sort(diffs);
                    for(Differentiator diff:diffs) {                        
                        e = doc.createElement("diff");
                        e.setAttribute("id", diff.getURI());
                        e.setAttribute("orden", Integer.toString(diff.getIndex()));
                        e.appendChild(doc.createTextNode(diff.getDisplayTitle(lang)==null?(diff.getTitle()==null?"Desconocido":diff.getTitle().replaceAll("['\n]", "")):diff.getDisplayTitle(lang).replaceAll("['\n]", "")));
                        ediffgroup.appendChild(e);
                    }
                }
            }
        }
        
        
        // lista de riesgos
        List<Risk> risks = listValidRisks();
        if(!risks.isEmpty()) {
            Element erskgp = doc.createElement("risks");
            eroot.appendChild(erskgp);
            for(Risk r:risks) {
                e = doc.createElement("risk");
                e.setAttribute("id", r.getId());
                e.setAttribute("prefix", r.getPrefix());
                e.setAttribute("likehood", Integer.toString(r.getFinAssessmentLikelihood()));
                e.setAttribute("impact", Integer.toString(r.getFinAssessmentImpactLevel()));
                e.appendChild(doc.createTextNode(r.getDisplayTitle(lang)==null?(r.getTitle()==null?"Desconocido":r.getTitle().replaceAll("['\n]", "")):r.getDisplayTitle(lang).replaceAll("['\n]", "")));
                erskgp.appendChild(e);
            }
        }
        
        return doc;
    }
    
    public Document getDom(final Period period)
    {
        User user = SWBContext.getSessionUser(getUserRepository().getId());
System.out.println("\n\ngetDom("+period.getTitle()+")...");
System.out.println("repositorio="+getUserRepository().getId());
System.out.println("1. user="+user);
        if(user==null) {
            user = SWBContext.getAdminUser();
System.out.println("2. user="+user);            
        }
        final String lang = user.getLanguage()==null?"es":user.getLanguage();
        Document  doc = SWBUtils.XML.getNewDocument();
        
        Element eroot = doc.createElement("bsc");
        eroot.setAttribute("id", getURI());        
        doc.appendChild(eroot);
        
        //title
        Element e = doc.createElement("title");
        e.appendChild(doc.createTextNode(getDisplayTitle(lang)==null ? (getTitle()==null?"Desconocido":getTitle().replaceAll("['\n]", "")) : getDisplayTitle(lang).replaceAll("['\n]", "")));
        eroot.appendChild(e);
        //mission
        e = doc.createElement("mission");
        e.appendChild(doc.createTextNode(getMission(lang)==null?(getMission()==null?"Desconocido":getMission().replaceAll("['\n]", "")):getMission(lang).replaceAll("['\n]", "")));
        eroot.appendChild(e);
        //vision
        e = doc.createElement("vision");
        e.appendChild(doc.createTextNode(getVision(lang)==null?(getVision()==null?"Desconocido":getVision().replaceAll("['\n]", "")):getVision(lang).replaceAll("['\n]", "")));
        eroot.appendChild(e);
        //logo
        e = doc.createElement("logo");
        Attr alt = doc.createAttribute("title");
        alt.setValue(getDisplayDescription(lang)==null?(getDescription()==null?"Desconocido":getDescription().replaceAll("['\n]", "")):getDisplayDescription(lang).replaceAll("['\n]", ""));
        e.setAttributeNode(alt);
        Attr src = doc.createAttribute("src");
        src.setValue(getLogo());
        e.setAttributeNode(src);
        eroot.appendChild(e);
        
        boolean existsObjectivesInPeriod;
        
        // lista de perspectivas
        List<Perspective> perspectives = listValidPerspectives();
        Collections.sort(perspectives);
        for(Perspective p:perspectives) {
            //perspectiva
            Element ep = doc.createElement("perspective");
            ep.setAttribute("id", p.getURI());
            ep.setAttribute("orden", Integer.toString(p.getIndex()));
            eroot.appendChild(ep);
            //prefijo
            e = doc.createElement("prefix");
            e.appendChild(doc.createTextNode(p.getPrefix()));
            ep.appendChild(e);
            //title
            e = doc.createElement("title");
            e.appendChild(doc.createTextNode(p.getDisplayTitle(lang)==null?(p.getTitle()==null?"Desconocido":p.getTitle().replaceAll("['\n]", "")):p.getDisplayTitle(lang).replaceAll("['\n]", "")));
            ep.appendChild(e);
            
            existsObjectivesInPeriod = false;
                        
            // lista de temas por perspectiva
            List<Theme> themes = p.listValidThemes();
            if(!themes.isEmpty()) {
                Element ethemes = doc.createElement("themes");
                ep.appendChild(ethemes);
                Collections.sort(themes);
                for(Theme t:themes) {
                    // tema
                    Element etheme = doc.createElement("theme");
                    etheme.setAttribute("id", t.getURI());
                    etheme.setAttribute("orden", Integer.toString(t.getIndex()));
                    etheme.setAttribute("hidden", Boolean.toString(t.isHidden()));
                    ethemes.appendChild(etheme);
                    //title
                    e = doc.createElement("title");
                    e.appendChild(doc.createTextNode(t.getDisplayTitle(lang)==null?(t.getTitle()==null?"Desconocido":t.getTitle().replaceAll("['\n]", "")):t.getDisplayTitle(lang).replaceAll("['\n]", "")));
                    etheme.appendChild(e);
                    
                    //relaciones tema - tema
                    Iterator<Causal> itrel = t.listCausalThemes();
                    while(itrel.hasNext()) {
                        Theme aux = (Theme)itrel.next();
                        if(!aux.isValid()) {
                            continue;
                        }
                        e = doc.createElement("rel");
                        e.setAttribute("to", aux.getURI());
                        e.setAttribute("parent", aux.getPerspective().getURI());
                        e.setAttribute("type", "theme");
                        etheme.appendChild(e);
                    }
                    //relaciones tema - objetivo
                    itrel = t.listCausalObjectives();
                    while(itrel.hasNext()) {
                        Objective aux = (Objective)itrel.next();
                        if(!aux.isValid() || !aux.hasPeriod(period)) {
                            continue;
                        }
                        e = doc.createElement("rel");
                        e.setAttribute("to", aux.getURI());
                        e.setAttribute("parent", aux.getTheme().getPerspective().getURI());
                        e.setAttribute("type", "objective");
                        etheme.appendChild(e);
                    }
                    
                    //objetivos por tema
                    State state;
                    String color;
                    List<Objective> objectives = t.listValidObjectives();
                    Collections.sort(objectives);
                    for(Objective o:objectives) {
                        if(!o.hasPeriod(period)) {
                            continue;
                        }
                        existsObjectivesInPeriod = true;
                        
                        state = o.getState(period);
                        color = state==null?"#a6a6a6":(state.getColorHex()==null?"#f912be":state.getColorHex());
                        Element eobj = doc.createElement("obj");
                        eobj.setAttribute("id", o.getURI());
                        eobj.setAttribute("href", o.getEncodedURI());
                        eobj.setAttribute("orden", Integer.toString(o.getIndex()));
                        eobj.setAttribute("status", color);
                        etheme.appendChild(eobj);
                        //prefix
                        e = doc.createElement("prefix");
                        e.appendChild(doc.createTextNode(o.getPrefix()));
                        eobj.appendChild(e);
                        //title
                        e = doc.createElement("title");
                        e.appendChild(doc.createTextNode(o.getDisplayTitle(lang)==null?(o.getTitle()==null?"Desconocido":o.getTitle().replaceAll("['\n]", "")):o.getDisplayTitle(lang).replaceAll("['\n]", "")));
                        eobj.appendChild(e);
                        //sponsor
                        e = doc.createElement("sponsor");
                        e.appendChild(doc.createTextNode(o.getSponsor()==null?"Desconocido":o.getSponsor().getFullName()));
                        eobj.appendChild(e);
                        //frequency
                        e = doc.createElement("frequency");
                        if(o.getPeriodicity()==null) {
                            e.appendChild(doc.createTextNode("Desconocido"));
                        }else {
                            e.appendChild(doc.createTextNode(o.getPeriodicity().getDisplayTitle(lang)==null?(o.getPeriodicity().getTitle()==null?"Desconocido":o.getPeriodicity().getTitle().replaceAll("['\n]", "")):o.getPeriodicity().getDisplayTitle(lang).replaceAll("['\n]", "")));
                        }
                        eobj.appendChild(e);
                        
                        //relaciones objetivo - tema
                        itrel = o.listCausalThemes();
                        while(itrel.hasNext()) {
                            Theme aux = (Theme)itrel.next();
                            if(!aux.isValid()) {
                                continue;
                            }
                            e = doc.createElement("rel");
                            e.setAttribute("to", aux.getURI());
                            e.setAttribute("parent", aux.getPerspective().getURI());
                            e.setAttribute("type", "theme");
                            eobj.appendChild(e);
                        }
                        //relaciones objetivo - objetivo
                        itrel = o.listCausalObjectives();
                        while(itrel.hasNext()) {
                            Objective aux = (Objective)itrel.next();
                            if(!aux.isValid() || !aux.hasPeriod(period)) {
                                continue;
                            }
                            e = doc.createElement("rel");
                            e.setAttribute("to", aux.getURI());
                            e.setAttribute("parent", aux.getTheme().getPerspective().getURI());
                            e.setAttribute("type", "objective");
                            eobj.appendChild(e);
                        }
                    } //objetivos por tema
                } //lista de temas
            } //temas por perspectiva
            
            // lista de diferenciadores por perspectiva
            List<DifferentiatorGroup> diffgroups = p.listValidDifferentiatorGroups();
            if(!diffgroups.isEmpty()) {
                DifferentiatorGroup diffgroup = diffgroups.get(0);
                List<Differentiator> diffs = diffgroup.listValidDifferentiators();
                if(!diffs.isEmpty()) {
                    Element ediffgroup = doc.createElement("diffgroup");
                    ediffgroup.setAttribute("id", diffgroup.getURI());
                    ep.appendChild(ediffgroup);
                    Collections.sort(diffs);
                    for(Differentiator diff:diffs) {                        
                        e = doc.createElement("diff");
                        e.setAttribute("id", diff.getURI());
                        e.setAttribute("orden", Integer.toString(diff.getIndex()));
                        e.appendChild(doc.createTextNode(diff.getDisplayTitle(lang)==null?(diff.getTitle()==null?"Desconocido":diff.getTitle().replaceAll("['\n]", "")):diff.getDisplayTitle(lang).replaceAll("['\n]", "")));
                        ediffgroup.appendChild(e);
                    }
                }
            }
            
            if(!existsObjectivesInPeriod) {
                eroot.removeChild(ep);
            }
        } // for perspectives
        
        //riesgos
        List<Risk> risks = listValidRisks();
        if(!risks.isEmpty()) {
            Element rsksgroup = doc.createElement("riskgroup");
            eroot.appendChild(rsksgroup);
            for(Risk r:risks) {
                e = doc.createElement("risk");
                e.setAttribute("id", r.getId());
                e.setAttribute("prefix", r.getPrefix());
                e.setAttribute("likehood", Integer.toString(r.getFinAssessmentLikelihood()));
                e.setAttribute("impact", Integer.toString(r.getFinAssessmentImpactLevel()));
                e.appendChild(doc.createTextNode(r.getDisplayTitle(lang)==null?(r.getTitle()==null?"Desconocido":r.getTitle().replaceAll("['\n]", "")):r.getDisplayTitle(lang).replaceAll("['\n]", "")));
                rsksgroup.appendChild(e);
            }
        }
        
        return doc;
    }

    @Override
    public String getLogo() {
        return super.getLogo()==null ? null : SWBPortal.getWebWorkPath() + getWorkPath() + "/" + super.getLogo();
    }
}
