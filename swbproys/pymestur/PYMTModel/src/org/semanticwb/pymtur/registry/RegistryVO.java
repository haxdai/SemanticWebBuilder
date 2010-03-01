
package org.semanticwb.pymtur.registry;


/**
 * Almacena los datos relacionados al registro de la empresa, para su facilidad
 * de presentacion en las pantallas utilizadas para el registro y modificacion
 * de datos.
 * @author jose.jimenez
 */
public class RegistryVO {


    /**
     * Tipo de paquete a contratar
     */
    private int paquete = 0;

    /**
     * Tiempo de publicacion contratado
     */
    private int tiempoPublicacion = 0;

    /**
     * Banco en que se realizo el pago correspondiente
     */
    private String banco = "";

    /**
     * Numero de cuenta con que se realizo el pago
     */
    private String cuentaBanco = "";

    /**
     * CLABE de la cuenta con que se realizo el pago
     */
    private String clabeBanco = "";

    /**
     * Referencia de la cuenta de banco para el pago
     */
    private String referenciaBanco = "";

    /**
     * Nombre de usuario para el registro
     */
    private String nombreUsuario = "";

    /**
     * Contraseña de usuario para el registro
     */
    private String contrasenia = "";

    /**
     * Razon Social de la empresa a registrar
     */
    private String razonSocial = "";

    /**
     * Calle del domicilio de la empresa
     */
    private String calle = "";

    /**
     * Colonia del domicilio de la empresa
     */
    private String colonia = "";

    /**
     * Codigo postal del domicilio de la empresa
     */
    private String cp = "";

    /**
     * Estado del domicilio de la empresa
     */
    private int estado = 0;

    /**
     * Municipio del estado de la empresa
     */
    private int municipio = 0;

    /**
     * Ciudad del domicilio de la empresa
     */
    private String ciudad = "";

    /**
     * Giro de la empresa
     */
    private String giro = "";

    /**
     * Tipo de la empresa a registrar, segun el giro
     */
    private String tipoEmpresa = "";

    /**
     * Claves de los servicios que proporciona la empresa, separadas por coma,
     * de acuerdo al tipo de empresa
     */
    private String servicios = "";

    /**
     * Claves de las instalaciones con que cuenta la empresa, separadas por coma,
     * de acuerdo al tipo de empresa
     */
    private String instalaciones = "";

    /**
     * RFC de la empresa a registrar
     */
    private String rfc = "";

    /**
     * Calle del domicilio fiscal de la empresa
     */
    private String calleFiscal = "";

    /**
     * Colonia del domicilio fiscal de la empresa
     */
    private String coloniaFiscal = "";

    /**
     * Codigo postal del domicilio fiscal de la empresa
     */
    private String cpFiscal = "";

    /**
     * Estado del domicilio fiscal de la empresa
     */
    private int estadoFiscal = 0;

    /**
     * Municipio del domicilio fiscal de la empresa
     */
    private int municipioFiscal = 0;

    /**
     * Ciudad del domicilio fiscal de la empresa
     */
    private String ciudadFiscal = "";

    /**
     * Nombre de la persona de contacto de la empresa
     */
    private String nombre = "";

    /**
     * Apellido paterno de la persona de contacto de la empresa
     */
    private String paterno = "";

    /**
     * Apellido materno de la persona de contacto de la empresa
     */
    private String materno = "";

    /**
     * Cuenta de correo electronico de la persona de contacto de la empresa
     */
    private String correo = "";

    /**
     * Clave de larga distancia del telefono de contacto de la empresa
     */
    private String lada = "";

    /**
     * Numero telefonico de contacto de la empresa
     */
    private String telefono = "";

    
    public RegistryVO() {}
    
    public RegistryVO(int paquete, int tiempoPublicacion, String banco,
            String cuentaBanco, String clabeBanco, String referenciaBanco,
            String nombreUsuario, String contrasenia, String razonSocial,
            String calle, String colonia, String cp, int estado, int municipio,
            String ciudad, String giro, String tipoEmpresa, String servicios,
            String instalaciones, String rfc, String calleFiscal, String coloniaFiscal,
            String cpFiscal, int estadoFiscal, int municipioFiscal, String ciudadFiscal,
            String nombre, String paterno, String materno, String correo, String lada,
            String telefono) {
        this.setPaquete(paquete);
        this.setTiempoPublicacion(tiempoPublicacion);
        this.setBanco(banco);
        this.setCuentaBanco(cuentaBanco);
        this.setClabeBanco(cuentaBanco);
        this.setReferenciaBanco(referenciaBanco);
        this.setNombreUsuario(nombreUsuario);
        this.setContrasenia(contrasenia);
        this.setRazonSocial(razonSocial);
        this.setCalle(calle);
        this.setColonia(colonia);
        this.setCp(cp);
        this.setEstado(estado);
        this.setMunicipio(municipio);
        this.setCiudad(ciudad);
        this.setGiro(giro);
        this.setTipoEmpresa(tipoEmpresa);
        this.setServicios(servicios);
        this.setInstalaciones(instalaciones);
        this.setRfc(rfc);
        this.setCalleFiscal(calleFiscal);
        this.setColoniaFiscal(coloniaFiscal);
        this.setCpFiscal(cpFiscal);
        this.setEstadoFiscal(estadoFiscal);
        this.setMunicipioFiscal(municipioFiscal);
        this.setCiudadFiscal(ciudadFiscal);
        this.setNombre(nombre);
        this.setPaterno(paterno);
        this.setMaterno(materno);
        this.setCorreo(correo);
        this.setLada(lada);
        this.setTelefono(telefono);
    }

    /**
     * Tipo de paquete a contratar
     * @return the paquete
     */
    public int getPaquete() {
        return paquete;
    }

    /**
     * Tipo de paquete a contratar
     * @param paquete the paquete to set
     */
    public void setPaquete(int paquete) {
        if (paquete >= 0 && paquete < 5) {
            this.paquete = paquete;
        }
    }

    /**
     * Tiempo de publicacion contratado
     * @return the tiempoPublicacion
     */
    public int getTiempoPublicacion() {
        return tiempoPublicacion;
    }

    /**
     * Tiempo de publicacion contratado
     * @param tiempoPublicacion the tiempoPublicacion to set
     */
    public void setTiempoPublicacion(int tiempoPublicacion) {
        if (tiempoPublicacion > 0 && tiempoPublicacion < 13) {
            this.tiempoPublicacion = tiempoPublicacion;
        }
    }

    /**
     * Banco en que se realizo el pago correspondiente
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Banco en que se realizo el pago correspondiente
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        if (banco != null && !banco.equalsIgnoreCase("null")) {
            this.banco = banco;
        }
    }

    /**
     * Numero de cuenta con que se realizo el pago
     * @return the cuentaBanco
     */
    public String getCuentaBanco() {
        return cuentaBanco;
    }

    /**
     * Numero de cuenta con que se realizo el pago
     * @param cuentaBanco the cuentaBanco to set
     */
    public void setCuentaBanco(String cuentaBanco) {
        if (cuentaBanco != null && !cuentaBanco.equalsIgnoreCase("null")) {
            this.cuentaBanco = cuentaBanco;
        }
    }

    /**
     * CLABE de la cuenta con que se realizo el pago
     * @return the clabeBanco
     */
    public String getClabeBanco() {
        return clabeBanco;
    }

    /**
     * CLABE de la cuenta con que se realizo el pago
     * @param clabeBanco the clabeBanco to set
     */
    public void setClabeBanco(String clabeBanco) {
        if (clabeBanco != null && !clabeBanco.equalsIgnoreCase("null")) {
            this.clabeBanco = clabeBanco;
        }
    }

    /**
     * Referencia de la cuenta de banco para el pago
     * @return the referenciaBanco
     */
    public String getReferenciaBanco() {
        return referenciaBanco;
    }

    /**
     * Referencia de la cuenta de banco para el pago
     * @param referenciaBanco the referenciaBanco to set
     */
    public void setReferenciaBanco(String referenciaBanco) {
        if (referenciaBanco != null && !referenciaBanco.equalsIgnoreCase("null")) {
            this.referenciaBanco = referenciaBanco;
        }
    }

    /**
     * Nombre de usuario para el registro
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Nombre de usuario para el registro
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario != null && !nombreUsuario.equalsIgnoreCase("null")) {
            this.nombreUsuario = nombreUsuario;
        }
    }

    /**
     * Contraseña de usuario para el registro
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Contraseña de usuario para el registro
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        if (contrasenia != null && !contrasenia.equalsIgnoreCase("null")) {
            this.contrasenia = contrasenia;
        }
    }

    /**
     * Razon Social de la empresa a registrar
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Razon Social de la empresa a registrar
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        if (razonSocial != null && !razonSocial.equalsIgnoreCase("null")) {
            this.razonSocial = razonSocial;
        }
    }

    /**
     * Calle del domicilio de la empresa
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Calle del domicilio de la empresa
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        if (calle != null && !calle.equalsIgnoreCase("null")) {
            this.calle = calle;
        }
    }

    /**
     * Colonia del domicilio de la empresa
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Colonia del domicilio de la empresa
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        if (colonia != null && !colonia.equalsIgnoreCase("null")) {
            this.colonia = colonia;
        }
    }

    /**
     * Codigo postal del domicilio de la empresa
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * Codigo postal del domicilio de la empresa
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        if (cp != null && !cp.equalsIgnoreCase("null")) {
            this.cp = cp;
        }
    }

    /**
     * Estado del domicilio de la empresa
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Estado del domicilio de la empresa
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        if (estado > 0) {
            this.estado = estado;
        }
    }

    /**
     * Municipio del estado de la empresa
     * @return the municipio
     */
    public int getMunicipio() {
        return municipio;
    }

    /**
     * Municipio del estado de la empresa
     * @param municipio the municipio to set
     */
    public void setMunicipio(int municipio) {
        if (municipio > 0) {
            this.municipio = municipio;
        }
    }

    /**
     * Ciudad del domicilio de la empresa
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Ciudad del domicilio de la empresa
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        if (ciudad != null && !ciudad.equalsIgnoreCase("null")) {
            this.ciudad = ciudad;
        }
    }

    /**
     * Giro de la empresa
     * @return the giro
     */
    public String getGiro() {
        return giro;
    }

    /**
     * Giro de la empresa
     * @param giro the giro to set
     */
    public void setGiro(String giro) {
        if (giro != null && !giro.equalsIgnoreCase("null")) {
            this.giro = giro;
        }
    }

    /**
     * Tipo de la empresa a registrar, segun el giro
     * @return the tipoEmpresa
     */
    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    /**
     * Tipo de la empresa a registrar, segun el giro
     * @param tipoEmpresa the tipoEmpresa to set
     */
    public void setTipoEmpresa(String tipoEmpresa) {
        if (tipoEmpresa != null && !tipoEmpresa.equalsIgnoreCase("null")) {
            this.tipoEmpresa = tipoEmpresa;
        }
    }

    /**
     * Claves de los servicios que proporciona la empresa, separadas por coma,
     * de acuerdo al tipo de empresa
     * @return the servicios
     */
    public String getServicios() {
        return servicios;
    }

    /**
     * Claves de los servicios que proporciona la empresa, separadas por coma,
     * de acuerdo al tipo de empresa
     * @param servicios the servicios to set
     */
    public void setServicios(String servicios) {
        if (servicios != null && !servicios.equalsIgnoreCase("null")) {
            this.servicios = servicios;
        }
    }

    /**
     * Claves de las instalaciones con que cuenta la empresa, separadas por coma,
     * de acuerdo al tipo de empresa
     * @return the instalaciones
     */
    public String getInstalaciones() {
        return instalaciones;
    }

    /**
     * Claves de las instalaciones con que cuenta la empresa, separadas por coma,
     * de acuerdo al tipo de empresa
     * @param instalaciones the instalaciones to set
     */
    public void setInstalaciones(String instalaciones) {
        if (instalaciones != null && !instalaciones.equalsIgnoreCase("null")) {
            this.instalaciones = instalaciones;
        }
    }

    /**
     * RFC de la empresa a registrar
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * RFC de la empresa a registrar
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        if (rfc != null && !rfc.equalsIgnoreCase("null")) {
            this.rfc = rfc;
        }
    }

    /**
     * Calle del domicilio fiscal de la empresa
     * @return the calleFiscal
     */
    public String getCalleFiscal() {
        return calleFiscal;
    }

    /**
     * Calle del domicilio fiscal de la empresa
     * @param calleFiscal the calleFiscal to set
     */
    public void setCalleFiscal(String calleFiscal) {
        if (calleFiscal != null && !calleFiscal.equalsIgnoreCase("null")) {
            this.calleFiscal = calleFiscal;
        }
    }

    /**
     * Colonia del domicilio fiscal de la empresa
     * @return the coloniaFiscal
     */
    public String getColoniaFiscal() {
        return coloniaFiscal;
    }

    /**
     * Colonia del domicilio fiscal de la empresa
     * @param coloniaFiscal the coloniaFiscal to set
     */
    public void setColoniaFiscal(String coloniaFiscal) {
        if (coloniaFiscal != null && !coloniaFiscal.equalsIgnoreCase("null")) {
            this.coloniaFiscal = coloniaFiscal;
        }
    }

    /**
     * Codigo postal del domicilio fiscal de la empresa
     * @return the cpFiscal
     */
    public String getCpFiscal() {
        return cpFiscal;
    }

    /**
     * Codigo postal del domicilio fiscal de la empresa
     * @param cpFiscal the cpFiscal to set
     */
    public void setCpFiscal(String cpFiscal) {
        if (cpFiscal != null && !cpFiscal.equalsIgnoreCase("null")) {
            this.cpFiscal = cpFiscal;
        }
    }

    /**
     * Estado del domicilio fiscal de la empresa
     * @return the estadoFiscal
     */
    public int getEstadoFiscal() {
        return estadoFiscal;
    }

    /**
     * Estado del domicilio fiscal de la empresa
     * @param estadoFiscal the estadoFiscal to set
     */
    public void setEstadoFiscal(int estadoFiscal) {
        if (estadoFiscal > 0) {
            this.estadoFiscal = estadoFiscal;
        }
    }

    /**
     * Municipio del domicilio fiscal de la empresa
     * @return the municipioFiscal
     */
    public int getMunicipioFiscal() {
        return municipioFiscal;
    }

    /**
     * Municipio del domicilio fiscal de la empresa
     * @param municipioFiscal the municipioFiscal to set
     */
    public void setMunicipioFiscal(int municipioFiscal) {
        if (municipioFiscal > 0) {
            this.municipioFiscal = municipioFiscal;
        }
    }

    /**
     * Ciudad del domicilio fiscal de la empresa
     * @return the ciudadFiscal
     */
    public String getCiudadFiscal() {
        return ciudadFiscal;
    }

    /**
     * Ciudad del domicilio fiscal de la empresa
     * @param ciudadFiscal the ciudadFiscal to set
     */
    public void setCiudadFiscal(String ciudadFiscal) {
        if (ciudadFiscal != null && !ciudadFiscal.equalsIgnoreCase("null")) {
            this.ciudadFiscal = ciudadFiscal;
        }
    }

    /**
     * Nombre de la persona de contacto de la empresa
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Nombre de la persona de contacto de la empresa
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.equalsIgnoreCase("null")) {
            this.nombre = nombre;
        }
    }

    /**
     * Apellido paterno de la persona de contacto de la empresa
     * @return the paterno
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     * Apellido paterno de la persona de contacto de la empresa
     * @param paterno the paterno to set
     */
    public void setPaterno(String paterno) {
        if (paterno != null && !paterno.equalsIgnoreCase("null")) {
            this.paterno = paterno;
        }
    }

    /**
     * Apellido materno de la persona de contacto de la empresa
     * @return the materno
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * Apellido materno de la persona de contacto de la empresa
     * @param materno the materno to set
     */
    public void setMaterno(String materno) {
        if (materno != null && !materno.equalsIgnoreCase("null")) {
            this.materno = materno;
        }
    }

    /**
     * Cuenta de correo electronico de la persona de contacto de la empresa
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Cuenta de correo electronico de la persona de contacto de la empresa
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        if (correo != null && !correo.equalsIgnoreCase("null")) {
            this.correo = correo;
        }
    }

    /**
     * Clave de larga distancia del telefono de contacto de la empresa
     * @return the lada
     */
    public String getLada() {
        return lada;
    }

    /**
     * Clave de larga distancia del telefono de contacto de la empresa
     * @param lada the lada to set
     */
    public void setLada(String lada) {
        if (lada != null && !lada.equalsIgnoreCase("null")) {
            this.lada = lada;
        }
    }

    /**
     * Numero telefonico de contacto de la empresa
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Numero telefonico de contacto de la empresa
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.equalsIgnoreCase("null")) {
            this.telefono = telefono;
        }
    }

    
}
