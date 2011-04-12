package org.semanticwb.process.model;

import java.util.Iterator;
import org.semanticwb.model.User;


public class FlowNode extends org.semanticwb.process.model.base.FlowNodeBase 
{
    public FlowNode(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /**
     * Crea una instancia del objeto de flujo
     * @param fobj
     * @param pinst
     * @return
     */
    public FlowNodeInstance createInstance(ContainerInstanceable pinst)
    {
        FlowNodeInstance inst=null;
        if(this instanceof SubProcess)
        {
            inst=pinst.getProcessSite().createSubProcessInstance();
        }else if(this instanceof CallProcess)
        {
            inst=pinst.getProcessSite().createSubProcessInstance();
        }else
        {
            inst=pinst.getProcessSite().createFlowNodeInstance();
        }
        inst.setFlowNodeType(this);
        inst.setStatus(Instance.STATUS_INIT);
        inst.setContainerInstance(pinst);
        return inst;
    }

    public void execute(FlowNodeInstance instance, User user)
    {
        //Implementar en subclases
    }

    public void close(FlowNodeInstance instance, User user)
    {
        //Implementar en subclases
    }

    /**
     * Continua el flujo al siguiente FlowNode
     * @param user
     */
    public void nextObject(FlowNodeInstance instance, User user)
    {
        //System.out.println("nextObject:"+getId()+" "+getFlowNodeType().getClass().getName()+" "+getFlowNodeType().getTitle());
        DefaultFlow def=null;
        boolean execute=false;
        Iterator<ConnectionObject> it=listOutputConnectionObjects();
        while (it.hasNext())
        {
            ConnectionObject connectionObject = it.next();
            if(!(connectionObject instanceof DefaultFlow))
            {
                if(connectionObject.evaluate(instance, user))
                {
                    connectionObject.execute(instance, user);
                    execute=true;
                }
            }else
            {
                def=(DefaultFlow)connectionObject;
            }
        }
        if(def!=null && !execute)def.execute(instance, user);
    }

    /**
     * Regresa proceso padre asociado
     * @return
     */
    public Process getProcess()
    {
        Process ret=null;
        Containerable cont=getContainer();
        if(cont!=null)
        {
            if(cont instanceof  Process)
            {
                ret = (Process) cont;
            }else
            {
                ret=((FlowNode)cont).getProcess();
            }
        }
        return ret;
    }
}
