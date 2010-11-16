package org.semanticwb.process.model;

import bsh.Interpreter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.codegen.CodeGenerator;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.script.util.MemoryClassLoader;

public class ScriptTask extends org.semanticwb.process.model.base.ScriptTaskBase 
{
    private static HashMap<String, MemoryClassLoader> loaders=new HashMap<String, MemoryClassLoader>();
    public static Logger log=SWBUtils.getLogger(ProcessRule.class);
    
    public ScriptTask(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }  
    
    private String addSemanticClass(SemanticClass clazz) throws Exception
    {
        CodeGenerator cg=new CodeGenerator();
        return cg.createClassBase(clazz,false);
        

    }
    private void addSemanticObject(Interpreter i,SemanticObject object,MemoryClassLoader mcls,FlowNodeInstance instance) throws Exception
    {           
        String varname=object.getSemanticClass().getUpperClassName().toLowerCase();        
        String className=object.getSemanticClass().getUpperClassName();
        log.debug("Para el objeto "+object.getURI()+" de la instancia de proceso "+ instance.getURI() +" se econtró la clase "+className);
        try
        {
            System.out.println("Cargando clase "+className+" ...");
            Class clazz=mcls.loadClass(className);
            System.out.println("Obteniendo constructor...");
            Constructor c=clazz.getConstructor(SemanticObject.class);
            System.out.println("Instanciando objeto...");
            Object instanceObject=c.newInstance(object);
            System.out.println("Agregando variable "+varname+"="+instanceObject+" de tipo "+instanceObject.getClass());
            i.set(varname, instanceObject);
            System.out.println("Variable "+ varname +" agregada");
        }
        catch(ClassNotFoundException cnfe)
        {
            log.error("No se agrego variable "+varname+" a script relacionada con el objeto "+object.getURI()+" en la instancia de proceso "+instance.getURI());
            log.error(cnfe);
        }
    }
    
    private MemoryClassLoader loadClasses(FlowNodeInstance instance,ClassLoader parent) throws Exception
    {
        MemoryClassLoader mcls=new MemoryClassLoader(parent);
        HashMap<String,String> classes=new HashMap<String, String>();
        List<ProcessObject> processObjects=instance.getProcessInstance().listHeraquicalProcessObjects();
        for(ProcessObject po : processObjects)
        {
            String code=addSemanticClass(po.getSemanticObject().getSemanticClass());
            log.debug("Agregando clase "+po.getSemanticObject().getSemanticClass().getUpperClassName());
            log.debug(code);
            classes.put(po.getSemanticObject().getSemanticClass().getUpperClassName(), code);
        }
        if(!classes.isEmpty())
        {
            log.debug("Compilando classes...");
            mcls.addAll(classes);
            log.debug("Classes compiladas");
        }
        return mcls;
    }
    @Override
    public void execute(FlowNodeInstance instance, User user)
    {
        super.execute(instance, user);
        String code=getScriptCode();

        try
        {
            long ini=System.currentTimeMillis();
            Interpreter i = new Interpreter();  // Construct an interpreter
            MemoryClassLoader mcls=null;

//            if(loaders.containsKey(instance.getURI()))
//            {
//                mcls=loaders.get(instance.getURI());
//            }
//            else
//            {
                mcls=loadClasses(instance,ProcessObject.class.getClassLoader());
//                loaders.put(instance.getURI(), mcls);
//            }
            
            i.setClassLoader(mcls);
            i.set("instance", instance);            
            i.set("user", user);
            if(instance!=null)
            {
                i.set("accepted", Instance.ACTION_ACCEPT.equals(instance.getAction()));
                i.set("rejected", Instance.ACTION_REJECT.equals(instance.getAction()));
                i.set("canceled", Instance.ACTION_CANCEL.equals(instance.getAction()));
            }
            i.eval("import org.semanticwb.process.model.*");
            
            List<ProcessObject> processObjects=instance.getProcessInstance().listHeraquicalProcessObjects();
            for(ProcessObject po : processObjects)
            {
                addSemanticObject(i,po.getSemanticObject(),mcls,instance);
            }

            Object ret=i.eval(code);
            System.out.println("ret:"+ret);
            System.out.println("time:"+ (System.currentTimeMillis()-ini ));

        }catch(Exception e)
        {
            log.error(e);

            Iterator<GraphicalElement> it=listChilds();
            while (it.hasNext())
            {
                GraphicalElement graphicalElement = it.next();
                if(graphicalElement instanceof ErrorIntermediateCatchEvent)
                {
                    ErrorIntermediateCatchEvent event=(ErrorIntermediateCatchEvent)graphicalElement;
                    //TODO:Validar excepciones
                    //String c1=event.getActionCode();
                    //String c2=((Event)instance.getFlowNodeType()).getActionCode();
                    //if((c1!=null && c1.equals(c2)) || c1==null && c2==null)
                    {
                        FlowNodeInstance source=(FlowNodeInstance)instance;
                        source.close(user, Instance.STATUS_ABORTED, Instance.ACTION_EVENT, false);

                        FlowNodeInstance fn=((FlowNodeInstance)instance).getRelatedFlowNodeInstance(event);
                        fn.setSourceInstance(instance);
                        event.notifyEvent(fn, instance);
                        return;
                    }
                }
            }

        }
        instance.close(user);

    }


}
