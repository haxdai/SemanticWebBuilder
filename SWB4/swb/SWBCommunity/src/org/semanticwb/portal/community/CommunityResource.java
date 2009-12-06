package org.semanticwb.portal.community;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.SWBPlatform;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.*;

public class CommunityResource extends org.semanticwb.portal.community.base.CommunityResourceBase
{

    public CommunityResource()
    {
    }

    public CommunityResource(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println("Hello CommunityResource...");
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getMode().equals("returnRank"))
        {
            returnRank(request, response);
        } else if (paramRequest.getMode().equals("returnStateMessage"))
        {
            returnStateMessage(request, response, paramRequest);
        } else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebPage page = response.getWebPage();
        Member mem = Member.getMember(response.getUser(), page);
        boolean isAdministrator = false;
        User user=response.getUser();
        if (user != null)
        {
            GenericIterator<UserGroup> groups = user.listUserGroups();
            while (groups.hasNext())
            {
                UserGroup group = groups.next();
                if (group != null && group.getId().equals("admin"))
                {
                    isAdministrator = true;
                    break;
                }
            }
        }
        if (!mem.canView())
        {
            return;                                       //si el usuario no pertenece a la red sale;
        }
        String action = request.getParameter("act");
        System.out.println("act:" + action);
        if ("subscribe".equals(action))
        {
            if (page instanceof MicroSiteWebPageUtil)
            {
                ((MicroSiteWebPageUtil) page).subscribeToElement(mem);
            }
        } else if ("unsubscribe".equals(action))
        {
            if (page instanceof MicroSiteWebPageUtil)
            {
                ((MicroSiteWebPageUtil) page).unSubscribeFromElement(mem);
            }
        } else if ("deletecomment".equals(action))
        {
            String suri = request.getParameter("uricomment");
            String commentId = request.getParameter("commentId");
            SemanticObject so = null;
            if (null != suri && commentId!=null)
            {
                so = SemanticObject.createSemanticObject(suri);
            }
            if (so.getGenericInstance() instanceof MicroSiteElement && isAdministrator)
            {
                MicroSiteElement element = (MicroSiteElement) so.getGenericInstance();
                if (element != null)
                {
                    GenericIterator<Comment> comments=element.listComments();
                    while(comments.hasNext())
                    {
                        Comment comment=comments.next();
                        if(comment.getId().equals(commentId))
                        {
                            comment.remove();
                            break;
                        }
                    }
                }
            }
        }else if ("vote".equals(action))
            {
                rank(request, response);
            } else if ("abuseReport".equals(action))
            {
                abusedStateChange(request, response);
            } else if ("getAbused".equals(action))
            {
                getAbused(request, response);
            } else if ("getSpam".equals(action))
            {
                getSpam(request, response);
            } else if ("addComment".equals(action))
            {
                addComment(request, response, mem);
            } else if ("spamReport".equals(action))
            {
                spamStateChange(request, response);
            }
        }

    private

     void rank(HttpServletRequest request, SWBActionResponse response)
    {

        String suri = request.getParameter("uri");
        SemanticObject so = null;
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof MicroSiteElement)
        {
            MicroSiteElement mse = (MicroSiteElement) so.getGenericInstance();
            int vote = 0;
            try
            {
                vote = Integer.parseInt(request.getParameter("value"));
            } catch (Exception ne)
            {
            }
            double rank = mse.getRank();
            long rev = mse.getReviews();
            response.setRenderParameter("uri", suri);

            rank = rank * rev;
            rev++;
            rank = rank + vote;
            rank = rank / rev;

            System.out.println("rank a almacenar:" + rank);
            mse.setRank(rank);
            mse.setReviews(rev);
        }
        response.setMode("returnRank");
    }

    private void getAbused(HttpServletRequest request,
            SWBActionResponse response)
    {
        String message = null;
        String suri = request.getParameter("uri");
        SemanticObject so = null;
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof MicroSiteElement)
        {
            MicroSiteElement mse = (MicroSiteElement) so.getGenericInstance();
            message = String.valueOf(mse.getAbused());
        }
        response.setRenderParameter("message",
                message != null ? message : "Not OK");
        response.setMode("returnStateMessage");
    }

    private void abusedStateChange(HttpServletRequest request,
            SWBActionResponse response)
    {

        String message = null;
        String suri = request.getParameter("uri");
        SemanticObject so = null;
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof MicroSiteElement)
        {
            MicroSiteElement mse = (MicroSiteElement) so.getGenericInstance();
            mse.setAbused(mse.getAbused() + 1);
            request.getSession().setAttribute(suri, "true");
        }
        response.setMode("returnStateMessage");
        response.setRenderParameter("message",
                message != null ? message : "Not OK");
    }

    private void addComment(HttpServletRequest request,
            SWBActionResponse response, Member mem)
    {

        String suri = request.getParameter("uri");
        String desc = request.getParameter("comentario");

        GenericObject gen = SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);

        if (desc == null)
        {
            desc = "";
        }
        if (gen != null && gen instanceof MicroSiteElement)
        {
            MicroSiteElement mse = (MicroSiteElement) gen;
            if (mse.canComment(mem) && desc.length() > 0)
            {
                Comment comment = Comment.ClassMgr.createComment(response.getWebPage().getWebSite());
                comment.setDescription(desc);
                mse.addComment(comment);
            }
        }
        response.setRenderParameter("uri", suri);
        response.setRenderParameter("act", "detail");
        response.setMode(SWBParamRequest.Mode_VIEW);
    }

    private void spamStateChange(HttpServletRequest request,
            SWBActionResponse response)
    {

        String message = null;
        String suri = request.getParameter("uri");
        String commentId = request.getParameter("commentId");
        SemanticObject so = null;
        //System.out.println("suri:" + suri + ", id:" + commentId );
        if (commentId == null)
        {
            return;
        }
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof MicroSiteElement)
        {
            MicroSiteElement mse = (MicroSiteElement) so.getGenericInstance();
            GenericIterator<Comment> iterator = mse.listComments();
            while (iterator.hasNext())
            {
                Comment comment = iterator.next();
                if (comment.getId().equals(commentId))
                {
                    try
                    {
                        comment.setSpam(comment.getSpam() + 1);
                    } catch (Exception e)
                    {
                        comment.setSpam(1);
                    }
                    request.getSession().setAttribute(comment.getURI(), "true");
                    break;
                }
            }
        }
        response.setMode("returnStateMessage");
        response.setRenderParameter("message",
                message != null || "".equals(message)
                ? message : "Not OK");
    }

    private void getSpam(HttpServletRequest request,
            SWBActionResponse response)
    {

        String message = null;
        String suri = request.getParameter("uri");
        String commentId = request.getParameter("commentId");
        SemanticObject so = null;
        //System.out.println("suri:" + suri + ", id:" + commentId );
        if (commentId == null)
        {
            return;
        }
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof MicroSiteElement)
        {
            MicroSiteElement mse = (MicroSiteElement) so.getGenericInstance();
            GenericIterator<Comment> iterator = mse.listComments();
            while (iterator.hasNext())
            {
                Comment comment = iterator.next();
                if (comment.getId().equals(commentId))
                {
                    message = String.valueOf(comment.getSpam());
                    break;
                }
            }
        }
        response.setMode("returnStateMessage");
        response.setRenderParameter("message",
                message != null || "".equals(message)
                ? message : "");
    }

    private void returnRank(HttpServletRequest request,
            HttpServletResponse response)
    {

        String message = null;
        String suri = request.getParameter("uri");
        SemanticObject so = null;
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof MicroSiteElement)
        {
            MicroSiteElement mse = (MicroSiteElement) so.getGenericInstance();
            message = mse.getRank() + "|" + mse.getReviews();
        }
        try
        {
            //System.out.println("message:"+message);
            response.getWriter().print(message != null ? message : "Not OK");
        } catch (IOException ioe)
        {
        }
    }

    private void returnStateMessage(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
    {

        String message = request.getParameter("message");
        //System.out.println("message en returnStateMessage:" + message);
        try
        {
            response.getWriter().print(message != null ? message : "Not OK");
        } catch (IOException ioe)
        {
        }
    }
}
