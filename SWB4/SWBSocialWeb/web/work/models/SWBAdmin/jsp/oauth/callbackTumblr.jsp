<%@page import="org.semanticwb.social.Tumblr"%>
<%@page import="oauth.signpost.OAuthProvider"%>
<%@page import="oauth.signpost.OAuthConsumer"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=x-iso-8859-11">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String verificationCode = null;
        String apiURL = null;
    	String accessToken = null;
        String secretToken = null;
    	OAuthConsumer consumer = null;
    	OAuthProvider provider = null;
        Tumblr tumblr = null;
        
        HttpSession httpSession = request.getSession();
        consumer = (OAuthConsumer)httpSession.getAttribute("consumer");
        provider = (OAuthProvider)httpSession.getAttribute("provider");
        tumblr = (Tumblr)httpSession.getAttribute("tumblr");
       
        if(consumer!=null && provider != null && tumblr != null){ 
            verificationCode = request.getParameter("oauth_verifier");
            if(null!=verificationCode && null!=consumer && null!=provider) {
                provider.retrieveAccessToken(consumer, verificationCode);
                accessToken = consumer.getToken();
                secretToken = consumer.getTokenSecret();
            }
            if( accessToken != null) {
                tumblr.setAccessToken(accessToken);
                tumblr.setAccessTokenSecret(secretToken);
                tumblr.setSn_authenticated(true);
                
            }
            //Ejecuto el form de doView en SocialWebResource, para validar que ya estoy autentificado
            %>
            <script type="text/javascript">
                var form = window.opener.document.getElementById('authNet/<%= tumblr.getEncodedURI() %>');
                if (form.onsubmit){
                    var result = form.onsubmit.call(form);
                }
                if (result !== false){
                    form.submit();
                }
                window.close();
            </script>
        <%} //Mensaje de error si hay error en la autentificacion 
        else{%>
            <h1>Error de autentificacion, intente de nuevo</h1>
            <script type="text/javascript">
                setTimeout(function(){
                     window.close();
                },4000)
            </script>
        <%}%>
    </body>
</html>
