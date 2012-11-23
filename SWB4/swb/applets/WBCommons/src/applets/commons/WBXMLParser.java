/**
* SemanticWebBuilder Process (SWB Process) es una plataforma para la gesti?n de procesos de negocio mediante el uso de 
* tecnolog?a sem?ntica, que permite el modelado, configuraci?n, ejecuci?n y monitoreo de los procesos de negocio
* de una organizaci?n, as? como el desarrollo de componentes y aplicaciones orientadas a la gesti?n de procesos.
* 
* Mediante el uso de tecnolog?a sem?ntica, SemanticWebBuilder Process puede generar contextos de informaci?n
* alrededor de alg?n tema de inter?s o bien integrar informaci?n y aplicaciones de diferentes fuentes asociadas a
* un proceso de negocio, donde a la informaci?n se le asigna un significado, de forma que pueda ser interpretada
* y procesada por personas y/o sistemas. SemanticWebBuilder Process es una creaci?n original del Fondo de 
* Informaci?n y Documentaci?n para la Industria INFOTEC.
* 
* INFOTEC pone a su disposici?n la herramienta SemanticWebBuilder Process a trav?s de su licenciamiento abierto 
* al p?blico (?open source?), en virtud del cual, usted podr? usarlo en las mismas condiciones con que INFOTEC 
* lo ha dise?ado y puesto a su disposici?n; aprender de ?l; distribuirlo a terceros; acceder a su c?digo fuente,
* modificarlo y combinarlo (o enlazarlo) con otro software. Todo lo anterior de conformidad con los t?rminos y 
* condiciones de la LICENCIA ABIERTA AL P?BLICO que otorga INFOTEC para la utilizaci?n de SemanticWebBuilder Process. 
* 
* INFOTEC no otorga garant?a sobre SemanticWebBuilder Process, de ninguna especie y naturaleza, ni impl?cita ni 
* expl?cita, siendo usted completamente responsable de la utilizaci?n que le d? y asumiendo la totalidad de los 
* riesgos que puedan derivar de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder Process, INFOTEC pone a su disposici?n la
* siguiente direcci?n electr?nica: 
*  http://www.semanticwebbuilder.org.mx
**/
 



/*
 * XMLParser.java
 *
 * Created on 8 de agosto de 2002, 13:27
 */
package applets.commons;

import java.io.*;
import java.util.*;
/**
 * Proporciona un parser para XML.
 *
 * It provides a XML parser
 *
 * @author  Administrador
 * @version 
 */
public class WBXMLParser {
    
    private String encoding=null;
    
    /** Creates new XMLParser */
    public WBXMLParser() {
    }
    
    public WBTreeNode createNode(String auxtag)
    {
        //System.out.println("createNode:"+auxtag);
        WBTreeNode auxnode=new WBTreeNode();
        auxnode.setType(WBTreeNode.TAG);
        
        boolean name=true;
        boolean attname=false;
        boolean value=false;
        boolean commi=false;
        String att=null;
        
        StringTokenizer st=new StringTokenizer(auxtag," =\"", true);
        while(st.hasMoreTokens())
        {
            String tok=st.nextToken();
            if(tok.equals(" "))
            {
                
            }else if(tok.equals("="))
            {
                attname=false;
                value=true;
            }else if(tok.equals("\""))
            {
                String val=tok;
                while(st.hasMoreTokens())
                {
                    tok=st.nextToken();
                    val+=tok;
                    if(tok.equals("\""))break;
                }
                //System.out.println("value="+val);
                auxnode.addAttribute(att,replaceStrTags(val));
                att=null;
                value=false;
                attname=true;
            }else
            {
                if(name)
                {
                    auxnode.setName(tok);
                    //System.out.println("name="+tok);
                    name=false;
                    attname=true;
                }else if(attname)
                {
                    //System.out.println("attname="+tok);
                    if(att!=null)
                    {
                        auxnode.addAttribute(att,"");
                    }
                    att=tok;
                    //attname=false;
                }else if(value)
                {
                    //System.out.println("value="+tok);
                    auxnode.addAttribute(att,tok);
                    att=null;
                    value=false;
                    attname=true;
                }
            }
            
        }
        return auxnode;
    }
    
    public WBTreeNode parse(String xml)
    {
        WBTreeNode node=new WBTreeNode();
        WBTreeNode auxnode=node;
        
        StringBuffer aux=new StringBuffer();
        
        int len=xml.length();
        char bxml[]=new char[len];
        xml.getChars(0,len,bxml,0);
        boolean tag=false;
        boolean data=false;
        for(int x=0;x<len;x++)
        {
           if(bxml[x]=='<')
           {
               tag=true;
               if(data==true)
               {
                   if(aux.toString().trim().length()!=0)
                   {
                        auxnode=auxnode.addNode();
                        auxnode.setType(WBTreeNode.TEXT);
                        auxnode.setText(replaceStrTags(aux.toString()));
                        auxnode=auxnode.getParent();
                        //System.out.println("text:("+aux+")");
                   }
                   aux=new StringBuffer();
               }
               data=false;
           }
           else if(bxml[x]=='>')
           {
                String auxtag=aux.toString();
                tag=false;
                data=true;
                if(auxtag.startsWith("/"))
                {
                    String temptag=auxtag.substring(1);
                    //System.out.println("temptag:"+temptag+" "+auxnode.getName());
                    if(auxnode.getName().equals(temptag))
                    {
                        auxnode=auxnode.getParent();
                        //System.out.println("endtag:("+temptag+")");
                    }else
                    {
                        System.out.println("Error al parsear xml");
                        return null;
                    }
                }
                else if(auxtag.endsWith("/"))
                {
                    String temptag=auxtag.substring(0,auxtag.length()-1);
                    auxnode.addNode(this.createNode(temptag));
/*                    
                    auxnode=auxnode.addNode();
                    auxnode.setName(temptag);
                    auxnode.setType(WBTreeNode.TAG);
                    auxnode=auxnode.getParent();
*/
                    //System.out.println("startendtag:("+temptag+")");
                }
                else if(auxtag.startsWith("?xml"))
                {
                    auxtag=auxtag.substring(1,auxtag.length()-1);
                    StringTokenizer st=new StringTokenizer(auxtag," =");
                    String temptag=st.nextToken();
                    if(auxnode.getParent()==null)
                    {
                        auxnode.setType(WBTreeNode.XMLTAG);
                        auxnode.setName(temptag);
                        //System.out.println("xmltag:("+temptag+")");
                        while(st.hasMoreTokens())
                        {
                            String attname=st.nextToken();
                            String attvalue=st.nextToken();
                            //System.out.println("attribute: ("+attname+")=("+attvalue+")");
                            auxnode.addAttribute(attname,replaceStrTags(attvalue));
                        }
                        encoding=auxnode.getAttribute("encoding");
                        if(encoding!=null)
                        {
                            try
                            {
                                //System.out.println("encoding:"+encoding);
                                ByteArrayInputStream inps=new ByteArrayInputStream(xml.getBytes());
                                InputStreamReader inpsr=new InputStreamReader(inps,encoding);
                                len=inpsr.read(bxml,0,len);
                            }catch(Exception e){System.out.println("Error al codificar xml..."+e);}
                        }
                        
                    }
                    else
                    {
                        System.out.println("Error al parsear xml");
                        return null;
                    }
                }
                else 
                {
                    WBTreeNode newNode=this.createNode(auxtag);
                    auxnode.addNode(newNode);
                    auxnode=newNode;
/*                    
                    StringTokenizer st=new StringTokenizer(auxtag," =");
                    String temptag=st.nextToken();
                    auxnode=auxnode.addNode();
                    auxnode.setName(temptag);
                    auxnode.setType(WBTreeNode.TAG);
                    //System.out.println("starttag:("+temptag+")");
                    while(st.hasMoreTokens())
                    {
                        String attname=st.nextToken();
                        String attvalue=st.nextToken();
                        //System.out.println("attribute: "+attname+"="+attvalue);
                        auxnode.addAttribute(attname,attvalue);
                    }
*/
                }
                aux=new StringBuffer();
           }
           else 
           {
               aux.append((char)bxml[x]);
           }
        }
        return node;
    }
    
        /**
         * Applies the charset specified in {@code enc} to the {@code data} received.
         * <p>Aplica el conjunto de caracteres especificado en {@code enc} a la
         * informaci&oacute;n recibida en {@code data}.</p>
         *
         * @param data a string with the information to apply the charset
         * @param enc the charset to apply
         * @return the string containing the {@code data} received with the charset applied.
         * el objeto string que contiene la informaci&oacute;n recibida
         * con el conjunto de caracteres aplicado.
         * @throws java.io.UnsupportedEncodingException If the specified charset's
         * name is not supported. <p>Si el nombre del conjunto de caracteres
         * especificado no es soportado.</p>
         * @throws java.io.IOException If there is a problem when applying the charset.
         * <p>Si ocurre un problema al aplicar el conjunto de caracteres.</p>
         * @throws UnsupportedEncodingException the unsupported encoding exception
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static String encode(String data, String enc)
                throws java.io.UnsupportedEncodingException, java.io.IOException
        {

            ByteArrayOutputStream sw = new java.io.ByteArrayOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(sw, enc);
            out.write(data);
            out.flush();
            return new String(sw.toByteArray());
        }

        /**
         * Decodes a string applying the specified charset in {@code enc}.
         * <p>Decodifica el contenido de {@code data} aplicando el conjunto de caracteres
         * especificado en {@code enc}.</p>
         *
         * @param data the string to decode
         * @param enc the charset to apply
         * @return a string resulting from applying the charset specified on {@code data}.
         * el objeto string que contiene la informaci&oacute;n recibida
         * con el conjunto de caracteres aplicado.
         * @throws java.io.UnsupportedEncodingException If the specified charset's
         * name is not supported. <p>Si el nombre del conjunto de caracteres
         * especificado no es soportado.</p>
         * @throws java.io.IOException If there is a problem when applying the charset.
         * <p>Si ocurre un problema al aplicar el conjunto de caracteres.</p>
         * @throws UnsupportedEncodingException the unsupported encoding exception
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static String decode(String data, String enc)
                throws java.io.UnsupportedEncodingException, java.io.IOException
        {

            ByteArrayInputStream sw = new ByteArrayInputStream(data.getBytes());
            InputStreamReader in = new InputStreamReader(sw, enc);

            StringBuilder ret = new StringBuilder(data.length());

            char[] bfile = new char[8192];
            int x;
            while ((x = in.read(bfile, 0, 8192)) > -1)
            {
                ret.append(new String(bfile, 0, x));
            }
            in.close();
            return ret.toString();
        }
    
    static public String replaceStrTags(String txt)
    {
        StringBuffer str=new StringBuffer(txt);
        for(int x=0;x<str.length();x++)
        {
            char ch=str.charAt(x);
            if(ch=='&' && str.charAt(x+1)!='#')
            {
                if((str.length()>=x+4) && str.substring(x,x+4).equals("&lt;"))
                {
                    str.replace(x,x+4,"<");
                }
                else if((str.length()>=x+4) && str.substring(x,x+4).equals("&gt;"))
                {
                    str.replace(x,x+4,">");
                }
                else if((str.length()>=x+5) && str.substring(x,x+5).equals("&amp;"))
                {
                    str.replace(x,x+5,"&");
                }
                else if((str.length()>=x+6) && str.substring(x,x+6).equals("&quot;"))
                {
                    str.replace(x,x+6,"\"");
                }else
                {
                    System.out.println("Codificaci?n no validada:"+str.substring(x));
                }
            }
        }
        return replaceAmpTags(str);
    }
    
    static public String replaceAmpTags(StringBuffer str)
    {
        for(int x=0;x<str.length();x++)
        {
            char ch=str.charAt(x);
            if(ch=='&')
            {
                int i=str.indexOf(";",x);
                if(i>2 && str.charAt(x+1)=='#')
                {
                    //System.out.println("x:"+x+" "+i);
                    try
                    {
                        int v=Integer.parseInt(str.substring(x+2,i)); 
                        //System.out.println(v);
                        str.replace(x,i+1,""+(char)v);
                    }catch(Exception noe){};
                }
            }
        }
        return str.toString();
    }
    
    static public String replaceAmpChars(String txt)
    {
        return replaceAmpChars(txt,255);
    }
    
    static public String replaceAmpChars(String txt, int graterthan)
    {
        StringBuffer str=new StringBuffer(txt);
        for(int x=0;x<str.length();x++)
        {
            char ch=str.charAt(x);
            //System.out.println("char:"+(int)ch+" "+ch);
            if(((int)ch)>graterthan)
            {
                str.replace(x,x+1,"&#"+(int)ch+";");
            }
        }
        return str.toString();
    }    
    
    static public String replaceStrChars(String str)
    {
        str=replaceAmpChars(str);
        StringBuffer ret=new StringBuffer();

        // split tokens
        StringTokenizer tokenizer = new StringTokenizer(str, " \t@%^&()-+=|\\{}[].;\"<>", true );
        while( tokenizer.hasMoreTokens() )    
        {
            // next token
            String token = tokenizer.nextToken();

            // replace '\t' by the content of "tabulation"
            if(token.startsWith("\t"))
            {
                ret.append("    ");
                continue;
            }

            // replace '<' by '&lt;'
            if(token.startsWith("<"))
            {
                ret.append("&lt;");
                continue;
            }

            // replace '>' by '&gt;'
            if( token.startsWith(">"))
            {
                ret.append("&gt;");
                continue;
            }

            // replace '&' by '&amp;'
            if(token.startsWith("&"))
            {
                ret.append("&amp;");
                continue;
            }

            // replace '"' by '&quot;'
            if(token.startsWith("\""))
            {
                ret.append("&quot;");
                continue;
            }
            ret.append(token);
        }
        return str=replaceAmpChars(ret.toString(),127);
        
    }
    
}
