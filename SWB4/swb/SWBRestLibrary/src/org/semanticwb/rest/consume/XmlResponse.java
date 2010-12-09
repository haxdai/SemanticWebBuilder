/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.rest.consume;

import java.net.URL;

/**
 *
 * @author victor.lorenzana
 */
public interface XmlResponse extends RepresentationResponse {

    public URL getLink(ParameterDefinition definition) throws RestException;
    public URL[] getLinks(ParameterDefinition definition) throws RestException;
    public Object[] getValues(ParameterDefinition definition) throws RestException;
    public Object getValue(ParameterDefinition definition) throws RestException;
}
