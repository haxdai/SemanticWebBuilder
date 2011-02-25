package mx.gob.stps.portalempleo.swb;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import mx.gob.stps.portalempleo.swb.Month.MonthOfYear;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;

public class EventManager extends mx.gob.stps.portalempleo.swb.base.EventManagerBase {
    private static Logger log = SWBUtils.getLogger(EventManager.class);

    public EventManager()
    {
    }

   /**
   * Constructs a EventManager with a SemanticObject
   * @param base The SemanticObject with the properties for the EventManager
   */
    public EventManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();

        if(wp instanceof Month) {
            final String modelId = wp.getWebSiteId();
            RequestDispatcher dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/event/list.jsp");
            try {
                dis.include(request, response);
            }catch (Exception e) {
                log.error(e);
            }
            String action = paramRequest.getAction();
            if(paramRequest.Action_ADD.equals(action)) {
                dis = request.getRequestDispatcher("/work/models/"+modelId+"/jsp/event/add.jsp");
                try {
                    dis.include(request, response);
                }catch (Exception e) {
                    log.error(e);
                }
            }else {
                out.println("<a href=\""+paramRequest.getRenderUrl().setAction(paramRequest.Action_ADD)+"\">agregar evento</a>");
            }
        }else {
            MonthOfYear moy = MonthOfYear.Enero;
            out.println("el valor ordinal de enero es "+moy.getDescription()+" "+moy.ordinal());
            try {
                moy = MonthOfYear.valueOf(null);
            }catch(IllegalArgumentException iae) {
                moy = null;
            }
        }
    }

}
