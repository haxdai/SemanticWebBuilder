package org.semanticwb.bsc;

import org.semanticwb.bsc.accessory.Period;

/*
 * Interface que define un elemento que puede mostrar detalles
*/
public interface Detailed extends org.semanticwb.bsc.base.DetailedBase
{
    public boolean canView();
    public String getStatusIconClass();
    public String getStatusIconClass(Period period);
    public String getStatusTitle(Period period);
}
