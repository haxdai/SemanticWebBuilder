/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.tankwar.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBModel;
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
public class TankGameView extends GenericResource
{

    private Random ran=new Random();
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        User user=paramRequest.getUser();
        WebSite site=paramRequest.getWebPage().getWebSite();
        String tankids[]=request.getParameterValues("tankID");
        if(tankids==null)
        {
            request.getSession().setAttribute("tkpre", false);
            tankids=getTanks(site, user);
        }else
        {
            request.getSession().setAttribute("tkpre", true);
        }
        request.getSession().setAttribute("tankids", tankids);
        //System.out.println(tankids);
        PrintWriter out=response.getWriter();
        out.println("<applet codebase=\"/work/models/TankWar/app\" archive=\"TankWarApplet.jar\" code=\"com/infotec/games/infotank/TankGameView.class\" width=\"800\" height=\"600\">");        
        //out.println("<param name=\"jsess\" value=\"" + request.getSession().getId() + "\">");
        String sessid=request.getSession().getId();
        String pwd=sessid.substring(0,10);
        String jsps=SWBUtils.CryptoWrapper.byteArrayToHexString(pwd.getBytes())+encript(pwd, sessid);
        out.println("<param name=\"jsps\" value=\"" + jsps + "\">");
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
        String sessid=request.getSession().getId();
        String pwd=sessid.substring(0,10);         
        PrintWriter out=response.getWriter();
        StringBuffer ret=new StringBuffer();        
        WebSite site=paramRequest.getWebPage().getWebSite();
        User user=paramRequest.getUser();
        Tank tk=null;
        if(user.isSigned())
        {
            Iterator<Tank> it=Tank.ClassMgr.listTankByCreator(user, site);
            if(it.hasNext())tk=it.next();        
        }
        if(tk!=null)
        {
            ret.append(tk.getId()+" "+tk.getTankType()+" "+tk.getTankColor()+"\n");
            request.getSession().setAttribute("tankid", tk.getId());
        }
        
        String tankids[]=(String[])request.getSession().getAttribute("tankids");
        if(tankids!=null)
        {
            for(int x=0;x<tankids.length;x++)
            {
                Tank tank = Tank.ClassMgr.getTank(tankids[x], site);
                ret.append(tank.getId()+" "+tank.getTankType()+" "+tank.getTankColor()+"\n");
            }
        }
        out.print(encript(pwd, ret.toString()));        
    }
    
    public void getTank(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        String sessid=request.getSession().getId();
        String pwd=sessid.substring(0,10);         
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
        //out.println(code);
        out.print(encript(pwd, code));        
        
    }
    
    public void saveTank(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        String sessid=request.getSession().getId();
        String pwd=sessid.substring(0,10);         
        WebSite site=paramRequest.getWebPage().getWebSite();
        User user=paramRequest.getUser();
        Tank tk=null;
        Iterator<Tank> it=Tank.ClassMgr.listTankByCreator(user, site);
        if(it.hasNext())tk=it.next();

        if(tk!=null)
        {
            String code=SWBUtils.IO.readInputStream(request.getInputStream());
            code=decript(pwd, code);
            tk.setTankCode(code);
            //System.out.println("code:"+code);
        } 
    }    
    
    private String[] getTanks(SWBModel site, User user)
    {
        int m=6;
        if(user.isSigned())m=5;
        System.out.println(m+" "+user+" "+user.isSigned());
        String tankids[]= new String[m];
        Iterator<Tank> it=Tank.ClassMgr.listTanks(site);
        List<Tank> l=SWBUtils.Collections.copyIterator(it);

        if(user.isSigned())
        {
            Iterator<Tank> it2=Tank.ClassMgr.listTankByCreator(user, site);
            if(it.hasNext())
            {
                Tank tk=it2.next();
                l.remove(tk);
            }
        }

        for(int x=0;x<m && l.size()>0;x++)
        {
            int r=ran.nextInt(l.size());
            tankids[x]=l.get(r).getId();
            l.remove(r);
        }
        
        return tankids;
        
    }
    
    public void updateTankScore(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        String sessid=request.getSession().getId();
        String pwd=sessid.substring(0,10);         
        WebSite site=paramRequest.getWebPage().getWebSite();
        User user=paramRequest.getUser();
        String score=SWBUtils.IO.readInputStream(request.getInputStream()).trim();
        score=decript(pwd, score);
        
        System.out.println("updateScore:"+score);
        
        String tankid=(String)request.getSession().getAttribute("tankid");
        String tankids[]=(String[])request.getSession().getAttribute("tankids");
        
        if(tankid!=null)
        {
            String aux[]=new String[tankids.length+1];
            aux[0]=tankid;
            for(int x=0;x<tankids.length;x++)
            {
                aux[x+1]=tankids[x];
            }
            tankids=aux;
        }
        
        System.out.println(score.length()+" "+(tankids.length));

        if(score==null || score.length()!=tankids.length)return;
        
        site.begin();
        int maxScore=0;
        Tank win=null;
        for(int x=0;x<score.length();x++)
        {
            char c=score.charAt(x);
            Tank t=Tank.ClassMgr.getTank(tankids[x], site);
            //System.out.println(t+" "+c);
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
        if(win!=null && win.getScore()<=maxScore)
        {
            if(win.getScore()<maxScore)
            {
                double i=(maxScore-win.getScore())/5.0;
                if(i<1)i=1;
                win.setScore(win.getScore()+(int)i);
            }else
            {
                int maxs=0;
                Iterator <Tank> it=Tank.ClassMgr.listTanks();
                while (it.hasNext()) {
                    Tank tk = it.next();
                    if(tk.getScore()>maxs)
                    {
                        maxs=tk.getScore();
                    }
                }
                if(maxs==win.getScore())
                {
                    win.setScore(win.getScore()+1);
                }
            }
        }
        site.commit();
        
        if(!((Boolean)request.getSession().getAttribute("tkpre")))
        {
            tankids=getTanks(site, user);
            request.getSession().setAttribute("tankids", tankids);        
        }
    }
    
    
    private String encript(String key, String data)
    {
        try
        {
            return SWBUtils.CryptoWrapper.byteArrayToHexString(SWBUtils.CryptoWrapper.PBEAES128Cipher(key, data.getBytes()));
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    
    private String decript(String key, String data)
    {
        try
        {
            return new String(SWBUtils.CryptoWrapper.PBEAES128Decipher(key, SWBUtils.CryptoWrapper.hexStringToByteArray(data)));
        }catch(Exception e){e.printStackTrace();}
        return null;
    }    
    
}
