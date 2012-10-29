/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.util;

import com.infotec.eworkplace.swb.Proyecto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.db.DBConnectionPool;
import org.semanticwb.model.WebSite;

/**
 *
 * @author carlos.ramos
 */
public class UpdateProjects {
    private static Logger log = SWBUtils.getLogger(UpdateProjects.class);
    private String update;
    private String dbConnectionPoolName;
    private WebSite wsite;
    
    public UpdateProjects(String wsiteId) throws Exception {
        wsite = WebSite.ClassMgr.getWebSite(wsiteId);
        if(wsite == null) {
            throw new Exception("WebSite with Id:"+wsiteId+" is invalid");
        }
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("proj.ProjectName ");
        query.append(",CAST(proj.[ID. Proyecto] as int) as Id_Interno ");
        query.append(",CONVERT(varchar,proj.ProjectStartDate,103) as fecha_Inicio ");
        query.append(",CONVERT(varchar,proj.ProjectFinishDate,103) as fecha_Fin ");
        query.append("FROM ProjectServer_Reporting_4.dbo.MSP_EpmProject_UserView AS proj ");
        query.append("order by proj.[ID. Proyecto] ");
        update = query.toString();
        dbConnectionPoolName = "sp";
    }
    
    public UpdateProjects(String wsiteId, String update) throws Exception {
        wsite = WebSite.ClassMgr.getWebSite(wsiteId);
        if(wsite == null) {
            throw new Exception("WebSite with Id:"+wsiteId+" is invalid");
        }
        this.update = update;
        dbConnectionPoolName = "sp";
    }
    
    public UpdateProjects(String wsiteId, String update, String dbConnectionPoolName) throws Exception {
        wsite = WebSite.ClassMgr.getWebSite(wsiteId);
        if(wsite == null) {
            throw new Exception("WebSite with Id:"+wsiteId+" is invalid");
        }
        this.update = update;
        this.dbConnectionPoolName = dbConnectionPoolName;
    }
    
    public String getUpdate() {
        return update;
    }
    
    private List<ProjectInformation> listFromProjectServer() throws Exception {
        List<ProjectInformation> proyectos = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DBConnectionPool cp = SWBUtils.DB.getPool(dbConnectionPoolName);
        if(cp==null) {
            throw new Exception("Connecton pool \"ps\" no exists. Check for connection pool \"ps\" in db.properties file");
        }
        Connection con = cp.getConnection();
        if(con==null){
            throw new Exception("Connection null. Check for connection pool \"ps\" in db.properties file");
        }
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = con.createStatement();
            if(stmt==null) {
                throw new Exception("Statement null");
            }            
            rs = stmt.executeQuery(update);
            ProjectInformation proyInfo;
            Date vigencia;
            while (rs.next()) {
                try {
                    vigencia = sdf.parse(rs.getString("fecha_Fin"));
                    proyInfo = new ProjectInformation(rs.getString("ProjectName"), rs.getString("Id_Interno"), vigencia);
                    proyectos.add(proyInfo);
                }catch(ParseException pe) {
                    log.error("La fecha de vigencia del proyecto "+rs.getString("ProjectName")+" con número "+rs.getInt("Id_Interno")+" es incorrecta", pe);
                }catch(Exception e) {
                    log.error("Actualización de proyectos desde el ProjectServer. "+e);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace(System.out);
        }
        finally
        {
            if(rs!=null)
            {
                try {
                    rs.close();                
                }catch(Exception e) {
                    e.printStackTrace(System.out);
                }
                rs = null;
            }
            if(stmt!=null)
            {
                try {
                    stmt.close();                
                }catch(Exception e) {
                    e.printStackTrace(System.out);
                }
                stmt = null;
            }
        }
        return proyectos;
    }
    
    public void update() throws Exception {
        List<ProjectInformation> proyectos = listFromProjectServer();
        
        boolean projectFound;
        List<Proyecto> semproys = SWBUtils.Collections.copyIterator(Proyecto.ClassMgr.listProyectos(wsite));
        for(ProjectInformation proyInfo : proyectos) {
            projectFound = false;
            Iterator<Proyecto> it = semproys.iterator();
            while(it.hasNext()) {
                Proyecto semproy = it.next();
                if(proyInfo.getNumero().equals(semproy.getNumeroProyecto())) {
                    semproy.setActivo(proyInfo.isActive());
                    projectFound = semproys.remove(semproy);
                    break;
                }
            }
            if(!projectFound) {
                Proyecto np = Proyecto.ClassMgr.createProyecto(wsite);
                np.setTitle(proyInfo.getTitulo());
                np.setNumeroProyecto(proyInfo.getNumero());
                np.setActivo(proyInfo.isActive());
            }
        }
    }
}
