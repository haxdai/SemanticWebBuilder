/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function resetTabTitle (objUri, tabId, title){
    var tabId = objUri + tabId;
    var pane = dijit.byId(tabId);                   
    try{
        var aux=title;
        pane.title = aux;
        pane.controlButton.containerNode.innerHTML = aux;
    }catch(noe){
        console.log('Error setting title to default value: ' + noe);
    }
}
      
function appendHtmlAt(url, tagid, location){
    
    dojo.xhrPost({
        url: url,
        load: function(response)
        {
            var tag=dojo.byId(tagid);
            if(tag){
                var pan=dijit.byId(tagid);
                if(pan && pan.attr)
                {
                    if(location == "bottom"){
                        pan.attr('content', tag.innerHTML + response);
                    }else if(location == "top"){
                        pan.attr('content', response + tag.innerHTML);
                    }
                }else
                {
                    if(location == "bottom"){
                        tag.innerHTML = tag.innerHTML + response;
                    }else if(location == "top"){
                        tag.innerHTML = response + tag.innerHTML;
                    }
                }
            }else {
            //alert("No existe ningun elemento con id " + tagid);
            }
            return response;
        },
        error: function(response)
        {
            if(dojo.byId(tagid)) {
            //dojo.byId(tagid).innerHTML = "<p>Ocurrio un error con respuesta:<br />" + response + "</p>";
            }else {
            //alert("No existe ningun elemento con id " + tagid);
            }
            return response;
        },
        handleAs: "text"
    });
}
    
function postSocialHtml(url, tagid)
{
    dojo.xhrPost({
        url: url,
        load: function(response)
        {
            var tag=dojo.byId(tagid);
            if(tag){
                var pan=dijit.byId(tagid);
                if(pan && pan.attr)
                {
                    pan.attr('content',response);
                }else
                {
                    tag.innerHTML = response;
                }
            }else {
                console.log('Tag not found: ' + tagid);
            }
            return response;
        },
        error: function(response)
        {
            alert(response.status);
            if(dojo.byId(tagid)) {
            //dojo.byId(tagid).innerHTML = "<p>Ocurrio un error con respuesta:<br />" + response + "</p>";
            }else {
                console.log('Tag not found: ' + tagid);
            }
            return response;
        },
        handleAs: "text"
    });
}
    
function postSocialHtmlListeners(url, tagid)
{
    dojo.xhrPost({
        url: url,
        load: function(response)
        {
            var tag=dojo.byId(tagid);
            if(tag){
                var pan=dijit.byId(tagid);
                if(pan && pan.attr)
                {
                    pan.attr('content',response);
                }else
                {
                    tag.innerHTML = response;
                }
            }else {
                console.log('Tag not found: ' + tagid);
            }
            return response;
        },
        error: function(response)
        {
            //If server is down or session expired
            if(response.status == 0 || response.status == 403){
                //Clear all possible active intervals
                for(var i = 0;  i < 1000; i++){
                    clearInterval(i);
                }
            }
                  
            if(dojo.byId(tagid)) {
            //dojo.byId(tagid).innerHTML = "<p>Ocurrio un error con respuesta:<br />" + response + "</p>";
            }else {
                console.log('Tag not found: ' + tagid);
            }
            return response;
        },
        handleAs: "text"
    });
}
function imageLoad(imgObject, imgParam) {
    var tag = dojo.byId(imgParam);
    var img = new Image();
    img = imgObject;

    // what's the size of this image and it's parent
    var w = img.width;        
    var h = img.height;
    var tw = tag.style.width.replace('px', '');
    var th = tag.style.height.replace('px', '');
        
    var scale;
    var wi;
    var he;
        
    // compute the new size and offsets
    if(w < tw && h < th){//If the image fits
        tag.style.width = w + 'px';
        tag.style.height = h + 'px';
        return;
    }else if(w > h){//landscape
        scale = tw / w ;            
    }else if(h > w){//portrait
        scale = th / h ;            
    }else{//squared
        scale = th / w ;
    }
    wi = scale * w;
    he = scale * h;
    img.width = wi;
    img.height = he;
        
    tag.style.width = wi + 'px';
    tag.style.height = he + 'px';
}
    
//Used to display video and pictures
function showSocialDialog(url, title){
    dojo.xhrGet({
        url: url,
        load: function(response, ioArgs){
            dijit.byId('swbSocialDialogImp').attr('content',response);
            dijit.byId('swbSocialDialog').show();
            setSocialDialogTitle(title);
            return response;
        },
        error: function(response, ioArgs){
            showStatus('Error:'+response);
            return response;
        },
        handleAs: "text"
    });
}
	  
function setSocialDialogTitle(title){
    if(title)dijit.byId('swbSocialDialog').titleNode.innerHTML=title;
}
	  
function hideSocialDialog(){
    dijit.byId('swbDialog').hide();
    dijit.byId('swbDialogImp').attr('content','');        
}
    
function scaleImage(srcwidth, srcheight, targetwidth, targetheight, fLetterBox) {
    var result = {
        width: 0, 
        height: 0, 
        fScaleToTargetWidth: true
    };

    if ((srcwidth <= 0) || (srcheight <= 0) || (targetwidth <= 0) || (targetheight <= 0)) {
        return result;
    }

    // scale to the target width
    var scaleX1 = targetwidth;
    var scaleY1 = (srcheight * targetwidth) / srcwidth;

    // scale to the target height
    var scaleX2 = (srcwidth * targetheight) / srcheight;
    var scaleY2 = targetheight;

    // now figure out which one we should use
    var fScaleOnWidth = (scaleX2 > targetwidth);
    if (fScaleOnWidth) {
        fScaleOnWidth = fLetterBox;
    }
    else {
        fScaleOnWidth = !fLetterBox;
    }

    if (fScaleOnWidth) {
        result.width = Math.floor(scaleX1);
        result.height = Math.floor(scaleY1);
        result.fScaleToTargetWidth = true;
    }
    else {
        result.width = Math.floor(scaleX2);
        result.height = Math.floor(scaleY2);
        result.fScaleToTargetWidth = false;
    }
    result.targetleft = Math.floor((targetwidth - result.width) / 2);
    result.targettop = Math.floor((targetheight - result.height) / 2);
    return result;
}

function showFullImage (image) {
    var img = new Image();
    img = image;

    // what's the size of this image and it's parent
    var w = img.width;        
    var h = img.height;
    var tw=img.parentNode.style.width.replace('px', '');
    var th=img.parentNode.style.height.replace('px', '');
        
    /*if(w <= 320 && h <= 240){
            tw= 320;
            th=240;
            img.parentNode.style.width = '320px';
            img.parentNode.style.height = '240px';
        }*/

    // compute the new size and offsets
    var result = scaleImage(w, h, tw, th, true);
    // adjust the image coordinates and size
    img.width = result.width;
    img.height = result.height;
    //offset
    img.style.left =result.targetleft + 'px';
    img.style.top = result.targettop + 'px';
}
    
function showHideConversation(id){
    if (document.getElementById(id)){
        var el = document.getElementById(id);
        if(el.style.display == 'none'){
            el.removeAttribute('style');
        }else{
            el.setAttribute('style','display:none;');
        }
    }
}
    
function stopListener(url){
    dojo.xhrGet({
        url: url,
        load: function(response, ioArgs)
        {
            //console.log('Listener stoped:' + response)
            return response;
        },
        error: function(response, ioArgs){
            console.log("Error Stoping listener!");
        },
        handleAs: "text"
    });
}
    
function saveInterval(url){
    dojo.xhrGet({
        url: url,
        load: function(response, ioArgs)
        {
        //console.log('Saving interval:' + response)
        },
        error: function(response, ioArgs){
            console.log("Error saving interval!");
        },
        handleAs: "text"
    });
}
function changeClassT(objUri, sourceCall) {
    var divId = objUri +  sourceCall +'Txt';
    console.log('DIV:' + divId);
    if(document.getElementById(divId).className == 'sel-txt'){
        document.getElementById(objUri +  sourceCall +'Txt').className ='sel-txt2';
        document.getElementById(objUri +  sourceCall +'Img').className ='sel-img';
        document.getElementById(objUri +  sourceCall +'Video').className ='sel-vid';
    }
}
function changeClassI(objUri,sourceCall) { 
    if(document.getElementById(objUri +  sourceCall +'Img').className =='sel-img'){
        document.getElementById(objUri +  sourceCall +'Img').className ='sel-img2';
        document.getElementById(objUri +  sourceCall +'Txt').className ='sel-txt';
        document.getElementById(objUri +  sourceCall +'Video').className ='sel-vid';
    }
}
function changeClassV(objUri,sourceCall) { 
    if(document.getElementById(objUri +  sourceCall +'Video').className =='sel-vid'){
        document.getElementById(objUri +  sourceCall +'Video').className ='sel-vid2';
        document.getElementById(objUri +  sourceCall +'Txt').className ='sel-txt';
        document.getElementById(objUri +  sourceCall +'Img').className ='sel-img';
    }
}
function showListCategory(objUri,sourceCall) {
    var frm = document.getElementById(objUri+sourceCall+'frmUploadVideo');
    var div = document.getElementById(objUri+sourceCall+'divCategory');

    if(frm.checkYT.length == null){//when there is only one Youtube account
        if(frm.checkYT.checked){
            div.removeAttribute('style');
        }else{
            div.setAttribute('style', 'display:none;');
        }
    }else{//Has length method, then it's an array
        var isChecked = false;
        for (i = 0; i < frm.checkYT.length; i++) {
            if(frm.checkYT[i].checked){//When a checkbox is checked
                isChecked = true;
                break;
            }
        }
        if(isChecked){
            div.removeAttribute('style');
        }else{
            div.setAttribute('style', 'display:none;');
        }
    }
}
/**
 * selectNetwork - cuando se responde a un mensaje de entrada no se debe de validar
 *                 porque ya hay una red hacia donde se va a responder
 *                 true-> debe de seleccionar una red
 *                 false-> ya hay una red seleccionada (la red que recibio el mensaje)
 * //TODO: REVISAR DE NUEVO LAS VALIDACIONES PORQUE SE PUEDE RESPONDER DE OTRAS REDES!!!
 */       
function checksRedesPhoto(objUri, sourceCall, selectNetwork){
    var frm = document.getElementById(objUri+sourceCall+'frmUploadPhoto');
    var checkRed = false;          
    if(selectNetwork == false){//Ya hay una red seleccionada porque se esta respondiendo
        return true;
    }
          
    if(frm.checkRedes == null){//No networks
        alert("Debes crear primero una red en donde publicar");
        return false;
    }
          
    if(frm.checkRedes.length == null){
        if(frm.checkRedes.checked){//there is only one network
            checkRed = true;
        }
    }else{
        for (i = 0; i < frm.checkRedes.length; i++) {
            if (frm.checkRedes[i].checked){
                checkRed = true;
                break;
            }
        }
    }
    if(checkRed == false){
        alert("Debes seleccionar al menos una red");
        return false;
    }
    else{
        return true;
    }
}
function checksRedesText(objUri, sourceCall,id, required){
    var frm = document.getElementById(objUri+sourceCall+'frmUploadText');
    var checkRed = false;
          
    if(frm.checkRedes == null){//No networks
        alert("Debes crear primero una red en donde publicar");
        return false;
    }
          
    if(frm.checkRedes.length == null){
        if(frm.checkRedes.checked){
            checkRed = true;
        }
    }else{
        for (i = 0; i < frm.checkRedes.length; i++) {
            if(frm.checkRedes[i].checked){
                checkRed = true;
                break;
            }
        }
    }
    if(checkRed == false){
        alert("Debes seleccionar al menos una red.");
        return false;
    }else{
        return  validateExtention(id, required);    
    }
}
function validateChecks(objUri, sourceCall, selectNetwork){
    var frm = document.getElementById(objUri+sourceCall+'frmUploadVideo');
    var checkYT = false;
    var checkRed = false;
          
    if(selectNetwork == false){//Ya hay una red seleccionada porque se esta respondiendo
        return true;
    }
    if(frm.checkRedes == null && frm.checkYT == null){//No networks found for facebook or youtube
        alert("Debes crear primero una red en donde publicar");
        return false;
    }
    if(frm.checkYT != null){
        if(frm.checkYT.length == null){
            if(frm.checkYT.checked){
                checkYT = true;
            }
        }else{
            for (i = 0; i < frm.checkYT.length; i++) {
                if (frm.checkYT[i].checked){
                    checkYT = true;
                    break;
                }
            }
        }
    }
          
    if(frm.checkRedes != null){
        if(frm.checkRedes.length == null){
            if(frm.checkRedes.checked){
                checkRed = true;
            }
        }else{
            for (j = 0; j < frm.checkRedes.length; j++) {
                if (frm.checkRedes[j].checked){
                    checkRed = true;
                    break;
                }
            }
        }
    }
        
    if(checkYT == false && checkRed == false){
        alert("Debes seleccionar al menos una red");
        return false;
    }
    else{
        return true;
    }
}
      
      
function disableSelect(source){
    var children = source.parentNode.childNodes;
    for(var i = 0; i < children.length; i++){
        if(children[i].nodeName == "SELECT"){
            if(source.checked){
                children[i].removeAttribute('style');
                children[i].removeAttribute('disabled');
            }else{
                children[i].setAttribute('disabled','disabled');
                children[i].setAttribute('style','display:none');
            }
        }
    }  
}
function reloadSocialTab(uri){
    var objid=uri;
    var tab = dijit.byId(objid);
    if(tab)
    {
        var arr=tab.getChildren();
        for (var n = 0; n < arr.length; n++)
        {
            if(arr[n].selected === true){        
                arr[n].refresh();
                break;
            }
        }
    }
}


function validateExtention(uri,required){    
    var obj = dijit.byId(uri);   
    
    //Obtenemos los archivos seleccionados del FileUpload
    var inputfileArray = [];
    inputfileArray  =obj.inputNode.files;

    //El fileUpload debe contener archivos
    if(required){
        if(inputfileArray.length == 0){
            alert("Debes adjuntar al menos una imagen ");
            return false;       
        } 
    }
    
    // Se almacenan los archivos seleccionados  nombre , tama?o del archivo
    var inputImages = new Array();
    
    for (var i = 0; i < inputfileArray.length; i++) {                
        inputImages.push(inputfileArray[i].name+","+inputfileArray[i].size);             
    }   
    
    //Obtenemos las extensiones y tama?o  validos desde el formElement
    var typeFileValid = [];
    var validos = obj.get('fileMask');
    //console.log("VALIDOS:"+validos);
    var position = validos.toString().indexOf(",");   
    var sizeValid =parseInt( validos.toString().substring(0 , position));

    var res = validos.toString().substring(position+1 ,obj.get('fileMask').toString().length);
    while( res.indexOf("*") > -1)
    {
        res = res.replace("*", "");
    }   
    typeFileValid =  res.split(";");    
    
    var count = 0;
    var countSize = 0;    
    var nValidExtention ="";
    var nValidSize ="";

    
    for(j=0; j < inputImages.length ; j++ ){
        var image = inputImages[j]; //.toLowerCase();
        var position =  image.toString().indexOf(",");   
        var ima =  image.toString().substring(0 ,position);
        var size =parseInt(image.toString().substring(position+1, image.toString().length));
        var imgExt = ima.substring(ima.lastIndexOf("."));  //     var imgExt = ima.substring(ima.lastIndexOf(".") + 1);
        imgExt = imgExt.toLowerCase();
        if(typeFileValid.indexOf(imgExt) >= 0){   //si lo contiene
            count++;   
        }else{             
            nValidExtention += "\n"+ ima;
        }
        
        if(size > sizeValid){
            countSize++;  
            size= size/1024;
            nValidSize += "\n"+ ima + " - "+ Math.ceil(size) + "KB";
        }
    }

    if(count != inputImages.length  ){
        alert('Archivo con extensiones no validas: '+nValidExtention);
        return false;         
    }
    if(countSize > 0){
        alert('Tama\xf1o de archivo no permitido ' +nValidSize);
        return false;         
    }
    return true;        
}

function validateNetwork( formId, id){        
    var haveFacebook = false;
    var haveTwitter = false;   
    
    var checkYT = false;
    var checkRed = false;      
    
    var frm = document.getElementById(formId);    
    if(frm.checkRedes == null){//No networks
        alert("Debes crear primero una red en donde publicar");
        return false;
    }
    if(frm.checkYT != null){
        if(frm.checkRedes.length == null){
            if(frm.checkRedes.checked){//there is only one network
                //checkRed = true;
                checkYT = true;
                if(frm.checkRedes.name.indexOf("#social_Twitter:") != -1){
                    haveTwitter = true;
                //console.log('twitterFOUND');
                }
                if(frm.checkRedes.name.indexOf("#social_Facebook:") != -1){
                    haveFacebook = true
                //console.log('FacebookFOUND');
                }
            }
        }else{
            for (i = 0; i < frm.checkRedes.length; i++) {
                if (frm.checkRedes[i].checked){//Network is selected
                    checkYT = true;
                    if(frm.checkRedes[i].name.indexOf("#social_Twitter:") != -1){
                        haveTwitter = true;
                    //console.log('twitterFOUND');
                    }
                    if(frm.checkRedes[i].name.indexOf("#social_Facebook:") != -1){
                        haveFacebook = true
                    //console.log('FacebookFOUND');
                    }
                }
            }
        }
    }
    if(frm.checkRedes != null){
        if(frm.checkRedes.length == null){
            if(frm.checkRedes.checked){
                checkRed = true;
            }
        }else{
            for (j = 0; j < frm.checkRedes.length; j++) {
                if (frm.checkRedes[j].checked){
                    checkRed = true;
                    break;
                }
            }
        }
    }    
    if(checkYT == false && checkRed == false){
        alert("Debes seleccionar al menos una red");
        return false;
    }    
    return  validateExtention(id, true);     
}

function lookForInputs(children, images){
    if(children == null){
        return;
    }else{
        for(var i = 0; i < children.length; i++){
            if(children[i].nodeName === "INPUT"){
                if(children[i].value != null && children[i].value != "")
                {
                    images.push(children[i].value);
                }
            }
            var siblings = children[i].childNodes;            
            lookForInputs(siblings, images);
        }
    }
}

function validateVideo(id, formId){
    
    var haveFacebook = false;
    var haveYoutube = false;
    var checkYT = false;
    var checkRed = false;
     

    var frm = document.getElementById(formId);
    
    if(frm.checkRedes == null){//No networks
        alert("Debes crear primero una red en donde publicar");
        return false;
    }


    if(frm.checkYT != null){
        if(frm.checkYT.length == null){
            if(frm.checkYT.checked){//there is only one network
                //checkRed = true;
                checkYT = true;
                if(frm.checkYT.name.indexOf("#social_Youtube:") != -1){
                    haveYoutube = true;
                }
                if(frm.checkYT.name.indexOf("#social_Facebook:") != -1){
                    haveFacebook = true
                }
            }
        }else{
            for (i = 0; i < frm.checkYT.length; i++) {
                if (frm.checkYT[i].checked){//Network is selected
                    checkYT = true;
                    if(frm.checkYT[i].name.indexOf("#social_Youtube:") != -1){
                        haveYoutube = true;
                    }
                    if(frm.checkYT[i].name.indexOf("#social_Facebook:") != -1){
                        haveFacebook = true
                    }
                }
            }
        }
    }
    if(frm.checkRedes != null){
        if(frm.checkRedes.length == null){
            if(frm.checkRedes.checked){
                checkRed = true;
                if(frm.checkRedes.name.indexOf("#social_Youtube:") != -1){
                    haveYoutube = true;
                }
                if(frm.checkRedes.name.indexOf("#social_Facebook:") != -1){
                    haveFacebook = true
                }
            }
        }else{
            for (j = 0; j < frm.checkRedes.length; j++) {
                if (frm.checkRedes[j].checked){
                    checkRed = true;
                    if(frm.checkRedes[j].name.indexOf("#social_Youtube:") != -1){
                        haveYoutube = true;
                    }
                    if(frm.checkRedes[j].name.indexOf("#social_Facebook:") != -1){
                        haveFacebook = true
                    }
                    break;
                }
            }
        }
    }
    
    if(checkYT == false && checkRed == false){
        alert("Debes seleccionar al menos una red");
        return false;
    }    
    
    //Obtenemos el componente FileUpload
    var obj = dijit.byId(id);   

    //Obtenemos los archivos seleccionados del FileUpload
    var fileArray = [];
    fileArray  =obj.inputNode.files;

    //El fileUpload debe contener archivos
    if(fileArray.length == 0){
        alert("Debes adjuntar un video");
        return false;       
    } 
    
    //Obtenemos el fileMask del FileUpload 
    var validos = obj.get('fileMask');
    
    //Obtenemos el tama?o del archivo valido
    var position = validos.toString().indexOf(",");   
    var sizeValid = Number(""+validos.toString().substring(0 , position).toString()+"");

    //Obtenemos las extensiones validas
    var res = validos.toString().substring(position+1 ,obj.get('fileMask').toString().length);
    
    //Quitamos caracteres que no utilizamos; tales como * y ,
    var caracteres = ["*",";"];
    i=0;
    while (i<caracteres.length) {
        res = res.split(caracteres[i]).join("");
        i++
    }

    //Separamos los archivos validos para Facebook y para Youtube
    position  = res.toString().indexOf(",");
    var validFacebook =  res.substring(0, position);
    var validYoutube =  res.substring(position+1, res.toString().length);
    

    //Convertimos en arreglo el string 
    var arrFacebook = validFacebook.split(".");
    var arrYoutube = validYoutube.split(".");


    var countFacebook = 0;
    var countYoutube =0;    
    var countSizeFacebook = 0;
    var countSizeYoutube = 0;
    var nValidSizeFacebook ="";
    var nValidSizeYoutube ="";
    var name ="";
    var nValidExtentionFacebook ="";
    var nValidExtentionYoutube ="";
    var nameFile ="";

    var file;    
    for (var i = 0; i < fileArray.length; i++) {                
        file= fileArray[i].name+","+fileArray[i].size;             
    }   
        

    position =  file.indexOf(",");
    name = file.substring(0, position);
    var size = Number(""+file.substring(position+1, file.length).toString()+"");     
    position =  name.lastIndexOf(".");
    nameFile =  name.substring(position+1, name.length);

    if(haveFacebook){        
        if(arrFacebook.indexOf(nameFile) >= 0){   //si lo contiene
            countFacebook++;   
        }else{             
            nValidExtentionFacebook += "\n"+ name;
        }
                              
        if( size > sizeValid){                
            countSizeFacebook++;
            size= size/1024;
            nValidSizeFacebook += "\n"+ name+ " - "+ Math.ceil(size) + "KB";
        }
        
    }else{        
        countFacebook++;
    }
    
    if(haveYoutube){        
        if( arrYoutube.indexOf(nameFile)>0){ //la extension si es valida    
            countYoutube++;           
        } else{             
            nValidExtentionYoutube += "\n"+ name;
        }                            
        if( size > sizeValid){        
            countSizeYoutube ++;
            size= size/1024;
            nValidSizeYoutube += "\n"+ name+ " - "+ Math.ceil(size) + "KB";
        }        
    }else{
        countYoutube++;        
    }
    
    if(countFacebook == 0 ){
        alert('Archivo con extensi\xf3n no valida: '+nValidExtentionFacebook);
        return false;         
    }else if( countYoutube == 0){        
        alert('Archivo con extensi\xf3n no valida: '+nValidExtentionYoutube);
        return false;        
        
    }
    if(countSizeFacebook>0){        
        alert('Tama\xf1o de archivo no permitido ' +nValidSizeFacebook);
        return false;      
    }else if(countSizeYoutube){
        alert('Tama\xf1o de archivo no permitido ' +nValidSizeYoutube);
        return false;         
    }
    
    return true;
}
/** Splits a string into words, kees spaces inside text*/
function splitString(string) {        
    var words = string.split('');
    var finalW = [];//arreglo final
    //console.log(words);
   
    var singleWord = "";
    for (var i = 0, l = words.length; i < l; i++) {
        if(words[i] != " "){
            singleWord += words[i];
            if(i+1 === l){//si es el elemento final entonces agregarlo
                finalW.push(singleWord);
            }
        }else{//si es un espacio
            if(singleWord.length > 0){//Si habia una cadena concatenada
                finalW.push(singleWord);//se agrega
                if(i < l){//si hay mas caracteres se agrega un espacio
                    finalW.push(" ");
                }
                singleWord = "";//se limpia la cadena que concatena
            }else{//si es un espacio en blanco
                finalW.push(words[i]);
            }
        }
    }
    return finalW;
}


function count(id, idText){
    //document.getElementById(idText).value=document.getElementById(id).value.length;
    var string = document.getElementById(id).value;
    var words = splitString(string);
    //console.log('words:' + words);
    var totalWords = 0;
    for (var i = 0, l = words.length; i < l; i++) {
        ///if (words[i].match(/[-a-zA-Z0-9@:%_\+.~#?&//=]{2,256}\.[a-z]{2,4}\b(\/[-a-zA-Z0-9@:%_\+.~#?&//=]*)?/gi)) {
        if(words[i].match(/(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/)){
            //console.info('Elemento encontrado:->' + words[i] + "<-");
            totalWords = totalWords + 19;
        } else {
            totalWords = totalWords + words[i].length;
            //console.info('No aplica para:+>' + words[i] + "<+");
        }
    }
    document.getElementById(idText).value=totalWords;
    //console.log("TOTAL WORDS:" + totalWords);
}

function submitFormPostIn(formid, postUri)
{
    var obj = dojo.byId(formid);
    var objd = dijit.byId(formid);
    var fid = formid;
    //alert("id:"+formid+" "+"dojo:"+obj +" dijit:"+objd);
    if (!obj && objd) //si la forma esta dentro de un dialog
    {
        obj = objd.domNode;
        fid = obj;
    }

    if (!objd || objd.isValid())
    {
        try
        {
            //dojo.fadeOut({node: formid, duration: 1000}).play();
            dojo.fx.wipeOut({
                node: formid, 
                duration: 500
            }).play();
        } catch (noe) {
        }

        try {
            var framesNames = "";
            for (var i = 0; i < window.frames.length; i++) 
            {
                try
                {
                    framesNames += window.frames[i].name;
                    if (framesNames && framesNames.indexOf("_editArea") != -1) {
                        area = window.frames[framesNames].editArea;
                        id = framesNames.substr(6);
                        document.getElementById(id).value = area.textarea.value;
                    }
                }catch(e){}
            }
        } catch (ex) {
        }

        //alert("entra2");
        dojo.xhrPost({
            // The page that parses the POST request
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            //handleAs: "text",

            url: obj.action,
            // Name of the Form we want to submit
            form: fid,
            // Loads this function if everything went ok
            load: function(data)
            {
                try{
                    var tag=document.getElementById(postUri);
                    if(tag){                
                        tag.innerHTML = data;
                        var arrScript = tag.getElementsByTagName('script')
                        for (var n = 0; n < arrScript.length; n++){
                            eval(arrScript[n].innerHTML)//run script inside div
                        }
                    //console.log("RECEIVED:" + data);
                    }else {
                        console.log('Tag not found: ' + postUri);
                    }
                }catch (e) {
                    alert(e.message);
                }                
            },
            // Call this function if an error happened
            error: function(error) {
                alert('Error: ', error);
            }
        });
    } else
{
        alert("Datos Inv?lidos...");
    }
}

function postSocialPostInHtml(url, tagid)
{
    dojo.xhrPost({
        url: url,
        load: function(response)
        {
            var tag=dojo.byId(tagid);
            if(tag){
                var pan=dijit.byId(tagid);
                if(pan && pan.attr)
                {
                    pan.attr('content',response);
                }else
                {
                    tag.innerHTML = response;
                    var arrScript = tag.getElementsByTagName('script')
                    for (var n = 0; n < arrScript.length; n++){
                        eval(arrScript[n].innerHTML)//run script inside div
                    }
                }
            }else {
                console.log('Tag not found: ' + tagid);
            }
            return response;
        },
        error: function(response)
        {
            alert(response.status);
            if(dojo.byId(tagid)) {
            //dojo.byId(tagid).innerHTML = "<p>Ocurrio un error con respuesta:<br />" + response + "</p>";
            }else {
                console.log('Tag not found: ' + tagid);
            }
            return response;
        },
        handleAs: "text"
    });
}
/*
 *thisVar - the current value of the DateTextBox, the selected day
 *id - target TimeTextBox to put or remove constraint
 *today_hidden - the value of the current day (this value is set when the page loads)
 *
 *If the selected date(thisVar) is greater than today (today_hidden), then remove the constraint
 **/
function removeMin(thisVar, id, today_hidden, hour, minute){
    var dojoObj = dijit.byId(id);
        
    if((thisVar == null) || (thisVar == "") || (thisVar.length == 0)){
        //console.log('nothing selected!');
        dojoObj.setAttribute('disabled', true);
        dojoObj.setAttribute('value', "");
        return;        
    }
    dojoObj.setAttribute('disabled', false);
    var todayTmp = today_hidden + '';
    var todayArray = todayTmp.split("-");
    var todayDate = new Date(todayArray[0], parseInt(todayArray[1])-1, todayArray[2]);
    //console.log('This is today Date: ' + todayDate);

    var selectedTmp = thisVar  + '';        
    var selectedArray = selectedTmp.split("-");
    var selectedDate = new Date(selectedArray[0], parseInt(selectedArray[1])-1, selectedArray[2]);
    //console.log('This is the selected:' + selectedDate);
        
    //Returns a Number: 0 means the dates are equal : dejar o poner la constraint
    //1 if selectedDate > todayDate : quitar la constraint
    //and -1 if selectedDate < todayDate : no debe pasar
    var comparison = dojo.date.compare(selectedDate, todayDate , "date");
    if(comparison === 0){//Sobreescribir la constraint
        dijit.byId(id).constraints.min = new Date(1970, 0, 1, hour, minute, 00);
    }else if (comparison === 1){//Quitar la constraint
        dijit.byId(id).constraints.min = new Date(1970, 0, 1, 00, 00, 00);
    }else{//Hay un error
        return;
    }

    dojoObj.attr('value', dojoObj.attr('value'));
}

function myFunction(url) {
    var myWindow = window.open(url, "_blank", "width=800, height=600");
    //myWindow.opener.document.write("<p>This is the source window Edited!</p>");
    //window.showModalDialog(url, 'dialogWidth:800px; dialogHeight:600px; dialogLeft:10; dialogTop:10; center:1; status:0; help:0');
}

function clearInput(id) {
    if(dojo.byId(id) != null) {
        dojo.byId(id).value = '';
    }
}