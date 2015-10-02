package org.semanticwb.bsc.accessory;

import java.util.Collections;
import java.util.List;
import org.semanticwb.SWBUtils;


public class PeriodGroup extends org.semanticwb.bsc.accessory.base.PeriodGroupBase 
{
    public PeriodGroup(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public List<Period> listPeriods() {
        List periods = SWBUtils.Collections.copyIterator(super.listGroupedPeriods());
        return periods;
    }

    public List<Period> listGroupedPeriods(boolean ascending) {
        List periods = SWBUtils.Collections.copyIterator(super.listGroupedPeriods());
        if(ascending) {
            Collections.sort(periods);
        }else {
            Collections.sort(periods, Collections.reverseOrder());
        }
        return periods;
    }
}
