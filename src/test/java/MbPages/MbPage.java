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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MbPage {
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
 
   
   public MbPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 }
   
  
	 public void HoverOnRentOption() {
		 Actions act = new Actions(driver);
		 act.moveToElement(rentHeading).build().perform();
		 //rentHeading.click();
	 }
    
	 public void NavigateToFindAgent() {
		
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
//			System.out.println(driver.getWindowHandles());
	 }
   
	 public void OpenCityList() {
		 dropDownList.click();
		 }
    
	 public void SelectCity() {
    	 Select select = new Select(dropDownList);	
    	 select.selectByVisibleText("Mumbai");		
		 }
	 
	 public List<WebElement> getAgentList() {
		 return agentList;
	 }
       
	 
	 public void ContactAgent() {
		 //contactBtn.click();

		 JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", contactBtn );
	
	 
	 }	 
}
