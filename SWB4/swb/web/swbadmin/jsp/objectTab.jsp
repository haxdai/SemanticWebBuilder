<%@page contentType="text/html"%><%@page pageEncoding="UTF-8"%><%@page import="org.semanticwb.*,org.semanticwb.platform.*,org.semanticwb.model.*,java.util.*,org.semanticwb.base.util.*"%>
<%

    String lang="es";
    response.setHeader("Cache-Control", "no-cache"); 
    response.setHeader("Pragma", "no-cache"); 
    String id=request.getParameter("suri");
    SemanticOntology ont=SWBPlatform.getSemanticMgr().getOntology();
    SemanticObject obj=ont.getSemanticObject(id);
    WebSite adm=SWBContext.getAdminWebSite();
    //System.out.println("suri:"+id);
    if(obj==null)return;
    SemanticClass cls=obj.getSemanticClass();

    String loading="<BR/><center><img src='/swb/swbadmin/images/loading.gif'/><center>";

    //Div dummy para detectar evento de carga y modificar titulo
    String icon=SWBContext.UTILS.getIconClass(obj);
    out.println("<div dojoType=\"dijit.layout.ContentPane\" postCreate=\"setTabTitle('"+id+"','"+obj.getDisplayName(lang)+"','"+icon+"');\" _loadingMessage=\""+loading+"\" />");

    out.println("<div dojoType=\"dijit.layout.TabContainer\" region=\"center\" style=\"width=100%;height=100%;\" id=\""+id+"/tab2\" _tabPosition=\"bottom\" nested=\"true\" _selectedChild=\"btab1\" onLoad=\"alert('Hola');\">");

    Iterator<ObjectBehavior> obit=SWBComparator.sortSermanticObjects(ObjectBehavior.listObjectBehaviors(adm));
    //Iterator<ObjectBehavior> obit=SWBComparator.sortSermanticObjects(new GenericIterator(ObjectBehavior.swbxf_ObjectBehavior, obj.getModel().listInstancesOfClass(ObjectBehavior.swbxf_ObjectBehavior)));
    while(obit.hasNext())
    {
        ObjectBehavior ob=obit.next();
        //System.out.println("ob:"+ob);
        if(!ob.isVisible())continue;

        String title=ob.getDisplayName(lang);
        //DisplayObject dpobj=ob.getDisplayObject();
        SemanticObject interf=ob.getInterface();
        boolean refresh=ob.isRefreshOnShow();
        //String url=ob.getParsedURL();
        String url=ob.getUrl();
        //System.out.println("ob:"+ob.getTitle(lang)+" "+ob.getDisplayObject()+" "+ob.getInterface()+" "+ob.getURL());

        String params="suri="+URLEncoder.encode(obj.getURI());

        String bp=ob.getBehaviorParams();
        if(bp!=null)
        {
            params+="&"+SWBUtils.TEXT.replaceAll(bp, "swb:", URLEncoder.encode(SemanticVocabulary.URI));
        }
//        Iterator<ResourceParameter> prmit=ob.listParams();
//        while(prmit.hasNext())
//        {
//            ResourceParameter rp=prmit.next();
//            params+="&"+rp.getName()+"="+rp.getValue().getEncodedURI();
//        }
        //System.out.println("params:"+params);
        //Genericos
        boolean addDiv=false;
        //if(dpobj==null)
        {
            if(interf==null)
            {
                addDiv=true;
            }else
            {
                SemanticClass scls=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(interf.getURI());
                if(scls!=null)
                {
                    if(obj.instanceOf(scls))
                    {
                        addDiv=true;
                    }
                }
            }
        }
        if(addDiv)
        {
            //out.println("<div dojoType=\"dojox.layout.ContentPane\" title=\""+title+"\" _style=\"display:true;padding:10px;\" refreshOnShow=\""+refresh+"\" href=\""+url+"?"+params+"\" executeScripts=\"true\">");
            //System.out.println("url:"+url+"?"+params);
            out.println("<div id=\""+obj.getURI()+"/"+ob.getId()+"\" dojoType=\"dijit.layout.ContentPane\" title=\""+title+"\" refreshOnShow=\""+refresh+"\" href=\""+url+"?"+params+"\" _loadingMessage=\""+loading+"\" _onLoad=\"alert('test');\">");
            //request.getRequestDispatcher((url+"?"+params).substring(4)).include(request, response);
            out.println("</div>");
        }
    }

    out.println("</div><!-- end Bottom TabContainer -->");
%>