package com.infotec.cvi.swb.base;

   /**
   * Elemento utilizado para definir las propiedades de la Justificación del Equipo a asignar 
   */
public interface EquipoJustificacionBase extends org.semanticwb.model.GenericObject
{
   /**
   * Propiedad que sirve para almacenar el detalle de la justificación para la asignación del equipo 
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_justificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#justificacion");
   /**
   * Elemento utilizado para definir las propiedades de la Justificación del Equipo a asignar 
   */
    public static final org.semanticwb.platform.SemanticClass intranet_EquipoJustificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EquipoJustificacion");

    public String getJustificacion();

    public void setJustificacion(String value);
}
