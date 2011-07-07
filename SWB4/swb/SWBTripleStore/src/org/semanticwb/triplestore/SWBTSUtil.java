/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.triplestore;

import com.hp.hpl.jena.datatypes.BaseDatatype;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.impl.LiteralLabel;
import com.hp.hpl.jena.graph.impl.LiteralLabelFactory;
import com.hp.hpl.jena.rdf.model.AnonId;
import com.hp.hpl.jena.sparql.function.library.substring;
import java.util.StringTokenizer;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.SFBase64;

/**
 *
 * @author jei
 */
public class SWBTSUtil
{
    private static Logger log = SWBUtils.getLogger(SWBTSUtil.class);

    public static final int MAX_NODE_TEXT=255;

    public static String encodeText(String str)
    {
        if(str==null)return "";
        StringBuffer ret = new StringBuffer();
        for (int x = 0; x < str.length(); x++)
        {
            char ch = str.charAt(x);
            if (ch == '&')
            {
                ret.append("&#38;");
            }else if (ch > 127)
            {
                ret.append("&#" + (int) ch + ";");
            } else
            {
                ret.append(ch);
            }
        }
        return ret.toString();
    }

    public static String decodeText(String str)
    {
        if(str==null)return "";
        StringBuffer ret = new StringBuffer();
        int l = str.length();
        for (int x = 0; x < l; x++)
        {
            char ch = str.charAt(x);
            boolean addch = false;
            if (ch == '&' && (x + 1) < l && str.charAt(x + 1) == '#')
            {
                int i = str.indexOf(";", x);
                if (i > x)
                {
                    try
                    {
                        int v = Integer.parseInt(str.substring(x + 2, i));
                        ret.append((char) v);
                        x = i;
                        addch = true;
                    } catch (NumberFormatException e)
                    { //Si no se puede parsear no se agrega
                    }
                }
            }
            if (!addch)
            {
                ret.append(ch);
            }
        }
        return ret.toString();
    }

    private static String getSegment(String ext, String node)
    {
        String ret=null;
        String tk1=null;
        String tk2=null;
        do
        {
            tk1=null;
            StringTokenizer st=new StringTokenizer(ext,"|");
            if(st.hasMoreTokens())tk1=st.nextToken();
            if(st.hasMoreTokens())tk2=st.nextToken();
            int s=Integer.parseInt(tk2);
            int i=tk1.length()+tk2.length()+3;
            ret=ext.substring(i,s+i);
            ext=ext.substring(s+i);
        }while(tk1!=null && !tk1.equals(node));
        return ret;
    }

    public static Node string2Node(String value, String ext)
    {
        if(value==null)return null;

        //Long literal
        if(value.startsWith("lgs")) 
        {
            value=getSegment(ext, "subj");
        }else if(value.startsWith("lgp"))
        {
            value=getSegment(ext, "prop");
        }else if(value.startsWith("lgo"))
        {
            value=getSegment(ext, "obj");
        }

        String tk1=null;
        String tk2=null;
        String tk3=null;
        String tk4=null;
        StringTokenizer st=new StringTokenizer(value,"|");
        if(st.hasMoreTokens())tk1=st.nextToken();
        if(st.hasMoreTokens())tk2=st.nextToken();
        if(st.hasMoreTokens())tk3=st.nextToken();
        if(st.hasMoreTokens())
        {
            tk4 = value.substring(tk1.length()+tk2.length()+tk3.length()+3);
        }

        if(tk1.equals("uri"))return Node.createURI(tk2);
        if(tk1.equals("nid"))return Node.createAnon(new AnonId(tk2));
        //System.out.println("valueClass:"+value.getClass()+" "+value);
        if(tk1.equals("lit"))
        {
            if(tk3!=null && tk3.equals("_"))
            {
                tk3 = null;
            }

            if(!tk2.equals("_"))
            {
                //System.out.println("("+l.getDatatype().stringValue()+")");
                LiteralLabel ll = null;
                if(tk2.endsWith("#boolean"))
                {
                    ll=LiteralLabelFactory.create(Boolean.parseBoolean(tk4));
                }else if(tk2.endsWith("#character"))
                {
                    //ll=LiteralLabelFactory.create(tk4,tk3);
                }else if(tk2.endsWith("#double"))
                {
                    ll=LiteralLabelFactory.create( Double.parseDouble(tk4));
                }else if(tk2.endsWith("#float"))
                {
                    ll=LiteralLabelFactory.create( Float.parseFloat(tk4));
                }else if(tk2.endsWith("#integer") || tk2.endsWith("#int"))
                {
                    ll=LiteralLabelFactory.create( Integer.parseInt(tk4));
                }else if(tk2.endsWith("#long"))
                {
                    ll=LiteralLabelFactory.create( Long.parseLong(tk4));
                }else if(tk2.endsWith("#dateTime"))
                {
                    //ll=LiteralLabelFactory.create( Long.parseLong(l.stringValue()));
                }else if(tk2.endsWith("#date"))
                {
                    //ll=LiteralLabelFactory.create( Long.parseLong(l.stringValue()));
                }
                if(ll!=null)
                {
                    Node n=Node.createLiteral( ll );
                    //Node n=Node.createLiteral(l.stringValue(), l.getLanguage(), new BaseDatatype(l.getDatatype().stringValue()));
                    //System.out.println(n+" "+n.getLiteralValue().getClass());
                    return n;
                }else
                {
                    return Node.createLiteral(tk4, tk3, new BaseDatatype(tk2));
                }
            }
            return Node.createLiteral(decodeText(tk4), tk3, false);
        }
        return null;
    }

    /**
     * Regresa el código hash que representa al String proporcionado, siempre y cuando
     * el String sea mayor a 255, de lo contrario regresa null
     * @param str
     * @return
     */
    public static String getHashText(String str)
    {
        if(str==null)return null;
        if(str.length()>MAX_NODE_TEXT)
        {
            try
            {
                return SFBase64.encodeBytes(ChecksumCreator.getHash(str));
            }catch(Exception e)
            {
                log.error(e);
                return null;
            }
        }else
        {
            return null;
        }
    }

    /**
     * Regresa la representacion en String del nodo de RDF,
     * si es mayor a 255 regresa un Hash que identifica al String generado
     * @param node
     * @return
     */
    public static String node2HashString(Node node, String prefix)//, StringBuilder comp)
    {
        String txt=node2String(node);
        String hash=getHashText(txt);
        if(hash!=null)return prefix+"|"+hash;
        return txt;
    }

    /**
     * Regresa la representacion en String del nodo de RDF
     * @param node
     * @return
     */
    public static String node2String(Node node)//, StringBuilder comp)
    {
        if(node==null)return null;
        if(node.isBlank())return "nid|"+node.getBlankNodeId().toString();
        if(node.isURI())
        {
            //if(node.getURI().length()==0)return null;
            //System.out.println(node.getURI());
            return "uri|"+node.getURI();
        }
        if(node.isLiteral())
        {
            LiteralLabel l=node.getLiteral();
            String type=l.getDatatypeURI();
            String lang=l.language();
            String value=l.getValue().toString();
            if(lang==null || lang.length()==0)lang="_";
            if(type==null)
            {
                type = "_";
                value=encodeText(value);
            }
            //if(value==null)value="";
            return "lit|"+type+"|"+lang+"|"+value;
        }
        return null;
    }

}
