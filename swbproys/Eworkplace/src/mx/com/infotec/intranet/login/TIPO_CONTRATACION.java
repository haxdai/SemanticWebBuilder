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
    Nómina_Institucional,Eventual,Servicios_Profesionales_por_Honorarios;

    @Override
    public String toString()
    {
        /*StringBuilder sb=new StringBuilder(super.toString().replace('_', ' '));
        sb.replace(0, 1,((Character)Character.toUpperCase(super.toString().charAt(0))).toString());
        return sb.toString();*/
        return super.toString().replace('_', ' ');
    }
}
