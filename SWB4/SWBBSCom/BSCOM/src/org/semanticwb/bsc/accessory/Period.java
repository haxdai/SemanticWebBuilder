package org.semanticwb.bsc.accessory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.bsc.accessory.base.PeriodBase;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.SWBModel;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticObserver;
import org.semanticwb.platform.SemanticProperty;

public class Period extends PeriodBase implements Comparable<Period>
{    
    static
    {
        bsc_start.registerObserver(new SemanticObserver()
        {
            @Override
            public void notify(SemanticObject obj, Object prop, String lang, String action)
            {
                if ("SET".equalsIgnoreCase(action)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    if ((obj.getDateProperty(Period.bsc_start) != null) && (obj.getDateProperty(Period.bsc_end) != null)) {
                        Date start = obj.getDateProperty(Period.bsc_start);
                        Date end = obj.getDateProperty(Period.bsc_end);
                        if (end.getTime() < start.getTime()) {
                            obj.setDateProperty(PeriodBase.bsc_start, end);
                            obj.setDateProperty(PeriodBase.bsc_end, start);
                        }
                    }
                }
            }
        });
        
        bsc_end.registerObserver(new SemanticObserver()
        {
            @Override
            public void notify(SemanticObject obj, Object prop, String lang, String action)
            {
                if ("SET".equalsIgnoreCase(action)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    if ((obj.getDateProperty(Period.bsc_start) != null) && (obj.getDateProperty(Period.bsc_end) != null)) {
                        Date start = obj.getDateProperty(Period.bsc_start);
                        Date end = obj.getDateProperty(Period.bsc_end);
                        if (end.getTime() < start.getTime()) {
                            obj.setDateProperty(PeriodBase.bsc_start, end);
                            obj.setDateProperty(PeriodBase.bsc_end, start);
                        }
                    }
                }
            }
        });
    }
    
    public Period(SemanticObject base) {
        super(base);
    }

    @Override
    public int compareTo(Period anotherPeriod) {
        //int compare;
        if(anotherPeriod==null || anotherPeriod.getStart()==null) {
            return 1;
        }
        Date d1 = getStart();
        if(d1==null) {
            return -1;
        }
        Date d2 = anotherPeriod.getStart();
        //compare = d1.getTime() > d2.getTime() ? 1 : -1;
        return d1.compareTo(d2);
    }
    
    public boolean isFuture() {
        long now = new Date().getTime();
        return getStart().getTime() > now;
    }
    
    public boolean isCurrent() {
        long now = new Date().getTime();
        return now>=getStart().getTime() && now<=getEnd().getTime();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n");
        sb.append("Start:");
        sb.append(getStart());
        sb.append("\nEnd:");
        sb.append(getEnd());        
        //return sb.toString();
        return super.toString();
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
        
        SemanticObject obj = getSemanticObject();
        SWBModel model = (SWBModel)obj.getModel().getModelObject().createGenericInstance();
        Iterator<SemanticObject> it = model.getSemanticModel().listInstancesOfClass(obj.getSemanticClass());
        while(it.hasNext()) {
            SemanticObject so = it.next();
            if( obj.equals(so) ) {
                continue;
            }
            if(ordinal == so.getIntProperty(prop))
            {
                throw new FormValidateException("El valor ordinal debe ser numérico y no puede repetirse");
            }
        }
    }

    @Override
    public int getIndex() {
        int index;
        index = super.getIndex();
        if(index < 0) {
            try {
                index = Integer.parseInt(this.getId());
            }catch(NumberFormatException nfe) {
                index = Integer.MAX_VALUE;
            }finally {
                super.setIndex(index);
            }
        }
        return index;
    }

    @Override
    public Period getNext() {
        return (Period)super.getNext();
    }
    
    @Override
    public Period getPrevius()
    {
        return (Period)super.getPrevius();
    }
}