/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.repository;

import java.security.Principal;
import java.util.ArrayList;
import javax.jcr.Session;

/**
 *
 * @author victor.lorenzana
 */
public interface RepositoryManager {
    public void init();
    public ArrayList<String> getWorkspaces();
    public Session openSession(String workspace,String id,String password) throws Exception;
    public Session openSession(String workspace,Principal principal) throws Exception;
    public String getName();
    public OfficeManager getOfficeManager();
}
