/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.jcr170.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import javax.jcr.version.Version;
import javax.jcr.version.VersionIterator;
import org.semanticwb.repository.BaseNode;

/**
 *
 * @author victor.lorenzana
 */
public class VersionIteratorImp implements VersionIterator
{
    private final Iterator<BaseNode> versions;
    private final int size;
    private long position=0;
    VersionIteratorImp(VersionHistoryImp versionHistory)
    {
        ArrayList<BaseNode> temp=new ArrayList<BaseNode>();
        for(BaseNode version : versionHistory.getVersions())
        {
            temp.add(version);
        }
        size=versionHistory.getVersions().length;
        versions=temp.iterator();
    }
    public Version nextVersion()
    {
        position++;
        BaseNode node=versions.next();
        if(node!=null)
        {
            return new VersionImp(node);
        }
        else
        {
            return null;
        }
    }

    public void skip(long arg0)
    {
        for(int i=1;i<=arg0;i++)
        {
            nextVersion();
        }
    }

    public long getSize()
    {
        return size;
    }

    public long getPosition()
    {
        return position;
    }

    public boolean hasNext()
    {
        return versions.hasNext();
    }

    public Object next()
    {
        return nextVersion();
    }

    public void remove()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
