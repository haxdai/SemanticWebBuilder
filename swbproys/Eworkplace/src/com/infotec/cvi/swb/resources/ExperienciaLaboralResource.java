package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.Academia;
import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Carrera;
import com.infotec.cvi.swb.ExperienciaLaboral;
import com.infotec.cvi.swb.Grado;
import com.infotec.cvi.swb.GradoAcademico;
import com.infotec.cvi.swb.SituacionAcademica;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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

    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
//        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
//        String path = basePath + "view.jsp";
//        if (request != null) {
//            RequestDispatcher dis = request.getRequestDispatcher(path);
//            if (null != dis) {
//                try {
//                    request.setAttribute("paramRequest", paramRequest);
//                    request.setAttribute("this", this);
//                    dis.include(request, response);
//                } catch (Exception e) {
//                    log.error(e);
//                }
//            }
//        }
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
        Resource base = getResourceBase();
        WebSite wsite = base.getWebSite();
        PrintWriter out =  response.getWriter();
        
        //Experiencia laboral
        CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
        if(cv!=null && user.equals(cv.getPropietario())) {
            StringBuilder htm = new StringBuilder();
            htm.append(script());
            htm.append("  <div class=\"contacto_externo divisor\">");
            htm.append("   <h3>Datos familiares</h3>");
            //htm.append("        <p>Esta informaci&oacute;n es para uso exclusivo de la instituci&oacute;n, no aparecer&aacute; en tu perfil</p>");
            
            Iterator<ExperienciaLaboral> experiencias = cv.listExperienciaLaborals();
            htm.append("   <ol id=\"fms\">");
            if(experiencias.hasNext()) {
                SWBResourceURL rem = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setAction(SWBResourceURL.Action_REMOVE);
                ExperienciaLaboral experiencia;
                while(experiencias.hasNext()) {
                    experiencia = experiencias.next();
                    rem.setParameter("oid", experiencia.getId());
                    htm.append("<li class=\"aaaa\">");
                    htm.append("  <p class=\"entero\"><label>Empresa</label><br/><input type=\"text\" name=\"emmp\" value=\""+experiencia.getEmpresa()+"\" /></p>");
                    htm.append("  <p class=\"tercio\"><label>Sector</label><br/><input type=\"text\" name=\"sec\" value=\""+experiencia.getSector()+"\" /></p>");
                    htm.append("  <p class=\"tercio\"><label>Fecha inicial</label><br/><input type=\"text\" name=\"fi\" value=\""+experiencia.getFechaIni()+"\" /></p>");
                    htm.append("  <p class=\"tercio\"><label>Fecha inicial</label><br/><input type=\"text\" name=\"ff\" value=\""+experiencia.getFechaIni()+"\" /></p>");
                    if(experiencia.getTelefono()!=null)
                        htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono</label><br/><label>Clave</label>:<input type=\"text\" name=\"cve\" value=\""+experiencia.getTelefono().getLada()+"\" />&nbsp;<label>Tel&eacute;fono</label>:<input type=\"text\" name=\"tf\" value=\""+experiencia.getTelefono().getNumero()+"\" />&nbsp;<label>Extensi&oacute;n</label>:<input type=\"text\" name=\"ext\" value=\""+experiencia.getTelefono().getExtension()+"\" /></p>");
                    else
                        htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono</label><br/><label>Clave</label>:<input type=\"text\" name=\"cve\" value=\"\" />&nbsp;<label>Tel&eacute;fono</label>:<input type=\"text\" name=\"tf\" value=\"\" /></p>");
                    htm.append("  <p><input type=\"button\" onclick=\"postHtml('"+rem+"','fms')\" value=\"Eliminar\" /></p>");
                    htm.append("  <br clear=\"all\" />");
                    htm.append("</li>");
                }
            }else {
                htm.append("<li class=\"aaaa\">");
                htm.append("  <p class=\"entero\"><label>Nombre completo</label><br/><input type=\"text\" name=\"ncf\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\"><label>Parentesco</label><br/><input type=\"text\" name=\"p\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\"><label>Direcci&oacute;n</label><br/><input type=\"text\" name=\"df\" value=\"\" /></p>");
                htm.append("  <p class=\"tercio\"><label>Tel&eacute;fono</label><br/>");
                htm.append("   <label>Clave</label>:<input type=\"text\" name=\"cve\" value=\"\" />");
                htm.append("   <label>Tel&eacute;fono</label>:<input type=\"text\" name=\"tf\" value=\"\" />");
                htm.append("  </p>");
                htm.append("  <br clear=\"all\" />");
                htm.append("</li>");
            }
            htm.append("   </ol>");
            htm.append("   <p><a href=\"javascript:appendChild('_"+base.getId()+"_'+(idx++),'fms')\">Agregar</a></p>");          
            htm.append("  </div>");
            out.println(htm.toString());
        }
    }
    
    private String script() {
        StringBuilder js = new StringBuilder();
        js.append("\n");
        js.append("<script type=\"text/javascript\">\n");
        js.append("<!--\n");
        
        js.append("dojo.require(\"dojo.fx\");\n");
        js.append("dojo.require(\"dijit.dijit\");\n");
        
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
        js.append("  function appendChild(childId, parentId) {\n");
        js.append("    var s = new String('');\n");
        js.append("    s = s.concat('<li class=\"aaaa\" id=\"');\n");
        js.append("    s = s.concat(childId);\n");
        js.append("    s = s.concat('\">');\n");
        js.append("    s = s.concat('<p class=\"entero\"><label>Nombre completo</label><br/><input type=\"text\" name=\"ncf\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Parentesco</label><br/><input type=\"text\" name=\"p\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Direcci&oacute;n</label><br/><input type=\"text\" name=\"df\" value=\"\" /></p>');\n");
        js.append("    s = s.concat('<p class=\"tercio\"><label>Tel&eacute;fono</label><br/>');\n");
        js.append("    s = s.concat('<label>Clave</label>:<input type=\"text\" name=\"cve\" value=\"\" />&nbsp;');\n");
        js.append("    s = s.concat('<label>N&uacute;mero</label>:<input type=\"text\" name=\"tf\" value=\"\" />');\n");
        js.append("    s = s.concat('</p>');\n");
        js.append("    s = s.concat('<p><input type=\"button\" onclick=\"dojo.destroy(\\''+childId+'\\')\" value=\"Eliminar\" /></p>');\n");
        js.append("    s = s.concat('<br clear=\"all\"/>');\n");
        js.append("    s = s.concat('</li>');\n");
        js.append("    dojo.place(s, parentId, 'last');\n");
        js.append("  }\n");
        js.append("-->\n");
        js.append("</script>\n");
        return js.toString();
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        String id = request.getParameter("id");
        if (null == action) {
            action = "";
        }

        User usr = response.getUser();
        WebSite wsite = response.getWebPage().getWebSite();
        String eventid = request.getParameter("idevent");
        String page = request.getParameter("page");

        CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
        if(cv==null) {
            cv = CV.ClassMgr.createCV(usr.getId(),wsite);
            cv.setPropietario(usr);
        }
             
        Academia aca = cv.getAcademia();
        if(aca==null){
            aca = Academia.ClassMgr.createAcademia(wsite);
            cv.setAcademia(aca);
        }
        
        
        if (SWBResourceURL.Action_ADD.equals(action)) {
            
            String idcarrera = request.getParameter("idcarrera");
            String idsituacion = request.getParameter("idsituacion");
            String nomInstitucion = request.getParameter("txtInstitucion");
            int intPeriodo = request.getParameter("periodo")!=null?Integer.parseInt(request.getParameter("periodo")):0;
            String idgrado = request.getParameter("idgrado");
            
            Carrera carrera = Carrera.ClassMgr.getCarrera(idcarrera, wsite);
            SituacionAcademica situacion = SituacionAcademica.ClassMgr.getSituacionAcademica(idsituacion, wsite);
            Grado grado = Grado.ClassMgr.getGrado(idgrado, wsite);
            
            if(grado!=null&&situacion!=null&&carrera!=null&&intPeriodo>0)
            {
                GradoAcademico ga = GradoAcademico.ClassMgr.createGradoAcademico(wsite);

                ga.setNombreInstitucion(nomInstitucion);
                ga.setCarrera(carrera);
                ga.setSituacionAcademica(situacion);
                ga.setPeriodoYears(intPeriodo);
                ga.setGrado(grado);

                aca.addGradoAcademico(ga);
                response.setAction("");
                
                response.setRenderParameter("act", "");
                response.setRenderParameter("alertmsg", "Se agregó correctamente el Grado Académico");
            } else {
                response.setRenderParameter("alertmsg", "Datos inválidos, no se pudo agregar Grado Académico");
            }

        } else if (SWBResourceURL.Action_REMOVE.equals(action)) {
            if(id!=null){
                GradoAcademico ga = GradoAcademico.ClassMgr.getGradoAcademico(id, wsite);
                if(ga!=null){
                    try {
                        ga.remove();
                        response.setRenderParameter("alertmsg", "Se eliminó correctamente el Grado Académico.");
                    } catch (Exception e) {
                        response.setRenderParameter("alertmsg", "No se pudo eliminar el Grado Académico");
                    }                    
                }                
            }
        }
        if (eventid != null) {
            response.setRenderParameter("id", eventid);
        }
        if (page != null) {
            response.setRenderParameter("page", page);
        }
    }
}
