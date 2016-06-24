package org.semanticwb.bsc.formelement;

import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

/**
 * FormElement que presenta un Editor, utilizando la clase dijit/Editor de Dojo
 */
public class RichTextEditorDojo extends org.semanticwb.bsc.formelement.base.RichTextEditorDojoBase {

    /**
     * Realiza operaciones de registro de eventos en bit&cora
     */
    private static Logger log = SWBUtils.getLogger(Ordinal.class);

    public RichTextEditorDojo(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    /**
     * Genera el c&oacute;digo HTML para representar el valor almacenado en la
     * interface del usuario
     *
     * @param request la petici&oacute;n HTTP generada por el cliente
     * @param obj el objeto al que pertenece la propiedad del valor de
     * inter&eacute;s
     * @param prop la propiedad del valor de inter&eacute;s a representar en la
     * interface
     * @param propName el nombre de la propiedad del valor de inter&eacute;s a
     * representar en la interface
     * @param type el tipo de representacio&acute;n utilizado en la interface
     * (dojo, XHTML)
     * @param mode el modo en que se desea la representaci&oacute;n del valor
     * ({@literal create}, {@literal edit}, {@literal view} o
     * {@literal inlineEdit})
     * @param lang el lenguaje utilizado en la representaci&oacute;n del valor
     * @return un {@code String} que representa el valor de la propiedad
     * especificada considerando el tipo y modo indicados
     */
    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode, String lang) {
        String toReturn = null;

        if (mode == null) {
            mode = "view";
        }
        if (mode.equals("edit") || mode.equals("create")) {
            toReturn = super.renderElement(request, obj, prop, propName, type, mode, lang);
        } else if (mode.equals("view")) {
            toReturn = (obj.getProperty(prop) == null
                    || (obj.getProperty(prop) == null && "null".equals(obj.getProperty(prop)))
                            ? "" : obj.getProperty(prop));
            toReturn = SWBUtils.XML.replaceXMLTags(toReturn);
        } else if (mode.equals("inlineEdit")) {
            /*Al utilizar este modo, se debe incluir en el HTML las instrucciones 
             * dojo.require del InlineEditBox: dijit._editor.plugins.AlwaysShowToolbar y dijit.form.Textarea, al menos*/
            StringBuilder viewString = new StringBuilder(128);
            String value = (obj.getProperty(prop) == null
                    || (obj.getProperty(prop) == null && "null".equals(obj.getProperty(prop)))
                            ? "" : obj.getProperty(prop));
            String objectId = obj.getSemanticClass().getClassCodeName() + "_" + propName;
//            String url = (String) request.getAttribute("urlRequest");

            viewString.append("<script type=\"text/javascript\">\n");
            viewString.append("  <!--\n");
            viewString.append("    var iledit_");
            viewString.append(objectId);
            viewString.append(";\n");
            viewString.append("    dojo.addOnLoad( function() {\n");
            viewString.append("      iledit_");
            viewString.append(objectId);
            viewString.append(" = new dijit.Editor({\n");
            viewString.append("        id: \"ile_");
            viewString.append(objectId);
            viewString.append("\",\n");
            viewString.append("        editor: \"dijit.Editor\",\n");
            viewString.append("        height: \"100%\",\n");
            viewString.append("extraPlugins:[ 'foreColor', 'hiliteColor'],\n"); //, Revisar funcionamiento: 'PasteFromWord'
            viewString.append("        onChange: function(value) {\n");
            viewString.append("          document.getElementById('" + objectId + "').value=arguments[0];");
            viewString.append("        }\n");

            viewString.append("      }, 'eb_");
            viewString.append(objectId);
            viewString.append("');\n");
            viewString.append("      iledit_");
            viewString.append(objectId);
            viewString.append(".startup();\n");
            viewString.append("          var data = '" + value.replaceAll("\\n", "") + "';");
            viewString.append("          document.getElementById('" + objectId + "').value=data;");
            
            viewString.append("    });\n ");
            viewString.append("-->\n");
            viewString.append("</script>\n");
            viewString.append("<div id=\"eb_");
            viewString.append(objectId);
            viewString.append("\" class=\"swb-ile\">\n");
            viewString.append(value).append("\n");
            viewString.append("</div>\n");
            toReturn = viewString.toString();
        }

        if (toReturn == null) {
            toReturn = "";
        }
        return toReturn;
    }

    /**
     * Procesa la informaci&oacute;n recibida para almacenarla en la propiedad
     * del objeto indicado
     *
     * @param request la petici&oacute;n HTTP generada por el cliente
     * @param obj el objeto al que pertenece la propiedad de inter&eacute;s
     * @param prop la propiedad del objeto a la que se desea asociar la
     * informaci&oacute;n recibida
     */
    @Override
    public void process(HttpServletRequest request, SemanticObject obj, SemanticProperty prop) {
        super.process(request, obj, prop);
    }

    /**
     * Procesa la informaci&oacute;n recibida para almacenarla en la propiedad
     * del objeto indicado
     *
     * @param request la petici&oacute;n HTTP generada por el cliente
     * @param obj el objeto al que pertenece la propiedad de inter&eacute;s
     * @param prop la propiedad del objeto a la que se desea asociar la
     * informaci&oacute;n recibida
     * @param propName el nombre de la propiedad especificada
     */
    @Override
    public void process(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName) {
        String value = request.getParameter(propName);
        try {
            if (value != null && !value.isEmpty()) {
                obj.setProperty(prop, SWBUtils.XML.replaceXMLTags(value));
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

}
