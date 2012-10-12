/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.infotec.intranet.login;

/**
 *
 * @author victor.lorenzana
 */
public enum GENERO
{

    HOMBRE, MUJER;

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(super.toString().toLowerCase());
        sb.replace(0, 1, ((Character) Character.toUpperCase(super.toString().charAt(0))).toString());
        return sb.toString();
    }
    public static boolean getGenero(String genero)
    {
        if(genero.equalsIgnoreCase(HOMBRE.toString()))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean getBoolean()
    {
        if(this.name().equalsIgnoreCase(this.HOMBRE.toString()))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
