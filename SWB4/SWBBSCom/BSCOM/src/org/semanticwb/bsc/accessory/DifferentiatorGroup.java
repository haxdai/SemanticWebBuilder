package org.semanticwb.bsc.accessory;

import java.util.List;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.GenericFilterRule;


   /**
   * Un DifferentiatorGroup es una clase que permitir contener uno o varios Differentiator que se dibujan en el mapa estratégico del scorecard. 
   */
public class DifferentiatorGroup extends org.semanticwb.bsc.accessory.base.DifferentiatorGroupBase
{
    public DifferentiatorGroup(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public List<Differentiator> listValidDifferentiators() {
        List<Differentiator> validDiffs = SWBUtils.Collections.filterIterator(super.listDifferentiators(), new GenericFilterRule<Differentiator>() {
                                                                        @Override
                                                                        public boolean filter(Differentiator diff) {
                                                                            if(diff==null) {
                                                                                return true;
                                                                            }
                                                                            /*User user = SWBContext.getSessionUser(getPerspective().getBSC().getUserRepository().getId());
                                                                            if(user==null) {
                                                                                user = SWBContext.getAdminUser();
                                                                            }
                                                                            return !diff.isValid() || !user.haveAccess(diff);*/
                                                                            return !diff.isValid();
                                                                        }            
                                                                    });
        return validDiffs;
    }

    @Override
    public boolean isValid() {
        return super.isValid() && getPerspective().isValid();
    }
}
