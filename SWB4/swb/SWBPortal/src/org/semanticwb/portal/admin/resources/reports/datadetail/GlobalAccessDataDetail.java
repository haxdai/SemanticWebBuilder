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
 

package org.semanticwb.portal.admin.resources.reports.datadetail;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.semanticwb.portal.db.SWBRecHits_;
import org.semanticwb.portal.admin.resources.reports.beans.*;

public class GlobalAccessDataDetail extends SWBDataDetail{
    
    public GlobalAccessDataDetail(WBAFilterReportBean filterReportBean) {
        super(filterReportBean);
    }
    
    public List doDataList(String site, String rfilter, int type, String language) throws IncompleteFilterException {
        List resumeRecHits = new ArrayList();
//        /*if(rfilter.hasNext()) {*/
//            resumeRecHits = SWBRecHits_.getInstance().getResHitsLog(site, rfilter, type);
//        //}
        return resumeRecHits;
    }
    
    public List doDataList(String site, String rfilter, int type, int year, String language) throws IncompleteFilterException {
        List resumeRecHits = new ArrayList();
        resumeRecHits = SWBRecHits_.getInstance().getResHitsLog(site, rfilter, type, year);
        return resumeRecHits;
    }
    
    public List doDataList(String site, String rfilter, int type, int year, int month, int day, String language) throws IncompleteFilterException {
        List resumeRecHits = new ArrayList();
        resumeRecHits = SWBRecHits_.getInstance().getResHitsLog(site, rfilter, type, year, month, day);
        return resumeRecHits;
    }
    
    public List doDataList(String site, String rfilter, int type, int yearI, int monthI, int dayI, int yearF, int monthF, int dayF, String language) throws IncompleteFilterException {
        List resumeRecHits = new ArrayList();
        resumeRecHits = SWBRecHits_.getInstance().getResHitsLog(site, rfilter, type, yearI, monthI, dayI, yearF, monthF, dayF);
        return resumeRecHits;
    }
}
