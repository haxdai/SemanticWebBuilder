/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.portal.community.utilresources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.portal.community.MicroSite;

/**
 *
 * @author juan.fernandez
 */
public class CommunityActivityUtil {
    private Logger log = SWBUtils.getLogger(CommunityActivityUtil.class);

    public CommunityActivityUtil(){}
    
    public Iterator<CommunityActivity> getCommunityActivities(MicroSite community)
    {
        ArrayList al = new ArrayList();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

            conn = SWBUtils.DB.getDefaultConnection("MicroSiteWebPageUtil.getComminityActivities");
            pst = conn.prepareStatement("select commuri,usruri,elementuri,modified from swb_commlog where commuri = ? order by modified desc");
            pst.setString(1,community.getURI());
            rs = pst.executeQuery();
            while(rs.next())
            {
                String commURI = rs.getString("commuri");
                String usrURI = rs.getString("usruri");
                String elementURI = rs.getString("elementuri");
                Timestamp modified = rs.getTimestamp("modified");
                al.add(new CommunityActivity(commURI, usrURI, elementURI, modified));
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
            log.error("Error al traer las actividades de la comunidad.",e);
        } finally
        {
            try { rs.close(); } catch (Exception e) { }
            try { pst.close(); } catch (Exception e) { }
            try { conn.close(); } catch (Exception e) { }
        }
        return al.iterator();
    }

    public Iterator<CommunityActivity> getMemberActivities(User user)
    {
        ArrayList al = new ArrayList();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        if(user!=null)
        {
            try {
            conn = SWBUtils.DB.getDefaultConnection("MicroSiteWebPageUtil.getMemberActivities");
            pst = conn.prepareStatement("select commuri,usruri,elementuri,modified from swb_commlog where usruri = ? order by modified desc");
            pst.setString(1,user.getURI());
            rs=pst.executeQuery();
            while(rs.next())
            {
                String commURI = rs.getString("commuri");
                String usrURI = rs.getString("usruri");
                String elementURI = rs.getString("elementuri");
                Timestamp modified = rs.getTimestamp("modified");
                al.add(new CommunityActivity(commURI, usrURI, elementURI,modified));
            }
            rs.close();
            pst.close();
            conn.close();
            } catch (Exception e) {
                log.error("Error al traer las actividades del miembro en la comunidad.",e);
            } finally {
                try { rs.close(); } catch (Exception e) { }
                try { pst.close(); } catch (Exception e) { }
                try { conn.close(); } catch (Exception e) { }
            }
        }
        return al.iterator();

    }

}
