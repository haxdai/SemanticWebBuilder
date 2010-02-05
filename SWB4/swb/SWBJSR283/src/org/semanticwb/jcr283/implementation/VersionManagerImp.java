/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.jcr283.implementation;

import javax.jcr.AccessDeniedException;
import javax.jcr.InvalidItemStateException;
import javax.jcr.ItemExistsException;
import javax.jcr.MergeException;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.UnsupportedRepositoryOperationException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.Version;
import javax.jcr.version.VersionException;
import javax.jcr.version.VersionHistory;
import javax.jcr.version.VersionManager;

/**
 *
 * @author victor.lorenzana
 */
public class VersionManagerImp implements VersionManager
{
    private final NodeImp versionStorage;
    
    private final SessionImp session;
    private final NodeManager nodeManager;
    public VersionManagerImp(SessionImp session,NodeImp versionStorage,NodeManager nodeManager)
    {
        this.session = session;
        this.versionStorage=versionStorage;
        this.nodeManager=nodeManager;
    }
    public NodeImp getVersionStorage()
    {
        return versionStorage;
    }
    
    @SuppressWarnings(value="deprecation")
    public Version checkin(String absPath) throws VersionException, UnsupportedRepositoryOperationException, InvalidItemStateException, LockException, RepositoryException
    {
        NodeImp node=nodeManager.getNode(absPath);
        if(node==null)
        {
            throw new RepositoryException("The node "+absPath+" was not found");
        }
        return node.checkin();
    }

    @SuppressWarnings(value="deprecation")
    public void checkout(String absPath) throws UnsupportedRepositoryOperationException, LockException, RepositoryException
    {
        NodeImp node=nodeManager.getNode(absPath);
        node.checkout();
    }

    public Version checkpoint(String absPath) throws VersionException, UnsupportedRepositoryOperationException, InvalidItemStateException, LockException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isCheckedOut(String absPath) throws RepositoryException
    {
        NodeImp node=nodeManager.getNode(absPath);
        if(node==null)
        {
            throw new RepositoryException("The node "+absPath+" was not found");
        }
        if(!node.isVersionable())
        {
            throw new RepositoryException("The node is not versionable");
        }
        return node.isCheckedOut();
    }

    public VersionHistory getVersionHistory(String absPath) throws UnsupportedRepositoryOperationException, RepositoryException
    {
        if (!ItemImp.isValidAbsPath(absPath))
        {
            throw new RepositoryException("The path is not absolute: " + absPath);
        }
        if (!session.getWorkspaceImp().getNodeManager().hasNode(absPath))
        {
            throw new RepositoryException("the node " + absPath + " was not found");
        }
        NodeImp node=session.getWorkspaceImp().getNodeManager().getNode(absPath);
        if(!node.isVersionable())
        {
            throw new UnsupportedRepositoryOperationException("The node is not versionable");
        }
        return node.getBaseVersion().getContainingHistory();        
    }

    public Version getBaseVersion(String absPath) throws UnsupportedRepositoryOperationException, RepositoryException
    {
        return getBaseVersionImp(absPath);
    }
    public VersionImp getBaseVersionImp(String absPath) throws UnsupportedRepositoryOperationException, RepositoryException
    {
        if (!ItemImp.isValidAbsPath(absPath))
        {
            throw new RepositoryException("The path is not absolute: " + absPath);
        }
        if (!session.getWorkspaceImp().getNodeManager().hasNode(absPath))
        {
            throw new RepositoryException("the node " + absPath + " was not found");
        }
        NodeImp node=session.getWorkspaceImp().getNodeManager().getNode(absPath);
        if(!node.isVersionable())
        {
            throw new UnsupportedRepositoryOperationException("The node is not versionable");
        }
        return node.getBaseVersionImp();
    }

    public void restore(Version[] versions, boolean removeExisting) throws ItemExistsException, UnsupportedRepositoryOperationException, VersionException, LockException, InvalidItemStateException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void restore(String absPath, String versionName, boolean removeExisting) throws VersionException, ItemExistsException, UnsupportedRepositoryOperationException, LockException, InvalidItemStateException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void restore(Version version, boolean removeExisting) throws VersionException, ItemExistsException, InvalidItemStateException, UnsupportedRepositoryOperationException, LockException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void restore(String absPath, Version version, boolean removeExisting) throws PathNotFoundException, ItemExistsException, VersionException, ConstraintViolationException, UnsupportedRepositoryOperationException, LockException, InvalidItemStateException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void restoreByLabel(String absPath, String versionLabel, boolean removeExisting) throws VersionException, ItemExistsException, UnsupportedRepositoryOperationException, LockException, InvalidItemStateException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public NodeIterator merge(String absPath, String srcWorkspace, boolean bestEffort) throws NoSuchWorkspaceException, AccessDeniedException, MergeException, LockException, InvalidItemStateException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public NodeIterator merge(String absPath, String srcWorkspace, boolean bestEffort, boolean isShallow) throws NoSuchWorkspaceException, AccessDeniedException, MergeException, LockException, InvalidItemStateException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void doneMerge(String absPath, Version version) throws VersionException, InvalidItemStateException, UnsupportedRepositoryOperationException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cancelMerge(String absPath, Version version) throws VersionException, InvalidItemStateException, UnsupportedRepositoryOperationException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Node createConfiguration(String absPath) throws UnsupportedRepositoryOperationException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Node setActivity(Node activity) throws UnsupportedRepositoryOperationException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Node getActivity() throws UnsupportedRepositoryOperationException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Node createActivity(String title) throws UnsupportedRepositoryOperationException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeActivity(Node activityNode) throws UnsupportedRepositoryOperationException, VersionException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public NodeIterator merge(Node activityNode) throws VersionException, AccessDeniedException, MergeException, LockException, InvalidItemStateException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
