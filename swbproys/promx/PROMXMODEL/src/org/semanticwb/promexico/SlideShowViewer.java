package org.semanticwb.promexico;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.servlet.http.*;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.*;

public class SlideShowViewer extends org.semanticwb.promexico.base.SlideShowViewerBase 
{

    public SlideShowViewer()
    {
    }

   /**
   * Constructs a SlideShowViewer with a SemanticObject
   * @param base The SemanticObject with the properties for the SlideShowViewer
   */
    public SlideShowViewer(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        Iterator<PictureSlide>it = listPictureSlideses();
        List<PictureSlide> rs = SWBUtils.Collections.copyIterator(it);
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        if(rs.size()>0) {
            StringBuilder preload = new StringBuilder();
            StringBuilder script = new StringBuilder();
            String url = "#";
            int i = 0;

            Iterator<SlideButton> bttns = listButtonses();
            String txtButtons = "";
            String creaButtons = "";
            while(bttns.hasNext()) {
                SlideButton button = bttns.next();
                if(txtButtons.trim().length() > 1) {
                    txtButtons = txtButtons + "|";
                }
                String tit = button.getBtnTitle() == null ? "" : button.getBtnTitle();
                String redi = "" ;
                if(button.getBtnRedirect() != null) {
                     WebPage redirec = paramRequest.getWebPage().getWebSite().getWebPage(button.getBtnRedirect());
                     redi = redirec.getUrl(user.getLanguage());
                }
                txtButtons = txtButtons + tit + "|" + redi + "|" + button.isBtnNewWindow();
                String tar = "";
                if(button.isBtnNewWindow()) {
                    tar = "target='_blank'";
                } /*else {
                    creaButtons = creaButtons + "<input type=\"button\" onclick=\"javascript:window.location='" + redi + "';\" value=\"" + tit + "\">";
                }*/
                creaButtons = creaButtons + "<li><a href=\"" + redi + "\"" + tar + ">" + tit + "</a></li>"; //target=\"_blank\"
            }


            for(PictureSlide pic:rs) {
                if(pic.isValid() && user.haveAccess(pic)) {
                    url = (pic.getExternalURL()==null || pic.getExternalURL().isEmpty()) ? (pic.getInternalURL() == null || pic.getInternalURL().isEmpty() ? "#" : pic.getInternalURL()) : pic.getExternalURL();

                    preload.append(" var imagen").append(i).append(" = new Image(); imagen").append(i++).append(".src = '").append(SWBPortal.getWebWorkPath()).append(pic.getWorkPath()).append("/").append("poster_").append(pic.getId()).append("_").append(pic.getPoster()).append("';\n");
                    //script.append("  <a href=\"javascript:nav('crwlr_bckg','").append(SWBPortal.getWebWorkPath()).append(pic.getWorkPath()).append("/").append("poster_").append(pic.getId()).append("_").append(pic.getPoster()).append("','").append(url).append("')\" title=\"").append(pic.getTitle(lang)).append("\" class=\"crwlr_a\"><img alt=\"").append(pic.getAlt(lang)).append("\" class=\"crwlr_img\" src=\"").append(SWBPortal.getWebWorkPath()).append(pic.getWorkPath()).append("/").append("thmbn_").append(pic.getId()).append("_").append(pic.getThmbn()).append("\" /></a>\n");
                }   script.append("  <a href=\"javascript:nav('crwlr_bckg','" + SWBPortal.getWebWorkPath() + pic.getWorkPath() + "/poster_" + pic.getId() + "_" + pic.getPoster() + "','" +
                    url + "','" + (pic.getTitle(lang) == null ? (pic.getTitle() == null ? "" : pic.getTitle()) : pic.getTitle(lang)) +
                    "','" + (pic.getDescription(lang) == null ? (pic.getDescription() == null ? "" : pic.getDescription()) : pic.getDescription(lang)) +
                    "', '" + txtButtons + "')\" title=\"" + (pic.getTitle(lang) == null ? (pic.getTitle() == null ? "" : pic.getTitle()) : pic.getTitle(lang)) +
                    "\" class=\"crwlr_a\"><img alt=\"" + (pic.getAlt(lang) == null ? (pic.getAlt() == null ? "" : pic.getAlt()) : pic.getAlt(lang)) +
                    "\" class=\"promx_crwlr_img\" onclick=\"javascript:pause()\" src=\"" + SWBPortal.getWebWorkPath() + pic.getWorkPath() + "/thmbn_" + pic.getId() + "_" + pic.getThmbn() + "\" /></a>\n");
            }

            /* script que permite altenar las imagenes al cargarse */
            out.println("<script type=\"text/javascript\">");
            out.println("/*****************************************************************************");
            out.println("   Presentación de Imágenes (SlideShow) por Tunait!");
            out.println("   Actualizado el 28/12/2003");
            out.println("   http://javascript.tunait.com");
            out.println("   tunait@yahoo.com ");
            out.println("******************************************************************************/");
            out.println("   var segundos = 6; //cada cuantos segundos cambia la imagen");
            out.println("   var randomImages = new Array();");
            out.println("   var randomText = new Array();");
            out.println("   var randomDescr = new Array();");
            String path = "";
            int k = 0;
            for(PictureSlide pic:rs) {
                if(pic.isValid() && user.haveAccess(pic)) {
                    path = SWBPortal.getWebWorkPath() + pic.getWorkPath() + "/" + "poster_" + pic.getId() + "_" + pic.getPoster();
                    out.println("   randomImages[" + k +"] = '" + path + "';");
                    String rTitle = pic.getTitle(lang) == null ? (pic.getTitle() == null ? "" : pic.getTitle()) : pic.getTitle(lang);
                    String rDescr = pic.getDescription(lang) == null ? (pic.getDescription() == null ? "" : pic.getDescription()) : pic.getDescription(lang);
                    out.println("   randomText[" + k + "] = '" + rTitle +"';");
                    out.println("   randomDescr[" + k + "] = '" + rDescr +"';");
                    k = k + 1;
                }
            }
            out.println("   var preImagenes = new Array();");
            out.println("   for (pre = 0; pre < randomImages.length; pre++) {");
            out.println("      preImagenes[pre] = new Image();");
            out.println("      preImagenes[pre].src = randomImages[pre];");
            out.println("   }");
            out.println("   cont = 0;");
            out.println("   var isClick = false;");
            out.println("   function presImagen() {");
            out.println("      var el = document.getElementById('crwlr_bckg')");
            out.println("      el.setAttribute('src', randomImages[cont])");
            out.println("      el = document.getElementById('pic_title');");
            out.println("      var texto = document.createTextNode(randomText[cont]);");
            out.println("      if(el.hasChildNodes()) {");
            out.println("          el.removeChild(el.firstChild);");
            out.println("      }");
            out.println("      el.appendChild(texto);");
            out.println("      el = document.getElementById('pic_desc');");
            out.println("      texto = document.createTextNode(randomDescr[cont]);");
            out.println("      if(el.hasChildNodes()) {");
            out.println("          el.removeChild(el.firstChild);");
            out.println("      }");
            out.println("      el.appendChild(texto);");
            out.println("      subeOpacidad();");
            out.println("      if (cont < randomImages.length-1) {");
            out.println("         cont++;");
            out.println("      } else {");
            out.println("         cont=0;");
            out.println("      }");
            out.println("      tiempo=window.setTimeout('bajaOpacidad()',segundos*1200);");
            out.println("   }");
            out.println("   var iex = navigator.appName==\"Microsoft Internet Explorer\" ? true : false;");
          //  out.println("   var fi = iex?'filters.alpha.opacity=40':'style.MozOpacity';");
            out.println("   var opa = iex ? 100 : 1;");
            out.println("   function bajaOpacidad() {");
            out.println("      if(!isClick) {");
            out.println("         eval(opa);");
            out.println("         if(opa >= 0) {");
            out.println("            cambia();");
            out.println("            opa -= iex ? 10 : 0.1;");
            out.println("            setTimeout('bajaOpacidad()',10);");
            out.println("         } else {");
            out.println("            presImagen();");
            out.println("         }");
            out.println("      }");
            out.println("   }");
            out.println("   function subeOpacidad() {");
            out.println("      if(!isClick) {");
            out.println("         opaci = iex ? 100 : 1;");
            out.println("         if(opa <= opaci) {");
            out.println("            cambia();");
            out.println("            opa += iex ? 10 : 0.1;");
            out.println("            setTimeout('subeOpacidad()',10);");
            out.println("         }");
            out.println("      }");
            out.println("   }");
            out.println("   function cambia() {");
            out.println("      if(!isClick) {");
            out.println("         var el = document.getElementById('crwlr_bckg');");
            out.println("         if(navigator.userAgent.match('MSIE')) {");
            out.println("            el.style.filter='alpha(opacity='+opa+');'");
            out.println("         } else {");
            out.println("            var el = document.getElementById('crwlr_bckg');");
            out.println("            el.style.MozOpacity = opa;");
            out.println("         }");
            out.println("      }");
            out.println("   }");
            out.println("   var tiempo;");
            out.println("   function inicio() {");
            out.println("      if(!isClick) {");
            out.println("         clearTimeout(tiempo);");
            out.println("         bajaOpacidad();");
            out.println("      }");
            out.println("   }");
            out.println("   function pause() {");
            out.println("      isClick = true;");
            out.println("   }");
            out.println("</script>");
            /* -------------------fin de mostrar imagenes cada determinad tiempo-------------*/

            out.println(getScript());
            out.println("<script type=\"text/javascript\">");
            out.println(preload.toString());
            out.println("  function nav(id, img, url, title, desc, buttons) {");
            out.println("    var arraButon = buttons.split('|')");
            out.println("    var createButtons = ''");
            out.println("    if(arraButon.length > 1) {");
            out.println("    for (i=0;i<arraButon.length;i=i+3){");
            out.println("       var ur = '';");
            out.println("       if(arraButon[i+2] == 'true') {");
            out.println("          ur = \"target='_blank';\"");
            out.println("       }");
            out.println("       createButtons = createButtons + '<li><a href=\"' + arraButon[i + 1] + '\" ' + ur + '>' + arraButon[i] + '</a></li> ';");//+ tar
            out.println("    }");
            out.println("    }");
            out.println("    document.getElementById('subhome_btns').innerHTML=createButtons;");
            out.println("    obj = document.getElementById(id)");
            out.println("    if(obj) {");
            out.println("      obj.src=img;");
            out.println("      if(url || url!='#')");
            out.println("        obj.parentNode.href=url;");
            out.println("    }");
            out.println("    document.getElementById('pic_title').innerHTML=title;");
            out.println("    document.getElementById('pic_desc').innerHTML=desc;");
            out.println("  }");
            out.println("</script>");

            //out.println("<div class=\"promx-slideshow\" id=\"promx-slideshow\">");//Si se desea agregar los botones siguiente/anterior
            out.println("<div class=\"promx-slideshow\">");
            Random r = new Random();
            r.setSeed((new Date()).getTime());
            i = r.nextInt(rs.size());
            url = rs.get(i).getExternalURL()==null || rs.get(i).getExternalURL().isEmpty()?rs.get(i).getInternalURL():rs.get(i).getExternalURL();
            if(url != null) {
                if(isTargetNew()) {
                    out.println("  <a href=\""+url+"\" target=\"_blank\" class=\"crwlr_a\"><img id=\"crwlr_bckg\" onclick=\"javascript:pause()\" class=\"promx_crwlr_img\" src=\""+SWBPortal.getWebWorkPath()+rs.get(i).getWorkPath()+"/poster_"+rs.get(i).getId()+"_"+rs.get(i).getPoster()+"\" alt=\""+(rs.get(i).getAlt(lang)==null?rs.get(i).getAlt():rs.get(i).getAlt(lang))+"\" /></a>");
                }  else {
                    out.println("  <a href=\""+url+"\" class=\"crwlr_a\"><img id=\"crwlr_bckg\" onclick=\"javascript:pause()\" class=\"promx_crwlr_img\" src=\""+SWBPortal.getWebWorkPath()+rs.get(i).getWorkPath()+"/poster_"+rs.get(i).getId()+"_"+rs.get(i).getPoster()+"\" alt=\""+(rs.get(i).getAlt(lang)==null?rs.get(i).getAlt():rs.get(i).getAlt(lang))+"\" /></a>");
                }
            } else {
                if(isTargetNew()) {
                    out.println("  <img id=\"crwlr_bckg\" onclick=\"javascript:pause()\" class=\"promx_crwlr_img\" src=\""+SWBPortal.getWebWorkPath()+rs.get(i).getWorkPath()+"/poster_"+rs.get(i).getId()+"_"+rs.get(i).getPoster()+"\" alt=\""+(rs.get(i).getAlt(lang)==null ? (rs.get(i).getAlt() == null ? "" : rs.get(i).getAlt()) : rs.get(i).getAlt(lang))+"\" />");
                }  else {
                    out.println("  <img id=\"crwlr_bckg\" onclick=\"javascript:pause()\" class=\"promx_crwlr_img\" src=\""+SWBPortal.getWebWorkPath()+rs.get(i).getWorkPath()+"/poster_"+rs.get(i).getId()+"_"+rs.get(i).getPoster()+"\" alt=\""+(rs.get(i).getAlt(lang)==null ? (rs.get(i).getAlt() == null ? "" : rs.get(i).getAlt()) : rs.get(i).getAlt(lang))+"\" />");
                }
            }

            //out.println("  <a class=\"btn_slideShowLeft\" href=\"javascript:coverImages(randomImages.length, 'ant');\"><img onclick=\"javascript:pause()\" class=\"promx_left\" src=\""+SWBPortal.getWebWorkPath()+ "/models/" + paramRequest.getWebPage().getWebSiteId() + "/css/images/promx_left.gif" + "\" /></a>\n");//Si se desea agregar los botones siguiente/anterior

            out.println("  <div id=\"pics_"+getId()+"\">");
            out.println(script.toString());
            out.println("  </div>");
            out.println("  <div class=\"title\"><p id=\"pic_title\">" + (rs.get(i).getTitle(lang) == null ? (rs.get(i).getTitle() == null ? "" : rs.get(i).getTitle()) : rs.get(i).getTitle(lang)) + "</p></div>");
            out.println("  <div class=\"desc\"><p id=\"pic_desc\">" + (rs.get(i).getDescription(lang) == null ? (rs.get(i).getDescription() == null ? "" : rs.get(i).getDescription()) : rs.get(i).getDescription(lang)) + "</p></div>");

            //out.println("  <a class=\"btn_slideShowRight\" href=\"javascript:coverImages(randomImages.length, 'sig')\"><img onclick=\"javascript:pause()\" class=\"promx_left\" src=\""+SWBPortal.getWebWorkPath()+ "/models/" + paramRequest.getWebPage().getWebSiteId() + "/css/images/promx_right.gif" + "\" /></a>\n");//Si se desea agregar los botones siguiente/anterior

            out.println("  <ul id=\"subhome_btns\">");
            out.println(creaButtons);
            out.println("  </ul>");
            out.println("</div>");

            /*out.println("<script type = \"text/javascript\">"); //Si se desea agregar los botones siguiente/anterior
            out.println(" var plusDivs = 0;");
            out.println(" var arrNext = new Array();");
            out.println("  var sizeImage = 0;");
            out.println(" function coverImages(noElement, button){\n");
            out.println("  var a = document.getElementById('promx-slideshow');");
            out.println("  var allDivs = a.getElementsByTagName(\"div\");");
            out.println("  if(arrNext.length < 1 || plusDivs < 1) {");
            out.println(" arrNext = new Array();");
            out.println(" plusDivs = 0;");

 
            out.println("  sizeImage = 0;");
            out.println("  if(a != null){");
            out.println("     for(var i=0; i < allDivs.length; i++){");
            out.println("        if(allDivs[i].className == 'marquee0') {");
            out.println("           var all3 = allDivs[i].getElementsByTagName(\"div\");");
            out.println("           var allDivs3 = all3[0].getElementsByTagName(\"div\");");
            out.println("           plusDivs = plusDivs + Math.abs(parseInt(allDivs3[0].style.left));");
            out.println("           plusDivs = plusDivs + Math.abs(parseInt(allDivs3[1].style.left));");
            out.println("           var plusDivs2 = (plusDivs) % noElement");
            out.println("           sizeImage = (plusDivs - plusDivs2) / noElement;");
            out.println("           var n = 0;");
            out.println("           for(var j=noElement; j > 0; j--) {");
            out.println("              arrNext[n] = (plusDivs - (sizeImage * (n))) * -1;");
            out.println("              n = n + 1; ");
            out.println("           }");
            out.println("           arrNext[n] = 0;");
            out.println("           n = n + 1; ");
            out.println("           for(var j=0; j < noElement; j++) {");
            out.println("              arrNext[n] = sizeImage * (j+1)");
            out.println("              n = n + 1; ");
            out.println("           }");
            out.println("        }");
            out.println("        break;");
            out.println("     }");
            out.println("  }");
            out.println("  }");

            out.println("     var leftFirstDiv=0;");
            out.println("     var allDivs3 = new Array();");
            out.println("     for(var i=0; i < allDivs.length; i++){");
            out.println("        if(allDivs[i].className == 'marquee0') {");
            out.println("           var all3 = allDivs[i].getElementsByTagName(\"div\");");
            out.println("           allDivs3 = all3[0].getElementsByTagName(\"div\");");
            out.println("           leftFirstDiv = parseInt(allDivs3[0].style.left);");
            out.println("        }");
            out.println("     }");

            out.println("  if(button == 'sig') {");
            out.println("     var i = 0; ");
            out.println("     do {");
            out.println("        i = i + 1;");
            out.println("     }while(arrNext[i] < leftFirstDiv);");
            out.println("     var n1 = arrNext[i-1];");
            out.println("     if(sizeImage > 0){ var valReg = ((sizeImage * noElement)) * -1; if(n1 < valReg) { n1 = 0;} }");
            out.println("     allDivs3[0].style.left = n1 + 'px';");
            out.println("     var styLeft = plusDivs - Math.abs(n1);");
            //out.println("     if(arrNext[n]>=0){styLeft = styLeft*(-1);}");
            out.println("     if(n1>=0){styLeft = styLeft*(-1);}");
            out.println("     allDivs3[1].style.left = styLeft + 'px';");
            out.println("  }else{ ");
            out.println("     for(var i = 0; i<arrNext.length; i++){");
            out.println("        if(arrNext[i] > leftFirstDiv){");
            out.println("           n = i;");
            out.println("           break;");
            out.println("        }");
            out.println("     }");
            out.println("     var n1 = arrNext[n];");
            //out.println("     if(n1 == 404 || n1 == 405 || n1 == 406){n1 = 0;}");
            out.println("     if(sizeImage > 0){ var valReg = ((sizeImage * noElement)); if(n1 >= valReg) { n1 = 0;} }");
            out.println("     allDivs3[0].style.left = n1 + 'px';");
            out.println("     var styLeft = plusDivs - Math.abs(n1);");
            out.println("     if(arrNext[n]>0){styLeft = styLeft*(-1);}");
            out.println("     allDivs3[1].style.left = styLeft + 'px';");
            out.println("  }");


            out.println(" }\n");
            out.println("</script>");*/

            out.println("<script type=\"text/javascript\">");
            out.println("  marqueeInit({");
            out.println("	uniqueid: 'pics_"+getId()+"',");
            out.println("	style: {");
            out.println("		'width': '416px',");
            out.println("		'height': '100px'");
            out.println("	},");
            out.println("	inc: 5,");
            out.println("	mouse: 'cursor driven',");
            out.println("	moveatleast: 0,");
            out.println("	neutral: 250,");
            out.println("	savedirection: false,");
            out.println("	random: true,");
            out.println("	stopped: true,");
            out.println("	noAddedSpace: true");
            out.println("  });");
            out.println("</script>");

            out.println("  <script type=\"text/javascript\">");
            out.println("     <!--");
            out.println("        dojo.addOnLoad( function(){");
            out.println("           inicio();}");
            out.println("         );");
            out.println("     -->");
            out.println("   </script>");
        }else {
            out.println(SWBUtils.TEXT.getLocaleString("org.semanticwb.promexico.locales.ProMxLocale", "msg_NoPicture",new Locale(lang)));
        }
    }

    private String getScript() {
        StringBuilder script = new StringBuilder();
        script.append("<script type=\"text/javascript\">\n");
        script.append("<!--\n");
        script.append("/* Text and/or Image Crawler Script v1.5 (c)2009-2011 John Davenport Scheuer\n");
        script.append("   as first seen in http://www.dynamicdrive.com/forums/\n");
        script.append("   username: jscheuer1 - This Notice Must Remain for Legal Use\n");
        script.append("   */\n");

        script.append("function marqueeInit(config){\n");
        script.append(" if(!document.createElement) return;\n");
        script.append(" marqueeInit.ar.push(config);\n");
        script.append(" marqueeInit.run(config.uniqueid);\n");
        script.append("}\n");

        script.append("(function(){\n");
        script.append(" if(!document.createElement) return;\n");
        script.append(" marqueeInit.ar = [];\n");

        script.append(" document.write('<style type=\"text/css\">.marquee{white-space:nowrap;overflow:hidden;visibility:hidden;}' +");
        script.append(" '#marq_kill_marg_bord{border:none!important;margin:0!important;}<\\/style>\\n');\n");

        script.append(" var c = 0, tTRE = [/^\\s*$/, /^\\s*/, /\\s*$/, /[^\\/]+$/],\n");
        script.append(" req1 = {'position': 'relative', 'overflow': 'hidden'}, defaultconfig = {\n");
        script.append("  style: { //default style object for marquee containers without configured style\n");
        script.append("	'margin': '0 auto'\n");
        script.append("  },\n");
        script.append("  direction: 'left',\n");
        script.append("  inc: 2, //default speed - pixel increment for each iteration of a marquee's movement\n");
        script.append("  mouse: 'pause' //default mouseover behavior ('pause' 'cursor driven' or false)\n");
        script.append(" }, dash, ie = false, oldie = 0, ie5 = false, iever = 0;\n");

         /*@cc_on @*/
         /*@if(@_jscript_version >= 5)
         ie = true;
         try{document.documentMode = 2000}catch(e){};
         iever = Math.min(document.documentMode, navigator.appVersion.replace(/^.*MSIE (\d+\.\d+).*$/, '$1'));
         if(iever < 6)
          oldie = 1;
         if(iever < 5.5){
          Array.prototype.push = function(el){this[this.length] = el;};
          ie5 = true;
          dash = /(-(.))/;
          String.prototype.encamel = function(s, m){
           s = this;
           while((m = dash.exec(s)))
            s = s.replace(m[1], m[2].toUpperCase());
           return s;
          };
         }
         @end @*/

        script.append(" if(!ie5){\n");
        script.append("  dash = /-(.)/g;");
        script.append("  function toHump(a, b){return b.toUpperCase();};\n");
        script.append("  String.prototype.encamel = function(){return this.replace(dash, toHump);};\n");
        script.append(" }\n");

        script.append(" if(ie && iever < 8){\n");
        script.append("  marqueeInit.table = [];\n");
        script.append("  window.attachEvent('onload', function(){\n");
        script.append("   marqueeInit.OK = true;\n");
        script.append("   for(var i = 0; i < marqueeInit.table.length; ++i)\n");
        script.append("   marqueeInit.run(marqueeInit.table[i]);\n");
        script.append("  });\n");
        script.append(" }\n");

        script.append(" function intable(el){\n");
        script.append("  while((el = el.parentNode))\n");
        script.append("   if(el.tagName && el.tagName.toLowerCase() === 'table')\n");
        script.append("    return true;\n");
        script.append("   return false;\n");
        script.append(" };\n");

        script.append(" marqueeInit.run = function(id){\n");
        script.append("   if(ie && !marqueeInit.OK && iever < 8 && intable(document.getElementById(id))){\n");
        script.append("    marqueeInit.table.push(id);\n");
        script.append("    return;\n");
        script.append("   }\n");
        script.append("   if(!document.getElementById(id))\n");
        script.append("    setTimeout(function(){marqueeInit.run(id);}, 300);\n");
        script.append("   else\n");
        script.append("    new Marq(c++, document.getElementById(id));\n");
        script.append(" }\n");

        script.append(" function trimTags(tag){\n");
        script.append("  var r = [], i = 0, e;\n");
        script.append("  while((e = tag.firstChild) && e.nodeType === 3 && tTRE[0].test(e.nodeValue))\n");
        script.append("   tag.removeChild(e);\n");
        script.append("  while((e = tag.lastChild) && e.nodeType === 3 && tTRE[0].test(e.nodeValue))\n");
        script.append("   tag.removeChild(e);\n");
        script.append("  if((e = tag.firstChild) && e.nodeType === 3)\n");
        script.append("   e.nodeValue = e.nodeValue.replace(tTRE[1], '');\n");
        script.append("  if((e = tag.lastChild) && e.nodeType === 3)\n");
        script.append("   e.nodeValue = e.nodeValue.replace(tTRE[2], '');\n");
        script.append("  while((e = tag.firstChild))\n");
        script.append("   r[i++] = tag.removeChild(e);\n");
        script.append("  return r;\n");
        script.append(" }\n");

        script.append(" function randthem(tag){\n");
        script.append("  var els = oldie? tag.all : tag.getElementsByTagName('*'), i = els.length - 1, childels = [], newels = [];\n");
        script.append("  for (i; i > -1; --i){\n");
        script.append("   if(els[i].parentNode === tag){\n");
        script.append("    childels.push(els[i]);\n");
        script.append("    newels.push(els[i].cloneNode(true));\n");
        script.append("   }\n");
        script.append("  }\n");
        script.append("  newels.sort(function(){return 0.5 - Math.random();});\n");
        script.append("  i = childels.length - 1;\n");
        script.append("  for (i; i > -1; --i){\n");
        script.append("   tag.replaceChild(newels[i], childels[i]);\n");
        script.append("  }\n");
        script.append(" }\n");

        script.append(" function Marq(c, tag){\n");
        script.append("  var p, u, s, a, ims, ic, i, marqContent, cObj = this;\n");
        script.append("  this.mq = marqueeInit.ar[c];\n");
        script.append("  if(this.mq.random){\n");
        script.append("   randthem(tag);\n");
        script.append("  }\n");
        script.append("  for (p in defaultconfig)\n");
        script.append("   if((this.mq.hasOwnProperty && !this.mq.hasOwnProperty(p)) || (!this.mq.hasOwnProperty && !this.mq[p]))\n");
        script.append("    this.mq[p] = defaultconfig[p];\n");
        script.append("  this.mq.style.width = !this.mq.style.width || isNaN(parseInt(this.mq.style.width))? '100%' : this.mq.style.width;\n");
        script.append("  if(!tag.getElementsByTagName('img')[0])\n");
        script.append("   this.mq.style.height = !this.mq.style.height || isNaN(parseInt(this.mq.style.height))? tag.offsetHeight + 3 + 'px' : this.mq.style.height;\n");
        script.append("  else\n");
        script.append("   this.mq.style.height = !this.mq.style.height || isNaN(parseInt(this.mq.style.height))? 'auto' : this.mq.style.height;\n");
        script.append("  u = this.mq.style.width.split(/\\d/);\n");
        script.append("  this.cw = this.mq.style.width? [parseInt(this.mq.style.width), u[u.length - 1]] : ['a'];\n");
        script.append("  marqContent = trimTags(tag);\n");
        script.append("  tag.className = tag.id = '';\n");
        script.append("  tag.removeAttribute('class', 0);\n");
        script.append("  tag.removeAttribute('id', 0);\n");
        script.append("  if(ie)\n");
        script.append("   tag.removeAttribute('className', 0);\n");
        script.append("  tag.appendChild(tag.cloneNode(false));\n");
        script.append("  tag.className = ['marquee', c].join('');\n");
        script.append("  tag.style.overflow = 'hidden';\n");
        script.append("tag.style.position = 'relative';\n");
        script.append("tag.style.left = '-168px';\n");//-18
        script.append("tag.style.top = '-118px';\n");
        script.append("  this.c = tag.firstChild;\n");
        script.append("  this.c.appendChild(this.c.cloneNode(false));\n");
        script.append("  this.c.style.visibility = 'hidden';\n");
        script.append("  a = [[req1, this.c.style], [this.mq.style, this.c.style]];\n");
        script.append("  for (i = a.length - 1; i > -1; --i)\n");
        script.append("   for (p in a[i][0])\n");
        script.append("    if((a[i][0].hasOwnProperty && a[i][0].hasOwnProperty(p)) || (!a[i][0].hasOwnProperty))\n");
        script.append("     a[i][1][p.encamel()] = a[i][0][p];\n");
        script.append("  this.m = this.c.firstChild;\n");
        script.append("  if(this.mq.mouse === 'pause'){\n");
        script.append("   this.c.onmouseover = function(){cObj.mq.stopped = true;};\n");
        script.append("   this.c.onmouseout = function(){cObj.mq.stopped = false;};\n");
        script.append("  }\n");
        script.append("  this.m.style.position = 'absolute';\n");
        script.append("  this.m.style.left = '-10000000px';\n");
        script.append("  this.m.style.whiteSpace = 'nowrap';\n");
        script.append("  if(ie5) this.c.firstChild.appendChild((this.m = document.createElement('nobr')));\n");
        script.append("  if(!this.mq.noAddedSpace)\n");
        script.append("   this.m.appendChild(document.createTextNode('\\xa0'));\n");
        script.append("  for(i = 0; marqContent[i]; ++i)\n");
        script.append("   this.m.appendChild(marqContent[i]);\n");
        script.append("  if(ie5) this.m = this.c.firstChild;\n");
        script.append("  ims = this.m.getElementsByTagName('img');\n");
        script.append("  if(ims.length){\n");
        script.append("   for(ic = 0, i = 0; i < ims.length; ++i){\n");
        script.append("    ims[i].style.display = 'inline';\n");
        script.append("    if(!ims[i].alt && !this.mq.noAddedAlt){\n");
        script.append("     ims[i].alt = (tTRE[3].exec(ims[i].src)) || ('Image #' + [i + 1]);\n");
        script.append("     if(!ims[i].title){ims[i].title = '';}\n");
        script.append("    }\n");
        script.append("    ims[i].style.display = 'inline';\n");
        script.append("    ims[i].style.verticalAlign = ims[i].style.verticalAlign || 'top';\n");
        script.append("    if(typeof ims[i].complete === 'boolean' && ims[i].complete)\n");
        script.append("     ic++;\n");
        script.append("    else {\n");
        script.append("     ims[i].onload = ims[i].onerror = function(){\n");
        script.append("       if(++ic === ims.length)\n");
        script.append("        cObj.setup(c);\n");
        script.append("      };\n");
        script.append("    }\n");
        script.append("     if(ic === ims.length)\n");
        script.append("      this.setup(c);\n");
        script.append("   }\n");
        script.append("  }\n");
        script.append("   else this.setup(c)\n");
        script.append(" }\n");

        script.append("  Marq.prototype.setup = function(c){\n");
        script.append("  if(this.mq.setup) return;\n");
        script.append("  this.mq.setup = this;\n");
        script.append("  var s, w, cObj = this, exit = 10000;\n");
        script.append("  if(this.c.style.height === 'auto')");
        script.append("   this.c.style.height = this.m.offsetHeight + 4 + 'px';\n");
        script.append("  this.c.appendChild(this.m.cloneNode(true));\n");
        script.append("  this.m = [this.m, this.m.nextSibling];\n");
        script.append("  if(this.mq.mouse === 'cursor driven'){\n");
        script.append("   this.r = this.mq.neutral || 16;\n");
        script.append("   this.sinc = this.mq.inc;\n");
        script.append("   this.c.onmousemove = function(e){cObj.mq.stopped = false; cObj.directspeed(e)};\n");
        script.append("   if(this.mq.moveatleast){\n");
        script.append("    this.mq.inc = this.mq.moveatleast;\n");
        script.append("    if(this.mq.savedirection){");
        script.append("     if(this.mq.savedirection === 'reverse'){\n");
        script.append("      this.c.onmouseout = function(e){\n");
        script.append("       if(cObj.contains(e)) return;\n");
        script.append("       cObj.mq.inc = cObj.mq.moveatleast;\n");
        script.append("       cObj.mq.direction = cObj.mq.direction === 'right'? 'left' : 'right';};\n");
        script.append("     } else {\n");
        script.append("      this.mq.savedirection = this.mq.direction;\n");
        script.append("      this.c.onmouseout = function(e){\n");
        script.append("       if(cObj.contains(e)) return;\n");
        script.append("       cObj.mq.inc = cObj.mq.moveatleast;\n");
        script.append("       cObj.mq.direction = cObj.mq.savedirection;};\n");
        script.append("    }\n");
        script.append("    } else\n");
        script.append("     this.c.onmouseout = function(e){if(!cObj.contains(e)) cObj.mq.inc = cObj.mq.moveatleast;};\n");
        script.append("   }\n");
        script.append("   else\n");
        script.append("    this.c.onmouseout = function(e){if(!cObj.contains(e)) cObj.slowdeath();};\n");
        script.append("  }\n");
        script.append("  this.w = this.m[0].offsetWidth;\n");
        script.append("  this.m[0].style.left = 0;\n");
        script.append("  this.c.id = 'marq_kill_marg_bord';\n");
        script.append("  this.m[0].style.top = this.m[1].style.top = Math.floor((this.c.offsetHeight - this.m[0].offsetHeight) / 2 - oldie) + 'px';\n");
        script.append("  this.c.id = '';\n");
        script.append("  this.c.removeAttribute('id', 0);\n");
        script.append("  this.m[1].style.left = this.w + 'px';\n");
        script.append("  s = this.mq.moveatleast? Math.max(this.mq.moveatleast, this.sinc) : (this.sinc || this.mq.inc);\n");
        script.append("  while(this.c.offsetWidth > this.w - s && --exit){\n");
        script.append("   w = isNaN(this.cw[0])? this.w - s : --this.cw[0];\n");
        script.append("   if(w < 1 || this.w < Math.max(1, s)){break;}\n");
        script.append("   this.c.style.width = isNaN(this.cw[0])? this.w - s + 'px' : --this.cw[0] + this.cw[1];\n");
        script.append("  }\n");
        script.append("  this.c.style.visibility = 'visible';\n");
        script.append("  this.runit();\n");
        script.append("  }\n");

        script.append(" Marq.prototype.slowdeath = function(){\n");
        script.append("  var cObj = this;\n");
        script.append("  if(this.mq.inc){\n");
        script.append("   this.mq.inc -= 1;\n");
        script.append("   this.timer = setTimeout(function(){cObj.slowdeath();}, 100);\n");
        script.append("  }\n");
        script.append(" }\n");

        script.append(" Marq.prototype.runit = function(){\n");
        script.append("  var cObj = this, d = this.mq.direction === 'right'? 1 : -1;\n");
        script.append("  if(this.mq.stopped || this.mq.stopMarquee){\n");
        script.append("   setTimeout(function(){cObj.runit();}, 300);\n");
        script.append("   return;\n");
        script.append("  }\n");
        script.append("  if(this.mq.mouse != 'cursor driven')\n");
        script.append("   this.mq.inc = Math.max(1, this.mq.inc);\n");
        script.append("  if(d * parseInt(this.m[0].style.left) >= this.w)\n");
        script.append("   this.m[0].style.left = parseInt(this.m[1].style.left) - d * this.w + 'px';\n");
        script.append("  if(d * parseInt(this.m[1].style.left) >= this.w)\n");
        script.append("   this.m[1].style.left = parseInt(this.m[0].style.left) - d * this.w + 'px';\n");
        script.append("  this.m[0].style.left = parseInt(this.m[0].style.left) + d * this.mq.inc + 'px';\n");
        script.append("  this.m[1].style.left = parseInt(this.m[1].style.left) + d * this.mq.inc + 'px';\n");
        script.append("  setTimeout(function(){cObj.runit();}, 30 + (this.mq.addDelay || 0));\n");
        script.append(" }\n");

        script.append(" Marq.prototype.directspeed = function(e){\n");
        script.append("  e = e || window.event;\n");
        script.append("  if(this.timer) clearTimeout(this.timer);\n");
        script.append("  var c = this.c, w = c.offsetWidth, l = c.offsetLeft, mp = (typeof e.pageX === 'number'?\n");
        script.append("   e.pageX : e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft) - l,\n");
        script.append("  lb = (w - this.r) / 2, rb = (w + this.r) / 2;\n");
        script.append("  while((c = c.offsetParent)) mp -= c.offsetLeft;\n");
        script.append("  this.mq.direction = mp > rb? 'left' : 'right';\n");
        script.append("  this.mq.inc = Math.round((mp > rb? (mp - rb) : mp < lb? (lb - mp) : 0) / lb * this.sinc);\n");
        script.append(" }\n");

        script.append(" Marq.prototype.contains = function(e){\n");
        script.append("  if(e && e.relatedTarget){var c = e.relatedTarget; if(c === this.c) return true;\n");
        script.append("   while ((c = c.parentNode)) if(c === this.c) return true;}\n");
        script.append("  return false;\n");
        script.append(" }\n");

        script.append(" function resize(){\n");
        script.append("  for(var s, w, m, i = 0; i < marqueeInit.ar.length; ++i){\n");
        script.append("   if(marqueeInit.ar[i] && marqueeInit.ar[i].setup){\n");
        script.append("    m = marqueeInit.ar[i].setup;\n");
        script.append("    s = m.mq.moveatleast? Math.max(m.mq.moveatleast, m.sinc) : (m.sinc || m.mq.inc);\n");
        script.append("    m.c.style.width = m.mq.style.width;\n");
        script.append("    m.cw[0] = m.cw.length > 1? parseInt(m.mq.style.width) : 'a';\n");
        script.append("    while(m.c.offsetWidth > m.w - s){\n");
        script.append("     w = isNaN(m.cw[0])? m.w - s : --m.cw[0];\n");
        script.append("     if(w < 1){break;}\n");
        script.append("     m.c.style.width = isNaN(m.cw[0])? m.w - s + 'px' : --m.cw[0] + m.cw[1];\n");
        script.append("    }\n");
        script.append("   }\n");
        script.append("  }\n");
        script.append(" }\n");

        script.append(" if (window.addEventListener)\n");
        script.append("  window.addEventListener('resize', resize, false);\n");
        script.append(" else if (window.attachEvent)\n");
        script.append("  window.attachEvent('onresize', resize);\n");
        script.append("})();\n");
        script.append("-->\n");
        script.append("</script>\n");
        return script.toString();
    }

}
