/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.triplestore.ext;

import org.semanticwb.triplestore.*;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.graph.TripleMatch;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.util.iterator.Filter;
import com.hp.hpl.jena.util.iterator.Map1;
import com.hp.hpl.jena.util.iterator.Map1Iterator;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.semanticwb.Logger;
import org.semanticwb.SWBRuntimeException;
import org.semanticwb.SWBUtils;

/**
 *
 * @author jei
 */
public class SWBTSIteratorExt implements ExtendedIterator<Triple>
{

    private static Logger log=SWBUtils.getLogger(SWBTSIteratorExt.class);

    private SWBTSGraph graph=null;
    private TripleMatch tm=null;

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    private Triple actual=null;
    private Triple next=null;

    private boolean closed=false;

    private static int counter=0;

    public SWBTSIteratorExt(SWBTSGraph graph, TripleMatch tm, String stype, Long limit, Long offset, String sortby)
    {
        //new Exception().printStackTrace();
        
        counter++;
        //System.out.println("SWBTSIterator:"+counter+" tm:"+tm+" "+graph.getName());
        
        this.graph=graph;
        this.tm=tm;

        String subj=SWBTSUtil.node2HashString(tm.getMatchSubject(),"lgs");
        String prop=SWBTSUtil.node2HashString(tm.getMatchPredicate(),"lgp");
        String obj=SWBTSUtil.node2HashString(tm.getMatchObject(),"lgo");
        
        //System.out.println("subj:"+subj+" prop:"+prop+" obj:"+obj);

        try
        {
            con=SWBUtils.DB.getDefaultConnection();

            String query="select * from swb_graph_ts"+graph.getId();
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
            if(stype!=null)
            {
                if(query2.length()>0)query2 +=" and";
                query2 += " stype=?";
            }            

            if(query2.length()>0)query+=" where"+query2;
            
            
            String query3="";
            if(sortby!=null)
            {
                //sortby.replace("obj", "sort");
                //if(sortby.equals("obj"))sortby="sort";
                query3=" order by "+sortby;
            }
            
            if(limit!=null)
            {
                query3+=" limit "+limit;
            }
            
            if(offset!=null)
            {
                query3+=" offset "+offset;
            }

            query+=query3;

            ps=con.prepareStatement(query);
            int i=1;
            if(subj!=null)ps.setString(i++, subj);
            if(prop!=null)ps.setString(i++, prop);
            if(obj!=null)ps.setString(i++, obj);
            if(stype!=null)ps.setString(i++, stype);
            
            rs=ps.executeQuery();

            if(rs.next())
            {
                String ext=null;
                InputStream sext=rs.getAsciiStream("ext");
                try
                {
                    if(sext!=null)ext=SWBUtils.IO.readInputStream(sext);
                }catch(Exception e){log.error(e);}
                next = new Triple(SWBTSUtil.string2Node(rs.getString("subj"),ext), SWBTSUtil.string2Node(rs.getString("prop"),ext), SWBTSUtil.string2Node(rs.getString("obj"),ext));
            }else
            {
                close();
            }
        }catch(SQLException e)
        {
            log.error(e);
            throw new SWBRuntimeException(e.getMessage(), e);
        }

        //Thread.currentThread().dumpStack();
    }

    public Triple removeNext()
    {
        Triple tp=next();
        remove();
        return tp;
    }

    public <X extends Triple> ExtendedIterator<Triple> andThen(Iterator<X> other)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ExtendedIterator<Triple> filterKeep(Filter<Triple> f)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ExtendedIterator<Triple> filterDrop(Filter<Triple> f)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
        make a new iterator which is the elementwise _map1_ of the base iterator.
    */     
    public <U> ExtendedIterator<U> mapWith( Map1<Triple, U> map1 )
    { 
        return new Map1Iterator<Triple, U>( map1, this ); 
    }
    

    public List<Triple> toList()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Set<Triple> toSet()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void close()
    {
        if(!closed)
        {
            closed=true;
            try
            {
                counter--;
                //System.out.println("SWBTSIterator Closed:"+counter+" tm:"+tm+" "+graph.getName());
                if(rs!=null)rs.close();
                if(ps!=null)ps.close();
                if(con!=null)con.close();
            } catch (Exception ex)
            {
                log.error(ex);
            }
        }
    }

    public boolean hasNext()
    {
        return next!=null;
    }

    public Triple next()
    {
        actual=next;
        next=null;
        try
        {
            if(rs.next())
            {
                String ext=null;
                InputStream sext=rs.getAsciiStream("ext");
                try
                {
                    if(sext!=null)ext=SWBUtils.IO.readInputStream(sext);
                }catch(Exception e){log.error(e);}
                next = new Triple(SWBTSUtil.string2Node(rs.getString("subj"),ext), SWBTSUtil.string2Node(rs.getString("prop"),ext), SWBTSUtil.string2Node(rs.getString("obj"),ext));
            }else
            {
                close();
            }

        }catch(SQLException e)
        {
            log.error(e);
        }
        return actual;
    }

    public void remove()
    {
        graph.performDelete(actual);
    }

    @Override
    protected void finalize() throws Throwable
    {
        if(!closed)
        {
            log.warn("Iterator is not closed, "+tm);
            close();
        }
    }

}