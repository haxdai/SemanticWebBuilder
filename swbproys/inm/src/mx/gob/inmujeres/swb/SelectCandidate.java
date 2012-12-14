package mx.gob.inmujeres.swb;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mx.gob.inmujeres.swb.resources.sem.base.Autentificacion;
import mx.gob.inmujeres.swb.resources.sem.base.UserSubordinado;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

/**
 * Seleciona un candidato a evaluar
 */
public class SelectCandidate extends mx.gob.inmujeres.swb.base.SelectCandidateBase
{

    public SelectCandidate(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    private boolean isSubordinado(User candidato, List<UserSubordinado> subordinados)
    {
        for (UserSubordinado userSubordinado : subordinados)
        {
            if (userSubordinado.getLogin().equals(candidato.getLogin()))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean filterObject(HttpServletRequest request, SemanticObject obj, SemanticObject filter, SemanticProperty prop, String propName, String type, String mode, String lang)
    {
        Principal principal = request.getUserPrincipal();
        if (principal instanceof User)
        {
            User evaluador = (User) principal;
            String login = evaluador.getLogin();
            Autentificacion aut = new Autentificacion();
            List<UserSubordinado> subordinados = aut.getSubordinados(login);
            GenericObject go = obj.getGenericInstance();
            if (go instanceof User)
            {
                User user = (User) go;
                return isSubordinado(user, subordinados);
            }
            else
            {
                return true;
            }
        }
        return true;
    }
}
