package emap;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.fail;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.BSC;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static org.semanticwb.bsc.resources.strategicMap.StrategicMap.*;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author carlos.ramos
 */
public class BscDOMTest {
    final private String modelId = "DADT";
    final private String periodId = "16";
    
    public BscDOMTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        String base = SWBUtils.getApplicationPath();
        SWBPlatform plat = SWBPlatform.createInstance();
        plat.setPersistenceType(SWBPlatform.PRESIST_TYPE_SWBTRIPLESTOREEXT);
        SWBPlatform.getSemanticMgr().initializeDB();
        SWBPlatform.getSemanticMgr().addBaseOntology(base + "/../../../build/web/WEB-INF/owl/swb.owl");
        SWBPlatform.getSemanticMgr().addBaseOntology(base + "/../../../build/web/WEB-INF/owl/swb_rep.owl");
        SWBPlatform.getSemanticMgr().addBaseOntology(base + "/../../../build/web/WEB-INF/owl/ext/bscom.owl");
        SWBPlatform.getSemanticMgr().loadBaseVocabulary();
        SWBPlatform.getSemanticMgr().loadDBModels();
        SWBPlatform.getSemanticMgr().getOntology().rebind();
    }
    
    public void setUpSessionUser(BSC model) {
        User user = model.getUserRepository().listUsers().next();
        SWBContext.setSessionUser(user);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    //@Test
    public void dom1() {
        System.out.println("\n\n----- Obtener el dom de un scorecard");
        if(BSC.ClassMgr.hasBSC(modelId))
        {   
            BSC model = BSC.ClassMgr.getBSC(modelId);
            System.out.println("model: "+model);
            
            setUpSessionUser(model);            
            
            Document dom = model.getDom();
            System.out.println("xml:\n"+SWBUtils.XML.domToXml(dom));
        }
        else
        {
            fail("No existen operacion con id "+modelId);
        }
    }
    
    //@Test
    public void dom2() {
        System.out.println("\n\n----- Obtener el dom del recurso de mapa");
        if(BSC.ClassMgr.hasBSC(modelId))
        {   
            BSC model = BSC.ClassMgr.getBSC(modelId);
            System.out.println("model: "+model);
            
            setUpSessionUser(model);            
            
            Document dom = model.getDom();
            System.out.println("xml:\n"+SWBUtils.XML.domToXml(dom));
            try {
                getDom(dom);
                System.out.println("svg:\n"+SWBUtils.XML.domToXml(dom));
            }catch(XPathExpressionException xpathe) {
                fail("XPath con problemas... "+xpathe);
            }
        }
        else
        {
            fail("No existen operacion con id "+modelId);
        }
    }
    
    @Test
    public void dom3() {
        System.out.println("\n\n----- Armar el svg del mapa");
        if(BSC.ClassMgr.hasBSC(modelId))
        {
            BSC model = BSC.ClassMgr.getBSC(modelId);
            System.out.println("model: "+model);
            
            setUpSessionUser(model);            
            
            Document dom = model.getDom();
            System.out.println("xml:\n"+SWBUtils.XML.domToXml(dom));
            
            try {
                getDom(dom);
                System.out.println("map:\n"+SWBUtils.XML.domToXml(dom));
            }catch(XPathExpressionException xpathe) {
                fail("XPath con problemas... "+xpathe);
            }
            
            try {
                String svg = getSvg(dom);
                System.out.println("svg:\n"+svg);
            }catch(XPathExpressionException xpe) {
                fail(xpe.toString());
            }
        }
        else
        {
            fail("No existen operacion con id "+modelId);
        }
    }
    
    String urlBase = "";
    public void getDom(Document documentBSC) throws XPathExpressionException
    {
        //Resource base = getResourceBase();
        //final BSC scorecard = (BSC)base.getWebSite();
        //final int width = Integer.parseInt(base.getAttribute("width", "800"));
        //final int height = Integer.parseInt(base.getAttribute("height", "600"));
        //final Period period = getPeriod(request);
        final int width = 800;
        final int height = 600;
        //Document documentBSC = scorecard.getDom(period);
        
        //root: period, width, height
        Element root = documentBSC.getDocumentElement();
        root.setAttribute("width", Integer.toString(width));
        root.setAttribute("height", Integer.toString(height));
                
        XPath xPath = XPathFactory.newInstance().newXPath();
        
        //header
        Element header = documentBSC.createElement("header");
        header.setAttribute("id", HEADER_PREFIX+"DADT");
        header.setAttribute("width", Integer.toString(width));
        header.setAttribute("height", Integer.toString(HEADER));
        header.setAttribute("x", "0");
        header.setAttribute("y", "0");
        String expression = "/bsc/title";
        Node node = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);
        header.appendChild(node);
        expression = "/bsc/mission";
        node = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);
        header.appendChild(node);
        expression = "/bsc/vision";
        node = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);
        header.appendChild(node);
        expression = "/bsc/logo";
        node = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);
        header.appendChild(node);
        
        expression = "/bsc/perspective[1]";
        Node p1 = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);        
        root.insertBefore(header, p1);
        
        
        final int px;
        int py;
        final int pw, ph;
        final int perspCount;
        String uri;
        Boolean hiddenTheme;
        
        //para cada perspectiva: width, height, x, y
        expression = "/bsc/perspective";
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODESET);
        perspCount = nodeList.getLength();
        pw = width-MARGEN_LEFT-MARGEN_RIGHT;
        ph = (height-HEADER)/perspCount -  MARGEN_TOP - MARGEN_BOTTOM;
        px = MARGEN_LEFT;
        //py = MARGEN_TOP;
        //lista de perspectivas
        for(int j=0; j<perspCount; j++) {
            int h_ = ph;
            Node nodep = nodeList.item(j);
            if(nodep.getNodeType()==Node.ELEMENT_NODE)
            {
                //perspectiva
                Element p = (Element)nodep;
                uri = p.getAttribute("id");
                //py = j*(ph+MARGEN_BOTTOM+MARGEN_TOP);
                py = MARGEN_TOP +HEADER+ j*(ph+MARGEN_BOTTOM+MARGEN_TOP);
                
                //diferenciadores de la perspectiva
                expression = "/bsc/perspective[@id='"+uri+"']/diffgroup[1]/diff";
                NodeList nlDiffs = (NodeList)xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODESET);
                final int nlDiffsCount = nlDiffs.getLength();
                final boolean hasDifferentiators = nlDiffsCount>0;
                if(hasDifferentiators) {
                    final int dw = pw/nlDiffsCount;  
                    //int dx = px;
                    for(int k=0; k<nlDiffsCount; k++) {
                        Node noded = nlDiffs.item(k);
                        Element d = (Element)noded;
                        d.setAttribute("width", Integer.toString(dw-BOX_SPACING));
                        d.setAttribute("height", "14");
                        d.setAttribute("x", Integer.toString(px + k*dw));
                        d.setAttribute("y", Integer.toString(py));
                    }
                    py = py + 14 + BOX_SPACING;
                }
                
                //perspectiva
                p.setAttribute("width", Integer.toString(pw));
                if(hasDifferentiators) {
                    h_ = ph - 14 - BOX_SPACING;
                }
                p.setAttribute("height",Integer.toString(h_));
                p.setAttribute("x", Integer.toString(px));
                p.setAttribute("y", Integer.toString(py));
                
                //lista de temas por perspectiva                
                expression = "/bsc/perspective[@id='"+uri+"']/themes/theme";
                NodeList nlThms = (NodeList)xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODESET);
                final int nlThmsCount = nlThms.getLength();
                final  boolean hasThemes = nlThmsCount>0;
                if(hasThemes)
                {
                    final int tw = pw/nlThmsCount;
                    int tx;
                    for(int k=0; k<nlThmsCount; k++)
                    {
                        Node nodet = nlThms.item(k);
                        int ty = py + BIND_TOP_SPACING;
                        if(nodet.getNodeType()==Node.ELEMENT_NODE) {
                            Element t = (Element)nodet;
                            uri = t.getAttribute("id");
                            hiddenTheme = Boolean.parseBoolean(t.getAttribute("hidden"));
                            t.setAttribute("width", Integer.toString(tw-BOX_SPACING));
                            tx = px + k*tw + BOX_SPACING;
                            t.setAttribute("x", Integer.toString(tx));
                            t.setAttribute("y", Integer.toString(ty));
                            
                            //lista de objetivos
                            expression = "//theme[@id='"+uri+"']/obj";
                            NodeList nlObjs = (NodeList)xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODESET);
                            final int nlObjsCount = nlObjs.getLength();
                            if(nlObjsCount>0)
                            {
                                int hObj;
                                if(hiddenTheme) {
                                    hObj = h_/(nlObjsCount);
                                    t.setAttribute("height","0");
                                }else {
                                    hObj = h_/(nlObjsCount+1);
                                    t.setAttribute("height",Integer.toString(hObj));
                                }
                                for(int l=0; l<nlObjsCount; l++)
                                {
                                    Node nodeo = nlObjs.item(l);
                                    int ox = tx;
                                    int oy = hiddenTheme ? 0 : hObj;
                                    if(nodeo.getNodeType()==Node.ELEMENT_NODE) {
                                        Element o = (Element)nodeo;
                                        uri = o.getAttribute("id");                                
                                        o.setAttribute("width", Integer.toString(tw-BIND_RIGHT_SPACING));
                                        o.setAttribute("height", Integer.toString(hObj-BIND_TOP_SPACING));
                                        o.setAttribute("x", Integer.toString(ox));  
                                        oy += ty + l*hObj + BIND_TOP_SPACING;
                                        o.setAttribute("y", Integer.toString(oy));
                                        o.setAttribute("href",  urlBase+uri);

                                        //relaciones con este objetivo
                                        expression = "//rel[@to='"+uri+"']";
                                        NodeList nlRels = (NodeList)xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODESET);
                                        for(int m=0; m<nlRels.getLength(); m++) {
                                            Node noder = nlRels.item(m);
                                            if(noder.getNodeType()==Node.ELEMENT_NODE) {
                                                Element rel = (Element)noder;
                                                rel.setAttribute("rx", Integer.toString(ox+tw/2));
                                                rel.setAttribute("ry", Integer.toString(oy));
                                            }
                                        }
                                    }
                                }//lista de objetivos por tema
                            }
                        }
                    }//lista de temas
                }
            }
        }//lista de perspectivas
    }
    
    public String getSvg(Document documentBSC) throws XPathExpressionException
    {
       String id, expression;
        final int width, height;
        int w, h, w_, h_;
        int x, y, x_, y_;
        StringBuilder SVGjs = new StringBuilder();
        final String emapId = "DAC";
        
        // XML del BSC
        Element rootBSC = documentBSC.getDocumentElement();
        width = 800;
        height = 600;
      
        SVGjs.append("<script type=\"text/javascript\">");
SVGjs.append(" var SVG_ = '"+SVG_NS_URI+"';").append("\n");
SVGjs.append(" var svg = document.createElementNS(SVG_, 'svg'); ").append("\n");
//SVGjs.append(" svg.setAttributeNS(null,'xmlns:xlink', '"+XLNK_NS_URI+"');").append("\n");
SVGjs.append(" svg.setAttributeNS(null,'id','"+emapId+"');").append("\n");
SVGjs.append(" svg.setAttributeNS(null,'width','"+width+"');").append("\n");
SVGjs.append(" svg.setAttributeNS(null,'height','"+height+"');").append("\n");
SVGjs.append(" svg.setAttributeNS(null,'viewBox','0,0,"+width+","+height+"');").append("\n");
SVGjs.append(" svg.setAttributeNS(null,'version','1.0');").append("\n");
SVGjs.append(" document.body.appendChild(svg);").append("\n");


SVGjs.append(" var g;").append("\n");
SVGjs.append(" var txt;").append("\n");
SVGjs.append(" var rect;").append("\n");
        
        
XPath xPath = XPathFactory.newInstance().newXPath();
expression = "/bsc/header";
Node node = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);
if(node!=null && node instanceof Element) {
    NamedNodeMap attrs = node.getAttributes();
    id = attrs.getNamedItem("id").getNodeValue();
    w = 800;
    h = 150;
    x = 0;
    y = 0;
    
    SVGjs.append(" g = document.createElementNS(SVG_,'g');").append("\n");
    SVGjs.append(" g.setAttributeNS(null,'id','"+id+"');").append("\n");
    SVGjs.append(" svg.appendChild(g);").append("\n");
    
    x_ = x;
    y_ = y;// + HEADER_TITLE;
    w_ = w;
    h_ = HEADER_TITLE;
    
    // título mapa
    expression = "/bsc/header/title";
    node = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);
    if(node!=null && node.getNodeType()==Node.ELEMENT_NODE) {
//        x_ = x;
//        y_ = y + HEADER_TITLE;
//        w_ = w;
//        h_ = HEADER_TITLE;
        SVGjs.append(" txt = document.createElementNS(SVG_,'text');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'id','"+id+"_title"+"');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'x','"+x_+"');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'y','"+y_+"');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'font-size','14');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'font-family','Verdana');").append("\n");
        SVGjs.append(" txt.textContent='"+node.getFirstChild().getNodeValue()+"';").append("\n");
        SVGjs.append(" g.appendChild(txt);").append("\n");
        SVGjs.append(" fixParagraphAtBounding(txt,"+w_+","+h_+","+x_+","+y_+");").append("\n");
        SVGjs.append(" rect = getBBoxAsRectElement(txt);").append("\n");
        SVGjs.append(" framingRect(rect,"+w_+","+h_+","+x_+","+y_+");").append("\n");
        SVGjs.append(" g.appendChild(rect);").append("\n");
    }
    
    // misión
    expression = "/bsc/header/mission";
    node = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);
    if(node!=null && node.getNodeType()==Node.ELEMENT_NODE) {
        y_ = y + HEADER_TITLE + 18;
        w_ = w/3;
        h_ = h - HEADER_TITLE;
        SVGjs.append(" txt = document.createElementNS(SVG_,'text');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'id','"+id+"_mt"+"');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'x','"+x_+"');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'y','"+y_+"');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'font-size','12');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'font-family','Verdana');").append("\n");
        SVGjs.append(" txt.textContent='"+node.getFirstChild().getNodeValue()+"';").append("\n");
        SVGjs.append(" g.appendChild(txt);").append("\n");
        SVGjs.append(" fixParagraphAtBounding(txt,"+w_+","+h_+","+x_+","+y_+");").append("\n");
        SVGjs.append(" rect = getBBoxAsRectElement(txt);").append("\n");
        SVGjs.append(" framingRect(rect,"+w_+","+h_+","+x_+","+y_+");").append("\n");
        SVGjs.append(" g.appendChild(rect);").append("\n");
    }
    
    // logo
    expression = "/bsc/header/logo";
    node = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);
    if(node!=null && node.getNodeType()==Node.ELEMENT_NODE) {
        x_ = x_ + w_;
        SVGjs.append(" rect = document.createElementNS(SVG_,'rect');").append("\n");
        SVGjs.append(" rect.setAttributeNS(null,'id','"+id+"_lg"+"');").append("\n");
        SVGjs.append(" rect.setAttributeNS(null,'width','"+w_+"');").append("\n");
        SVGjs.append(" rect.setAttributeNS(null,'height','"+h_+"');").append("\n");
        SVGjs.append(" rect.setAttributeNS(null,'x','"+x_+"');").append("\n");
        SVGjs.append(" rect.setAttributeNS(null,'y','"+y_+"');").append("\n");
        SVGjs.append(" rect.setAttributeNS(null,'fill','none');").append("\n");
        SVGjs.append(" rect.setAttributeNS(null,'stroke','black');").append("\n");
        SVGjs.append(" rect.setAttributeNS(null, 'stroke-width','1');").append("\n");
        SVGjs.append(" g.appendChild(rect);").append("\n");
    }
    
    // vision
    expression = "/bsc/header/vision";
    node = (Node) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODE);
    if(node!=null && node.getNodeType()==Node.ELEMENT_NODE) {
        x_ = x_ + w_;
        SVGjs.append(" txt = document.createElementNS(SVG_,'text');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'id','"+id+"_vs"+"');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'x','"+x_+"');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'y','"+y_+"');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'font-size','12');").append("\n");
        SVGjs.append(" txt.setAttributeNS(null,'font-family','Verdana');").append("\n");
        SVGjs.append(" txt.textContent='"+node.getFirstChild().getNodeValue()+"';").append("\n");
        SVGjs.append(" g.appendChild(txt);").append("\n");
        SVGjs.append(" fixParagraphAtBounding(txt,"+w_+","+h_+","+x_+","+y_+");").append("\n");
        SVGjs.append(" rect = getBBoxAsRectElement(txt);").append("\n");
        SVGjs.append(" framingRect(rect,"+w_+","+h_+","+x_+","+y_+");").append("\n");
        SVGjs.append(" g.appendChild(rect);").append("\n");
    }
}

//lista de perspectivas
expression = "/bsc/perspective";
NodeList nlPersp = (NodeList) xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODESET);
for(int j=0; j<nlPersp.getLength(); j++) {
    node = nlPersp.item(j);
    if(node!=null && node.getNodeType()==Node.ELEMENT_NODE) {
        NamedNodeMap attrs = node.getAttributes();
        String pid = attrs.getNamedItem("id").getNodeValue();
        int pw = assertValue(attrs.getNamedItem("width").getNodeValue());
        int ph = assertValue(attrs.getNamedItem("height").getNodeValue());
        int px = assertValue(attrs.getNamedItem("x").getNodeValue());
        int py = assertValue(attrs.getNamedItem("y").getNodeValue());
        
        // título de la perspectiva
        expression = "/bsc/perspective[@id='"+pid+"']/title";
        String title = (String)xPath.compile(expression).evaluate(documentBSC, XPathConstants.STRING);
        // prefijo de la perspectiva
        expression = "/bsc/perspective[@id='"+pid+"']/prefix";
        String prefix = (String)xPath.compile(expression).evaluate(documentBSC, XPathConstants.STRING);
        
System.out.println("perspectiva="+title);
SVGjs.append(" g = document.createElementNS(SVG_,'g');").append("\n");
SVGjs.append(" g.setAttributeNS(null,'id','"+pid+"');").append("\n");
SVGjs.append(" svg.appendChild(g);").append("\n");

System.out.println("");
SVGjs.append(" rect = document.createElementNS(SVG_,'rect');").append("\n");
SVGjs.append(" rect.setAttributeNS(null,'id','"+pid+"_p"+"');").append("\n");
SVGjs.append(" rect.setAttributeNS(null,'width','"+pw+"');").append("\n");
SVGjs.append(" rect.setAttributeNS(null,'height','"+ph+"');").append("\n");
SVGjs.append(" rect.setAttributeNS(null,'x','"+px+"');").append("\n");
SVGjs.append(" rect.setAttributeNS(null,'y','"+py+"');").append("\n");
SVGjs.append(" rect.setAttributeNS(null,'fill','none');").append("\n");
SVGjs.append(" rect.setAttributeNS(null,'stroke','black');").append("\n");
SVGjs.append(" rect.setAttributeNS(null, 'stroke-width','1');").append("\n");
SVGjs.append(" g.appendChild(rect);").append("\n");
        
        
        //diferenciadores de la perspectiva
        expression = "/bsc/perspective[@id='"+pid+"']/diffgroup[1]/diff";
        NodeList nlDiffs = (NodeList)xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODESET);
        for(int k=0; k<nlDiffs.getLength(); k++) {
            Node nodeD = nlDiffs.item(k);
            if(nodeD!=null && nodeD.getNodeType()==Node.ELEMENT_NODE) {
                attrs = nodeD.getAttributes();
                String did = attrs.getNamedItem("id").getNodeValue();
                w_ = assertValue(attrs.getNamedItem("width").getNodeValue());
                h_ = assertValue(attrs.getNamedItem("height").getNodeValue());
                x_ = assertValue(attrs.getNamedItem("x").getNodeValue());
                y_ = assertValue(attrs.getNamedItem("y").getNodeValue());

                expression = "/bsc/perspective[@id='"+pid+"']/diffgroup[1]/diff/title";
                title = (String)xPath.compile(expression).evaluate(documentBSC, XPathConstants.STRING);

System.out.println("diferenciador="+title);
SVGjs.append(" txt = document.createElementNS(SVG_,'text');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'id','"+did+"');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'x','"+x_+"');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'y','"+y_+"');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'font-size','12');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'font-family','Verdana');").append("\n");
SVGjs.append(" txt.textContent='"+title+"';").append("\n");
SVGjs.append(" g.appendChild(txt);").append("\n");
SVGjs.append(" fixParagraphAtBounding(txt,"+w_+","+h_+","+x_+","+y_+");").append("\n");
SVGjs.append(" rect = getBBoxAsRectElement(txt);").append("\n");
SVGjs.append(" framingRect(rect,"+w_+","+h_+","+x_+","+y_+");").append("\n");
SVGjs.append(" g.appendChild(rect);").append("\n");                
            }
        }
        
        // temas de la perspectiva
        expression = "/bsc/perspective[@id='"+pid+"']/themes/theme";
        NodeList nlThms = (NodeList)xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODESET);
        for(int l=0; l<nlThms.getLength(); l++) {
            Node nodeT = nlThms.item(l);
            if(nodeT!=null && nodeT.getNodeType()==Node.ELEMENT_NODE) {
                attrs = nodeT.getAttributes();
                String tid = attrs.getNamedItem("id").getNodeValue();
                w_ = assertValue(attrs.getNamedItem("width").getNodeValue());
                h_ = assertValue(attrs.getNamedItem("height").getNodeValue());
                x_ = assertValue(attrs.getNamedItem("x").getNodeValue());
                y_ = assertValue(attrs.getNamedItem("y").getNodeValue());

                expression = "/bsc/perspective[@id='"+pid+"']/themes/theme[@id='"+tid+"']/title";
                title = (String)xPath.compile(expression).evaluate(documentBSC, XPathConstants.STRING);
System.out.println("tema="+title);                
SVGjs.append(" txt = document.createElementNS(SVG_,'text');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'id','"+tid+"');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'x','"+x_+"');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'y','"+y_+"');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'font-size','12');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'font-family','Verdana');").append("\n");
SVGjs.append(" txt.textContent='"+title+"';").append("\n");
SVGjs.append(" g.appendChild(txt);").append("\n");
SVGjs.append(" fixParagraphAtBounding(txt,"+w_+","+h_+","+x_+","+y_+");").append("\n");
SVGjs.append(" rect = getBBoxAsRectElement(txt);").append("\n");
SVGjs.append(" framingRect(rect,"+w_+","+h_+","+x_+","+y_+");").append("\n");
SVGjs.append(" g.appendChild(rect);").append("\n"); 
                
                
                //lista de objetivos
                expression = "//theme[@id='"+tid+"']/obj";
                NodeList nlObjs = (NodeList)xPath.compile(expression).evaluate(documentBSC, XPathConstants.NODESET);
                for(int m=0; m<nlObjs.getLength(); m++) {
                    Node nodeO = nlObjs.item(m);
                    if(nodeO!=null && nodeO.getNodeType()==Node.ELEMENT_NODE) {
                        attrs = nodeO.getAttributes();
                        String oid = attrs.getNamedItem("id").getNodeValue();
                        w_ = assertValue(attrs.getNamedItem("width").getNodeValue());
                        h_ = assertValue(attrs.getNamedItem("height").getNodeValue());
                        x_ = assertValue(attrs.getNamedItem("x").getNodeValue());
                        y_ = assertValue(attrs.getNamedItem("y").getNodeValue());

                        expression = "//theme[@id='"+tid+"']/obj[@id='"+oid+"']/title";
                        title = (String)xPath.compile(expression).evaluate(documentBSC, XPathConstants.STRING);
System.out.println("objetivo="+title);
SVGjs.append(" txt = document.createElementNS(SVG_,'text');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'id','"+oid+"');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'x','"+x_+"');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'y','"+y_+"');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'font-size','12');").append("\n");
SVGjs.append(" txt.setAttributeNS(null,'font-family','Verdana');").append("\n");
SVGjs.append(" txt.textContent='"+title+"';").append("\n");
SVGjs.append(" g.appendChild(txt);").append("\n");
SVGjs.append(" fixParagraphAtBounding(txt,"+w_+","+h_+","+x_+","+y_+");").append("\n");
SVGjs.append(" rect = getBBoxAsRectElement(txt);").append("\n");
SVGjs.append(" framingRect(rect,"+w_+","+h_+","+x_+","+y_+");").append("\n");
SVGjs.append(" g.appendChild(rect);").append("\n"); 
                    }
                }
            }
        }
    }
}
        

SVGjs.append("function framingRect(rect,width, height, x, y) {").append("\n");
SVGjs.append("    rect.x.baseVal.value = x;").append("\n");
SVGjs.append("    rect.y.baseVal.value = y;").append("\n");
SVGjs.append("    rect.width.baseVal.value = width;").append("\n");
SVGjs.append("    rect.height.baseVal.value = height;").append("\n");
SVGjs.append("    rect.setAttributeNS(null,'fill','none');").append("\n");
SVGjs.append("    rect.setAttributeNS(null,'stroke','black');").append("\n");
SVGjs.append("    rect.setAttributeNS(null, 'stroke-width','1');").append("\n");
SVGjs.append("}").append("\n");
        
SVGjs.append("function fixParagraphAtBounding(text_element, width, height, x, y) {").append("\n");
SVGjs.append("    var dy = getFontSize(text_element);").append("\n");
SVGjs.append("    var text = text_element.textContent;").append("\n");
SVGjs.append("    var words = text.split(' ');").append("\n");
SVGjs.append("    var tspan_element = document.createElementNS(SVG_, 'tspan');").append("\n");
SVGjs.append("    var text_node = document.createTextNode(words[0]);").append("\n");

SVGjs.append("    text_element.textContent='';").append("\n");
SVGjs.append("    tspan_element.appendChild(text_node);").append("\n");
SVGjs.append("    text_element.appendChild(tspan_element);").append("\n");

SVGjs.append("    var h;").append("\n");

SVGjs.append("    for(var i=1; i<words.length; i++)").append("\n");
SVGjs.append("    {").append("\n");
SVGjs.append("        h = getBoundingHeight(text_element);").append("\n");
SVGjs.append("        var len = tspan_element.firstChild.data.length;").append("\n");
SVGjs.append("        tspan_element.firstChild.data += ' ' + words[i];").append("\n");

SVGjs.append("        if (tspan_element.getComputedTextLength() > width)").append("\n");
SVGjs.append("        {").append("\n");
SVGjs.append("            dy = dy - (h/height);").append("\n");
SVGjs.append("            text_element.setAttributeNS(null, 'font-size', dy);").append("\n");
SVGjs.append("            var childElements = text_element.getElementsByTagName('tspan');").append("\n");
SVGjs.append("            for (var j=0; j<childElements.length; j++) {").append("\n");
SVGjs.append("                if(childElements[j].getAttribute('dy')) {").append("\n");
SVGjs.append("                    childElements[j].setAttributeNS(null,'dy',dy);").append("\n");
SVGjs.append("                }").append("\n");
SVGjs.append("            }").append("\n");
SVGjs.append("            h = getBoundingHeight(text_element);").append("\n");

SVGjs.append("            if (tspan_element.getComputedTextLength() > width)").append("\n");
SVGjs.append("            {").append("\n");
SVGjs.append("                tspan_element.firstChild.data = tspan_element.firstChild.data.slice(0, len);").append("\n");  // Remove added word

SVGjs.append("                var tspan_element = document.createElementNS(SVG_, 'tspan');").append("\n");
SVGjs.append("                tspan_element.setAttributeNS(null, 'x', x);").append("\n");
SVGjs.append("                tspan_element.setAttributeNS(null, 'dy', dy);").append("\n");
SVGjs.append("                text_node = document.createTextNode(words[i]);").append("\n");
SVGjs.append("                tspan_element.appendChild(text_node);").append("\n");
SVGjs.append("                text_element.appendChild(tspan_element);").append("\n");
SVGjs.append("            }").append("\n");
SVGjs.append("        }").append("\n");
SVGjs.append("    }").append("\n");

SVGjs.append("    h = getBoundingHeight(text_element);").append("\n");
SVGjs.append("    while(h>height) {").append("\n");
SVGjs.append("        dy--;").append("\n");
SVGjs.append("        text_element.setAttributeNS(null, 'font-size', dy);").append("\n");

SVGjs.append("        var childElements = text_element.getElementsByTagName('tspan');").append("\n");
SVGjs.append("        for (var i=0; i < childElements.length; i++) {").append("\n");
SVGjs.append("            if(childElements[i].getAttribute('dy')) {").append("\n");
SVGjs.append("                childElements[i].setAttributeNS(null,'dy',dy-0.5);").append("\n");
SVGjs.append("            }").append("\n");
SVGjs.append("        }").append("\n");
SVGjs.append("        h = getBoundingHeight(text_element);").append("\n");
SVGjs.append("    }").append("\n");
SVGjs.append("}").append("\n");

SVGjs.append(" function getFontSize(text_element) {").append("\n");
SVGjs.append("  var fs_ = window.getComputedStyle(text_element, null).getPropertyValue('font-size');").append("\n");
SVGjs.append("  var fs = fs_.replace( /\\D+/g, '');").append("\n");
SVGjs.append("  return fs;").append("\n");
SVGjs.append(" }").append("\n");

SVGjs.append(" function getBoundingHeight(objNode) {").append("\n");
SVGjs.append("  if(!objNode.getBBox) {").append("\n");
SVGjs.append("      if(objNode.correspondingUseElement) {").append("\n");
SVGjs.append("          objNode = objNode.correspondingUseElement;").append("\n");
SVGjs.append("      }").append("\n");
SVGjs.append("  }").append("\n");
SVGjs.append("  var bbox = objNode.getBBox();").append("\n");
SVGjs.append("  return bbox.height;").append("\n");
SVGjs.append(" }").append("\n");

SVGjs.append(" function getBBoxAsRectElement(objNode) {").append("\n");
SVGjs.append("  if(!objNode.getBBox) {").append("\n");
SVGjs.append("    if(objNode.correspondingUseElement)").append("\n");
SVGjs.append("      objNode = objNode.correspondingUseElement;").append("\n");
SVGjs.append("  }").append("\n");
SVGjs.append("  var bbox = objNode.getBBox();").append("\n");
SVGjs.append("  var rect = document.createElementNS(SVG_, 'rect');").append("\n");
SVGjs.append("  rect.x.baseVal.value = bbox.x;").append("\n");
SVGjs.append("  rect.y.baseVal.value = bbox.y;").append("\n");
SVGjs.append("  rect.width.baseVal.value = bbox.width;").append("\n");
SVGjs.append("  rect.height.baseVal.value = bbox.height;").append("\n");
SVGjs.append("  return rect;").append("\n");
SVGjs.append(" }").append("\n");

        SVGjs.append("</script>");
        return SVGjs.toString();
    }
    
    private int assertValue(final String textVal)
    {
        int val;
        try {
            val = Integer.parseInt(textVal);
        }catch(NumberFormatException nfe) {
            val = 0;
        }catch(NullPointerException nulle) {
            val = 0;
        }
        return val;
    }
}