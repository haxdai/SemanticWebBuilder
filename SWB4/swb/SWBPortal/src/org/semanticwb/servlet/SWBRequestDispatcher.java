/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author javiersolis
 */
public class SWBRequestDispatcher implements javax.servlet.RequestDispatcher
{
    private String path=null;
    
    public SWBRequestDispatcher(String path)
    {
        this.path=path;
    }

    @Override
    public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("forward:"+path+"->"+request+"-->"+response);
    }

    @Override
    public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        System.out.println("include:"+path+"->"+request+"-->"+response);    
    }
    
}
