<%@page import="org.json.*,org.semanticwb.*,org.semanticwb.model.*,org.semanticwb.platform.*,java.util.*,com.hp.hpl.jena.ontology.*,com.hp.hpl.jena.*,com.hp.hpl.jena.util.*,com.hp.hpl.jena.rdf.model.Model" %>
<%@page contentType="text/html" %><%@page pageEncoding="UTF-8" %>
<%!
    int nullnode=0;

    public String getUserLanguage()
    {
        String lang="es";
        User user=SWBContext.getSessionUser();
        if(user!=null)lang=user.getLanguage();
        return lang;
    }

    public String getLocaleString(String key, String lang)
    {
        String ret="";
        if(lang==null)
        {
            ret=SWBUtils.TEXT.getLocaleString("locale_swb_admin", key);
        }else
        {
            ret=SWBUtils.TEXT.getLocaleString("locale_swb_admin", key, new Locale(lang));
        }
        //System.out.println(key+" "+lang+" "+ret);
        return ret;
    }

    public JSONObject getAction(String name, String value, String target) throws JSONException
    {
        JSONObject obj=new JSONObject();
        obj.put("id", "_NOID_"+(nullnode++));
        obj.put("name", name);
        obj.put("value", value);
        obj.put("target", target);
        return obj;
    }

    public JSONObject getEvent(String name, JSONObject action) throws JSONException
    {
        JSONObject obj=new JSONObject();
        obj.put("id", "_NOID_"+(nullnode++));
        obj.put("name", name);
        obj.put("action", action);
        return obj;
    }

    public JSONObject getMenuItem(String title, String icon, JSONObject action) throws JSONException
    {
        JSONObject obj=new JSONObject();
        obj.put("id", "_NOID_"+(nullnode++));
        obj.put("title", title);
        obj.put("icon", icon);
        obj.put("action", action);
        return obj;
    }

    public JSONObject getNode(String id, String title, String type, String icon) throws JSONException
    {
        if(title==null)title="Topic";
        JSONObject obj=new JSONObject();
        obj.put("id", id);
        obj.put("title",title);
        obj.put("type",type);
        obj.put("icon",icon);
        return obj;
    }

    public JSONObject getDummyNode() throws JSONException
    {
        return getNode("_NOID_" + (nullnode++), "DUMMY", "DUMMY", "DUMMY");
    }

    public JSONObject getReloadAction() throws JSONException
    {
        return getAction("reload",null,null);
    }

    public JSONObject getNewTabAction() throws JSONException
    {
        return getAction("newTab",SWBPlatform.getContextPath()+"/swbadmin/jsp/objectTab.jsp",null);
    }

    public JSONObject getMenuSeparator() throws JSONException
    {
        return getMenuItem("_",null, null);
    }

    public JSONObject getMenuReload(String lang) throws JSONException
    {
        return getMenuItem(getLocaleString("reload",lang), getLocaleString("icon_reload",null), getReloadAction());
    }
    
    public void addWebSites(JSONArray arr, String lang)  throws JSONException
    {
        //System.out.println("addWebSites");
        Iterator<WebSite> it=SWBComparator.sortSermanticObjects(lang, SWBContext.listWebSites());
        while(it.hasNext())
        {
            WebSite site=it.next();
            //System.out.println("site:"+site);
            //TODO: arreglar lista de sitios en SWBContext (estal ligados a ontologia)
            //site=SWBContext.getWebSite(site.getURI());
            addSemanticObject(arr, site.getSemanticObject(),false,true,lang);
            //addWebSite(arr, site);
        }

    }

    public void addUserReps(JSONArray arr, String lang)  throws JSONException
    {
        //System.out.println("addWebSites");
        Iterator<UserRepository> it=SWBComparator.sortSermanticObjects(lang, SWBContext.listUserRepositories());
        while(it.hasNext())
        {
            UserRepository rep=it.next();
            //TODO: arreglar lista de sitios en SWBContext (estal ligados a ontologia)
            //rep=SWBContext.getUserRepository(rep.getURI());
            addSemanticObject(arr, rep.getSemanticObject(),false,true,lang);
            //addWebSite(arr, site);
        }
    }

    public void addDocRepositories(JSONArray arr, String lang)  throws JSONException
    {
        //System.out.println("addWebSites");
        Iterator<org.semanticwb.repository.Workspace> it=SWBComparator.sortSermanticObjects(lang, SWBContext.listWorkspaces());
        while(it.hasNext())
        {
            org.semanticwb.repository.Workspace rep=it.next();
            //TODO: arreglar lista de sitios en SWBContext (estal ligados a ontologia)
            //rep=SWBContext.getUserRepository(rep.getURI());
            addSemanticObject(arr, rep.getSemanticObject(),false,true,lang);
            //addWebSite(arr, site);
        }
    }

    public void addFavorites(JSONArray arr, String lang)  throws JSONException
    {
        User user=SWBContext.getSessionUser();
        //System.out.println("user uri:"+user.getURI());
        if(user!=null && user.getURI()!=null)
        {
            UserFavorite fav=user.getUserFavorite();
            if(fav!=null)
            {
                //System.out.println("user fav:"+user.getURI());
                Iterator<SemanticObject> it=SWBComparator.sortSermanticObjects(fav.listObjects());
                while(it.hasNext())
                {
                    SemanticObject obj=it.next();
                    addSemanticObject(arr, obj,false,true,lang);
                }
            }
        }
    }

    public void addWebSitesTrash(JSONArray arr, String lang)  throws JSONException
    {
        Iterator<WebSite> it=SWBComparator.sortSermanticObjects(lang, SWBContext.listWebSites());
        while(it.hasNext())
        {
            WebSite site=it.next();
            if(!site.isDeleted())
            {
                Iterator<Resource> itp = site.listResources();
                while(itp.hasNext())
                {
                    Resource por = itp.next();
                    if(por.isDeleted())
                    {
                        addSemanticObject(arr, por.getSemanticObject(),false,true,lang);
                    }
                }
                Iterator<WebPage> itwp = site.listWebPages();
                while(itwp.hasNext())
                {
                    WebPage wp = itwp.next();
                    //if(wp.getId().equals("y")) wp.setDeleted(true);
                    if(wp.isDeleted())  //wp.isDeleted()
                    {
                        addSemanticObject(arr, wp.getSemanticObject(),false,true,lang);
                    }
                }
            }
        }

        it=SWBComparator.sortSermanticObjects(lang, SWBContext.listWebSites());
        while(it.hasNext())
        {
            WebSite site=it.next();
            if(site.isDeleted())
            {
                addSemanticObject(arr, site.getSemanticObject(),false,true,lang);
            }
        }
    }

    public boolean hasHerarquicalNodes(SemanticObject obj, String lang) throws JSONException
    {
        boolean ret=false;
        Iterator<SemanticObject> it=obj.getSemanticClass().listHerarquicalNodes();
        if(it.hasNext())
        {
            ret=true;
        }
        return ret;
    }


    public void addHerarquicalNodes(JSONArray arr, SemanticObject obj, String lang) throws JSONException
    {
        Iterator<SemanticObject> it=SWBComparator.sortSortableObject(obj.getSemanticClass().listHerarquicalNodes());
        while(it.hasNext())
        {
            HerarquicalNode node=new HerarquicalNode(it.next());
            addHerarquicalNode(arr,node,obj,false,lang);
        }
    }

    public void addHerarquicalNode(JSONArray arr, HerarquicalNode node, SemanticObject obj, boolean addChilds, String lang) throws JSONException
    {
        SemanticClass cls=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(node.getHClass().getURI());
        String pf=node.getPropertyFilter();
        JSONObject jobj=getNode("HN|"+obj.getURI()+"|"+node.getURI(), node.getDisplayTitle(lang), "HerarquicalNode", node.getIconClass());
        arr.put(jobj);

        JSONArray childs=new JSONArray();
        jobj.putOpt("children", childs);
        Iterator<SemanticObject> it=SWBObjectFilter.filter(SWBComparator.sortSermanticObjects(lang, obj.getModel().listInstancesOfClass(cls)),pf);

        //System.out.println("obj:"+obj.getId()+" cls:"+cls);
        //drop acceptance
        JSONArray dropacc=new JSONArray();
        jobj.putOpt("dropacc", dropacc);

        //Menus
        JSONArray menus=new JSONArray();
        jobj.putOpt("menus", menus);
        String url=SWBPlatform.getContextPath();
        //TODO:Separar en controller
        if(cls.equals(Language.ClassMgr.sclass))
        {
            url+="/swbadmin/jsp/addLang.jsp";
        }else
        {
            url+="/swbadmin/jsp/SemObjectEditor.jsp";
        }
        url+="?scls="+cls.getEncodedURI()+"&sref="+obj.getEncodedURI();
        if(pf!=null)url+="&"+pf;
        menus.put(getMenuItem(getLocaleString("add",lang)+" "+cls.getDisplayName(lang), getLocaleString("icon_add",null),getAction("showDialog", url,getLocaleString("add",lang)+" "+cls.getDisplayName(lang))));
        dropacc.put(cls.getClassId());
        //Iterator<SemanticClass> it2=cls.listSubClasses();
        //while(it2.hasNext())
        //{
        //    SemanticClass scls=it2.next();
        //    menus.put(getMenuItem("Agregar "+scls.getDisplayName(lang), getLocaleString("icon_add",null),getAction("showDialog", SWBPlatform.getContextPath()+"/swbadmin/jsp/SemObjectEditor.jsp?scls="+scls.getEncodedURI()+"&sref="+obj.getEncodedURI()+"&sprop="+prop.getEncodedURI(),null)));
        //    dropacc.put(scls.getClassID());
        //}

        menus.put(getMenuSeparator());
        menus.put(getMenuReload(lang));

        SemanticProperty herarprop=null;   //Herarquical property;
        Iterator<SemanticProperty> hprops=cls.listInverseHerarquicalProperties();
        if(hprops.hasNext())herarprop=hprops.next();

        //System.out.println("herarprop:"+herarprop);

        if(addChilds)
        {
            while(it.hasNext())
            {
                SemanticObject so=it.next();
                if(herarprop!=null)
                {
                    if(so.getObjectProperty(herarprop)==null)
                    {
                        addSemanticObject(childs, so,false,lang);
                    }
                }else
                {
                    addSemanticObject(childs, so,false,lang);
                }
            }
        }else
        {
            if(it.hasNext())
            {
                jobj.put("hasChilds", "true");
                JSONArray events=new JSONArray();
                jobj.putOpt("events", events);
                events.put(getEvent("onOpen", getReloadAction()));
            }
        }
    }

    //TODO:Separar en una clase treeController
    public void addResourceType(JSONArray arr, SemanticObject obj, boolean addChilds, boolean addDummy, String lang) throws JSONException
    {
        boolean hasChilds=false;
        SemanticClass cls=obj.getSemanticClass();
        SemanticObject dispobj=cls.getDisplayObject();
        String type=cls.getClassId();
        ResourceType restype=(ResourceType)obj.createGenericInstance();

        //Active
        boolean active=false;
        SemanticProperty activeprop=cls.getProperty("active");
        if(activeprop!=null)
        {
            active=obj.getBooleanProperty(activeprop);
        }

        String icon=SWBContext.UTILS.getIconClass(obj);
        JSONObject jobj=getNode(obj.getURI(), obj.getDisplayName(lang), type, icon);
        arr.put(jobj);

        //dragSupport
        if(dispobj!=null)
        {
            DisplayObject dp=(DisplayObject)dispobj.createGenericInstance();
            jobj.put("dragSupport", dp.isDragSupport());
            jobj.put("dropMatchLevel", dp.getDropMatchLevel());
        }

        //System.out.println("obj:"+obj.getId());
        //drop acceptance
        JSONArray dropacc=new JSONArray();
        jobj.putOpt("dropacc", dropacc);

        //menus
        JSONArray menus=new JSONArray();
        jobj.putOpt("menus", menus);

        if(restype.getResourceMode()!=1)
        {
            Iterator<SemanticProperty> pit=cls.listHerarquicalProperties();
            while(pit.hasNext())
            {
                SemanticProperty prop=pit.next();
                SemanticClass rcls=prop.getRangeClass();
                menus.put(getMenuItem(getLocaleString("add",lang)+" "+rcls.getDisplayName(lang), getLocaleString("icon_add",null),getAction("showDialog", SWBPlatform.getContextPath()+"/swbadmin/jsp/SemObjectEditor.jsp?scls="+rcls.getEncodedURI()+"&sref="+obj.getEncodedURI()+"&sprop="+prop.getEncodedURI(),getLocaleString("add",lang)+" "+rcls.getDisplayName(lang))));
                dropacc.put(rcls.getClassId());
            }
            menus.put(getMenuSeparator());
        }

        //Active
        if(activeprop!=null)
        {
            if(!active)
            {
                menus.put(getMenuItem(getLocaleString("active",lang), getLocaleString("icon_active",null), getAction("showStatusURL",SWBPlatform.getContextPath()+"/swbadmin/jsp/active.jsp?suri="+obj.getEncodedURI()+"&act=active",null)));
            }else
            {
                menus.put(getMenuItem(getLocaleString("unactive",lang), getLocaleString("icon_unactive",null), getAction("showStatusURL",SWBPlatform.getContextPath()+"/swbadmin/jsp/active.jsp?suri="+obj.getEncodedURI()+"&act=unactive",null)));
            }
        }

        menus.put(getMenuItem(getLocaleString("edit",lang), getLocaleString("icon_edit",null), getNewTabAction()));
        if(!obj.instanceOf(Undeleteable.swb_Undeleteable) ||  (obj.instanceOf(Undeleteable.swb_Undeleteable) && obj.getBooleanProperty(Undeleteable.swb_undeleteable)==false))
        {
            menus.put(getMenuItem(getLocaleString("delete",lang), getLocaleString("icon_delete",null), getAction("showStatusURLConfirm",SWBPlatform.getContextPath()+"/swbadmin/jsp/delete.jsp?suri="+obj.getEncodedURI(),getLocaleString("delete",lang)+" "+cls.getDisplayName(lang))));
        }
        menus.put(getMenuSeparator());

        User user=SWBContext.getSessionUser();
        boolean isfavo=user.hasFavorite(obj);
        if(!isfavo)
        {
            menus.put(getMenuItem(getLocaleString("addFavorites",lang), getLocaleString("icon_addFavorites",null), getAction("showStatusURL",SWBPlatform.getContextPath()+"/swbadmin/jsp/favorites.jsp?suri="+obj.getEncodedURI()+"&act=active",null)));
        }else
        {
            menus.put(getMenuItem(getLocaleString("deleteFavorites",lang), getLocaleString("icon_deleteFavorites",null), getAction("showStatusURL",SWBPlatform.getContextPath()+"/swbadmin/jsp/favorites.jsp?suri="+obj.getEncodedURI()+"&act=unactive",null)));
        }
        menus.put(getMenuReload(lang));

        //eventos
        JSONArray events=new JSONArray();
        jobj.putOpt("events", events);
        events.put(getEvent("onDblClick", getAction("newTab", SWBPlatform.getContextPath()+"/swbadmin/jsp/objectTab.jsp", null)));
        events.put(getEvent("onClick", getAction("getHtml", SWBPlatform.getContextPath()+"/swbadmin/jsp/viewProps.jsp?id="+obj.getEncodedURI(), "vprop")));

        //hijos
        JSONArray childs=new JSONArray();
        jobj.putOpt("children", childs);

        if(restype.getResourceMode()!=restype.MODE_CONTENT)
        {
            hasChilds=hasHerarquicalNodes(obj,lang);
            if(addChilds || !hasChilds)
            {
                addHerarquicalNodes(childs, obj,lang);

                Iterator<SemanticObject> it=obj.listHerarquicalChilds();
                if(addChilds)
                {
                    Iterator<SemanticObject> it2=SWBComparator.sortSermanticObjects(lang, it);
                    while(it2.hasNext())
                    {
                        SemanticObject ch=it2.next();
                        boolean add=true;
                        if(ch.instanceOf(Resource.ClassMgr.sclass))
                        {
                            Resource res=(Resource)ch.createGenericInstance();
                            if(res.getResourceSubType()!=null)add=false;
                            //if(add && restype.getResourceMode()==restype.MODE_SYSTEM)
                            //{
                            //    System.out.println("res.getResourceable():"+res.getResourceable());
                            //    if(res.getResourceable()!=null)add=false;
                            //}
                        }
                        if(add)addSemanticObject(childs, ch,false,lang);
                    }
                }else
                {
                    if(it.hasNext())
                    {
                        hasChilds=true;
                    }
                }
            }
            if(hasChilds && !addChilds)
            {
                if (addDummy) {
                    childs.put(getDummyNode());
                } else {
                    jobj.put("hasChilds", "true");
                }
                events.put(getEvent("onOpen", getReloadAction()));
            }
        }
    }


    public void addSemanticObject(JSONArray arr, SemanticObject obj, boolean addChilds, String lang) throws JSONException
    {
        addSemanticObject(arr, obj, addChilds, false,lang);
    }

    public void addSemanticObject(JSONArray arr, SemanticObject obj, boolean addChilds, boolean addDummy, String lang) throws JSONException
    {
        addSemanticObject(arr, obj, addChilds, addDummy, null, lang);
    }

    public void addSemanticObject(JSONArray arr, SemanticObject obj, boolean addChilds, boolean addDummy, SemanticObject virparent, String lang) throws JSONException
    {
        boolean hasChilds=false;
        SemanticClass cls=obj.getSemanticClass();
        SemanticObject dispobj=cls.getDisplayObject();
        String type=cls.getClassId();

        boolean virtual=virparent!=null;
        //System.out.println("obj:"+obj+" virtual:"+virparent);
        
        //TODO:validar treeController
        //System.out.println("type:"+type);
        if(cls.equals(ResourceType.ClassMgr.sclass))
        {
            addResourceType(arr,obj,addChilds,addDummy,lang);
            return;
        }
        //Active
        boolean active=false;
        SemanticProperty activeprop=cls.getProperty("active");
        if(activeprop!=null)
        {
            active=obj.getBooleanProperty(activeprop);
        }

        String uriext="";
        String icon=SWBContext.UTILS.getIconClass(obj);
        if(virtual)
        {
            uriext="|"+(nullnode++);
            icon="swbIconWebPageV";
        }
        JSONObject jobj=getNode(obj.getURI()+uriext, obj.getDisplayName(lang), type, icon);
        arr.put(jobj);

        //dragSupport
        if(dispobj!=null && !virtual)
        {
            DisplayObject dp=(DisplayObject)dispobj.createGenericInstance();
            jobj.put("dragSupport", dp.isDragSupport());
            jobj.put("dropMatchLevel", dp.getDropMatchLevel());
        }

        //System.out.println("obj:"+obj.getId());
        //Thread.currentThread().dumpStack();
        //drop acceptance
        JSONArray dropacc=new JSONArray();
        jobj.putOpt("dropacc", dropacc);

        //menus
        JSONArray menus=new JSONArray();
        jobj.putOpt("menus", menus);

        //TODO:separar treeController
        if(!cls.equals(WebSite.ClassMgr.sclass) && !virtual)
        {
            //menus creacion
            Iterator<SemanticProperty> pit=cls.listHerarquicalProperties();
            while(pit.hasNext())
            {
                SemanticProperty prop=pit.next();
                SemanticClass rcls=prop.getRangeClass();
                menus.put(getMenuItem(getLocaleString("add",lang)+" "+rcls.getDisplayName(lang), getLocaleString("icon_add",null),getAction("showDialog", SWBPlatform.getContextPath()+"/swbadmin/jsp/SemObjectEditor.jsp?scls="+rcls.getEncodedURI()+"&sref="+obj.getEncodedURI()+"&sprop="+prop.getEncodedURI(),getLocaleString("add",lang)+" "+rcls.getDisplayName(lang))));
                dropacc.put(rcls.getClassId());
                //add subclasess
                
                Iterator<SemanticClass> it=rcls.listSubClasses();
                while(it.hasNext())
                {
                    SemanticClass scls=it.next();
                    menus.put(getMenuItem(getLocaleString("add",lang)+" "+scls.getDisplayName(lang), getLocaleString("icon_add",null),getAction("showDialog", SWBPlatform.getContextPath()+"/swbadmin/jsp/SemObjectEditor.jsp?scls="+scls.getEncodedURI()+"&sref="+obj.getEncodedURI()+"&sprop="+prop.getEncodedURI(),getLocaleString("add",lang)+" "+scls.getDisplayName(lang))));
                    dropacc.put(scls.getClassId());
                }
                
            }
        }

        if(obj.instanceOf(WebPage.ClassMgr.sclass))
        {
            WebPage page=(WebPage)obj.createGenericInstance();
            menus.put(getMenuItem(getLocaleString("preview",lang), getLocaleString("icon_preview",null), getAction("showPreviewURL",page.getUrl(),null)));
        }
        
        if(menus.length()>0)
            menus.put(getMenuSeparator());

        //Active
        if(activeprop!=null && !virtual)
        {
            if(!active)
            {
                menus.put(getMenuItem(getLocaleString("active",lang), getLocaleString("icon_active",null), getAction("showStatusURL",SWBPlatform.getContextPath()+"/swbadmin/jsp/active.jsp?suri="+obj.getEncodedURI()+"&act=active",null)));
            }else
            {
                menus.put(getMenuItem(getLocaleString("unactive",lang), getLocaleString("icon_unactive",null), getAction("showStatusURL",SWBPlatform.getContextPath()+"/swbadmin/jsp/active.jsp?suri="+obj.getEncodedURI()+"&act=unactive",null)));
            }
        }

        menus.put(getMenuItem(getLocaleString("edit",lang), getLocaleString("icon_edit",null), getNewTabAction()));
        //menus.put(getMenuItem(getLocaleString("clone",lang), getLocaleString("icon_clone",null), getAction("showStatusURLConfirm",SWBPlatform.getContextPath()+"/swbadmin/jsp/clone.jsp?suri="+obj.getEncodedURI(),getLocaleString("clone",lang)+" "+cls.getDisplayName(lang))));
        //menu remove
        if(!virtual)
        {
            if(!obj.instanceOf(Undeleteable.swb_Undeleteable) ||  (obj.instanceOf(Undeleteable.swb_Undeleteable) && obj.getBooleanProperty(Undeleteable.swb_undeleteable)==false))
            {
                menus.put(getMenuItem(getLocaleString("delete",lang), getLocaleString("icon_delete",null), getAction("showStatusURLConfirm",SWBPlatform.getContextPath()+"/swbadmin/jsp/delete.jsp?suri="+obj.getEncodedURI(),getLocaleString("delete",lang)+" "+cls.getDisplayName(lang))));
            }
        }else
        {
            menus.put(getMenuItem(getLocaleString("deleteref",lang), getLocaleString("icon_delete",null), getAction("showStatusURLConfirm",SWBPlatform.getContextPath()+"/swbadmin/jsp/delete.jsp?suri="+obj.getEncodedURI()+"&virp="+virparent.getEncodedURI(),getLocaleString("deleteref",lang))));
        }
        menus.put(getMenuSeparator());

        //menu favoritos
        if(!virtual)
        {
            User user=SWBContext.getSessionUser();
            boolean isfavo=user.hasFavorite(obj);
            if(!isfavo)
            {
                menus.put(getMenuItem(getLocaleString("addFavorites",lang), getLocaleString("icon_addFavorites",null), getAction("showStatusURL",SWBPlatform.getContextPath()+"/swbadmin/jsp/favorites.jsp?suri="+obj.getEncodedURI()+"&act=active",null)));
            }else
            {
                menus.put(getMenuItem(getLocaleString("deleteFavorites",lang), getLocaleString("icon_deleteFavorites",null), getAction("showStatusURL",SWBPlatform.getContextPath()+"/swbadmin/jsp/favorites.jsp?suri="+obj.getEncodedURI()+"&act=unactive",null)));
            }

            //menu recargar
            //TODO:validar recarga de virtual
            menus.put(getMenuReload(lang));
         }


        //eventos
        JSONArray events=new JSONArray();
        jobj.putOpt("events", events);
        events.put(getEvent("onDblClick", getAction("newTab", SWBPlatform.getContextPath()+"/swbadmin/jsp/objectTab.jsp", null)));
        events.put(getEvent("onClick", getAction("getHtml", SWBPlatform.getContextPath()+"/swbadmin/jsp/viewProps.jsp?id="+obj.getEncodedURI(), "vprop")));

        //hijos
        JSONArray childs=new JSONArray();
        jobj.putOpt("children", childs);

        if(!virtual)
        {
            hasChilds=hasHerarquicalNodes(obj,lang);
            if(addChilds || !hasChilds)
            {
                addHerarquicalNodes(childs, obj,lang);

                boolean isWebPage=obj.instanceOf(WebPage.ClassMgr.sclass);

                Iterator<SemanticObject> it=obj.listHerarquicalChilds();
                if(addChilds)
                {
                    Iterator<SemanticObject> it2=null;
                    if(isWebPage)
                    {
                        it2=SWBComparator.sortSermanticObjects(lang,it,obj.listObjectProperties(WebPage.ClassMgr.swb_hasWebPageVirtualChild));
                    }else
                    {
                        it2=SWBComparator.sortSermanticObjects(lang,it);
                    }
                    while(it2.hasNext())
                    {
                        SemanticObject ch=it2.next();
                        SemanticObject vp=null;
                        if(isWebPage)
                        {
                            SemanticObject p=ch.getObjectProperty(WebPage.ClassMgr.swb_webPageParent);
                            //System.out.println("ch:"+ch+" p:"+p+"="+obj);
                            if(obj!=p)vp=obj;
                        }
                        //System.out.println("isVirtChild:"+isVirtChild);
                        addSemanticObject(childs, ch, false, false, vp,lang);
                    }
                }else
                {
                    if(it.hasNext())
                    {
                        hasChilds=true;
                    }else if(isWebPage)
                    {
                        hasChilds=obj.listObjectProperties(WebPage.ClassMgr.swb_hasWebPageVirtualChild).hasNext();
                    }

                }
            }
            if(hasChilds && !addChilds)
            {
                if (addDummy) {
                    childs.put(getDummyNode());
                } else {
                    jobj.put("hasChilds", "true");
                }
                events.put(getEvent("onOpen", getReloadAction()));
            }
        }
    }

/****************************************************************************/

    public void addClasses(JSONArray arr, SemanticOntology ont)  throws JSONException
    {
        Iterator<OntClass> it=ont.getRDFOntModel().listHierarchyRootClasses();
        while(it.hasNext())
        {
            OntClass cls=it.next();
            if(!cls.isAnon())
            {
                //System.out.println("cls:"+cls+" "+cls.isAnon()+" "+cls.getLocalName());
                addClass(arr, cls, ont);
            }
        }
        addClass(arr, ont.getRDFOntModel().getOntClass(SemanticVocabulary.RDF_PROPERTY), ont);
        addClass(arr, ont.getRDFOntModel().getOntClass(SemanticVocabulary.OWL_CLASS), ont);
    }

    public void addClass(JSONArray arr, OntClass cls, SemanticOntology ont) throws JSONException
    {
        boolean base=SWBPlatform.JENA_UTIL.isInBaseModel(cls, ont.getRDFOntModel());
        String icon="swbIconClass";
        if(!base)icon+="U";
        JSONObject jobj=getNode(cls.getURI()+"|"+(nullnode++), SWBPlatform.JENA_UTIL.getId(cls), "Class", icon);
        arr.put(jobj);

        //hijos
        JSONArray childs=new JSONArray();
        jobj.putOpt("children", childs);

        //eventos
        JSONArray events=new JSONArray();
        jobj.putOpt("events", events);
        events.put(getEvent("onDblClick", getAction("newTab", SWBPlatform.getContextPath()+"/swbadmin/jsp/resourceTab.jsp", null)));
        //events.put(getEvent("onClick", getAction("getHtml", SWBPlatform.getContextPath()+"/swbadmin/jsp/viewProps.jsp?id="+obj.getEncodedURI(), "vprop")));

        Iterator<OntClass> it=cls.listSubClasses(true);
        while(it.hasNext())
        {
            OntClass ccls=it.next();
            addClass(childs, ccls,ont);
        }
    }

    public void addProperties(JSONArray arr, SemanticOntology ont)  throws JSONException
    {
        Iterator<OntProperty> it=ont.getRDFOntModel().listOntProperties();
        while(it.hasNext())
        {
            OntProperty prop=it.next();
            addProperty(arr, prop, ont);
        }
    }

    public void addProperty(JSONArray arr, OntProperty prop, SemanticOntology ont) throws JSONException
    {
        boolean base=SWBPlatform.JENA_UTIL.isInBaseModel(prop, ont.getRDFOntModel());
                //isInBaseModel(prop);
        String icon="swbIconClass";
        if(!base)icon+="U";
        JSONObject jobj=getNode(prop.getURI()+"|"+(nullnode++), SWBPlatform.JENA_UTIL.getId(prop), "Property", icon);
        arr.put(jobj);

        //hijos
        JSONArray childs=new JSONArray();
        jobj.putOpt("children", childs);

        //eventos
        JSONArray events=new JSONArray();
        jobj.putOpt("events", events);
        events.put(getEvent("onDblClick", getAction("newTab", SWBPlatform.getContextPath()+"/swbadmin/jsp/resourceTab.jsp", null)));
        //events.put(getEvent("onClick", getAction("getHtml", SWBPlatform.getContextPath()+"/swbadmin/jsp/viewProps.jsp?id="+obj.getEncodedURI(), "vprop")));

        Iterator<OntProperty> it=prop.listSubProperties(true);
        while(it.hasNext())
        {
            OntProperty cprop=it.next();
            addProperty(childs, cprop,ont);
        }
    }


    
%><%
    String lang=getUserLanguage();

    SemanticOntology sont=(SemanticOntology)session.getAttribute("ontology");
    if(sont==null)
    {
        OntDocumentManager mgr=com.hp.hpl.jena.ontology.OntDocumentManager.getInstance();
        Model m=SWBPlatform.getSemanticMgr().loadRDFFileModel("file:"+SWBUtils.getApplicationPath()+"/WEB-INF/owl/swb.owl");
        mgr.addModel("http://www.semanticwebbuilder.org/swb4/ontology", m);

        //mgr.addAltEntry("http://www.semanticwebbuilder.org/swb4/ontology", "file:"+SWBUtils.getApplicationPath()+"/WEB-INF/owl/swb.owl");
        //mgr.addAltEntry("http://www.semanticwb.org/catalogs", "file:"+SWBUtils.getApplicationPath()+"/WEB-INF/owl/cat.owl");
        mgr.addAltEntry("http://www.semanticwebbuilder.org/swb4/process", "file:"+SWBUtils.getApplicationPath()+"/WEB-INF/owl/swb_process.owl");
        mgr.addAltEntry("http://www.semanticwebbuilder.org/swb4/community", "file:"+SWBUtils.getApplicationPath()+"/WEB-INF/owl/community.owl");

        //String swbowl="file:"+SWBUtils.getApplicationPath()+"/WEB-INF/owl/cat.owl";
        //java.io.File owlf=new java.io.File(swbowl);
        //SemanticModel base=SWBPlatform.getSemanticMgr().readRDFFile(owlf.getName(),swbowl);
        //sont=new SemanticOntology("", com.hp.hpl.jena.rdf.model.ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RDFS_INF,base.getRDFModel()));
        //sont=new SemanticOntology("", mgr.getOntology("http://www.semanticwb.org/catalogs", OntModelSpec.OWL_MEM_RDFS_INF));
        //sont=new SemanticOntology("", mgr.getOntology("http://www.semanticwebbuilder.org/swb4/ontology", OntModelSpec.OWL_MEM_RDFS_INF));
        sont=new SemanticOntology("", mgr.getOntology("http://www.semanticwebbuilder.org/swb4/community", OntModelSpec.OWL_MEM_RDFS_INF));
/*
        swbowl="file:"+SWBUtils.getApplicationPath()+"/WEB-INF/owl/swb.owl";
        owlf=new java.io.File(swbowl);
        SemanticModel model=SWBPlatform.getSemanticMgr().readRDFFile(owlf.getName(),swbowl);
        sont.addSubModel(model, false);
*/
        session.setAttribute("ontology", sont);

        //System.out.println("Base:"+base.getRDFModel().size());
        //System.out.println("SWB:"+model.getRDFModel().size());
        //System.out.println("Ont:"+sont.getRDFOntModel().size());
    }

    System.out.println("Inicio");
    Iterator mit=sont.getRDFOntModel().listSubModels();
    while(mit.hasNext())
    {
        OntModel model=(OntModel)mit.next();
        System.out.println(model.getNsPrefixMap());
    }
    System.out.println("fin");

    String id=request.getParameter("id");
    if(id==null)id="mtree";
    //System.out.println(new Date()+" Tree1");
    SemanticOntology ont=SWBPlatform.getSemanticMgr().getOntology();

    response.setHeader("Cache-Control", "no-cache"); 
    response.setHeader("Pragma", "no-cache"); 
    
    String suri=request.getParameter("suri");
    //System.out.println("suri:"+suri);
    if(suri==null)
    {
        JSONObject obj=new JSONObject();
        obj.put("identifier", "id");
        obj.put("label","title");
        JSONArray items=new JSONArray();
        obj.putOpt("items", items);
        if(id.equals("mtree"))addWebSites(items,lang);
        if(id.equals("muser"))addUserReps(items,lang);
        if(id.equals("mfavo"))addFavorites(items,lang);
        if(id.equals("mtra")) addWebSitesTrash(items,lang);
        if(id.equals("mdoc")) addDocRepositories(items,lang);
        if(id.equals("mclass")) addClasses(items,sont);
        if(id.equals("mprop")) addProperties(items,sont);
        out.print(obj.toString());
        //System.out.print(id);
    }else
    {
        boolean addChilds=true;
        String childs=request.getParameter("childs");
        if(childs!=null && childs.equals("false"))addChilds=false;

        JSONArray items=new JSONArray();
        if(suri.startsWith("HN|"))
        {
            StringTokenizer st=new StringTokenizer(suri,"|");
            String aux=st.nextToken();
            String ouri=st.nextToken();
            String nuri=st.nextToken();
            //System.out.println("aux:"+aux+" ouri:"+ouri+" nuri:"+nuri);
            if(ouri!=null && nuri!=null)
            {
                SemanticObject obj=ont.getSemanticObject(ouri);
                SemanticObject nobj=ont.getSemanticObject(nuri);
                //System.out.println("obj:"+obj+" node:"+nobj);
                HerarquicalNode node=new HerarquicalNode(nobj);
                addHerarquicalNode(items,node,obj,addChilds,lang);
            }
        }else
        {
            SemanticObject sobj=ont.getSemanticObject(suri);
            if(sobj!=null)
            {
                addSemanticObject(items, sobj,addChilds,lang);
                Iterator<SemanticObject> it=sobj.listHerarquicalParents();
                if(it.hasNext())
                {
                    JSONObject obj=items.getJSONObject(0);
                    obj.put("parent", it.next().getURI());
                }
            }
        }
        out.print(items.toString());
    }    

    /*
{ identifier: 'name',
  label: 'name',
  items: [
     { name:'Africa', type:'continent', children:[{ name:'Kenya', type:'country'}, {_reference:'Sudan'}] },
     { name:'Nairobi', type:'city' },
     { name:'Mombasa', type:'city' },
     { name:'Sudan', type:'country', children:{_reference:'Khartoum'} },
     { name:'Khartoum', type:'city' },
     { name:'Argentina', type:'country'}
]}
    */
    //System.out.println(new Date()+" Tree2");
%>
