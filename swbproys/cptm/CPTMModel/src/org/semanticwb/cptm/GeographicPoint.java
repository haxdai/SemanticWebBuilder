package org.semanticwb.cptm;

import java.util.Iterator;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;
import org.semanticwb.platform.SemanticProperty;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos. 
   */
public class GeographicPoint extends org.semanticwb.cptm.base.GeographicPointBase 
{
    public GeographicPoint(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
        /*
        LocalityInt.cptm_hasProximity.registerObserver(new SemanticObserver(){
         public void notify(SemanticObject obj, Object prop, String lang, String action)
            {
                SemanticProperty semProp=(SemanticProperty)prop;
                System.out.println("semProp:"+semProp.getName());
                Iterator <SemanticObject> semObject=obj.listObjectProperties(semProp);
                while(semObject.hasNext()){
                    SemanticObject semObj=(SemanticObject)semObject.next();
                    LocalityInt locality=(LocalityInt)semObj.createGenericInstance();
                    if(!GeographicPoint.this.hasProximity(locality)){
                        System.out.println("Agrega a:" +GeographicPoint.this+", la proximidad:"+locality);
                        GeographicPoint.this.addProximity(locality);
                    }
                }
         }
        });
         * */
         
    }

    

}
