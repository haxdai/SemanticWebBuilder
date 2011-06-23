/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.tankwar.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.tankwar.Tank;

/**
 *
 * @author javier.solis.g
 */
public class TankGame extends GenericResource
{

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        PrintWriter out=response.getWriter();
        out.println("<applet codebase=\"/work/models/TankWar/app\" archive=\"TankWarApplet.jar,lib/rsyntaxtextarea.jar,lib/autocomplete.jar\" code=\"com/infotec/games/infotank/TankGame.class\" width=\"800\" height=\"600\">");        
        out.println("<param name=\"jsess\" value=\"" + request.getSession().getId() + "\">");
        out.println("<param name=\"gtw\" value=\"" + paramRequest.getRenderUrl() + "\">");
        out.println("</applet>");        
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        if(paramRequest.getMode().equals("tks"))                
        {
            getTanks(request,response,paramRequest);        
        }else if(paramRequest.getMode().equals("tk"))
        {
            getTank(request,response,paramRequest);        
        }else if(paramRequest.getMode().equals("stk"))
        {
            saveTank(request,response,paramRequest);        
        }else
        {
            super.processRequest(request, response, paramRequest);
        }
    }
    
    public void getTanks(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        PrintWriter out=response.getWriter();
        WebSite site=paramRequest.getWebPage().getWebSite();
        Iterator<Tank> it=Tank.ClassMgr.listTanks(site);
        while (it.hasNext()) {
            Tank tank = it.next();
            out.println(tank.getId()+" 0 0");
        }
        //out.println("DemoTank 0 0");
        //out.println("JeiTank 3 2");
        //out.println("SleepyTank 1 1");
        //out.println("JeiTank 2 3");
        //out.println("DemoTank 3 4");
        //out.println("DemoTank 0 5");
    }
    
    public void getTank(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        String code=null;
        PrintWriter out=response.getWriter();
        WebSite site=paramRequest.getWebPage().getWebSite();
        Tank tk=Tank.ClassMgr.getTank(request.getParameter("id"), site);
        if(tk!=null)
        {
            code=tk.getTankCode();
            if(code==null)
            {
                code=SWBUtils.TEXT.join("\n",new String[]{                        
                    "    function getName()",
                    "    {",
                    "        return \""+tk.getTitle()+"\";",
                    "    }",
                    "",
                    "    function move(tank)",
                    "    {",
                    "        while(!tank.moveForward())",
                    "        {",
                    "            tank.setTankDirection(Math.random() * 360);",
                    "        }",
                    "        if(tank.haveBullets())",
                    "        {",
                    "            tank.fireBullets(Math.random() * 360);",
                    "        }",
                    "        if(tank.haveMissile())",
                    "        {",
                    "            tank.fireMissile(Math.random() * 360,Math.random() * tank.getBattlefieldHeight());",
                    "        }",
                    "    }"
                });


            }
        }
        out.println(code);
    }
    
    public void saveTank(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        WebSite site=paramRequest.getWebPage().getWebSite();
        User user=paramRequest.getUser();
        Tank tk=null;
        Iterator<Tank> it=Tank.ClassMgr.listTankByCreator(user, site);
        if(it.hasNext())tk=it.next();

        if(tk!=null)
        {
            String code=SWBUtils.IO.readInputStream(request.getInputStream());
            tk.setTankCode(code);
            System.out.println("code:"+code);
        }
        
    }    
    
    
}
