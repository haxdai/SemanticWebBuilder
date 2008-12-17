<%@page contentType="text/html"%><%@page pageEncoding="ISO-8859-1"%><%@page import="org.semanticwb.*,org.semanticwb.platform.*,org.semanticwb.model.*,java.util.*,org.semanticwb.base.util.*"%>
<%
    String lang="es";
    response.setHeader("Cache-Control", "no-cache"); 
    response.setHeader("Pragma", "no-cache"); 
    String id=request.getParameter("suri");
    SemanticOntology ont=SWBPlatform.getSemanticMgr().getOntology();
    com.hp.hpl.jena.rdf.model.Resource res=ont.getResource(id);
    System.out.println("suri:"+id);
    if(res==null)return;
    SemanticClass cls=ont.getSemanticObjectClass(res);
    GenericObject obj=ont.getGenericObject(id,cls);
    out.println("<div dojoType=\"dijit.layout.TabContainer\" region=\"center\" style=\"width=100%;height=100%;\" id=\""+id+"/tab2\" _tabPosition=\"bottom\" _selectedChild=\"btab1\">");
    //out.println("    <script type=\"dojo/method\" event=\"onClick\" args=\"item\">");
    //out.println("       alert(item);");
    //out.println("    </script>");

    Iterator<ObjectBehavior> obit=SWBComparator.sortSortableObject(SWBContext.getVocabulary().swbxf_ObjectBehavior.listGenericInstances(true));
    while(obit.hasNext())
    {
        ObjectBehavior ob=obit.next();
        String title=ob.getTitle(lang);
        DisplayObject dpobj=ob.getDisplayObject();
        SemanticObject interf=ob.getInterface();
        boolean refresh=ob.isRefreshOnShow();
        String url=ob.getURL();
        System.out.println("ob:"+ob.getTitle(lang)+" "+ob.getDisplayObject()+" "+ob.getInterface()+" "+ob.getURL());

        String params="suri="+URLEncoder.encode(obj.getURI());
        Iterator<ResourceParameter> prmit=ob.listParams();
        while(prmit.hasNext())
        {
            ResourceParameter rp=prmit.next();
            params+="&"+rp.getName()+"="+rp.getValue().getEncodedURI();
        }
        System.out.println("params:"+params);
        //Genericos
        boolean addDiv=false;
        if(dpobj==null)
        {
            if(interf==null)
            {
                addDiv=true;
            }else
            {
                SemanticClass scls=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(interf.getURI());
                if(scls!=null)
                {
                    if(scls.getObjectClass().isInstance(obj))
                    {
                        addDiv=true;
                    }
                }
            }
        }
        if(addDiv)
        {
            out.println("<div dojoType=\"dojox.layout.ContentPane\" title=\""+title+"\" style=\"display:true;padding:10px;\" refreshOnShow=\""+refresh+"\" href=\""+url+"?"+params+"\" executeScripts=\"true\">");
            out.println("</div>");
        }
    }
%>

<%        
        String buri="/swb/swb/SWBAdmin/WBAd_Home/_rid/1/_mto/3";
        buri+="?suri="+obj.getSemanticObject().getEncodedURI();
        SWBVocabulary voc=SWBContext.getVocabulary();
        
        if(obj instanceof Calendarable)
        {
            String auri="/swb/swb/SWBAdmin/WBAd_Home/_rid/4/_mto/3";
            auri+="?suri="+obj.getSemanticObject().getEncodedURI();
            auri+="&sprop="+voc.swb_hasCalendar.getEncodedURI();
            System.out.println(auri);
            //auri+="&spropref="+voc.pflow.getEncodedURI();            
%>
<div dojoType="dijit.layout.ContentPane" title="Calendarizaci�n" style=" padding:10px;" refreshOnShow="false" href="<%=auri%>"></div>
<%            
        }
        
        if(obj instanceof RoleRefable)
        {
            String auri=buri;
            auri+="&sprop="+voc.swb_hasRoleRef.getEncodedURI();
            auri+="&spropref="+voc.swb_role.getEncodedURI();
%>
<div dojoType="dijit.layout.ContentPane" title="Roles" style=" padding:10px;" refreshOnShow="false" href="<%=auri%>"></div>
<%            
        }
        
        if(obj instanceof RuleRefable)
        {
            String auri=buri;
            auri+="&sprop="+voc.swb_hasRuleRef.getEncodedURI();
            auri+="&spropref="+voc.swb_rule.getEncodedURI();
%>
<div dojoType="dijit.layout.ContentPane" title="Reglas" style=" padding:10px;" refreshOnShow="false" href="<%=auri%>"></div>
<%            
        }

        {
%>
<div dojoType="dijit.layout.ContentPane" title="Bit�cora" style=" padding:10px;" refreshOnShow="false" href=""></div>
<%            
        }

    out.println("</div><!-- end Bottom TabContainer -->");
%>