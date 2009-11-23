package org.semanticwb.portal.community;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;


public class DirectoryObject extends org.semanticwb.portal.community.base.DirectoryObjectBase 
{
    private static Logger log = SWBUtils.getLogger(DirectoryObject.class);
    
    public DirectoryObject(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /**
     * Muestra la información utilizada por las herramientas o recursos generales para
     * los elementos de comunidades, como calificar y reporte de abuso sobre el elemento
     * o comentarios relacionados al mismo.
     * @param request petición del usuario a atender
     * @param out para agregar los datos a desplegar
     * @param paramRequest para obtener referencias a objetos internos
     * @throws org.semanticwb.portal.api.SWBResourceException
     * @throws java.io.IOException
     */
    public void renderGenericElements(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {


        String path="/swbadmin/jsp/microsite/RenderGenericElements/RenderDirObjElements.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        try
        {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("DirectoryObject", this);
            dis.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    /**
     * Indica si el <code>User</code> recibido puede ver y agregar comentarios
     * @param ele
     * @param mem
     * @return <code>true</code> si el usuario tiene derecho a ver y agregar el elemento,
     * <code>false</code> de lo contrario.
     */
    public boolean canComment(User mem) {

        boolean ret = false;
        if (mem.isSigned()) {
            ret = true;
        }
        return ret;
    }

    public boolean canClaim(User mem) {
        boolean ret = false;
        if (getSemanticObject().instanceOf(Claimable.swbcomm_Claimable)) {
            if (mem.isSigned()) {
                if (!getCreator().equals(mem)) {
                    User claimer = (User)getSemanticObject().getObjectProperty(Claimable.swbcomm_claimer).createGenericInstance();
                    if (claimer == null) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }
}
