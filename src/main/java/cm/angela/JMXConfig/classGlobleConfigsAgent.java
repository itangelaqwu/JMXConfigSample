package main.java.cm.angela.JMXConfig;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by Angela on 5/18/2014.
 */
public class classGlobleConfigsAgent {

    public static void main(String[] args) throws Exception {

        MBeanServer mbServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objName = new ObjectName("setting:name=ip1");
        GlobleConfigs conf = new GlobleConfigs();
        conf.setIpDir("192.168.196.17");
        mbServer.registerMBean(conf, objName);
        ObjectName adapterName = new ObjectName("GlobleConfigsAgent:name=htmladapter,port=8081");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        mbServer.registerMBean(adapter, adapterName);
        adapter.start();
        System.out.println("start.....");

        //varify if the value is changed
        for (int i = 0; i < 100; i++) {
            Thread.sleep(2000);
            System.out.println(conf.getIpDir());
        }
    }
}
