/**
 * SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
 * colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
 * información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
 * fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
 * procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
 * para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
 *
 * INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
 * en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
 * aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
 * del SemanticWebBuilder 4.0.
 *
 * INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
 * siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
 * dirección electrónica:
 *  http://www.semanticwebbuilder.org
 **/

import org.semanticwb.portal.api.*
import org.semanticwb.model.*
import org.semanticwb.portal.community.*
import org.semanticwb.*
import org.semanticwb.platform.*
import java.util.*

//long time1 = System.currentTimeMillis()
WebSite wsid = request.getAttribute("topic").getWebSite()
Contenedor local = LocalCache.getInicio(wsid)
def path =  SWBPortal.getWebWorkPath() + "/models/" + wsid.getWebSiteId() + "/css/images/"

//recurseContenedor(local,0)

ArrayList<Contenedor> Tabs = new ArrayList<Contenedor>(local.getHijos())
ArrayList<Contenedor> panels = new ArrayList<Contenedor>()
Tabs.each{
    panels.addAll(it.getHijos())
}

println """
    <div id="bodyTop">
      <div class="contentPanelsWrap" id="contentPanelsWrap1">"""
panels.each{
    def panel = it.getWebPage()
    def contents = it.getHijos()
    println """        <div class="contentPanel">
        <img class="fakeBackground" src="$path${panel.getId()}_bk.jpg" alt="${panel.getDisplayName("es")}">
          <div class="columnaIzquierda">
            <h2>${panel.getDisplayName("es")}</h2>
            <img src="$path${panel.getId()}.jpg" alt="${panel.getDisplayName("es")}">
            <!--p class="botonesAux"> <a href="#"><img src="images/icoAvion.png" alt="Transporte aereo"></a> <a href="#"><img src="images/icoAuto.png" alt="Transporte terrestre"></a> </p-->
            ${panel.getDescription()}
          </div>
          <div class="columnaCentro">
            <p>${panel.getTags()}</p>"""
    contents.each{
        def elecount = 0
        if (it.getHijos().size()>0) {
            def test = it
            println "            <h2>${test.getWebPage().getDisplayName("es")}</h2>"
            print "            <p class=\"itemsRelacionados\">"
            def linea = ""
            test.getHijos().each{
                def valor = it.getWebPage()
                valor.listChilds().each{
                    if (it.isValid()) elecount++
                }
                linea = linea + "<a href=\"" + valor.getRealUrl()+"\">"+valor.getDisplayName("es")+"</a>, "
            }
            if (linea.length()>0)
            linea = linea.substring(0,linea.length()-2)
            println """${linea}</p>
            <p>Con un total de ${elecount} elementos publicados</p>"""
        }
    }
    //            <h2>Lugares</h2>
    //            <p class="itemsRelacionados"><a href="#">Playas</a>, <a href="#">Zonas Arquelógicas</a> y <a href="#">Museos</a></p>
    //            <p>Con un total de 62 elementos publicados</p>
    //            <h2>Servicios</h2>
    //            <p class="itemsRelacionados"><a href="#">Playas</a>, <a href="#">Zonas Arquelógicas</a> y <a href="#">Museos</a></p>
    //            <p>Con un total de 62 elementos publicados</p>
    //            <h2>Organizaciones</h2>
    //            <p class="itemsRelacionados"><a href="#">Playas</a>, <a href="#">Zonas Arquelógicas</a> y <a href="#">Museos</a></p>
    //            <p>Con un total de 62 elementos publicados</p>
    println """          </div>
          </div>"""
}

println """
      </div>
      <div id="TabbedPanels1" class="TabbedPanels">
            <ul class="TabbedPanelsTabGroup">"""
def tabCount = 0
Tabs.each{
    def tab = it.getWebPage()
    tabCount++
    println """              <li class="TabbedPanelsTab" id="tab${tabCount}">${tab.getDisplayName("es")}</li>"""
}
println """            </ul>
            <div class="TabbedPanelsContentGroup">"""
tabCount = 0
Tabs.each{
    def tab = it
    tabCount++
    println """              <div class="TabbedPanelsContent" id="tabContent${tabCount}">
                <ul id="panelSelector${tabCount}">"""
    tab.getHijos().each{
        def linea = it.getWebPage()
        println """                  <li><a href="#">${linea.getDisplayName("es")}</a></li>"""
    }
    println """                </ul>
              </div>"""
}
println """            </div>
      </div>
    </div>
"""
//System.out.println "HT -->"+(System.currentTimeMillis()-time1)

//System.out.println("Listo")
//def paramRequest=request.getAttributeNames()
//paramRequest.each{
//    System.out.println it
//
//}

//WebSite ws = org.semanticwb.model.SWBContext.getWebSite("Ciudad_Digital")
//System.out.println topic.getWorkPath()
//System.out.println topic.getWebSite().getWorkPath()
//
//println "Ready"

def recurseContenedor(Contenedor home, int level){
    level.times {
        System.out.print "-"
    }
    System.out.print ">"
    System.out.println home.getWebPage()
    def list = home.getHijos().iterator()
    list.each(){
        recurseContenedor(it, level+1)
    }
}

class LocalCache{
    static  Contenedor inicio = null
    static long timer = 0
    //static long cache_time = 1000L*60*60*12
    static long cache_time = 1000L*60*5

    static public Contenedor getInicio(WebSite wsid){
        if (null==inicio || System.currentTimeMillis()>timer+cache_time) init(wsid)
        return inicio
    }

    static private synchronized void init(WebSite wsid){
        if (null!=inicio) return
        timer = System.currentTimeMillis()
//        WebPage homeTeaser = org.semanticwb.model.SWBContext.getWebSite("Ciudad_Digital").getWebPage("HomeTeasers")
        WebPage homeTeaser = wsid.getWebPage("HomeTeasers")
        inicio = new Contenedor(homeTeaser, new TreeSet<Contenedor>(new CompContenedor()))
        WebPage lugar = wsid.getWebPage("Sitios_de_Interes")
        WebPage servicio = wsid.getWebPage("Servicios")
        WebPage organizacion = wsid.getWebPage("Organizaciones")
        //wpage.getWebSite().getWebPage("HomeTeasers")
        //println homeTeaser

        def mains = homeTeaser.listChilds()
        mains.each{
            WebPage main = (WebPage)it
            def mCont = new Contenedor(main,new TreeSet<Contenedor>(new CompContenedor()))
            inicio.getHijos().add(mCont)
            //      println "at main"
            //      println main
            def childs = main.listChilds()
            childs.each {
                WebPage child = (WebPage)it
                def cCont = new Contenedor(child, new TreeSet<Contenedor>(new CompContenedor()))
                mCont.getHijos().add(cCont)
                //          println "at child"
                //          println child
                def clugar = new Contenedor(lugar, new TreeSet<Contenedor>(new CompContenedor()))
                cCont.getHijos().add(clugar)
                def cservicio = new Contenedor(servicio, new TreeSet<Contenedor>(new CompContenedor()))
                cCont.getHijos().add(cservicio)
                def corganizacion = new Contenedor(organizacion, new TreeSet<Contenedor>(new CompContenedor()))
                cCont.getHijos().add(corganizacion)
                def temes = child.listWebPageVirtualChilds()

                temes.each{
                    WebPage teme = (WebPage)it
                    if (findif(teme, lugar)) clugar.getHijos().add(new Contenedor(teme, null))
                    if (findif(teme, servicio)) cservicio.getHijos().add(new Contenedor(teme, null))
                    if (findif(teme, organizacion)) corganizacion.getHijos().add(new Contenedor(teme, null))
                    //              println "at teme"
                    //              println teme
                    //              println "en lugar: " + findif(teme, lugar)
                    //              println "en servicio: " +findif(teme, servicio)
                    //              println "en organizacion: " +findif(teme, organizacion)
                }
            }
        }
    }

    static boolean findif(WebPage curr, WebPage lookup) {
        //println "buscando: $curr contra $lookup"
        def parents = curr.listVirtualParents()
        boolean flag = false
        parents.each{
            if (!flag) {
                WebPage parent = (WebPage) it
                //println parent
                if (parent.equals(lookup)) {
                    flag = true
                }
                else {
                    flag = findif(parent, lookup)
                }
            }
        }
        if (!flag) {
            WebPage parent = curr.getParent()
            if (null!=parent){
                //println parent
                if (parent.equals(lookup)) {
                    flag = true
                }
                else {
                    flag = findif(parent, lookup)
                }
            }
        }
        return flag
    }


}

class Contenedor {
    WebPage yo
    Set<Contenedor> hijos
    Contenedor (WebPage yo, Set<Contenedor> hijos){
        this.yo = yo
        this.hijos = hijos
    }

    WebPage getWebPage(){
        return yo;
    }

    Set<Contenedor> getHijos(){
        return hijos
    }
}

class CompContenedor implements java.util.Comparator {

    
    public int compare(java.lang.Object obj1, java.lang.Object obj2)
    {
        WebPage wbp1, wbp2
        String name1, name2
        wbp1 = ((Contenedor)obj1).getWebPage()
        wbp2 = ((Contenedor)obj2).getWebPage()
        name1 = wbp1.getSortName()
        if (null==name1) name1 = wbp1.getDisplayName("es")
        name2 = wbp2.getSortName()
        if (null==name2) name2 = wbp2.getDisplayName("es")

        return name1.compareToIgnoreCase(name2)
    }
}