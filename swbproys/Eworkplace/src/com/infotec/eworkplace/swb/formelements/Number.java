package com.infotec.eworkplace.swb.formelements;

import com.infotec.eworkplace.swb.formelements.base.CurrencyBase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.DisplayProperty;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.platform.SemanticVocabulary;

/**
 * Caja de texto para capturar numero a n digitos
 */
public class Number extends com.infotec.eworkplace.swb.formelements.base.NumberBase
{

    static Logger log = SWBUtils.getLogger(Number.class);

    public Number(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type,
            String mode, String lang)
    {
        if (obj == null)
        {
            obj = new SemanticObject();
        }

//        boolean IPHONE = false;
//        boolean XHTML  = false;
        boolean DOJO = false;

//        if (type.equals("iphone")) {
//            IPHONE = true;
//        } else if (type.equals("xhtml")) {
//            XHTML = true;
//        } else
        if (type.equals("dojo"))
        {
            DOJO = true;
        }

        StringBuilder ret = new StringBuilder();
        String name = propName;
        String label = prop.getDisplayName(lang);
        SemanticObject sobj = prop.getDisplayProperty();
        boolean required = prop.isRequired();
        String pmsg = null;
        String imsg = null;
        boolean disabled = false;

        if (sobj != null)
        {
            DisplayProperty dobj = new DisplayProperty(sobj);

            pmsg = dobj.getPromptMessage();
            imsg = dobj.getInvalidMessage();
            disabled = dobj.isDisabled();
        }

        if (DOJO)
        {
            if (required && imsg == null)
            {
                imsg = label + " es requerido.";

                if (lang.equals("en"))
                {
                    imsg = label + " is required.";
                }
            }

            if (pmsg == null)
            {
                pmsg = "Captura " + label + ".";

                if (lang.equals("en"))
                {
                    pmsg = "Enter " + label + ".";
                }
            }
        }

        String ext = "";

        if (disabled)
        {
            ext += " disabled=\"disabled\"";
        }

        String value = request.getParameter(propName);

        if (value == null)
        {
            value = obj.getProperty(prop);
        }

        if (value == null)
        {
            value = "";
        }

        value = value.replace("\"", "&quot;");

        // value=SWBUtils.TEXT.encodeExtendedCharacters(value);
//      System.out.println("value:"+value);
//      for(int x=0;x<value.length();x++)
//      {
//          System.out.println(" "+(int)value.charAt(x));
//      }
        if (mode.equals("edit") || mode.equals("create"))
        {
            ret.append("<input name=\"").append(name).append("\" maxlength=\"").append(getNdigits()).append("\" size=\"").append(getNdigits() + 1).append("\" value=\"").append(value).append("\"");

            if (DOJO)
            {
                ret.append(" dojoType=\"dijit.form.ValidationTextBox\"");
            }

            if (DOJO)
            {
                ret.append(" required=\"").append(required).append("\"");
            }

//          ret.append(" propercase=\"true\"");
            if (DOJO)
            {
                ret.append(" promptMessage=\"").append(pmsg).append("\"");
            }

            if (DOJO)
            {

                ret.append(((!getFormat().isEmpty())
                        ? (" regExp=\"" + getFormat().toString() + "\"")
                        : ""));
            }

            if (DOJO)
            {
                ret.append(" invalidMessage=\"").append(imsg).append("\"");
            }

            ret.append(" ").append(getAttributes());

            /*if(getMaxLength()>0)
            ret.append(" maxlength=\""+getMaxLength()+"\"");*/

            if (DOJO)
            {
                ret.append(" trim=\"true\"");
            }

            ret.append(" style=\"width:300px;\"");
            ret.append(ext);
            ret.append("/>");

            if (DOJO)
            {
                if (!mode.equals("create") && prop.isLocaleable())
                {
                    ret.append(" <a href=\"#\" onClick=\"javascript:showDialog('").append(SWBPlatform.getContextPath()).append("/swbadmin/jsp/propLocaleEdit.jsp?suri=").append(obj.getEncodedURI()).append("&prop=").append(prop.getEncodedURI()).append("','Idiomas de la Propiedad ").append(prop.getDisplayName(lang)).append("');\">locale</a>");
                }
            }
        }
        else if (mode.equals("view"))
        {
            ret.append("<span name=\"").append(name).append("\">").append(value).append("</span>");
        }

        return ret.toString();
    }

    @Override
    public int getNdigits()
    {
        int ndigits = super.getNdigits();
        if (ndigits <= 0)
        {
            String uridefault = SemanticVocabulary.SWB_PROP_DEFAULTVALUE;
            SemanticProperty defaultProp = this.getSemanticObject().getModel().getSemanticProperty(uridefault);
            String value = Number.intraxf_ndigits.getSemanticObject().getProperty(defaultProp);
            try
            {
                ndigits = Integer.parseInt(value);
            }
            catch (Exception e)
            {
                log.trace(e);
            }
        }
        return ndigits;
    }

    @Override
    public void validate(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName) throws FormValidateException
    {
        String format = getFormat();
        Pattern pattern = Pattern.compile(format);
//        if (request.getParameter(propName) == null)
//        {
//            throw new FormValidateException("El valor es incorrecto");
//        }
        String value = request.getParameter(propName);
//        if (value == null || value.isEmpty())
//        {
//            throw new FormValidateException("El valor es incorrecto");
//        }
        if (value != null && !value.trim().isEmpty())
        {
            value=value.trim();
            Matcher matcher = pattern.matcher(value);
            if (!matcher.matches())
            {
                throw new FormValidateException("El valor es incorrecto");
            }


            //value = value.replace(",", "").replace("$", "").trim();

            try
            {
                int ivalue = Integer.parseInt(value);
                if (!this.isNumberCero())
                {
                    if (ivalue <= 0)
                    {
                        throw new FormValidateException("El valor es incorrecto, no puede ser negativo o cero");
                    }
                }

            }
            catch (NumberFormatException pe)
            {

                throw new FormValidateException("El valor es incorrecto");
            }
        }

    }

    @Override
    public void process(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName)
    {
        try
        {
            validate(request, obj, prop);
            String value = request.getParameter(propName);
            if (value == null || value.isEmpty())
            {
                log.error("No se puede actulizar valor para propiedad " + propName + " objecto: " + obj.getURI());
            }
            else
            {
                //value = value.replace(",", "").replace("$", "").trim();
                try
                {
                    int fvalue = Integer.parseInt(value);
                    obj.setIntProperty(prop, fvalue);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    private String getFormat()
    {
        StringBuilder format = new StringBuilder();
        format.append("\\d{1,").append(getNdigits()).append("}");
        return format.toString();
    }
}
