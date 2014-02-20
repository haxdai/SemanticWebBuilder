package org.semanticwb.applicate.admin;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
//import java.io.BufferedReader;
//import java.io.Closeable;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.Reader;
//import java.io.UnsupportedEncodingException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import com.ecwid.mailchimp.MailChimpClient;
//import com.ecwid.mailchimp.MailChimpObject;
//import com.ecwid.mailchimp.method.v2_0.lists.Email;
//import com.ecwid.mailchimp.method.v2_0.lists.MemberInfoData;
//import com.ecwid.mailchimp.method.v2_0.lists.MemberInfoMethod;
//import com.ecwid.mailchimp.method.v2_0.lists.MemberInfoResult;
//import com.ecwid.mailchimp.method.v2_0.lists.SubscribeMethod;
//import com.google.gson.Gson;
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Dictionary;
//import java.util.Hashtable;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//
///**
// *
// * @author gabriela.rosales
// */
//public class Applicate {
//
//    public void connect() throws IOException {
//        Map<String, String> params = new HashMap<String, String>(2);
//        params.put("access_token", "464dd4f3a2aebd448ab4b83ffa2ff9fe-us3");
//        String facebookResponse = "";
//        String url = "https://us7.api.mailchimp.com/2.0/lists/batch-subscribe.json";
//        facebookResponse = postRequest(params, url,
//                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95",
//                "POST");
//
//    }
//
//    private String postRequest(Map<String, String> params, String url,
//            String userAgent, String method) throws IOException {
//        System.out.println("++URL : " + url);
//        URL serverUrl = new URL(url);
//        CharSequence paramString = (null == params) ? "" : delimit(params.entrySet(), "&", "=", true);
//        System.out.println("serverUrl: " + serverUrl);
//        HttpURLConnection conex = null;
//        OutputStream out = null;
//        InputStream in = null;
//        String response = null;
//
//        if (method == null) {
//            method = "POST";
//        }
//        try {
//            conex = (HttpURLConnection) serverUrl.openConnection();
//            System.out.println("conex" + conex);
//
//            if (userAgent != null) {
//                conex.setRequestProperty("user-agent", userAgent);
//            }
//            System.out.println("1");
//            conex.setConnectTimeout(30000);
//            conex.setReadTimeout(60000);
//            conex.setRequestMethod(method);
//            conex.setDoOutput(true);
//            System.out.println("3");
//            conex.connect();
//            System.out.println("4");
//            out = conex.getOutputStream();
//            System.out.println("out" + out);
//            out.write(paramString.toString().getBytes("UTF-8"));
//            System.out.println("params:" + paramString);
//            in = conex.getInputStream();
//            System.out.println("in" + in);
//            response = getResponse(in);
//            System.out.println("resposne:" + response);
//        } catch (java.io.IOException ioe) {
//            System.out.println("entor en el catch");
//            System.out.println("Error : " + conex.getErrorStream());
//            response = getResponse(conex.getErrorStream());
//            //ioe.printStackTrace();
//        } finally {
//            close(in);
//            close(out);
//            if (conex != null) {
//                conex.disconnect();
//            }
//        }
//        if (response == null) {
//            response = "";
//        }
//        System.out.println("RESPONSE : " + response);
//        return response;
//    }
//
//    private void close(Closeable c) {
//        if (c != null) {
//            try {
//                c.close();
//            } catch (IOException ex) {
//                System.out.println("Error:" + ex);
//            }
//        }
//    }
//
//    private static String getResponse(InputStream data) throws IOException {
//
//        System.out.println("Data: " + data);
//        Reader in = new BufferedReader(new InputStreamReader(data, "UTF-8"));
//        StringBuilder response = new StringBuilder(256);
//        char[] buffer = new char[1000];
//        int charsRead = 0;
//        while (charsRead >= 0) {
//            response.append(buffer, 0, charsRead);
//            charsRead = in.read(buffer);
//        }
//        in.close();
//        return response.toString();
//    }
//
//    private CharSequence delimit(Collection<Map.Entry<String, String>> entries,
//            String delimiter, String equals, boolean doEncode)
//            throws UnsupportedEncodingException {
//
//        if (entries == null || entries.isEmpty()) {
//            return null;
//        }
//        StringBuilder buffer = new StringBuilder(64);
//        boolean notFirst = false;
//        for (Map.Entry<String, String> entry : entries) {
//            if (notFirst) {
//                buffer.append(delimiter);
//            } else {
//                notFirst = true;
//            }
//            CharSequence value = entry.getValue();
//            buffer.append(entry.getKey());
//            buffer.append(equals);
//            buffer.append(doEncode ? encode(value) : value);
//        }
//        return buffer;
//    }
//
//    private String encode(CharSequence target) throws UnsupportedEncodingException {
//
//        String result = "";
//        if (target != null) {
//            result = target.toString();
//            result = URLEncoder.encode(result, "UTF8");
//        }
//        return result;
//    }
//
//    public static void main(String[] args) throws IOException, JSONException {
//        Applicate a = new Applicate();
//
//        JSONArray objClientes = new JSONArray();
//        JSONObject objCliente = new JSONObject();
//        String[] num = {"hshshs@hotmail.com", "828383", "8888"};
//        Gson gson = new Gson();
//gson.toJson("email= gabriel.rmvo@hotmai.com")        ;
//gson.toJson("email= gabriel.rmvo@hotmai.com")        ;
//gson.toJson("email= gabriel.rmvo@hotmai.com")        ;
//        System.out.println("GSON"+gson.toString());
////gson.toJson("abcd");      
////gson.toJson(new Long(10)); 
////int[] values = { 1 };f
//        String json = "{email=gabriela.salazar@hotmail.com,euid=24124,leid=12312}";
//        JSONObject obj = new JSONObject();
//        obj.put("name", "mkyong.com");
//        obj.put("age", new Integer(100));
//
//        JSONArray list = new JSONArray();
//        list.put("msg 1");
//        list.put("msg 2");
//        list.put("msg 3");
//
//        obj.put("messages", list);
//        objCliente.put("email", "gabriela.salazar@hotmail.com");
//        objCliente.put("euid", "12");
//        objCliente.put("leid", "123");
//        objClientes.put(objCliente);
//        gson.toJson(objCliente);
//
//        final Map<String, Object> email = new HashMap<>();
//        email.put("email", "gabriela.salazar@hotmail.com");
//        email.put("euid", "234");
//        email.put("leid", "324");
//
//       //Map<String,String> map = new HashMap<String,String>();
//        Dictionary map = new Hashtable();
//        map.put("email", "gabriela.salazar@hotmail.com");
//            map.put("euid", "234");
//            map.put("leid", "324");
//        System.out.println("gson:" + gson.toJson(email));
//        
//        JSONObject objeto = new JSONObject();
//        JSONArray email1 = new JSONArray();
//        JSONObject emailObj = new JSONObject();
//        emailObj.put("email", "jacqueline_princess92@hotmail.com");
//        emailObj.put("euid", "234");
//        emailObj.put("leid", "324");
//        email1.put(emailObj);
//
//        objeto.put("apikey", "99352dad89129549af21584e56fb0122-us3");
//        objeto.put("id", "d34edd3b7f");
//        objeto.put("email", emailObj);
//        objeto.put("double_optin", false);
//        
//        System.out.println("--------"+objeto.toString());
//        
//        
//        
//           String urlComment = "https://us3.api.mailchimp.com/2.0/lists/subscribe?";
//                URL url;
//                HttpURLConnection conn = null;
//              
//                    url = new URL(urlComment);
//                    conn = (HttpURLConnection) url.openConnection();
//                    conn.setDoInput(true);
//                    conn.setDoOutput(true);
//                    conn.setRequestMethod("POST");
//                    conn.setUseCaches(false);
//                    conn.setRequestProperty("Host", "us3.api.mailchimp.com");
//                    conn.setRequestProperty("Content-Type", "application/json");                    
//
//                    DataOutputStream writer = new DataOutputStream(conn.getOutputStream());                        
//
//                    writer.write(objeto.toString().getBytes("UTF-8"));
//                    writer.flush();
//                    writer.close();                        
//                    BufferedReader readerl = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                  StringBuilder videoInfo = new StringBuilder();
//                    String docxml;
//                    while((docxml = readerl.readLine()) != null) {
//                       videoInfo.append(docxml);
//                    }
//                    docxml = videoInfo.toString();
//                    System.out.println("++++++++++++++"+docxml);
//                    
//                     //SWBUtils.EMAIL.sendBGEmail(email, "hola", "hola");
//                    
//
////        //  String url ="https://us3.api.mailchimp.com/2.0/lists/members?apikey=99352dad89129549af21584e56fb0122-us3&id=d34edd3b7f";
////        String url = "https://us3.api.mailchimp.com/2.0/lists/subscribe?apikey=99352dad89129549af21584e56fb0122-us3&id=d34edd3b7f&email=" + gson.toJson(json);
////        //String url = "https://us3.api.mailchimp.com/2.0/lists/subscribe?apikey=99352dad89129549af21584e56fb0122-us3&id=d34edd3b7f&email={email=\"gabriela_rdl86@hotmail.com\",euid=\"233\",leid=\"242\"}";
////
////        String respuesta = a.postRequest(null, url, null, null);
////        System.out.println("respuesta:" + respuesta);
//    }
//
//
//}
