/**
* SemanticWebBuilder Process (SWB Process) es una plataforma para la gestión de procesos de negocio mediante el uso de 
* tecnología semántica, que permite el modelado, configuración, ejecución y monitoreo de los procesos de negocio
* de una organización, así como el desarrollo de componentes y aplicaciones orientadas a la gestión de procesos.
* 
* Mediante el uso de tecnología semántica, SemanticWebBuilder Process puede generar contextos de información
* alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes fuentes asociadas a
* un proceso de negocio, donde a la información se le asigna un significado, de forma que pueda ser interpretada
* y procesada por personas y/o sistemas. SemanticWebBuilder Process es una creación original del Fondo de 
* Información y Documentación para la Industria INFOTEC.
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder Process a través de su licenciamiento abierto 
* al público (‘open source’), en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC 
* lo ha diseñado y puesto a su disposición; aprender de él; distribuirlo a terceros; acceder a su código fuente,
* modificarlo y combinarlo (o enlazarlo) con otro software. Todo lo anterior de conformidad con los términos y 
* condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización de SemanticWebBuilder Process. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder Process, de ninguna especie y naturaleza, ni implícita ni 
* explícita, siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los 
* riesgos que puedan derivar de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder Process, INFOTEC pone a su disposición la
* siguiente dirección electrónica: 
*  http://www.semanticwebbuilder.org.mx
**/

package org.semanticwb.process.model;

import java.util.Iterator;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;


public class MessageIntermediateCatchEvent extends org.semanticwb.process.model.base.MessageIntermediateCatchEventBase 
{
    public MessageIntermediateCatchEvent(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    @Override
    public void execute(FlowNodeInstance instance, User user)
    {
        ProcessObserver obs=instance.getProcessSite().getProcessObserver();
        if(!obs.hasMessageObserverInstance(instance))
        {
            obs.addMessageObserverInstance(instance);
        }
    }

    @Override
    public void close(FlowNodeInstance instance, User user)
    {
        super.close(instance, user);
        ProcessObserver obs=instance.getProcessSite().getProcessObserver();
        obs.removeMessageObserverInstance(instance);
    }

    @Override
    public void notifyEvent(FlowNodeInstance instance, FlowNodeInstance from)
    {
        //System.out.println("MessageIntermediateCatchEvent-notifyEvent:"+instance+" "+from);
        
        Iterator<ItemAwareMapping> it=listItemAwareMappings();
        while (it.hasNext())
        {
            ItemAwareMapping itemAwareMapping = it.next();
            ItemAware loc=itemAwareMapping.getLocalItemAware();
            ItemAware rem=itemAwareMapping.getRemoteItemAware();
            
            //System.out.println("loc:"+loc+" rem:"+rem);
            
            ItemAwareReference itemAwareReference=getItemAwareReference(instance, loc);
            //System.out.println("itemAwareReference:"+itemAwareReference);
            
            Iterator<ItemAwareReference> it3=from.listHeraquicalItemAwareReference().iterator();
            while (it3.hasNext())
            {
                ItemAwareReference remitem = it3.next();
                //System.out.println("remitem:"+remitem);
                if(remitem.getItemAware().equals(rem))
                {
                    if(itemAwareReference==null)
                    {
                        //System.out.println("create");
                        
                        itemAwareReference=ItemAwareReference.ClassMgr.createItemAwareReference((SWBModel)remitem.getSemanticObject().getModel().getModelObject().createGenericInstance());
                        itemAwareReference.setItemAware(loc);   
                        itemAwareReference.setItemAwareTemporal(remitem.isItemAwareTemporal());
                        instance.addItemAwareReference(itemAwareReference);        
                    }
                    itemAwareReference.setProcessObject(remitem.getProcessObject());
                    remitem.setProcessObjectReused(true);
                }
            }
        }    
        
        super.notifyEvent(instance, from);
    }
    
    public ItemAwareReference getItemAwareReference(FlowNodeInstance instance, ItemAware item)
    {
        Iterator<ItemAwareReference> it=instance.listHeraquicalItemAwareReference().iterator();
        while (it.hasNext())
        {
            ItemAwareReference itemAwareReference = it.next();
            if(itemAwareReference.getItemAware().equals(item))
            {
                return itemAwareReference;
            }
        }
        return null;
    }
    
    
    
}
