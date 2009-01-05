package org.semanticwb.model;

import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.model.base.*;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

public class GenericFormElement extends SWBFormElement
{
    public GenericFormElement()
    {
        super(null);
    }

    public GenericFormElement(SemanticObject obj)
    {
        super(obj);
    }
    
    @Override
    public String renderElement(SemanticObject obj, SemanticProperty prop, String type, String mode, String lang)
    {
        if(obj==null)obj=new SemanticObject();
        String ret="";
        if(type.endsWith("iphone"))
        {
            ret=renderIphone(obj, prop, type, mode, lang);
        }else
        {
            ret=renderXHTML(obj, prop, type, mode, lang);
        }
        return ret;
    }    
    
    public String renderIphone(SemanticObject obj, SemanticProperty prop, String type, String mode, String lang)
    {
        return "";
    }

    public String renderXHTML(SemanticObject obj, SemanticProperty prop, String type, String mode, String lang)
    {
        String ret="";
        String name=prop.getName();
        String label=prop.getDisplayName(lang);
        SemanticObject sobj=prop.getDisplayProperty();
        boolean required=prop.isRequired();
        String pmsg=null;
        String imsg=null;
        String selectValues=null;
        if(sobj!=null)
        {
            DisplayProperty dobj=new DisplayProperty(sobj);
            pmsg=dobj.getPromptMessage();
            imsg=dobj.getInvalidMessage();
            selectValues=dobj.getSelectValues(lang);
        }
        
        if(imsg==null)
        {
            if(prop.isDataTypeProperty() && prop.isInt())
            {
                imsg="Número invalido.";
                if(lang.equals("en"))
                {
                    imsg="Invalid number.";
                }
            }
            
            if(required)
            {
                imsg=label+" es requerido.";
                if(lang.equals("en"))
                {
                    imsg=label+" is required.";
                }
            }
        }
        
        if(pmsg==null)
        {
            pmsg="Captura "+label+".";
            if(lang.equals("en"))
            {
                pmsg="Enter "+label+".";
            }
        }        
        
        if(prop.isDataTypeProperty())
        {
            if(selectValues!=null)
            {
                String value=obj.getProperty(prop);
                ret="<span>";
                StringTokenizer st=new StringTokenizer(selectValues,"|");
                while(st.hasMoreTokens())
                {
                    String tok=st.nextToken();
                    int ind=tok.indexOf(':');
                    String id=tok;
                    String val=tok;
                    if(ind>0)
                    {
                        id=tok.substring(0,ind);
                        val=tok.substring(ind+1);
                    }
                    ret+=" <label for=\""+name+id+"\"><input dojoType=\"dijit.form.RadioButton\" id_=\""+name+id+"\" name=\""+name+"\"";
                    if(id.equals(value))ret+=" checked=\"checked\"";
                    ret+=" value=\""+id+"\" type=\"radio\" />"+val+"</label>";
                }
                ret+="</span>";
                
            }else if(prop.isBoolean())
            {
                String checked="";
                boolean value=obj.getBooleanProperty(prop);
                if(value)checked="checked=\"checked\"";
                ret="<input type=\"checkbox\" id_=\""+name+"\" name=\""+name+"\" "+checked
                    + " dojoType=\"dijit.form.CheckBox\""
                    + " required=\""+required+"\""
//                    + " propercase=\"true\""
                    + " promptMessage=\""+pmsg+"\""
                    + " invalidMessage=\""+imsg+"\""
//                    + " trim=\"true\""
                + "/>";
            }else if(prop.isDateTime())
            {
                String value=obj.getProperty(prop);
                if(value==null)value="";
                ret="<span _id=\""+name+"\" name=\""+name+"\">"+value+"</span>";
            }else if(prop.isInt() || prop.isLong())
            {
                String value=obj.getProperty(prop);
                if(value==null)value="";
                if(mode.equals("edit") || mode.equals("create") )
                {
                    ret="<input _id=\""+name+"\" name=\""+name+"\" size=\"10\" value=\""+value+"\""
                        + " dojoType=\"dijit.form.ValidationTextBox\""
                        + " regExp=\"\\d+\""
                        + " required=\""+required+"\""
    //                    + " propercase=\"true\""
                        + " promptMessage=\""+pmsg+"\""
                        + " invalidMessage=\""+imsg+"\""
    //                    + " trim=\"true\""
                    + "/>";
//                }else if(mode.equals("edit"))
//                {
//                    ret="<label for=\""+name+"\">"+label
//                        + reqtxt
//                        + "</label>"
//                        + "<p><span _id=\""+name+"\" dojoType=\"dijit.InlineEditBox\" editor=\"dijit.form.ValidationTextBox\" editorParams=\"{regExp:'\\\\d+'}\" autoSave=\"false\" name=\""+name+"\">"+value+"</span></p>";
                }else if(mode.equals("view"))
                {
                    ret="<span _id=\""+name+"\" name=\""+name+"\">"+value+"</span>";
                }
            }else
            {
                String value=obj.getProperty(prop);
                if(value==null)value="";
                if(mode.equals("edit") || mode.equals("create") )
                {
                    ret="<input _id=\""+name+"\" name=\""+name+"\" size=\"30\" value=\""+value+"\""
                        + " dojoType=\"dijit.form.ValidationTextBox\""
                        + " required=\""+required+"\""
    //                    + " propercase=\"true\""
                        + " promptMessage=\""+pmsg+"\""
                        + " invalidMessage=\""+imsg+"\""
                        + " trim=\"true\""
                    + "/>";
                }else if(mode.equals("view"))
                {
                    ret="<span _id=\""+name+"\" name=\""+name+"\">"+value+"</span>";
                }
            }

        }else if(prop.isObjectProperty())
        {
            if(name.startsWith("has"))
            {
            
            }else
            {
                SemanticObject value=obj.getObjectProperty(prop);
                ret="<span>";
                if(value!=null)
                {
                    ret+="<a href=\"?suri="+value.getEncodedURI()+"\" onclick=\"addNewTab('"+value.getURI()+"', null, '"+value.getDisplayName(lang)+"');return false;\">"+value.getDisplayName()+"</a>";
                }
                ret+="</span>";
            }
        }
        return ret;
    }

}
