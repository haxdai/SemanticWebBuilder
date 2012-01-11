package com.infotec.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.resources.sem.AudioFile;

/**
 *
 * @author carlos.ramos
 */
public class FavoriteAudios extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(FavoriteAudios.class);
    public static final int MIN_LIST = 5;
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=UTF-8");
        Resource base = getResourceBase();
        String lang = paramRequest.getUser().getLanguage();

        PrintWriter out =  response.getWriter();

        Iterator<AudioFile> iresources = AudioFile.ClassMgr.listAudioFiles(base.getWebSite());
        List resources = SWBUtils.Collections.copyIterator(iresources);
        Collections.sort(resources, new AudioFile.SortByRanking());
        iresources = resources.iterator();
        int min = 0;
        while(min<MIN_LIST && iresources.hasNext()) {
            AudioFile audio = iresources.next();
            out.println(audio.getDisplayTitle(lang));
            out.println(audio.getDisplayDescription(lang));
            min++;
        }
    }
    
}
