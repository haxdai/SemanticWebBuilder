package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.ExperienciaLaboral;
import com.infotec.cvi.swb.Sector;
import com.infotec.eworkplace.swb.Telefono;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                    e.printStackTrace(System.out);
                }
            }
        }
    }
    
    private String script(final String lang) {
        StringBuilder js = new StringBuilder();
        js.append("\n");
        js.append("<script type=\"text/javascript\">\n");
        js.append("<!--\n");
        
        js.append("dojo.require('dojo.parser');\n;");
        js.append("dojo.require('dojo.fx');\n");
        js.append("dojo.require('dijit.dijit');\n");
        js.append("dojo.require('dijit.form.Form');\n");
        js.append("dojo.require('dijit.form.Textarea');\n");
        js.append("dojo.require('dijit.form.DateTextBox');\n");
        js.append("dojo.require('dijit.form.FilteringSelect');\n");
        js.append("dojo.require('dijit.form.ValidationTextBox');\n");
        
        js.append("function validation() {\n");
js.append("v = true;");        
js.append("dojo.query('[name$=\"sctr\"]').forEach(function(node, index, arr){\n");
js.append("  if(!node.value) {\n");
js.append("    dojo.byId(node.name+'_msg').innerHTML='falta este dato';\n");
js.append("    v = v && false;");
js.append("  }");
//js.append("  console.log('node='+node.type+',node.name='+node.name+',node.value='+node.value+',index='+index+',arr='+arr);\n");
js.append("});\n");

js.append("dojo.query('[name$=\"mfncs\"]').forEach(function(node, index, arr){\n");
js.append("  if(!node.value) {\n");
js.append("    dojo.byId(node.name+'_msg').innerHTML='falta este dato';\n");
js.append("    v = v && false;");
js.append("  }");
//js.append("  console.log('node='+node.type+',node.name='+node.name+',node.value='+node.value+',index='+index+',arr='+arr);\n");
js.append("});\n");
        
        
        js.append("    var f = dojo.byId(\"explab_0001\");\n");
        js.append("    var s = \"\";\n");
        js.append("    for(var i = 0; i < f.elements.length; i++) {\n");
        js.append("        var elem = f.elements[i]; \n");
        js.append("        if(elem.name == \"button\") \n");
        js.append("            continue; \n");
//        js.append("        if(elem.type == \"radio\" && !elem.checked) \n");
//        js.append("            continue; \n");
        js.append("        s += 'e=' + elem.type + ', ' + elem.name + ': ' + elem.value + '\\n';\n");
        js.append("    }\n");
        js.append("    console.log(s);\n");
        js.append("}\n");
        
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
        js.append("    s = s.concat('<p class=\"tercio\"><label>Empresa</label><input type=\"text\" name=\"emp\" value=\"\" dojoType=\"dijit.form.ValidationTextBox\" required=\"true\" promptMessage=\"Nombre de la empresa\" invalidMessage=\"El nombre de la empresa es requerido\"/></p>');\n");
        js.append("    s = s.concat('<p class=\"entero\"><label>Sector</label><select name=\"sctr\" dojoType=\"dijit.form.FilteringSelect\" required=\"true\"><option value=\"\"></option>');\n");
        for(Sector sector:sectors) {
            js.append("s= s.concat('<option value=\""+sector.getId()+"\">"+sector.getDisplayTitle(lang) +"</option>');\n");
        }
        js.append("    s = s.concat('</select></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Fecha inicial</label><input type=\"text\" id=\"fi_'+dateboxId+'\" name=\"fi\" value=\"\" maxlength=\"10\" style=\"width:110px;\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Fecha inicial</label><input type=\"text\" id=\"ff_'+dateboxId+'\" name=\"ff\" value=\"\" maxlength=\"10\" style=\"width:110px;\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Puesto</label><input type=\"text\" name=\"crg\" value=\"\" dojoType=\"dijit.form.ValidationTextBox\" required=\"true\" promptMessage=\"Puesto ocupado\" invalidMessage=\"El nombre del puesto es requerido\"/></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>*Funciones principales</label><textarea name=\"mfncs\" rows=\"5\" cols=\"40\" dojoType=\"dijit.form.Textarea\" required=\"true\" promptMessage=\"Funciones realizadas en el puesto ocupado\" invalidMessage=\"Las funciones realizadas son requeridas\"></textarea></p>');\n");
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
        js.append("                   }, 'ff_'+dateboxId");
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
        User user = response.getUser();
        if(!user.isSigned())
            return;
        
        final String action = response.getAction();
        WebSite wsite = response.getWebPage().getWebSite();

        CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
        if(cv==null) {
            log.error("Objeto semantico cv del usuario es nulo");
        }
        
        if (SWBResourceURL.Action_ADD.equals(action)) {
            if(!validate(request, response))
                return;
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            ExperienciaLaboral experiencia = ExperienciaLaboral.ClassMgr.createExperienciaLaboral(wsite);
            experiencia.setActual(request.getParameter("cur")==null?false:true);
            experiencia.setEmpresa(SWBUtils.XML.replaceXMLChars(request.getParameter("emp")));
            experiencia.setSector(Sector.ClassMgr.getSector(request.getParameter("sctr"), wsite));
            try {
                experiencia.setFechaIni(sdf.parse(SWBUtils.XML.replaceXMLChars(request.getParameter("fi"))));
            }catch(ParseException e){
                response.setRenderParameter("alertmsg", "Fecha inicial mal");
                return;
            }
            try {
                experiencia.setFechaFin(sdf.parse(SWBUtils.XML.replaceXMLChars(request.getParameter("ff"))));
            }catch(ParseException e) {
                response.setRenderParameter("alertmsg", "Fecha final mal");
                return;
            }
            experiencia.setCargo(SWBUtils.XML.replaceXMLChars(request.getParameter("crg")));
            experiencia.setFuncionesPrincipales(SWBUtils.XML.replaceXMLChars(request.getParameter("mfncs")));
            experiencia.setJefe(SWBUtils.XML.replaceXMLChars(request.getParameter("jf")));
            
            try {
                int num = Integer.parseInt(SWBUtils.XML.replaceXMLChars(request.getParameter("tf")));
                Telefono telefono = Telefono.ClassMgr.createTelefono(wsite);
                telefono.setNumero(num);
                try {
                    int cve = Integer.parseInt(SWBUtils.XML.replaceXMLChars(request.getParameter("cve")));
                    telefono.setLada(cve);
                }catch(Exception e) {
                }
                try {
                    int ext = Integer.parseInt(SWBUtils.XML.replaceXMLChars(request.getParameter("ext")));
                    telefono.setExtension(ext);
                }catch(Exception e) {
                }
                experiencia.setTelefono(telefono);
                cv.addExperienciaLaboral(experiencia);
                response.setRenderParameter("alertmsg", "experiencia agregada");
            }catch(Exception e){
                experiencia.remove();
            }
        }else if (SWBResourceURL.Action_EDIT.equals(action)) {
            final String experienciaId = request.getParameter("id");
            ExperienciaLaboral experiencia;
            try {
                experiencia = ExperienciaLaboral.ClassMgr.getExperienciaLaboral(experienciaId, wsite);
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", "experiencia no existe");
                return;
            }
            if(!validate(request, response))
                return;
            
            if(!cv.hasExperienciaLaboral(experiencia)) {
                response.setRenderParameter("alertmsg", "Tu cv no contiene esta experiencia");
                return;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            experiencia.setActual(request.getParameter("cur")==null?false:true);
            experiencia.setEmpresa(SWBUtils.XML.replaceXMLChars(request.getParameter("emp")));
            experiencia.setSector(Sector.ClassMgr.getSector(request.getParameter("sctr"), wsite));
            try {
                experiencia.setFechaIni(sdf.parse(SWBUtils.XML.replaceXMLChars(request.getParameter("fi"))));
            }catch(ParseException e){
                response.setRenderParameter("alertmsg", "Fecha inicial mal");
                return;
            }
            try {
                experiencia.setFechaFin(sdf.parse(SWBUtils.XML.replaceXMLChars(request.getParameter("ff"))));
            }catch(ParseException e) {
                response.setRenderParameter("alertmsg", "Fecha final mal");
                return;
            }
            experiencia.setCargo(SWBUtils.XML.replaceXMLChars(request.getParameter("crg")));
            experiencia.setFuncionesPrincipales(SWBUtils.XML.replaceXMLChars(request.getParameter("mfncs")));
            experiencia.setJefe(SWBUtils.XML.replaceXMLChars(request.getParameter("jf")));
            
            try {
                int num = Integer.parseInt(SWBUtils.XML.replaceXMLChars(request.getParameter("tf")));
                Telefono telefono = Telefono.ClassMgr.createTelefono(wsite);
                telefono.setNumero(num);
                try {
                    int cve = Integer.parseInt(SWBUtils.XML.replaceXMLChars(request.getParameter("cve")));
                    telefono.setLada(cve);
                }catch(Exception e) {
                }
                try {
                    int ext = Integer.parseInt(SWBUtils.XML.replaceXMLChars(request.getParameter("ext")));
                    telefono.setExtension(ext);
                }catch(Exception e) {
                }
                experiencia.setTelefono(telefono);
                response.setRenderParameter("alertmsg", "experiencia agregada");
            }catch(Exception e){
                experiencia.remove();
            }
            response.setRenderParameter("alertmsg", "experiencia modifcada bien");
        }else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            final String experienciaId = request.getParameter("id");
            try {
                ExperienciaLaboral experiencia = ExperienciaLaboral.ClassMgr.getExperienciaLaboral(experienciaId, wsite);
                if(cv.hasExperienciaLaboral(experiencia)) {
                    experiencia.remove();
                    response.setRenderParameter("alertmsg", "experiencia eliminada");
                }else {
                    response.setRenderParameter("alertmsg", "Tu cv no contiene esta experiencia");
                }
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", "experiencia no se pudo eliminar");
                log.error(e);
            }
        }
    }
    
    private boolean validate(HttpServletRequest request, SWBActionResponse response) {
        if(request.getParameter("emp").isEmpty() || request.getParameter("sctr")==null || request.getParameter("fi").isEmpty() || request.getParameter("crg").isEmpty() || request.getParameter("mfncs")==null) {
            response.setRenderParameter("alertmsg", "faltan datos");
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fi=null, ff=null;
        try {
            Sector.ClassMgr.getSector(request.getParameter("sctr"), response.getWebPage().getWebSite());
        }catch(Exception e) {
            response.setRenderParameter("alertmsg", "Sector no existe");
            return false;
        }
        try {
            fi = sdf.parse(SWBUtils.XML.replaceXMLChars(request.getParameter("fi")));
        }catch(Exception e){
            response.setRenderParameter("alertmsg", "Fecha inicial mal");
            return false;
        }
        try {
            ff = sdf.parse(SWBUtils.XML.replaceXMLChars(request.getParameter("ff")));
            Date now = new Date();
            if(fi.after(now) || ff.after(now) || fi.after(ff))
                throw new Exception("Fecha mal");
        }catch(Exception e) {
            response.setRenderParameter("alertmsg", "Fecha mal");
            return false;
        }
        return true;
    }
}
