package org.semanticwb.process.model;

import java.util.Date;
import java.util.Iterator;
import org.semanticwb.model.User;


public class ScalationEndEvent extends org.semanticwb.process.model.base.ScalationEndEventBase 
{
    public ScalationEndEvent(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void execute(FlowNodeInstance instance, User user)
    {
        instance.close(user);
        Instance parent=instance.getParentInstance();
        if(parent instanceof SubProcessInstance)
        {
            //list atached events
            Iterator<GraphicalElement> it=((SubProcessInstance)parent).getFlowNodeType().listChilds();
            while (it.hasNext())
            {
                GraphicalElement graphicalElement = it.next();
                if(graphicalElement instanceof ScalationIntermediateCatchEvent)
                {
                    ScalationIntermediateCatchEvent event=(ScalationIntermediateCatchEvent)graphicalElement;
                    if(event instanceof ActionCodeable && instance.getFlowNodeType() instanceof ActionCodeable)
                    {                    
                        String c1=((ActionCodeable)event).getActionCode();
                        String c2=((ActionCodeable)instance.getFlowNodeType()).getActionCode();
                        if((c1!=null && c1.equals(c2)) || c1==null && c2==null)
                        {
                            FlowNodeInstance source=(FlowNodeInstance)parent;
                            source.setStatus(Instance.STATUS_CLOSED);
                            source.setAction(Instance.ACTION_EVENT);
                            source.setEnded(new Date());
                            source.setEndedby(user);
                            source.abortDependencies(user);

                            FlowNodeInstance fn=((FlowNodeInstance)parent).getRelatedFlowNodeInstance(event);
                            fn.setSourceInstance(instance);
                            event.notifyEvent(fn, instance);
                        }
                    }
                }
            }
        }else
        {
            instance.getParentInstance().close(user);
        }
    }
}
