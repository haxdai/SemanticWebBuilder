
package com.infotec.eworkplace.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author carlos.ramos
 */


public class Notice extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(Notice.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        User user = paramsRequest.getUser();
        if(user.haveAccess(base) && base.getExpiration()!=null && base.getExpiration().after(new Date())) {
            PrintWriter out = response.getWriter();
            String url = base.getAttribute("url");
            if(url!=null && !url.isEmpty()) {
                out.print("<a href=\""+url+"\" title=\"Ver m&aacute;s\"></a>");
            }else {
                out.print(base.getAttribute("msg",""));
            }
        }else {
            log.info("user.haveAccess("+base.getTitle()+")="+user.haveAccess(base));
            log.info(base.getTitle()+".getExpiration()="+base.getExpiration());
        }
    }
}
