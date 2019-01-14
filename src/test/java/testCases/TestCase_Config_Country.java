package testCases;


import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class TestCase_Config_Country {
	
//	WebDriver driver;
	WebDriver driver= new FirefoxDriver();
//	driver= new ChromeDriver();
		
	@Test (priority = 0)
	public void Login()	{
		try{
		MethodLoginOperation.loginOperation(driver);		
		//driver.close();
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test (priority = 1)
	public void addCountryTest() {
		try{	
	//Country list page
	driver.get("http://192.168.100.202:8080/unifiedeagro/country/list");
	Thread.sleep(3000);
	//Create Country popup
	WebElement country = (WebElement) driver.findElement(By.cssSelector("#body-container > div.common-radius > div.toolPanel.button-toolbar > div > div > a"));
	country.click();

	CommonButtonFunctions.saveClosebutton(driver);
	CommonButtonFunctions.resetButton(driver);
	CommonButtonFunctions.saveButton(driver);
	CommonButtonFunctions.closeButton(driver);

	//Add new Country
	country.click();
	driver.findElement(By.name("name")).sendKeys(StaticVariables.country);
	driver.findElement(By.name("code")).sendKeys(StaticVariables.iSOcode);
	driver.findElement(By.name("countryCode")).sendKeys(StaticVariables.countryCode);
		
	
	//Save information
//	CommonButtonFunctions.saveClosebutton(driver);
	CommonButtonFunctions.closeButton(driver);	
	
	

		}catch (Exception e){
			e.printStackTrace();
		}
		
	
	}
	
	
	@Test(priority = 2)
	public void verifySave(){
		try{
		
			System.out.println("inside verify");
			// Search and verify result	
			driver.findElement(By.name("search.name")).sendKeys(StaticVariables.country);
			Thread.sleep(13000);
		
			String searchText = driver.findElement(By.cssSelector("#module-panel > div > div.grid-contents.table-grid > "
					+ "table > tbody > tr > td:nth-child(2) > div > a")).getText();

			System.out.println(searchText + " found");
			Assert.assertEquals(searchText, StaticVariables.country);
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
		
}
