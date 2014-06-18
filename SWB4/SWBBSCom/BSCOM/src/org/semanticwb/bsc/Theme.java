package org.semanticwb.bsc;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.GenericFilterRule;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticProperty;


   /**
   * Los temas estratégicos agrupan objetivos con fines en común. A su vez, los temas están agrupados dentro de las perspectivas. 
   */
public class Theme extends org.semanticwb.bsc.base.ThemeBase implements Comparable<Theme>
{
    public Theme(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    @Override
    public int compareTo(Theme anotherTheme)
    {
        int compare = getIndex()>anotherTheme.getIndex()?1:-1;
        return compare;
    }
    
    public List<Objective> listValidObjectives() {
        List<Objective> validObjectives = SWBUtils.Collections.filterIterator(super.listObjectives(), new GenericFilterRule<Objective>() {
                                                                        @Override
                                                                        public boolean filter(Objective o) {
                                                                            if(o==null) {
                                                                                return true;
                                                                            }
                                                                            User user = SWBContext.getSessionUser(getPerspective().getBSC().getUserRepository().getId());
                                                                            if(user==null) {
                                                                                user = SWBContext.getAdminUser();
                                                                            }
                                                                            return !o.isValid() || !user.haveAccess(o);
                                                                        }            
                                                                    });
        return validObjectives;
    }
    
    @Override
    public boolean isValid() {
        if(getPerspective()==null){
            return false;
        }
        return super.isValid() && getPerspective().isValid();
    }

    @Override
    public void validOrder(HttpServletRequest request, SemanticProperty prop, String propName) throws FormValidateException {
        int ordinal;
        try {
            String value = request.getParameter(propName);
            ordinal = Integer.parseInt(value);
        }catch(NumberFormatException pe) {            
            throw new FormValidateException("El valor debe ser numérico y no puede repetirse");
        }
        
        GenericIterator<Theme> it = getPerspective().listThemes();
        while(it.hasNext()) {
            Theme t = it.next();
            if( this.equals(t) ) {
                continue;
            }
            if(t.getIndex() == ordinal) {
                throw new FormValidateException("El valor debe ser numérico y no puede repetirse");
            }
        }
    }
}
