package org.semanticwb.mask;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

public class MessageBoard extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(MessageBoard.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();

        User me = paramRequest.getUser();
        System.out.println("me="+me.getName()+", signed="+me.isSigned());
        if(!me.isSigned()) {
            System.out.println("no signed");
            return;
        }

        final String relPath = SWBPortal.getWebWorkPath()+"/models/"+paramRequest.getWebPage().getWebSiteId()+"/imagenes/avatar/caras/small/";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yy hh:mm", new Locale(me.getLanguage()));

        Iterator<Message>myMessages = Message.ClassMgr.listMessageByTo(me, paramRequest.getWebPage().getWebSite());
        while(myMessages.hasNext()) {
            Message msg = myMessages.next();
            User from = msg.getFrom();
            out.println("<div>");
            out.println("<div class=\"pBig\"><img src=\""+relPath+from.getPhoto()+"\" alt=\""+from.getName()+"\" /></div>");
            out.println("<div class=\"pLayerBig\"><p class=\"textoAvatar\">"+from.getName()+"</p></div>");
            out.println("<div class=\"pTextoFecha\">"+sdf.format(msg.getCreated())+"</div>");
            out.println("<div class=\"pSubject\">"+msg.getSubject()+"</div>");
            out.println("<div class=\"pTextoAmigo\">"+msg.getMsg()+"</div>");
            out.println("<div class=\"pBoteBasura\"></div>");
            out.println("</div>");
            System.out.println("byto");
        }
        out.println("<p class=\"pLineaPunteada\"></p>");
        out.println("<form id=\"form1\" method=\"post\" action=\""+paramRequest.getActionUrl().setAction(paramRequest.Action_ADD)+"\">");
        out.println("<div>");
        out.println("  <label for=\"to\">Para</label><br/>");
        out.println("  <input type=\"text\" id=\"to\" name=\"to\" />");
        out.println("</div>");
        out.println("<div>");
        out.println("  <label for=\"subj\">Asunto</label><br />");
        out.println("  <input type=\"text\" id=\"subj\" name=\"subj\" />");
        out.println("</div>");
        out.println("<div>");
        out.println("  <label for=\"msg\">Mensaje</label><br />");
        out.println("  <textarea name=\"msg\" id=\"msg\" cols=\"58\" rows=\"5\"></textarea>");
        out.println("</div>");
        out.println("<div>");
        out.println("  <input type=\"submit\" name=\"Enviar\" value=\"Enviar\" />");
        out.println("  <input type=\"reset\" name=\"Cancelar\" value=\"Limpiar\" />");
        out.println("</div>");
        out.println("</form>");
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        WebSite model = response.getWebPage().getWebSite();
        String action = response.getAction();
        User me = response.getUser();
        if(response.Action_ADD.equals(action)) {
            StringBuilder msgwrn = new StringBuilder();
            if(!me.isSigned()) {
                msgwrn.append(response.getLocaleString("msgErrUserNoSigned"));
            }
            if( request.getParameter("to")==null || "".equals(request.getParameter("to")) ) {
                msgwrn.append(response.getLocaleString("msgErrToRequired"));
            }
            if( request.getParameter("subj")==null || "".equals(request.getParameter("subj")) ) {
                msgwrn.append(response.getLocaleString("msgErrSubjectRequired"));
            }
            if( request.getParameter("msg")==null || "".equals(request.getParameter("msg")) ) {
                msgwrn.append(response.getLocaleString("msgErrMsgRequired"));
            }
            UserRepository ur = model.getUserRepository();
            User you = ur.getUserByLogin(request.getParameter("to"));
            if( me.isSigned()&&you!=null&&msgwrn.length()==0) {
                Message message = Message.ClassMgr.createMessage(model);
                message.setFrom(me);
                message.setTo(you);
                message.setSubject(SWBUtils.XML.replaceXMLChars(request.getParameter("subj")));
                message.setMsg(SWBUtils.XML.replaceXMLChars(request.getParameter("msg")));
                message.setCreated(new Date());
                message.setRead(Boolean.FALSE);
            }else {
                response.setRenderParameter("to", SWBUtils.XML.replaceXMLChars(request.getParameter("to")));
                response.setRenderParameter("subj", SWBUtils.XML.replaceXMLChars(request.getParameter("subj")));
                response.setRenderParameter("msg", SWBUtils.XML.replaceXMLChars(request.getParameter("msg")));
                response.setRenderParameter("msgwrn", msgwrn.toString());
            }
        }
    }
}
