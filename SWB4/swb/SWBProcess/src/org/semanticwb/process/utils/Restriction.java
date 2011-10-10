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

import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.process.kpi.KProcessInstance;

/**
 *
 * @author Sergio Téllez
 */
public class Restriction {

    private String property = null;
    private Object criteria = null;
    private String operator = null;

    public final static int EQUALS=0;
    public final static int GREATER_THAT=1;
    public final static int SMALLER_THAT=2;
    public final static int GREATER_EQUAL=3;
    public final static int SMALLER_EQUAL=4;
    public final static int EQUALS_TO=5;
    public final static int EQUALS_IGNORE_CASE=6;
    public final static int STARTS_WITH=7;
    public final static int ENDS_WITH=8;
    public final static int LIKES=9;
    
    public Restriction(String property, Object criteria, String operator) {
        this.property = property;
        this.criteria=criteria;
        this.operator=operator;
    }

    public Restriction(String restriction) {
        if (restriction.startsWith("<restriction>")) {
            if (restriction.indexOf("<property>") != -1)
                setProperty(restriction.substring(restriction.indexOf("<property>") + 10, restriction.indexOf("</property>")));
            if (restriction.indexOf("<operator>") != -1)
                setOperator(restriction.substring(restriction.indexOf("<operator>") + 10, restriction.indexOf("</operator>")));
            if (restriction.indexOf("<criteria>") != -1)
                setCriteria(restriction.substring(restriction.indexOf("<criteria>") + 10, restriction.indexOf("</criteria>")));
        }
    }

    public void setProperty(String property) {
        this.property=property;
    }

    public void setCriteria(String criteria) {
        this.criteria=criteria;
    }

    public void setOperator(String operator) {
        this.operator=operator;
    }

    public String getProperty() {
        return this.property;
    }

    public Object getCriteria() {
        return this.criteria;
    }

    public String getOperator() {
        return this.operator;
    }

    public boolean match(SemanticObject sobj, SemanticProperty sp) {
        boolean match = false;
        if (getOperator().equals(String.valueOf(EQUALS))) {
            if (sp.isBoolean() && Boolean.valueOf((String)getCriteria()).equals(sobj.getBooleanProperty(sp)))
                return true;
            else if (sp.isInt() && Integer.valueOf((String)getCriteria()).equals(sobj.getIntProperty(sp)))
                return true;
            else if (sp.isDate() && ((String)getCriteria()).equals(String.valueOf(sobj.getDateProperty(sp))))
                return true;
            else if (sp.isDateTime() && ((String)getCriteria()).equals(String.valueOf(sobj.getDateTimeProperty(sp))))
                return true;
            else if (sp.isString() && ((String)getCriteria()).equals(sobj.getProperty(sp)))
                return true;
            else if (sp.isFloat() && Float.valueOf((String)getCriteria()).equals(sobj.getFloatProperty(sp)))
                return true;
            else if (sp.isDouble() && Double.valueOf((String)getCriteria()).equals(sobj.getDoubleProperty(sp)))
                return true;
            else if (sp.isLong() && Long.valueOf((String)getCriteria()).equals(sobj.getLongProperty(sp)))
                return true;
        }else if (getOperator().equals(String.valueOf(GREATER_THAT))) {
            if (sp.isInt() && sobj.getIntProperty(sp) > Integer.valueOf((String)getCriteria()))
                return true;
            else if (sp.isDate() && sobj.getDateProperty(sp).after(new DateInterval((String)getCriteria(),null).dateInit()))
                    return true;
            else if (sp.isDateTime() && sobj.getDateTimeProperty(sp).after(new DateInterval((String)getCriteria(),null).dateInit()))
                return true;
            else if (sp.isFloat() && sobj.getFloatProperty(sp) > Float.valueOf((String)getCriteria()))
                return true;
            else if (sp.isDouble() && sobj.getDoubleProperty(sp) > Double.valueOf((String)getCriteria()))
                return true;
            else if (sp.isLong() && sobj.getLongProperty(sp) > Long.valueOf((String)getCriteria()))
                return true;
        }else if (getOperator().equals(String.valueOf(SMALLER_THAT))) {
            if (sp.isInt() && sobj.getIntProperty(sp) < Integer.valueOf((String)getCriteria()))
                return true;
            else if (sp.isDate() && sobj.getDateProperty(sp).before(new DateInterval((String)getCriteria(),null).dateInit()))
                    return true;
            else if (sp.isDateTime() && sobj.getDateTimeProperty(sp).before(new DateInterval((String)getCriteria(),null).dateInit()))
                return true;
            else if (sp.isFloat() && sobj.getFloatProperty(sp) < Float.valueOf((String)getCriteria()))
                return true;
            else if (sp.isDouble() && sobj.getDoubleProperty(sp) < Double.valueOf((String)getCriteria()))
                return true;
            else if (sp.isLong() && sobj.getLongProperty(sp) < Long.valueOf((String)getCriteria()))
                return true;
        }else if (getOperator().equals(String.valueOf(GREATER_EQUAL))) {
            if (sp.isInt() && sobj.getIntProperty(sp) >= Integer.valueOf((String)getCriteria()))
                return true;
            else if (sp.isDate() && (sobj.getDateProperty(sp).before(new DateInterval((String)getCriteria(),null).dateInit()) || ((String)getCriteria()).equals(String.valueOf(sobj.getDateProperty(sp)))))
                    return true;
            else if (sp.isDateTime() && (sobj.getDateTimeProperty(sp).before(new DateInterval((String)getCriteria(),null).dateInit()) || ((String)getCriteria()).equals(String.valueOf(sobj.getDateTimeProperty(sp)))))
                return true;
            else if (sp.isFloat() && sobj.getFloatProperty(sp) >= Float.valueOf((String)getCriteria()))
                return true;

            else if (sp.isDouble() && sobj.getDoubleProperty(sp) >= Double.valueOf((String)getCriteria()))
                return true;
            else if (sp.isLong() && sobj.getLongProperty(sp) >= Long.valueOf((String)getCriteria()))
                return true;
        }else if (getOperator().equals(String.valueOf(SMALLER_EQUAL))) {
            if (sp.isInt() && sobj.getIntProperty(sp) <= Integer.valueOf((String)getCriteria()))
                return true;
            else if (sp.isDate() && (sobj.getDateProperty(sp).after(new DateInterval((String)getCriteria(),null).dateInit()) || ((String)getCriteria()).equals(String.valueOf(sobj.getDateProperty(sp)))))
                    return true;
            else if (sp.isDateTime() && (sobj.getDateTimeProperty(sp).after(new DateInterval((String)getCriteria(),null).dateInit()) || ((String)getCriteria()).equals(String.valueOf(sobj.getDateTimeProperty(sp)))))
                return true;
            else if (sp.isFloat() && sobj.getFloatProperty(sp) <= Float.valueOf((String)getCriteria()))
                return true;

            else if (sp.isDouble() && sobj.getDoubleProperty(sp) <= Double.valueOf((String)getCriteria()))
                return true;
            else if (sp.isLong() && sobj.getLongProperty(sp) <= Long.valueOf((String)getCriteria()))
                return true;
        }else if (getOperator().equals(String.valueOf(EQUALS_TO))) {
            if (((String)getCriteria()).equals(KProcessInstance.getPropertyValue(sobj, sp)))
                return true;
        }else if (getOperator().equals(String.valueOf(EQUALS_IGNORE_CASE))) {
            if (((String)getCriteria()).equalsIgnoreCase(KProcessInstance.getPropertyValue(sobj, sp)))
                return true;
        }else if (getOperator().equals(String.valueOf(STARTS_WITH))) {
            if (KProcessInstance.getPropertyValue(sobj, sp).startsWith((String)getCriteria()))
                return true;
        }else if (getOperator().equals(String.valueOf(ENDS_WITH))) {
            if (KProcessInstance.getPropertyValue(sobj, sp).endsWith((String)getCriteria()))
                return true;
        }else if (getOperator().equals(String.valueOf(LIKES))) {
            if (KProcessInstance.getPropertyValue(sobj, sp).contains((String)getCriteria()))
                return true;
        }
        return match;
    }

    @Override
    public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<restriction>");
		sb.append("<property>" + property + "</property>");
		sb.append("<operator>" + operator + "</operator>");
		sb.append("<criteria>" + criteria + "</criteria>");
		sb.append("</restriction>");
		return sb.toString();
	}
}