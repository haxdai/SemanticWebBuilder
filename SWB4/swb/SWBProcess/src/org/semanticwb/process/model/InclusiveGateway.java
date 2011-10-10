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
import org.semanticwb.model.User;


public class InclusiveGateway extends org.semanticwb.process.model.base.InclusiveGatewayBase 
{
    public InclusiveGateway(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void execute(FlowNodeInstance instance, User user)
    {
        //SI LA COMPUERTA ES DIVERGENTE, HABILITAR LOS FLUJOS QUE CUMPLEN SU CONDICIÓN
          //Obtener todos los flujos de salida
          //Para cada flujo de salida
            //Evaluar la condición del flujo
              //Si la condición se cumple, habilitar ese flujo
          //Si ninguna condición se cumple, seguir por el flujo de defecto

        //SI LA COMPUERTA ES CONVERGENTE, ESPERAR A QUE TERMINEN LOS FLUJOS DE ENTRADA
          //Obtener el número de flujos de entrada (fi)
          //Terminados = 0
          //Mientras terminados < fi
              //Obtener todos los flujos de entrada
                //Para cada flujo obtener el source
                  //Si la tarea source se ha completado
                    //Incrementar el contador de terminados
          //Continuar con el flujo
        //SI LA COMPUERTA ES MIXTA, EVALUAR LA CONDICION

        //SI LA COMPUERTA ES CONVERGENTE, ESPERAR A QUE SE COMPLETEN LOS FLUJOS HABILITADOS
        boolean ret=true;
        Iterator<ConnectionObject> it=listInputConnectionObjects();
        while (it.hasNext())
        {
            ConnectionObject connectionObject = it.next();
            GraphicalElement obj=connectionObject.getSource();
            if(obj instanceof FlowNode)
            {
                FlowNodeInstance inst=instance.getRelatedFlowNodeInstance((FlowNode)obj);
                if(inst==null)
                {
                    //ret=false;
                }else if(inst.getStatus()<Instance.STATUS_CLOSED)
                {
                    ret=false;
                    break;
                }
            }
        }
        if(ret)
        {
            instance.close(user,instance.getSourceInstance().getAction());
        }
    }

}
