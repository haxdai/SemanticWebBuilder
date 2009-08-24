package org.semanticwb.portal.community;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.*;

public class BlogResource extends org.semanticwb.portal.community.base.BlogResourceBase
{

    private static Logger log = SWBUtils.getLogger(BlogResource.class);

    public BlogResource()
    {
    }

    public BlogResource(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    private Blog createBlog(String title, String description, WebSite site, WebPage page, User user)
    {
        Blog blog = Blog.createBlog(site);
        blog.setWebPage(page);
        blog.setTitle(title);
        blog.setDescription(description);
        Date date = new Date(System.currentTimeMillis());
        blog.setCreated(date);
        blog.setUpdated(date);
        blog.setCreator(user);
        return blog;
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        Iterator<Blog> blogs = Blog.listBlogByWebPage(paramRequest.getWebPage());
        Blog blog = null;
        if (blogs.hasNext())
        {
            blog = blogs.next();
        }
        if (blog == null)
        {
            blog = createBlog("Título del Blog", "Descripción del blog", paramRequest.getWebPage().getWebSite(), paramRequest.getWebPage(), paramRequest.getUser());
        }
        String act = request.getParameter("act");
        if (act == null)
        {
            act = "view";
        }
        String path = "/swbadmin/jsp/microsite/BlogResource/blogView.jsp";
        if (act.equals("add"))
        {
            path = "/swbadmin/jsp/microsite/BlogResource/blogAdd.jsp";
        }
        if (act.equals("edit"))
        {
            path = "/swbadmin/jsp/microsite/BlogResource/blogEdit.jsp";
        }
        if (act.equals("detail"))
        {
            String uri = request.getParameter("uri");
            if (uri != null)
            {
                path = "/swbadmin/jsp/microsite/BlogResource/blogDetail.jsp";
                PostElement post = (PostElement) SemanticObject.createSemanticObject(uri).createGenericInstance();
                request.setAttribute("post", post);
            }
        }

        RequestDispatcher dis = request.getRequestDispatcher(path);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("blog", blog);
            dis.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private void addPost(String title, String description,String content, User user, Blog blog,int level)
    {
        PostElement rec = PostElement.createPostElement(getResourceBase().getWebSite());
        rec.setTitle(title);
        rec.setDescription(description);
        Date date = new Date(System.currentTimeMillis());
        rec.setCreated(date);
        rec.setCreator(user);
        rec.setUpdated(date);
        rec.setContent(content);
        rec.setVisibility(level);
        blog.addPostElement(rec);

    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        Member mem = Member.getMember(response.getUser(), response.getWebPage());
        if (!mem.canView())
        {
        return;
        }
        String action = request.getParameter("act");
        System.out.println("act:" + action);
        if ("add".equals(action) && mem.canAdd())        
        {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String content = request.getParameter("content");
            if (title != null && description != null)
            {
                Iterator<Blog> blogs = Blog.listBlogByWebPage(response.getWebPage());
                Blog blog = null;
                if (blogs.hasNext())
                {
                    blog = blogs.next();
                    try
                    {
                        int level= Integer.parseInt(request.getParameter("level"));
                        addPost(title, description,content, response.getUser(), blog,level);
                    }
                    catch(Exception e)
                    {
                        log.error(e);
                    }
                }

            }
        }
        else if ("edit".equals(action) && "editpost".equals(request.getParameter("mode")))
        {
            User user = response.getUser();
            String uri = request.getParameter("uri");
            if (uri != null)
            {
                PostElement rec = (PostElement) SemanticObject.createSemanticObject(uri).createGenericInstance();
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String content = request.getParameter("content");
                try
                {
                    int level= Integer.parseInt(request.getParameter("level"));
                    if (rec != null && rec.canModify(mem) && title != null && description != null && user.getLogin().equals(rec.getCreator().getLogin()))
                    {
                        rec.setTitle(title);
                        rec.setVisibility(level);
                        rec.setDescription(description);
                        rec.setContent(content);
                        Date date = new Date(System.currentTimeMillis());
                        rec.setUpdated(date);
                    }
                }
                catch(Exception e)
                {
                    log.error(e);
                }
            }
        }
        else if ("edit".equals(action) && "editblog".equals(request.getParameter("mode")))
        {
            User user = response.getUser();
            Member member = Member.getMember(user, response.getWebPage());
            String uri = request.getParameter("uri");
            if (uri != null)
            {
                Blog rec = (Blog) SemanticObject.createSemanticObject(uri).createGenericInstance();
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                if (rec != null && title != null && description != null && member.getAccessLevel()==Member.LEVEL_OWNER)
                {
                    rec.setTitle(title);
                    rec.setDescription(description);
                    Date date = new Date(System.currentTimeMillis());
                    rec.setUpdated(date);
                }
            }
        }
        else if ("remove".equals(action))
        {
            String uri = request.getParameter("uri");
            if (uri != null)
            {
                PostElement rec = (PostElement) SemanticObject.createSemanticObject(uri).createGenericInstance();
                if (rec != null && rec.canModify(mem))                
                {
                    rec.remove();                                       //elimina el registro
                }
            }
        }
        else {
            super.processAction(request, response);
        }
    }
}
