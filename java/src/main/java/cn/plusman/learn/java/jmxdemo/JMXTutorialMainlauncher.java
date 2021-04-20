package cn.plusman.learn.java.jmxdemo;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Reference to article: https://www.baeldung.com/java-management-extensions
 * @author plusman
 * @since 2021/4/20 3:39 PM
 */
public class JMXTutorialMainlauncher {
    public static void main(String[] args) {
    
        System.out.println("This is basic JMX tutorial");
        
        try {
            ObjectName objectName = new ObjectName(" cn.plusman.learn.java.jmxdemo:type=basic,name=game");
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            server.registerMBean(new Game(), objectName);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException |
            MBeanRegistrationException | NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    
        System.out.println("Registration for Game mbean with the platform server is successfull");
        System.out.println("Please open jconsole to access Game mbean");
        
        while (true) {
            // to ensure application does not terminate
        }
    }
}
