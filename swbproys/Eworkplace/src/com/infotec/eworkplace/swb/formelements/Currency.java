package com.infotec.eworkplace.swb.formelements;

import com.infotec.eworkplace.swb.formelements.base.CurrencyBase;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
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
import org.semanticwb.portal.SWBFormMgr;

public class Currency extends com.infotec.eworkplace.swb.formelements.base.CurrencyBase
{

    static Logger log = SWBUtils.getLogger(Currency.class);
    private static final DecimalFormat CURRENCY = new DecimalFormat("$###,###,###.##", new DecimalFormatSymbols(new Locale("es", "MX")));

    public Currency(org.semanticwb.platform.SemanticObject base)
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

        try
        {
            if (!value.isEmpty())
            {
                double dvalue = Double.parseDouble(value);
                value = CURRENCY.format(dvalue);
            }

        }
        catch (Exception e)
        {
            log.trace(e);
        }
        if (mode.equals("edit") || mode.equals("create"))
        {
            ret.append("<input name=\"").append(name).append("\" size=\"30\" value=\"").append(value).append("\"");

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
                ret.append(((getFormat() != null)
                        ? (" regExp=\"" + getFormat() + "\"")
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
    public String getFormat()
    {
        String format = super.getFormat();
        if (format == null)
        {
            String uridefault = SemanticVocabulary.SWB_PROP_DEFAULTVALUE;
            SemanticProperty defaultProp = this.getSemanticObject().getModel().getSemanticProperty(uridefault);
            format = CurrencyBase.intraxf_format.getSemanticObject().getProperty(defaultProp);

        }
        return format;
    }

    @Override
    public void validate(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName) throws FormValidateException
    {
        String format = getFormat();
        Pattern pattern = Pattern.compile(format);
        if (request.getParameter(propName) == null)
        {
            throw new FormValidateException("El valor es incorrecto");
        }
        String value = request.getParameter(propName);
        if (value == null || value.isEmpty())
        {
            throw new FormValidateException("El valor es incorrecto");
        }
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches())
        {
            throw new FormValidateException("El valor es incorrecto");
        }


        value = value.replace(",", "").replace("$", "").trim();

        try
        {
            float ivalue = Float.parseFloat(value);
            if (!this.isCurrencyCero())
            {
                if (ivalue <= 0)
                {
                    throw new FormValidateException("El valor no puede ser negativo o cero");
                }
            }


        }
        catch (NumberFormatException pe)
        {

            throw new FormValidateException("El valor es incorrecto");
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
                value = value.replace(",", "").replace("$", "").trim();
                try
                {
                    float fvalue = Float.parseFloat(value);
                    obj.setFloatProperty(prop, fvalue);
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
}
