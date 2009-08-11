/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 
/*
 * RDFElements.java
 *
 * Created on 9 de julio de 2008, 11:49 AM
 */

package org.semanticwb.xforms.drop;


import java.util.*;
/**
 *
 * @author  jorge.jimenez
 */
public class RDFElement {
    
    protected String value=null;
    protected int size=-1;
    protected int maxlength=-1;
    protected String accesskey=null;
    protected String align=null;
    protected boolean isdisabled=false;
    protected boolean isreadonly=false;
    protected boolean isautocomplete=true;
    protected int width=-1;
    protected int height=-1;
    protected String alert=null;
    protected String hint=null;
    
    protected String type;
    protected String stype;
    protected String id;
    protected String label;
    protected boolean required=false;
    protected String constraint=null;
    protected String help=null;
    
    //TextArea
    private boolean incremental=false;
    private int cols=-1;
    private int rows=-1;
    private String wrap=null;
    private String mediatype=null;
    
    //group
    private String appearance=null;
    
    //upload
    private String filename=null;
    
    //case-swith
    private String actioncase=null;
    private boolean selected=false;
    private String cssclass=null;
    
    //Range
    protected int start=0;
    protected int end=0;
    protected int step=0;
    
    //StaticText
    protected boolean isInhead=false;
    
    
    //Para agregar elementos dentro de un elemento-contenedor (ej. group)
    private ArrayList elements=new ArrayList();
    
    //sets
    
    public void setValue(String value) {
        this.value=value;
    }
    
    public void setType(String type) {
        this.type=type;
    }
    
    public void setSType(String stype) {
        this.stype=stype;
    }
    
    public void setId(String id) {
        this.id=id;
    }
    
    public void setLabel(String label) {
        this.label=label;
    }
    
    public void setSize(int size) {
        this.size=size;
    }
    
    public void setMaxLength(int maxlength) {
        this.maxlength=maxlength;
    }
    
    public void setAlert(String alert) {
        this.alert=alert;
    }
    
    public void setHint(String hint) {
        this.hint=hint;
    }
    
    public void setRequired(boolean required) {
        this.required=required;
    }
    
    public void setConstraint(String constraint) {
        this.constraint=constraint;
    }
    
    public void setHelp(String help) {
        this.help=help;
    }
    
    public void setIncremental(boolean incremental) {
        this.incremental=incremental;
    }
    
    public void setCols(int cols) {
        this.cols=cols;
    }
    
    public void setRows(int rows) {
        this.rows=rows;
    }
    
    public void setWrap(String wrap) {
        this.wrap=wrap;
    }
    
    public void setMediatype(String mediatype) {
        this.mediatype=mediatype;
    }
    
    public void setAppearance(String appearance) {
        this.appearance=appearance;
    }
    
    public void addElement(Object element) {
        elements.add(element);
    }
    
    public void setFileName(String filename) {
        this.filename=filename;
    }
    
    public void setActionCase(String actioncase) {
        this.actioncase=actioncase;
    }
    
    public void setSelected(boolean selected) {
        this.selected=selected;
    }
    
    public void setCssClass(String cssclass) {
        this.cssclass=cssclass;
    }
    
    public void setStart(int start){
        this.start=start;
    }
    
    public void setEnd(int end){
        this.end=end;
    }
    
    public void setStep(int step){
        this.step=step;
    }
    
    public void setisInhead(boolean isInhead){
        this.isInhead=isInhead;
    }
    
    //gets
    
    public String getType() {
        return type;
    }
    
    public String getSType() {
        return stype;
    }
    
    public String getId() {
        return id;
    }
    
    public String getLabel() {
        return label;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getMaxLength() {
        return maxlength;
    }
    
    public String getAlert() {
        return alert;
    }
    
    public String getHint() {
        return hint;
    }
    
    public boolean isRequired() {
        return required;
    }
    
    public String getConstraint() {
        return constraint;
    }
    
    public String getHelp() {
        return help;
    }
    
    public boolean isIncremental() {
        return incremental;
    }
    
    public int getCols() {
        return cols;
    }
    
    public int getRows() {
        return rows;
    }
    
    public String getWrap() {
        return wrap;
    }
    
    public String getMediatype() {
        return mediatype;
    }
    
    public String getAppearance() {
        return appearance;
    }
    
    public ArrayList getElements() {
        return elements;
    }
    
    public String getFileName() {
        return filename;
    }
    
    public String getValue() {
        return value;
    }
    
    public String getActionCase() {
        return actioncase;
    }
    
    public boolean isSelected() {
        return selected;
    }
    
    public String getCssClass() {
        return cssclass;
    }
    
    public int getStart(){
        return start;
    }
    
    public int getEnd(){
        return end;
    }
    
    public int getStep(){
        return step;
    }
    
    public boolean isInhead(){
        return isInhead;
    }
    
}
