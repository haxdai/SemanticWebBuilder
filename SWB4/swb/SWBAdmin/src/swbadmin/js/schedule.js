
//      // Para el recurso SWBASchedule           


 function enableTime(suri) {
     var time='off';
   if (dijit.byId(suri+"/time").checked) {
       time='on';
   }
   if (time=='on') {
       dijit.byId(suri+"/starthour").setDisabled(false);
       dijit.byId(suri+"/endhour").setDisabled(false);
       dijit.byId(suri+"/starthour").focus();
   }
   else if (time=='off') {
       dijit.byId(suri+"/starthour").setDisabled(true);
       dijit.byId(suri+"/endhour").setDisabled(true);
   }
}

 function enableTimer(suri) {
   var waittime='off';
   if (dijit.byId(suri+"/timerinter1").checked) {
       waittime='on';
   } else if (dijit.byId(suri+"/timerinter2").checked) {
       waittime='off';
   }
   if (waittime=='on') {
       dijit.byId(suri+"/timer").setDisabled(false);
       dijit.byId(suri+"/exechour").setDisabled(true);
       dijit.byId(suri+"/endhour").setDisabled(true);
       dijit.byId(suri+"/inter").setDisabled(true);
       dijit.byId(suri+"/time").setDisabled(true);
       dijit.byId(suri+"/timer").focus();
   }
   else if (waittime=='off') {
       dijit.byId(suri+"/timer").setDisabled(true);
       dijit.byId(suri+"/exechour").setDisabled(false);
       dijit.byId(suri+"/time").setDisabled(false);
       enableIntervalTime(suri);
       dijit.byId(suri+"/exechour").focus();
   }
}


 function enableIntervalTime(suri) {
     var time='off';
   if (dijit.byId(suri+"/time").checked) {
       time='on';
   }
   if (time=='on') {
       dijit.byId(suri+"/inter").setDisabled(false);
       dijit.byId(suri+"/endhour").setDisabled(false);
       dijit.byId(suri+"/inter").focus();
   }
   else if (time=='off') {
       dijit.byId(suri+"/inter").setDisabled(true);
       dijit.byId(suri+"/endhour").setDisabled(true);
   }
}
 
 function disablePeriodicity(suri) {
    var useP = false;
    if(dijit.byId(suri+'/periodicidad').checked)
        useP = true;
    if(useP)
     {
         dijit.byId(suri+"/period1").setDisabled(false);
         dijit.byId(suri+"/period2").setDisabled(false);
         dijit.byId(suri+"/period3").setDisabled(false);
      } 
    enableWeekly(suri);
    enableMonthly(suri);
    enableYearly(suri);   
    if(!useP)
     {
         dijit.byId(suri+"/period1").setDisabled(true);
         dijit.byId(suri+"/period2").setDisabled(true);
         dijit.byId(suri+"/period3").setDisabled(true);
     }
 }
 
 function enableWeekly(suri) {
     if(dijit.byId(suri+"/periodicidad").checked && dijit.byId(suri+"/period1").checked)
     {
        dijit.byId(suri+"/period1").setDisabled(false);
        dijit.byId(suri+"/period2").setDisabled(false);
        dijit.byId(suri+"/period3").setDisabled(false);
        dijit.byId(suri+"/wday1").setDisabled(false);
        dijit.byId(suri+"/wday2").setDisabled(false);
        dijit.byId(suri+"/wday3").setDisabled(false);
        dijit.byId(suri+"/wday4").setDisabled(false);
        dijit.byId(suri+"/wday5").setDisabled(false);
        dijit.byId(suri+"/wday6").setDisabled(false);
        dijit.byId(suri+"/wday7").setDisabled(false);
     }
     else if(!dijit.byId(suri+"/periodicidad").checked || !dijit.byId(suri+"/period1").checked)
     {
        dijit.byId(suri+"/wday1").setDisabled(true);
        dijit.byId(suri+"/wday2").setDisabled(true);
        dijit.byId(suri+"/wday3").setDisabled(true);
        dijit.byId(suri+"/wday4").setDisabled(true);
        dijit.byId(suri+"/wday5").setDisabled(true);
        dijit.byId(suri+"/wday6").setDisabled(true);
        dijit.byId(suri+"/wday7").setDisabled(true);
     }
 }

 function enableMonthly(suri) {
      if(dijit.byId(suri+"/periodicidad").checked && dijit.byId(suri+"/period2").checked)
     {
         dijit.byId(suri+"/smonth1").setDisabled(false); 
         dijit.byId(suri+"/smonth2").setDisabled(false);
         if(!dijit.byId(suri+"/smonth1").checked && !dijit.byId(suri+"/smonth2").checked)
             {
                 dijit.byId(suri+"/smonth1").checked = "checked";  
                 dijit.byId(suri+"/smonth2").checked = "";
             } 
     }
     
   if(dijit.byId(suri+"/smonth1").checked && dijit.byId(suri+"/smonth2").checked)
     {
         dijit.byId(suri+"/smonth1").checked = "checked";  
         dijit.byId(suri+"/smonth2").checked = "";
     } 
     
   
   if(dijit.byId(suri+"/periodicidad").checked && dijit.byId(suri+"/period2").checked && dijit.byId(suri+"/smonth1").checked)
     {
         //alert('periodicidad..1');
         
        dijit.byId(suri+"/smonth1").setDisabled(false); 
        dijit.byId(suri+"/mmday").setDisabled(false); 
        dijit.byId(suri+"/mmday2").setDisabled(false); 
        dijit.byId(suri+"/mmonths1").setDisabled(false); 
        
        dijit.byId(suri+"/smonth2").setDisabled(false);
        dijit.byId(suri+"/mweek").setDisabled(true);
        dijit.byId(suri+"/mmonths2").setDisabled(true);
        
        dijit.byId(suri+"/mday1").setDisabled(true);
        dijit.byId(suri+"/mday2").setDisabled(true);
        dijit.byId(suri+"/mday3").setDisabled(true);
        dijit.byId(suri+"/mday4").setDisabled(true);
        dijit.byId(suri+"/mday5").setDisabled(true);
        dijit.byId(suri+"/mday6").setDisabled(true);
        dijit.byId(suri+"/mday7").setDisabled(true);

     }
   else if(dijit.byId(suri+"/periodicidad").checked && dijit.byId(suri+"/period2").checked && dijit.byId(suri+"/smonth2").checked)
     {
         //alert('periodicidad..2');
         
        dijit.byId(suri+"/smonth1").setDisabled(false);
        dijit.byId(suri+"/mmday").setDisabled(true); 
        dijit.byId(suri+"/mmday2").setDisabled(true); 
        dijit.byId(suri+"/mmonths1").setDisabled(true); 
        
        dijit.byId(suri+"/smonth2").setDisabled(false);
        dijit.byId(suri+"/mweek").setDisabled(false);
        dijit.byId(suri+"/mmonths2").setDisabled(false);
        
        dijit.byId(suri+"/mday1").setDisabled(false);
        dijit.byId(suri+"/mday2").setDisabled(false);
        dijit.byId(suri+"/mday3").setDisabled(false);
        dijit.byId(suri+"/mday4").setDisabled(false);
        dijit.byId(suri+"/mday5").setDisabled(false);
        dijit.byId(suri+"/mday6").setDisabled(false);
        dijit.byId(suri+"/mday7").setDisabled(false);   
     }
     else if(!dijit.byId(suri+"/periodicidad").checked || !dijit.byId(suri+"/period2").checked)
     {
         //alert('periodicidad..3');
         
        dijit.byId(suri+"/smonth1").setDisabled(true);
        dijit.byId(suri+"/mmday").setDisabled(true); 
        dijit.byId(suri+"/mmday2").setDisabled(true); 
        dijit.byId(suri+"/mmonths1").setDisabled(true); 
        
        dijit.byId(suri+"/smonth2").setDisabled(true);
        dijit.byId(suri+"/mweek").setDisabled(true);
        dijit.byId(suri+"/mmonths2").setDisabled(true);
        
        dijit.byId(suri+"/mday1").setDisabled(true);
        dijit.byId(suri+"/mday2").setDisabled(true);
        dijit.byId(suri+"/mday3").setDisabled(true);
        dijit.byId(suri+"/mday4").setDisabled(true);
        dijit.byId(suri+"/mday5").setDisabled(true);
        dijit.byId(suri+"/mday6").setDisabled(true);
        dijit.byId(suri+"/mday7").setDisabled(true);
     }
 }
 
 
 function enableYearly(suri) {
     
   if(dijit.byId(suri+"/periodicidad").checked && dijit.byId(suri+"/period3").checked)
     {
         dijit.byId(suri+"/radio1").setDisabled(false); 
         dijit.byId(suri+"/radio2").setDisabled(false); 
         if(!dijit.byId(suri+"/radio1").checked && !dijit.byId(suri+"/radio2").checked)
             {
                 dijit.byId(suri+"/radio1").checked = "checked";  
                 dijit.byId(suri+"/radio2").checked = "";
             } 
     }
     
   if(dijit.byId(suri+"/radio1").checked && dijit.byId(suri+"/radio2").checked)
     {
         dijit.byId(suri+"/radio1").checked = "checked";  
         dijit.byId(suri+"/radio2").checked = "";
     } 
   
   if(dijit.byId(suri+"/periodicidad").checked && dijit.byId(suri+"/period3").checked && dijit.byId(suri+"/radio1").checked)
     {
        dijit.byId(suri+"/radio1").setDisabled(false); 
        dijit.byId(suri+"/text1").setDisabled(false); 
        dijit.byId(suri+"/text12").setDisabled(false); 
        dijit.byId(suri+"/selectm1").setDisabled(false); 
        dijit.byId(suri+"/text2").setDisabled(false); 
        
        dijit.byId(suri+"/radio2").setDisabled(false);
        dijit.byId(suri+"/select1").setDisabled(true);
        dijit.byId(suri+"/selectm2").setDisabled(true);
        dijit.byId(suri+"/text3").setDisabled(true); 
        
        dijit.byId(suri+"/yday1").setDisabled(true);
        dijit.byId(suri+"/yday2").setDisabled(true);
        dijit.byId(suri+"/yday3").setDisabled(true);
        dijit.byId(suri+"/yday4").setDisabled(true);
        dijit.byId(suri+"/yday5").setDisabled(true);
        dijit.byId(suri+"/yday6").setDisabled(true);
        dijit.byId(suri+"/yday7").setDisabled(true);

     }
   else if(dijit.byId(suri+"/periodicidad").checked && dijit.byId(suri+"/period3").checked && dijit.byId(suri+"/radio2").checked)
     {
        dijit.byId(suri+"/radio1").setDisabled(false);
        dijit.byId(suri+"/text1").setDisabled(true); 
        dijit.byId(suri+"/text12").setDisabled(true); 
        dijit.byId(suri+"/selectm1").setDisabled(true); 
        dijit.byId(suri+"/text2").setDisabled(true); 
        
        dijit.byId(suri+"/radio2").setDisabled(false);
        dijit.byId(suri+"/select1").setDisabled(false);
        dijit.byId(suri+"/selectm2").setDisabled(false);
        dijit.byId(suri+"/text3").setDisabled(false); 
        
        dijit.byId(suri+"/yday1").setDisabled(false);
        dijit.byId(suri+"/yday2").setDisabled(false);
        dijit.byId(suri+"/yday3").setDisabled(false);
        dijit.byId(suri+"/yday4").setDisabled(false);
        dijit.byId(suri+"/yday5").setDisabled(false);
        dijit.byId(suri+"/yday6").setDisabled(false);
        dijit.byId(suri+"/yday7").setDisabled(false);
   
     }
     else if(!dijit.byId(suri+"/periodicidad").checked || !dijit.byId(suri+"/period3").checked)
     {
        dijit.byId(suri+"/radio1").setDisabled(true);
        dijit.byId(suri+"/text1").setDisabled(true);
        dijit.byId(suri+"/text12").setDisabled(true);
        dijit.byId(suri+"/selectm1").setDisabled(true);
        dijit.byId(suri+"/text2").setDisabled(true);
        
        dijit.byId(suri+"/radio2").setDisabled(true);
        dijit.byId(suri+"/select1").setDisabled(true);
        dijit.byId(suri+"/selectm2").setDisabled(true);
        dijit.byId(suri+"/text3").setDisabled(true); 
        
        dijit.byId(suri+"/yday1").setDisabled(true);
        dijit.byId(suri+"/yday2").setDisabled(true);
        dijit.byId(suri+"/yday3").setDisabled(true);
        dijit.byId(suri+"/yday4").setDisabled(true);
        dijit.byId(suri+"/yday5").setDisabled(true);
        dijit.byId(suri+"/yday6").setDisabled(true);
        dijit.byId(suri+"/yday7").setDisabled(true);
     }
  
 }
 
function selectCombo(obj,id) 
{
   obj.selectedIndex=id;
}