package Runner;

import Base.CutomizeTestNGCucmberRunner;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "C:\\Users\\User\\Desktop\\Automation\\fantasypanel\\src\\test\\resources\\features\\Staff\\ManageRole.feature",
		glue = { "stepDefinitions", "Hooks" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
		//,tags = "@PinContest"
		
		)
public class testRunner extends CutomizeTestNGCucmberRunner {
	
}
