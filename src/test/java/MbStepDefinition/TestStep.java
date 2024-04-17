
package MbStepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MbDriverSetup.SetupClass;
import MbPages.HelpPageFactory;
import MbPages.MbPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestStep {
	static WebDriver driver;
	
	HelpPageFactory hpf;
	
	
	@Given("User is on MagicBricks homepage")
	public void user_is_on_magic_bricks_homepage() throws InterruptedException {
		driver=SetupClass.chromedriver();  
	//	driver=SetupClass.edgedriver();
		 hpf= new HelpPageFactory(driver);
	}	 
		
	/*--------------------------------------------Scenario 1--------------------------------------*/
	/*
	 * Created By : Gauri Vyas
	 * Reviewed By :
	 * Motive : To validate Agent list with applied city filter
	 * 
	 */	
	
	 
	@When("User is on Agent SRP webpage")
	public void user_is_on_agent_srp_webpage() throws InterruptedException {
	 hpf.HoverOnRentOption();
	
	 hpf.NavigateToFindAgent();
	
	 hpf.SwitchToFindAgent();
	 //System.out.println(driver.getCurrentUrl());
	}

	
	
	@And("User opens city filter drop down list")
	public void user_opens_city_filter_drop_down_list() throws InterruptedException {
		
		 hpf.OpenCityList();
	}

	@And("select the city Mumbai")
	public void select_the_city_mumbai() throws InterruptedException {
	 
		 hpf.SelectCity();
	}

	@Then("It should display Agent list for that city")
	public void it_should_display_agent_list_for_that_city() {
		List<WebElement> agentList =  hpf.getAgentList();
        
        for (WebElement agent : agentList) {
            String agentLocation = agent.getText();
            assertTrue(agentLocation.contains("Mumbai"));
	}
}

	/*--------------------------------------------Scenario 2--------------------------------------*/
	/*
	 * Created By : Gauri Vyas
	 * Reviewed By :
	 * Motive :Validate Help Search Functionality with invalid input.
	 * 
	 */	
	@When("User is on Help Center webpage")
	public void user_is_on_help_center_webpage() throws InterruptedException {
	    hpf=new HelpPageFactory(driver);
		hpf.HoverOnHelpOption();
		hpf.NavigateToHelpCenter();	
	}

	@And("User provides invalid input {string} in search bar")
	public void user_provides_invalid_input_in_search_bar(String input) throws InterruptedException {	  
	  	hpf.SwitchToHelpCenter();	  	
		hpf.ProvideInput(input);
	}

	@And("click on search icon")
	public void click_on_search_icon() throws InterruptedException {
	    hpf.ClickOnSearch();
		
	}

	@Then("It should display an error message")
	public void it_should_display_an_error_message() {
	   String actMsg=hpf.SearchMsg();
	   String expMsg="Please Select A Question";
	   assertEquals(actMsg, expMsg);
		
	}
	/*--------------------------------------------Scenario 3-------------------------------------*/
	/*
	 * Created By : Gauri Vyas
	 * Reviewed By :
	 * Motive :Validate Help Search Functionality with invalid input
	 * 
	 */
	@When("User is on Help Center webpage1")
	public void user_is_on_help_center_webpage1() throws InterruptedException {
		 hpf=new HelpPageFactory(driver);
			hpf.HoverOnHelpOption();			
			hpf.NavigateToHelpCenter();			
		  	hpf.SwitchToHelpCenter();
	}

	@When("User provides valid input in search bar")
	public void user_provides_valid_input_in_search_bar(DataTable dataTable) throws InterruptedException{
		List<List<String>>cells=dataTable.cells();
	  	hpf.ProvideValidInput(cells.get(0).get(0));
	  	
	}

	@Then("It should display drop down list relevant to search keyword")
	public void it_should_display_drop_down_list_relevant_to_search_keyword() throws InterruptedException {
	  String Text=hpf.SearchKeyword();
	  assertEquals(Text, "login");
	  		   
	}
	
	/*--------------------------------------------Scenario 4-------------------------------------*/
	/*
	 * Created By : Gauri Vyas
	 * Reviewed By :
	 * Motive :Validate user receives OTP for verification
	 * 
	 */
	
	@When("Agent List according to the city filter is displayed")
	public void agent_list_according_to_the_city_filter_is_displayed() throws InterruptedException {
		 hpf=new HelpPageFactory(driver);
		 hpf.HoverOnRentOption();		
		 hpf.NavigateToFindAgent();		
		 hpf.SwitchToFindAgent();		 
		 hpf.OpenCityList();		 
		 hpf.SelectCity();
	}

	@And("User clicks on Contact Agent button")
	public void user_clicks_on_contact_agent_button() throws InterruptedException {
		 hpf.ContactAgent();
	}

	@And("provide details {string}, {string}, {string} in the one time contact form to get details on email")
	public void provide_details_in_the_one_time_contact_form_to_get_details_on_email(String name, String email, String phoneno) throws InterruptedException {	   
		hpf.ProvideName(name);		
	    hpf.ProvideEmail(email);	    
        hpf.ProvidePhone(phoneno);        
        hpf.ClickOnGetContact();
	}

	@Then("user should be able to provide OTP received on registered number.")
	public void user_should_be_able_to_provide_otp_received_on_registered_number() throws InterruptedException {
		
		String Otp=hpf.PutOtp();		
		String expOtp="^\\d{3}$";
		assertEquals(Otp,expOtp);
	}



	/*--------------------------------------------Scenario 5-------------------------------------*/
	/*
	 * Created By : Gauri Vyas
	 * Reviewed By :
	 * Motive :Validate Service Center CallBack functionality
	 * 
	 */
	
	@When("User is on Sales Enquiry Webpage")
	public void user_is_on_sales_enquiry_webpage() throws InterruptedException {
	    Thread.sleep(1000);
	   
	    hpf.NavigateToSalesEnquiry();
	}

	@And("Click on Request Callback button")
	public void click_on_request_callback_button() {
	    hpf.ClickOnRequestCallback();
	}

	@And("submit the callback form without entering phone number")
	public void submit_the_callback_form_without_entering_phone_number() {
	    hpf.SubmitCallBack();
	}

	@Then("It should give an error message")
	public void it_should_give_an_error_message() {
	    String act=hpf.MessageErr();
	    String exp="Please provide valid contact number";
	    assertEquals(act,exp);
	}
		

	@AfterStep
	public static void takeScreendown(Scenario scenerio) {
 
		   TakesScreenshot ts= (TakesScreenshot) driver;
		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		   scenerio.attach(src, "image/png",scenerio.getName());

}

}
