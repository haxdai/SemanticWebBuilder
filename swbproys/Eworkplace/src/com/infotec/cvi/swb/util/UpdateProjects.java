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
import java.util.List;
import java.util.Date;
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
        this(wsiteId, null, null);
    }
    
    public UpdateProjects(String wsiteId, String update) throws Exception {
        this(wsiteId, update, null);
    }
    
    public UpdateProjects(String wsiteId, String update, String dbConnectionPoolName) throws Exception {
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
        this.update = update==null?query.toString():update;
        this.dbConnectionPoolName = dbConnectionPoolName==null?"ps":dbConnectionPoolName;
    }
    
    public String getUpdate() {
        return update;
    }
    
    private List<ProjectInformation> listFromProjectServer() throws Exception {
        List<ProjectInformation> proyectos = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DBConnectionPool cp = SWBUtils.DB.getPool(dbConnectionPoolName);
        if(cp==null) {
            throw new Exception("Connecton pool \""+dbConnectionPoolName+"\" no exists. Check for connection pool \""+dbConnectionPoolName+"\" in db.properties file");
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
System.out.println("\n\n----------\nUpdating...");
        List<ProjectInformation> projInfos = listFromProjectServer();
        
        int idx;
        List<Proyecto> semproys = SWBUtils.Collections.copyIterator(Proyecto.ClassMgr.listProyectos(wsite));
        for(ProjectInformation projInfo : projInfos) {
System.out.println("\n+++\nproyInfo="+projInfo.toString());
            idx = semproys.indexOf(projInfo);
System.out.println("Proyecto con indice="+idx);
            if(idx >= 0)
            {
System.out.println("actualizando proyecto...");
                Proyecto proyecto = semproys.remove(idx);
                proyecto.setActive(projInfo.isActive());
System.out.println("proyecto "+proyecto.getTitle()+" actualizado.");
            }
            else
            {
System.out.println("proyecto no encontrado. creando nuevo...");
                Proyecto nuevo = Proyecto.ClassMgr.createProyecto(wsite);
                nuevo.setTitle(projInfo.getTitulo());
                nuevo.setNumeroProyecto(projInfo.getNumero());
                nuevo.setActive(projInfo.isActive());
System.out.println("proeycto creado.");
            }
        }
    }
}
