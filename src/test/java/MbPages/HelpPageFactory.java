package MbPages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpPageFactory {
WebDriver driver;
WebDriverWait wait;	


     /*Scenario 1*/
     @FindBy(id="rentheading")
     @CacheLookup
     WebElement rentHeading;
 
     @FindBy(css="a[onclick=\"openUrlInNewTab('https://www.magicbricks.com/Real-estate-property-top-agents/agent-in-Mumbai?&proptype=Multistorey-Apartment,Builder-Floor-Apartment,Penthouse,Studio-Apartment,Service-Apartment,Residential-House,Villa&cityName=Mumbai&mbTrackSrc=tabChange&page=1&category=R');\"]")
     @CacheLookup
     WebElement clickOnFindAgent;
 
     @FindBy(id="cityList")
     //@FindBy(xpath="//div[@class=\"srpSort__filter-select\"]")
     @CacheLookup
     WebElement dropDownList;

     @FindBy(id="topAgentCard")
     @CacheLookup
     List<WebElement> agentList;

     @FindBy(id="contactBtn2340868")
     @CacheLookup
     WebElement contactBtn;
  
     /*Scenario 2*/

     @FindBy(xpath="//a[text()=\"Help\"]")
     @CacheLookup
     WebElement helpHeading;
     
     @FindBy(xpath="//a[@href=\"https://www.magicbricks.com/help\"]")
     @CacheLookup
     WebElement clickOnHelpCenter;
     
     @FindBy(id="searchContentInput")
     @CacheLookup
     WebElement inp;
         
     @FindBy(id="userPersonaPopupCloseAnchor")
     @CacheLookup
     WebElement closebutton;
     
     @FindBy(id="doSearchButton")
     @CacheLookup
     WebElement searchIcon;
     
     @FindBy(id="onlyLocation")
     @CacheLookup
     WebElement errMsg;
     
     @FindBy(id="searchContentInput")
     @CacheLookup
     WebElement inpValid;
     
     @FindBy(xpath="//span[@class=\"highlightClass\"]")
     @CacheLookup
     WebElement list;
     
     @FindBy(id="username2340868")
     @CacheLookup
     WebElement uname;
     
     @FindBy(id="userEmail2340868")
     @CacheLookup
     WebElement uemail;
     
     @FindBy(id="userMobile2340868")
     @CacheLookup
     WebElement uphone;
     
     @FindBy(id="contactObjButton")
     @CacheLookup
     WebElement cont ;
     
     @FindBy(id="smsNo")
     @CacheLookup
     WebElement otp ;
     
//     @FindBy(xpath="//div[@class=\"mb-header__sub__tabs__dropdown js-menu-drop swiper-created\"]/div/div/ul/li[2]/a")
     @FindBy(xpath="(//a[@href=\"https://www.magicbricks.com/contactUs\"])[4]")
     @CacheLookup
     WebElement Sales;
     
     @FindBy(xpath="//a[@onclick=\"inboundPopupOpen('inbound-poup')\"]")
     @CacheLookup
     WebElement reqbtn;
     
     @FindBy(id="callBackSubmit")
     @CacheLookup
     WebElement SubmitCall;
     
     @FindBy(id="useremailErr")
     @CacheLookup
     WebElement errText;
     
     
     
//     @FindBy(xpath="//div[@class=\"inbound-popup__content inbound-form\"]")
//     @CacheLookup
//     WebElement errText;
    
	//WebElement sales=driver.findElement(RelativeLocator.with(By.xpath("//a[text(),'Sales Enquiry']")).below(clickOnHelpCenter));
	
     
/*-------------------------------------------Scenario 1------------------------------------------------------------*/
     
     public HelpPageFactory(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 }
     
     public void HoverOnRentOption() {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 Actions act = new Actions(driver);
		 act.moveToElement(rentHeading).build().perform();
	 }
    
	 public void NavigateToFindAgent() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(clickOnFindAgent));
		clickOnFindAgent.click();
	 }
	
	 public void SwitchToFindAgent() {
			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String handle : allWindowHandles) {
			    if (!handle.equals(mainWindowHandle)) {
			        driver.switchTo().window(handle);
			    }
			}
	 }
   
	 public void OpenCityList() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 dropDownList.click();			
		 }
    
	 public void SelectCity() {
    	 Select select = new Select(dropDownList);	
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(dropDownList));
    	 select.selectByVisibleText("Mumbai");		
		 }
	 
	 public List<WebElement> getAgentList() {
		 return agentList;
	 }
  
	 /*--------------------------------------------------------------------------------------------------*/
	 public void ContactAgent() {
		 //contactBtn.click();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(contactBtn));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", contactBtn );
	
	 
	 }	 

   /*-------------------------------------------Scenario 2 ---------------------------------------------------------*/  
     public void HoverOnHelpOption() {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 Actions act = new Actions(driver);
		 act.moveToElement(helpHeading).build().perform();		
	 }
    
     public void NavigateToHelpCenter() {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(clickOnHelpCenter));
 		clickOnHelpCenter.click(); 	  
 	 }
	
	 public void SwitchToHelpCenter() {
			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String handle : allWindowHandles) {
			    if (!handle.equals(mainWindowHandle)) {
			        driver.switchTo().window(handle);
			    }
			}
			closebutton.click();
	 }
		   
	 public void ProvideInput(String input) throws InterruptedException {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(inp));
	 	inp.sendKeys(input);	 		
	 	 }
	
	 public void ClickOnSearch() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
		searchIcon.click();
		 }
	 
	 public String SearchMsg() {	
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));		 
		return errMsg.getText();
		 }

	 
	 /*----------------------------------------Scenario 3---------------------------------*/
	
	 public void ProvideValidInput(String input) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));	    
	 	 inpValid.sendKeys(input);	 		
	 	 }
	     
	 public String SearchKeyword() {
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 	
	     wait.until(ExpectedConditions.visibilityOfAllElements(list));
		return list.getText();
	     }
	   
	 /*----------------------------------------Scenario 4---------------------------------*/
	 
	  public void ProvideName(String name) throws InterruptedException {
		 	// uname.click();	
		  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      wait.until(ExpectedConditions.elementToBeClickable(uname));
	    uname.sendKeys(name);	 		
	 	 }
	  
	  public void ProvideEmail(String email) throws InterruptedException {
		 	//uemail.click();		    
		  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      wait.until(ExpectedConditions.elementToBeClickable(uemail));
		uemail.sendKeys(email);	 		
		 	 }
	    
	  public void ProvidePhone(String phoneno) throws InterruptedException {
		 	//uphone.click();	
		  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      wait.until(ExpectedConditions.elementToBeClickable(uphone));
	    	 uphone.sendKeys(phoneno);	 		
		 	 }
	    
	     public void ClickOnGetContact() {
	    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	 wait.until(ExpectedConditions.elementToBeClickable(cont));
	    	 cont.click();
			 }
	    
	     public String PutOtp() {	
	    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	 wait.until(ExpectedConditions.elementToBeClickable(otp));
				return otp.getText();
			 }
	    
	  /*----------------------------------------Scenario 5---------------------------------*/ 
	     
	     public void NavigateToSalesEnquiry() {	    	 
	    	 JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,6000)");	
				 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.elementToBeClickable(Sales));
				js.executeScript("arguments[0].click();", Sales );
				SwitchToFindAgent();	    
			 } 
	     
	     public void ClickOnRequestCallback() {
	    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	 wait.until(ExpectedConditions.elementToBeClickable(reqbtn));
	    	 reqbtn.click();
			 }
	     
	     public void SubmitCallBack() {
	    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	 wait.until(ExpectedConditions.elementToBeClickable(SubmitCall));
	    	 SubmitCall.click();
			 }
	     public String MessageErr() {
	    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	 wait.until(ExpectedConditions.elementToBeClickable(errText));
	    	 
			return errText.getText();
			 }
}
