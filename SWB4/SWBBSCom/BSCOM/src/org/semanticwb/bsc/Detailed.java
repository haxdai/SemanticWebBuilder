package org.semanticwb.bsc;

import org.semanticwb.bsc.accessory.Period;

public interface Detailed extends org.semanticwb.bsc.base.DetailedBase
{
    public boolean canView();
    public String getStatusIconClass();
    public String getStatusIconClass(Period period);
}
