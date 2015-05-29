package org.semanticwb.bsc.formelement;

import javax.servlet.http.HttpServletRequest;
import org.semanticwb.SWBPlatform;
import org.semanticwb.bsc.element.BSCElement;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.element.Risk;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBModel;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;


   /**
   * Muestra el título del objeto al que se relaciona el objeto actual, si ese objeto es uno 
   * de tipo BSCElement el título mostrará un vínculo a la página detalle correspondiente 
   */
public class RelatedElement extends org.semanticwb.bsc.formelement.base.RelatedElementBase {
    
    public RelatedElement(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }
    
    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String type, String mode, String lang) {
        return renderElement(request, obj, prop, prop.getName(), type, mode, lang);
    }
    
    /**
     * Muestra el {@code displayName()} del objeto indicado por la propiedad {@code prop} de {@code obj},
     * agregando un v&iacute;nculo a la vista detalle correspondiente,
     * si es que el objeto de la propiedad es hijo directo de {@code BSCElement}
     * @param request la petici&oacute;n HTTP enviada por el cliente
     * @param obj el objeto sem&aacute;ntico que contiene a {@code prop}
     * @param prop la propiedad sem&aacute;ntica de la que se desea obtener el valor
     * @param propName el nombre de la propiedad sem&aacute;ntica
     * @param type el tipo de despliegue a generar, actualmente sin importancia
     * @param mode el modo en que se presentar&aacute; la informaci&oacute;n. Solo se soporta {@literal view}
     * @param lang el lenguaje en que se deber&iacute; presentar la informaci&oacute;n. Se presenta la 
     * informaci&ooacute;n del objeto por default.
     * @return un objeto {@code String} que representa el {@code displayName()} del objeto indicado por la propiedad recibida.
     */
    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode,
            String lang) {
        StringBuilder html = new StringBuilder();
        boolean showLink = false;
        SemanticClass rangeClass = prop.getRangeClass();
        if(rangeClass.getRootClass().equals(BSCElement.bsc_BSCElement)) {
            showLink = true;
        }else if(rangeClass.getRootClass().isSWBInterface()) {
            SemanticObject value = obj.getObjectProperty(prop);
            if(value != null) {
                GenericObject generic = value.createGenericInstance();
                if(generic instanceof Indicator) {
                    rangeClass = Indicator.bsc_Indicator;
                    showLink = true;
                }else if(generic instanceof Risk) {
                    rangeClass = Risk.bsc_Risk;
                    showLink = true;
                }
            }
        }
        if(prop.isObjectProperty()) {
            SemanticObject value = obj.getObjectProperty(prop);
            if(value!=null) {
                //html.append(value.getDisplayName(lang));
                if(showLink) {
                    SWBModel model = (SWBModel)obj.getModel().getModelObject().getGenericInstance();
                    String url = request.getScheme()+"://"+request.getServerName()+":"
                            +request.getServerPort()+SWBPlatform.getContextPath()+"/"
                            +lang+"/"+model.getId()+"/"+rangeClass.getName()
                            +"?suri="+value.getEncodedURI();
                    html.append(" <a href=\"");
                    html.append(url);
                    html.append("\">");
                    //html.append("<span class=\"summary-grid glyphicon glyphicon-eye-open\"></span>\n");
                    //html.append("</a>\n");
                }
                html.append(value.getDisplayName(lang));
                if(showLink) {
                    html.append("</a>");
                }
            }
        }
        return html.toString();
    }
}
