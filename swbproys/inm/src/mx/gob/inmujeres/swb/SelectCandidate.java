package mx.gob.inmujeres.swb;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import mx.gob.inmujeres.swb.resources.sem.base.Autentificacion;
import mx.gob.inmujeres.swb.resources.sem.base.UserSubordinado;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.DisplayProperty;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.Trashable;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticModel;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

/**
 * Seleciona un candidato a evaluar
 */
public class SelectCandidate extends mx.gob.inmujeres.swb.base.SelectCandidateBase
{

    static
    {
    }
    static Logger log = SWBUtils.getLogger(SelectCandidate.class);

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
                return true;
            }
        }
        return false;
    }

    private boolean isEvaluado(User evaluador, User evaluado)
    {
        boolean isEvaluado = false;

        int anio = Calendar.getInstance().get(Calendar.YEAR);

        Iterator<EvaluacionDesempenio> values = EvaluacionDesempenio.ClassMgr.listEvaluacionDesempenios();
        while (values.hasNext())
        {
            EvaluacionDesempenio evaluacionDesempenio = values.next();
            if (evaluacionDesempenio.isValid())
            {


                Desempenio desempenio = evaluacionDesempenio.getDesempeño();
                if (desempenio != null && desempenio.isValid())
                {
                    if (evaluador.equals(desempenio.getEvaluador()) && evaluado.equals(desempenio.getEvaluado()) && anio == desempenio.getAnio())
                    {
                        if (evaluacionDesempenio.getStatus() == 0)
                        {
                            return false;
                        }
                        else
                        {
                            return true;
                        }
                    }
                }
            }
        }

        return isEvaluado;
    }

    @Override
    public boolean filterObject(HttpServletRequest request, SemanticObject obj, SemanticObject filter, SemanticProperty prop, String propName, String type, String mode, String lang)
    {
        User evaluador = SWBContext.getSessionUser();
        Autentificacion aut = new Autentificacion();
        List<UserSubordinado> subordinados = aut.getSubordinados(evaluador.getLogin() + "@inmujeres.local");
        //List<UserSubordinado> subordinados = aut.getSubordinados(evaluador.getLogin());
        GenericObject go = filter.createGenericInstance();

        if (go instanceof User)
        {
            User user = (User) go;

            if (isSubordinado(user, subordinados))
            {
                if (!isEvaluado(evaluador, user))
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return true;
            }
            //return isSubordinado(user, subordinados);// && !isEvaluado(user);

        }
        else
        {
            return true;
        }


    }

    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type,
            String mode, String lang)
    {
        //User evaluador = SWBContext.getSessionUser();

        //String login = evaluador.getLogin();
        //Autentificacion aut = new Autentificacion();
        //List<UserSubordinado> subordinados = aut.getSubordinados(login);
        /*for (UserSubordinado subordinado : subordinados)
        {
        try
        {
        evaluador.getUserRepository().getUserByLogin(subordinado.getLogin());
        }
        catch (Exception e)
        {
        log.error("Error cargando subordinados login: " + subordinado.getLogin(), e);

        }
        }*/
        if (obj == null)
        {
            obj = new SemanticObject();
        }

//        boolean IPHONE = false;
//        boolean XHTML  = false;
        boolean DOJO = false;

//        if (type.equals("iphone")) {
//            IPHONE = true;
//        } else if (type.equals("xhtml")) {
//            XHTML = true;
//        } else
        if (type.equals("dojo"))
        {
            DOJO = true;
        }

        StringBuilder ret = new StringBuilder();
        String name = propName;
        String label = prop.getDisplayName(lang);
        SemanticObject sobj = prop.getDisplayProperty();
        boolean required = prop.isRequired();
        String pmsg = null;
        String imsg = null;
        String selectValues = null;
        boolean disabled = false;

        if (sobj != null)
        {
            DisplayProperty dobj = new DisplayProperty(sobj);

            pmsg = dobj.getPromptMessage();
            imsg = dobj.getInvalidMessage();
            selectValues = dobj.getDisplaySelectValues(lang);
            disabled = dobj.isDisabled();
        }

        /*
        System.out.println("prop:"+prop);
        System.out.println("sobj:"+sobj);
        System.out.println("selectValues:"+selectValues);
         */
        if (DOJO)
        {
            if (imsg == null)
            {
                if (required)
                {
                    imsg = label + " es requerido.";

                    if (lang.equals("en"))
                    {
                        imsg = label + " is required.";
                    }
                }
                else
                {
                    imsg = "Dato invalido.";

                    if (lang.equals("en"))
                    {
                        imsg = "Invalid data.";
                    }
                }
            }

            if (pmsg == null)
            {
                pmsg = "Captura " + label + ".";

                if (lang.equals("en"))
                {
                    pmsg = "Enter " + label + ".";
                }
            }
        }

        String ext = "";

        if (disabled)
        {
            ext += " disabled=\"disabled\"";
        }

        if (prop.isObjectProperty())
        {
            SemanticObject val = null;
            String aux = request.getParameter(propName);

            if (aux != null)
            {
                val = SemanticObject.createSemanticObject(aux);
            }
            else
            {
                val = obj.getObjectProperty(prop);
            }

            String uri = "";
            String value = "";

            if (val != null)
            {
                uri = val.getURI();
                value = val.getDisplayName(lang);
            }

            if (mode.equals("edit") || mode.equals("create") || mode.equals("filter"))
            {
                ret.append("<select name=\"" + name + "\"");

                if (DOJO)
                {
                    ret.append(" dojoType=\"dijit.form.FilteringSelect\" autoComplete=\"true\" invalidMessage=\""
                            + imsg + "\"" + " value=\"" + uri + "\"");
                }

                if (!mode.equals("filter"))
                {
                    ret.append(" required=\"" + required + "\"");
                }

                if ((mode.equals("filter") || isBlankSuport()) && ((uri == null) || (uri.length() == 0)))
                {
                    ret.append(" displayedvalue=\"\"");
                }

                ret.append(" " + ext + ">");

                // onChange="dojo.byId('oc1').value=arguments[0]"
                if ((mode.equals("filter") || isBlankSuport()))
                {
                    ret.append("<option");

                    // if(uri==null || uri.length()==0)ret.append(" selected");
                    ret.append(" value=\"\"></option>");
                }

                SemanticClass cls = prop.getRangeClass();
                Iterator<SemanticObject> it = null;

                if (isGlobalScope())
                {
                    if (cls != null)
                    {
                        it = SWBComparator.sortSermanticObjects(lang, cls.listInstances());
                    }
                    else
                    {
                        it = SWBComparator.sortSermanticObjects(lang,
                                SWBPlatform.getSemanticMgr().getVocabulary().listSemanticClassesAsSemanticObjects());
                    }
                }
                else if (isUserRepository())
                {
                    SemanticModel model = getModel();
                    SWBModel m = (SWBModel) model.getModelObject().createGenericInstance();

                    if (m instanceof WebSite)
                    {
                        m = ((WebSite) m).getUserRepository();
                        model = m.getSemanticObject().getModel();
                    }

                    it = SWBComparator.sortSermanticObjects(lang, model.listInstancesOfClass(cls));
                }
                else
                {
                    SemanticModel model = getModel();
                    SWBModel m = (SWBModel) model.getModelObject().createGenericInstance();

                    if (m instanceof UserRepository)
                    {
                        SWBModel p = m.getParentWebSite();
                        if (p != null)
                        {
                            m = p;
                        }
                        model = m.getSemanticObject().getModel();
                    }

                    it = SWBComparator.sortSermanticObjects(lang, model.listInstancesOfClass(cls));
                }

                if (it != null)
                {
                    while (it.hasNext())
                    {
                        SemanticObject sob = it.next();
                        boolean deleted = false;
                        if (sob.instanceOf(Trashable.swb_Trashable))
                        {
                            deleted = sob.getBooleanProperty(Trashable.swb_deleted);
                        }

                        if (filterObject(request, sobj, sob, prop, propName, type, mode, lang))
                        {
                            continue;
                        }

                        if (!deleted)
                        {
                            // System.out.println("display:"+sob.getDisplayName(lang));
                            if (sob.getURI() != null)
                            {
                                ret.append("<option value=\"" + sob.getURI() + "\" ");

                                if (sob.getURI().equals(uri))
                                {
                                    ret.append("selected=\"selected\"");
                                }
                                GenericObject go = sob.createGenericInstance();
                                if (go != null && go instanceof User)
                                {
                                    User user = (User) go;
                                    ret.append(">" + user.getFullName() + "</option>");
                                }
                                else
                                {
                                    ret.append(">" + sob.getDisplayName(lang) + "</option>");
                                }
                            }
                        }
                    }
                }

                ret.append("</select>");
            }
            else if (mode.equals("view"))
            {
                ret.append("<span _id=\"" + name + "\" name=\"" + name + "\">" + value + "</span>");
            }
        }
        else
        {
            if (selectValues != null)
            {
                String value = request.getParameter(propName);

                if (value == null)
                {
                    value = obj.getProperty(prop);
                }

                ret.append("<select name=\"" + name + "\"");

                if (DOJO)
                {
                    ret.append(" dojoType=\"dijit.form.FilteringSelect\" autoComplete=\"true\" invalidMessage=\""
                            + imsg + "\"");
                }

                ret.append(" " + ext + ">");

                StringTokenizer st = new StringTokenizer(selectValues, "|");

                while (st.hasMoreTokens())
                {
                    String tok = st.nextToken();
                    int ind = tok.indexOf(':');
                    String id = tok;
                    String val = tok;

                    if (ind > 0)
                    {
                        id = tok.substring(0, ind);
                        val = tok.substring(ind + 1);
                    }

                    ret.append("<option value=\"" + id + "\" ");

                    if (id.equals(value))
                    {
                        ret.append("selected");
                    }

                    ret.append(">" + val + "</option>");
                }

                ret.append("</select>");
            }
        }

        return ret.toString();
    }
}
