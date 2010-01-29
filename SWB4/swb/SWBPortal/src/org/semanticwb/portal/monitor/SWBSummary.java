/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal.monitor;

import java.io.IOException;
import static java.lang.management.ManagementFactory.*;
import static org.semanticwb.portal.monitor.SWBFormatUtils.*;
import java.lang.management.*;
import java.util.*;
import javax.management.*;

/**
 *
 * @author serch
 */
public class SWBSummary
{

    private ClassLoadingMXBean classLoadingMBean = null;
    private CompilationMXBean compilationMBean = null;
    private MemoryMXBean memoryMBean = null;
    private OperatingSystemMXBean operatingSystemMBean = null;
    private RuntimeMXBean runtimeMBean = null;
    private ThreadMXBean threadMBean = null;
    private com.sun.management.OperatingSystemMXBean sunOperatingSystemMXBean = null;
    private List<SWBLocalMemoryPool> memoryPoolProxies = null;
    private List<GarbageCollectorMXBean> garbageCollectorMBeans = null;
    private long prevUpTime, prevProcessCpuTime;

    public SWBSummary()
    {
        classLoadingMBean = getClassLoadingMXBean();
        compilationMBean = getCompilationMXBean();
        memoryMBean = getMemoryMXBean();
        operatingSystemMBean = getOperatingSystemMXBean();
        runtimeMBean = getRuntimeMXBean();
        threadMBean = getThreadMXBean();
        garbageCollectorMBeans = getGarbageCollectorMXBeans();

        try
        {
            sunOperatingSystemMXBean = newPlatformMXBeanProxy(getPlatformMBeanServer(), OPERATING_SYSTEM_MXBEAN_NAME, com.sun.management.OperatingSystemMXBean.class);
            getMemoryPoolProxies();
        } catch (IOException ex)
        {
            assert (false);
        }
    }

    public Collection<SWBLocalMemoryPool> getMemoryPoolProxies()
            throws IOException
    {

        // TODO: How to deal with changes to the list??
        if (memoryPoolProxies == null)
        {
            ObjectName poolName = null;
            try
            {
                poolName = new ObjectName(MEMORY_POOL_MXBEAN_DOMAIN_TYPE + ",*");
            } catch (MalformedObjectNameException e)
            {
                // should not reach here
                assert (false);
            }
            Set mbeans = getPlatformMBeanServer().queryNames(poolName, null);
            if (mbeans != null)
            {
                memoryPoolProxies = new ArrayList<SWBLocalMemoryPool>();
                Iterator iterator = mbeans.iterator();
                while (iterator.hasNext())
                {
                    ObjectName objName = (ObjectName) iterator.next();
                    SWBLocalMemoryPool p = new SWBLocalMemoryPool(objName);
                    memoryPoolProxies.add(p);
                }
            }
        }
        return memoryPoolProxies;
    }

    public SWBSummaryData getSample()
    {
        SWBSummaryData ret = new SWBSummaryData();
        ret.vmName = runtimeMBean.getVmName() + " version " + runtimeMBean.getVmVersion();
        ret.vmVendor = runtimeMBean.getVmVendor();
        ret.vmInstanceName = runtimeMBean.getName();
        if (null != sunOperatingSystemMXBean)
        {
            ret.processCpuTime = sunOperatingSystemMXBean.getProcessCpuTime();
            ret.commitedVirtualMem = sunOperatingSystemMXBean.getCommittedVirtualMemorySize();
            ret.FreeSwapMem = sunOperatingSystemMXBean.getFreeSwapSpaceSize();
            ret.freePhysicalMem = sunOperatingSystemMXBean.getFreePhysicalMemorySize();
            ret.totalPhysicalMem = sunOperatingSystemMXBean.getTotalPhysicalMemorySize();
            ret.totalSwapMem = sunOperatingSystemMXBean.getTotalSwapSpaceSize();
            //ret.systemLoadAverage = sunOperatingSystemMXBean.getSystemLoadAverage();
        }
        ret.jitCompiler = compilationMBean.getName();
        ret.vmLibraryPath = runtimeMBean.getLibraryPath();
        ret.vmClassPath = runtimeMBean.getClassPath();
        ret.vmBootClassPath = runtimeMBean.getBootClassPath();
        Iterator<String> it = runtimeMBean.getInputArguments().iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext())
        {
            sb.append(it.next()).append(" ");
        }
        ret.vmArgs = sb.toString().trim();
        ret.osName = operatingSystemMBean.getName() + " " + operatingSystemMBean.getVersion();
        ret.vmArch = operatingSystemMBean.getArch();
        ret.nCPUs = operatingSystemMBean.getAvailableProcessors();
        ret.upTime = runtimeMBean.getUptime();
        ret.startTime = runtimeMBean.getStartTime();
        //ret.systemLoadAverage = operatingSystemMBean.getSystemLoadAverage();
        ret.liveTh = threadMBean.getThreadCount();
        ret.deamonTh = threadMBean.getDaemonThreadCount();
        ret.peakTh = threadMBean.getPeakThreadCount();
        ret.startedTh = threadMBean.getTotalStartedThreadCount();
        ret.currentClass = classLoadingMBean.getLoadedClassCount();
        ret.totalClass = classLoadingMBean.getTotalLoadedClassCount();
        ret.unloadedClass = classLoadingMBean.getUnloadedClassCount();
        MemoryUsage u = memoryMBean.getHeapMemoryUsage();
        ret.currentHeap = u.getUsed();
        ret.maxHeap = u.getMax();
        ret.currentCommited = u.getCommitted();
        ret.objectsPending = memoryMBean.getObjectPendingFinalizationCount();
        ArrayList<String> gcList = new ArrayList<String>();
        for (GarbageCollectorMXBean garbageCollectorMBean : garbageCollectorMBeans)
        {
            String gcName = garbageCollectorMBean.getName();
            long gcCount = garbageCollectorMBean.getCollectionCount();
            long gcTime = garbageCollectorMBean.getCollectionTime();
            gcList.add("Nombre=" + gcName + " Colecciones: " + gcCount + " Tiempo: " + formatTime(gcTime));
        }
        ret.gcDetails = gcList.toArray(new String[gcList.size()]);
//        try {
//        ret.internalName=(String)lvm.findByName("sun.rt.internalVersion").getValue();
//        } catch (Exception e) {ret.internalName="No disponible";}
        ret.instantCPU = updateCPUInfo(ret);
        return ret;
    }

    public float updateCPUInfo(SWBSummaryData data) {
        float cpuUsage = Float.MIN_VALUE;
	    if (prevUpTime > 0L && data.upTime > prevUpTime) {
		// elapsedCpu is in ns and elapsedTime is in ms.
		long elapsedCpu = data.processCpuTime - prevProcessCpuTime;
		long elapsedTime = data.upTime - prevUpTime;
		// cpuUsage could go higher than 100% because elapsedTime
		// and elapsedCpu are not fetched simultaneously. Limit to
		// 99% to avoid Plotter showing a scale from 0% to 200%.
		cpuUsage =
		    Math.min(99.99F,
			     elapsedCpu / (elapsedTime * 10000F * data.nCPUs));
	    }
	    this.prevUpTime = data.upTime;
	    this.prevProcessCpuTime = data.processCpuTime;
            return cpuUsage;
	}

}
