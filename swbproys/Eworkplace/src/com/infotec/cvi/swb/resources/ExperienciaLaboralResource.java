package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.ExperienciaLaboral;
import com.infotec.cvi.swb.Sector;
import com.infotec.eworkplace.swb.Telefono;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author carlos.ramos
 */
public class ExperienciaLaboralResource extends GenericResource {
    private Logger log = SWBUtils.getLogger(ExperienciaLaboralResource.class);
    private List<Sector> sectors;
    

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        Iterator<Sector> isectors = Sector.ClassMgr.listSectors(base.getWebSite());
        if(isectors.hasNext())
            sectors = SWBUtils.Collections.copyIterator(isectors);
        else
            sectors = new ArrayList();
    }


    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        PrintWriter out =  response.getWriter();
        String lang = user.getLanguage();
        
        //Experiencia laboral
        CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
        if(cv==null) {
            cv = CV.ClassMgr.createCV(user.getId(), wsite);
            cv.setPropietario(user);
        }
System.out.println("user.equals(cv.getPropietario())="+user.equals(cv.getPropietario()));
        //if(cv!=null && user.equals(cv.getPropietario())) {
        if(cv!=null) {
            Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));
            final String axn = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD).toString();
            StringBuilder htm = new StringBuilder();
            htm.append(script(lang));
System.out.println("msg="+SWBUtils.XML.replaceXMLChars(request.getParameter("msg")));
            if(request.getParameter("msg")!=null) {
                htm.append("<script type=\"text/javascript\">\n");
                htm.append("<!--\n");
                //htm.append("alert('"+SWBUtils.XML.replaceXMLChars(request.getParameter("msg"))+"');");
                htm.append("dojo.addOnLoad(function() {alert('"+SWBUtils.XML.replaceXMLChars(request.getParameter("msg"))+"')})\n");
                htm.append("-->\n");
                htm.append("</script>\n");
            }
            
            
            htm.append("<form method=\"post\" dojoType=\"dijit.form.Form\" action=\""+axn+"\">");
            htm.append("  <div class=\"contacto_externo divisor\">");
            Iterator<ExperienciaLaboral> experiencias = cv.listExperienciaLaborals();
            htm.append("   <ol id=\"fms\">");
            if(experiencias.hasNext()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", locale);
                //SWBResourceURL rem = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWBResourceURL.Action_REMOVE);
                SWBResourceURL rem = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_REMOVE);
                ExperienciaLaboral experiencia;
                while(experiencias.hasNext()) {
                    experiencia = experiencias.next();
                    rem.setParameter("oid", experiencia.getId());
                    htm.append("<li class=\"aaaa\">");
                    htm.append("  <p class=\"tercio\"><label>Trabajo actual <input type=\"checkbox\" name=\"cur\" value=\"1\" "+(experiencia.isActual()?"checked=\"checked\"":"")+"/></label></p>");
                    htm.append("  <p class=\"tercio\"><label>*Empresa</label><input type=\"text\" name=\"emp\" value=\""+experiencia.getEmpresa()+"\" /></p>");
                    htm.append("  <p class=\"entero\"><label>*Sector</label><select name=\"sctr\"><option value=\"\"></option>");
                    for(Sector sector:sectors) {
                        if(sector.equals(experiencia.getSector()))
                            htm.append("<option value=\""+sector.getId()+"\" selected=\"selected\">"+sector.getDisplayTitle(lang) +"</option>");
                        else
                            htm.append("<option value=\""+sector.getId()+"\">"+sector.getDisplayTitle(lang) +"</option>");
                    }
                    htm.append("  </select></p>");
                    htm.append("  <p class=\"tercio\"><label>*Fecha inicial</label><input type=\"text\" name=\"fi\" value=\""+sdf.format(experiencia.getFechaIni())+"\" dojoType=\"dijit.form.DateTextBox\" required=\"true\" constraints=\"{datePattern:'dd/MM/yyyy'}\" maxlength=\"10\" hasDownArrow=\"true\"/></p>");
                    htm.append("  <p class=\"tercio\"><label>Fecha final</label><input type=\"text\" name=\"ff\" value=\""+sdf.format(experiencia.getFechaFin())+"\" dojoType=\"dijit.form.DateTextBox\" required=\"false\" constraints=\"{datePattern:'dd/MM/yyyy'}\" maxlength=\"10\" hasDownArrow=\"true\"/></p>");
                    htm.append("  <p class=\"tercio\"><label>*Puesto</label><input type=\"text\" name=\"crg\" value=\""+experiencia.getCargo()+"\" /></p>");
                    htm.append("  <p class=\"tercio\"><label>*Funciones principales</label><textarea name=\"mfncs\" rows=\"5\" cols=\"40\">"+experiencia.getFuncionesPrincipales()+"</textarea></p>");
                    htm.append("  <p class=\"tercio\"><label>Nombre y puesto del jefe inmediato</label><input type=\"text\" name=\"jf\" value=\""+experiencia.getJefe()+"\" /></p>");
                    if(experiencia.getTelefono()!=null)
                        htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono (clave lada, n&uacute;mero y extensi&oacute;n)</label><input type=\"text\" name=\"cve\" value=\""+(experiencia.getTelefono().getLada()==0?"":experiencia.getTelefono().getLada())+"\" size=\"3\" maxlength=\"3\" />&nbsp;<input type=\"text\" name=\"tf\" value=\""+(experiencia.getTelefono().getNumero()==0?"":experiencia.getTelefono().getNumero())+"\" size=\"8\" maxlength=\"8\" />&nbsp;<input type=\"text\" name=\"ext\" value=\""+(experiencia.getTelefono().getExtension()==0?"":experiencia.getTelefono().getExtension())+"\" size=\"5\" maxlength=\"5\" /></p>");
                    else
                        htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono (clave lada, n&uacute;mero y extensi&oacute;n)</label><input type=\"text\" name=\"cve\" value=\"\" size=\"3\" maxlength=\"3\" />&nbsp;<input type=\"text\" name=\"tf\" value=\"\" size=\"8\" maxlength=\"8\" />&nbsp;<input type=\"text\" name=\"ext\" value=\"\" size=\"5\" maxlength=\"5\" /></p>");
                    //htm.append("  <p><input type=\"button\" onclick=\"postHtml('"+rem+"','fms')\" value=\"Eliminar\" /></p>");
                    htm.append("  <p class=\"entero\"><input type=\"button\" onclick=\"location.href='"+rem+"'\" value=\"Eliminar\" /></p>");
                    htm.append("  <br clear=\"all\" />");
                    htm.append("</li>");
                }
            }else {
                htm.append("<li class=\"aaaa\">");
                htm.append("  <p class=\"tercio\"><label>Trabajo actual <input type=\"checkbox\" name=\"cur\" value=\"1\"/></label></p>");
                htm.append("  <p class=\"tercio\"><label>*Empresa</label><input type=\"text\" name=\"emp\" value=\"\" /></p>");
                htm.append("  <p class=\"entero\"><label>*Sector</label><select name=\"sctr\"><option value=\"\"></option>");
                Iterator<Sector> sectors = Sector.ClassMgr.listSectors(wsite);
                while(sectors.hasNext()) {
                    Sector sector = sectors.next();
                    htm.append("<option value=\""+sector.getId()+"\">"+sector.getDisplayTitle(lang) +"</option>");
                }
                htm.append("  </select></p>");
                htm.append("  <p class=\"tercio\"><label>*Fecha inicial</label><input type=\"text\" name=\"fi\" value=\"\" dojoType=\"dijit.form.DateTextBox\" required=\"true\" constraints=\"{datePattern:'dd/MM/yyyy'}\" maxlength=\"10\" hasDownArrow=\"true\"/></p>");
                htm.append("  <p class=\"tercio\"><label>Fecha final</label><input type=\"text\" name=\"ff\" value=\"\" dojoType=\"dijit.form.DateTextBox\" required=\"false\" constraints=\"{datePattern:'dd/MM/yyyy'}\" maxlength=\"10\" hasDownArrow=\"true\"/></p>");
                htm.append("  <p class=\"tercio\"><label>*Puesto</label><input type=\"text\" name=\"crg\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\"><label>*Funciones principales</label><textarea name=\"mfncs\" rows=\"5\" cols=\"40\"></textarea></p>");
                htm.append("  <p class=\"tercio\"><label>Nombre y puesto del jefe inmediato</label><input type=\"text\" name=\"jf\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono (clave lada, n&uacute;mero y extensi&oacute;n)</label>");
                htm.append("   <input type=\"text\" name=\"cve\" value=\"\" size=\"3\" maxlength=\"3\" />&nbsp;");
                htm.append("   <input type=\"text\" name=\"tf\" value=\"\" size=\"8\" maxlength=\"8\" />&nbsp;");
                htm.append("   <input type=\"text\" name=\"ext\" value=\"\" size=\"5\" maxlength=\"5\" />");
                htm.append("  </p>");
                htm.append("  <br clear=\"all\" />");
                htm.append("</li>");
            }
            htm.append("   </ol>");
            htm.append("   <p><a href=\"javascript:appendChild('_"+base.getId()+"_'+(idx++),'dtb_"+base.getId()+"_'+(idx++),'fms')\">Agregar</a></p>");          
            htm.append("  </div>");
            htm.append("  <div class=\"guardar\"><input type=\"submit\" value=\"Guardar\" /></div>");
            htm.append("</form>");
            out.println(htm.toString());
        }
    }
    
    private String script(final String lang) {
        StringBuilder js = new StringBuilder();
        js.append("\n");
        js.append("<script type=\"text/javascript\">\n");
        js.append("<!--\n");
        
        js.append("dojo.require(\"dojo.fx\");\n");
        js.append("dojo.require(\"dijit.dijit\");\n");
        js.append("dojo.require(\"dijit.form.Form\");\n");
        js.append("dojo.require(\"dijit.form.DateTextBox\");\n");
        js.append("dojo.require(\"dijit.form.ValidationTextBox\");\n");
        
        js.append("function expande(domId) {\n");
        js.append("   var anim1 = dojo.fx.wipeIn( {node:domId, duration:500 });\n");
        js.append("   var anim2 = dojo.fadeIn({node:domId, duration:650});\n");
        js.append("   dojo.fx.combine([anim1,anim2]).play();\n");
        js.append("}\n");

        js.append("function collapse(domId) {\n");
        js.append("   var anim1 = dojo.fx.wipeOut( {node:domId, duration:500 });\n");
        js.append("   var anim2 = dojo.fadeOut({node:domId, duration:650});\n");
        js.append("   dojo.fx.combine([anim1, anim2]).play();\n");
        js.append(" }\n");        
                
        js.append("  var idx=0;\n");
        js.append("  function appendChild(childId, dateboxId, parentId) {\n");
        js.append("    var s = new String('');\n");
        js.append("    s = s.concat('<li class=\"aaaa\" id=\"');\n");
        js.append("    s = s.concat(childId);\n");
        js.append("    s = s.concat('\">');\n");
        js.append("    s = s.concat('');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Trabajo actual <input type=\"checkbox\" name=\"cur\" value=\"1\"/></label></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Empresa</label><input type=\"text\" name=\"emp\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"entero\"><label>Sector</label><select name=\"sctr\"><option value=\"\"></option>');\n");
        for(Sector sector:sectors) {
            js.append("s= s.concat('<option value=\""+sector.getId()+"\">"+sector.getDisplayTitle(lang) +"</option>');\n");
        }
        js.append("    s = s.concat('</select></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Fecha inicial</label><input type=\"text\" id=\"fi_'+dateboxId+'\" name=\"fi\" value=\"\" maxlength=\"10\" style=\"width:110px;\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Fecha inicial</label><input type=\"text\" id=\"ff_'+dateboxId+'\" name=\"ff\" value=\"\" maxlength=\"10\" style=\"width:110px;\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Puesto</label><input type=\"text\" name=\"crg\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>*Funciones principales</label><textarea name=\"mfncs\" rows=\"5\" cols=\"40\"></textarea></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Nombre y puesto del jefe inmediato</label><input type=\"text\" name=\"jf\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Tel&eacute;fono (clave lada, n&uacute;mero y extensi&oacute;n)</label>');\n");
        js.append("    s = s.concat('<input type=\"text\" name=\"cve\" value=\"\" size=\"3\" maxlength=\"3\" />&nbsp;');\n");
        js.append("    s = s.concat('<input type=\"text\" name=\"tf\" value=\"\" size=\"8\" maxlength=\"8\" />');\n");
        js.append("    s = s.concat('<input type=\"text\" name=\"ext\" value=\"\" size=\"5\" maxlength=\"5\" />');\n");
        js.append("    s = s.concat('</p>');\n");
        js.append("    s = s.concat('<p class=\"entero\"><input type=\"button\" onclick=\"dojo.destroy(\\''+childId+'\\')\" value=\"Eliminar\" /></p>');\n");
        js.append("    s = s.concat('<br clear=\"all\"/>');\n");
        js.append("    s = s.concat('</li>');\n");
        js.append("    dojo.place(s, parentId, 'last');\n");
        
        js.append("dojo.addOnLoad(function() {");
        js.append("  var datefi = new dijit.form.DateTextBox(");
        js.append("                   {");
        js.append("                   name:'fi',");
        js.append("                   required:true,");
        js.append("                   constraints:{datePattern:'dd/MM/yyyy'},");
        js.append("                   hasDownArrow:true");
        js.append("                   }, 'fi_'+dateboxId");
        js.append("                 );");
        js.append("  var dateff = new dijit.form.DateTextBox(");
        js.append("                   {");
        js.append("                   name:'ff',");
        js.append("                   required:false,");
        js.append("                   constraints:{datePattern:'dd/MM/yyyy'},");
        js.append("                   hasDownArrow:true");
        js.append("                   }, 'ff_'+dateboxId");
        js.append("                 );");
        js.append("});");
        js.append("  }\n");
        js.append("-->\n");
        js.append("</script>\n");
        return js.toString();
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
//        String id = request.getParameter("id");
//        if (null == action) {
//            action = "";
//        }

        User user = response.getUser();
        if(!user.isSigned())
            return;
        
        final String action = response.getAction();
        WebSite wsite = response.getWebPage().getWebSite();
//        String eventid = request.getParameter("idevent");
//        String page = request.getParameter("page");

        CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
        if(cv==null) {
            log.error("Objeto semantico cv del usuario es nulo");
//            cv = CV.ClassMgr.createCV(user.getId(),wsite);
//            cv.setPropietario(user);
        }
             
//        Academia aca = cv.getAcademia();
//        if(aca==null){
//            aca = Academia.ClassMgr.createAcademia(wsite);
//            cv.setAcademia(aca);
//        }
        
        
        if (SWBResourceURL.Action_ADD.equals(action)) {
            if(!validate(request, response))
                return;
            
            Iterator<ExperienciaLaboral> experiencias = cv.listExperienciaLaborals();
            while(experiencias.hasNext()) {
                try {
                    experiencias.next().remove();
                }catch(Exception e) {}
            }            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String[] cur = request.getParameterValues("cur");
            String[] emp = request.getParameterValues("emp");
            String[] sctr = request.getParameterValues("sctr");
            String[] fi = request.getParameterValues("fi");
            String[] ff = request.getParameterValues("ff");
            String[] crg = request.getParameterValues("crg");
            String[] mfncs = request.getParameterValues("mfncs");
            String[] jf = request.getParameterValues("jf");
            
            String[] cve = request.getParameterValues("cve");
            String[] tf = request.getParameterValues("tf");
            String[] ext = request.getParameterValues("ext");
//            if(emp.length!=fi.length && fi.length!=crg.length && crg.length!=sctr.length) {
//                response.setRenderParameter("msg", "Faltan datos");
//                return;
//            }
            for(int i=0; i<emp.length; i++) {
//                if(emp[i].isEmpty() || fi[i].isEmpty() || ff[i].isEmpty() || jf[i].isEmpty() || tf[i].isEmpty())
//                    continue;
                ExperienciaLaboral experiencia = ExperienciaLaboral.ClassMgr.createExperienciaLaboral(wsite);
                try {
                    experiencia.setActual(cur[i]==null?false:true);
                }catch(Exception e) {}
                experiencia.setEmpresa(SWBUtils.XML.replaceXMLChars(emp[i]));
                try {
                    Sector sector = Sector.ClassMgr.getSector(SWBUtils.XML.replaceXMLChars(sctr[i]), wsite);
                    experiencia.setSector(sector);
                }catch(Exception e) {}
                try {
                    experiencia.setFechaIni(sdf.parse(SWBUtils.XML.replaceXMLChars(fi[i])));
                }catch(Exception e){
                    return;
                }
                try {
                    experiencia.setFechaFin(sdf.parse(SWBUtils.XML.replaceXMLChars(ff[i])));
                }catch(Exception e) {}
                experiencia.setCargo(SWBUtils.XML.replaceXMLChars(crg[i]));
                experiencia.setFuncionesPrincipales(SWBUtils.XML.replaceXMLChars(mfncs[i]));
                experiencia.setJefe(SWBUtils.XML.replaceXMLChars(jf[i]));
                Telefono tel = Telefono.ClassMgr.createTelefono(wsite);
                try {
                    tel.setLada(Integer.parseInt(SWBUtils.XML.replaceXMLChars(cve[i])));
                }catch(Exception iobe){}
                try {
                    tel.setExtension(Integer.parseInt(SWBUtils.XML.replaceXMLChars(ext[i])));
                }catch(Exception iobe){}
                try {
                    tel.setNumero(Integer.parseInt(SWBUtils.XML.replaceXMLChars(tf[i])));
                }catch(Exception iobe){
                    iobe.printStackTrace(System.out);
                    tel.remove();
                }
                experiencia.setTelefono(tel);
                cv.addExperienciaLaboral(experiencia);
            }
            response.setRenderParameter("msg", "Experiencia registrada correctamente");
        }else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            final String semObjId = request.getParameter("oid");
            try {
                ExperienciaLaboral experiencia = ExperienciaLaboral.ClassMgr.getExperienciaLaboral(semObjId, wsite);
                experiencia.remove();
            }catch(Exception e) {
                log.error(e);
            }
        }
    }
    
    private boolean validate(HttpServletRequest request, SWBActionResponse response) {
        String[] emp = request.getParameterValues("emp");
        if(emp.length==0) {
            response.setRenderParameter("msg", "nombre de empresa falta");
            return false;
        }
        String[] fi = request.getParameterValues("fi");
        if(fi.length==0) {
            response.setRenderParameter("msg", "fecha inicial falta");
            return false;
        }
        String[] sctr = request.getParameterValues("sctr");
        if(sctr.length==0) {
            response.setRenderParameter("msg", "sector falta");
            return false;
        }
        String[] crg = request.getParameterValues("crg");
        if(crg.length==0) {
            response.setRenderParameter("msg", "puesto del candidato falta");
            return false;
        }
        if(emp.length!=fi.length && fi.length!=crg.length && crg.length!=sctr.length) {
            response.setRenderParameter("msg", "Faltan datos");
            return false;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(String s:fi)
            try {
                sdf.parse(SWBUtils.XML.replaceXMLChars(s));
            }catch(Exception e){
                response.setRenderParameter("msg", "Fecha inicial es incorrrecta");
                return false;
            }
        String[] ff = request.getParameterValues("ff");
        for(int i=0; i<ff.length; i++)
            try {
                Date di = sdf.parse(SWBUtils.XML.replaceXMLChars(fi[i]));
                Date df = sdf.parse(SWBUtils.XML.replaceXMLChars(ff[i]));
                if(di.after(df))
                    throw new Exception("Fecha final es antes de la fecha inicial");
            }catch(Exception e){
                response.setRenderParameter("msg", "Fecha final es incorrecta");
                return false;
            }
        String[] cve = request.getParameterValues("cve");
        for(String s:cve)
            try {
                if(!s.isEmpty())
                    Integer.parseInt(SWBUtils.XML.replaceXMLChars(s));
            }catch(Exception e){
                response.setRenderParameter("msg", "Clave lada es incorrecta");
                return false;
            }
        String[] tf = request.getParameterValues("tf");
        for(String s:tf)
            try {
                if(!s.isEmpty())
                    Integer.parseInt(SWBUtils.XML.replaceXMLChars(s));
            }catch(Exception e){
                response.setRenderParameter("msg", "Numero telefonico es incorrecto");
                return false;
            }
        String[] ext = request.getParameterValues("ext");
        for(String s:ext)
            try {
                if(!s.isEmpty())
                    Integer.parseInt(SWBUtils.XML.replaceXMLChars(s));
            }catch(Exception e){
                response.setRenderParameter("msg", "Extension telefonica es incorrecta");
                return false;
            }
        
        if(cve.length>tf.length || ext.length>tf.length)
            return false;

        return true;
    }
}
