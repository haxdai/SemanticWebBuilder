/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.gob.inmujeres.swb.resources.sem.base;

/**
 *
 * @author gabriela.rosales
 */
public class UserLogin {

        private String nombre;
        private String noEmpleado;
        private String areaAdscripcion;
        private String puesto;
        private String nivel;
        private String extension;

        public UserLogin()
        {
        }

    public UserLogin(String nombre, String noEmpleado, String areaAdscripcion, String puesto, String nivel, String extension) {
        this.nombre = nombre;
        this.noEmpleado = noEmpleado;
        this.areaAdscripcion = areaAdscripcion;
        this.puesto = puesto;
        this.nivel = nivel;
        this.extension = extension;
    }

    public String getAreaAdscripcion() {
        return areaAdscripcion;
    }

    public void setAreaAdscripcion(String areaAdscripcion) {
        this.areaAdscripcion = areaAdscripcion;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(String noEmpleado) {
        this.noEmpleado = noEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario: " +" "+ "Nombre=" +" "+ nombre +" "+ "Numero de Empleado=" +" "+ noEmpleado + " "+"Area Adscripcion=" +" "+ areaAdscripcion + " "+"Puesto=" +" "+ puesto +" "+ "Nivel=" + " "+nivel +" "+ "Extension=" + " "+extension;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


        


}
