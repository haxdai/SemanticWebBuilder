/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.Candidato;
import com.infotec.eworkplace.swb.Persona;
import com.infotec.eworkplace.swb.Telefono;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.semanticwb.*;
import org.semanticwb.model.*;
import org.semanticwb.portal.api.*;
import org.semanticwb.base.util.SFBase64;

/**
 *
 * @author rene.jara
 */
public class UserPersonalData extends GenericAdmResource {

    private static Logger log = SWBUtils.getLogger(UserPersonalData.class);

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
//System.out.println("processAction");
        String action = response.getAction();
//TODO  si se planea usarlo para que alguin mas vea  y cambie los datos ajustar aqui tal ves enviando el id usario encriptado
        User user = response.getUser();
        WebPage wp = response.getWebPage();
        WebSite ws = wp.getWebSite();
        UserRepository ur = ws.getUserRepository();
        Resource base = getResourceBase();
//System.out.println("action:" + action);
        if (response.Action_EDIT.equals(action) && user.isSigned()) {
            try {
               /* if (request.getParameter("usrPassword") != null && !"{MD5}tq5RXfs6DGIXD6dlHUgeQA==".equalsIgnoreCase(request.getParameter("usrPassword"))) {
                    user.setPassword(request.getParameter("usrPassword"));
                }*/
                boolean complete=true;
                String curp=request.getParameter("curp");
                String firstName=request.getParameter("firstName");
                String lastName=request.getParameter("lastName");
                String secondLastName=request.getParameter("secondLastName");
                String gender=request.getParameter("gender");
                Date birthday=null;
                if( request.getParameter("birthday")!=null && !"".equals(request.getParameter("birthday")) ) {
                    try{
                        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                        birthday=sdf.parse(request.getParameter("birthday"));
                     }catch(ParseException ignoredException){
                     }
                }
// TORG guardar estado
                String state=request.getParameter("state");
                Country nationality=null;
                if(request.getParameter("nationality")!=null && !"".equals(request.getParameter("nationality"))){
                    nationality =Country.ClassMgr.getCountry(request.getParameter("nationality"), ws);
                }
                String fm2=request.getParameter("fm2");
                String email = request.getParameter("email");
                //String phoneUser = request.getParameter("phoneUser");
                String sLabor = request.getParameter("sLabor");
                String availability = request.getParameter("availability");
                String facebook = request.getParameter("facebook");
                String skype = request.getParameter("skype");
                String msn = request.getParameter("msn");
                String linkedin = request.getParameter("linkedin");
                String twitter = request.getParameter("twitter");

//System.out.println(firstName.matches("[a-zA-Z\u00C0-\u00FF' ]+"));
                if (firstName!=null&&!firstName.equals("")&&firstName.matches("[a-zA-Z\u00C0-\u00FF' ]+")){
                    user.setFirstName(SWBUtils.XML.replaceXMLChars(firstName));
                }else{
                    complete=false;
                }
                if (lastName!=null&&!lastName.equals("")&&lastName.matches("[a-zA-Z\u00C0-\u00FF' ]+")){
                    user.setLastName(SWBUtils.XML.replaceXMLChars(lastName));
                }else{
                    complete=false;
                }
                if (secondLastName!=null&&!secondLastName.equals("")&&secondLastName.matches("[a-zA-Z\u00C0-\u00FF' ]+")){
                    user.setSecondLastName(SWBUtils.XML.replaceXMLChars(secondLastName));
                }else{
                    complete=false;
                }

                Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
                if (persona == null) {
                    persona = Persona.ClassMgr.createPersona(user.getId(), ws);
                    persona.setOwner(user);
                }else if(persona.getOwner()==null){
                    persona.setOwner(user);
                }

                if (curp!=null&&!curp.equals("")&&curp.matches("[a-zA-Z]{4}\\d{6}[a-zA-Z]{6}\\d{2}")){
                    persona.setCurp(curp);
                }else{
                    complete=false;
                }

                if (gender.equals("f")){
                    persona.setGenero(true);
                }else if(gender.equals("m")){
                    persona.setGenero(false);
                }else{
                    complete=false;
                }

                if (birthday!=null){
                    persona.setNacimiento(birthday);
                }else{
                    complete=false;
                }

                persona.setLugarNacimiento(null);

                if (nationality!=null){
                    persona.setNacionalidad(nationality);
                }else{
                    complete=false;
                }
                if (fm2!=null&&!fm2.equals("")&&fm2.matches("\\d+")){
                    persona.setFM2(fm2);
                }else{
                    complete=false;
                }


                Enumeration<String> params=request.getParameterNames();
                while(params.hasMoreElements()){
                    String param=params.nextElement();
                    if (param.startsWith("phoneNum")){
                        String phoneId=param.substring(8);
                        int phoneNum=0;
                        int phoneLada=0;
                        int phoneExt=0;
                        String phoneType=request.getParameter("phoneType"+phoneId);
                        try{
                            phoneNum=Integer.parseInt(request.getParameter("phoneNum"+phoneId));
                            try{
                                phoneLada=Integer.parseInt(request.getParameter("phoneLada"+phoneId));
                            }catch(NumberFormatException ignoredException){
                            }
                            phoneExt=Integer.parseInt(request.getParameter("phoneExt"+phoneId));
                        }catch(NumberFormatException ignoredException){
                        }

//System.out.println("phoneId:"+phoneId);
//System.out.println("phonenum"+request.getParameter("phoneNum"+phoneId));
                        if(phoneId.startsWith("_")&&phoneNum>0){
                            Telefono telefono=Telefono.ClassMgr.createTelefono(ws);
                            telefono.setLada(phoneLada);
                            telefono.setNumero(phoneNum);
                            telefono.setExtension(phoneExt);
                            telefono.setTipo(phoneType);
                            persona.addTelefono(telefono);
                        }else{
                            Iterator<Telefono>  itt=persona.listTelefonos();
                            while(itt.hasNext()){
                                Telefono telefono=itt.next();
//System.out.println("telefonoId:"+telefono.getId());
                                if(telefono.getId().equals(phoneId)&&phoneNum>0){
                                    telefono.setLada(phoneLada);
                                    telefono.setNumero(phoneNum);
                                    telefono.setExtension(phoneExt);
                                    telefono.setTipo(phoneType);
                                }
                            }
                        }
                    }
                }


                //sLabor = request.getParameter("sLabor");
                 //avalibility = request.getParameter("avalibility");

                if (facebook!=null&&!facebook.equals("")&&facebook.matches(".+")){
                    persona.setFacebook(facebook);
                }else{
                    //complete=false;
                }
                if (skype!=null&&!skype.equals("")&&skype.matches(".+")){
                    persona.setSkype(skype);
                }else{
                    //complete=false;
                }
                if (msn!=null&&!msn.equals("")&&msn.matches(".+")){
                    persona.setMsn(msn);
                }else{
                    //complete=false;
                }
                if (linkedin!=null&&!linkedin.equals("")&&linkedin.matches(".+")){
                    persona.setLinkedin(linkedin);
                }else{
                    //complete=false;
                }
                if (twitter!=null&&!twitter.equals("")&&twitter.matches(".+")){
                    persona.setTwitter(twitter);
                }else{
                    //complete=false;
                }

                Candidato candidato = Candidato.ClassMgr.getCandidato(user.getId(), ws);
                if (candidato == null) {
                    candidato = Candidato.ClassMgr.createCandidato(user.getId(), ws);
                }
                try{
                    candidato.setSituacionLaboral(Integer.parseInt(sLabor));
                }catch(NumberFormatException ignoredException){
                    complete=false;
                }
                try{
                    candidato.setDisponibilidad(Integer.parseInt(availability));
                }catch(NumberFormatException ignoredException){
                    complete=false;
                }
                if (!complete){
                  /*  response.setRenderParameter("firstName", SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                    response.setRenderParameter("lastName", SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                    response.setRenderParameter("secondLastName", SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                   // response.setRenderParameter("email", email);
                    response.setRenderParameter("birthday", request.getParameter("birthday"));
                    //response.setRenderParameter("msg", msg.toString());
                */}

            } catch (Exception ex) {
                log.error(ex);
            }
        }


    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        PrintWriter out = response.getWriter();
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";

        User user = paramsRequest.getUser();
        Resource base = getResourceBase();
        WebSite ws = base.getWebSite();
        //String wsid = paramsRequest.getWebPage().getWebSiteId();
        /*
        String msg = request.getParameter("msg");
        String model = paramRequest.getWebPage().getWebSiteId();

        if(msg!=null) {
        out.println("<div class=\"\"><p class=\"\">"+msg+"</p></div>");
        }
         */

        //if(!user.isSigned()) {
/*        Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
        if (persona == null) {
            persona = Persona.ClassMgr.createPersona(user.getId(), ws);
            persona.setOwner(user);
        }else if(persona.getOwner()==null){
            persona.setOwner(user);
        }
        Persona capersona = Persona.ClassMgr.getPersona(user.getId(), ws);
        if(){}
*/        RequestDispatcher dis = request.getRequestDispatcher(basePath+"userData.jsp");
        try {
            request.setAttribute("paramRequest", paramsRequest);
//            request.setAttribute("persona", persona);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }

    }
}
