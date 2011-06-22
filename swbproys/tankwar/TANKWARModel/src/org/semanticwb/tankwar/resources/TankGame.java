/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.tankwar.resources;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

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
        out.println("<applet codebase=\"/work/models/TankWar/app\" archive=\"TankWarApplet.jar,lib/syntax.jar\" code=\"com/infotec/games/infotank/TankGame.class\" width=\"800\" height=\"600\">");        
        out.println("<param name=\"jsess\" value=\"" + request.getSession().getId() + "\">");
        out.println("<param name=\"gtw\" value=\"" + paramRequest.getRenderUrl().setMode("tks") + "\">");
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
        }else
        {
            super.processRequest(request, response, paramRequest);
        }
    }
    
    public void getTanks(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        PrintWriter out=response.getWriter();
        out.println("DemoTank 0 0");
        out.println("JeiTank 3 2");
        out.println("SleepyTank 1 1");
        out.println("JeiTank 2 3");
        out.println("DemoTank 3 4");
        out.println("DemoTank 0 5");
    }
    
    public void getTank(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        
    }
    
}
