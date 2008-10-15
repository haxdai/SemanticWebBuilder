/*
	Copyright (c) 2004-2008, The Dojo Foundation All Rights Reserved.
	Available via Academic Free License >= 2.1 OR the modified BSD license.
	see: http://dojotoolkit.org/license for details
*/


if(!dojo._hasResource["dojox.robot.recorder"]){
dojo._hasResource["dojox.robot.recorder"]=true;
dojo.provide("dojox.robot.recorder");
dojo.experimental("dojox.robot.recorder");
(function(){
var _1=1000;
var _2=500;
var _3=10000;
var _4=[];
var _5=0;
var _6=null;
var _7=null;
var _8=function(){
alert("Started recording.");
_4=[];
_6=new Date();
_7=new Date();
};
var _9=function(_a,_b){
if(_6==null||_a=="doh.robot.keyPress"&&_b[0]==dojo.keys.ENTER&&eval("("+_b[2]+")").ctrl&&eval("("+_b[2]+")").alt){
return;
}
var dt=Math.max(Math.min(Math.round((new Date()).getTime()-_7.getTime()),_3),1);
if(_a=="doh.robot.mouseMove"){
_b[2]=dt;
}else{
_b[1]=dt;
}
_4.push({name:_a,args:_b});
_7=new Date();
};
var _d=function(){
var c=_4;
if(c[0].name=="doh.robot.keyPress"&&(c[0].args[0]==dojo.keys.ENTER||c[0].args[0]==77)){
c.splice(0,1);
}
for(var i=c.length-1;(i>=c.length-2)&&(i>=0);i--){
if(c[i].name=="doh.robot.keyPress"&&c[i].args[0]==dojo.keys.ALT||c[i].args[0]==dojo.keys.CTRL){
c.splice(i,1);
}
}
for(i=0;i<c.length;i++){
var _10,_11;
if(c[i+1]&&c[i].name=="doh.robot.mouseMove"&&c[i+1].name==c[i].name&&c[i+1].args[2]<_2){
_10=c[i+1];
_11=0;
while(_10&&_10.name==c[i].name&&_10.args[2]<_2){
c.splice(i+1,1);
_11+=_10.args[2];
c[i].args[0]=_10.args[0];
c[i].args[1]=_10.args[1];
_10=c[i+1];
}
c[i].args[3]=_11;
}else{
if(c[i+1]&&c[i].name=="doh.robot.mouseWheel"&&c[i+1].name==c[i].name&&c[i+1].args[1]<_2){
_10=c[i+1];
_11=0;
while(_10&&_10.name==c[i].name&&_10.args[1]<_2){
c.splice(i+1,1);
_11+=_10.args[1];
c[i].args[0]+=_10.args[0];
_10=c[i+1];
}
c[i].args[2]=_11;
}else{
if(c[i+2]&&c[i].name=="doh.robot.mouseMoveAt"&&c[i+2].name=="doh.robot.scrollIntoView"){
var _12=c.splice(i+2,1)[0];
c.splice(i,0,_12);
}else{
if(c[i+1]&&c[i].name=="doh.robot.mousePress"&&c[i+1].name=="doh.robot.mouseRelease"&&c[i].args[0]==c[i+1].args[0]){
c[i].name="doh.robot.mouseClick";
c.splice(i+1,1);
if(c[i+1]&&c[i+1].name=="doh.robot.mouseClick"&&c[i].args[0]==c[i+1].args[0]){
c.splice(i+1,1);
}
}else{
if(c[i+1]&&c[i-1]&&c[i-1].name=="doh.robot.mouseMoveAt"&&c[i].name=="doh.robot.mousePress"&&c[i+1].name=="doh.robot.mouseMove"){
var cmd={name:"doh.robot.mouseMoveAt",args:[c[i-1].args[0],1,100,c[i-1].args[3]+1,c[i-1].args[4]]};
c.splice(i+1,0,cmd);
}else{
if(c[i+1]&&((c[i].name=="doh.robot.keyPress"&&typeof c[i].args[0]=="string")||c[i].name=="doh.robot.typeKeys")&&c[i+1].name=="doh.robot.keyPress"&&typeof c[i+1].args[0]=="string"&&c[i+1].args[1]<=_1&&!eval("("+c[i].args[2]+")").ctrl&&!eval("("+c[i].args[2]+")").alt&&!eval("("+c[i+1].args[2]+")").ctrl&&!eval("("+c[i+1].args[2]+")").alt){
c[i].name="doh.robot.typeKeys";
c[i].args.splice(3,1);
_10=c[i+1];
var _14=0;
while(_10&&_10.name=="doh.robot.keyPress"&&typeof _10.args[0]=="string"&&_10.args[1]<=_1&&!eval("("+_10.args[2]+")").ctrl&&!eval("("+_10.args[2]+")").alt){
c.splice(i+1,1);
c[i].args[0]+=_10.args[0];
_14+=_10.args[1];
_10=c[i+1];
}
c[i].args[2]=_14;
c[i].args[0]="'"+c[i].args[0]+"'";
}else{
if(c[i].name=="doh.robot.keyPress"){
if(typeof c[i].args[0]=="string"){
c[i].args[0]="'"+c[i].args[0]+"'";
}else{
if(c[i].args[0]==0){
c.splice(i,1);
}else{
for(var j in dojo.keys){
if(dojo.keys[j]==c[i].args[0]){
c[i].args[0]="dojo.keys."+j;
break;
}
}
}
}
}
}
}
}
}
}
}
}
};
var _16=function(){
if(!_6){
_8();
}else{
_17();
}
};
var _17=function(){
var dt=Math.round((new Date()).getTime()-_6.getTime());
_6=null;
_d();
var c=_4;

if(c.length){
var s="doh.register('dojox.robot.AutoGeneratedTestGroup',{\n";
s+="     name: 'autotest"+(_5++)+"',\n";
s+="     timeout: "+(dt+2000)+",\n";
s+="     runTest: function(){\n";
s+="          var d = new doh.Deferred();\n";
for(var i=0;i<c.length;i++){
s+="          "+c[i].name+"(";
for(var j=0;j<c[i].args.length;j++){
var arg=c[i].args[j];
s+=arg;
if(j!=c[i].args.length-1){
s+=", ";
}
}
s+=");\n";
}
s+="          doh.robot.sequence(function(){\n";
s+="               if(/*Your condition here*/){\n";
s+="                    d.callback(true);\n";
s+="               }else{\n";
s+="                    d.errback(new Error('We got a failure'));\n";
s+="               }\n";
s+="          }, 1000);\n";
s+="          return d;\n";
s+="     }\n";
s+="});\n";
var div=document.createElement("div");
div.id="dojox.robot.recorder";
div.style.backgroundColor="white";
div.style.position="absolute";
var _1f={y:(window.pageYOffset||document.documentElement.scrollTop||document.body.scrollTop||0),x:(window.pageXOffset||(window["dojo"]?dojo._fixIeBiDiScrollLeft(document.documentElement.scrollLeft):undefined)||document.body.scrollLeft||0)};
div.style.left=_1f.x+"px";
div.style.top=_1f.y+"px";
var h1=document.createElement("h1");
h1.innerHTML="Your code:";
div.appendChild(h1);
var pre=document.createElement("pre");
if(pre.innerText!==undefined){
pre.innerText=s;
}else{
pre.textContent=s;
}
div.appendChild(pre);
var _22=document.createElement("button");
_22.innerHTML="Close";
var _23=dojo.connect(_22,"onmouseup",function(e){
dojo.stopEvent(e);
document.body.removeChild(div);
dojo.disconnect(_23);
});
div.appendChild(_22);
document.body.appendChild(div);
_4=[];
}
};
var _25=function(_26){
if(typeof _26=="string"){
return "'"+_26+"'";
}else{
if(_26.id){
return "'"+_26.id+"'";
}else{
var _27=document.getElementsByTagName(_26.nodeName);
var i;
for(i=0;i<_27.length;i++){
if(_27[i]==_26){
break;
}
}
return "function(){ return document.getElementsByTagName('"+_26.nodeName+"')["+i+"]; }";
}
}
};
var _29=function(b){
return "{left:"+(b==0)+", middle:"+(b==1)+", right:"+(b==2)+"}";
};
var _2b=function(e){
return "{'shift':"+(e.shiftKey)+", 'ctrl':"+(e.ctrlKey)+", 'alt':"+(e.altKey)+"}";
};
dojo.connect(document,"onkeydown",function(e){
if((e.keyCode==dojo.keys.ENTER||e.keyCode==77)&&e.ctrlKey&&e.altKey){
dojo.stopEvent(e);
_16();
}
});
var _2e={type:""};
var _2f=function(e){
if(!e||_2e.type==e.type&&_2e.button==e.button){
return;
}
_2e={type:e.type,button:e.button};
var _31=_25(e.target);
var _32=dojo.coords(e.target);
_9("doh.robot.mouseMoveAt",[_31,0,100,e.clientX-_32.x,e.clientY-_32.y]);
_9("doh.robot.mousePress",[_29(e.button-(dojo.isIE?1:0)),0]);
};
var _33=function(e){
if(!e||_2e.type==e.type&&_2e.button==e.button){
return;
}
_2e={type:e.type,button:e.button};
var _35=_25(e.target);
var _36=dojo.coords(e.target);
_9("doh.robot.mouseClick",[_29(e.button-(dojo.isIE?1:0)),0]);
};
var _37=function(e){
if(!e||_2e.type==e.type&&_2e.button==e.button){
return;
}
_2e={type:e.type,button:e.button};
var _39=_25(e.target);
var _3a=dojo.coords(e.target);
_9("doh.robot.mouseRelease",[_29(e.button-(dojo.isIE?1:0)),0]);
};
var _3b=function(e){
if(!e||_2e.type==e.type&&_2e.pageX==e.pageX&&_2e.pageY==e.pageY){
return;
}
_2e={type:e.type,pageX:e.pageX,pageY:e.pageY};
_9("doh.robot.mouseMove",[e.pageX,e.pageY,0,100,true]);
};
var _3d=function(e){
if(!e||_2e.type==e.type&&_2e.pageX==e.pageX&&_2e.pageY==e.pageY){
return;
}
_2e={type:e.type,detail:(e.detail?(e.detail):(-e.wheelDelta/120))};
_9("doh.robot.mouseWheel",[_2e.detail]);
};
var _3f=function(e){
if(!e||_2e.type==e.type&&(_2e.charCode==e.charCode&&_2e.keyCode==e.keyCode)){
return;
}
_2e={type:e.type,charCode:e.charCode,keyCode:e.keyCode};
_9("doh.robot.keyPress",[e.charOrCode==dojo.keys.SPACE?" ":e.charOrCode,0,_2b(e)]);
};
var _41=function(e){
if(!e||_2e.type==e.type&&(_2e.charCode==e.charCode&&_2e.keyCode==e.keyCode)){
return;
}
_2e={type:e.type,charCode:e.charCode,keyCode:e.keyCode};
};
dojo.connect(document,"onmousedown",_2f);
dojo.connect(document,"onmouseup",_37);
dojo.connect(document,"onclick",_33);
dojo.connect(document,"onkeypress",_3f);
dojo.connect(document,"onkeyup",_41);
dojo.connect(document,"onmousemove",_3b);
dojo.connect(document,!dojo.isMozilla?"onmousewheel":"DOMMouseScroll",_3d);
dojo.addOnLoad(function(){
if(window["dijit"]&&dijit.scrollIntoView){
dojo.connect(dijit,"scrollIntoView",function(_43){
_9("doh.robot.scrollIntoView",[_25(_43)]);
});
}
});
dojo.connect(dojo,"connect",function(_44,_45,f){
if(_44&&(!f||!f._mine)){
var _47=null;
if(_45.toLowerCase()=="onmousedown"){
_47=dojo.hitch(this,_2f);
}else{
if(_45.toLowerCase()==(!dojo.isMozilla?"onmousewheel":"dommousescroll")){
_47=dojo.hitch(this,_3d);
}else{
if(_45.toLowerCase()=="onclick"){
_47=dojo.hitch(this,_33);
}else{
if(_45.toLowerCase()=="onmouseup"){
_47=dojo.hitch(this,_37);
}else{
if(_45.toLowerCase()=="onkeypress"){
_47=dojo.hitch(this,_3f);
}else{
if(_45.toLowerCase()=="onkeyup"){
_47=dojo.hitch(this,_41);
}
}
}
}
}
}
if(_47==null){
return;
}
_47._mine=true;
dojo.connect(_44,_45,_47);
}
});
})();
}
