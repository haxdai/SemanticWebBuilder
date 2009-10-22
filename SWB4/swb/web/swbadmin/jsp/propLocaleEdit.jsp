<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="org.semanticwb.*,org.semanticwb.model.*,org.semanticwb.platform.*,org.semanticwb.portal.*,java.util.*,org.semanticwb.base.util.*"%>
<%
    User user=SWBContext.getSessionUser();
    String lang="es";
    if(user!=null)lang=user.getLanguage();
    response.setHeader("Cache-Control", "no-cache"); 
    response.setHeader("Pragma", "no-cache"); 
    String suri=request.getParameter("suri");
    String prop=request.getParameter("prop");
    String slang=request.getParameter("lang");
    String val=request.getParameter("val");
    SemanticOntology ont=SWBPlatform.getSemanticMgr().getOntology();
    SemanticObject sobj=ont.getSemanticObject(suri);
    SemanticProperty sprop=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(prop);

    //System.out.println("suri:"+suri);
    //System.out.println("prop:"+prop);
    //System.out.println("lang:"+slang);
    //System.out.println("val:"+val);

    if(val==null)
    {
        String name=sprop.getName();
        StringBuffer ret=new StringBuffer();
        ret.append("<form dojoType=\"dijit.form.Form\" class=\"swbform\">");
        ret.append(" <fieldset>");
        ret.append("    <table>");
        Iterator<SemanticObject> it=sobj.getModel().listInstancesOfClass(Language.ClassMgr.sclass);
        while(it.hasNext())
        {
            Language lng=(Language)it.next().getGenericInstance();
            ret.append("      <tr>");
            ret.append("        <td><label>"+lng.getDisplayTitle(lang)+":</label></td>");
            String sval=sobj.getProperty(sprop,"",lng.getId());
            //print(sval);
            String update="getSyncHtml('"+SWBPlatform.getContextPath()+"/swbadmin/jsp/propLocaleEdit.jsp?";
            update+="suri="+sobj.getEncodedURI();
            update+="&prop="+sprop.getEncodedURI();
            update+="&lang="+lng.getId();
            update+="&val='+encodeURIComponent(this.value)+'";
            update+="');";
            
            if(sobj.getSemanticClass().getDisplayNameProperty().equals(sprop) && lng.getId().equals(lang))
            {
                String icon=SWBContext.UTILS.getIconClass(sobj);
                //update+="setTabTitle('"+sobj.getURI()+"',this.value,'"+icon+"');";
                update+="updateTreeNodeByURI('"+sobj.getURI()+"');";
            }
            ret.append("        <td><input dojoType=dijit.form.TextBox type=\"text\" name=\""+name+":"+lng.getId()+"\" value=\""+sval+"\" onChange=\""+update+"\"/></td>");
            ret.append("      </tr>");
        }
        ret.append("    </table>");
        ret.append(" </fieldset>");
        String script="hideDialog();";

        ret.append(" <button dojoType=dijit.form.Button onclick=\""+script+"\" name=\"save\">Aceptar</button>");

        ret.append("</form>");
        out.println(ret.toString());
    }else
    {
        if(val.length()==0)
        {
            sobj.removeProperty(sprop,slang);
        }else
        {
            val=SWBUtils.TEXT.decode(val, "utf8");
            if(slang!=null && slang.length()>0)
            {
                sobj.setProperty(sprop, val, slang);
            }else
            {
                sobj.setProperty(sprop, val);
            }
        }

    }
%>