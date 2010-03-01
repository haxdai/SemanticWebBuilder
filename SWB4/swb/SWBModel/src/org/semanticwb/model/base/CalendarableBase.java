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
package org.semanticwb.model.base;

// TODO: Auto-generated Javadoc
/**
 * The Interface CalendarableBase.
 */
public interface CalendarableBase extends org.semanticwb.model.GenericObject
{
    
    /** The Constant swb_Calendar. */
    public static final org.semanticwb.platform.SemanticClass swb_Calendar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Calendar");
    
    /** The Constant swb_hasCalendar. */
    public static final org.semanticwb.platform.SemanticProperty swb_hasCalendar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasCalendar");
    
    /** The Constant swb_Calendarable. */
    public static final org.semanticwb.platform.SemanticClass swb_Calendarable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Calendarable");

    /**
     * List calendars.
     * 
     * @return the org.semanticwb.model. generic iterator
     */
    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Calendar> listCalendars();
    
    /**
     * Checks for calendar.
     * 
     * @param calendar the calendar
     * @return true, if successful
     */
    public boolean hasCalendar(org.semanticwb.model.Calendar calendar);

    /**
     * Adds the calendar.
     * 
     * @param calendar the calendar
     */
    public void addCalendar(org.semanticwb.model.Calendar calendar);

    /**
     * Removes the all calendar.
     */
    public void removeAllCalendar();

    /**
     * Removes the calendar.
     * 
     * @param calendar the calendar
     */
    public void removeCalendar(org.semanticwb.model.Calendar calendar);

    /**
     * Gets the calendar.
     * 
     * @return the calendar
     */
    public org.semanticwb.model.Calendar getCalendar();
}
