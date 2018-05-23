package com.cyclos.stepdefination;

import SeleniumPackage.TestAttributes;
import SeleniumPackage.WebKeywordLibrary;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.Reporter;

public class Hooks extends TestAttributes  {

	/*@Before("@functionaltesting")
	public void beforeScenario(Scenario sc) throws Throwable{
		System.out.println("anno tag before");
		



	}*/

	@Before()
	public void beforelogic(Scenario sc) throws Throwable{
	
		Reporter.startTestCase(sc.getName());

		//LAUNCHAPP(TestAttributes.prop.getProperty("browser"));

	}

	@After
	public void afterScenario( ) throws Throwable{
		//System.out.println("no anootation after");
		TestAttributes.driver.quit();
		Reporter.endtest();
		
		

	}

	/*@After("@functionaltesting")
	public void afterlogic() throws Throwable{
		
	}*/



}
