package org.semanticwb.process.model;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;

public class ProcessObserver extends org.semanticwb.process.model.base.ProcessObserverBase implements SemanticObserver
{
    private static Logger log=SWBUtils.getLogger(ProcessObserver.class);

    /** The timer. */
    private transient Timer timer;

    /** The delays. */
    private transient int delays = 60;

    /** The t. */
    private transient TimerTask t=null;

    /**
     * Inits the.
     */
    public void init()
    {
        t=new TimerTask(){
            public void run()
            {
                try {
                    checkTimer();
                } catch (Exception e){
                    log.error(e);
                }
            }
        };
        timer = new Timer("ProcessObserver("+delays+"s)", true);
        timer.scheduleAtFixedRate(t, delays*1000, delays*1000);
        log.event("Initializing ProcessObserver("+delays+"s)...");

        SWBPlatform.getSemanticMgr().registerObserver(this);
    }

    public ProcessObserver(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
        init();
    }

    public void sendSignal(FlowNodeInstance instance)
    {
        //System.out.println("sendSignal:"+((Event)instance.getFlowNodeType()).getActionCode());
        Iterator<FlowNodeInstance> it=listSignalObserverInstances();
        while (it.hasNext())
        {
            FlowNodeInstance flowNodeInstance = it.next();
            if(flowNodeInstance.getFlowNodeType() instanceof ActionCodeable && instance.getFlowNodeType() instanceof ActionCodeable)
            {
                String c1=((ActionCodeable)flowNodeInstance.getFlowNodeType()).getActionCode();
                String c2=((ActionCodeable)instance.getFlowNodeType()).getActionCode();
                //System.out.println(flowNodeInstance+" "+c1+"=="+c2);
                if((c1!=null && c1.equals(c2)) || c1==null && c2==null)
                {
                    try
                    {
                        flowNodeInstance.notifyEvent(instance);
                    }catch(Exception e){log.error(e);}
                }
            }
        }

        Iterator<StartEvent> nit=listSignalObserverNodes();
        while (nit.hasNext())
        {
            StartEvent startEvent = nit.next();
            //System.out.println(startEvent);
            Containerable cont=startEvent.getContainer();
            if(cont!=null && cont instanceof Process && ((Process)cont).isActive())
            {
                if(startEvent instanceof ActionCodeable && instance.getFlowNodeType() instanceof ActionCodeable)
                {
                    String c1=((ActionCodeable)startEvent).getActionCode();
                    String c2=((ActionCodeable)instance.getFlowNodeType()).getActionCode();
                    //System.out.println(startEvent+" "+c1+"=="+c2);
                    if((c1!=null && c1.equals(c2)) || c1==null && c2==null)
                    {
                        try
                        {
                            //System.out.println("ok...");
                            ProcessInstance inst=((Process)cont).createInstance();
                            inst.start(null,startEvent);
                        }catch(Exception e){log.error(e);}
                    }
                }
            }
        }

    }

    public void sendSignal(FlowNode node)
    {

    }

    private void checkTimer()
    {
        //System.out.println("checkTimer...");
        //Check timer
        {
            Iterator<FlowNodeInstance> it=listTimeObserverInstances();
            while (it.hasNext())
            {
                FlowNodeInstance flowNodeInstance = it.next();
                ProcessPeriodRefable pr=((ProcessPeriodRefable)flowNodeInstance.getFlowNodeType());
                Iterator<ProcessPeriodRef> it2=pr.listProcessPeriodRefs();
                while (it2.hasNext()) {
                    ProcessPeriodRef ppr = it2.next();
                    if(ppr.isActive())
                    {
                        //System.out.println("checking:"+ppr.getProcessPeriod());
                        if(ppr.getProcessPeriod().isOnSchedule())
                        {
                            try
                            {
                                //System.out.println("ok...");
                                flowNodeInstance.notifyEvent(null);
                            }catch(Exception e){log.error(e);}
                        }
                    }
                }
            }

            Iterator<StartEvent> sit=listTimeObserverNodes();
            while (sit.hasNext())
            {
                StartEvent startEvent = sit.next();
                Containerable cont=startEvent.getContainer();
                if(cont!=null && cont instanceof Process && ((Process)cont).isActive())
                {
                    ProcessPeriodRefable pr=((ProcessPeriodRefable)startEvent);
                    Iterator<ProcessPeriodRef> it2=pr.listProcessPeriodRefs();
                    while (it2.hasNext()) {
                        ProcessPeriodRef ppr = it2.next();
                        if(ppr.isActive())
                        {
                            //System.out.println("checking:"+ppr.getProcessPeriod());
                            if(ppr.getProcessPeriod().isOnSchedule())
                            {
                                try
                                {
                                    //System.out.println("ok...");
                                    ProcessInstance inst=((Process)cont).createInstance();
                                    inst.start(null,startEvent);
                                }catch(Exception e){log.error(e);}
                            }
                        }
                    }
                }
            }
        }

        //Check rules
        {
            Iterator<FlowNodeInstance> it=listRuleObserverInstances();
            while (it.hasNext())
            {
                FlowNodeInstance flowNodeInstance = it.next();
                ProcessRuleRefable pr=((ProcessRuleRefable)flowNodeInstance.getFlowNodeType());
                Iterator<ProcessRuleRef> it2=pr.listProcessRuleRefs();
                while (it2.hasNext()) {
                    ProcessRuleRef ppr = it2.next();
                    if(ppr.isActive())
                    {
                        //System.out.println("checking:"+ppr.getProcessRule());
                        if(ppr.getProcessRule().evaluate(flowNodeInstance, null))
                        {
                            try
                            {
                                //System.out.println("ok...");
                                flowNodeInstance.notifyEvent(null);
                            }catch(Exception e){log.error(e);}
                        }
                    }
                }
            }

            Iterator<StartEvent> sit=listRuleObserverNodes();
            while (sit.hasNext())
            {
                StartEvent startEvent = sit.next();
                Containerable cont=startEvent.getContainer();
                if(cont!=null && cont instanceof Process && ((Process)cont).isActive())
                {
                    ProcessRuleRefable pr=((ProcessRuleRefable)startEvent);
                    Iterator<ProcessRuleRef> it2=pr.listProcessRuleRefs();
                    while (it2.hasNext()) {
                        ProcessRuleRef ppr = it2.next();
                        if(ppr.isActive())
                        {
                            //System.out.println("checking:"+ppr.getProcessRule());
                            if(ppr.getProcessRule().evaluate(null, null))
                            {
                                try
                                {
                                    //System.out.println("ok...");
                                    ProcessInstance inst=((Process)cont).createInstance();
                                    inst.start(null,startEvent);
                                }catch(Exception e){log.error(e);}
                            }
                        }
                    }
                }
            }
        }

    }

    public void notify(SemanticObject obj, Object prop, String lang, String action)
    {
        //System.out.println(obj+" "+prop+" "+action+" "+SemanticObject.ACT_CREATE);
        if(SemanticObject.ACT_CREATE.equals(action))
        {
            if(obj.instanceOf(TimerStartEvent.sclass))
            {
                addTimeObserverNode((StartEvent)obj.createGenericInstance());
            }else if(obj.instanceOf(SignalStartEvent.sclass))
            {
                addSignalObserverNode((StartEvent)obj.createGenericInstance());
            }else if(obj.instanceOf(RuleStartEvent.sclass))
            {
                addRuleObserverNode((StartEvent)obj.createGenericInstance());
            }
        }
    }
}
