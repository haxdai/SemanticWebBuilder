/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.infotec.intranet.login;

/**
 *
 * @author victor.lorenzana
 */
public enum TIPO_CONTRATACION {
    Nomina_Institucional("Nómina Institucional"),
    Eventual("Eventual"),
    Servicios_Profesionales_por_Honorarios("Servicios Profesionales por honorarios");
    
    TIPO_CONTRATACION()
    {
        this.description = this.toString();
    }
    
    TIPO_CONTRATACION(String descrption)
    {
        this.description = descrption;
    }
    
    private String description;
    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        /*StringBuilder sb=new StringBuilder(super.toString().replace('_', ' '));
        sb.replace(0, 1,((Character)Character.toUpperCase(super.toString().charAt(0))).toString());
        return sb.toString();*/
        //return super.toString().replace('_', ' ');
        return getDescription();
    }
    
}