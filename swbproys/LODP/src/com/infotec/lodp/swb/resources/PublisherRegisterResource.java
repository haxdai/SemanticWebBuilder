/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infotec.lodp.swb.resources;

import com.infotec.lodp.swb.Institution;
import com.infotec.lodp.swb.Publisher;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;



/**
 *
 * @author rene.jara
 */
public class PublisherRegisterResource extends GenericAdmResource {
    public static final Logger log = SWBUtils.getLogger(PublisherRegisterResource.class);

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        WebPage wpage = response.getWebPage();
        WebSite wsite = wpage.getWebSite();
        Resource base = getResourceBase();
        User usr = response.getUser();
        UserRepository ur = wsite.getUserRepository();

        if(response.Action_ADD.equals(action)) {
            String login = SWBUtils.XML.replaceXMLChars(request.getParameter("user"));
            String email = SWBUtils.XML.replaceXMLChars(request.getParameter("email"));
            String pwd = request.getParameter("passwd");
            StringBuilder msg = new StringBuilder();
            if( request.getParameter("firstName").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrFirstNameRequired")).append(",");
            }
            if( request.getParameter("lastName").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrLastNameRequired")).append(",");
            }
            if( !SWBUtils.EMAIL.isValidEmailAddress(email) ) {
                msg.append(response.getLocaleString("msgErrInvalidEmail")).append(",");
            }
            if( pwd==null || pwd.isEmpty()) {
                msg.append(response.getLocaleString("msgErrPasswordRequired")).append(",");
            }else if(login.equals(pwd)){
                msg.append(response.getLocaleString("msgErrPasswordEquals")).append(",");
            }
            if(ur.getUserByLogin(login)!=null){
                msg.append(response.getLocaleString("lblLoginDupl")).append(",");
            }
            if(ur.getUserByEmail(email)!=null){
                msg.append(response.getLocaleString("lblEmailDupl")).append(",");
            }
            if( request.getParameter("rfc").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrRfcRequired")).append(",");
            }
            if( request.getParameter("phone").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrPhoneRequired")).append(",");
            }
            if( request.getParameter("position").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrPositionRequired")).append(",");
            }
            if( request.getParameter("uniAdm").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrUniAdmRequired")).append(",");
            }
            if( request.getParameter("dirAdm").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrDirAdmRequired")).append(",");
            }
            if( request.getParameter("certificate").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrCertificateRequired")).append(",");
            }
            if( request.getParameter("bossName").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrBossNameRequired")).append(",");
            }
            if( request.getParameter("bossEmail").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrBossEmailRequired")).append(",");
            }
            if( request.getParameter("institutionId").isEmpty() ) {
                msg.append(response.getLocaleString("msgErrInstitutionRequired")).append(",");
            }

            if(msg.length()==0 ) {
                try {
                    Publisher pub=Publisher.ClassMgr.createPublisher(ur);

                    pub.setLogin(login);
                    pub.setPassword(pwd);
                    pub.setLanguage(usr.getLanguage());
                    pub.setFirstName(SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                    pub.setLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                    pub.setSecondLastName(SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                    pub.setEmail(email);

                    pub.setPubRFC(request.getParameter("rfc"));
                    pub.setPubPhone(request.getParameter("phone"));
                    pub.setPubPosition(request.getParameter("position"));
                    pub.setPubUniAdmin(request.getParameter("uniAdm"));
                    pub.setPubDirGral(request.getParameter("dirAdm"));
                    pub.setPubCertificate(request.getParameter("certificate"));
                    pub.setChiefName(request.getParameter("bossName"));
                    pub.setChiefEmail(request.getParameter("bossEmail"));
                    pub.setPubInstitution(Institution.ClassMgr.getInstitution(request.getParameter("institutionId"), wsite));

                    pub.setActive(true);

                    response.setRenderParameter("msg", response.getLocaleString("msgOk"));
                }catch(Exception ne) {
                    log.error(ne);
                }
            }else {
                response.setRenderParameter("firstName", SWBUtils.XML.replaceXMLChars(request.getParameter("firstName")));
                response.setRenderParameter("lastName", SWBUtils.XML.replaceXMLChars(request.getParameter("lastName")));
                response.setRenderParameter("secondLastName", SWBUtils.XML.replaceXMLChars(request.getParameter("secondLastName")));
                response.setRenderParameter("email", email);
                response.setRenderParameter("user", login);
                response.setRenderParameter("rfc", request.getParameter("rfc"));
                response.setRenderParameter("phone", request.getParameter("phone"));
                response.setRenderParameter("position",request.getParameter("position"));
                response.setRenderParameter("uniAdm", request.getParameter("uniAdm"));
                response.setRenderParameter("dirAdm", request.getParameter("dirAdm"));
                response.setRenderParameter("certificate", request.getParameter("certificate"));
                response.setRenderParameter("bossName", request.getParameter("bossName"));
                response.setRenderParameter("bossEmail",request.getParameter("bossEmail"));
                response.setRenderParameter("institutionId", request.getParameter("institutionId"));
                response.setRenderParameter("msg", msg.toString());
                response.setMode(response.Mode_VIEW);
            }
        }
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramsRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
}
