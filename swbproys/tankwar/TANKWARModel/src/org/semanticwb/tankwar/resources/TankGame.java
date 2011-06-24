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
        String tankids[]=request.getParameterValues("tankID");
        request.getSession().setAttribute("tankids", tankids);
        System.out.println(tankids);
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
        }else if(paramRequest.getMode().equals("uts"))
        {
            updateTankScore(request, response, paramRequest);
        }else
        {
            super.processRequest(request, response, paramRequest);
        }
    }
    
    public void getTanks(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        PrintWriter out=response.getWriter();
        WebSite site=paramRequest.getWebPage().getWebSite();
        User user=paramRequest.getUser();
        Tank tk=null;
        Iterator<Tank> it=Tank.ClassMgr.listTankByCreator(user, site);
        if(it.hasNext())tk=it.next();        
        if(tk!=null)
        {
            out.println(tk.getId()+" "+tk.getTankType()+" "+tk.getTankColor());
            request.getSession().setAttribute("tankid", tk.getId());
        }
        
        String tankids[]=(String[])request.getSession().getAttribute("tankids");
        if(tankids!=null)
        {
            for(int x=0;x<tankids.length;x++)
            {
                Tank tank = Tank.ClassMgr.getTank(tankids[x], site);
                out.println(tank.getId()+" "+tank.getTankType()+" "+tank.getTankColor());
            }
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
    
    public void updateTankScore(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        WebSite site=paramRequest.getWebPage().getWebSite();
        User user=paramRequest.getUser();
        String score=SWBUtils.IO.readInputStream(request.getInputStream()).trim();
        System.out.println("updateScore:"+score);
        
        String tankid=(String)request.getSession().getAttribute("tankid");
        String tankids[]=(String[])request.getSession().getAttribute("tankids");
        
        System.out.println(score.length()+" "+(tankids.length+1));

        if(score.length()!=tankids.length+1)return;
        
        int maxScore=0;
        Tank win=null;
        for(int x=0;x<score.length();x++)
        {
            char c=score.charAt(x);
            Tank t=null;
            if(x==0)t=Tank.ClassMgr.getTank(tankid, site);
            else t=Tank.ClassMgr.getTank(tankids[x-1], site);
            System.out.println(t+" "+c);
            if(t!=null)
            {
                if(c=='w')
                {
                    t.setWonGames(t.getWonGames()+1);
                    win=t;
                }
                else if(c=='t')t.setTieGames(t.getTieGames()+1);
                else if(c=='l')t.setLostGames(t.getLostGames()+1);
                if(t!=win && maxScore<t.getScore())maxScore=t.getScore();
            }
        }
        if(win.getScore()<=maxScore)
        {
            double i=(maxScore-win.getScore())/5.0;
            if(i<1)i=1;
            win.setScore(win.getScore()+(int)i);
        }
        
    }
    
}
