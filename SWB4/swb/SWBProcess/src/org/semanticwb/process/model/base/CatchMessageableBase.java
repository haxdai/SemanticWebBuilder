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
package org.semanticwb.process.model.base;

public interface CatchMessageableBase extends org.semanticwb.model.GenericObject
{
    public static final org.semanticwb.platform.SemanticClass swp_ItemAwareMapping=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#ItemAwareMapping");
    public static final org.semanticwb.platform.SemanticProperty swp_hasItemAwareMapping=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/process#hasItemAwareMapping");
    public static final org.semanticwb.platform.SemanticClass swp_CatchMessageable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#CatchMessageable");

    public org.semanticwb.model.GenericIterator<org.semanticwb.process.model.ItemAwareMapping> listItemAwareMappings();
    public boolean hasItemAwareMapping(org.semanticwb.process.model.ItemAwareMapping value);

   /**
   * Adds the ItemAwareMapping
   * @param value An instance of org.semanticwb.process.model.ItemAwareMapping
   */
    public void addItemAwareMapping(org.semanticwb.process.model.ItemAwareMapping value);

   /**
   * Remove all the values for the property ItemAwareMapping
   */
    public void removeAllItemAwareMapping();

   /**
   * Remove a value from the property ItemAwareMapping
   * @param value An instance of org.semanticwb.process.model.ItemAwareMapping
   */
    public void removeItemAwareMapping(org.semanticwb.process.model.ItemAwareMapping value);

/**
* Gets the ItemAwareMapping
* @return a instance of org.semanticwb.process.model.ItemAwareMapping
*/
    public org.semanticwb.process.model.ItemAwareMapping getItemAwareMapping();
}
