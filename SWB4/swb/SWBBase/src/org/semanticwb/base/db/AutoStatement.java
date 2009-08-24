/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 

/*
 * PoolStatement.java
 *
 * Created on 20 de febrero de 2003, 12:43
 */

package org.semanticwb.base.db;

import java.sql.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;

/**
 * Objeto que sobrescribe la clase Statement para poder tener control la misma desde el Pool de conexiones.
 * @author  Javier Solis Gonzalez (jsolis@infotec.com.mx) 
 */
public class AutoStatement implements java.sql.Statement
{
    private static Logger log=SWBUtils.getLogger(AutoStatement.class);
    private boolean debug=false;

    Statement st;
    AutoConnection aconn;
    Connection conn;
    boolean closed = false;

    Integer param;
    Integer param1;


    /** Creates a new instance of PoolStatement
     * @param st 
     */
    public AutoStatement(AutoConnection aconn) throws SQLException
    {
        this.aconn=aconn;
        checkStatement();
    }

    public AutoStatement(AutoConnection aconn, int param, int param1) throws SQLException
    {
        this.aconn=aconn;
        this.param=param;
        this.param1=param1;
        checkStatement();
    }

    private void checkStatement() throws SQLException
    {
        if(!closed)
        {
            if(aconn.getNativeConnection()!=conn)
            {
                if(conn!=null)System.out.println("Recreating Statement...");
                conn=aconn.getNativeConnection();
                if(param!=null && param1!=null)
                {
                    st=conn.createStatement(param,param1);
                }else
                {
                    st=conn.createStatement();
                }
            }
        }
    }

    public void addBatch(String str) throws java.sql.SQLException
    {
        checkStatement();
        st.addBatch(str);
    }

    public void cancel() throws java.sql.SQLException
    {
        checkStatement();
        st.cancel();
    }

    public void clearBatch() throws java.sql.SQLException
    {
        checkStatement();
        st.clearBatch();
    }

    public void clearWarnings() throws java.sql.SQLException
    {
        checkStatement();
        st.clearWarnings();
    }

    public void close() throws java.sql.SQLException
    {
        closed = true;
        st.close();
    }

    public boolean execute(String str) throws java.sql.SQLException
    {
        checkStatement();
        return st.execute(str);
    }

    public int[] executeBatch() throws java.sql.SQLException
    {
        if(debug)
        {
            System.out.println("*************************************");
            System.out.println("s.executeBatch():");
        }
        checkStatement();
        return st.executeBatch();
    }

    public java.sql.ResultSet executeQuery(String str) throws java.sql.SQLException
    {
        if(debug)System.out.println("s.executeQuery:"+str);
        checkStatement();
        try
        {
            return st.executeQuery(str);
        }catch(SQLException se)
        {
            if(aconn.checkConnection())
            {
                checkStatement();
                return st.executeQuery(str);
            }else
            {
                throw se;
            }
        }
    }

    public int executeUpdate(String str) throws java.sql.SQLException
    {
        if(debug)System.out.println("s.executeUpdate:"+str);
        checkStatement();
        return st.executeUpdate(str);
    }

    public java.sql.Connection getConnection() throws java.sql.SQLException
    {
        checkStatement();
        return st.getConnection();
    }

    public int getFetchDirection() throws java.sql.SQLException
    {
        checkStatement();
        return st.getFetchDirection();
    }

    public int getFetchSize() throws java.sql.SQLException
    {
        checkStatement();
        return st.getFetchSize();
    }

    public int getMaxFieldSize() throws java.sql.SQLException
    {
        checkStatement();
        return st.getMaxFieldSize();
    }

    public int getMaxRows() throws java.sql.SQLException
    {
        checkStatement();
        return st.getMaxRows();
    }

    public boolean getMoreResults() throws java.sql.SQLException
    {
        checkStatement();
        return st.getMoreResults();
    }

    public int getQueryTimeout() throws java.sql.SQLException
    {
        checkStatement();
        return st.getQueryTimeout();
    }

    public java.sql.ResultSet getResultSet() throws java.sql.SQLException
    {
        checkStatement();
        return st.getResultSet();
    }

    public int getResultSetConcurrency() throws java.sql.SQLException
    {
        checkStatement();
        return st.getResultSetConcurrency();
    }

    public int getResultSetType() throws java.sql.SQLException
    {
        checkStatement();
        return st.getResultSetType();
    }

    public int getUpdateCount() throws java.sql.SQLException
    {
        checkStatement();
        return st.getUpdateCount();
    }

    public java.sql.SQLWarning getWarnings() throws java.sql.SQLException
    {
        checkStatement();
        return st.getWarnings();
    }

    public void setCursorName(String str) throws java.sql.SQLException
    {
        checkStatement();
        st.setCursorName(str);
    }

    public void setEscapeProcessing(boolean param) throws java.sql.SQLException
    {
        checkStatement();
        st.setEscapeProcessing(param);
    }

    public void setFetchDirection(int param) throws java.sql.SQLException
    {
        checkStatement();
        st.setFetchDirection(param);
    }

    public void setFetchSize(int param) throws java.sql.SQLException
    {
        checkStatement();
        st.setFetchSize(param);
    }

    public void setMaxFieldSize(int param) throws java.sql.SQLException
    {
        checkStatement();
        st.setMaxFieldSize(param);
    }

    public void setMaxRows(int param) throws java.sql.SQLException
    {
        checkStatement();
        st.setMaxRows(param);
    }

    public void setQueryTimeout(int param) throws java.sql.SQLException
    {
        checkStatement();
        st.setQueryTimeout(param);
    }

    public boolean isClosed()
    {
        return closed;
    }

//********************************** version 1.4
    public boolean execute(String str, String[] str1) throws java.sql.SQLException
    {
        checkStatement();
        return st.execute(str, str1);
    }

    public boolean execute(String str, int[] values) throws java.sql.SQLException
    {
        checkStatement();
        return st.execute(str, values);
    }

    public boolean execute(String str, int param) throws java.sql.SQLException
    {
        checkStatement();
        return st.execute(str, param);
    }

    public int getResultSetHoldability() throws java.sql.SQLException
    {
        checkStatement();
        return st.getResultSetHoldability();
    }

    public boolean getMoreResults(int param) throws java.sql.SQLException
    {
        checkStatement();
        return st.getMoreResults(param);
    }

    public int executeUpdate(String str, String[] str1) throws java.sql.SQLException
    {
        checkStatement();
        return st.executeUpdate(str, str1);
    }

    public int executeUpdate(String str, int param) throws java.sql.SQLException
    {
        checkStatement();
        return st.executeUpdate(str, param);
    }

    public int executeUpdate(String str, int[] values) throws java.sql.SQLException
    {
        checkStatement();
        return st.executeUpdate(str, values);
    }

    public java.sql.ResultSet getGeneratedKeys() throws java.sql.SQLException
    {
        checkStatement();
        return st.getGeneratedKeys();
    }

//********************************** version 1.6
/*
    public void setPoolable(boolean poolable) throws SQLException {
        checkStatement();
        st.setPoolable(poolable);
    }

    public boolean isPoolable() throws SQLException {
        checkStatement();
        return st.isPoolable();
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        checkStatement();
        return st.unwrap(iface);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        checkStatement();
        return st.isWrapperFor(iface);
    }

//*/
}
