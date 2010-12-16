package org.semanticwb.portal.admin.admresources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.semanticwb.portal.admin.admresources.lib.*;
import org.w3c.dom.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;

/**
 *
 * @author carlos.ramos
 */
public class Div extends WBContainerFE {
    /** The log. */
    private static Logger log = SWBUtils.getLogger(FieldSet.class);
    
    private String title=null;
    private String open=null;

    /** The tag. */
    protected Node tag = null;

    /** The base. */
    protected Resource base = null;

    /** The form. */
    FormFE form=null;

    /** The ajsfe. */
    private ArrayList ajsfe=new ArrayList();

    /** The locale. */
    private Locale locale=null;

    /**
     * Instantiates a new field set.
     *
     * @param id the id
     */
    public Div(String id) {
        this.id = id;
    }

    /**
     * Creates a new instwance with the default parameters.
     *
     * @param tag the tag
     * @param base the base
     * @param form the form
     */
    public Div(Node tag, Resource base, FormFE form) {
        this.tag = tag;
        setAttributes();
        this.base=base;
        this.form=form;
        createObjs();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getOpen() {
        return open;
    }

    /**
     * Obtiene el html(xml) final del elemento para mostrar en la admin del recurso
     * obtains the final xml element to show in the resource admin.
     *
     * @return the html
     */
    @Override
    public String getHtml(){
        StringBuilder ret=new StringBuilder("");
        String xml="";
        try
        {
            Document dom=SWBUtils.XML.getNewDocument();
            if(dom!=null)
            {
                Element child=dom.createElement("div");
//                if(name!=null) {
//                    child.setAttribute("name",name);
//                }
                if(id!=null) {
                    child.setAttribute("id",id);
                }
//                if(style!=null) {
//                    child.setAttribute("style",style);
//                }
                if(styleclass!=null) {
                    child.setAttribute("class",styleclass);
                    System.out.println("\n\n\n**************************\nponiendo class");
                }
//                if(moreattr!=null) {
//                    child.setAttribute("moreattr",moreattr);
//                }
                if(title!=null) {
                    child.setAttribute("title",title);
                    System.out.println("\n\n\n**************************\nponiendo title");
                }
                if(open!=null) {
                    child.setAttribute("open",open);
                    System.out.println("\n\n\n**************************\nponiendo open");
                }
                dom.appendChild(child);

                xml=SWBUtils.XML.domToXml(dom, "ISO-8859-1", true);
                if(xml!=null && !"".equals(xml.trim())) {
                    xml=xml.substring(xml.indexOf("<div"), xml.indexOf("/>", xml.indexOf("<div"))) + ">";
                    System.out.println(xml);
                }
                else {
                    xml="";
                }
            }
        }catch(Exception e) {
            log.error(e);
        }
        ret.append(xml);
        ret.append(show());
        ret.append("\n</div>");
        return ret.toString();
    }

    /* (non-Javadoc)
     * @see org.semanticwb.portal.admin.admresources.lib.WBContainerFE#getJscripsFE()
     */
    @Override
    public Iterator getJscripsFE(){
        return ajsfe.iterator();
    }

    /**
     * Gets the size js fe.
     *
     * @return the size js fe
     */
    public int getSizeJsFE(){
        return ajsfe.size();
    }

    //Sets
    /**
     * Sets the locale.
     *
     * @param locale the new locale
     */
    public void setLocale(Locale locale){
        this.locale=locale;
    }

    //gets
    /**
     * agrega el action del elemento forma.
     *
     * @return the locale
     */
    public Locale getLocale(){
        return this.locale;
    }

     /**
      * Gets the js fe.
      *
      * @return the js fe
      */
     public String getJsFE(){
        StringBuilder strb=new StringBuilder();
        Iterator ijsfeObj=ajsfe.iterator();
        while(ijsfeObj.hasNext()){
            WBJsValidationsFE js_valfe=(WBJsValidationsFE)ijsfeObj.next();
            strb.append(js_valfe.getHtml(getLocale()));
        }
        return strb.toString();
    }

     /* (non-Javadoc)
      * @see org.semanticwb.portal.admin.admresources.lib.WBContainerFE#add(java.lang.Object)
      */
    @Override
     public void add(Object obj){
       super.add(obj);
       addJSFormFE(obj);
    }

     /**
      * Adds the js form fe.
      *
      * @param obj the obj
      */
     private void addJSFormFE(Object obj){
         if(obj instanceof WBJsInputFE){
           WBJsInputFE objInJs=(WBJsInputFE)obj;
           Object[] js_Objs=objInJs.getJsValObj();
           for(int i=0;i<js_Objs.length;i++){
               if(js_Objs[i] instanceof WBJsValidationsFE){
                   WBJsValidationsFE js_valfe=(WBJsValidationsFE)js_Objs[i];
                   js_valfe.setFormFEName(getName());
                   ajsfe.add(js_valfe);
               }
           }
         }
    }

    /* (non-Javadoc)
     * @see org.semanticwb.portal.admin.admresources.lib.WBContainerFE#setAttributes()
     */
    @Override
    final public void setAttributes() {
        if (tag != null) {
            NamedNodeMap nnodemap = tag.getAttributes();
            if (nnodemap.getLength() > 0) {
                for (int i = 0; i < nnodemap.getLength(); i++) {
                    String attrName = nnodemap.item(i).getNodeName();
                    String attrValue = nnodemap.item(i).getNodeValue();
                    if (attrValue != null && !attrValue.equals("")) {
                        //defecto
                        if (attrName.equalsIgnoreCase("id")) {
                            id = attrValue;
                        } else if (attrName.equalsIgnoreCase("title")) {
                            title = attrValue;
                        } else if (attrName.equalsIgnoreCase("class")) {
                            styleclass = attrValue;
                        } else if (attrName.equalsIgnoreCase("open")) {
                            open = attrValue;
                        } 
                    }
                }
            }
        }
    }

    /**
     * Crea objetos html de acuerdo a tags del xml de la administraciï¿½n de los recursos
     * Creates html objects according with the tags of xml admin resources.
     */
    private void createObjs() {
        if (tag != null) {
            NodeList ndlchilds = tag.getChildNodes();
            for (int i = 0; i < ndlchilds.getLength(); i++)
            {
                Node node=ndlchilds.item(i);
                if (node.getNodeName().equalsIgnoreCase("INPUT")) {
                    String type = findType(node);
                    if (type != null) {
                        if (type.equalsIgnoreCase("TEXT")) {
                            TextFE textfe = new TextFE(node);
                            textfe.setFormFE(form);
                            this.add(textfe);
                        } else if (type.equalsIgnoreCase("PASSWORD")) {
                            PasswordFE passwordfe = new PasswordFE(node);
                            passwordfe.setFormFE(form);
                            this.add(passwordfe);
                        } else if (type.equalsIgnoreCase("FILE")) {
                            FileFE filefe = new FileFE(node);
                            filefe.setFormFE(form);
                            this.add(filefe);
                        } else if (type.equalsIgnoreCase("CHECKBOX")) {
                            CheckBoxFE checkboxfe = new CheckBoxFE(node);
                            checkboxfe.setFormFE(form);
                            this.add(checkboxfe);
                        } else if (type.equalsIgnoreCase("RADIO")) {
                            RadioFE radiofe = new RadioFE(node);
                            radiofe.setFormFE(form);
                            this.add(radiofe);
                        } else if (type.equalsIgnoreCase("SUBMIT")) {
                            SubmitFE submitfe = new SubmitFE(node, form);
                            submitfe.setFormFE(form);
                            this.add(submitfe);
                        } else if (type.equalsIgnoreCase("RESET")) {
                            ResetFE resetfe = new ResetFE(node);
                            resetfe.setFormFE(form);
                            this.add(resetfe);
                        } else if (type.equalsIgnoreCase("HIDDEN")) {
                            HiddenFE hiddenfe = new HiddenFE(node);
                            hiddenfe.setFormFE(form);
                            this.add(hiddenfe);
                        } else if (type.equalsIgnoreCase("BUTTON")) {
                            ButtonFE buttonfe = new ButtonFE(node);
                            buttonfe.setFormFE(form);
                            this.add(buttonfe);
                        }
                    }
                } else {
                    if (node.getNodeName().equalsIgnoreCase("SELECT")) {
                        SelectFE selectfe = new SelectFE(node);
                        selectfe = (SelectFE) addChildsFE(node, selectfe);
                        selectfe.setAdmDBConnMgr(form.getAdmDBConnMgr());
                        selectfe.setFormFE(form);
                        this.add(selectfe);
                    } else if (node.getNodeName().equalsIgnoreCase("TEXTAREA")) {
                        TextAreaFE textareafe = new TextAreaFE(node);
                        textareafe.setFormFE(form);
                        this.add(textareafe);
                    } else if (node.getNodeName().equalsIgnoreCase("IMG")) {
                        ImgFE imgfe = new ImgFE(node);
                        imgfe.setFormFE(form);
                        this.add(imgfe);
                    } else if (node.getNodeName().equalsIgnoreCase("MAP")) {
                        MapFE mapfe = new MapFE(node);
                        mapfe.setAdmDBConnMgr(this.getAdmDBConnMgr());
                        mapfe = (MapFE) addChildsMapFE(node, mapfe);
                        mapfe.setAdmDBConnMgr(form.getAdmDBConnMgr());
                        this.add(mapfe);
                    } else if (node.getNodeName().equalsIgnoreCase("APPLET")) {
                        AppletFE appletfe = new AppletFE(node);
                        appletfe.setAdmDBConnMgr(this.getAdmDBConnMgr());
                        appletfe = (AppletFE) addChildsAppletFE(node, appletfe);
                        appletfe.setAdmDBConnMgr(form.getAdmDBConnMgr());
                        this.add(appletfe);
                    } else if (node.getNodeName().equalsIgnoreCase("CALENDAR")) {
                        CalendarFE calendarfe = new CalendarFE(node);
                        calendarfe.setAdmDBConnMgr(form.getAdmDBConnMgr());
                        this.add(calendarfe);
                    } else if ((node.getNodeName().equalsIgnoreCase("statictext") || node.getNodeName().equalsIgnoreCase("script"))) {
                        //HtmlFE htmlfe = new HtmlFE(tag);
                        //TODO:check if the base needs to be passed to other tags, if yes it need to be declared in the WBAdmResource interface
                        HtmlFE htmlfe = new HtmlFE(node, base);
                        htmlfe.setFormFE(form);
                        this.add(htmlfe);
                    } else if (node.getNodeName().equalsIgnoreCase("fieldset")) {
                        //HtmlFE htmlfe = new HtmlFE(tag);
                        //TODO:check if the base needs to be passed to other tags, if yes it need to be declared in the WBAdmResource interface
                        FieldSet fieldset = new FieldSet(node, base, form);
                        fieldset.setAdmDBConnMgr(form.getAdmDBConnMgr());
                        this.add(fieldset);
                    }
                }
            }
        }
    }

    /**
     * Find type.
     *
     * @param tag the tag
     * @return the string
     */
    private String findType(Node tag) {
        String type = null;
        NamedNodeMap nnodemap = tag.getAttributes();
        for (int i = 0; i < nnodemap.getLength(); i++) {
            if (nnodemap.item(i).getNodeName().equalsIgnoreCase("type")) {
                type = nnodemap.item(i).getNodeValue();
            }
        }
        return type;
    }

    /**
     * Adds the childs fe.
     *
     * @param tag the tag
     * @param obj the obj
     * @return the object
     */
    private Object addChildsFE(Node tag, Object obj) {
        NodeList ndlchilds = tag.getChildNodes();
        if(ndlchilds.getLength() > 0) {
            for(int i = 0; i < ndlchilds.getLength(); i++) {
                if(ndlchilds.item(i).getNodeName().startsWith("#text") || !(obj instanceof SelectFE)){
                    continue;
                }
                SelectFE selecFe = (SelectFE)obj;
                if(ndlchilds.item(i).getNodeName().equalsIgnoreCase("Option")) {
                    OptionSelectFE optionselfe = new OptionSelectFE(ndlchilds.item(i));
                    selecFe.add(optionselfe);
                    obj = selecFe;
                }
            }

        }
        return obj;
    }

    /**
     * Adds the childs applet fe.
     *
     * @param tag the tag
     * @param obj the obj
     * @return the object
     */
    private Object addChildsAppletFE(Node tag, Object obj) {
        NodeList ndlchilds = tag.getChildNodes();
        if(ndlchilds.getLength() > 0) {
            for(int i = 0; i < ndlchilds.getLength(); i++) {
                if(ndlchilds.item(i).getNodeName().startsWith("#text") || !(obj instanceof AppletFE))
                {continue;}
                AppletFE appletfe = (AppletFE)obj;
                if(ndlchilds.item(i).getNodeName().equalsIgnoreCase("Param")) {
                    ParamAppletFE paramappfe = new ParamAppletFE(ndlchilds.item(i));
                    paramappfe.setAdmDBConnMgr(appletfe.getAdmDBConnMgr());
                    appletfe.add(paramappfe);
                    obj = appletfe;
                }
            }
        }
        return obj;
    }

    /**
     * Adds the childs map fe.
     *
     * @param tag the tag
     * @param obj the obj
     * @return the object
     */
    private Object addChildsMapFE(Node tag, Object obj) {
        NodeList ndlchilds = tag.getChildNodes();
        if(ndlchilds.getLength() > 0) {
            for(int i = 0; i < ndlchilds.getLength(); i++) {
                if(ndlchilds.item(i).getNodeName().startsWith("#text") || !(obj instanceof MapFE))
                {continue;}
                MapFE mapfe = (MapFE)obj;
                if(ndlchilds.item(i).getNodeName().equalsIgnoreCase("Area")) {
                    AreaMapFE areamapfe = new AreaMapFE(ndlchilds.item(i));
                    areamapfe.setAdmDBConnMgr(mapfe.getAdmDBConnMgr());
                    mapfe.add(areamapfe);
                    obj = mapfe;
                }
            }
        }
        return obj;
    }
}
