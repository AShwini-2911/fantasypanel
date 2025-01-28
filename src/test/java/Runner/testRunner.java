package Runner;

import Base.CutomizeTestNGCucmberRunner;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "E:\\Ashwini\\fantasypanel\\src\\test\\resources\\features\\FinanceERP\\FinancialTransaction.feature",
		glue = { "stepDefinitions", "Hooks" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
		//,tags = "@PinContest"
		
		)
public class testRunner extends CutomizeTestNGCucmberRunner {
	
}
