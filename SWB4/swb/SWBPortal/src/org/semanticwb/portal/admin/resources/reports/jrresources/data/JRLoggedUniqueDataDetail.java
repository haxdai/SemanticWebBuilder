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
 

package org.semanticwb.portal.admin.resources.reports.jrresources.data;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.semanticwb.portal.admin.resources.reports.beans.*;
import org.semanticwb.portal.admin.resources.reports.datadetail.LoggedUniqueDataDetail;
import org.semanticwb.portal.admin.resources.reports.datadetail.SWBDataDetail;
import org.semanticwb.portal.admin.resources.reports.jrresources.JRDataSourceable;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

// TODO: Auto-generated Javadoc
/**
 * The Class JRLoggedUniqueDataDetail.
 */
public class JRLoggedUniqueDataDetail implements JRDataSourceable{
    
    /** The data detail. */
    private SWBDataDetail dataDetail;
    
    /**
     * Instantiates a new jR logged unique data detail.
     * 
     * @param filterReportBean the filter report bean
     */
    public JRLoggedUniqueDataDetail(WBAFilterReportBean filterReportBean){
        dataDetail = new LoggedUniqueDataDetail(filterReportBean);
    }
    
    /* (non-Javadoc)
     * @see org.semanticwb.portal.admin.resources.reports.jrresources.JRDataSourceable#orderJRReport()
     */
    public JRBeanCollectionDataSource orderJRReport() throws IncompleteFilterException{
        List dataList = dataDetail.execute();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
        return dataSource;
    }
    
    /* (non-Javadoc)
     * @see org.semanticwb.portal.admin.resources.reports.jrresources.JRDataSourceable#prepareJRReport()
     */
    public void prepareJRReport() throws JRException{
    }
    
    /* (non-Javadoc)
     * @see org.semanticwb.portal.admin.resources.reports.jrresources.JRDataSourceable#exportReport(javax.servlet.http.HttpServletResponse)
     */
    public void exportReport(HttpServletResponse response) throws java.io.IOException, JRException{
    }
}
