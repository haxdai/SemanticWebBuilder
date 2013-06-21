/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import com.infotec.lodp.swb.Comment;
import com.infotec.lodp.swb.Dataset;
import com.infotec.lodp.swb.Application;
import static com.infotec.lodp.swb.resources.CommentsViewResource.log;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author Sabino
 */
public class ChartsResource extends GenericAdmResource {
    public static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
    static final int FIRST_YEAR = 1900;
    public static final String RANGO_DIAS = "Días";
    public static final String RANGO_MESES = "Meses";
    public static final String RANGO_YEARS = "Años";
    static final int HITS_TYPE_HIT = 12;
    static final int HITS_TYPE_VIEW = 11;
    static final String MODELID = "LODP";
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, 
        SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() 
                    + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        request.setAttribute("paramRequest", paramRequest);
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
    
    public HttpServletRequest graphic(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {        
        String fechaInicial = request.getParameter("startDate");
        String fechaFinal = request.getParameter("finishDate");
        String dataset = request.getParameter("dataset");
        String chartType = request.getParameter("chartType");
        String DataType = request.getParameter("dataType")==null?"views":request.getParameter("dataType");
        Date dStart = null;
        Date dFinal = null;        
        if(fechaInicial.equals("") && fechaFinal.equals("")){
            dFinal = new Date();                   
            dStart = new Date(dFinal.getTime()-(7*MILLSECS_PER_DAY));            
        }else {
            try {
                DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                dStart = fechaInicial.equals("")?new Date():sdf1.parse(fechaInicial);                
                dFinal = fechaFinal.equals("")?new Date():sdf1.parse(fechaFinal);                
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }       
        request.setAttribute("startDate", formatFecha(dStart));
        request.setAttribute("finishDate", formatFecha(dFinal));
        if(chartType != null){
            request.setAttribute("chartType",chartType);
        }        
        long dias = 1+(dFinal.getTime()-dStart.getTime())/MILLSECS_PER_DAY;
        String rango = getRango(dias,dStart,dFinal);
        request.setAttribute("rango",rango);
        request.setAttribute("dataType", DataType);
        WebPage wpage = paramRequest.getWebPage();
        WebSite wsite = wpage.getWebSite();
        Dataset datasetObj = Dataset.ClassMgr.getDataset(dataset, wsite);        
        System.out.println("Días:::"+dias);
        System.out.println("chartType:::"+chartType);
        System.out.println("dataset:::"+datasetObj.getId()+":::"+datasetObj.getDatasetTitle());
        System.out.println("DataType:::"+DataType);
        System.out.println("Rango:::"+rango);
        List<ChartData> datos = getDatos(DataType, dFinal, dStart, dias, rango, datasetObj, wsite);
        for(ChartData cd : datos){
            System.out.println("Title:"+cd.getTitle()+",Count:"+cd.getCount());
        }
        //request.setAttribute("datos", datos);
        return request;
    } 
        
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, 
    SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if("GRAPHIC".equals(mode)) {
            //request = graphic(request, response, paramRequest);                      
            doView(request, response, paramRequest);
        }else{
            super.processRequest(request, response, paramRequest);
        }        
    }
    
    public static String formatFecha(Date date){
        SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
        String fecha=null;
        if(date != null){
             fecha=  df1.format(date);
        }else{
            fecha = "No disponible";
        }
        return fecha;
    }    
    
    public static String getRango(long dias, Date dinicial, Date dfinal){
        String rango = RANGO_DIAS;
        if(dias<=31 && dinicial.getMonth()==dfinal.getMonth()){
            rango = RANGO_DIAS;
        }else if(dias<=31 && dinicial.getMonth()!=dfinal.getMonth()){
            rango = RANGO_MESES;            
        }else if(dias>31 && dinicial.getYear()==dfinal.getYear()){
            rango = RANGO_MESES;
        }else if(dias>31 && dinicial.getYear()!=dfinal.getYear()){
            rango = RANGO_YEARS;
        }
        return rango;
    }

    public static List<ChartData> getDatos(String DataType, Date dFinal, Date dStart, long dias, 
            String rango, Dataset datasetObj,WebSite wsite) {
        List<ChartData> datos = null;
        if(DataType.equals("views")){
            datos = getDatosViews(dFinal,dStart,rango,datasetObj,dias);
        }
        else if(DataType.equals("ranking")){
            datos = getDatosRanking(dFinal,dStart,rango,datasetObj,dias);
        }
        else if(DataType.equals("hits")){
            datos = getDatosHits(dFinal,dStart,rango,datasetObj,dias);
        }
        else if(DataType.equals("comments")){
            datos = getDatosComments(dFinal,dStart,rango,datasetObj,dias);
        }
        else if(DataType.equals("appl")){
            datos = getDatosAppl(dFinal,dStart,rango,datasetObj,dias,wsite);
        }
        return datos;
    }

    private static List<ChartData> getDatosViews(Date dFinal, Date dStart, String rango, Dataset datasetObj,long dias) {
        List<ChartData> datos = new ArrayList();        
        Connection con = SWBUtils.DB.getDefaultConnection();
        String qry1 = "select hits_date,hits from swb_reshits where hits_type=? "
                + "and hits_modelid=? and hits_objid=? and hits_date between ? and ?";
        String qry2 = "select sum(hits) from swb_reshits where hits_type=? "
                + "and hits_modelid=? and hits_objid=? and hits_date between ? and ?";
        if(con != null) {
            try {               
                if(rango.equals(RANGO_DIAS)){            
                    for(int i=0;i<dias;i++){
                        Date date = new Date(dStart.getTime()+(i*MILLSECS_PER_DAY));
                        datos.add(new ChartData(String.valueOf(date.getDate()) ,0,date));                        
                    } 
                    if(datasetObj!=null){
                        PreparedStatement st = con.prepareStatement(qry1.toString());
                        st.setInt(1, HITS_TYPE_VIEW);
                        st.setString(2, MODELID);
                        st.setString(3, datasetObj.getShortURI());
                        Timestamp tsmp1 = new Timestamp(dStart.getTime());
                        st.setTimestamp(4, tsmp1);  
                        Timestamp tsmp2 = new Timestamp(dFinal.getTime());
                        st.setTimestamp(5, tsmp2);
                        ResultSet rs = st.executeQuery();                    
                        long count = 0;
                        Timestamp tsmp3 = null;
                        while(rs.next()) {
                            tsmp3 = rs.getTimestamp(1);
                            count = rs.getInt(2);
                            Date date = new Date(tsmp3.getTime());
                            for(ChartData cd: datos){
                                if(formatFecha(cd.getStartDate()).equals(formatFecha(date))){                                
                                    cd.setCount(count);
                                }
                            }                      
                        }
                    }    
                }                
                else if(rango.equals(RANGO_MESES)){
                    int mesFinal = dFinal.getMonth();
                    int añoFinal = dFinal.getYear()+FIRST_YEAR;
                    Date rangoInicial = dStart;                    
                    Calendar pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate());                    
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));                    
                    Date rangoFinal = pCal.getTime();
                    boolean sigue = true;
                    while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal && rangoInicial.getMonth() <= mesFinal){
                        long count = 0; 
                        if(datasetObj!=null){
                            PreparedStatement st = con.prepareStatement(qry2.toString());
                            st.setInt(1, HITS_TYPE_VIEW);
                            st.setString(2, MODELID);
                            st.setString(3, datasetObj.getShortURI());
                            Timestamp tsmp1 = new Timestamp(rangoInicial.getTime());
                            st.setTimestamp(4, tsmp1);  
                            Timestamp tsmp2 = new Timestamp(rangoFinal.getTime());
                            st.setTimestamp(5, tsmp2);
                            ResultSet rs = st.executeQuery();                        
                            if(rs.next()){
                                count = rs.getInt(1);                            
                            }
                        }
                        SimpleDateFormat  sdf = new SimpleDateFormat("MMM");
                        String mes = sdf.format(rangoInicial).toUpperCase();
                        datos.add(new ChartData(mes ,count));
                        if(!sigue){ break;}
                        rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);                        
                        if(rangoInicial.getYear()+FIRST_YEAR==añoFinal && rangoInicial.getMonth() ==mesFinal){
                            rangoFinal = dFinal;
                            sigue = false;
                        }
                        else{
                            pCal= GregorianCalendar.getInstance();
                            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate()); 
                            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                            rangoFinal = pCal.getTime();
                        }                       
                    }
                }                    
                else if(rango.equals(RANGO_YEARS)){
                    int añoFinal = dFinal.getYear()+FIRST_YEAR;
                    Date rangoInicial = dStart;
                    Calendar pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                    
                    Date rangoFinal = pCal.getTime();
                    boolean sigue = true;
                    while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal){                        
                        String label = String.valueOf(rangoInicial.getYear()+FIRST_YEAR);                        
                        long count = 0;
                        if(datasetObj!=null){
                            PreparedStatement st = con.prepareStatement(qry2.toString());
                            st.setInt(1, HITS_TYPE_VIEW);
                            st.setString(2, MODELID);
                            st.setString(3, datasetObj.getShortURI());
                            Timestamp tsmp1 = new Timestamp(rangoInicial.getTime());
                            st.setTimestamp(4, tsmp1);  
                            Timestamp tsmp2 = new Timestamp(rangoFinal.getTime());
                            st.setTimestamp(5, tsmp2);
                            ResultSet rs = st.executeQuery();                       
                            if(rs.next()){
                                count = rs.getInt(1);                            
                            }
                        }
                        datos.add(new ChartData( label,count));
                        if(!sigue){ break;}
                        rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);
                        if(rangoInicial.getYear()+FIRST_YEAR==añoFinal){
                            rangoFinal = dFinal;
                            sigue = false;
                        } 
                         else{
                            pCal= GregorianCalendar.getInstance();
                            pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                             
                            rangoFinal = pCal.getTime();
                        }
                    }
                }   
            }catch (Exception e) {
                log.error("Error DBResHits_getResHitsLog_getLogError", e);
            }finally {
                try {
                    if(con!=null){ con.close();}
                }catch(SQLException e) {
                }
            }
        }
        return datos;
    }

    private static List getDatosRanking(Date dFinal, Date dStart, String rango, Dataset datasetObj,long dias) {
        List<ChartData> datos = new ArrayList(); 
        /*List<Comment> listComment =null;
        if(datasetObj!=null){
            Iterator<Comment> itListComments = datasetObj.listComments();
            listComment = new ArrayList();
            while(itListComments.hasNext()){
                Comment comment = itListComments.next();
                listComment.add(comment);
            }
        }*/
         
        if(rango.equals(RANGO_DIAS)){
            for(int i=0;i<dias;i++){
                Date date = new Date(dStart.getTime()+(i*MILLSECS_PER_DAY));
                datos.add(new ChartData(String.valueOf(date.getDate()),0,date));
            } 
            /*if(listComment!=null){
                for(Comment comment: listComment){
                    if(comment.isApproved()){
                        if(comment.getCreated().getTime() >= dStart.getTime() && comment.getCreated().getTime() <= dFinal.getTime() ){
                            for(ChartData cd: datos){
                                if(formatFecha(comment.getCreated()).equals(cd.getTitle())){
                                    cd.setCount(cd.getCount()+1);
                                    break;
                                }
                            }
                        }
                    }
                }
            }*/
        }                
        else if(rango.equals(RANGO_MESES)){            
            int mesFinal = dFinal.getMonth();
            int añoFinal = dFinal.getYear()+FIRST_YEAR;
            Date rangoInicial = dStart;                    
            Calendar pCal= GregorianCalendar.getInstance();
            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate());                    
            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));                    
            Date rangoFinal = pCal.getTime();
            boolean sigue = true;
            while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal && rangoInicial.getMonth() <= mesFinal){
                long count = 0;
                /*if(listComment!=null){
                    for(Comment comment: listComment){
                        if(comment.isApproved()){
                            if(comment.getCreated().getTime() >= rangoInicial.getTime() && 
                                comment.getCreated().getTime() <= rangoFinal.getTime() ){
                                count++;
                            }
                        }
                    }    
                }*/
                SimpleDateFormat  sdf = new SimpleDateFormat("MMM");
                String mes = sdf.format(rangoInicial).toUpperCase();
                datos.add(new ChartData(mes ,count));
                if(!sigue){ break;}
                rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);                        
                if(rangoInicial.getYear()+FIRST_YEAR==añoFinal && rangoInicial.getMonth() ==mesFinal){
                    rangoFinal = dFinal;
                    sigue = false;
                }
                else{
                    pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate()); 
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    rangoFinal = pCal.getTime();
                } 
            }
        }
        else if(rango.equals(RANGO_YEARS)){
            int añoFinal = dFinal.getYear()+FIRST_YEAR;
            Date rangoInicial = dStart;
            Calendar pCal= GregorianCalendar.getInstance();
            pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                    
            Date rangoFinal = pCal.getTime();
            boolean sigue = true;
            while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal){
                String label = String.valueOf(rangoInicial.getYear()+FIRST_YEAR);
                long count = 0;
                /*if(listComment!=null){
                    for(Comment comment: listComment){
                        if(comment.isApproved()){
                            if(comment.getCreated().getTime() >= rangoInicial.getTime() && 
                                comment.getCreated().getTime() <= rangoFinal.getTime() ){
                                count++;
                            }
                        }
                    }
                } */   
                datos.add(new ChartData( label,count));
                if(!sigue){ break;}
                rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);
                if(rangoInicial.getYear()+FIRST_YEAR==añoFinal){
                    rangoFinal = dFinal;
                    sigue = false;
                } 
                 else{
                    pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                             
                    rangoFinal = pCal.getTime();
                }
            }
        }
        
        return datos;
    }

    private static List<ChartData> getDatosHits(Date dFinal, Date dStart, String rango, 
            Dataset datasetObj,long dias) {
        List<ChartData> datos = new ArrayList();        
        Connection con = SWBUtils.DB.getDefaultConnection();
        String qry1 = "select hits_date,hits from swb_reshits where hits_type=? "
                + "and hits_modelid=? and hits_objid=? and hits_date between ? and ?";
        String qry2 = "select sum(hits) from swb_reshits where hits_type=? "
                + "and hits_modelid=? and hits_objid=? and hits_date between ? and ?";
        if(con != null) {
            try {               
                if(rango.equals(RANGO_DIAS)){            
                    for(int i=0;i<dias;i++){
                        Date date = new Date(dStart.getTime()+(i*MILLSECS_PER_DAY));
                        datos.add(new ChartData(String.valueOf(date.getDate()),0,date));
                    }                    
                    if(datasetObj!=null){
                        PreparedStatement st = con.prepareStatement(qry1.toString());
                        st.setInt(1, HITS_TYPE_HIT);
                        st.setString(2, MODELID);
                        st.setString(3, datasetObj.getShortURI());
                        Timestamp tsmp1 = new Timestamp(dStart.getTime());
                        st.setTimestamp(4, tsmp1);  
                        Timestamp tsmp2 = new Timestamp(dFinal.getTime());
                        st.setTimestamp(5, tsmp2);
                        ResultSet rs = st.executeQuery();                    
                        long count = 0;
                        Timestamp tsmp3 = null;
                        while(rs.next()) {
                            tsmp3 = rs.getTimestamp(1);
                            count = rs.getInt(2);
                            Date date = new Date(tsmp3.getTime());
                            for(ChartData cd: datos){
                                if(formatFecha(cd.getStartDate()).equals(formatFecha(date))){                                
                                    cd.setCount(count);
                                }
                            }                      
                        }
                    }                     
                }                
                else if(rango.equals(RANGO_MESES)){
                    int mesFinal = dFinal.getMonth();
                    int añoFinal = dFinal.getYear()+FIRST_YEAR;
                    Date rangoInicial = dStart;                    
                    Calendar pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate());                    
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));                    
                    Date rangoFinal = pCal.getTime();
                    boolean sigue = true;
                    while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal && rangoInicial.getMonth() <= mesFinal){
                        long count = 0;
                        if(datasetObj!=null){
                            PreparedStatement st = con.prepareStatement(qry2.toString());
                            st.setInt(1, HITS_TYPE_HIT);
                            st.setString(2, MODELID);
                            st.setString(3, datasetObj.getShortURI());
                            Timestamp tsmp1 = new Timestamp(rangoInicial.getTime());
                            st.setTimestamp(4, tsmp1);  
                            Timestamp tsmp2 = new Timestamp(rangoFinal.getTime());
                            st.setTimestamp(5, tsmp2);
                            ResultSet rs = st.executeQuery();
                            if(rs.next()){
                                count = rs.getInt(1);                            
                            }
                        }
                        SimpleDateFormat  sdf = new SimpleDateFormat("MMM");
                        String mes = sdf.format(rangoInicial).toUpperCase();
                        datos.add(new ChartData(mes ,count));
                        if(!sigue){ break;}
                        rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);                        
                        if(rangoInicial.getYear()+FIRST_YEAR==añoFinal && rangoInicial.getMonth() ==mesFinal){
                            rangoFinal = dFinal;
                            sigue = false;
                        }
                        else{
                            pCal= GregorianCalendar.getInstance();
                            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate()); 
                            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                            rangoFinal = pCal.getTime();
                        } 
                    }
                }                    
                else if(rango.equals(RANGO_YEARS)){
                    int añoFinal = dFinal.getYear()+FIRST_YEAR;
                    Date rangoInicial = dStart;
                    Calendar pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                    
                    Date rangoFinal = pCal.getTime();
                    boolean sigue = true;
                    while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal){                        
                        String label = String.valueOf(rangoInicial.getYear()+FIRST_YEAR);
                        long count = 0;
                        if(datasetObj!=null){
                            PreparedStatement st = con.prepareStatement(qry2.toString());
                            st.setInt(1, HITS_TYPE_HIT);
                            st.setString(2, MODELID);
                            st.setString(3, datasetObj.getShortURI());
                            Timestamp tsmp1 = new Timestamp(rangoInicial.getTime());
                            st.setTimestamp(4, tsmp1);  
                            Timestamp tsmp2 = new Timestamp(rangoFinal.getTime());
                            st.setTimestamp(5, tsmp2);
                            ResultSet rs = st.executeQuery();
                            if(rs.next()){
                                count = rs.getInt(1);                            
                            }
                        }
                        datos.add(new ChartData( label,count));
                        if(!sigue){ break;}
                        rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);
                        if(rangoInicial.getYear()+FIRST_YEAR==añoFinal){
                            rangoFinal = dFinal;
                            sigue = false;
                        } 
                         else{
                            pCal= GregorianCalendar.getInstance();
                            pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                             
                            rangoFinal = pCal.getTime();
                        }
                    }
                }  
            }catch (Exception e) {
                log.error("Error DBResHits_getResHitsLog_getLogError", e);
            }finally {
                try {
                    if(con!=null){ con.close();}
                }catch(SQLException e) {
                }
            }
        }
        return datos;
    }

    private static List<ChartData> getDatosComments(Date dFinal, Date dStart, String rango, 
            Dataset datasetObj, long dias) {
        List<ChartData> datos = new ArrayList(); 
        List<Comment> listComment =null;
        if(datasetObj!=null){
            Iterator<Comment> itListComments = datasetObj.listComments();
            listComment = new ArrayList();
            while(itListComments.hasNext()){
                Comment comment = itListComments.next();
                listComment.add(comment);
            }
        }
         
        if(rango.equals(RANGO_DIAS)){
            for(int i=0;i<dias;i++){
                Date date = new Date(dStart.getTime()+(i*MILLSECS_PER_DAY));
                datos.add(new ChartData(String.valueOf(date.getDate()),0,date));
            } 
            if(listComment!=null){
                for(Comment comment: listComment){
                    if(comment.isApproved()){
                        if(comment.getCreated().getTime() >= dStart.getTime() && comment.getCreated().getTime() <= dFinal.getTime() ){
                            for(ChartData cd: datos){
                                if(formatFecha(comment.getCreated()).equals(formatFecha(cd.getStartDate()))){
                                    cd.setCount(cd.getCount()+1);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }                
        else if(rango.equals(RANGO_MESES)){            
            int mesFinal = dFinal.getMonth();
            int añoFinal = dFinal.getYear()+FIRST_YEAR;
            Date rangoInicial = dStart;                    
            Calendar pCal= GregorianCalendar.getInstance();
            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate());                    
            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));                    
            Date rangoFinal = pCal.getTime();
            boolean sigue = true;
            while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal && rangoInicial.getMonth() <= mesFinal){
                long count = 0;
                if(listComment!=null){
                    for(Comment comment: listComment){
                        if(comment.isApproved()){
                            if(comment.getCreated().getTime() >= rangoInicial.getTime() && 
                                comment.getCreated().getTime() <= rangoFinal.getTime() ){
                                count++;
                            }
                        }
                    }    
                }
                SimpleDateFormat  sdf = new SimpleDateFormat("MMM");
                String mes = sdf.format(rangoInicial).toUpperCase();
                datos.add(new ChartData(mes ,count));
                if(!sigue){ break;}
                rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);                        
                if(rangoInicial.getYear()+FIRST_YEAR==añoFinal && rangoInicial.getMonth() ==mesFinal){
                    rangoFinal = dFinal;
                    sigue = false;
                }
                else{
                    pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate()); 
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    rangoFinal = pCal.getTime();
                } 
            }
        }
        else if(rango.equals(RANGO_YEARS)){
            int añoFinal = dFinal.getYear()+FIRST_YEAR;
            Date rangoInicial = dStart;
            Calendar pCal= GregorianCalendar.getInstance();
            pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                    
            Date rangoFinal = pCal.getTime();
            boolean sigue = true;
            while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal){
                String label = String.valueOf(rangoInicial.getYear()+FIRST_YEAR);
                long count = 0;
                if(listComment!=null){
                    for(Comment comment: listComment){
                        if(comment.isApproved()){
                            if(comment.getCreated().getTime() >= rangoInicial.getTime() && 
                                comment.getCreated().getTime() <= rangoFinal.getTime() ){
                                count++;
                            }
                        }
                    }
                }    
                datos.add(new ChartData( label,count));
                if(!sigue){ break;}
                rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);
                if(rangoInicial.getYear()+FIRST_YEAR==añoFinal){
                    rangoFinal = dFinal;
                    sigue = false;
                } 
                 else{
                    pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                             
                    rangoFinal = pCal.getTime();
                }
            }
        }
        
        return datos;
    }

    private static List<ChartData> getDatosAppl(Date dFinal, Date dStart, String rango, 
            Dataset datasetObj, long dias, WebSite wsite) {
        List<ChartData> datos = new ArrayList(); 
        List<Application> listAppls = null;         
        if(datasetObj!=null){
            Iterator<Application> itListAppl = Application.ClassMgr.listApplicationByRelatedDataset(datasetObj, wsite); 
            listAppls = new ArrayList();
            while(itListAppl.hasNext()){
                Application appl = itListAppl.next();
                listAppls.add(appl);
            }
        }
        if(rango.equals(RANGO_DIAS)){
            for(int i=0;i<dias;i++){
                Date date = new Date(dStart.getTime()+(i*MILLSECS_PER_DAY));
                datos.add(new ChartData(String.valueOf(date.getDate()),0,date));
            } 
            if(listAppls==null){
                for(Application appl: listAppls){
                    if(appl.isAppValid()){
                        if(appl.getAppCreated().getTime() >= dStart.getTime() && appl.getAppCreated().getTime() <= dFinal.getTime() ){
                            for(ChartData cd: datos){
                                if(formatFecha(appl.getAppCreated()).equals(formatFecha(cd.getStartDate()))){
                                    cd.setCount(cd.getCount()+1);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }                
        else if(rango.equals(RANGO_MESES)){
            int mesFinal = dFinal.getMonth();
            int añoFinal = dFinal.getYear()+FIRST_YEAR;
            Date rangoInicial = dStart;                    
            Calendar pCal= GregorianCalendar.getInstance();
            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate());                    
            pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));                    
            Date rangoFinal = pCal.getTime();
            boolean sigue = true;
            while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal && rangoInicial.getMonth() <= mesFinal){
                long count = 0;
                if(listAppls==null){
                    for(Application appl: listAppls){
                        if(appl.isAppValid()){
                            if(appl.getAppCreated().getTime() >= rangoInicial.getTime() && 
                                appl.getAppCreated().getTime() <= rangoFinal.getTime() ){
                                count++;
                            }
                        }
                    }
                }
                SimpleDateFormat  sdf = new SimpleDateFormat("MMM");
                String mes = sdf.format(rangoInicial).toUpperCase();
                datos.add(new ChartData(mes ,count));
                if(!sigue){ break;}
                rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);                        
                if(rangoInicial.getYear()+FIRST_YEAR==añoFinal && rangoInicial.getMonth() ==mesFinal){
                    rangoFinal = dFinal;
                    sigue = false;
                }
                else{
                    pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), rangoInicial.getDate()); 
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, rangoInicial.getMonth(), pCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    rangoFinal = pCal.getTime();
                } 
            }
        }
        else if(rango.equals(RANGO_YEARS)){
            int añoFinal = dFinal.getYear()+FIRST_YEAR;
            Date rangoInicial = dStart;
            Calendar pCal= GregorianCalendar.getInstance();
            pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                    
            Date rangoFinal = pCal.getTime();
            boolean sigue = true;
            while(rangoInicial.getYear()+FIRST_YEAR <= añoFinal){
                String label = String.valueOf(rangoInicial.getYear()+FIRST_YEAR);
                long count = 0;
                if(listAppls==null){
                    for(Application appl: listAppls){
                        if(appl.isAppValid()){
                            if(appl.getAppCreated().getTime() >= rangoInicial.getTime() && 
                                appl.getAppCreated().getTime() <= rangoFinal.getTime() ){
                                count++;
                            }
                        }
                    }
                }
                datos.add(new ChartData( label,count));
                if(!sigue){ break;}
                rangoInicial = new Date(rangoFinal.getTime()+MILLSECS_PER_DAY);
                if(rangoInicial.getYear()+FIRST_YEAR==añoFinal){
                    rangoFinal = dFinal;
                    sigue = false;
                } 
                 else{
                    pCal= GregorianCalendar.getInstance();
                    pCal.set(rangoInicial.getYear()+FIRST_YEAR, 12, 31);                             
                    rangoFinal = pCal.getTime();
                }
            }
        }        
        return datos;        
    }
}