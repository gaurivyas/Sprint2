package MbTestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\GNEELKAN\\Desktop\\Sprint2\\Rent\\src\\text\\resource\\MbFeature\\Rent.feature",
glue="MbStepDefinition",tags="@CallBack",
plugin= {"pretty", 
"html:target/HTMLReports/MagicBricksReport.html",	
"json:target/JSONReports/MagicBricksReport.json",
"junit:target/JUNITReports/MagicBricksReport.xml",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})



public class MbRunner extends AbstractTestNGCucumberTests {

}

