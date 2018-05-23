package com.cyclos.stepdefination;

import org.junit.Assert;
import org.testng.annotations.Test;

import SeleniumPackage.TestAttributes;
import SeleniumPackage.WebKeywordLibrary;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Reporter;

public class StepDefinationCyclos extends WebKeywordLibrary {	

	
	@Given("^I want to enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_want_to_enter_valid_demo_and(String arg1, String arg2) throws Throwable {
		// Express the Regexp above with the code you wish you had
		//throw new PendingException();
		LAUNCHAPP(TestAttributes.prop.getProperty("browser"));
		
		EnterByXpath(TestAttributes.prop.getProperty("cyclos_loginpage.username_txtbox.xpath"),arg1);
		EnterByXpath(TestAttributes.prop.getProperty("cyclos_loginpage.password_txtbox.xpath"),arg2);
	}

	@And("^click on Sign In button$")
	public void click_on_Sign_In_button() throws Throwable {
		// Express the Regexp above with the code you wish you had
		//throw new PendingException();
		ClickByXpath(TestAttributes.prop.getProperty("cyclos_loginpage.Signin_Btn.xpath"));
	}
	
	@Then("^the login should be sucessfull$")
	public void the_login_should_be_sucessfull() throws Throwable {
		// Express the Regexp above with the code you wish you had
		//throw new PendingException();
		//VerifyTitle(TestAttributes.prop.getProperty("cyclos_homepage.title.value"));		
		Assert.assertTrue(VerifyLabelByXpath(TestAttributes.prop.getProperty("cyclos_homepage.greeting_txt.xpath"),"Welcome to the Cyclos4 Demo"));
	}

	@Given("^I want to enter into the cyclos application with valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_want_to_enter_into_the_cyclos_application_with_valid_and(String arg1, String arg2) throws Throwable {
		LAUNCHAPP(TestAttributes.prop.getProperty("browser"));
		EnterByXpath(TestAttributes.prop.getProperty("cyclos_loginpage.username_txtbox.xpath"),arg1);
		EnterByXpath(TestAttributes.prop.getProperty("cyclos_loginpage.password_txtbox.xpath"),arg2);
		ClickByXpath(TestAttributes.prop.getProperty("cyclos_loginpage.Signin_Btn.xpath"));
		
		
	}

	@When("^I click on member account balance field$")
	public void I_click_on_member_account_balance_field() throws Throwable
	{
		ClickByXpath(TestAttributes.prop.getProperty("cyclos_homepage.memberacc_label.xpath"));
		
		
	}

	@Then("^Member account transaction details page should be displayed$")
	public void Member_account_transaction_details_page_should_be_displayed() throws Throwable
	{
		//VerifyTitle(TestAttributes.prop.getProperty("cyclos_memberpage.title.value"));
		Assert.assertTrue(VerifyLabelByXpath(TestAttributes.prop.getProperty("cyclos_memberaccountpage.memberacc_label.xpath"),"Member account"));
	}
	

	
}
