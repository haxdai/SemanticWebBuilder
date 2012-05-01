package org.semanticwb.social;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.photos.upload.UploadInterface;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import com.flickr4java.flickr.util.IOUtilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.io.SWBFile;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.SWBActionResponse;
import org.xml.sax.SAXException;


public class Flicker extends org.semanticwb.social.base.FlickerBase 
{
    Logger log = SWBUtils.getLogger(Flicker.class);
    SWBFlickrOauth oauthConnection = new SWBFlickrOauth();

    // Utilizado para loguearse con OAuth
    public String getCredentials(String uri, WebPage wp, String scheme) throws IOException{
        String url2 = null;
        Flicker flicker = (Flicker)SemanticObject.createSemanticObject(uri).createGenericInstance();
        String url = scheme + wp.getUrl() + "";
        oauthConnection.setKey(flicker.getAppKey());
        oauthConnection.setSecret(flicker.getSecretKey());
        oauthConnection.setUrlCallBack(url);
        oauthConnection.sendRequestToken(flicker);
        url2 = oauthConnection.getAuthorize(flicker);
        return url2;
    }

    public Flicker(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    //@Override
    public void postPhoto(Photo photo, HttpServletRequest request, SWBActionResponse response) {
        String action = response.getAction();
        Flickr flickr = null;
        //WebSite ws = response.getWebPage().getWebSite();
        String uri = request.getParameter("socialUri");
        Flicker flicker = null;
        if(uri != null && uri.trim().length() > 1) {
            flicker = (Flicker) SemanticObject.createSemanticObject(uri).createGenericInstance();
        }
        if(action.equals("uploadPhoto") && flicker != null && photo != null && photo.getPhoto() != null) {
           String photoSend = SWBPortal.getWorkPath() + photo.getWorkPath() + "/" + Photo.social_photo.getName() +
                     "_" + photo.getId() + "_" + photo.getPhoto();

           String oauth_token = flicker.getAccessToken();//flicker.getProperty("oauth_token");
           String oauth_token_secret = flicker.getAccessTokenSecret();//flicker.getProperty("oauth_token_secret");
           if(oauth_token != null && oauth_token_secret != null && (flicker.getAppKey() != null && flicker.getAppKey().trim().length() > 1) && (flicker.getSecretKey() != null && flicker.getSecretKey().trim().length() > 1)) {
               REST rest = new REST();

               flickr = new Flickr(flicker.getAppKey(), flicker.getSecretKey(), rest);
               Auth auth = new Auth();
               auth.setPermission(Permission.DELETE);
               auth.setToken(oauth_token);
               auth.setTokenSecret(oauth_token_secret);

               RequestContext requestContext = RequestContext.getRequestContext();
               requestContext.setAuth(auth);
               flickr.setAuth(auth);
               SWBFile file = new SWBFile(photoSend);//path + photo.getPhoto();
               String description = request.getParameter("description") != null ? request.getParameter("description") : "";
               InputStream fileInputStream = null;
               Uploader uploader = flickr.getUploader();
               List<String> list = new ArrayList();
               String tags1 = photo.getTags();
               if(tags1 != null && tags1.trim().length() > 1) {
                   String[] tags2 = tags1.split(",");
                   for(int i=0; i<tags2.length; i++) {
                       list.add(tags2[i]);
                   }
               }
               try {
                   fileInputStream = new FileInputStream(file);
                   UploadMetaData uploadMetaData = new UploadMetaData();
                   uploadMetaData.setTitle(photo.getTitle());
                   uploadMetaData.setPublicFlag(true);
                   uploadMetaData.setDescription(description);
                   uploadMetaData.setTags(list);
                   try {
                       String id = uploader.upload(fileInputStream, uploadMetaData);

                   } catch(FlickrException e1){
                       log.error(e1);
                   }
               } catch(IOException e){
                   log.error("Exception: " + e);
               } finally {
                   IOUtilities.close(fileInputStream);
               }
           }
       }
    }
}
