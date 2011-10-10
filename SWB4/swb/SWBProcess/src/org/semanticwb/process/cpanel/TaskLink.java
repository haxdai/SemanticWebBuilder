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

package org.semanticwb.process.cpanel;

import java.util.*;
import org.semanticwb.process.model.*;
import org.semanticwb.model.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;

/**
 *
 * @author haydee.vertti
 */
public class TaskLink {

    private String tlHref;
    private String tlLegend;
    private FlowNodeInstance fobi;
    private Hashtable artifactValues;
    private int tlPriority;
    private static Logger log = SWBUtils.getLogger(TaskLink.class);

        public TaskLink(FlowNodeInstance fobi, String tlHref,
                String tlLegend, Hashtable artifactValues)
        {
            this.fobi = fobi;
            this.tlHref = tlHref;
            this.tlLegend = tlLegend;
            this.artifactValues = artifactValues;
            this.tlPriority = getFlowNodePriority();
        }

        public TaskLink(FlowNodeInstance fobi, String tlHref, String tlLegend)
        {
            this.fobi = fobi;
            this.tlHref = tlHref;
            this.tlLegend = tlLegend;
            this.tlPriority = getFlowNodePriority();
        }

        public TaskLink(FlowNodeInstance fobi)
        {
            this.fobi = fobi;
            this.tlHref = "";
            this.tlLegend = "";
            this.tlPriority = getFlowNodePriority();
        }

        public Hashtable getTaskLinkArtifactValues(){
            return artifactValues;
        }

        public FlowNodeInstance getTaskLinkFlowNodeInstance(){
            return fobi;
        }

        public String getTaskLinkHref(){
            return tlHref;
        }

        public String getTaskLinkLegend(){
            return tlLegend;
        }

        public Object getTaskLinkArtifactValue(String key)
        {
            Object objValue = new Object();
            if(this.artifactValues.containsKey(key))
            {
                objValue  = this.artifactValues.get(key);
            }
            return objValue;
        }

        public String getFlowNodeInstanceId()
        {
            String strId = this.fobi.getId()==null
                ?""
                :this.fobi.getId();
            return strId;
        }

        public int getFlowNodeInstanceStatus()
        {
            int intStatus = this.fobi.getStatus();
            return intStatus;
        }

        public FlowNode getFlowNodeType()
        {
            FlowNode fobType = this.fobi.getFlowNodeType();
            return fobType;
        }

        public String getFlowNodeParentProcess()
        {
            //TODO: Que pasa si es un subproceso???
            String strProcessTitle = "";
            try {
            ProcessInstance fpinst = this.fobi.getProcessInstance();
            if(null!=fpinst){
                org.semanticwb.process.model.Process fproc = (org.semanticwb.process.model.Process)fpinst.getProcessType();
                if(null!=fproc){
                    strProcessTitle = fproc.getTitle();
                }
            }
            /*
            String strProcessTitle = this.getFlowNodeType().getParent().getTitle()==null
                ?""
                :this.getFlowNodeType().getParent().getTitle();
             */
            }catch(Exception e){
                log.error("Error en TaskLink.getFlowNodeParentProcess", e);
                //System.out.println("Error en TaskLink.getFlowNodeParentProcess:" + e.getMessage());
            }
            return strProcessTitle;
        }

        public int getPriority(){
            return this.tlPriority;
        }

        public int getFlowNodePriority(){
            int intPriority = 2;
            try{
                ProcessInstance pinst = this.fobi.getProcessInstance();
                if(null!=pinst){
                    intPriority = pinst.getPriority();
                }
            }catch(Exception e){
                log.error("Error en TaskLink.getFlowNodePriority", e);
                //System.out.println("Error en TaskLink.getFlowNodePriority:" + e.getMessage());
            }
            return intPriority;
        }

        public String getFlowNodeParentProcessURI()
        {
            //TODO: Que pasa si es un subproceso???
            String strProcessURI = "";
            ProcessInstance fpinst = this.fobi.getProcessInstance();
            if(null!=fpinst){
                org.semanticwb.process.model.Process fproc = (org.semanticwb.process.model.Process)fpinst.getProcessType();
                if(null!=fproc){
                    strProcessURI = fproc.getURI();
                }
            }
            return strProcessURI;
        }

        public String getFlowNodeTitle()
        {
            String strTaskTitle =
                this.getFlowNodeType().getTitle()==null
                ?""
                :this.getFlowNodeType().getTitle();


            return strTaskTitle;
        }

        public java.util.Date getFlowNodeInstanceCreated()
        {
            return this.fobi.getCreated();
        }

        public User getFlowNodeInstanceCreatedBy()
        {
            return this.fobi.getCreator();
        }

        public String getFlowNodeInstanceCreatedByName()
        {
            String strCreatedByName =
                this.getFlowNodeInstanceCreatedBy().getFullName()==null
                ?""
                :this.getFlowNodeInstanceCreatedBy().getFullName();
            return strCreatedByName;
        }

        public java.util.Date getFlowNodeInstanceModified()
        {
            return this.fobi.getUpdated();
        }

        public User getFlowNodeInstanceModifiedBy()
        {
            return this.fobi.getModifiedBy();
        }

        public String getFlowNodeInstanceModifiedByName()
        {
            String strModifiedByName =
                this.getFlowNodeInstanceModifiedBy().getFullName()==null
                ?""
                :this.getFlowNodeInstanceModifiedBy().getFullName();
            return strModifiedByName;
        }

        public java.util.Date getFlowNodeInstanceEnded()
        {
            return this.fobi.getEnded();
        }

        public User getFlowNodeInstanceEndedBy()
        {
            return this.fobi.getEndedby();
        }

        public String getFlowNodeInstanceEndedByName()
        {
            String strEndedByName =
                this.getFlowNodeInstanceEndedBy().getFullName()==null
                ?""
                :this.getFlowNodeInstanceEndedBy().getFullName();
            return strEndedByName;
        }

        public void setTaskLinkArtifactValue(String key, Object objValue)
        {
            this.artifactValues.put(key, objValue);
        }

        public void setTaskLinkArtifactValues(Hashtable artifactValues){
            this.artifactValues = artifactValues;
        }

        public void setTaskLinkFlowNodeInstance(FlowNodeInstance fobi){
            this.fobi = fobi;
        }

        public void setTaskLinkHref(String tlHref){
            this.tlHref = tlHref;
        }

        public void setTaskLinkLegend(String tlLegend){
            this.tlLegend = tlLegend;
        }

        public String toString(){
            return fobi.toString() + "|" +  tlHref + "|" + tlLegend;
        }

    /**
	 * Clase utilizada para comparar 2 objetos TaskLink.
	 * Regresa un entero: result = value2.compareTo(value1);
	 * Si el entero es menor a cero, el valor que invoca la funcion de
     * comparacion, es menor al valor del argumento.
	 * Si el entero es mayor a cero, el valor que invoca la funcion es mayor al
     * valor del argumento.
	 * Si el entero es igual a cero, ambos valores son iguales.
	 * Cada objeto TaskLink tiene un objeto FlowNodeInstance y Strings para
     * los datos del vínculo y la leyenda.
	 * El objeto FlowNodeInstance tiene un identificador y fecha de creacion.
	 * <p>
	 * Este método no regresa ningun objeto.
	 *
	 * @param  obj1 			Objeto TaskLink
	 * @param  obj2 			Objeto TaskLink
	 * @return result     		int
	 * @see         			Topic
	 */
    static class TaskLinkDateComparator implements Comparator{
        public int compare(Object obj1, Object obj2){
            int result=0;
            TaskLink tlink1 = (TaskLink)obj1;
            TaskLink tlink2 = (TaskLink)obj2;
            FlowNodeInstance fobi1 = tlink1.getTaskLinkFlowNodeInstance();
            FlowNodeInstance fobi2 = tlink2.getTaskLinkFlowNodeInstance();
            String id1 = (String)fobi1.getId();
            String id2 = (String)fobi2.getId();
            Date value1 = (Date)fobi1.getCreated();
            Date value2 = (Date)fobi2.getCreated();
            result = value2.compareTo(value1);
			if(result==0){
				result = id1.compareTo(id2);
			}
            return result;
        }
    }

    /**
	 * Clase utilizada para comparar 2 objetos TaskLink.
	 * Regresa un entero: result = value2.compareTo(value1);
	 * Si el entero es menor a cero, el valor que invoca la funcion de
     * comparacion, es menor al valor del argumento.
	 * Si el entero es mayor a cero, el valor que invoca la funcion es mayor al
     * valor del argumento.
	 * Si el entero es igual a cero, ambos valores son iguales.
	 * Cada objeto TaskLink tiene un objeto FlowNodeInstancey Strings para
     * los datos del vínculo y la leyenda.
	 * El objeto FlowNodeInstance tiene un identificador y fecha de creacion.
	 * <p>
	 * Este método no regresa ningun objeto.
	 *
	 * @param  obj1 			Objeto TaskLink
	 * @param  obj2 			Objeto TaskLink
	 * @return result     		int
	 * @see         			Topic
	 */
    static class TaskLinkProcessComparator implements Comparator{
        public int compare(Object obj1, Object obj2){
            int result=0;
            TaskLink tlink1 = (TaskLink)obj1;
            TaskLink tlink2 = (TaskLink)obj2;
            FlowNodeInstance fobi1 = tlink1.getTaskLinkFlowNodeInstance();
            FlowNodeInstance fobi2 = tlink2.getTaskLinkFlowNodeInstance();
            Date date1 = (Date)fobi1.getCreated();
            Date date2 = (Date)fobi2.getCreated();
            FlowNode fobiType1 = (FlowNode)fobi1.getFlowNodeType();
            FlowNode fobiType2 = (FlowNode)fobi2.getFlowNodeType();
            GraphicalElement ge1 = fobiType1.getParent();
            GraphicalElement ge2 = fobiType2.getParent();
            String value1 = ge1.getURI();
            String value2 = ge2.getURI();
            result = value2.compareTo(value1);
			if(result==0){
				result = date1.compareTo(date2);
			}
            return result;
        }
    }

    static class TaskLinkPriorityComparator implements Comparator{
        public int compare(Object obj1, Object obj2){
            int result=0;
            int int1 = 0;
            int int2 = 0;
            TaskLink tlink1 = (TaskLink)obj1;
            TaskLink tlink2 = (TaskLink)obj2;
            FlowNodeInstance fobi1 = tlink1.getTaskLinkFlowNodeInstance();
            FlowNodeInstance fobi2 = tlink2.getTaskLinkFlowNodeInstance();
            int1 = tlink1.getFlowNodePriority();
            int2 = tlink2.getFlowNodePriority();
            Date date1 = (Date)fobi1.getCreated();
            Date date2 = (Date)fobi2.getCreated();
            if( int1 > int2 ){
                result = 1;
            } else if( int1 < int2 ) {
                result = -1;
            } else {
                result = date1.compareTo(date2);
            }
            return result;
        }
    }

    /**
	 * Clase utilizada para comparar 2 objetos TaskLink.
	 * Regresa un entero: result = value2.compareTo(value1);
	 * Si el entero es menor a cero, el valor que invoca la funcion de
     * comparacion, es menor al valor del argumento.
	 * Si el entero es mayor a cero, el valor que invoca la funcion es mayor al
     * valor del argumento.
	 * Si el entero es igual a cero, ambos valores son iguales.
	 * Cada objeto TaskLink tiene un objeto FlowNodeInstance y Strings para
     * los datos del vínculo y la leyenda.
	 * El objeto FlowNodeInstance tiene un identificador, titulo y fecha de creacion.
	 * <p>
	 * Este método no regresa ningun objeto.
	 *
	 * @param  obj1 			Objeto TaskLink
	 * @param  obj2 			Objeto TaskLink
	 * @return result     		int
	 * @see         			Topic
	 */
    static class TaskLinkTitleComparator implements Comparator{
        public int compare(Object obj1, Object obj2){
            int result=0;
            TaskLink tlink1 = (TaskLink)obj1;
            TaskLink tlink2 = (TaskLink)obj2;
            FlowNodeInstance fobi1 = tlink1.getTaskLinkFlowNodeInstance();
            FlowNodeInstance fobi2 = tlink2.getTaskLinkFlowNodeInstance();
            Date date1 = (Date)fobi1.getCreated();
            Date date2 = (Date)fobi2.getCreated();
            FlowNode fobiType1 = (FlowNode)fobi1.getFlowNodeType();
            FlowNode fobiType2 = (FlowNode)fobi2.getFlowNodeType();
            String value1 = fobiType1.getTitle();
            String value2 = fobiType2.getTitle();
            result = value1.compareTo(value2);
			if(result==0){
				result = date1.compareTo(date2);
			}
            return result;
        }
    }
}

