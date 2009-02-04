/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.portal.admin.resources;

import java.io.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.SWBProperties;
import org.semanticwb.model.*;
import org.semanticwb.portal.api.*;

/**
 *
 * @author juan.fernandez
 */
public class SWBAProperties extends GenericResource {

    private Logger log = SWBUtils.getLogger(SWBAProperties.class);
    ArrayList properties;
    SWBProperties prop;
    Portlet base;
    
    /** Creates a new instance of WBAProperties */
    public SWBAProperties() {
    }
    
    /**
     * Init the resource
     * @throws AFException an exception of type AFException
     */    
    @Override
    public void init() throws SWBResourceException {
        properties=new ArrayList();
        properties.add("db.properties");
        //properties.add("license.properties");
        properties.add("startup.properties");
        //properties.add("user.properties");
        properties.add("web.properties");
        properties.add("logging.properties");
        properties.add("System.properties");
    }
    
    /** Init the resource base configuration
     * @param base a resource in the data base
     * @throws AFException an exception of type AFException
     */    
    @Override
    public void setResourceBase(Portlet base) throws SWBResourceException
    {
        super.setResourceBase(base);

        String fileSelected = base.getProperty("uptPropFile");
        //fileSelected ="web.properties";  //quitar, es solo para pruebas
        if(fileSelected==null)return;
        if(fileSelected.equals("web.properties"))
        {
            prop = (SWBProperties) SWBPlatform.getWebProperties();
//        }else if(fileSelected.equals("workflow.properties"))
//        {
//            prop = com.infotec.workflow.manager.ProcessManagerConfig.getInstance().getProperties();
        }else if(fileSelected.equals("System.properties"))
        {
            prop = new SWBProperties(System.getProperties());
            prop.setReadOnly(true);
        }else
        {
            InputStream is = getClass().getResourceAsStream("/"+fileSelected);  
            prop = new SWBProperties();     
            try
            {
                prop.load(is);
            } catch (Exception e)
            {
                log.error("Can't read the properties file. " +
                               "Make sure "+fileSelected+" is in the CLASSPATH",e);
            }            
        }     
    } 

     /** Requested action of the WBAProperties resource
     * @param request input parameters
     * @param response an answer to the request and a list of objects (topic, user, action, ...)
     * @throws AFException an AF Exception
     * @throws IOException an IO Exception
     */  
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        base = getResourceBase();

        String fileSelected = base.getProperty("uptPropFile");
       
        String accion = response.getAction();
        if(accion==null) accion = request.getParameter("act");
        String keyID = request.getParameter("id");
        if(keyID!=null&&keyID.trim().length()==0) keyID=null;
        String comentario = request.getParameter("comentario");
        String valor = request.getParameter("valor");
        String newKey = request.getParameter("llave");
        
        if(accion!=null){
            if(accion.equals("update")){
                if(newKey!=null){
                    if(keyID!=null){
                        if(!keyID.equals(newKey)){
                            prop.remove(keyID);
                            prop.setProperty(newKey,valor,comentario);
                        }
                        else prop.setProperty(keyID,valor,comentario);
                    }
                    else prop.setProperty(newKey,valor,comentario);
                }
                response.setMode(response.Mode_VIEW);
                //TODO:no se utiliza
                //SWBUtils.getInstance().refresh();
            }
            if(accion.equals("remove")){
                if(keyID!=null) prop.remove(keyID);
                response.setMode(response.Mode_VIEW);
            }
            if(accion.equals("rollback")){
                //cargar de nuevo el archivo properties a memoria
                InputStream fins = getClass().getResourceAsStream("/"+fileSelected);
                prop.load(fins);
                response.setMode(response.Mode_VIEW);
            }
            if(accion.equals("commit")){
                //guarda los cambio hechos al archivo properties
                FileOutputStream fouts = new FileOutputStream(SWBUtils.getApplicationPath()+"/WEB-INF/classes/" + fileSelected);
                prop.store(fouts,null);
                response.setMode(response.Mode_VIEW);
            }
            if(accion.equals("uptPropFile")){
                if(request.getParameter("propFile")!=null){
                    base.setProperty("uptPropFile", request.getParameter("propFile"));
                    //base.updateAttributesToDB();
                }
                response.setMode(response.Mode_ADMIN);
                //response.setMode(response.Mode_VIEW);
            }
            
        }
        
    }

    /** User view of WBAProperties resource
     * @param request input parameters
     * @param response an answer to the request
     * @param paramRequest a list of objects (topic, user, action, ...)
     * @throws AFException an AF Exception
     * @throws IOException an IO Exception
     */   
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        base = getResourceBase();
        String accion = request.getParameter("act");
        
        PrintWriter out = response.getWriter();
        String fileSelected = base.getProperty("uptPropFile");
        if(null==fileSelected) doAdmin(request, response, paramRequest);
        if(accion==null) accion="";
        if(accion.equals("")){

            out.println("<div class=\"swbform\">");
            out.println("<fieldset>");
            out.println("<table cellpadding=10 cellspacing=0 >");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th >"+paramRequest.getLocaleString("msgRemove")+"</th>");
            out.println("<th >"+paramRequest.getLocaleString("msgKey")+"</th>");
            out.println("<th >"+paramRequest.getLocaleString("msgValue")+"</th>");
            out.println("<th >"+paramRequest.getLocaleString("msgComment")+"</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            String rowColor="";
            boolean cambiaColor = true;
            Enumeration ite = prop.propertyOrderedNames();
            while(ite.hasMoreElements()) {
                String key = (String) ite.nextElement();
                String comment = prop.getComment(key);
                if(comment==null)comment="";
                String value = prop.getProperty(key);
                if(value==null)value="";
                SWBResourceURL urlEdit = paramRequest.getRenderUrl();
                urlEdit.setMode(paramRequest.Mode_EDIT);
                urlEdit.setParameter("act","edit");
                urlEdit.setParameter("id",key);
                SWBResourceURL urlRemove = paramRequest.getActionUrl();
                urlRemove.setParameter("act","remove");
                urlRemove.setParameter("id",key);
//                rowColor="#EFEDEC";
//                if(!cambiaColor) rowColor="#FFFFFF";
//                cambiaColor = !(cambiaColor);
                out.println("<tr >"); //bgcolor=\""+rowColor+"\"
                out.println("<td >");
                if(!prop.isReadOnly())out.println("<a class=\"link\" href=\""+urlRemove.toString()+"\" onclick=\"if(confirm('"+paramRequest.getLocaleString("msgAlertRemoveProperty")+"?')) { return(true);} else {return(false);}\"><img border=0 src=\""+SWBPlatform.getContextPath()+"/swbadmin/images/delete.gif\" alt=\""+paramRequest.getLocaleString("msgLinkRemove")+"\"></a>");
                out.println("</td>");
                out.println("<td >");
                if(!prop.isReadOnly())out.println("<a class=\"link\" href=\""+urlEdit.toString()+"\">"+key+"</a>");
                else out.println(key);
                out.println("</td>");
                out.println("<td >"+value+"</td>");
                out.println("<td ><PRE >"+comment+"</PRE></td>");
                
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("<fieldset>");
//            out.println("<tfoot>");
//            out.println("<tr>");
//            out.println("<td colspan=4 ><HR size=\"1\" noshade>");
//
            if(prop.hasChangeIt()){
                SWBResourceURL urlRoll = paramRequest.getActionUrl();
                urlRoll.setParameter("act","rollback");
                
                SWBResourceURL urlCommit = paramRequest.getActionUrl();
                urlCommit.setParameter("act","commit");
                
                out.println("<button dojoType=\"dijit.form.Button\" type=\"button\" name=\""+base.getId()+"/btnCommit\" onclick=\"if(confirm('"+paramRequest.getLocaleString("msgAlertSaveallChanges")+"?')) {submitUrl('" + urlCommit + "',this.domNode);} return false;\">"+paramRequest.getLocaleString("msgBtnCommit")+"</button>");
                out.println("<button dojoType=\"dijit.form.Button\" type=\"button\" name=\""+base.getId()+"/btnRollback\" onclick=\"if(confirm('"+paramRequest.getLocaleString("msgAlertRestoreAllValues")+"?')) {submitUrl('" + urlRoll + "',this.domNode);} return false;\">"+paramRequest.getLocaleString("msgBtnRollback")+"</button>");
               // out.println("<input type=button class=\"boton\" name=btnRollback value=\""+paramRequest.getLocaleString("msgBtnRollback")+"\" onclick=\"if(confirm('"+paramRequest.getLocaleString("msgAlertRestoreAllValues")+"?')) {window.location='"+urlRoll.toString()+"';}\">");
            }
            
            SWBResourceURL urlAdd = paramRequest.getRenderUrl();
            urlAdd.setMode(paramRequest.Mode_EDIT);
            urlAdd.setParameter("act","add");
            if(!prop.isReadOnly())out.println("<button dojoType=\"dijit.form.Button\" type=button name=\""+base.getId()+"/btnAdd\" onclick=\"submitUrl('"+urlAdd.toString()+"',this.domNode); return false;\">"+paramRequest.getLocaleString("msgBtnAdd")+"</button>");
//            out.println("</td>");
//            out.println("</tr>");
//            out.println("</tfoot>");
//            out.println("</table>");
            out.println("</fieldset>");
            out.println("</div>");
        }
        
        
    }

     /** Edit view of WBAProperties resource
     * @param request input parameters
     * @param response an answer to the request
     * @param paramRequest a list of objects (topic, user, action, ...)
     * @throws AFException an AF Exception
     * @throws IOException an IO Exception
     */
    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        base = getResourceBase();
        String accion = request.getParameter("act");
        
        PrintWriter out = response.getWriter();
        String fileSelected = base.getProperty("uptPropFile");
        
        if(accion==null) accion="";
        if(accion.equals("edit")||accion.equals("add")) {
            String id=request.getParameter("id");
            String strKey="";
            String strValue="";
            String strComment="";
            String msgTitle = paramRequest.getLocaleString("msgKeyDefinition");
            if(accion.equals("edit")&&id!=null){
                msgTitle = paramRequest.getLocaleString("msgKeyEdition");
                strKey = id;
                strValue = prop.getProperty(id);
                strComment = prop.getComment(id);
            }
            
            out.println("<script>");
            out.println("   function valida(forma) {");
            out.println("       ");
            out.println("       ");
            out.println("       var tmp = forma.llave.value;     ");
            out.println("       trim(forma.llave);     ");
            out.println("       if(forma.llave.value=='')");
            out.println("       {   alert('"+paramRequest.getLocaleString("alertKeyMissing")+"');");
            out.println("           forma.llave.value=tmp;");
            out.println("           forma.llave.focus();     ");
            out.println("           forma.llave.select();     ");
            out.println("           return(false);");
            out.println("       }");
            out.println("       forma.llave.value=tmp;");
            out.println("       tmp = forma.valor.value;     ");
            out.println("       trim(forma.valor);     ");
            out.println("       if(forma.valor.value=='')");
            out.println("       {   alert('"+paramRequest.getLocaleString("alertValueMissing")+"');");
            out.println("           forma.valor.value=tmp;");
            out.println("           forma.valor.focus();     ");
            out.println("           forma.valor.select();     ");
            out.println("           return(false);");
            out.println("       }");
            out.println("       forma.valor.value=tmp;");
            out.println("       return (true);");
            out.println("   }");
            out.println("    function trim(field) {     ");
            out.println("         var retVal = '';     ");
            out.println("         var start = 0;     ");
            out.println("         while ((start < field.value.length) && (field.value.charAt(start) == ' ')) {     ");
            out.println("              ++start;     ");
            out.println("         }     ");
            out.println("         var end = field.value.length;     ");
            out.println("         while ((end > 0) && (field.value.charAt(end - 1) == ' ')) {     ");
            out.println("              --end;     ");
            out.println("         }     ");
            out.println("         retVal = field.value.substring(start, end);     ");
            out.println("         if (end == 0)     ");
            out.println("              field.value='';     ");
            out.println("         else     ");
            out.println("              field.value=retVal;          ");
            out.println("    }              ");
            out.println("</script>");

//            SWBResourceURL urla = paramRequest.getRenderUrl();
//            urla.setMode(SWBResourceURL.Mode_VIEW);
//
//            out.println("<a href=\"#\" onclick=\"window.location='"+urla+"'\">view</a>");
            out.println("<div class=\"swbform\">");
            //out.println("	<legend> Properties file edition. "+fileSelected+"</legend>");
            out.println("<form dojoType=\"dijit.form.Form\" id=\""+id+"/fnewkey\" name=\"frmAdd\" method=post action=\""+paramRequest.getActionUrl().setAction("update").toString()+"\" onsubmit=\"if(valida(frmAdd)) submitForm('"+id+"/fnewkey'); return false; \" >");
            out.println("<fieldset>");
            out.println("<table cellpadding=10 cellspacing=0 width=98%>");
            out.println("<tr>");
            out.println("<td colspan=2 class=\"tabla\">"+msgTitle+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class=\"datos\" align=right width=150>"+paramRequest.getLocaleString("msgKey")+": </td>");
            out.println("<td class=\"valores\"><input type=text class=\"campos\" value=\""+strKey+"\" name=llave size=50><input type=hidden name=id value=\""+strKey+"\"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class=\"datos\" align=right width=150>"+paramRequest.getLocaleString("msgValue")+": </td>");
            out.println("<td class=\"valores\"><input type=text class=\"campos\" value=\""+strValue+"\" name=valor size=50></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td class=\"datos\" align=right width=150>"+paramRequest.getLocaleString("msgComment")+": </td>");
            out.println("<td class=\"valores\"><textarea class=\"campos\" cols=50 rows=10 name=comentario>"+strComment+"</textarea></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("<fieldset>");
//            out.println("<tr>");
//            out.println("<td colspan=2 class=\"tabla\" align=\"right\"><HR size=\"1\" noshade>");
            
            SWBResourceURL urlBack = paramRequest.getRenderUrl();
            urlBack.setMode(paramRequest.Mode_VIEW);
            
            out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\" name=\""+base.getId()+"/btnSend\" >"+paramRequest.getLocaleString("msgBtnSend")+"</button>");
            out.println("<button dojoType=\"dijit.form.Button\" type=\"button\" name=\""+base.getId()+"/btnCancel\" onclick=\"submitUrl('"+urlBack.toString()+"',this.domNode); return false;\">"+paramRequest.getLocaleString("msgBtnCancel")+"</button>");
//            out.println("</td>");
//            out.println("</tr>");
//            out.println("</table>");
            
            out.println("</fieldset>");
            out.println("</form>");
            out.println("</div>");
            
        }
    }

    /** Admin view of WBAProperties resource
     * @param request input parameters
     * @param response an answer to the request
     * @param paramRequest a list of objects (topic, user, action, ...)
     * @throws AFException an AF Exception
     * @throws IOException an IO Exception
     */   
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        base = getResourceBase();
        PrintWriter out = response.getWriter();
        String fileSelect = "";
        if(base.getProperty("uptPropFile")!=null) fileSelect=base.getProperty("uptPropFile");
        out.println("<div class=\"swbform\">");
        out.println("<form dojoType=\"dijit.form.Form\" id=\""+getResourceBase().getId()+"/doAdmin\" method=post action=\""+paramRequest.getActionUrl().setAction("uptPropFile").toString()+"\" onsubmit=\"submitForm('"+getResourceBase().getId()+"/doAdmin'); return false;\">");
        out.println("<fieldset>");
        //out.println("	<legend> Properties file edition. "+fileSelect+"</legend>");
        out.println("<table cellpadding=10 cellspacing=0 width=98%>");
        out.println("<tr>");
        out.println("<td colspan=2 class=\"tabla\">"+paramRequest.getLocaleString("msgSelectPropertyFile")+"</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"datos\" align=right width=150>"+paramRequest.getLocaleString("msgExistingFiles")+": </td>");
        out.println("<td class=\"valores\">");
        out.println("<select class=\"campos\" name=\"propFile\" >");
        
        Iterator it=properties.iterator();
        while(it.hasNext())
        {
            String name=(String)it.next();
            String strSelect ="";
            if(fileSelect.trim().equals(name)) strSelect = "selected";
            out.println("<option value=\""+name+"\" "+strSelect+">"+name+"</option>");
        }

        out.println("</select>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</fieldset>");
        out.println("<fieldset>");
//        out.println("<tr>");
//        out.println("<td colspan=2 class=\"tabla\" align=\"right\"><HR size=\"1\" noshade>");
        out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"btnSend\">"+paramRequest.getLocaleString("msgBtnSend")+"</button>");
//        out.println("</td>");
//        out.println("</tr>");
        out.println("</fielset>");
        out.println("</form>");
        out.println("</div>");
       
    }
}
