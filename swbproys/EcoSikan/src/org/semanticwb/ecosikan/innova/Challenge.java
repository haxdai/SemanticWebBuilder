package org.semanticwb.ecosikan.innova;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.portal.api.*;

public class Challenge extends org.semanticwb.ecosikan.innova.base.ChallengeBase 
{


    public Challenge(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static class ClassMgr
    {
        public static org.semanticwb.ecosikan.innova.Challenge createChallenge(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            System.out.println("\n\nEstoy en Challenge.createChallenge 1 con id="+id);
            return org.semanticwb.ecosikan.innova.Challenge.ClassMgr.createChallenge(String.valueOf(id), model);
        }

        /**
       * Create a org.semanticwb.ecosikan.innova.Challenge
       * @param id Identifier for org.semanticwb.ecosikan.innova.Challenge
       * @param model Model of the org.semanticwb.ecosikan.innova.Challenge
       * @return A org.semanticwb.ecosikan.innova.Challenge
       */
        public static org.semanticwb.ecosikan.innova.Challenge createChallenge(String id, org.semanticwb.model.SWBModel model)
        {
            System.out.println("\n\nEstoy en Challenge.createChallenge 2 con id="+id);
            return (org.semanticwb.ecosikan.innova.Challenge)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
    }

}
