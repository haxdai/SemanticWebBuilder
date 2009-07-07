/*
 * WBHttpServletResponseWrapper.java
 *
 * Created on 22 de marzo de 2006, 06:48 PM
 */
package org.semanticwb.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.ServletOutputStream;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class SWBHttpServletResponseWrapper extends HttpServletResponseWrapper
{

    static Logger log = SWBUtils.getLogger(SWBHttpServletResponseWrapper.class);

    ByteArrayOutputStream bout = new ByteArrayOutputStream(1024);
    ServletOutputStream sout = new SWBServletOutputStreamImp(bout);
    PrintWriter pout = null;
    private String sendRedirect = null;
    private int err = -1;
    private String errMessage = null;
    private boolean trapSendError = false;
    private boolean trapContentType = true;

    private String contentType=null;

    /** Creates a new instance of WBHttpServletResponseWrapper */
    public SWBHttpServletResponseWrapper(HttpServletResponse response)
    {
        super(response);
    }

    @Override
    public javax.servlet.ServletOutputStream getOutputStream() throws java.io.IOException
    {
        //return response.getOutputStream();
        log.debug("WBResponse:getOutputStream");
        if(pout!=null)
        {
            pout.flush();
            String dec=new String(bout.toByteArray(),SWBUtils.TEXT.CHARSET_UTF8);
            bout.reset();
            sout.write(dec.getBytes());
            pout=null;
        }
        return sout;
    }

    @Override
    public java.io.PrintWriter getWriter() throws java.io.IOException
    {
        //return response.getWriter();
        log.debug("WBResponse:getWriter");
        try
        {
            pout = new PrintWriter(new OutputStreamWriter(sout,SWBUtils.TEXT.CHARSET_UTF8));
            //pout = new PrintWriter(new OutputStreamWriter(sout));
        }catch(Exception e){log.error(e);}
        return pout;
    }

    @Override
    public void flushBuffer() throws java.io.IOException
    {
        //response.flushBuffer();
        log.debug("WBResponse:flushBuffer");
        bout.flush();
    }

    @Override
    public int getBufferSize()
    {
        //return response.getBufferSize();
        log.debug("WBResponse:getBufferSize");
        return bout.size();
    }

    @Override
    public void resetBuffer()
    {
        log.debug("WBResponse:resetBuffer");
        bout.reset();
    }

    @Override
    public void setBufferSize(int param)
    {
        log.debug("WBResponse:setBufferSize:" + param);
    //bout = new ByteArrayOutputStream(param);
    }

    @Override
    public String toString()
    {
        try
        {
            if(pout!=null)
            {
                pout.flush();
                pout.close();
            }
            bout.flush();
        } catch (Exception e)
        {
            log.error(e);
        }
        String ret="";
        try
        {
            if(pout!=null)
            {
                ret=new String(bout.toByteArray(),SWBUtils.TEXT.CHARSET_UTF8);
                //ret=SWBUtils.TEXT.decode(ret,SWBUtils.TEXT.CHARSET_UTF8);
            }else
            {
                ret=bout.toString();
            }
        }catch(Exception e){log.error(e);}
        //log.trace("WBResponse:out:" + ret);
        return ret;
    }

    public byte[] toByteArray()
    {
        try
        {
            if(pout!=null)
            {
                pout.flush();
                pout.close();
            }
            bout.flush();
        } catch (Exception e)
        {
            log.error(e);
        }
        byte arr[]=bout.toByteArray();
        try
        {
            if(pout!=null)
            {
                arr=new String(arr, SWBUtils.TEXT.CHARSET_UTF8).getBytes();
                //ret=SWBUtils.TEXT.decode(ret,SWBUtils.TEXT.CHARSET_UTF8);
            }
        }catch(Exception e){log.error(e);}

        return arr;
    }

    @Override
    public void sendRedirect(String location) throws java.io.IOException
    {
        location = location.replaceAll("&amp;", "&");
        log.debug("WBHttpServletResponseWrapper:sendRedirect");
        super.sendRedirect(location);
        sendRedirect = location;
    }

    public String getSendRedirect()
    {
        return sendRedirect;
    }

    public boolean isSendRedirect()
    {
        return sendRedirect != null;
    }

    @Override
    public void sendError(int err) throws IOException
    {
        if (trapSendError)
        {
            sendError(err, null);
        } else
        {
            super.sendError(err);
        }
    }

    @Override
    public void sendError(int err, String msg) throws IOException
    {
        if (trapSendError)
        {
            log.debug("WBHttpServletResponseWrapper:Capturing sendError");
            this.err = err;
            this.errMessage = msg;
        } else
        {
            super.sendError(err, msg);
        }

    }

    public boolean isSendError()
    {
        return err != -1;
    }

    public int getError()
    {
        return err;
    }

    public String getErrorMsg()
    {
        return errMessage;
    }

    public void setTrapSendError(boolean trapSendError)
    {
        this.trapSendError = trapSendError;
    }

    @Override
    public void setContentType(String type) 
    {
        log.debug("contentType:"+type+" trapContentType:"+trapContentType);
        contentType=type;
        if(!trapContentType)
        {
            super.setContentType(type);
        }
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setTrapContentType(boolean trapContentType)
    {
        this.trapContentType = trapContentType;
    }

    public boolean getTrapContentType()
    {
        return this.trapContentType;
    }

}
