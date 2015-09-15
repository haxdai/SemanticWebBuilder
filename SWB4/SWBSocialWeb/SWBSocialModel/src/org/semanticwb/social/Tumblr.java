/**  
* SWB Social es una plataforma que descentraliza la publicación, seguimiento y monitoreo hacia las principales redes sociales. 
* SWB Social escucha y entiende opiniones acerca de una organización, sus productos, sus servicios e inclusive de su competencia, 
* detectando en la información sentimientos, influencia, geolocalización e idioma, entre mucha más información relevante que puede ser 
* útil para la toma de decisiones. 
* 
* SWB Social, es una herramienta basada en la plataforma SemanticWebBuilder. SWB Social, como SemanticWebBuilder, es una creación original 
* del Fondo de Información y Documentación para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SWB Social a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarla en las mismas condiciones con que INFOTEC la ha diseñado y puesto a su disposición; 
* aprender de élla; distribuirla a terceros; acceder a su código fuente y modificarla, y combinarla o enlazarla con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. y SWB Social 1.0
* 
* INFOTEC no otorga garantía sobre SWB Social, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder o SWB Social, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 

package org.semanticwb.social;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.AudioPost;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.ChatPost;
import com.tumblr.jumblr.types.LinkPost;
import com.tumblr.jumblr.types.PhotoPost;
import com.tumblr.jumblr.types.PhotoSize;
import com.tumblr.jumblr.types.PhotosetPost;
import com.tumblr.jumblr.types.TextPost;
import com.tumblr.jumblr.types.User;
import com.tumblr.jumblr.types.VideoPost;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.QuotePost;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import org.json.JSONObject;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.social.listener.Classifier;
import org.semanticwb.social.util.SWBSocialUtil;

   /**
   * Clase que almacenará las diferentes cuentas de una organización para la red social Tumblr. 
   */
public class Tumblr extends org.semanticwb.social.base.TumblrBase {
    
    private static final org.semanticwb.Logger log = SWBUtils.getLogger(Tumblr.class);
    public static  final String TYPE_POST_TEXT = "text";
    public static final String TYPE_POST_PHOTO="photo";
    public static final String TYPE_POST_QUOTE = "quote"; 
    public static final String TYPE_POST_LINK="link";
    public static final String TYPE_POST_CHAT = "chat" ;
    public static final String TYPE_POST_AUDIO ="audio";
    public static final String TYPE_POST_VIDEO ="video";
    
    public static final String STATE_PUBLISHED="published";
    public static final String STATE_DRAFT = "draft" ;
    public static final String STATE_QUEUE ="queue";
    public static final String STATE_PRIVATE ="private";

    
    public Tumblr(org.semanticwb.platform.SemanticObject base){
        super(base);
    }
    /**
     * Autentifica un usuario en tumblr
     * @param request
     * @param response
     * @param paramRequest
     * @throws SWBResourceException
     * @throws IOException 
     */
     @Override
     public void authenticate(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            PrintWriter out = response.getWriter();
            // Objetos para el manejo de OAuth
            OAuthConsumer consumer;
            OAuthProvider provider;
            // Ruta callback y obtenciond de appkey y secretkey
            String callbackURL ="http://" + request.getServerName() + ":" + request.getServerPort() +
                    SWBPortal.getWebWorkPath() + "/models/SWBAdmin/jsp/oauth/callbackTumblr.jsp";
            String tumblrConsumerKey = this.getAppKey()!= null ? this.getAppKey() : "" ;
            String tumblrSecretKey = this.getSecretKey()!= null ? this.getSecretKey() : ""; 
            
            consumer = new DefaultOAuthConsumer(tumblrConsumerKey,tumblrSecretKey);
            provider = new DefaultOAuthProvider(
                    "http://www.tumblr.com/oauth/request_token", 
                    "http://www.tumblr.com/oauth/access_token",
                    "http://www.tumblr.com/oauth/authorize");
            String url = provider.retrieveRequestToken(consumer,callbackURL);
            // Guardo vliebles en session para usarlos en el callback
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("consumer", consumer);
            httpSession.setAttribute("provider", provider);
            httpSession.setAttribute("tumblr", this);
            //Lanzo la ventana para autentificacion
            out.println("<script type='text/javascript'>");
            out.println("   location.href='"+url +"' ");
            out.println("</script>");
        } catch (OAuthMessageSignerException ex) {
            Logger.getLogger(Tumblr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OAuthNotAuthorizedException ex) {
            Logger.getLogger(Tumblr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OAuthExpectationFailedException ex) {
            Logger.getLogger(Tumblr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OAuthCommunicationException ex) {
            Logger.getLogger(Tumblr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     /**
      * Publica un mensaje en Tumblr
      * @param message 
      */
    @Override
    public void postMsg(Message message) {
        if (!isSn_authenticated() || getAccessToken() == null) {
            log.error("Not authenticated network: " + getTitle() + ". Unable to post Message");
            return;
        }
        if (message.getMsg_Text() == null) {
            log.error("Not message found, nothing to post");
            return;
        }
        //Instancia del cliente para tumblr
        JumblrClient client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),  SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
        client.setToken(getAccessToken(), getAccessTokenSecret());
        User user = client.user();
        Blog blog = user.getBlogs().get(0);
        //Configuracion para crear post tipo texto
        TextPost textPost = new TextPost();
        textPost.setClient(client);
        textPost.setBlogName(blog.getName());
        textPost.setState(STATE_PUBLISHED);
        textPost.setBody(message.getMsg_Text());
         //Configuracion de los tags
        if(message.getTags()!=null){
            textPost.setTags(new ArrayList(Arrays.asList( message.getTags().split(","))));
        }
         //Se publica el texto
        textPost.save();
    }

    /**
     * Publica una foto en tumblr
     * @param photo 
     */
    @Override
    public void postPhoto(Photo photo) {
        try {
            if (!isSn_authenticated() || getAccessToken() == null) {
                log.error("Not authenticated network: " + getTitle() + ". Unable to post Photo");
                return;
            }
            if (photo.listPhotos().hasNext() == false) {
                log.error("Not photos found, nothing to post");
                return;
            }
            //Instancia del cliente para tumblr
            JumblrClient client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),  SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(getAccessToken(), getAccessTokenSecret());
            User user = client.user();
            Blog blog = user.getBlogs().get(0);
            //Configuracion para crear post tipo Imagen
            PhotosetPost photosetPost = new PhotosetPost();
            photosetPost.setClient(client);
            photosetPost.setBlogName(blog.getName());
            photosetPost.setState(STATE_PUBLISHED);
            photosetPost.setCaption(photo.getMsg_Text());
            //Configuracion de los tags
            if(photo.getTags()!=null){
                photosetPost.setTags(new ArrayList(Arrays.asList( photo.getTags().split(","))));
            }
            //Se agregan las imagenes
            Iterator<String> listPhotos = photo.listPhotos();
            while(listPhotos.hasNext()){
                photosetPost.addData(new File(SWBPortal.getWorkPath()  + photo.getWorkPath() + "/" + listPhotos.next() ));
            }
            //Se publica la imagen
            photosetPost.save();
        } catch (IOException ex) {
            log.error("Error al subir imagen (tumblr): ", ex);
        }
    }
    
    /**
     * Publica un video en tumblr
     * @param video 
     */
    @Override
    public void postVideo(Video video) {
       try {
           if (!isSn_authenticated() || getAccessToken() == null) {
                log.error("Not authenticated network: " + getTitle() + ". Unable to post Photo");
                return;
            }
            if (video.getVideo() == null) {
                log.error("Not photos found, nothing to post");
                return;
            }
            //Instancia del cliente para tumblr
            JumblrClient client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),  SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(getAccessToken(), getAccessTokenSecret());
            User user = client.user();
            Blog blog = user.getBlogs().get(0);
            //Configuracion para crear post tipo Imagen
            VideoPost videoPost = new VideoPost();
            videoPost.setClient(client);
            videoPost.setBlogName(blog.getName());
            videoPost.setState(STATE_PUBLISHED);
            videoPost.setCaption(video.getMsg_Text());
            //Configuracion de los tags
            if(video.getTags()!=null){
                videoPost.setTags(new ArrayList(Arrays.asList( video.getTags().split(","))));
            }
            //Se agregan las imagenes
            videoPost.setData(new File(SWBPortal.getWorkPath()  + video.getWorkPath() + "/" +  video.getVideo() ));

            //Se publica la imagen
            videoPost.save();
        } catch (IOException ex) {
            log.error("Error al subir imagen (tumblr): ", ex);
        }
        
    }

    @Override
    public void listen(Stream stream) {
        if(!isSn_authenticated() || getAccessToken() == null ){
            log.error("Not authenticated network: " + getTitle() + "!!!");
            return;
        }
        //System.out.println("Listen tumblr");
        ArrayList<ExternalPost> externalPostArray = new ArrayList<ExternalPost>();
        ExternalPost exPostTemp;
        HashMap params; 
        TumblrListenHelper tumblrListenHelper = null ;
        long lastTimePost = 0, firtsTimePost = 0,postTime;
        
        //Instancia del cliente para tumblr
        JumblrClient client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),  SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
        client.setToken(getAccessToken(), getAccessTokenSecret());
        User user = client.user();
        Blog blog = user.getBlogs().get(0);  
        //Obtengo las palabras clave del stream
        Iterator<String> iteratorPhases = incomingPhasesFromStream(stream);
        
        //Determinar la fecha del ultimo post guardado
        SocialNetStreamSearch socialStreamSerch = SocialNetStreamSearch.getSocialNetStreamSearchbyStreamAndSocialNetwork(stream, this);
        if (socialStreamSerch != null) {
            if(socialStreamSerch.getNextDatetoSearch() == null){
                //System.out.println("Data new: "+socialStreamSerch.getNextDatetoSearch());
                tumblrListenHelper = new TumblrListenHelper(incomingPhasesFromStream(stream));   
            }else{
                tumblrListenHelper = new TumblrListenHelper(socialStreamSerch.getNextDatetoSearch(),socialStreamSerch);
                //System.out.println("Data old: "+ tumblrListenHelper.getFormatString());
                
            }        
        }
        //Configuro la fecha de inicio y de fin de la captura del stream
         if(stream.getInitialDate()!= null){
            try {
                firtsTimePost = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(stream.getInitialDate()).getTime() /1000;
            } catch (ParseException ex) {
                Logger.getLogger(Tumblr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.YEAR, -1);
            //calendar.add(Calendar.MONTH, 0);
            //calendar.add(Calendar.DAY_OF_YEAR, 0 );
            firtsTimePost = calendar.getTime().getTime()/1000;
         }
        if(stream.getEndDate()!= null){
            try {
                lastTimePost = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(stream.getEndDate()).getTime() /1000;
            } catch (ParseException ex) {
                Logger.getLogger(Tumblr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            lastTimePost = new Date().getTime()/1000;
        }
   
        //System.out.println("Termino de validar fechas");
          
        while(iteratorPhases.hasNext()){
            //System.out.println("Entro al iterador de phases");
            params = new HashMap();
            String phase = iteratorPhases.next();
            TumblrListenHelper.TumblrTimeHelper timeHelper = tumblrListenHelper.getTimeHelper(phase);
            if(timeHelper== null)break;
            if (timeHelper.getReachInit() == 0 ){
                timeHelper.setReachInit(firtsTimePost);
            }
            //Se repite la consulta 50 veces, 20 post en cada consulta = 1000 post por phase en cada iteracion. 
            for(int times=0;times<25;times++){
                boolean skip = false;
                if(timeHelper.getEnd()==0){
                    params.put("before",lastTimePost);
                }else{
                      params.put("before",timeHelper.getInit());  
                }
                
                ArrayList<Post> taggedItems =  (ArrayList<Post>) client.tagged(phase, params);
                //System.out.println("Mensajes disponibles: "+taggedItems.size());
                if(taggedItems.isEmpty()){
                    break;
                }

                Iterator<Post> iteratorPost = taggedItems.iterator();
                while(iteratorPost.hasNext()){
                    Post post = iteratorPost.next();
                    postTime  = post.getTimestamp();

                    if(postTime <= timeHelper.getReachInit()){
                        if(timeHelper.getEnd()!=0){
                            timeHelper.setReachInit(timeHelper.getEnd());
                            timeHelper.setInit(0);
                            timeHelper.setEnd(0);
                        }else{
                            skip= true;
                        }
                        break;
                    }
                    
                    if(postTime > firtsTimePost  && postTime < lastTimePost){
                        ExternalPost externalPostFromTumblrPost = getExternalPostFromTumblrPost(post,stream);
                        if(externalPostFromTumblrPost!= null){
                            externalPostArray.add(externalPostFromTumblrPost);
                            
                             if(timeHelper.getEnd() < postTime){ 
                                timeHelper.setEnd(postTime); // Almacena la fecha en segundos del post mas reciente.
                             }
                             if(timeHelper.getInit()==0 || timeHelper.getInit() > postTime){
                                 timeHelper.setInit(postTime);
                             }
                             
                        }
                    }
                }
                if(skip)break;
            } 
        }
        socialStreamSerch.setNextDatetoSearch(tumblrListenHelper.getFormatString());
        
        if(externalPostArray.size()>0){
            new Classifier(externalPostArray, stream, this, true);
        }
        //System.out.println("Termino la busqueda");
        
    }
    /**
     * Analiza limpia y extrae las palabras claves a buscar en tumblr.
     * @param stream
     * @return Arreglo con una lista de palabras clave (tags) a buscar
     */
    public Iterator<String> incomingPhasesFromStream(Stream stream){
        ArrayList<String> phasesArray = new ArrayList<String>();
        if(stream.getPhrase() != null && !stream.getPhrase().trim().isEmpty()){
            String orPhrases = "";
            orPhrases = stream.getPhrase();            
            //orPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(orPhrases);
            orPhrases = orPhrases.trim().replaceAll("\\s+", " "); 
            String words[] = orPhrases.split(" ");
            for(String word :words){
                if(!word.trim().isEmpty()){
                    phasesArray.add(word.trim());
                }
            }
        }
        if(stream.getStream_exactPhrase() != null && !stream.getStream_exactPhrase().trim().isEmpty()){
            String exactPhrases = "";
            exactPhrases = stream.getStream_exactPhrase();
            //exactPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(exactPhrases);
            exactPhrases = exactPhrases.trim().replaceAll("\\s+", " "); //replace multiple spaces beetwen words for one only one space
            phasesArray.add(exactPhrases);
        }
        
        return phasesArray.iterator();
    }
    
    /**
     * Crea un externalPost a partir de un post de tumblr
     * @param post
     * @param stream
     * @return  ExternalPost o null en caso de error.
     */
    private ExternalPost getExternalPostFromTumblrPost(Post post,Stream stream) {
        ExternalPost externalPost = new ExternalPost();
        externalPost.setSocialNetwork(this);
        if(post.getBlogName()!= null){
            externalPost.setCreatorId(post.getBlogName());
        }
        if(post.getId()!= null){
            externalPost.setPostId(String.valueOf(post.getId()));
        }
        if(post.getTimestamp()!= null){
            externalPost.setCreationTime(new Date(post.getTimestamp()*1000));
        }
        if(post.getBlogName()!= null){
            externalPost.setCreatorName(post.getBlogName());
        }
        if(post.getClient()!= null && post.getBlogName()!= null){
            if(post.getClient().blogAvatar(post.getBlogName())!= null){
                externalPost.setCreatorPhotoUrl(post.getClient().blogAvatar(post.getBlogName()));
            }
        }
      
        
        //No hay amigos en tumbler
        externalPost.setFriendsNumber(0);
        
        if(post.getTags()!= null){
            externalPost.setTags(Arrays.toString(post.getTags().toArray()));
        }
        if(post.getPostUrl()!= null){
            externalPost.setPostUrl(post.getPostUrl());
        }
        
        if(post.getType().equals(TYPE_POST_AUDIO) ) {
            if( ((AudioPost)post).getCaption() != null ){
                externalPost.setMessage(((AudioPost)post).getCaption());
                externalPost.setPostType(SWBSocialUtil.AUDIO);
            }else{
                return null;
            }
            return null;
        }else if(post.getType().equals(TYPE_POST_CHAT) ){
            if( ((ChatPost)post).getBody() != null && !((ChatPost)post).getBody().trim().isEmpty() ){
                externalPost.setMessage(((ChatPost)post).getBody() );
                externalPost.setPostType(SWBSocialUtil.MESSAGE);
            }else{
                return null;
            }
        }else if(post.getType().equals(TYPE_POST_LINK) ){
            if( ((LinkPost)post).getDescription() != null && !((LinkPost)post).getDescription().trim().isEmpty()){
                externalPost.setMessage( ((LinkPost)post).getTitle()!=null? ((LinkPost)post).getTitle()+"\n":"" + ((LinkPost)post).getDescription());
                externalPost.setPostType(SWBSocialUtil.MESSAGE);
            }
            else{
                return null;
            }
        }else if(post.getType().equals(TYPE_POST_PHOTO) ){
            ArrayList externalPhotos = new ArrayList();
            if( ((PhotoPost)post).getCaption() != null && !((PhotoPost)post).getCaption().trim().isEmpty() ){
                externalPost.setMessage(((PhotoPost)post).getCaption());
                externalPost.setPostType(SWBSocialUtil.PHOTO);
                //Obtengo las fotos
                Iterator<com.tumblr.jumblr.types.Photo> iteratorPhotos = ((PhotoPost)post).getPhotos().iterator();
                while(iteratorPhotos.hasNext()){
                    com.tumblr.jumblr.types.Photo nextPhoto = iteratorPhotos.next();
                    Iterator<PhotoSize> iteratorPhotoSize = nextPhoto.getSizes().iterator();
                    if(iteratorPhotoSize.hasNext()){
                        externalPhotos.add(iteratorPhotoSize.next().getUrl());
                    }
                }
                externalPost.setPictures(externalPhotos); 
            }else{
                return null;
            }
        }else if(post.getType().equals(TYPE_POST_QUOTE) ){
            if( ((QuotePost)post).getText() != null && ! ((QuotePost)post).getText().trim().isEmpty()){
                externalPost.setMessage(((QuotePost)post).getText() );
            }
            else{
                return null;
            }
            externalPost.setPostType(SWBSocialUtil.MESSAGE);
        }else if(post.getType().equals(TYPE_POST_TEXT) ){
            if( ((TextPost)post).getBody() != null && !((TextPost)post).getBody().trim().isEmpty() ){
                externalPost.setMessage( ((TextPost)post).getTitle()!= null? ((TextPost)post).getTitle()+ "\n":"" + ((TextPost)post).getBody());
                 externalPost.setPostType(SWBSocialUtil.MESSAGE);
            }
            else{
                return null;
            }
        }else if(post.getType().equals(TYPE_POST_VIDEO) ){
            if( ((VideoPost)post).getCaption() != null ){
                externalPost.setMessage(((VideoPost)post).getCaption());
            }
            externalPost.setPostType(SWBSocialUtil.VIDEO);
            //Obtengo video
            Iterator<com.tumblr.jumblr.types.Video> videos = ((VideoPost)post).getVideos().iterator();
            if(videos.hasNext()){
                externalPost.setVideo(videos.next().getEmbedCode());
            }

        }
       
        
        return externalPost;
            
    }


    @Override
    public JSONObject getUserInfobyId(String userId) {
        return null;
    }
    
}


 class TumblrListenHelper{
    HashMap<String,TumblrTimeHelper> iterationInfo;
    
    TumblrListenHelper(Iterator<String> iteratorPhases) {
        iterationInfo = new HashMap<String, TumblrTimeHelper>();
        while(iteratorPhases.hasNext()){
           iterationInfo.put(iteratorPhases.next(), new TumblrTimeHelper(0, 0,0));
        }
        
    }
    TumblrListenHelper(String iteratorPhases, SocialNetStreamSearch socialStreamSerch) {
        iterationInfo = new HashMap<String, TumblrTimeHelper>();
        String[] split = iteratorPhases.replace("|","==").split("==");
        //System.out.println("Iterator:"+ iteratorPhases);
        for(int i =  0; i< split.length; i+=4){
            if(split.length -i >=4){
                try{
                   Long.valueOf(split[i+1]);Long.valueOf( split[i+2]);Long.valueOf(split[i+3]);
                }catch(NumberFormatException ex){
                    split[i+1] = "0";split[i+2] = "0";split[i+3] = "0";
                }finally{ 
                     iterationInfo.put(split[i], new TumblrTimeHelper(Long.valueOf(split[i+1]),Long.valueOf( split[i+2]),Long.valueOf(split[i+3])));
                       
                }   
            }else{
                socialStreamSerch.setNextDatetoSearch(null);
            }
        }
    }
    
    TumblrTimeHelper getTimeHelper(String key){
        return iterationInfo.get(key);
    
    }
    
    public HashMap getIterationInfo() {
        return iterationInfo;
    }

    public void setIterationInfo(HashMap iterationInfo) {
        this.iterationInfo = iterationInfo;
    }

    String getFormatString() {
        String formatString = "";
        Iterator<Map.Entry<String, TumblrTimeHelper>> iterator = iterationInfo.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, TumblrTimeHelper> next = iterator.next();
            formatString+=next.getKey()+"==" + next.getValue().getInit() +"=="+ next.getValue().getEnd() + "==" +next.getValue().getReachInit()+"==";
        }
        return formatString;
    }

    
    class TumblrTimeHelper{
        long init;
        long end;
        long reachInit;

        public TumblrTimeHelper(long init, long end, long reachInit) {
            this.init = init;
            this.end = end;
            this.reachInit = reachInit;
        }

        public long getReachInit() {
            return reachInit;
        }

        public void setReachInit(long reachInit) {
            this.reachInit = reachInit;
        }

      
      
        
        public long getInit() {
            return init;
        }

        public void setInit(long init) {
            this.init = init;
        }

        public long getEnd() {
            return end;
        }

        public void setEnd(long end) {
            this.end = end;
        }
        
    }
} 

