/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.infotec.intranet.login;

import java.security.Provider.Service;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;

/**
 *
 * @author victor.lorenzana
 */
public class UserInformation
{

    private String login;
    private Attributes myAttrs;
    private String nombre, segundoNombre;
    private String pApellido, sApellido, tipoContratacion, puestoFuncion, rfc, curp;
    private Integer noempleado, area, especialidad, proyecto;
    private String sede, jefeInmediato, email;
    private GENERO genero;
    
    public String getFullName()
    {
        return (nombre==null?"":nombre) +" "+ (segundoNombre==null?"":segundoNombre) + (pApellido==null?"":pApellido) +" "+ (sApellido==null?"":sApellido); 
    }

    public UserInformation()
    {
    }

    public UserInformation(String login, String email, String nombre, String segundoNombre, String pApellido, String sApellido, String tipoContratacion, String puestoFuncion, String rfc, String curp, int noempleado, String sede, int area, int especialidad, int proyecto, String jefeInmediato)
    {
        this.login = login;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.tipoContratacion = tipoContratacion;
        this.puestoFuncion = puestoFuncion;
        this.rfc = rfc;
        this.curp = curp;
        this.sede = sede;
        this.area = area;
        this.especialidad = especialidad;
        this.proyecto = proyecto;
        this.jefeInmediato = jefeInmediato;
        this.email = email;

    }

    public Integer getArea()
    {
        return area;
    }

    public void setArea(Integer area)
    {
        if (area <= 0)
        {
            throw new IllegalArgumentException("El número de área no puede ser negativo o cero");
        }
        this.area = area;
    }

    public String getCurp()
    {
        return curp;
    }

    public void setCurp(String curp)
    {
        if (curp == null)
        {
            throw new IllegalArgumentException("El curp no puede ser nulo");
        }
        this.curp = curp;
    }

    public Integer getEspecialidad()
    {

        return especialidad;
    }

    public void setEspecialidad(Integer especialidad)
    {
        if (especialidad <= 0)
        {
            throw new IllegalArgumentException("El número de especialidad no puede ser negativo o cero");
        }
        this.especialidad = especialidad;
    }

    public String getJefeInmediato()
    {
        return jefeInmediato;
    }

    public void setSimpleJefeInmediato(String loginJefeInmediato)
    {
        this.jefeInmediato=loginJefeInmediato;
    }
    public void setJefeInmediato(String loginJefeInmediato)
    {
        if (loginJefeInmediato == null)
        {
            throw new IllegalArgumentException("El jefe inmediato no puede ser nulo");
        }
        if (!loginJefeInmediato.toLowerCase().startsWith("cn="))
        {
            Services s = new Services();
            String cnManager = s.getCNFromLogin(loginJefeInmediato);
            if (cnManager == null)
            {
                throw new IllegalArgumentException("No se encontro al jefe inmediato con login " + loginJefeInmediato);
            }
            this.jefeInmediato = cnManager;
        }
        else
        {
            this.jefeInmediato = loginJefeInmediato;
        }
    }

    public void setJefeInmediatoByCURP(String curp)
    {
        if (curp == null)
        {
            throw new IllegalArgumentException("El jefe inmediato no puede ser encontrado con curp nulo");
        }
        Services s = new Services();
        String cn = s.getCNFromCURP(curp);
        if (cn == null)
        {
            throw new IllegalArgumentException("No se ubico al jefe inmediato con CURP " + curp);
        }
        this.jefeInmediato = cn;
    }

    public void setJefeInmediatoByRFC(String rfc)
    {
        if (rfc == null)
        {
            throw new IllegalArgumentException("El jefe inmediato no puede ser encontrado con rfc nulo");
        }
        Services s = new Services();
        String cn = s.getCNFromRFC(rfc);
        if (cn == null)
        {
            throw new IllegalArgumentException("No se ubico al jefe inmediato con RFC " + rfc);
        }
        this.jefeInmediato = cn;
    }

    public Integer getNoempleado()
    {
        return noempleado;
    }

    public void setNoempleado(Integer noempleado)
    {
        if (noempleado != null && noempleado <= 0)
        {
            throw new IllegalArgumentException("El número de empleado no puede ser negativo o cero");
        }
        this.noempleado = noempleado;
    }

    public Integer getProyecto()
    {
        return proyecto;
    }

    public void setProyecto(Integer proyecto)
    {
        if (proyecto <= 0)
        {
            throw new IllegalArgumentException("El número de proyecto no puede ser negativo o cero");
        }
        this.proyecto = proyecto;
    }

    public String getSede()
    {
        return sede;
    }

    public void setSede(String sede)
    {
        if (sede == null)
        {
            throw new IllegalArgumentException("La sede no puede ser nulo");
        }
        this.sede = sede;
    }

    public void setTipoContratacion(String tipoContratacion)
    {
        if (tipoContratacion == null)
        {
            throw new IllegalArgumentException("El tipoContratacion no puede ser nulo");
        }
        this.tipoContratacion = tipoContratacion;
    }

    public void setTipoContratacion(TIPO_CONTRATACION tipoContratacion)
    {
        if (tipoContratacion == null)
        {
            throw new IllegalArgumentException("El tipoContratacion no puede ser nulo");
        }
        this.tipoContratacion = tipoContratacion.toString();


    }

    public void setPuestoFuncion(String puestoFuncion)
    {
        if (puestoFuncion == null)
        {
            throw new IllegalArgumentException("El puesto no puede ser nulo");
        }
        this.puestoFuncion = puestoFuncion;
    }

    public void setRFC(String rfc)
    {
        if (rfc == null)
        {
            throw new IllegalArgumentException("El rfc no puede ser nulo");
        }
        this.rfc = rfc;
    }

    public void check() throws ServiceException
    {
        if (login == null || login.length() == 0)
        {
            throw new ServiceException("El valor de login no puede ser nulo o longitud cero");
        }
        if (rfc == null || rfc.length() == 0)
        {
            throw new ServiceException("El valor de rfc no puede ser nulo o longitud cero");
        }
        if (email == null || email.length() == 0)
        {
            throw new ServiceException("El valor de email no puede ser nulo o longitud cero");
        }

        if (curp == null || curp.length() == 0)
        {
            throw new ServiceException("El valor de curp no puede ser nulo o longitud cero");
        }
        // El no_empleado puede ser nulo
        if (noempleado != null && noempleado <= 0)
        {
            throw new ServiceException("El valor de noempleado no puede ser negativo o cero");
        }
    }

    public void setLogin(String login)
    {
        if (login == null)
        {
            throw new IllegalArgumentException("El login no puede ser nulo");
        }
        this.login = login.replace('ñ', 'n');
    }

    public void setEmail(String email)
    {
        if (email == null)
        {
            throw new IllegalArgumentException("El email no puede ser nulo");
        }
        this.email = email;
    }

    public void setPrimerNombre(String nombre)
    {
        if (nombre == null)
        {
            throw new IllegalArgumentException("El primer nombre no puede ser nulo");
        }
        this.nombre = nombre;
    }

    public void setSegundoNombre(String segundoNombre)
    {
        if (segundoNombre == null)
        {
            throw new IllegalArgumentException("El segundo nombre no puede ser nulo");
        }
        this.segundoNombre = segundoNombre;
    }

    public void setpApellido(String pApellido)
    {
        if (pApellido == null)
        {
            throw new IllegalArgumentException("El primer apellido no puede ser nulo");
        }
        this.pApellido = pApellido;
    }

    public void setsApellido(String sApellido)
    {
        if (sApellido == null)
        {
            throw new IllegalArgumentException("El segundo apellido no puede ser nulo");
        }
        this.sApellido = sApellido;
    }

    public Integer getNoEmpleado()
    {
        return noempleado;
    }

    public String getLogin()
    {
        return login;
    }

    public String getEmail()
    {
        return email;
    }

    public String getRFC()
    {
        return rfc;
    }

    public String getCURP()
    {
        return curp;
    }

    public Map<String, String> getMapAttributes()
    {
        HashMap<String, String> values = new HashMap<String, String>();
        values.put(Services.getName(FIELD.TIPO_CONTRATACION), tipoContratacion);

        values.put(Services.getName(FIELD.PUESTO_FUNCION), puestoFuncion);

        values.put(Services.getName(FIELD.RFC), rfc.toUpperCase());
        values.put(Services.getName(FIELD.CURP), curp.toUpperCase());

        values.put(Services.getName(FIELD.SEDE), sede);

        values.put(Services.getName(FIELD.GENERO), this.genero.toString());


        if (noempleado != null)
        {
            values.put(Services.getName(FIELD.NO_EMPLEADO), String.valueOf(noempleado));
        }

        /*if(email!=null)
        values.put(Services.getName(FIELD.EMAIL),String.valueOf(email));*/

        values.put(Services.getName(FIELD.ESPECIALIDAD), String.valueOf(especialidad));


        values.put(Services.getName(FIELD.PROYECTO), String.valueOf(proyecto));


        values.put(Services.getName(FIELD.PRIMER_NOMBRE), String.valueOf(nombre));
        if (segundoNombre != null)
        {
            values.put(Services.getName(FIELD.SEGUNDO_NOMBRE), String.valueOf(segundoNombre));
        }

        values.put(Services.getName(FIELD.JEFE_INMEDIATO), String.valueOf(jefeInmediato));

        values.put(Services.getName(FIELD.PRIMER_APELLIDO), String.valueOf(this.pApellido));
        values.put(Services.getName(FIELD.SEGUNDO_APELLIDO), String.valueOf(this.sApellido));

        return values;
    }

    public GENERO getGenero()
    {
        return genero;
    }

    public void setGenero(GENERO genero)
    {

        this.genero = genero;
    }

    public Attributes getAttributes(Properties props)
    {
        myAttrs = new BasicAttributes(false);  // Case ignore



        BasicAttribute oc = new BasicAttribute(Services.getName(FIELD.NOMBRE_JUNTO));
        oc.add(this.nombre);
        myAttrs.put(oc);


        oc = new BasicAttribute(Services.getName(FIELD.PRIMER_APELLIDO));
        oc.add(pApellido);
        myAttrs.put(oc);

        oc = new BasicAttribute(Services.getName(FIELD.SEGUNDO_APELLIDO));
        oc.add(sApellido);
        myAttrs.put(oc);

        oc = new BasicAttribute(Services.getName(FIELD.TIPO_CONTRATACION));
        oc.add(tipoContratacion);
        myAttrs.put(oc);

        oc = new BasicAttribute(Services.getName(FIELD.PUESTO_FUNCION));
        oc.add(puestoFuncion);
        myAttrs.put(oc);


        oc = new BasicAttribute(Services.getName(FIELD.RFC));
        oc.add(rfc.toUpperCase());
        myAttrs.put(oc);


        oc = new BasicAttribute(Services.getName(FIELD.CURP));
        oc.add(curp.toUpperCase());
        myAttrs.put(oc);

        /*if(noempleado!=null)
        {
        oc = new BasicAttribute(Services.getName(FIELD.NO_EMPLEADO));
        oc.add(String.valueOf(noempleado));
        myAttrs.put(oc);
        }*/

        oc = new BasicAttribute(Services.getName(FIELD.SEDE));
        oc.add(sede);
        myAttrs.put(oc);

        /*oc = new BasicAttribute(Services.getName(FIELD.AREA));
        oc.add(area);
        myAttrs.put(oc);*/

        /*oc = new BasicAttribute(Services.getName(FIELD.ESPECIALIDAD));
        oc.add(especialidad);
        myAttrs.put(oc);*/

        /*oc = new BasicAttribute(Services.getName(FIELD.PROYECTO));
        oc.add(proyecto);
        myAttrs.put(oc);*/

        /*oc = new BasicAttribute(Services.getName(FIELD.JEFE_INMEDIATO));
        oc.add(jefeInmediato);
        myAttrs.put(oc);*/



        return myAttrs;
    }

    public String getPrimerNombre()
    {
        return nombre;
    }

    public String getSegundoNombre()
    {
        return segundoNombre;
    }

    public String getPApellido()
    {
        return pApellido;
    }

    public String getSApellido()
    {
        return sApellido;
    }

    public TIPO_CONTRATACION getTipoContratacion()
    {
        if(tipoContratacion==null)
        {
            return null;
        }
        else
        {
            return TIPO_CONTRATACION.valueOf(tipoContratacion.replace('ó', 'o'));            
        }
    }
    public String getPuestoFuncion()
    {
        return puestoFuncion;
    }
}
