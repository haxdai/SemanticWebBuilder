package org.semanticwb.social.admin.resources;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.social.SocialNetwork;
import org.semanticwb.social.SocialSite;

/**
 *
 * @author carlos.ramos
 * @modified by Francisco.Jimenez
 */
public class SocialWebResource extends GenericAdmResource
{
    public static Logger log = SWBUtils.getLogger(SocialWebResource.class);
    
    public static final String ATTR_THIS = "this";
    public static final String ATTR_PARAMREQUEST = "paramRequest";
    public static final String ATTR_AXN = "action";
    public static final String ATTR_OBJURI = "objUri";
    public static final String ATTR_BRAND = "wsite";
    public static final String ATTR_TREEITEM = "treeItem";
    
    public static final String OAUTH_MODE = "oauth";
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(OAUTH_MODE.equals(paramRequest.getMode())) {
            doAuthenticate(request, response, paramRequest);
        }else {
            super.processRequest(request, response, paramRequest);
        }
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        SocialNetwork socialNetwork;
        String objUri = request.getParameter("suri"); //uri of socialNetwork        
        
        try {
            socialNetwork = (SocialNetwork)SemanticObject.getSemanticObject(objUri).getGenericInstance();
            if(socialNetwork==null){
                out.println("No fue posible recuperar el objeto con uri:" + objUri);
                System.out.println("NULL SOCIAL NET");
                return;
            }else if(socialNetwork.getAppKey() == null || socialNetwork.getSecretKey() == null){
                out.println("No han sido configuradas la llave de la aplicación o la llave secreta");
                System.out.println("NULL SOCIAL NET PARAMS");
                return;
            }else if(socialNetwork.getAppKey().isEmpty() || socialNetwork.getSecretKey().isEmpty()){
                out.println("No han sido configuradas la llave de la aplicación o la llave secreta");
                System.out.println("EMPTY SOCIAL NET PARAMS");
                return;
            }
        }catch(Exception ex) {
            socialNetwork = null;
            System.out.println("No valid value for current social Network");
            return;
        }
        
        if(user.isSigned()){
            if(socialNetwork.isSn_authenticated())
               {
                out.println("<div class=\"swbform\">");
                out.println("<table width=\"100%\" border=\"0px\">");            
                out.println("   <tr>");
                out.println("       <td style=\"text-align: center;\"><h3>La cuenta está autenticada correctamente</h3></td>");
                out.println("   </tr>");
                out.println("</table>");
                out.println("</div>");                
            }else if(!socialNetwork.isSn_authenticated()){
                out.println("<div class=\"swbform\">");
                out.println("<table width=\"100%\" border=\"0px\">");            
                out.println("   <tr>");
                out.println("       <td style=\"text-align: center;\"><h3>La cuenta aún no está autenticada!</h3></td>");
                out.println("   </tr>");
                out.println("   <tr>");
                out.println("       <td style=\"text-align: center;\">");
                out.println("   <form type=\"dijit.form.Form\" id=\"nc\" action=\"" +  paramRequest.getRenderUrl().setMode(OAUTH_MODE) + "\" method=\"post\" onsubmit=\"submitForm('nc'); return false;\">");
                out.println("       <input type=\"hidden\"  name=\"suri\" value=\"" + objUri +"\">");
                out.println("       <input type=\"hidden\"  name=\"wsid\" value=\"" + socialNetwork.getSemanticObject().getModel().getName()+"\">");
                out.println("       <button dojoType=\"dijit.form.Button\" type=\"submit\">" + paramRequest.getLocaleString("lblAuthentic") + "</button>");
                out.println("   </form>");
                out.println("       </td>");
                out.println("   </tr>");
                out.println("</table>");
                out.println("</div>");                              
            }
        }else{
            out.println("<h3>Usuario no autorizado. Consulte a su administrador</h3>");
        }
    }
    
    public void doAuthenticate(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        final String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/admin/jsp/components/" + this.getClass().getSimpleName() + "/";
        String objUri = (String)request.getAttribute("objUri");
        final SocialSite wsite = (SocialSite)WebSite.ClassMgr.getWebSite(request.getParameter("wsid"));        
        HttpSession session = request.getSession(true);
        if(session.getAttribute("sw")==null)
        {
            /*SemanticClass sclass = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(sclassURI);
            long id = wsite.getSemanticObject().getModel().getCounter(sclass);
            SocialNetwork socialNetwork = (SocialNetwork)wsite.getSemanticObject().getModel().createGenericObject(wsite.getSemanticObject().getModel().getObjectUri(Long.toString(id), sclass), sclass);
            */
            SocialNetwork socialNetwork = (SocialNetwork)wsite.getSemanticObject().getModel().getGenericObject(request.getParameter("suri"));

            session.setAttribute("sw", socialNetwork);
            socialNetwork.authenticate(request, response, paramRequest);
        }
        else
        {            
            SocialNetwork socialNetwork = (SocialNetwork)session.getAttribute("sw");
            session.removeAttribute("sw");
            objUri = socialNetwork.getURI();
            if(!socialNetwork.isSn_authenticated()) {
                socialNetwork.authenticate(request, response, paramRequest);
            }                        
        }        
    }
    
    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
System.out.println("********************   doEdit.");
        
        final String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/admin/jsp/components/" + this.getClass().getSimpleName() + "/";
System.out.println(" recuperando socialNetwork....");
        String objUri = (String)request.getAttribute("objUri");
        SocialNetwork socialNetwork;
        try {
            socialNetwork = (SocialNetwork)SemanticObject.getSemanticObject(objUri).getGenericInstance();
System.out.println(" 1.socialNetwork="+socialNetwork.getId());
            String title = request.getParameter("title");
            String desc = request.getParameter("desc");
            String appId = request.getParameter("appId");
            String sk = request.getParameter("sk");
            if(title!=null && !title.isEmpty()) {
                socialNetwork.setTitle(title);
            }
            if(desc!=null && !desc.isEmpty()) {
                socialNetwork.setDescription(desc);
            }
            if(!socialNetwork.isSn_authenticated() && appId!=null && sk!=null && !appId.isEmpty() && !sk.isEmpty())
            {
                socialNetwork.setAppKey(appId);
                socialNetwork.setSecretKey(sk);
                HttpSession session = request.getSession(true);
                session.setAttribute("objUri", objUri);
                socialNetwork.authenticate(request, response, paramRequest);
            }
        }catch(Exception e) {
            HttpSession session = request.getSession(true);
            objUri = (String)session.getAttribute("objUri");
            try {
                socialNetwork = (SocialNetwork)SemanticObject.getSemanticObject(objUri).getGenericInstance();
System.out.println(" 2.socialNetwork="+socialNetwork.getId());
                if(!socialNetwork.isSn_authenticated()) {
                    socialNetwork.authenticate(request, response, paramRequest);
                }
            }catch(Exception ex) {
                socialNetwork = null;
            }
        }
        
        RequestDispatcher dis = null;
        dis = request.getRequestDispatcher(basePath+"/edit.jsp");
        try
        {
            request.setAttribute(ATTR_THIS, this);
            request.setAttribute(ATTR_PARAMREQUEST, paramRequest);
            request.setAttribute("objUri", objUri);
            dis.include(request, response);
        }catch (Exception e) {
            log.error(e);
            e.printStackTrace(System.out);
        }
    }
    
    /*
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
System.out.println("processAction....");
        final String wsiteId = request.getParameter(ATTR_BRAND);
        final SocialSite model = SocialSite.ClassMgr.getSocialSite(wsiteId);
        final String action = response.getAction();
        if(SWBResourceURL.Action_ADD.equals(action))
        {
            String sclassURI = request.getParameter("socialweb");
            String title = request.getParameter("title");
            String desc = request.getParameter("desc");
            String appId = request.getParameter("appId");
            String sk = request.getParameter("sk");
            
            SemanticClass sclass = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(sclassURI);
            long id = model.getSemanticObject().getModel().getCounter(sclass);
            SocialNetwork socialNetwork = (SocialNetwork)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(Long.toString(id), sclass), sclass);
            socialNetwork.setTitle(title);
            socialNetwork.setDescription(desc);
            socialNetwork.setAppKey(appId);            
            socialNetwork.setSecretKey(sk);
            final String url = ((Oauthable)socialNetwork).doRequestPermissions();
            response.setRenderParameter(ATTR_OBJURI, socialNetwork.getURI());
            response.setRenderParameter(ATTR_BRAND, wsiteId);
            response.setRenderParameter(ATTR_TREEITEM, request.getParameter(ATTR_TREEITEM));
        }
    }
    */
}