<%-- 
    Document   : splash
    Created on : 23/03/2012, 04:37:42 PM
    Author     : rene.jara
--%><jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<script type="text/javascript">

   function createCoverDiv() {
  	var divId='cover01';
  	var bgcolor='#101010';
  	var opacity=80;
    var layer=document.createElement('div');
    layer.id=divId;
    layer.style.width='100%';
    layer.style.height='100%';
    layer.style.backgroundColor=bgcolor;
    layer.style.position='fixed';
    layer.style.top=0;
    layer.style.left=0;
    layer.style.zIndex=1000;
    layer.style.filter='alpha(opacity='+opacity+')';
    layer.style.opacity=opacity/100;
    document.body.appendChild(layer);
  }
  function removeCoverDiv(){//divId) {
    var divId='cover01';
    var layer=document.getElementById(divId);
    //var superlayer=document.getElementById('s_'+divId);
    if(layer ){//&& superlayer) {
//        document.body.removeChild(superlayer);
        document.body.removeChild(layer);
    }
  }

    //dojo.require("dijit.layout.LayoutContainer");
     function agreeSplash(){
        var ret=false;
        ret=dijit.byId("aceptSplash").checked;
        return ret;
    }
    function closeSplash() {
       // alert(agreeSplash());
        if(!agreeSplash()){
            dojo.byId("splash").style.display = "none";
            removeCoverDiv();
        }else{
            //alert("ok");
            location="<%=paramRequest.getActionUrl().setAction(paramRequest.Action_ADD).setParameter("agree","true").toString()%>";
        }
    }
/*
function showSplash() {
    dojo.byId("splash").style.display = "none";
}
dojo.addOnLoad(showSplash);
*/
dojo.addOnLoad(createCoverDiv);
</script>
<div id="splash" style="z-index: 1001; width: 50%; height:60%;  position:absolute; top: 20%; left:20%; background-color: #FFFFFF; ">
    <div align="center">
        <p>Nuevos terminos y cndiciones</p>
    </div>
    <div align="center" style="overflow: auto; height:80%">
        <%=paramRequest.getResourceBase().getAttribute("agreement")%>
    </div>
    <div style="">
        <label for="aceptSplash"><b>*</b>Acepta los terminos y condiciones:</label>
        <input type="checkbox" name="aceptSplash" id="aceptSplash" value="true" dojoType="dijit.form.CheckBox" />
        <a href="" onclick="closeSplash();return false;">Cerrar</a>
    </div>
</div>
