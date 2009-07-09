/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal.resources.blog;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Templates;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceType;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.portal.admin.admresources.util.WBAdmResourceUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.util.WBFileUpload;

/**
 *
 * @author victor.lorenzana
 */
public class BlogResource extends GenericResource
{

    private Logger log=SWBUtils.getLogger(BlogResource.class);
    public static final String defaultFormat = "dd 'de' MMMM 'de' yyyy";
    private static final String DELETE_FILE = "deleteblog.bmp";
    private static final String ADD_FILE = "addpost.bmp";
    
    private static final String EDIT_FILE = "editpost.bmp";
    Resource base = null;


    public void installMySql(ResourceType type) throws SWBResourceException
    {
        uninstallMySql(type);
        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
            con.setAutoCommit(false);
            
            PreparedStatement pt=con.prepareStatement("CREATE TABLE wbblog (blogid int(10) unsigned NOT NULL auto_increment,blogname varchar(255) NOT NULL, PRIMARY KEY  (blogid)) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1");
            pt.execute();            
            
            pt=con.prepareStatement("CREATE TABLE wbblogcomments (blogid int(10) unsigned NOT NULL auto_increment,postid int(10) unsigned NOT NULL,commentid int(10) unsigned NOT NULL,comment text NOT NULL,userid varchar(40) NOT NULL,fec_alta datetime NOT NULL, PRIMARY KEY  USING BTREE (blogid,postid,commentid)) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1");
            pt.execute();
            
            pt=con.prepareStatement("CREATE TABLE wbblogpermissions (blogid int(10) unsigned NOT NULL auto_increment, userid varchar(45) NOT NULL, level int(10) unsigned NOT NULL,isrol tinyint(1) NOT NULL,PRIMARY KEY  (blogid,userid)) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1");
            pt.execute();
            
            pt=con.prepareStatement("CREATE TABLE wbblogpost ( postid int(10) unsigned NOT NULL auto_increment,  blogid int(10) unsigned NOT NULL,  title varchar(255) NOT NULL,  description text NOT NULL,  fec_alta datetime NOT NULL,  userid varchar(255) NOT NULL,  PRIMARY KEY  (postid,blogid),  KEY FK_post_1 (blogid)) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1");
            pt.execute();
            con.commit();
            con.setAutoCommit(true);            
        }
        catch(SQLException sqle)
        {
             log.error(sqle);
             throw new SWBResourceException("It was not possible to create the tables of the BlogResource: "+sqle.getMessage(),sqle);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(SQLException sqle)
            {
                log.error(sqle);
            }
        }
    }
    public void uninstallMySql(ResourceType type) throws SWBResourceException
    {
        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
            con.setAutoCommit(false);
            PreparedStatement pt=con.prepareStatement("DROP TABLE IF EXISTS wbblog");
            pt.execute();                        
            pt=con.prepareStatement("DROP TABLE IF EXISTS wbblogcomments");
            pt.execute();
            pt=con.prepareStatement("DROP TABLE IF EXISTS wbblogpermissions");
            pt.execute();            
            pt=con.prepareStatement("DROP TABLE IF EXISTS wbblogpost");
            pt.execute();            
            con.commit();
            con.setAutoCommit(true);                        
        }
        catch(SQLException sqle)
        {
             log.error(sqle);
             throw new SWBResourceException("It was not possible to create the tables of the BlogResource: "+sqle.getMessage(),sqle);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(SQLException sqle)
            {
                log.error(sqle);
            }
        }
    }

    @Override
    public void install(ResourceType recobj) throws SWBResourceException {
        String dbname=SWBUtils.DB.getDatabaseName();
        if(dbname.startsWith("MySQL") && dbname.indexOf("")!=-1)
        {
            this.installMySql(recobj);
        }
        else
        {
            throw new SWBResourceException("The data base "+dbname+" is not supported");
        }
    }

    @Override
    public void uninstall(ResourceType type) throws SWBResourceException
    {
        String dbname=SWBUtils.DB.getDatabaseName();
        if(dbname.startsWith("MySQL") && dbname.indexOf("5.0")!=-1)
        {
            uninstallMySql(type);
        }
        else
        {
            throw new SWBResourceException("The data base "+dbname+" is not supported");
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if ( paramRequest.getMode().equals("viewComents") )
        {
            doViewComments(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("ViewCommentsXML") )
        {
            doViewCommentsXML(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("ViewBlogXML") )
        {
            doViewBlogXML(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("createBlog") )
        {
            doCreateBlog(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("asignblog") )
        {
            doAsignblog(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("deleteBlog") )
        {
            doDeleteBlog(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("permissions") )
        {
            doPermissions(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("rol") )
        {
            doAsignRole(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("user") )
        {
            doAsignUser(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("changeTemplateBlog") )
        {
            doChangeTemplateBlog(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("changeTemplateComments") )
        {
            doChangeTemplateComments(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("viewTemplateBlog") )
        {
            doViewTemplateBlog(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("viewTemplateComments") )
        {
            doViewTemplateComments(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("viewTemplateByDefaultBlog") )
        {
            doViewTemplateByDefaultBlog(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("viewTemplateByDefaultComments") )
        {
            doViewTemplateByDefaultComments(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("editpost") )
        {
            doEditPost(request, response, paramRequest);
        }
        else if ( paramRequest.getMode().equals("changeSettings") )
        {
            doChangeSettings(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

    public int getNumMaxOfBlogs()
    {
        int numofblogs = 5;
        if ( this.getResourceBase().getAttribute("numofblogs") != null && !this.getResourceBase().getAttribute("numofblogs").equals("") )
        {
            try
            {
                numofblogs = Integer.parseInt(this.getResourceBase().getAttribute("numofblogs"));
            }
            catch ( NumberFormatException e )
            {
                log.error(e);
            }
        }
        return numofblogs;
    }

    public int getNumMaxOfComments()
    {
        int numofcomments = 5;
        if ( this.getResourceBase().getAttribute("numofcomments") != null && !this.getResourceBase().getAttribute("numofcomments").equals("") )
        {
            try
            {
                numofcomments = Integer.parseInt(this.getResourceBase().getAttribute("numofcomments"));
            }
            catch ( NumberFormatException e )
            {
                log.error(e);
            }
        }
        return numofcomments;
    }

    public boolean existBlog(int blogId)
    {
        boolean existBlog = false;
        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {

            PreparedStatement pt = con.prepareStatement("select blogid from wbblog where blogid=?");
            pt.setInt(1, blogId);
            ResultSet rs = pt.executeQuery();
            if ( rs.next() )
            {
                existBlog = true;
            }
            rs.close();
            pt.close();

        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
        return existBlog;
    }

    public void doEditPost(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {

        String mode = request.getParameter("mode");
        String postid = request.getParameter("postid");
        if ( mode != null && !mode.equals("") && postid != null && !postid.equals("") )
        {
            if ( mode.equals("getTitle") )
            {
                getTitlePost(request, response, paramRequest, Integer.parseInt(postid));
            }
            if ( mode.equals("getContent") )
            {
                getContentPost(request, response, paramRequest, Integer.parseInt(postid));

            }
        }

    }

    private void getContentPost(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, int postid) throws IOException
    {
        PrintWriter out = response.getWriter();
        UserRepository userRep = paramRequest.getUser().getUserRepository();
        Post post = new Post(postid, Integer.parseInt(this.getResourceBase().getAttribute("blogid")),userRep);
        Document doc = new Document();
        Element content = new Element("content");
        doc.addContent(content);
        content.setText(SWBUtils.TEXT.encode(post.getDescription(),"utf-8"));
        response.setContentType("text/xml");
        XMLOutputter xMLOutputter = new XMLOutputter();
        xMLOutputter.output(doc, out);
        out.close();
    }

    private void getTitlePost(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, int postid) throws IOException
    {

        PrintWriter out = response.getWriter();
        UserRepository userRep = paramRequest.getUser().getUserRepository();
        Post post = new Post(postid, Integer.parseInt(this.getResourceBase().getAttribute("blogid")),userRep);
        Document doc = new Document();
        Element content = new Element("title");
        doc.addContent(content);
        content.setText(SWBUtils.TEXT.encode(post.getTitle(),"utf-8"));
        response.setContentType("text/xml");
        XMLOutputter xMLOutputter = new XMLOutputter();
        xMLOutputter.output(doc, out);
        out.close();

    }

    public void doChangeSettings(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\" language=\"javascript\">");
        out.println("function validaForma(forma)");
        out.println("{");
        out.println("if(forma.format.value=='')");
        out.println("{");
        out.println("alert('"+ paramRequest.getLocaleString("invalidDate") +"');");
        out.println("return;");
        out.println("}");
        out.println("forma.submit();");
        out.println("}");
        out.println("</script>");
        out.println("<div class=\"swbform\"><fieldset><table width='100%'  border='0' cellpadding='5' cellspacing='0'> ");
        SWBResourceURL url = paramRequest.getActionUrl();
        out.println("<form action=" + url + " method='post'>");
        out.println("<tr><td >"+ paramRequest.getLocaleString("numOfEntriesToShow") +"</td>");
        out.println("<td><select name='numofblogs'>");
        int numofblogs = getNumMaxOfBlogs();
        for ( int i = 1; i <= 20; i++ )
        {
            out.println("<option " + (numofblogs == i ? "selected" : "") + "  value='" + i + "'>" + i + "</option>");
        }
        out.println("</select></td></tr>");
        out.println("<tr><td >"+ paramRequest.getLocaleString("numOfCommentsToShow") +"</td>");
        out.println("<td><select name='numofcomments'>");
        int numofcomments = getNumMaxOfComments();
        for ( int i = 1; i <= 20; i++ )
        {
            out.println("<option " + (numofcomments == i ? "selected" : "") + "  value='" + i + "'>" + i + "</option>");
        }
        out.println("</select></td></tr>");
        out.println("<tr><td >"+ paramRequest.getLocaleString("FormatOfDateOfBlobEntry") +":</td>");
        out.println("<td>");
        String format = this.getResourceBase().getAttribute("format", defaultFormat);
        out.println("<input class='valores' type='text' name='format' value=\"" + format + "\" size='50'>");
        out.println("</td></tr>");

        out.println("<tr><td >"+ paramRequest.getLocaleString("FormatOfDateForComments") +":</td>");
        out.println("<td>");
        String format_comments = this.getResourceBase().getAttribute("format_comments", defaultFormat);
        out.println("<input class='valores' type='text' name='format_comments' value=\"" + format_comments + "\" size='50'>");
        out.println("</td></tr>");

        out.println("<tr>");
        out.println("<td colspan='2'>");

        out.println("<div ><table  border='1' width='100%'  border='0' cellpadding='5' cellspacing='0'>");
        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("dayOfMonth"));
        out.println("</td>");
        out.println("<td >d</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("month"));
        out.println("</td>");
        out.println("<td >M</td></tr>");

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("year"));
        out.println("</td>");
        out.println("<td >y </td></tr>");

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("time24"));
        out.println("</td>");
        out.println("<td >H</td></tr>");

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("time12"));
        out.println("</td>");
        out.println("<td >h</td></tr>");

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("minutes"));
        out.println("</td>");
        out.println("<td >m</td></tr>");

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("seconds"));
        out.println("</td>");
        out.println("<td >s</td></tr>");


        out.println("<tr>");
        out.println("<td  >");
        out.println(paramRequest.getLocaleString("ampm"));
        out.println("</td>");
        out.println("<td >a</td></tr>");


        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("labelNote")+":");
        out.println("</td>");
        out.println("<td >"+ paramRequest.getLocaleString("note") +"</td></tr>");

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("formatByDefault")+": ");
        out.println("</td>");
        out.println("<td > " + defaultFormat + "</td></tr>");

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("example")+":");
        out.println("</td>");
        out.println("<td >dd/MM/yyyy 'a las' HH:mm:ss</td></tr>");

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("example")+":");
        out.println("</td>");
        out.println("<td >dd/MM/yyyy 'a las' hh:mm:ss a</td></tr>");

        out.println("</table></div>");

        out.println("</td>");
        out.println("</tr>");

        out.println("<tr><td colspan='2' ><input class='boton' type='button' value='"+ paramRequest.getLocaleString("save") +"' onClick='javascript:validaForma(this.form)'></td></tr>");
        out.println("</form>");
        SWBResourceURL urlback = paramRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("</td></tr><tr><td colspan='2' ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></td></tr>");
        out.println("</table></fieldset></div>");
        out.close();
    }

    public void doViewTemplateByDefaultComments(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml");
        InputStream styleStream = styleStream = Blog.class.getResourceAsStream("comments.xsl");
        try
        {
            SAXBuilder builder = new SAXBuilder();
            Document docToReturn = builder.build(styleStream);
            XMLOutputter xMLOutputter = new XMLOutputter();
            xMLOutputter.output(docToReturn, out);

        }
        catch ( Exception ex )
        {
            log.error(ex);
        }
        out.close();
    }

    public void doViewTemplateByDefaultBlog(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml");
        InputStream styleStream = Blog.class.getResourceAsStream("blog.xsl");
        try
        {
            SAXBuilder builder = new SAXBuilder();
            Document docToReturn = builder.build(styleStream);
            XMLOutputter xMLOutputter = new XMLOutputter();
            xMLOutputter.output(docToReturn, out);

        }
        catch ( Exception ex )
        {
            log.error(ex);
        }
        out.close();
    }

    public void doViewTemplateBlog(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml");
        InputStream styleStream = null;
        base = getResourceBase();
        if ( this.getResourceBase().getAttribute("templateblog") == null )
        {
            styleStream = Blog.class.getResourceAsStream("blog.xsl");
        }
        else
        {
            try{
                styleStream = SWBPlatform.getFileFromWorkPath(base.getWorkPath() + "/" + base.getAttribute("templateblog").trim());
            }
            catch(Exception e){ log.error(e);}
        }
        try
        {
            SAXBuilder builder = new SAXBuilder();
            Document docToReturn = builder.build(styleStream);
            XMLOutputter xMLOutputter = new XMLOutputter();
            xMLOutputter.output(docToReturn, out);

        }
        catch ( Exception ex )
        {
            log.error(ex);
        }
        out.close();
    }

    public void doViewTemplateComments(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml");
        InputStream styleStream = null;
        base=getResourceBase();
        if ( this.getResourceBase().getAttribute("templatecomments") == null )
        {
            styleStream = Blog.class.getResourceAsStream("comments.xsl");
        }
        else
        {
            try
            {
                styleStream = SWBPlatform.getFileFromWorkPath(base.getWorkPath() + "/" + base.getAttribute("templatecomments").trim());
            }
            catch(Exception e){ log.error(e);}
        }
        try
        {
            SAXBuilder builder = new SAXBuilder();
            Document docToReturn = builder.build(styleStream);
            XMLOutputter xMLOutputter = new XMLOutputter();
            xMLOutputter.output(docToReturn, out);

        }
        catch ( Exception ex )
        {
            log.error(ex);
        }
        out.close();
    }

    public void doAsignRole(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {

        User user = paramRequest.getUser();
        UserRepository userrep = paramRequest.getWebPage().getWebSite().getUserRepository();

        PrintWriter out = response.getWriter();
        if ( this.getResourceBase().getAttribute("blogid") == null || this.getResourceBase().getAttribute("blogid").equals("") )
        {
            out.println("<div class=\"swbform\"><fieldset><p>"+ paramRequest.getLocaleString("noBlogs") +"</p>");
            SWBResourceURL urlback = paramRequest.getRenderUrl();
            urlback.setMode(urlback.Mode_ADMIN);
            out.println("<p ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></p></fieldset></div>");
            return;
        }
        out.println("<div class=\"swbform\"><form action='" + paramRequest.getActionUrl() + "' method='post'><fieldset>");
        out.println("<table width='100%'  border='0' cellpadding='5' cellspacing='0'><tr><td>");
        out.println("<table width='100%'  border='0' cellpadding='5' cellspacing='0'>");

        int level = getLevel("*", true);

        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("all"));
        out.println("<td>");
        out.println("<td >");
        out.println("<select name='role_*'>");
        out.println("<option " + (level == 0 ? "selected" : "") + " value='0'>"+paramRequest.getLocaleString("level0"));
        out.println("<option " + (level == 1 ? "selected" : "") + " value='1'>"+paramRequest.getLocaleString("level1"));
        out.println("<option " + (level == 2 ? "selected" : "") + " value='2'>"+paramRequest.getLocaleString("level2"));
        out.println("<option " + (level == 3 ? "selected" : "") + " value='3'>"+paramRequest.getLocaleString("level3"));
        out.println("</select>");
        out.println("<td>");
        out.println("</tr>");
        Iterator<Role> roles = userrep.listRoles();
        while (roles.hasNext())
        {
            out.println("<tr>");
            out.println("<td  >");
            Role recRole = roles.next();
            level = getLevel(recRole.getId() + "_" + recRole.getUserRepository().getId(), true);
            out.println(recRole.getTitle());
            out.println("<td>");
            out.println("<td  >");
            out.println("<select class='valores' name='role_" + recRole.getId() + "_" + recRole.getUserRepository().getId() + "'>");
            out.println("<option " + (level == 0 ? "selected" : "") + " value='0'>"+paramRequest.getLocaleString("level0"));
            out.println("<option " + (level == 1 ? "selected" : "") + " value='1'>"+paramRequest.getLocaleString("level1"));
            out.println("<option " + (level == 2 ? "selected" : "") + " value='2'>"+paramRequest.getLocaleString("level2"));
            out.println("<option " + (level == 3 ? "selected" : "") + " value='3'>"+paramRequest.getLocaleString("level3"));
            out.println("</select>");
            out.println("<td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</td></tr><tr><td colspan='2' ><input class='boton' type='submit' name='save' value='"+ paramRequest.getLocaleString("saveAsign") +"'></td></tr>");
        SWBResourceURL urlback = paramRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("</td></tr><tr><td colspan='2' ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></td></tr></table></fieldset></form></div>");
        out.close();
    }

    public int getLevel(String userid, boolean isrool)
    {
        int level = 0;
        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
            int blogid = Integer.parseInt(this.getResourceBase().getAttribute("blogid"));
            PreparedStatement pt = con.prepareStatement("select level from wbblogpermissions where blogid=? and userid=? and isrol=?");
            pt.setInt(1, blogid);
            pt.setString(2, userid);
            if ( isrool )
            {
                pt.setInt(3, 1);
            }
            else
            {
                pt.setInt(3, 0);
            }
            ResultSet rs = pt.executeQuery();
            if ( rs.next() )
            {
                level = rs.getInt("level");
            }
            rs.close();
            pt.close();
        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
        return level;
    }

    public void doAsignUser(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        User user = paramRequest.getUser();
        UserRepository userrep = paramRequest.getWebPage().getWebSite().getUserRepository();

        PrintWriter out = response.getWriter();
        if ( this.getResourceBase().getAttribute("blogid") == null || this.getResourceBase().getAttribute("blogid").equals("") )
        {
            out.println("<div class=\"swbform\"><fieldset><p>"+ paramRequest.getLocaleString("noBlogs") +"</p>");
            SWBResourceURL urlback = paramRequest.getRenderUrl();
            urlback.setMode(urlback.Mode_ADMIN);
            out.println("<p ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></p></fieldset></div>");
            return;
        }
        out.println("<div class=\"swbform\"><fieldset><form action='" + paramRequest.getActionUrl() + "' method='post'>");
        out.println("<table width='100%'  border='0' cellpadding='5' cellspacing='0'><tr><td>");
        out.println("<table width='100%'  border='0' cellpadding='5' cellspacing='0'>");

        int level = getLevel("*", false);
        out.println("<tr>");
        out.println("<td >");
        out.println(paramRequest.getLocaleString("all"));
        out.println("<td>");
        out.println("<td >");
        out.println("<select class='valores' name='user_*'>");
        out.println("<option " + (level == 0 ? "selected" : "") + " value='0'>"+ paramRequest.getLocaleString("level0") +"");
        out.println("<option " + (level == 1 ? "selected" : "") + " value='1'>"+paramRequest.getLocaleString("level1"));
        out.println("<option " + (level == 2 ? "selected" : "") + " value='2'>"+paramRequest.getLocaleString("level2"));
        out.println("<option " + (level == 3 ? "selected" : "") + " value='3'>"+paramRequest.getLocaleString("level3"));
        out.println("</select>");
        out.println("<td>");
        out.println("</tr>");
        Iterator<User> users = userrep.listUsers();
        while (users.hasNext())
        {
            out.println("<tr>");
            out.println("<td >");
            User recuser = users.next();
            level = getLevel(recuser.getId() + "_" + recuser.getUserRepository().getId(), false);
            out.println(recuser.getName() + " " + recuser.getLastName());
            out.println("<td>");
            out.println("<td>");
            out.println("<select class='valores' name='user_" + recuser.getId() + "_" + recuser.getUserRepository().getId() + "'>");
            out.println("<option " + (level == 0 ? "selected" : "") + " value='0'>"+paramRequest.getLocaleString("level0"));
            out.println("<option " + (level == 1 ? "selected" : "") + " value='1'>"+paramRequest.getLocaleString("level1"));
            out.println("<option " + (level == 2 ? "selected" : "") + " value='2'>"+paramRequest.getLocaleString("level2"));
            out.println("<option " + (level == 3 ? "selected" : "") + " value='3'>"+paramRequest.getLocaleString("level3"));
            out.println("</select>");
            out.println("<td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</td></tr><tr><td colspan='2' ><input class='boton' type='submit' name='save' value='"+ paramRequest.getLocaleString("saveAsign") +"'></td></tr>");
        SWBResourceURL urlback = paramRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("</td></tr><tr><td colspan='2' ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></td></tr></table></form></fieldset></div>");
        out.close();
    }

    public void doPermissions(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println("<div class=\"swbform\"><fieldset><form action='" + paramRequest.getActionUrl() + "' method='post'>");
        out.println("<table width='100%'  border='0' cellpadding='5' cellspacing='0'><tr><td >"+ paramRequest.getLocaleString("saveAsign") +":</td><td >");
        out.println("<input class='valores' checked type='radio' name='type' value='rol'>"+ paramRequest.getLocaleString("byRol") +"<br><input class='valores' type='radio' name='type' value='user'>"+ paramRequest.getLocaleString("byUser") +"</td></tr><tr><td colspan='2' ><input class='boton' type='submit' name='save' value='"+ paramRequest.getLocaleString("saveAsign") +"'></td></tr>");
        SWBResourceURL urlback = paramRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("</td></tr><tr><td colspan='2' ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></td></tr></table></form></fieldset></div>");
        out.close();
    }

    public void doDeleteBlog(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();

        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
            int cuenta = 0;
            PreparedStatement pt = con.prepareStatement("select count(*) as cuenta from wbblog");
            ResultSet rs = pt.executeQuery();
            if ( rs.next() )
            {
                cuenta = rs.getInt("cuenta");
            }
            rs.close();
            pt.close();

            if ( cuenta == 0 )
            {
                out.println("<div class=\"swbform\"><fieldset><p>"+ paramRequest.getLocaleString("noBlogs") +"</p>");
                SWBResourceURL urlback = paramRequest.getRenderUrl();
                urlback.setMode(urlback.Mode_ADMIN);
                out.println("<p ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></p></fieldset></div>");
                return;
            }
            else
            {
                out.println("<div class=\"swbform\"><fieldset><form action='" + paramRequest.getActionUrl() + "' method='post'>");
                out.println("<table width='100%' cellpadding='5' cellspacing='0'><tr><td >"+ paramRequest.getLocaleString("nameBlog") +":</td><td class='valores'><select name='deleteblog'>");
                pt = con.prepareStatement("select * from wbblog");
                rs = pt.executeQuery();
                while (rs.next())
                {
                    out.println("<option value='" + rs.getString("blogid") + "'>" + rs.getString("blogname") + "</option>");
                }
                rs.close();
                pt.close();
                out.println("</select></td></tr><tr><td colspan='2' ><input type='submit' class='boton' name='save' value='"+ paramRequest.getLocaleString("deleteBlog") +"'></td></tr>");
                SWBResourceURL urlback = paramRequest.getRenderUrl();
                urlback.setMode(urlback.Mode_ADMIN);
                out.println("</td></tr><tr><td colspan='2' ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></td></tr></table></form></fieldset></div>");
                out.close();
            }


        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }

    }

    public void doAsignblog(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();

        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
            int cuenta = 0;
            PreparedStatement pt = con.prepareStatement("select count(*) as cuenta from wbblog");
            ResultSet rs = pt.executeQuery();
            if ( rs.next() )
            {
                cuenta = rs.getInt("cuenta");
            }

            rs.close();
            pt.close();
            if ( cuenta == 0 )
            {
                out.println("<div class=\"swbform\"><fieldset><p>"+ paramRequest.getLocaleString("noBlogs") +"</p>");
                SWBResourceURL urlback = paramRequest.getRenderUrl();
                urlback.setMode(urlback.Mode_ADMIN);
                out.println("<p ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></p></fieldset></div>");
            }
            else
            {
                out.println("<div class=\"swbform\"><fieldset><form action='" + paramRequest.getActionUrl() + "' method='post'>");
                out.println("<table width='100%' cellpadding='5' cellspacing='0'><tr><td >"+ paramRequest.getLocaleString("nameBlog") +":</td><td><select name='blog'>");
                pt = con.prepareStatement("select * from wbblog");
                rs = pt.executeQuery();
                while (rs.next())
                {
                    out.println("<option value='" + rs.getString("blogid") + "'>" + rs.getString("blogname") + "</option>");
                }
                rs.close();
                pt.close();
                out.println("</select></td></tr><tr><td colspan='2' ><input class='boton' type='submit' name='save' value='"+ paramRequest.getLocaleString("buttonAsign") +"'></td></tr>");
                SWBResourceURL urlback = paramRequest.getRenderUrl();
                urlback.setMode(urlback.Mode_ADMIN);
                out.println("</td></tr><tr><td colspan='2' ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></td></tr></table></form></fieldset></div>");
            }
        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }

        out.close();
    }

    public void doCreateBlog(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        try{
        createForm(out, paramRequest);
        }
        catch(Exception e){log.error(e);}
        out.close();
    }

    public void doViewCommentsXML(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        String sBlogId = request.getParameter("blogid");
        String spostid = request.getParameter("postid");
        if ( sBlogId != null && !sBlogId.equals("") )
        {
            if ( spostid != null && !spostid.equals("") )
            {
                int postid = Integer.parseInt(spostid);
                int blogid = Integer.parseInt(sBlogId);
                SWBResourceURL url = paramRequest.getRenderUrl();
                url.setMode("viewComents");
                url.setCallMethod(url.Call_CONTENT);
                url.setParameter("viewall", "true");
                url.setParameter("postid", String.valueOf(postid));
                try{
                    Document doc = getComments(paramRequest, blogid, postid, paramRequest.getWebPage().getUrl(), true, url.toString());
                    XMLOutputter xMLOutputter = new XMLOutputter();
                    xMLOutputter.output(doc, out);
                }
                catch(Exception e){log.error(e);}
                
            }
        }
        out.close();
    }

    public void doViewBlogXML(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String pathDeleteBlog = getDeleteImagePath(paramRequest);
        String pathEditBlog = getEditImagePath(paramRequest);
        String pathAddBlog=getAddImagePath(paramRequest);
        PrintWriter out = response.getWriter();
        String sBlogId = this.getResourceBase().getAttribute("blogid");
        if ( sBlogId != null && !sBlogId.equals("") )
        {
            try
            {
                long blogId = Long.parseLong(sBlogId);
                Blog blog = new Blog(blogId, paramRequest.getUser(), this.getResourceBase().getAttribute("format", defaultFormat), pathDeleteBlog, pathEditBlog,pathAddBlog);
                Document doc = blog.toXML(getNumMaxOfBlogs());
                response.setContentType("text/xml");
                XMLOutputter xMLOutputter = new XMLOutputter();
                xMLOutputter.output(doc, out);
            }
            catch ( NumberFormatException nfe ) // Error
            {
                log.error(nfe);
            }
            catch ( IllegalArgumentException nfe ) // Error
            {
                log.error("Error al tratar de buscar un blog, en el recurso " + this.getResourceBase().getId() + ", en la p�gina: " + paramRequest.getWebPage().getId() + ", En el sitio " + paramRequest.getWebPage().getWebSiteId(),nfe);
            }
            catch ( Exception nfe ) // Error
            {
                log.error(nfe);
            }
        }
        out.close();
    }

    public void updatePost(HttpServletRequest request, SWBActionResponse response, int blogid, int postid) throws SWBResourceException, IOException
    {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        if ( title != null && description != null )
        {
            Connection con = SWBUtils.DB.getDefaultConnection();
            try
            {
                PreparedStatement pt = con.prepareStatement("update wbblogpost set title=?,description=? where blogid=? and postid=?");
                pt.setString(1, title);
                pt.setString(2, description);
                pt.setInt(3, blogid);
                pt.setInt(4, postid);
                pt.executeUpdate();
                pt.close();
            }
            catch ( SQLException sqle )
            {
                log.error(sqle);
            }
            finally
            {
                if ( con != null )
                {
                    try
                    {
                        con.close();
                    }
                    catch ( SQLException sqle )
                    {
                        log.error(sqle);
                    }
                }
            }
        }
    }

    public void addPost(HttpServletRequest request, SWBActionResponse response, int blogid) throws SWBResourceException, IOException
    {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if ( title != null && description != null )
        {
            Connection con = SWBUtils.DB.getDefaultConnection();
            try
            {
                int postId = 0;
                PreparedStatement pt = con.prepareStatement("select max(postid) as maximo from wbblogpost where blogid=" + blogid);
                ResultSet rs = pt.executeQuery();
                if ( rs.next() )
                {
                    postId = rs.getInt("maximo");
                }
                rs.close();
                pt.close();
                postId++;
                pt = con.prepareStatement("insert into wbblogpost(postid,blogid,title,description,fec_alta,userid) values(?,?,?,?,?,?)");
                pt.setInt(1, postId);
                pt.setInt(2, blogid);
                pt.setString(3, title);
                pt.setString(4, description);
                pt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
                pt.setString(6, response.getUser().getId()+"_"+response.getUser().getUserRepository().getId());
                pt.executeUpdate();
                pt.close();
            }
            catch ( SQLException sqle )
            {
                log.error(sqle);
            }
            finally
            {
                if ( con != null )
                {
                    try
                    {
                        con.close();
                    }
                    catch ( SQLException sqle )
                    {
                        log.error(sqle);
                    }
                }
            }
        }

    }

    public synchronized void insertComment(HttpServletRequest request, SWBActionResponse response, int postid, int blogid, String comment) throws SWBResourceException, IOException
    {
        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
            PreparedStatement pt = con.prepareStatement("select postid from wbblogpost where postid=" + postid + " and blogid=" + blogid);
            ResultSet rs = pt.executeQuery();
            if ( !rs.next() )
            {
                rs.close();
                pt.close();
                throw new IllegalArgumentException("El post no existe");
            }
            rs.close();
            pt.close();

            int commentid = 0;
            pt = con.prepareStatement("select max(commentid) as maximo from wbblogcomments where postid=" + postid + " and blogid=" + blogid);
            rs = pt.executeQuery();
            if ( rs.next() )
            {
                commentid = rs.getInt("maximo");
            }
            commentid++;
            rs.close();
            pt.close();

            pt = con.prepareStatement("insert into wbblogcomments(blogid,postid,commentid,comment,userid,fec_alta) values(?,?,?,?,?,?)");
            pt.setInt(1, blogid);
            pt.setInt(2, postid);
            pt.setInt(3, commentid);
            pt.setString(4, comment);
            pt.setString(5, response.getUser().getId()+"_"+response.getUser().getUserRepository().getId());
            pt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            pt.executeUpdate();
            pt.close();
        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
    }

    public synchronized void deleteBlog(HttpServletRequest request, SWBActionResponse response, int blogid) throws SWBResourceException, IOException
    {
        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {

            PreparedStatement pt = con.prepareStatement("delete from wbblogpermissions where blogid=" + blogid);
            pt.executeUpdate();
            pt.close();

            pt = con.prepareStatement("delete from wbblog where blogid=" + blogid);
            pt.executeUpdate();
            pt.close();

            pt = con.prepareStatement("delete from wbblogcomments where blogid=" + blogid);
            pt.executeUpdate();
            pt.close();

            pt = con.prepareStatement("delete from wbblogpost where blogid=" + blogid);
            pt.executeUpdate();
            pt.close();




            response.setMode(response.Mode_ADMIN);
        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
    }

    public synchronized void deletePost(HttpServletRequest request, int postid, int blogid) throws SWBResourceException, IOException
    {

        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
            PreparedStatement pt = con.prepareStatement("delete from wbblogpost where postid=" + postid + " and blogid=" + blogid);
            pt.executeUpdate();
            pt.close();
            pt = con.prepareStatement("delete from wbblogcomments where postid=" + postid + " and blogid=" + blogid);
            pt.executeUpdate();
            pt.close();
        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }

    }

    public void createBlog(String name,boolean asign)
    {
        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
            int blogid = 0;
            PreparedStatement pt = con.prepareStatement("select max(blogid) as maximo from wbblog");
            ResultSet rs = pt.executeQuery();
            if ( rs.next() )
            {
                blogid = rs.getInt("maximo");
            }
            rs.close();
            pt.close();
            blogid++;
            pt = con.prepareStatement("insert into wbblog(blogid,blogname) values(?,?)");
            pt.setInt(1, blogid);
            pt.setString(2, name);
            pt.executeUpdate();
            pt.close();
            if ( asign )
            {
                asignBlog(blogid);
            }

        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
    }
    private synchronized void createBlog(HttpServletRequest request, SWBActionResponse response, String name, boolean asign)
    {
        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
            int blogid = 0;
            PreparedStatement pt = con.prepareStatement("select max(blogid) as maximo from wbblog");
            ResultSet rs = pt.executeQuery();
            if ( rs.next() )
            {
                blogid = rs.getInt("maximo");
            }
            rs.close();
            pt.close();
            blogid++;
            pt = con.prepareStatement("insert into wbblog(blogid,blogname) values(?,?)");
            pt.setInt(1, blogid);
            pt.setString(2, name);
            pt.executeUpdate();
            pt.close();
            if ( asign )
            {
                asignBlog(request, response, blogid);
            }
            response.setMode(response.Mode_ADMIN);

        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
    }

    public void asignBlog(int blogid)
    {
        this.getResourceBase().setAttribute("blogid", String.valueOf(blogid));
        try
        {
            this.getResourceBase().updateAttributesToDB();
        }
        catch ( SWBException afe )
        {
            log.error(afe);
        }
    }
    public void asignBlog(HttpServletRequest request, SWBActionResponse response, int blogid)
    {
        this.getResourceBase().setAttribute("blogid", String.valueOf(blogid));
        try
        {
            this.getResourceBase().updateAttributesToDB();
            response.setMode(response.Mode_ADMIN);
        }
        catch ( SWBException afe )
        {
            log.error(afe);
        }
    }

    public void asignRole(HttpServletRequest request, SWBActionResponse response, int blogid) throws SWBResourceException, IOException
    {
        Connection con = SWBUtils.DB.getDefaultConnection();
        Enumeration names = request.getParameterNames();
        try
        {
            while (names.hasMoreElements())
            {

                String name = ( String ) names.nextElement();
                if ( name.startsWith("role_") )
                {
                    String level = request.getParameter(name);
                    name = name.substring(5);
                    int ilevel = Integer.parseInt(level);
                    if ( ilevel > 0 )
                    {
                        try
                        {
                            PreparedStatement pt = con.prepareStatement("select count(*) as cuenta from wbblogpermissions where blogid=? and userid=? and isrol=?");
                            pt.setInt(1, blogid);
                            pt.setString(2, name);
                            pt.setInt(3, 1);
                            boolean exists = false;
                            ResultSet rs = pt.executeQuery();
                            if ( rs.next() )
                            {
                                if ( rs.getInt("cuenta") > 0 )
                                {
                                    exists = true;
                                }
                            }
                            rs.close();
                            pt.close();
                            if ( !exists )
                            {
                                pt = con.prepareStatement("insert into wbblogpermissions(blogid,userid,level,isrol) values(?,?,?,?)");
                                pt.setInt(1, blogid);
                                pt.setString(2, name);
                                pt.setInt(3, ilevel);
                                pt.setInt(4, 1);
                                pt.executeUpdate();
                                pt.close();
                            }
                            else
                            {
                                pt = con.prepareStatement("update wbblogpermissions set level=? where blogid=? and userid=? and isrol=?");
                                pt.setInt(1, ilevel);
                                pt.setInt(2, blogid);
                                pt.setString(3, name);
                                pt.setInt(4, 1);
                                pt.executeUpdate();
                                pt.close();
                            }
                        }
                        catch ( SQLException sqle )
                        {
                            log.error(sqle);
                        }
                    }
                    else // 0 no tiene permisos
                    {
                        try
                        {
                            PreparedStatement pt = con.prepareStatement("delete from wbblogpermissions where blogid=?  and userid=? and isrol=1");
                            pt.setInt(1, blogid);
                            pt.setString(2, name);
                            pt.executeUpdate();
                            pt.close();
                        }
                        catch ( SQLException sqle )
                        {
                            log.error(sqle);
                        }
                    }
                }
            }
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
    }

    public void asignRole(String name, int level, int blogid) throws SWBResourceException, IOException
    {
        Connection con = SWBUtils.DB.getDefaultConnection();
        try
        {
                if ( name.startsWith("role_") )
                {
                    name = name.substring(5);
                    if ( level > 0 )
                    {
                        try
                        {
                            PreparedStatement pt = con.prepareStatement("select count(*) as cuenta from wbblogpermissions where blogid=? and userid=? and isrol=?");
                            pt.setInt(1, blogid);
                            pt.setString(2, name);
                            pt.setInt(3, 1);
                            boolean exists = false;
                            ResultSet rs = pt.executeQuery();
                            if ( rs.next() )
                            {
                                if ( rs.getInt("cuenta") > 0 )
                                {
                                    exists = true;
                                }
                            }
                            rs.close();
                            pt.close();
                            if ( !exists )
                            {
                                pt = con.prepareStatement("insert into wbblogpermissions(blogid,userid,level,isrol) values(?,?,?,?)");
                                pt.setInt(1, blogid);
                                pt.setString(2, name);
                                pt.setInt(3, level);
                                pt.setInt(4, 1);
                                pt.executeUpdate();
                                pt.close();
                            }
                            else
                            {
                                pt = con.prepareStatement("update wbblogpermissions set level=? where blogid=? and userid=? and isrol=?");
                                pt.setInt(1, level);
                                pt.setInt(2, blogid);
                                pt.setString(3, name);
                                pt.setInt(4, 1);
                                pt.executeUpdate();
                                pt.close();
                            }
                        }
                        catch ( SQLException sqle )
                        {
                            log.error(sqle);
                        }
                    }
                    else // 0 no tiene permisos
                    {
                        try
                        {
                            PreparedStatement pt = con.prepareStatement("delete from wbblogpermissions where blogid=?  and userid=? and isrol=1");
                            pt.setInt(1, blogid);
                            pt.setString(2, name);
                            pt.executeUpdate();
                            pt.close();
                        }
                        catch ( SQLException sqle )
                        {
                            log.error(sqle);
                        }
                    }
                }

        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
    }


    public void asignUser(HttpServletRequest request, SWBActionResponse response, int blogid) throws SWBResourceException, IOException
    {
        Connection con = SWBUtils.DB.getDefaultConnection();
        Enumeration names = request.getParameterNames();
        try
        {
            while (names.hasMoreElements())
            {

                String name = ( String ) names.nextElement();
                if ( name.startsWith("user_") )
                {
                    String level = request.getParameter(name);
                    name = name.substring(5);
                    int ilevel = Integer.parseInt(level);
                    if ( ilevel > 0 )
                    {
                        try
                        {
                            PreparedStatement pt = con.prepareStatement("select count(*) as cuenta from wbblogpermissions where blogid=? and userid=? and isrol=?");
                            pt.setInt(1, blogid);
                            pt.setString(2, name);
                            pt.setInt(3, 0);
                            boolean exists = false;
                            ResultSet rs = pt.executeQuery();
                            if ( rs.next() )
                            {
                                if ( rs.getInt("cuenta") > 0 )
                                {
                                    exists = true;
                                }
                            }
                            rs.close();
                            pt.close();
                            if ( !exists )
                            {
                                pt = con.prepareStatement("insert into wbblogpermissions(blogid,userid,level,isrol) values(?,?,?,?)");
                                pt.setInt(1, blogid);
                                pt.setString(2, name);
                                pt.setInt(3, ilevel);
                                pt.setInt(4, 0);
                                pt.executeUpdate();
                                pt.close();
                            }
                            else
                            {
                                pt = con.prepareStatement("update wbblogpermissions set level=? where blogid=? and userid=? and isrol=?");
                                pt.setInt(1, ilevel);
                                pt.setInt(2, blogid);
                                pt.setString(3, name);
                                pt.setInt(4, 0);
                                pt.executeUpdate();
                                pt.close();
                            }
                        }
                        catch ( SQLException sqle )
                        {
                            log.error(sqle);
                        }
                    }
                    else // 0 no tiene permisos
                    {
                        try
                        {
                            PreparedStatement pt = con.prepareStatement("delete from wbblogpermissions where blogid=?  and userid=? and isrol=0");
                            pt.setInt(1, blogid);
                            pt.setString(2, name);
                            pt.executeUpdate();
                            pt.close();
                        }
                        catch ( SQLException sqle )
                        {
                            log.error(sqle);
                        }
                    }
                }

            }
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
    }

    public void addTemplateBlog(HttpServletRequest request, SWBActionResponse response, WBFileUpload upload) throws SWBResourceException, IOException
    {
        byte[] template = upload.getFileData("templateblog");
        ByteArrayInputStream in = new ByteArrayInputStream(template);
        try{
            this.getResourceBase().setAttribute("templateblog", "blog.xsl");
            this.getResourceBase().updateAttributesToDB();
            SWBPlatform.writeFileToWorkPath(this.getResourceBase().getWorkPath() + "/blog.xsl", in, response.getUser().getId());
        }
        catch(Exception e){log.error(e);}
        
        response.setMode(response.Mode_ADMIN);
    }

    public void addTemplateComments(HttpServletRequest request, SWBActionResponse response, WBFileUpload upload) throws SWBResourceException, IOException
    {
        byte[] template = upload.getFileData("templatecomments");
        ByteArrayInputStream in = new ByteArrayInputStream(template);
        try
        {
            this.getResourceBase().setAttribute("templatecomments", "comments.xsl");
            this.getResourceBase().updateAttributesToDB();
            SWBPlatform.writeFileToWorkPath(this.getResourceBase().getWorkPath() + "/comments.xsl", in, response.getUser().getId());
        }
        catch(Exception e){log.error(e);}
        
        response.setMode(response.Mode_ADMIN);
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        if ( isMultipart(request) )
        {
            WBFileUpload upload = new WBFileUpload();
            upload.getFiles(request);
            String templateblog = upload.getFileName("templateblog");
            if ( templateblog != null && !templateblog.equals("") )
            {
                addTemplateBlog(request, response, upload);
                response.setMode(response.Mode_ADMIN);
                return;
            }
            String templatecomments = upload.getFileName("templatecomments");
            if ( templatecomments != null && !templatecomments.equals("") )
            {
                addTemplateComments(request, response, upload);
                response.setMode(response.Mode_ADMIN);
                return;
            }
        }
        else
        {

            String format_comments = request.getParameter("format_comments");
            if ( format_comments != null && !format_comments.equals("") )
            {
                try
                {
                    SimpleDateFormat dateformat = new SimpleDateFormat(format_comments);
                    getResourceBase().setAttribute("format_comments", format_comments);
                    try{
                        getResourceBase().updateAttributesToDB();
                    }catch(SWBException e){log.error(e);}
                }
                catch ( IllegalArgumentException iae )
                {
                    log.error(iae);
                    return;
                }
                response.setMode(response.Mode_ADMIN);
            }
            String format = request.getParameter("format");
            if ( format != null && !format.equals("") )
            {
                try
                {
                    SimpleDateFormat dateformat = new SimpleDateFormat(format);
                    getResourceBase().setAttribute("format", format);
                    try{
                        getResourceBase().updateAttributesToDB();
                    }catch(SWBException e){log.error(e);}
                }
                catch ( IllegalArgumentException iae )
                {
                    log.error(iae);
                    return;
                }
                response.setMode(response.Mode_ADMIN);
            }
            String deleteblog = request.getParameter("deleteblog");
            if ( deleteblog != null && !deleteblog.equals("") )
            {
                deleteBlog(request, response, Integer.parseInt(deleteblog));
            }
            String numofblogs = request.getParameter("numofblogs");
            if ( numofblogs != null && !numofblogs.equals("") )
            {
                this.getResourceBase().setAttribute("numofblogs", String.valueOf(Integer.parseInt(numofblogs)));
                try{
                    getResourceBase().updateAttributesToDB();
                }catch(SWBException e){log.error(e);}
                response.setMode(response.Mode_ADMIN);
                return;
            }

            String numofcomments = request.getParameter("numofcomments");
            if ( numofcomments != null && !numofcomments.equals("") )
            {
                this.getResourceBase().setAttribute("numofcomments", String.valueOf(Integer.parseInt(numofcomments)));
                try
                {
                    getResourceBase().updateAttributesToDB();
                }catch(SWBException e){log.error(e);}
                response.setMode(response.Mode_ADMIN);
                return;
            }


            Enumeration names = request.getParameterNames();
            while (names.hasMoreElements())
            {
                String name = ( String ) names.nextElement();
                if ( name.startsWith("user_") )
                {

                    asignUser(request, response, Integer.parseInt(this.getResourceBase().getAttribute("blogid")));
                    response.setMode(response.Mode_ADMIN);
                    return;
                }
            }
            names = request.getParameterNames();
            while (names.hasMoreElements())
            {
                String name = ( String ) names.nextElement();
                if ( name.startsWith("role_") )
                {

                    asignRole(request, response, Integer.parseInt(this.getResourceBase().getAttribute("blogid")));
                    response.setMode(response.Mode_ADMIN);
                    return;
                }
            }


            String type = request.getParameter("type");
            if ( type != null && !type.equals("") )
            {
                response.setMode(type);
                return;
            }

            String blog = request.getParameter("blog");
            if ( blog != null && !blog.equals("") )
            {
                asignBlog(request, response, Integer.parseInt(blog));
                return;
            }


            String createBlog = request.getParameter("createblog");
            String asign = request.getParameter("asign");
            String name = request.getParameter("title");
            if ( createBlog != null && name != null && !name.equals("") && createBlog.equals("true") )
            {
                createBlog(request, response, name, Boolean.parseBoolean(asign));
                return;
            }
            String sBlogId = response.getResourceBase().getAttribute("blogid");
            String spostid = request.getParameter("postid");
            String comment = request.getParameter("comment");
            String mode = request.getParameter("mode");

            if ( sBlogId != null && !sBlogId.equals("") )
            {


                int blogid = Integer.parseInt(sBlogId);
                if ( spostid == null || spostid.equals("") )
                {
                    if ( mode != null && !mode.equals("") )
                    {
                        if ( mode.equals("create") )
                        {
                            addPost(request, response, blogid);
                        }
                    }
                }
                else
                {

                    int postid = Integer.parseInt(spostid);
                    if ( mode != null && !mode.equals("") )
                    {

                        if ( mode.startsWith("update") )
                        {
                            updatePost(request, response, blogid, postid);
                        }
                        if ( mode.startsWith("delete") )
                        {
                            deletePost(request, postid, blogid);
                        }
                    }
                    if ( comment != null && !comment.equals("") )
                    {
                        insertComment(request, response, postid, blogid, comment);
                        response.setRenderParameter("blogid", String.valueOf(blogid));
                        response.setRenderParameter("postid", String.valueOf(postid));
                    }
                }
            }
        }
    }

    private String getDeleteImagePath(SWBParamRequest paramRequest)
    {
        InputStream indeleteblog = BlogResource.class.getResourceAsStream(DELETE_FILE);
        String pathDeleteBlog = SWBPlatform.getWebWorkPath() + this.getResourceBase().getWorkPath() + "/" + DELETE_FILE;
        try
        {
            InputStream in = SWBPlatform.getFileFromWorkPath(this.getResourceBase().getWorkPath() + "/" + DELETE_FILE);
            if ( in == null )
            {
                SWBPlatform.writeFileToWorkPath(this.getResourceBase().getWorkPath() + "/" + DELETE_FILE, indeleteblog, paramRequest.getUser().getId());
            }
        }
        catch ( SWBException afe )
        {
            try
            {
                SWBPlatform.writeFileToWorkPath(this.getResourceBase().getWorkPath() + "/" + DELETE_FILE, indeleteblog, paramRequest.getUser().getId());
            }
            catch ( SWBException afe2 )
            {
                log.error(afe2);
            }
        }
        return pathDeleteBlog;
    }
    private String getAddImagePath(SWBParamRequest paramRequest)
    {
        InputStream indeleteblog = BlogResource.class.getResourceAsStream(ADD_FILE);
        String pathDeleteBlog = SWBPlatform.getWebWorkPath() + this.getResourceBase().getWorkPath() + "/" + ADD_FILE;
        try
        {
            InputStream in = SWBPlatform.getFileFromWorkPath(this.getResourceBase().getWorkPath() + "/" + ADD_FILE);
            if ( in == null )
            {
                SWBPlatform.writeFileToWorkPath(this.getResourceBase().getWorkPath() + "/" + ADD_FILE, indeleteblog, paramRequest.getUser().getId());
            }
        }
        catch ( SWBException afe )
        {
            try
            {
                SWBPlatform.writeFileToWorkPath(this.getResourceBase().getWorkPath() + "/" + ADD_FILE, indeleteblog, paramRequest.getUser().getId());
            }
            catch ( SWBException afe2 )
            {
                log.error(afe2);
            }
        }
        return pathDeleteBlog;
    }

    private String getEditImagePath(SWBParamRequest paramRequest)
    {
        InputStream indeleteblog = BlogResource.class.getResourceAsStream(EDIT_FILE);
        String pathDeleteBlog = SWBPlatform.getWebWorkPath() + this.getResourceBase().getWorkPath() + "/" + EDIT_FILE;
        try
        {
            InputStream in = SWBPlatform.getFileFromWorkPath(this.getResourceBase().getWorkPath() + "/" + EDIT_FILE);
            if ( in == null )
            {
                SWBPlatform.writeFileToWorkPath(this.getResourceBase().getWorkPath() + "/" + EDIT_FILE, indeleteblog, paramRequest.getUser().getId());
            }
        }
        catch ( SWBException afe )
        {
            try
            {
                SWBPlatform.writeFileToWorkPath(this.getResourceBase().getWorkPath() + "/" + EDIT_FILE, indeleteblog, paramRequest.getUser().getId());
            }
            catch ( SWBException afe2 )
            {
                log.error(afe2);
            }
        }
        return pathDeleteBlog;
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
   {
        String pathDeleteBlog = getDeleteImagePath(paramRequest);
        String pathEditBlog = getEditImagePath(paramRequest);
        String pathAddBlog=getAddImagePath(paramRequest);
        PrintWriter out = response.getWriter();
        String sBlogId = this.getResourceBase().getAttribute("blogid");
        if ( sBlogId != null && !sBlogId.equals("") )
        {
            try
            {
                long blogId = Long.parseLong(sBlogId);
                Blog blog = new Blog(blogId, paramRequest.getUser(), this.getResourceBase().getAttribute("format", defaultFormat), pathDeleteBlog, pathEditBlog,pathAddBlog);
                Document doc = blog.toXML(getNumMaxOfBlogs());
                String sytylePath = this.getResourceBase().getAttribute("templateblog");
                String htmlDocument = null;
                InputStream styleStream = null;
                if ( sytylePath == null )
                {
                    styleStream = BlogResource.class.getResourceAsStream("blog.xsl");
                }
                else
                {
                    styleStream = SWBPlatform.getFileFromWorkPath(this.getResourceBase().getWorkPath() + "/" + this.getResourceBase().getAttribute("templateblog").trim());
                }
                Templates templates = SWBUtils.XML.loadTemplateXSLT(styleStream);
                DOMOutputter Domout = new DOMOutputter();
                htmlDocument = SWBUtils.XML.transformDom(templates, Domout.output(doc));
                htmlDocument = htmlDocument.replaceAll("&lt;", "<");
                htmlDocument = htmlDocument.replaceAll("&gt;", ">");
                styleStream.close();
                out.println("<script type=\"text/javascript\">");
                InputStream script = BlogResource.class.getResourceAsStream("blogscripts.js");
                SWBResourceURL url = paramRequest.getActionUrl();
                byte[] buffer = new byte[2048];
                int read = script.read(buffer);
                while (read != -1)
                {
                    String data = new String(buffer, 0, read, "UTF-8");
                    data = data.replaceAll("\\[urladd\\]", url.toString());
                    data = data.replaceAll("\\[blogid\\]", String.valueOf(blog.getBlogID()));
                    data = data.replaceAll("\\[urldeletepost\\]", url.toString());
                    SWBResourceURL editPost = paramRequest.getRenderUrl();
                    editPost.setMode("editpost");
                    editPost.setCallMethod(url.Call_DIRECT);
                    data = data.replaceAll("\\[urleditpost\\]", editPost.toString());
                    SWBResourceURL urlviewComments = paramRequest.getRenderUrl();
                    urlviewComments.setMode("viewComents");

                    SWBResourceURL urladdComments = paramRequest.getRenderUrl();
                    urladdComments.setMode("addComent");

                    data = data.replaceAll("\\[urlviewComments\\]", urlviewComments.toString());
                    data = data.replaceAll("\\[urladdComments\\]", urladdComments.toString());
                    out.println(data);
                    read = script.read(buffer);
                }
                out.println("</script>");

                out.println(htmlDocument);
            }
            catch ( NumberFormatException nfe ) // Error
            {
                log.error(nfe);
            }
            catch ( Exception nfe ) // Error
            {
                log.error(nfe);
            }
        }
        out.close();
    }

    private synchronized Document getComments(SWBParamRequest paramRequest, int blogid, int postid, String urlBlog, boolean showAll, String urlviewall) throws SWBException
    {
        User wbUser=paramRequest.getUser();
        Connection con = SWBUtils.DB.getDefaultConnection();
        Document doc = new Document();
        Element comments = new Element("comments");
        comments.setAttribute("blogid", String.valueOf(blogid));
        comments.setAttribute("postid", String.valueOf(postid));
        if ( showAll )
        {
            comments.setAttribute("viewall", "");
        }
        else
        {
            comments.setAttribute("viewall", urlviewall);
        }
        doc.addContent(comments);
        try
        {
            Post post = new Post(postid, blogid,wbUser.getUserRepository());
            comments.setAttribute("title", post.getTitle());
            comments.setAttribute("name", new Blog(blogid, wbUser, this.getResourceBase().getAttribute("format", defaultFormat), "", "","").getName());
            comments.setAttribute("url", urlBlog);
            comments.setAttribute("comments", String.valueOf(post.getNumberOfComments()));
            comments.setAttribute("id", String.valueOf(post.getPostID()));
            comments.setAttribute("blogid", String.valueOf(blogid));
            comments.setAttribute("date", new SimpleDateFormat(this.getResourceBase().getAttribute("dd/MM/yyyy 'a las' HH:mm:ss", defaultFormat)).format(post.getDate()));
            comments.setAttribute("author", post.getUser());
            Element eDescription = new Element("description");
            CDATA cDescription = new CDATA(post.getDescription());
            eDescription.addContent(cDescription);
            comments.addContent(eDescription);

            PreparedStatement pt = con.prepareStatement("select * from wbblogcomments where blogid=? and postid=? order by fec_alta desc");
            pt.setInt(1, blogid);
            pt.setInt(2, postid);
            if ( showAll )
            {
                ResultSet rs = pt.executeQuery();
                while (rs.next())
                {
                    Element comment = new Element("comment");
                    comment.setAttribute("date", new SimpleDateFormat(this.getResourceBase().getAttribute("format_comments", defaultFormat)).format(rs.getTimestamp("fec_alta")));
                    String userid = rs.getString("userid");

                    String uid = userid.substring(0,userid.indexOf("_"));
                    String repid = userid.substring(userid.indexOf("_")+1);
                    User recuser =UserRepository.getUserRepository(repid).getUser(uid);

                    //System.out.println("getComments: recuser: "+recuser);

                    StringBuffer name = new StringBuffer("");
                    if ( recuser == null )
                    {
                        name.append(paramRequest.getLocaleString("userAnonimous"));
                    }
                    else
                    {
                        name.append(recuser.getFullName());
                    }
                    String user = name.toString().trim();
                    comment.setAttribute("user", user);
                    comment.setText(rs.getString("comment"));
                    comments.addContent(comment);
                }
                pt.close();
                rs.close();
            }
            else
            {
                int numofcomments = getNumMaxOfComments();
                int i = 1;
                ResultSet rs = pt.executeQuery();
                while (rs.next())
                {
                    Element comment = new Element("comment");
                    comment.setAttribute("date", new SimpleDateFormat(this.getResourceBase().getAttribute("format_comments", defaultFormat)).format(rs.getTimestamp("fec_alta")));
                    String userid = rs.getString("userid");

                    String uid = userid.substring(0,userid.indexOf("_"));
                    String repid = userid.substring(userid.indexOf("_")+1);
                    User recuser =UserRepository.getUserRepository(repid).getUser(uid);

                    StringBuffer name = new StringBuffer("");
                    if ( recuser == null )
                    {
                        name.append(paramRequest.getLocaleString("userAnonimous"));
                    }
                    else
                    {
                        name.append(recuser.getFullName());
                    }
                    String user = name.toString().trim();
                    comment.setAttribute("user", user);
                    comment.setText(rs.getString("comment"));
                    comments.addContent(comment);
                    if ( i >= numofcomments )
                    {
                        break;
                    }
                    i++;
                }
                pt.close();
                rs.close();
            }
        }
        catch ( SQLException sqle )
        {
            log.error(sqle);
        }
        finally
        {
            if ( con != null )
            {
                try
                {
                    con.close();
                }
                catch ( SQLException sqle )
                {
                    log.error(sqle);
                }
            }
        }
        return doc;
    }

    public void doViewComments(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        String spostid = request.getParameter("postid");
        String sviewall = request.getParameter("viewall");
        boolean viewall = false;
        if ( sviewall != null && !sviewall.equals("") )
        {
            viewall = Boolean.parseBoolean(sviewall);
        }
        String sBlogId = this.getResourceBase().getAttribute("blogid", "");
        if ( sBlogId != null && !sBlogId.equals("") )
        {
            if ( spostid != null && !spostid.equals("") )
            {
                int postid = Integer.parseInt(spostid);
                int blogid = Integer.parseInt(sBlogId);
                SWBResourceURL urlviewComents = paramRequest.getRenderUrl();
                urlviewComents.setMode("viewComents");
                urlviewComents.setCallMethod(urlviewComents.Call_CONTENT);
                urlviewComents.setParameter("viewall", "true");
                urlviewComents.setParameter("postid", String.valueOf(postid));
                Document doc = null;
                try{
                    doc = getComments(paramRequest,blogid, postid, paramRequest.getWebPage().getUrl(), viewall, urlviewComents.toString());
                }
                catch(SWBException e){log.error(e);}
                String sytylePath = this.getResourceBase().getAttribute("templatecomments");
                String htmlDocument = null;
                InputStream styleStream = null;
                if ( sytylePath == null )
                {
                    styleStream = BlogResource.class.getResourceAsStream("comments.xsl");

                }
                else
                {
                    try
                    {
                        styleStream = SWBPlatform.getFileFromWorkPath(this.getResourceBase().getWorkPath() + "/" + this.getResourceBase().getAttribute("templatecomments").trim());
                    }
                    catch(SWBException e){log.error(e);}
                }
                try
                {
                    Templates templates = SWBUtils.XML.loadTemplateXSLT(styleStream);
                    DOMOutputter Domout = new DOMOutputter();
                    htmlDocument = SWBUtils.XML.transformDom(templates, Domout.output(doc));
                    styleStream.close();
                    out.println("<script type=\"text/javascript\">");
                    InputStream script = BlogResource.class.getResourceAsStream("comments.js");
                    SWBResourceURL url = paramRequest.getActionUrl();
                    byte[] buffer = new byte[2048];
                    int read = script.read(buffer);
                    while (read != -1)
                    {
                        String data = new String(buffer, 0, read);
                        data = data.replaceAll("\\[urltoAdd\\]", url.toString());
                        url.setMode("viewComents");
                        data = data.replaceAll("\\[url_comment_all\\]", url.toString() + "?viewall=true&postid=" + postid);
                        out.println(data);
                        read = script.read(buffer);
                    }
                    out.println("</script>");
                    htmlDocument = htmlDocument.replaceAll("&lt;", "<");
                    htmlDocument = htmlDocument.replaceAll("&gt;", ">");
                    out.println(htmlDocument);
                }
                catch ( Exception e )
                {
                    log.error(e);
                }
            }
        }
    }

    private void createForm(PrintWriter out, SWBParamRequest paramRequest) throws SWBResourceException
    {
        out.println("<script type=\"text/javascript\">");
        out.println("function createBlog(forma)");
        out.println("{");
        out.println("if(forma.name.value=='')");
        out.println("{");
        out.println("alert('"+ paramRequest.getLocaleString("msgBlogName") +"');");
        out.println("return;");
        out.println("}");
        out.println("forma.submit();");
        out.println("}");
        out.println("</script>");
        out.println("<div class=\"swbform\"><form action='" + paramRequest.getActionUrl() + "' method='post'><fieldset>");
        out.println("<input type='hidden' name='createblog' value='true'><table width='100%' cellpadding='5' cellspacing='0'><tr><td >"+ paramRequest.getLocaleString("nameBlog") +"</td><td><input class='valores' type='text' name='title' size='50' maxlength='200'></td></tr>");
        out.println("<tr><td colspan='2' ><input class='valores' CHECKED type='radio' name='asign' value='true'>"+ paramRequest.getLocaleString("showBlogContent") +"</td></tr>");
        out.println("<tr><td colspan='2' ><input class='valores' type='radio' name='asign' value='false'>"+ paramRequest.getLocaleString("notshowBlogContent") +"</td></tr>");
        out.println("<tr><td colspan='2' ><input class='boton' type='button' name='save' value='"+ paramRequest.getLocaleString("createBlog") +"' onClick='javascript:createBlog(this.form)'></td></tr>");
        SWBResourceURL urlback = paramRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("</td></tr><tr><td colspan='2' ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></td></tr></table></fieldset></form></div>");
    }

    public void doChangeTemplateBlog(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        SWBResourceURL url = paramRequest.getActionUrl();
        out.println(getScript(paramRequest));
        out.println("<div class=\"swbform\"><form name='frmResource' method='post' enctype='multipart/form-data' action='" + url.toString() + "'><fieldset>");
        out.println("<table width='100%'  border='0' cellpadding='5' cellspacing='0'><tr><td >"+ paramRequest.getLocaleString("templatefileBlog") +":</td><td><input class='valores' type=\"file\" name=\"templateblog\" size=\"40\" onChange=\"isFileType(this, 'xsl|xslt');\" /></td></tr><tr><td colspan='2' >" +
                "<input type='submit' name='btnSave' class='boton' value='"+ paramRequest.getLocaleString("save") +"' onClick=\"if(jsValida(this.form)) return true; else return false;\">" +
                "</td></tr>");
        SWBResourceURL urlback = paramRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("</td></tr><tr><td colspan='2' ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></td></tr></table>");
        out.println("</fieldset></form></div>");
    }

    private static boolean isMultipart(HttpServletRequest request)
    {
        boolean isMultipart = false;
        if ( request.getContentType() != null )
        {
            if ( request.getContentType().indexOf("multipart/form-data") != -1 )
            {
                isMultipart = true;
            }
        }
        return isMultipart;
    }

    public void doChangeTemplateComments(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();
        SWBResourceURL url = paramRequest.getActionUrl();
        out.println(getScript(paramRequest));
        out.println("<div class=\"swbform\"><form name='frmResource' method='post' enctype='multipart/form-data' action='" + url.toString() + "'><fieldset>");
        out.println("<table width='100%'  border='0' cellpadding='5' cellspacing='0'><tr><td >"+ paramRequest.getLocaleString("templateFileComments") +":</td><td><input type=\"file\" name=\"templatecomments\" size=\"40\" onChange=\"isFileType(this, 'xsl|xslt');\" /></td></tr><tr><td colspan='2' >" +
                "<input type='submit' name='btnSave' class='boton' value='"+paramRequest.getLocaleString("save")+"' onClick=\"if(jsValida(this.form)) return true; else return false;\">" +
                "</td></tr>");
        SWBResourceURL urlback = paramRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("</td></tr><tr><td colspan='2' ><a href='" + urlback + "'>"+ paramRequest.getLocaleString("back") +"</a></td></tr></table>");
        out.println("</fieldset></form></div>");
    }

    private String getScript(SWBParamRequest paramRequest)
    {
        StringBuffer ret = new StringBuffer("");
        WBAdmResourceUtils admResUtils = new WBAdmResourceUtils();
        try
        {
            ret.append("\n<script language=javascript>");
            ret.append("\nfunction jsValida(pForm) {");
            ret.append("\n   if(!isFileType(pForm.template, 'xsl|xslt')) return false;");
            ret.append("\n   return true; ");
            ret.append("\n }     ");
            ret.append(admResUtils.loadIsFileType());
            ret.append("\n</script>");
        }
        catch ( Exception e )
        {
            log.error(e);
        }
        return ret.toString();
    }

    /**
     * Asigna un blog � crea un blog
     * @param request
     * @param response
     * @param paramRequest
     * @throws com.infotec.appfw.exception.SWBException
     * @throws java.io.IOException
     */
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String pathDeleteBlog = getDeleteImagePath(paramRequest);
        String pathEditBlog = getEditImagePath(paramRequest);
        String pathAddBlog=getAddImagePath(paramRequest);
        PrintWriter out = response.getWriter();
        out.println("<div class=\"swbform\">");
        out.println("<fieldset>");
        out.println("<table width='100%'  border='0' cellpadding='5' cellspacing='0'> ");
        String sBlogId = this.getResourceBase().getAttribute("blogid");
        if ( sBlogId == null || sBlogId.equals("") )
        {
            out.println("<tr><td >");
            createForm(out, paramRequest);
            out.println("</td></tr>");

        }
        else
        {
            try
            {
                Blog blog = new Blog(Integer.parseInt(sBlogId), paramRequest.getUser(), this.getResourceBase().getAttribute("format", defaultFormat), pathDeleteBlog, pathEditBlog,pathAddBlog);
                out.println("<tr><td >"+ paramRequest.getLocaleString("blogAsigned") +": <b>" + blog.getName() + "</td></tr>");
            }
            catch ( IllegalArgumentException iae )
            {
                log.error("Error al tratar de buscar un blog, en el recurso " + this.getResourceBase().getId() + ", en la p�gina: " + paramRequest.getWebPage().getId() + ", En el sitio " + paramRequest.getWebPage().getWebSiteId());
                log.error(iae);
                out.println("<tr><td >");
                createForm(out, paramRequest);
                out.println("</td></tr>");
                this.getResourceBase().setAttribute("blogid", null);
                try{
                    this.getResourceBase().updateAttributesToDB();
                }
                catch(SWBException e){log.error(e);}

            }
        }
        out.println("<tr><td>&nbsp;</td></tr>");

        SWBResourceURL url = paramRequest.getRenderUrl();
        url.setMode("asignblog");
        url.setCallMethod(url.Call_CONTENT);
        out.println("<tr><td ><a href='" + url + "'>"+ paramRequest.getLocaleString("asignblog") +"</a></td></tr>");
        url.setMode("createBlog");
        url.setCallMethod(url.Call_CONTENT);
        out.println("<tr><td ><a href='" + url + "'>"+paramRequest.getLocaleString("createblog")+"</a></td></tr>");


        url.setMode("changeSettings");
        url.setCallMethod(url.Call_CONTENT);
        out.println("<tr><td ><a href='" + url + "'>"+  paramRequest.getLocaleString("config") +"</a></td></tr>");

        if ( sBlogId != null && !sBlogId.equals("") )
        {
            url.setMode("permissions");
            url.setCallMethod(url.Call_CONTENT);
            out.println("<tr><td ><a href='" + url + "?blogid=1&postid=1'>"+paramRequest.getLocaleString("asignpermissions")+"</a></td></tr>");
        }

        out.println("<tr><td>&nbsp;</td></tr>");

        url.setMode("ViewBlogXML");
        url.setCallMethod(url.Call_DIRECT);
        out.println("<tr><td ><a href='" + url + "' target='_blank'>"+paramRequest.getLocaleString("viewXMLBlog")+"</a></td></tr>");

        out.println("<tr><td>&nbsp;</td></tr>");

        url.setMode("viewTemplateBlog");
        url.setCallMethod(url.Call_DIRECT);
        out.println("<tr><td ><a href='" + url + "' target='_blank'>"+paramRequest.getLocaleString("viewTemplateBlog")+"</a></td></tr>");

        url.setMode("changeTemplateBlog");
        url.setCallMethod(url.Call_CONTENT);
        out.println("<tr><td ><a href='" + url + "'>"+paramRequest.getLocaleString("changeTemplateBlog")+"</a></td></tr>");

        out.println("<tr><td>&nbsp;</td></tr>");

        url.setMode("viewTemplateComments");
        url.setCallMethod(url.Call_DIRECT);
        out.println("<tr><td ><a href='" + url + "' target='_blank'>"+  paramRequest.getLocaleString("viewTemplateComments")+"</a></td></tr>");


        url.setMode("changeTemplateComments");
        url.setCallMethod(url.Call_CONTENT);
        out.println("<tr><td ><a href='" + url + "'>"+paramRequest.getLocaleString("changeTemplateComments")+"</a></td></tr>");


        out.println("<tr><td>&nbsp;</td></tr>");

        url.setMode("viewTemplateByDefaultBlog");
        url.setCallMethod(url.Call_DIRECT);
        out.println("<tr><td ><a href='" + url + "' target='_blank'>"+ paramRequest.getLocaleString("viewBlogTemplateExample") +"</a></td></tr>");

        url.setMode("viewTemplateByDefaultComments");
        url.setCallMethod(url.Call_DIRECT);
        out.println("<tr><td ><a href='" + url + "' target='_blank'>"+ paramRequest.getLocaleString("viewCommentsTemplateExample") +"</a></td></tr>");

        out.println("<tr><td>&nbsp;</td></tr>");

        url.setMode("deleteBlog");
        url.setCallMethod(url.Call_CONTENT);
        out.println("<tr><td ><a href='" + url + "'>"+ paramRequest.getLocaleString("deleteBlog") +"</a></td></tr>");

        out.println("</table>");
        out.println("</fieldset>");
        out.println("</div>");
        out.close();
    }
}
