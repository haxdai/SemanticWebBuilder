package org.semanticwb.bsc;

import java.util.Iterator;
import org.semanticwb.bsc.accessory.Period;

public interface Seasonable extends org.semanticwb.bsc.base.SeasonableBase
{
    public BSC getBSC();
    public Period getFirstPeriod();
    public Period getLastPeriod();
    public Period getNextPeriod();
    public Iterator<Period> listAvailablePeriods();
    public Iterator<Period> listAvailablePeriods(boolean ascending);
}
