package Hooks;




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import Base.DriverManager;
import Utility.LoggerHelper;
import Utility.Util;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class hook extends DriverManager {
    private static Logger log = LoggerHelper.getLogger(hook.class);

	@BeforeStep
	public void beforeStep() {
	}

	@AfterStep
	public void afterStep() {
	}

	@Before
	public void beforeScenario(Scenario scenario) {

		Util.performLogin();
        scenario.attach(Util.takeScreenShot(), "image/png", "Login Successful: " + scenario.getName());
        
        Util.startConsoleCapture();

	}

	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(Util.takeScreenShot(), "image/png", scenario.getName());
		
		 String consoleOutput4 = Util.stopConsoleCapture();

        // Attach console output if there is any
           if (!consoleOutput4.isEmpty()) {
            scenario.attach(consoleOutput4, "text/plain", "Console Output");
            
        }
        else
        {
        	System.out.println("No console");
        }

           try {
               String logContent = readLogFile("D:\\automation\\practice\\target\\Selenium.log"); // Specify the path to the log file here
               if (!logContent.isEmpty()) {
                   scenario.attach(logContent, "text/plain", "Log File Content");
               }
           } catch (IOException e) {
               System.err.println("Failed to read log file: " + e.getMessage());
               log.error("Failed to read log file", e);
           }

        // Clear console output for the next test
        Util.clearConsoleOutput();
	}
	
	private String readLogFile(String logFilePath) throws IOException {
        StringBuilder logContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logContent.append(line).append("\n");
            }
        }
        return logContent.toString();
    }
}


