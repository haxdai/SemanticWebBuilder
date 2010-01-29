/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.portal.monitor;


import static java.lang.management.ManagementFactory.*;
import com.sun.management.GarbageCollectorMXBean;
import com.sun.management.GcInfo;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.*;
import javax.management.ObjectName;


/**
 *
 * @author serch
 */
public class SWBLocalMemoryPool {
    private String poolName;
    private ObjectName  objName;
    private MemoryPoolMXBean pool;
    private Map<ObjectName,Long> gcMBeans;
    private GcInfo lastGcInfo;

    public SWBLocalMemoryPool(ObjectName poolName) throws java.io.IOException {
        this.objName = objName;
        this.pool = newPlatformMXBeanProxy(getPlatformMBeanServer(),
                                      poolName.toString(),
                                      MemoryPoolMXBean.class);
        this.poolName = this.pool.getName();
        this.gcMBeans = new HashMap<ObjectName,Long>();
        this.lastGcInfo = null;

        String[] mgrNames = pool.getMemoryManagerNames();
        for (String name : mgrNames) {
            try {
                ObjectName mbeanName = new ObjectName(GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE +
                                                      ",name=" + name);
                if (getPlatformMBeanServer().isRegistered(mbeanName)) {
                    gcMBeans.put(mbeanName, new Long(0));
                }
            } catch (Exception e) {
                assert false;
            }

        }
    }

    public boolean isCollectedMemoryPool() {
        return (gcMBeans.size() != 0);
    }

    public ObjectName getObjectName() {
        return objName;
    }

    public SWBMemoryPoolStat getStat() throws java.io.IOException {
        long usageThreshold = (pool.isUsageThresholdSupported()
                                  ? pool.getUsageThreshold()
                                  : -1);
        long collectThreshold = (pool.isCollectionUsageThresholdSupported()
                                  ? pool.getCollectionUsageThreshold()
                                  : -1);
        long lastGcStartTime = 0;
        long lastGcEndTime = 0;
        MemoryUsage beforeGcUsage = null;
        MemoryUsage afterGcUsage = null;
        long gcId = 0;
        if (lastGcInfo != null) {
            gcId = lastGcInfo.getId();
            lastGcStartTime = lastGcInfo.getStartTime();
            lastGcEndTime = lastGcInfo.getEndTime();
            beforeGcUsage = lastGcInfo.getMemoryUsageBeforeGc().get(poolName);
            afterGcUsage = lastGcInfo.getMemoryUsageAfterGc().get(poolName);
        }

        Set<Map.Entry<ObjectName,Long>> set = gcMBeans.entrySet();
        for (Map.Entry<ObjectName,Long> e : set) {
            GarbageCollectorMXBean gc =
                newPlatformMXBeanProxy(getPlatformMBeanServer(),
                                      e.getKey().getCanonicalName(),
                                      com.sun.management.GarbageCollectorMXBean.class);
            Long gcCount = e.getValue();
            Long newCount = gc.getCollectionCount();
            if (newCount > gcCount) {
                gcMBeans.put(e.getKey(), new Long(newCount));
                lastGcInfo = gc.getLastGcInfo();
                if (lastGcInfo.getEndTime() > lastGcEndTime) {
                    gcId = lastGcInfo.getId();
                    lastGcStartTime = lastGcInfo.getStartTime();
                    lastGcEndTime = lastGcInfo.getEndTime();
                    beforeGcUsage = lastGcInfo.getMemoryUsageBeforeGc().get(poolName);
                    afterGcUsage = lastGcInfo.getMemoryUsageAfterGc().get(poolName);
                    assert(beforeGcUsage != null);
                    assert(afterGcUsage != null);
                }
            }
        }

        MemoryUsage usage = pool.getUsage();
        return new SWBMemoryPoolStat(poolName,
                                  usageThreshold,
                                  usage,
                                  gcId,
                                  lastGcStartTime,
                                  lastGcEndTime,
                                  collectThreshold,
                                  beforeGcUsage,
                                  afterGcUsage);
    }

}
