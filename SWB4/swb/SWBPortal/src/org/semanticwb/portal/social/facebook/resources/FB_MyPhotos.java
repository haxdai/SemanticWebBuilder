/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal.social.facebook.resources;

import org.semanticwb.portal.social.facebook.*;
import com.google.code.facebookapi.FacebookXmlRestClient;
import com.google.code.facebookapi.IFacebookRestClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.social.facebook.Photo;
import org.semanticwb.portal.social.facebook.util.FacebookUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jorge Jiménez
 */
public class FB_MyPhotos extends GenericAdmResource {

    private static Logger log = SWBUtils.getLogger(FB_MyPhotos.class);
    private static final String FACEBOOK_USER_CLIENT = "facebook.user.client";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            PrintWriter out = response.getWriter();
            FacebookUtils facebookUtils = new FacebookUtils();
            HttpSession session = request.getSession(true);
            IFacebookRestClient<Document> userClient = getUserClient(session);
            if (userClient != null) {
                long facebookUserID = userClient.users_getLoggedInUser();

                ArrayList<Photo> aPhotos = new ArrayList();
                Iterator<String> itAlbums = facebookUtils.getAlbums(userClient.photos_getAlbums(facebookUserID)).iterator();
                while (itAlbums.hasNext()) {
                    String aid = itAlbums.next();

                    Document domPhotos = userClient.photos_getByAlbum(new Long(aid).longValue());
                    
                    NodeList nListPhotos = domPhotos.getElementsByTagName("photo");
                    for (int a = 0; a < nListPhotos.getLength(); a++) {
                        Photo photo = new Photo();
                        NodeList nPhotoChilds = nListPhotos.item(a).getChildNodes();
                        for(int b=0;b<nPhotoChilds.getLength();b++)
                        {
                            Node nPhotoChild=nPhotoChilds.item(b);
                            if (nPhotoChild.getNodeName().equals("pid")) {
                                photo.setPid(nPhotoChild.getFirstChild().getNodeValue());
                            } else if (nPhotoChild.getNodeName().equals("aid") && nPhotoChild.getFirstChild() != null) {
                                photo.setAid(nPhotoChild.getFirstChild().getNodeValue());
                            } else if (nPhotoChild.getNodeName().equals("owner") && nPhotoChild.getFirstChild() != null) {
                                photo.setOwner(nPhotoChild.getFirstChild().getNodeValue());
                            } else if (nPhotoChild.getNodeName().equals("src_small") && nPhotoChild.getFirstChild() != null) {
                                photo.setSrc_small(nPhotoChild.getFirstChild().getNodeValue());
                            } else if (nPhotoChild.getNodeName().equals("src_big") && nPhotoChild.getFirstChild() != null) {
                                photo.setSrc_big(nPhotoChild.getFirstChild().getNodeValue());
                            } else if (nPhotoChild.getNodeName().equals("src") && nPhotoChild.getFirstChild() != null) {
                                photo.setSrc(nPhotoChild.getFirstChild().getNodeValue());
                            } else if (nPhotoChild.getNodeName().equals("link") && nPhotoChild.getFirstChild() != null) {
                                photo.setLink(nPhotoChild.getFirstChild().getNodeValue());
                            } else if (nPhotoChild.getNodeName().equals("caption") && nPhotoChild.getFirstChild() != null) {
                                photo.setCaption(nPhotoChild.getFirstChild().getNodeValue());
                            } else if (nPhotoChild.getNodeName().equals("created") && nPhotoChild.getFirstChild() != null) {
                                photo.setCreated(nPhotoChild.getFirstChild().getNodeValue());
                            } else if (nPhotoChild.getNodeName().equals("modified") && nPhotoChild.getFirstChild() != null) {
                                photo.setModified(nPhotoChild.getFirstChild().getNodeValue());
                            }
                        }
                        aPhotos.add(photo);
                    }
                }
                boolean flag = false;
                int cont = 0;
                out.println("<table>");
                Iterator<Photo> itusers = aPhotos.iterator();
                while (itusers.hasNext()) {
                    Photo photo = itusers.next();
                    if (!flag && cont == 0) {
                        out.println("<tr>");
                    }
                    cont++;
                    out.println("<td>");

                    out.println("<a href=\""+photo.getLink()+"\" target=\"_new\" text-decoration:none><img src=\"" + photo.getSrc() + "\"/></a><br>");
                    if (photo.getCaption() != null) {
                        out.println(photo.getCaption() + "<br>");
                    }
                    out.println("</td>");
                    if (cont == 4) {
                        out.println("</tr>");
                        cont = 0;
                        flag = false;
                    }
                }
                if (flag) {
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    static FacebookXmlRestClient getUserClient(HttpSession session) {
        return (FacebookXmlRestClient) session.getAttribute(FACEBOOK_USER_CLIENT);
    }
}


