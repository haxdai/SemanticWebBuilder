/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.jcr283.implementation;

import javax.jcr.ItemNotFoundException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.query.Row;

/**
 *
 * @author victor.lorenzana
 */
public final class RowImp implements Row {

    private final SessionImp session;
    private final ValueImp[] values;
    private final String[] columnames;
    public RowImp(SessionImp session,String[] columnames,ValueImp[] values)
    {
        this.session=session;
        this.values=values;
        this.columnames=columnames;
    }
    public Value[] getValues() throws RepositoryException
    {
        return values;
    }

    public Value getValue(String columnName) throws ItemNotFoundException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Node getNode() throws RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Node getNode(String selectorName) throws RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getPath() throws RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getPath(String selectorName) throws RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double getScore() throws RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double getScore(String selectorName) throws RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
