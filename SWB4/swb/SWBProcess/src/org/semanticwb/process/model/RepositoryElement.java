/*
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
 */
package org.semanticwb.process.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.semanticwb.model.VersionInfo;


public class RepositoryElement extends org.semanticwb.process.model.base.RepositoryElementBase 
{
    public RepositoryElement(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    /**
     * Obtiene el listado de versiones del elemento.
     * @return Lista de versiones del elemento.
     */
    public List<VersionInfo> listVersions() {
        ArrayList<VersionInfo> ret = new ArrayList<VersionInfo>();
        VersionInfo ver = getLastVersion();
        
        if (null != ver) {
            ret.add(ver);
            while (ver.getPreviousVersion() != null) {
                ver = ver.getPreviousVersion();
                ret.add(ver);
            }
        }
        Collections.reverse(ret);
        return ret;
    }
    
    /**
     * Obtiene la lista de elementos que conforman la jerarquía del elemento en el repositorio.
     * Se devuelven por defecto en la lista los ID de los directorios.
     * @param asNames indica si se devuelven en la lista los nombres de los elementos en lugar del ID.
     * @return Lista de elementos que conforman la jerarquía del elemento en el repositorio.
     */
    public ArrayList getElementRepositoryPath(boolean asNames) {
        ArrayList<String> nodes = new ArrayList<>();
        RepositoryDirectory root = getRepositoryDirectory();
        while (null != root) {
            nodes.add(asNames ? root.getTitle() : root.getId());
            if (null != root.getParent() && root.getParent() instanceof RepositoryDirectory) {
                root = (RepositoryDirectory) root.getParent();
            } else {
                root = null;
            }
        }
        
        return nodes;
    }
}
