package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;

import java.lang.management.ManagementFactory;

import javax.management.*;

import org.apache.logging.log4j.*;

//import jmx.MaintenanceMode;
import jmx.Advert;

@WebListener
public class StartupListener implements ServletContextListener {
	
	
	private static final Logger logger = LogManager.getLogger(StartupListener.class);

    /**
     * Default constructor. 
     */
    public StartupListener() {
        // TODO Auto-generated constructor stub
    }
    public void sessionWillPassivate(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	  logger.info("Démarrage de l'application...");
    	  // Initializing MBean
          MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
          ObjectName name = null;
          
          try {
              name = new ObjectName("TP-CRUD-JEE.jmx:type=AdvertMBean");
              Advert mbean = new Advert();
              mbs.registerMBean(mbean, name);
          } catch (Exception e) {
              logger.error(e);
          }
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	
}
