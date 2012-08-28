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

import bsh.Interpreter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.codegen.CodeGenerator;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.script.util.MemoryClassLoader;

/**
 *
 * @author jei
 */
public class SWBPClassMgr
{
    private static Logger log=SWBUtils.getLogger(SWBPClassMgr.class);
    private static MemoryClassLoader mcls=new MemoryClassLoader(SWBPClassMgr.class.getClassLoader());

    public static Class getClassDefinition(SemanticClass scls)
    {
        String pk=scls.getCodePackage();
        String className=scls.getClassCodeName();
        if(pk!=null)
        {
            className = pk + "." + className;
        }
        //System.out.println("className:"+className);
        Class clazz=null;
        try
        {
            clazz=mcls.loadClass(className);
        }catch(Exception noe){}
//        if(clazz==null)
//        {
//            HashMap<String,String> classes=new HashMap<String, String>();
//            try
//            {
//                CodeGenerator cg=new CodeGenerator();
//                cg.setGenerateVirtualClasses(true);
//                String code=cg.createClassBase(scls,false);
//                classes.put(className, code);
//            }catch(Exception e)
//            {
//                log.error("Error compiling:" +className,e);
//            }
//            mcls.addAll(classes);
//
//            try
//            {
//                clazz=mcls.loadClass(className);
//            }catch(Exception noe){}
//        }
        return clazz;
    }

    public static void reset()
    {
        mcls=new MemoryClassLoader(SWBPClassMgr.class.getClassLoader());
    }
    
    public static Interpreter getInterpreter(Instance instance, User user)
    {
        Interpreter i = new Interpreter();  // Construct an interpreter
        i.setClassLoader(mcls);
        try
        {
            i.eval("import org.semanticwb.process.model.*");        
            i.set("user", user);
            if(instance!=null)
            {
                i.set("instance", instance);            
                i.set("accepted", Instance.ACTION_ACCEPT.equals(instance.getAction()));
                i.set("rejected", Instance.ACTION_REJECT.equals(instance.getAction()));
                i.set("canceled", Instance.ACTION_CANCEL.equals(instance.getAction()));
            }
        }catch(Exception e)
        {
            log.error(e);
        }
        addProcessInstanceObjectsReference(instance, i);
        return i;
    }
    
    public static Interpreter getInterpreter()
    {
        Interpreter i = new Interpreter();  // Construct an interpreter
        i.setClassLoader(mcls);
        i.setStrictJava(true);
        try
        {
            i.eval("import org.semanticwb.process.model.*");        
        }catch(Exception e)
        {
            log.error(e);
        }
        return i;
    }    

    public static void addProcessInstanceObjectsReference(Instance instance, Interpreter i)
    {
        List<ItemAwareReference> list=instance.listHeraquicalItemAwareReference();
        for(ItemAwareReference item : list)
        {
            String varname=item.getItemAware().getName();
            SemanticObject object=item.getProcessObject().getSemanticObject();
            try
            {
                //System.out.println("Cargando clase "+className+" ...");
                Class clazz=getClassDefinition(object.getSemanticClass());
                //System.out.println("Obteniendo constructor...");
                Constructor c=clazz.getConstructor(SemanticObject.class);
                //System.out.println("Instanciando objeto...");
                Object instanceObject=c.newInstance(object);
                //System.out.println("Agregando variable "+varname+"="+instanceObject+" de tipo "+instanceObject.getClass());
                i.set(varname, instanceObject);
                //System.out.println("Variable "+ varname +" agregada");
            }
            catch(Exception cnfe)
            {
                log.error("No se agrego variable "+varname+" a script relacionada con el objeto "+object.getURI()+" en la instancia de proceso "+instance.getURI(),cnfe);
            }
        }
    }

    public static ClassLoader getClassLoader()
    {
        return mcls;
    }

}
