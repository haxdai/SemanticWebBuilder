<%-- 
    Document   : streamSentimentData
    Created on : 08-ago-2013, 11:51:58
    Author     : jorge.jimenez
--%>
<%@page contentType="text/json" pageEncoding="UTF-8"%> 
<%@page import="org.semanticwb.social.admin.resources.util.SWBSocialResUtil"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.SWBPortal"%> 
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="org.json.*"%>
<%@page import="java.util.*"%> 


<%!
    JSONArray getObject(SemanticObject semObj, String lang) throws Exception {
        //WebSite wsite=WebSite.ClassMgr.getWebSite(stream.getSemanticObject().getModel().getName());
        //System.out.println("Entra 3");
        int neutrals = 0, positives = 0, negatives = 0;
        Iterator<PostIn> itObjPostIns = null;
        if (semObj.getGenericInstance() instanceof Stream) {
            Stream stream = (Stream) semObj.getGenericInstance();
            itObjPostIns = stream.listPostInStreamInvs();
        } else if (semObj.getGenericInstance() instanceof SocialTopic) {
            SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
            itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
        }
        while (itObjPostIns.hasNext()) {
            PostIn postIn = itObjPostIns.next();
            if (postIn != null) {
                if (postIn.getPostSentimentalType() == 0) {
                    neutrals++;
                } else if (postIn.getPostSentimentalType() == 1) {
                    positives++;
                } else if (postIn.getPostSentimentalType() == 2) {
                    negatives++;
                }
            }
        }
        float intTotalVotos = positives + negatives + neutrals;

        //Positivo
        float intPorcentajePositive = ((float) positives * 100) / (float) intTotalVotos;

        //System.out.println("Votos Positivos:"+positives+", porcentaje:"+intPorcentajePositive); 

        //Negativo
        float intPorcentajeNegative = ((float) negatives * 100) / (float) intTotalVotos;

        //System.out.println("Votos negatives"+negatives+", porcentaje:"+intPorcentajeNegative); 

        //Neutro
        float intPorcentajeNeutral = ((float) neutrals * 100) / (float) intTotalVotos;

        //System.out.println("Votos neutrals"+neutrals+", porcentaje:"+intPorcentajeNeutral);         


        //System.out.println("Entra 4:"+positives+","+negatives+","+neutrals);
        JSONArray node = new JSONArray();

        if (intPorcentajePositive > 0) {
            JSONObject node1 = new JSONObject();

            node1.put("label", "" + SWBSocialResUtil.Util.getStringFromGenericLocale("positives", lang));
            node1.put("value1", "" + positives);
            node1.put("value2", "" + round(intPorcentajePositive));
            node1.put("color", "#008000");
            node1.put("chartclass", "possClass");
            JSONObject joc = new JSONObject();
            joc.put("positivos", "" + positives);
            joc.put("negativos", "" + negatives);
            joc.put("neutros", "" + neutrals);
            node1.put("valor", joc);
            node.put(node1);
        }
        if (intPorcentajeNegative > 0) {
            JSONObject node2 = new JSONObject();
            node2.put("label", "" + SWBSocialResUtil.Util.getStringFromGenericLocale("negatives", lang));
            node2.put("value1", "" + negatives);
            node2.put("value2", "" + round(intPorcentajeNegative));
            node2.put("color", "#FF0000");
            node2.put("chartclass", "negClass");
            JSONObject joc = new JSONObject();
            joc.put("positivos", "" + positives);
            joc.put("negativos", "" + negatives);
            joc.put("neutros", "" + neutrals);
            node2.put("valor", joc);
            node.put(node2);
        }
        if (intPorcentajeNeutral > 0) {
            JSONObject node3 = new JSONObject();
            node3.put("label", "" + SWBSocialResUtil.Util.getStringFromGenericLocale("neutral", lang));
            node3.put("value1", "" + neutrals);
            node3.put("value2", "" + round(intPorcentajeNeutral));
            node3.put("color", "#838383");
            node3.put("chartclass", "neuClass");
            JSONObject joc = new JSONObject();
            joc.put("positivos", "" + positives);
            joc.put("negativos", "" + negatives);
            joc.put("neutros", "" + neutrals);
            node3.put("valor", joc);
            node.put(node3);
        }

        if (positives == 0 && negatives == 0 && neutrals == 0) {
            //System.out.println("Entra a ObSentData TODOS 0");
            JSONObject node3 = new JSONObject();
            node3.put("label", "Sin datos");
            node3.put("value1", "0");
            node3.put("value2", "100");
            node3.put("color", "#eae8e3");
            node3.put("chartclass", "neuClass");
            JSONObject joc = new JSONObject();
            joc.put("positivos", "" + 0);
            joc.put("negativos", "" + 0);
            joc.put("neutros", "" + 0);
            node3.put("valor", joc);
            node.put(node3);
        }
        return node;
    }

    public double round(float number) {
        return Math.rint(number * 100) / 100;
    }
%>
<%
    //System.out.println("Entra 0jjjjjjjjjjj");
    if (request.getParameter("objUri") != null) {
        //System.out.println("Entra 1:"+request.getParameter("objUri"));
        //SemanticObject semObj = SemanticObject.getSemanticObject(request.getParameter("objUri"));
        SemanticObject semObj = SemanticObject.createSemanticObject(request.getParameter("objUri"));
        String lang = request.getParameter("lang");
        //System.out.println("Entra 2:"+lang);
        out.println(getObject(semObj, lang));
    }
%>