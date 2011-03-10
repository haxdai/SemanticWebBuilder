package org.semanticwb.cptm;

import java.util.Iterator;
import org.semanticwb.SWBPortal;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;
import org.semanticwb.platform.SemanticProperty;

/**
 * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Destinos.
 */
public class GeographicPoint extends org.semanticwb.cptm.base.GeographicPointBase {

    static {

        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(GeographicPoint.class, new LocalityParser()); //Registra Parser

        //Observador de la propiedad "cptm_hasProximity", cada que haya un cambio en ella se ejecuta el siguiente código
        LocalityInt.cptm_hasProximity.registerObserver(new SemanticObserver() {
            public void notify(SemanticObject obj, Object prop, String lang, String action) {
                if(action!=null && obj.instanceOf(LocalityInt.cptm_LocalityInt))
                {
                    LocalityInt currentlpoint = (LocalityInt) obj.createGenericInstance();
                    SemanticProperty semProp = (SemanticProperty) prop;
                    if(action.equalsIgnoreCase("REMOVE")){
                        Iterator<SemanticObject> semObject = obj.listObjectProperties(semProp);
                        while (semObject.hasNext()) {
                            SemanticObject semObj = (SemanticObject) semObject.next();
                            LocalityInt locality = (LocalityInt) semObj.createGenericInstance();
                            if (locality.hasProximity(currentlpoint)) {
                                //System.out.println("Elimina de:" + locality + ", la proximidad inversa:" + currentlpoint);
                                locality.getSemanticObject().removeObjectProperty(cptm_hasProximity, currentlpoint.getSemanticObject(), false);
                            }
                        }  
                    }else if(action.equalsIgnoreCase("ADD")){                
                            Iterator<SemanticObject> semObject = obj.listObjectProperties(semProp);
                            while (semObject.hasNext()) {
                                SemanticObject semObj = (SemanticObject) semObject.next();
                                LocalityInt locality = (LocalityInt) semObj.createGenericInstance();
                                if (currentlpoint.getURI() != locality.getURI() && !locality.hasProximity(currentlpoint)) {
                                    //System.out.println("Agrega a:" + locality + ", la proximidad inversa:" + currentlpoint);
                                    locality.getSemanticObject().addObjectProperty(cptm_hasProximity, currentlpoint.getSemanticObject(), false);
                                }
                            }    
                    }
                }

            }
        });
    }

    public GeographicPoint(org.semanticwb.platform.SemanticObject base) {
        super(base);        
    }
    
}
