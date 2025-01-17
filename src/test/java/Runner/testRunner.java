package Runner;

import Base.CutomizeTestNGCucmberRunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "D:\\automation\\practice\\src\\test\\resources\\features\\DFS\\ContestDashboard.feature",
		glue = { "stepDefinitions", "Hooks" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
		,tags = "@PinContest"
		//,tags = "(@MasterModule and @P1) or (@MasterModule and @P2) or (@MasterModule and @P3) or (@MasterModule and @P4) or (@MasterModule and @P5) or (@MasterModule and @P6)"
		
		)
public class testRunner extends CutomizeTestNGCucmberRunner {
	
}
