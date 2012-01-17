/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.triplestore;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.graph.TripleMatch;
import com.hp.hpl.jena.graph.impl.GraphBase;
import com.hp.hpl.jena.shared.PrefixMapping;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import org.semanticwb.Logger;
import org.semanticwb.SWBRuntimeException;
import org.semanticwb.SWBUtils;
import org.semanticwb.remotetriplestore.RGraph;

/**
 *
 * @author jei
 */
public class SWBTSGraph extends GraphBase implements RGraph
{
    private static Logger log = SWBUtils.getLogger(SWBTSGraph.class);

    private String name;
    private int id;

    private PrefixMapping pmap;
    //private BigdataTransactionHandler trans;


    public SWBTSGraph(int id, String name)
    {
        this.id=id;
        this.name=name;
        pmap=new SWBTSPrefixMapping(this);
    }

    @Override
    protected ExtendedIterator<Triple> graphBaseFind(TripleMatch tm)
    {
        return new SWBTSIterator(this, tm);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void performAdd(Triple t)
    {
        performAdd(t,null);
    }    

    public void performAdd(Triple t, Long id)
    {
        try
        {
            Connection con = SWBUtils.DB.getDefaultConnection();
            PreparedStatement ps = null;

            String subj=SWBTSUtil.node2String(t.getSubject());
            String hsubj=SWBTSUtil.getHashText(subj);
            String prop=SWBTSUtil.node2String(t.getPredicate());
            String hprop=SWBTSUtil.getHashText(prop);
            String obj=SWBTSUtil.node2String(t.getObject());
            String hobj=SWBTSUtil.getHashText(obj);
            
            //if(subj==null || prop==null || obj==null)return;

            String sext="";
            if(hsubj!=null)
            {
                sext+="|subj|"+subj.length()+"|"+subj;
                subj="lgs|"+hsubj;
            }
            if(hprop!=null)
            {
                sext+="|prop|"+prop.length()+"|"+prop;
                prop="lgp|"+hprop;
            }
            if(hobj!=null)
            {
                sext+="|obj|"+obj.length()+"|"+obj;
                obj="lgo|"+hobj;
            }
            
            //System.out.println("performAdd:"+subj+" "+prop+" "+obj);
            //new Exception().printStackTrace();

            if(sext.length()==0)
            {
                ps=con.prepareStatement("INSERT INTO swb_graph_ts"+getId()+" (subj, prop, obj, timems) VALUES (?, ?, ?, ?)");
            }else
            {
                ps=con.prepareStatement("INSERT INTO swb_graph_ts"+getId()+" (subj, prop, obj, timems, ext) VALUES (?, ?, ?, ?, ?)");
            }

            ps.setString(1, subj);
            ps.setString(2, prop);
            ps.setString(3, obj);
            ps.setLong(4, System.currentTimeMillis());
            if(sext.length()>0)
            {
                ps.setAsciiStream(5, SWBUtils.IO.getStreamFromString(sext), sext.length());
            }

            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e2)
        {
            log.error(e2);
            throw new SWBRuntimeException(e2.getMessage(), e2);
        }
    }

    @Override
    public void performDelete(Triple t)
    {
        performDelete(t,null);
    }    

    public void performDelete(Triple t, Long id)
    {
        try
        {
            Connection con = SWBUtils.DB.getDefaultConnection();
            
            String subj=SWBTSUtil.node2HashString(t.getMatchSubject(),"lgs");
            String prop=SWBTSUtil.node2HashString(t.getMatchPredicate(),"lgp");
            String obj=SWBTSUtil.node2HashString(t.getMatchObject(),"lgo");

            //System.out.println("performDelete:"+subj+" "+prop+" "+obj);
            
            String query="delete from swb_graph_ts"+getId();
            String query2="";
            if(subj!=null)query2+=" subj=?";
            if(prop!=null)
            {
                if(query2.length()>0)query2 +=" and";
                query2 += " prop=?";
            }
            if(obj!=null)
            {
                if(query2.length()>0)query2 +=" and";
                query2 += " obj=?";
            }

            if(query2.length()>0)query+=" where"+query2;

            PreparedStatement ps=con.prepareStatement(query);
            int i=1;
            if(subj!=null)ps.setString(i++, subj);
            if(prop!=null)ps.setString(i++, prop);
            if(obj!=null)ps.setString(i++, obj);
            ps.executeUpdate();            
            ps.close();
            con.close();
        } catch (Exception e2)
        {
            log.error(e2);
            throw new SWBRuntimeException(e2.getMessage(), e2);            
        }
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public void close()
    {
        //Thread.currentThread().dumpStack();
        super.close();
    }

    @Override
    public PrefixMapping getPrefixMapping()
    {
        return pmap;
    }

}
