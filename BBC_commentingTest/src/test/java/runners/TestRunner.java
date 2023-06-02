/*Test runner class for cucumber class, defining*
 * feature file and step definitions*/
package runners;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import fileReaders.ConfigFileReader;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTest",
		glue = {"stepDefinitions"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true
		)
public class TestRunner {
	/*Method to generate extent report, file path is reading from config file*/
	@AfterClass
	public static void generateReport() {
		try {
			String configFilePath = new ConfigFileReader().getExtentReportConfigPath();
			Reporter.loadXMLConfig(new File(configFilePath));
		}
		catch (Exception e) {e.printStackTrace();}
	}
}
