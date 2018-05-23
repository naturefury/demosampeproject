package steprunner;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import SeleniumPackage.TestAttributes;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "E:\\Gopi\\CorrectWS\\Gerty\\Artemis\\cyclossampledemo\\src\\test\\resources\\Cyclos_Features",
		glue= {"com.cyclos.stepdefination"},
		//tags= {"@testdemo1"},
		monochrome=true
		//,tags= {"@two,@three"}

		)
//
//extends AbstractTestNGCucumberTests

public class SteprunnerCyclos  {
	
	@BeforeClass
	public static void beforeclass() throws IOException, ConfigurationException
	{		
		TestAttributes.loadobjectsprop();
		TestAttributes.runId();
		TestAttributes.createrunfolder();
		Reporter.startResult();			
		TestAttributes.logsetup();		
		System.out.println(TestAttributes.i);
		
	}
	@AfterClass
	public static void afterclass()
	{
		Reporter.endflush();
	}
	

}
