<%-- 
    Document   : tumblrTabs
    Created on : 19/06/2015, 12:41:10 PM
    Author     : oscar.paredes
--%>


<jsp:useBean id="urlDoDashboard" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="urlDoFollowing" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="urlDoFollowers" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="blogName" scope="request" type="String"/>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<div dojoType="dojox.layout.ContentPane">
<main style="width:1210px; height: 100%!important;">
     <link href="<%=org.semanticwb.SWBPlatform.getContextPath()%>\work\models\SWBAdmin\css\tumblrDashboard.css" rel="stylesheet">
        <div style="width: 400px;display: inline-block; height: 100%;overflow-y: scroll;" id = "dashboard">    
            <div class="timelineTab-title">
                <p><strong>Dashboard</strong><%=blogName%></p>
            </div>
        </div>
        <div style="width: 400px;display: inline-block; height: 100%;overflow-y: scroll;" id = "following">
            <div class="timelineTab-title">
                <p><strong>Siguiendo</strong><%=blogName%></p>
            </div>
        </div>

    <!--div style="width: 400px;display: inline-block; height: 100%;overflow-y: scroll;" id = "followers"></div-->
</main>   


    <script type="dojo/method">
        function post(url, callback){
            var xmlhttp;
            xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function(){
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
                    callback(xmlhttp.responseText);
                }
            }
            xmlhttp.open("POST", url, true);
            xmlhttp.send();
        }
        function loadPost(url){
            post(url , function(data){
                var div = document.createElement('div');
                div.innerHTML = data;
                document.getElementById("dashboard").appendChild(div);
                //Like - follow
                var likesButtons = document.getElementsByClassName("like-button");
                for (i = (Math.ceil(likesButtons.length/60)-1)*20; i< likesButtons.length;i++){
                    
                    likesButtons[i].addEventListener("click", function(){
                        var thisLikeButton = this;
                         post(this.dataset.urllike , function(response){
                            thisLikeButton.nextElementSibling.style.display = "inline";
                            thisLikeButton.style.display = "none"
                        });
                    });
                }
                //Unlike - unfollow
                var unlikesButtons = document.getElementsByClassName("unlike-button");
                
                for (i = (Math.ceil(unlikesButtons.length)/40-1)*20; i< unlikesButtons.length;i++){
                    unlikesButtons[i].addEventListener("click", function(){
                        var thisUnLikeButton = this;
                        post(this.dataset.urlunlike , function(response){
                            console.log(response)
                            thisUnLikeButton.previousElementSibling.style.display = "inline";
                            thisUnLikeButton.style.display = "none"
                        });
                    });
                }
                //More post
                var morePostButtons = document.getElementsByClassName("more-post");
                morePostButtons[morePostButtons.length-1].addEventListener("click", function(e){
                   this.style.display = "none"
                    e.preventDefault();
                    loadPost(this.href);
                });
               /* for (i = 0; i< unlikesButtons.length;i++){
                    unlikesButtons[i].addEventListener("click", function(){
                        var thisUnLikeButton = this;
                         post(this.dataset.urlunlike , function(response){
                            console.log(response)
                            thisUnLikeButton.previousElementSibling.style.display = "inline";
                            thisUnLikeButton.style.display = "none"
                        });
                    });
                }*/
            });
        }
        post(" <%= urlDoFollowing.toString() %>" , function(data){
            var div = document.createElement('div');
            div.innerHTML = data;
            document.getElementById("following").appendChild(div);
            //Follow
            var likesButtons = document.getElementsByClassName("follow-button");
            for (i = 0; i< likesButtons.length;i++){
                likesButtons[i].addEventListener("click", function(){
                    var thisLikeButton = this;
                     post(this.dataset.urllike , function(response){
                        console.log(response)
                        thisLikeButton.nextElementSibling.style.display = "inline";
                        thisLikeButton.style.display = "none"
                    });
                });
            }
            //Unfollow
            var unlikesButtons = document.getElementsByClassName("unfollow-button");
            for (i = 0; i< unlikesButtons.length;i++){
                unlikesButtons[i].addEventListener("click", function(){
                    var thisUnLikeButton = this;
                     post(this.dataset.urlunlike , function(response){
                        console.log(response)
                        thisUnLikeButton.previousElementSibling.style.display = "inline";
                        thisUnLikeButton.style.display = "none"
                    });
                });
            }
        });
        
        
       /* post(" <%= urlDoFollowers.toString() %>" , function(data){
          var div = document.createElement('div');
          div.innerHTML = data;
          document.getElementById("followers").appendChild(div);
      });*/
      
      loadPost(" <%= urlDoDashboard.toString() %>");
      
    </script>
</div>



