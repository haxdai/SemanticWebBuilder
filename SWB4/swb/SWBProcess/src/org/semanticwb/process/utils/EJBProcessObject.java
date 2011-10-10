/**
* SemanticWebBuilder Process (SWB Process) es una plataforma para la gestión de procesos de negocio mediante el uso de 
* tecnología semántica, que permite el modelado, configuración, ejecución y monitoreo de los procesos de negocio
* de una organización, así como el desarrollo de componentes y aplicaciones orientadas a la gestión de procesos.
* 
* Mediante el uso de tecnología semántica, SemanticWebBuilder Process puede generar contextos de información
* alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes fuentes asociadas a
* un proceso de negocio, donde a la información se le asigna un significado, de forma que pueda ser interpretada
* y procesada por personas y/o sistemas. SemanticWebBuilder Process es una creación original del Fondo de 
* Información y Documentación para la Industria INFOTEC.
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder Process a través de su licenciamiento abierto 
* al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC 
* lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente,
* modificarlo y combinarlo (o enlazarlo) con otro software. Todo lo anterior de conformidad con los términos y 
* condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de SemanticWebBuilder Process. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder Process, de ninguna especie y naturaleza, ni implícita ni 
* explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los 
* riesgos que puedan derivar de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder Process, INFOTEC pone a su disposición la
* siguiente dirección electrónica: 
*  http://www.semanticwebbuilder.org.mx
**/

package org.semanticwb.process.utils;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Sergio Téllez
 */
public class EJBProcessObject {

    private HashMap map;
    private HashMap fields;
    private String keys;
    private String instance;

    public EJBProcessObject(HashMap map, HashMap fields) {
        this.map = map;
        this.fields = fields;
        keys = instance = "";
        build();
    }

    public String getInstance() {
        return instance;
    }

    public String getKeys() {
        return keys;
    }

    private void build() {
        StringBuffer names = new StringBuffer();
        StringBuffer values = new StringBuffer();
        names.append("<table>");
        values.append("<table>");
        Iterator<String> itkeys = map.keySet().iterator();
        while (itkeys.hasNext()) {
            String key = itkeys.next();
            names.append("    <tr><td>" + (fields.containsKey(key) ? fields.get(key) : key) + "</td></tr>");
            values.append("    <tr><td>" + Ajax.notNull((String)map.get(key)) + "</td></tr>");
        }
        names.append("</table>");
        values.append("</table>");
        keys = names.toString();
        instance = values.toString();
    }
}
