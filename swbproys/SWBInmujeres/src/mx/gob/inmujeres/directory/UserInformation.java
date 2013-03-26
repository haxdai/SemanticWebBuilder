package mx.gob.inmujeres.directory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author victor.lorenzana
 */
public class UserInformation
{

    public String nombre;
    public String login;
    public String mail;
    public String apellidos;
    public String departamento;
    public String telefono;
    public String street;
    public String city;
    public String CP;
    public String estado;
    public String pais;
    public String office;
    public String initials;
    public String description;
    public String webpage;
    public String title;
    public String manager;

    public static UserInformation getUserInformation(String login, Map<String, String> values)
    {
        UserInformation user = new UserInformation();
        user.login = login;
        user.nombre = values.get("givenName");
        user.apellidos = values.get("sn");
        user.mail = values.get("mail");
        user.departamento = values.get("department");
        user.telefono = values.get("telephoneNumber");
        user.street = values.get("street");
        user.city = values.get("l");
        user.CP = values.get("postalCode");
        user.estado = values.get("st");
        user.pais = values.get("co");
        user.office = values.get("physicaldeliveryofficename");
        user.initials = values.get("initials");
        user.description = values.get("description");
        user.webpage = values.get("wWWHomePage");
        user.title = values.get("title");
        user.manager = values.get("manager");
        return user;
    }

    public static List<UserInformation> ordena(List<UserInformation> users)
    {
        if (users != null)
        {
            Collections.sort(users, new Comparator<UserInformation>()
            {

                public int compare(UserInformation o1, UserInformation o2)
                {
                    return o1.apellidos.compareToIgnoreCase(o2.apellidos);
                }
            });
        }
        return users;
    }
}
