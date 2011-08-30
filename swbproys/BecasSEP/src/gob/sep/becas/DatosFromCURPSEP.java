/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.sep.becas;

/**
 *
 * @author serch
 */
public class DatosFromCURPSEP {
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String cveEdoNac;
    private String fechaNac;
    private String sexo;

    public String getApellido1()
    {
        return apellido1;
    }

    public void setApellido1(String apellido1)
    {
        this.apellido1 = apellido1;
    }

    public String getApellido2()
    {
        return apellido2;
    }

    public void setApellido2(String apellido2)
    {
        this.apellido2 = apellido2;
    }

    public String getCveEdoNac()
    {
        return cveEdoNac;
    }

    public void setCveEdoNac(String cveEdoNac)
    {
        this.cveEdoNac = cveEdoNac;
    }

    public String getFechaNac()
    {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac)
    {
        this.fechaNac = fechaNac;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    @Override
    public String toString()
    {
        return "Datos Obtenidos: "+ nombres + " " + apellido1 + " " +
                apellido2 + " nacio en " + cveEdoNac + " el " + fechaNac + " y es "+ sexo;
    }


}
