/*
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
 */
package org.semanticwb.process.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Sortable;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;
import org.semanticwb.process.SWBProcess;

/**
 * Clase que encapsula las propiedades y funciones de un proceso.
 * @author Javier Solis
 */
public class Process extends org.semanticwb.process.model.base.ProcessBase 
{
    private static Logger log=SWBUtils.getLogger(Process.class);
    
    //Bloque estático para registrar un observador cuando se modifica la propiedad parentWebPage
    static 
    {
        swp_parentWebPage.registerObserver(new SemanticObserver() 
        {
            @Override
            public void notify(SemanticObject obj, Object prop, String lang, String action)
            {
                //System.out.println("obj:"+obj+" prop:"+prop+" action:"+action);
                if(obj.instanceOf(Process.sclass))
                {
                    Process process=(Process)obj.createGenericInstance();                    
                    process.getProcessWebPage().removeAllVirtualParent();
                    if(action!=null && action.equals("SET"))
                    {
                        if(process.getParentWebPage()!=null)
                        {
                            process.getProcessWebPage().addVirtualParent(process.getParentWebPage());
                        }
                    }
                }
                        
            }
        });
    }
    
    /**
     * Constructor.
     * @param base 
     */
    public Process(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
        getProcessWebPage();  //Crea pagina web de proceso
        
    }
    
    /**
     * Crea una instancia del proceso.
     * @return 
     */
    public ProcessInstance createInstance()
    {
        //System.out.println("createInstance process:"+this);
        ProcessInstance inst=null;
        inst=this.getProcessSite().createProcessInstance();
        inst.setProcessType(this);
        inst.setStatus(Instance.STATUS_INIT);

        return inst;
    }

    /**
     * Regresa las ItemAware y la Classes relacionadas con el proceso (ItemAware Globales)
     * @return
     */
    @Override
    public List<ItemAware> listRelatedItemAware()
    {
        //System.out.println("getRelatedItemAwareClasses:"+this);
        ArrayList<ItemAware> arr=new ArrayList();
        Iterator<GraphicalElement> it=listContaineds();
        while (it.hasNext())
        {
            GraphicalElement graphicalElement = it.next();
            if(graphicalElement instanceof ItemAware)
            {
                ItemAware item=(ItemAware)graphicalElement;

                if(!item.listInputConnectionObjects().hasNext() && !item.listOutputConnectionObjects().hasNext())
                {
                    arr.add(item);
                }
            }
        }
        return arr;
    }

    /**
     * Regresa las ItemAware y la Classes relacionadas con el proceso (ItemAware Globales)
     * @return
     */
    @Override
    public List<ItemAware> listHerarquicalRelatedItemAware()
    {
        //System.out.println("getHerarquicalRelatedItemAwareClasses:"+this);
        return listRelatedItemAware();
    }
    
    /**
     * Obtiene una lista de todos los nodos contenidos en un proceso.
     * @return 
     */
    public Iterator<GraphicalElement> listAllContaineds()
    {
        ArrayList<GraphicalElement> arr=new ArrayList();
        Iterator<GraphicalElement> it=listContaineds();
        while (it.hasNext())
        {
            GraphicalElement gElement = it.next();
            arr.add(gElement);
            if(gElement instanceof SubProcess)
            {
                Iterator<GraphicalElement> it2=((SubProcess)(gElement)).listAllContaineds();
                while (it2.hasNext())
                {
                    GraphicalElement gElement2 = it2.next();
                    arr.add(gElement2);
                }
            }
        }
        return arr.iterator();
    }

    @Override
    public WrapperProcessWebPage getProcessWebPage() 
    {
        WrapperProcessWebPage wp=super.getProcessWebPage();
        if(wp==null)
        {
            wp=WrapperProcessWebPage.ClassMgr.createWrapperProcessWebPage(getId()+"_swp", getProcessSite());
            setProcessWebPage(wp);
            wp.setActive(true);
            //eliminar cache
            //getSemanticObject().removeCache(wp.getURI());
            //wp=super.getProcessWebPage();
        }
        return wp;
    }

    @Override
    public boolean isValid()
    {
        boolean ret=super.isValid();
        if(ret)
        {
            ret=getProcessGroup().isActive() && !getProcessGroup().isDeleted();
        }
        return ret; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    /**
     * Verifica si el usuario puede acceder al proceso.
     * @param user Usuario.
     * @return true si el usuario tiene permisos para ver el proceso, false en otro caso.
     */
    public boolean haveAccess(User user) {
        return (isValid() && user.haveAccess(this));
    }
    
    /**
     * Verifica si el usuario puede instanciar el proceso.
     * @param user Usuario.
     * @return true si el usuario puede instanciar el proceso, false en otro caso.
     */
    public boolean canInstantiate(User user) {
        boolean ret = false;
        boolean hasStart = false;
        Iterator<GraphicalElement> elements = listContaineds();
        while (elements.hasNext()) {
            GraphicalElement ge = elements.next();
            if (ge instanceof StartEvent) {
                hasStart = true;
                ret = user.haveAccess(ge);
                break;
            }
        }
        return hasStart && ret;
    }

    @Override
    public String serialize(String format) {
        String ret = "";
        if ("JSON".equalsIgnoreCase(format)) {
            JSONObject model = getProcessJSON();
            try {
                if (null != model) ret = model.toString(2);
            } catch (JSONException jse) {
                log.error("Ha ocurrido un error al serializar el modelo", jse);
            }
        }
        return ret;
    }
    
    /**
     * Obtiene la representación en formato JSON de un subproceso.
     * @param subprocess SubProceso
     * @param nodes Lista de nodos del subproceso
     */
    public void getSubProcessJSON(org.semanticwb.process.model.Containerable subprocess, JSONArray nodes) {
        JSONObject ele = null;
        JSONObject coele = null;
        try {
            Iterator<GraphicalElement> it_fo = subprocess.listContaineds();
            while (it_fo.hasNext()) {
                GraphicalElement obj = it_fo.next();
                ele = new JSONObject();
                nodes.put(ele);
                ele.put(SWBProcess.JSONProperties.PROP_CLASS, obj.getSemanticObject().getSemanticClass().getClassCodeName());
                ele.put(SWBProcess.JSONProperties.PROP_TITLE, obj.getTitle());

                //if(obj.getDescription()==null) obj.setDescription("");
                ele.put(SWBProcess.JSONProperties.PROP_DESCRIPTION, obj.getDescription());
                ele.put(SWBProcess.JSONProperties.PROP_URI, obj.getURI());
                ele.put(SWBProcess.JSONProperties.PROP_X, obj.getX());
                ele.put(SWBProcess.JSONProperties.PROP_Y, obj.getY());
                ele.put(SWBProcess.JSONProperties.PROP_W, obj.getWidth());
                ele.put(SWBProcess.JSONProperties.PROP_H, obj.getHeight());
                if (obj.getContainer() != null) {
                    ele.put(SWBProcess.JSONProperties.PROP_CONTAINER, obj.getContainer().getURI());
                } else {
                    ele.put(SWBProcess.JSONProperties.PROP_CONTAINER, "");
                }
                if (obj.getParent() != null) {
                    ele.put(SWBProcess.JSONProperties.PROP_PARENT, obj.getParent().getURI());
                } else {
                    ele.put(SWBProcess.JSONProperties.PROP_PARENT, "");
                }

                if (obj.getLabelSize() != 0) {
                    ele.put(SWBProcess.JSONProperties.PROP_labelSize, obj.getLabelSize());
                } else {
                    ele.put(SWBProcess.JSONProperties.PROP_labelSize, 10);
                }

                if (obj instanceof Sortable) {

                    //System.out.println("Es coleccion...");
                    Sortable sorble = (Sortable) obj;
                    ele.put(SWBProcess.JSONProperties.PROP_index, sorble.getIndex());
                }

                if (obj instanceof ActivityConfable) {

                    ActivityConfable tsk = (ActivityConfable) obj;
                    if (tsk.getLoopCharacteristics() != null) {
                        LoopCharacteristics loopC = tsk.getLoopCharacteristics();
                        if (loopC instanceof MultiInstanceLoopCharacteristics) {
                            ele.put(SWBProcess.JSONProperties.PROP_isMultiInstance, true);
                        } else {
                            ele.put(SWBProcess.JSONProperties.PROP_isMultiInstance, false);
                        }

                        if (loopC instanceof StandarLoopCharacteristics) {
                            ele.put(SWBProcess.JSONProperties.PROP_isLoop, true);
                        } else {
                            ele.put(SWBProcess.JSONProperties.PROP_isLoop, false);
                        }
                    }
                    ele.put(SWBProcess.JSONProperties.PROP_isForCompensation, Boolean.toString(tsk.isForCompensation()));
                }

                if (obj instanceof Collectionable) {
                    //System.out.println("Es coleccion subprocess...");
                    Collectionable colble = (Collectionable) obj;
                    if (colble.isCollection()) {
                        ele.put(SWBProcess.JSONProperties.PROP_isCollection, true);
                    } else {
                        ele.put(SWBProcess.JSONProperties.PROP_isCollection, false);
                    }
                    //System.out.println("===>"+colble.isCollection());
                }

                if (obj instanceof Lane) {
                    ele.put("lindex", ((Lane) obj).getLindex());
                }

                Iterator<ConnectionObject> it = obj.listOutputConnectionObjects();
                while (it.hasNext()) {
                    ConnectionObject connectionObject = it.next();
                    coele = new JSONObject();
                    nodes.put(coele);
                    coele.put(SWBProcess.JSONProperties.PROP_CLASS, connectionObject.getSemanticObject().getSemanticClass().getClassCodeName());
                    coele.put(SWBProcess.JSONProperties.PROP_URI, connectionObject.getURI());
                    coele.put(SWBProcess.JSONProperties.PROP_START, connectionObject.getSource().getURI());
                    coele.put(SWBProcess.JSONProperties.PROP_END, connectionObject.getTarget().getURI());
                    coele.put(SWBProcess.JSONProperties.PROP_TITLE, connectionObject.getTitle());
                    coele.put(SWBProcess.JSONProperties.PROP_CONNPOINTS, connectionObject.getConnectionPoints());
                    //coele.put(PROP_DESCRIPTION, connectionObject.getDescription());
                }
                if (obj instanceof Containerable) {
                    getSubProcessJSON((Containerable) obj, nodes);
                }
            }
        } catch (Exception e) {
            log.error("Error al general el JSON del Modelo.....getSubProcessJSON(" + subprocess.getId() + ", uri:" + subprocess.getURI() + ")", e);
        }
    }
    
    /**
     * Obtiene la representación en formato JSON del proceso.
     * @return Objeto con la representación del proceso.
     */
    private JSONObject getProcessJSON() {
        JSONObject json_ret = null;
        JSONArray nodes = null;
        JSONObject ele = null;
        JSONObject coele = null;

        try {
            json_ret = new JSONObject();
            json_ret.put(SWBProcess.JSONProperties.PROP_URI, getURI());
            json_ret.put(SWBProcess.JSONProperties.PROP_TITLE, getTitle());
            json_ret.put(SWBProcess.JSONProperties.PROP_DESCRIPTION, getDescription());
            json_ret.put(SWBProcess.JSONProperties.PROP_CLASS, getSemanticObject().getSemanticClass().getClassCodeName());
            nodes = new JSONArray();
            json_ret.putOpt("nodes", nodes);

            Iterator<GraphicalElement> it_fo = listContaineds();
            while (it_fo.hasNext()) {
                GraphicalElement obj = it_fo.next();
                ele = new JSONObject();
                nodes.put(ele);
                ele.put(SWBProcess.JSONProperties.PROP_CLASS, obj.getSemanticObject().getSemanticClass().getClassCodeName());
                ele.put(SWBProcess.JSONProperties.PROP_TITLE, obj.getTitle());

                //if(obj.getDescription()==null) obj.setDescription("");
                ele.put(SWBProcess.JSONProperties.PROP_DESCRIPTION, obj.getDescription());
                ele.put(SWBProcess.JSONProperties.PROP_URI, obj.getURI());
                ele.put(SWBProcess.JSONProperties.PROP_X, obj.getX());
                ele.put(SWBProcess.JSONProperties.PROP_Y, obj.getY());
                ele.put(SWBProcess.JSONProperties.PROP_W, obj.getWidth());
                ele.put(SWBProcess.JSONProperties.PROP_H, obj.getHeight());
                if (obj.getContainer() != null) {
                    ele.put(SWBProcess.JSONProperties.PROP_CONTAINER, obj.getContainer().getURI());
                } else {
                    ele.put(SWBProcess.JSONProperties.PROP_CONTAINER, "");
                }
                if (obj.getParent() != null) {
                    ele.put(SWBProcess.JSONProperties.PROP_PARENT, obj.getParent().getURI());
                } else {
                    ele.put(SWBProcess.JSONProperties.PROP_PARENT, "");
                }

                if (obj.getLabelSize() != 0) {
                    ele.put(SWBProcess.JSONProperties.PROP_labelSize, obj.getLabelSize());
                } else {
                    ele.put(SWBProcess.JSONProperties.PROP_labelSize, 10);
                }

                if (obj instanceof Sortable) {

                    //System.out.println("Es coleccion...");
                    Sortable sorble = (Sortable) obj;
                    ele.put(SWBProcess.JSONProperties.PROP_index, sorble.getIndex());
                }

                if (obj instanceof IntermediateCatchEvent) {
                    IntermediateCatchEvent ice = (IntermediateCatchEvent) obj;
                    ele.put(SWBProcess.JSONProperties.PROP_isInterrupting, ice.isInterruptor());
                }

                if (obj instanceof ActivityConfable) {
                    ActivityConfable tsk = (ActivityConfable) obj;
                    if (tsk.getLoopCharacteristics() != null) {
                        LoopCharacteristics loopC = tsk.getLoopCharacteristics();
                        if (loopC instanceof MultiInstanceLoopCharacteristics) {
                            ele.put(SWBProcess.JSONProperties.PROP_isMultiInstance, true);
                        } else {
                            ele.put(SWBProcess.JSONProperties.PROP_isMultiInstance, false);
                        }

                        if (loopC instanceof StandarLoopCharacteristics) {
                            ele.put(SWBProcess.JSONProperties.PROP_isLoop, true);
                        } else {
                            ele.put(SWBProcess.JSONProperties.PROP_isLoop, false);
                        }
                    }
                    ele.put(SWBProcess.JSONProperties.PROP_isForCompensation, Boolean.toString(tsk.isForCompensation()));
                }

                if (obj instanceof Collectionable) {

                    //System.out.println("Es coleccion...");
                    Collectionable colble = (Collectionable) obj;
                    if (colble.isCollection()) {
                        ele.put(SWBProcess.JSONProperties.PROP_isCollection, true);
                    } else {
                        ele.put(SWBProcess.JSONProperties.PROP_isCollection, false);
                    }
                    //System.out.println("===>"+colble.isCollection());
                }

                if (obj instanceof Lane) {
                    //System.out.println("put index:"+obj+" "+((Lane)obj).getLindex());
                    ele.put("lindex", ((Lane) obj).getLindex());
                }
                Iterator<ConnectionObject> it = obj.listOutputConnectionObjects();
                while (it.hasNext()) {
                    ConnectionObject connectionObject = it.next();
                    coele = new JSONObject();
                    nodes.put(coele);
                    coele.put(SWBProcess.JSONProperties.PROP_CLASS, connectionObject.getSemanticObject().getSemanticClass().getClassCodeName());
                    coele.put(SWBProcess.JSONProperties.PROP_URI, connectionObject.getURI());
                    coele.put(SWBProcess.JSONProperties.PROP_START, connectionObject.getSource().getURI());
                    coele.put(SWBProcess.JSONProperties.PROP_END, connectionObject.getTarget().getURI());
                    coele.put(SWBProcess.JSONProperties.PROP_TITLE, connectionObject.getTitle());
                    coele.put(SWBProcess.JSONProperties.PROP_CONNPOINTS, connectionObject.getConnectionPoints());
                    //coele.put(PROP_DESCRIPTION, connectionObject.getDescription());
                }
                if (obj instanceof Containerable) {
                    getSubProcessJSON((Containerable) obj, nodes);
                }
            }

        } catch (Exception e) {
            json_ret = null;
            log.error("Error al general el JSON del Modelo.....getModelJSON(" + getTitle() + ", uri:" + getURI() + ")", e);
        }
        return json_ret;
    }
}
