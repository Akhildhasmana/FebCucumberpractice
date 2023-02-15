package Practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo {

	public static void main (String args[])throws Exception {
	  Logger log=LogManager.getLogger("LoggerDemo");
	   System.out.println("This is info loggerdemo");
		
	  log.info("Log Information check");
	  log.debug("Debug 123");
	   log.fatal("Fatal 123");
	   log.error("Error 123");
	  log.warn("Warn 123 ");
}
}  