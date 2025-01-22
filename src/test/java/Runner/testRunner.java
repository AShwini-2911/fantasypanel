package Runner;

import Base.CutomizeTestNGCucmberRunner;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "D:\\automation\\practice\\src\\test\\resources\\features\\GeneralSettings\\avatar.feature",
		glue = { "stepDefinitions", "Hooks" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
		//,tags = "@PinContest"
		
		)
public class testRunner extends CutomizeTestNGCucmberRunner {
	
}
