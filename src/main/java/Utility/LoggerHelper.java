package Utility;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;


/**
	 * LoggerHelper class to handle logging in the application.
	 * It initializes Log4j and provides logger instances.
	 */
	@SuppressWarnings("rawtypes")
	public class LoggerHelper {

	    private static boolean root = false;

		public static Logger getLogger(Class clas) {
	        if (root)
	            return Logger.getLogger(clas);

	        // Configure Log4j using the properties file
	        String log4jConfigFile = "D:\\automation\\practice\\AppConfig\\log4j.properties";  // Update this path as per your project structure
	        PropertyConfigurator.configure(log4jConfigFile);

	        // Set the flag to true to ensure this block is executed only once
	        root = true;

	        // Return logger instance for the given class
	        return Logger.getLogger(clas);
	    }
		
	}


