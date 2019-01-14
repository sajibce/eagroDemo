package testCases;


import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class TestCase_Config_Region {
	
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
	
	WebElement region;
	
	@Test (priority = 0)
	public void addRegionButtonTest() {
		try{	
			//Country list page
			driver.get(StaticVariables.regionURL);
			Thread.sleep(3000);
			//Create Region popup
			region = (WebElement) driver.findElement(By.cssSelector("#body-container > div.common-radius > "
					+ "div.toolPanel.button-toolbar > div > div > a"));
			region.click();
		
			CommonButtonFunctions.saveClosebutton(driver);
			CommonButtonFunctions.resetButton(driver);
			CommonButtonFunctions.saveButton(driver);
			CommonButtonFunctions.closeButton(driver);
	
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//Add new Region
	@Test (priority = 1)
	public void addRegionTest() {
		try{	
			region = (WebElement) driver.findElement(By.cssSelector("#body-container > div.common-radius > "
					+ "div.toolPanel.button-toolbar > div > div > a"));
			region.click();
			driver.findElement(By.name("name")).sendKeys(StaticVariables.regionName);
			driver.findElement(By.name("code")).sendKeys(StaticVariables.regionCode);
			driver.findElement(By.cssSelector("#w2l-sbox-2 > div > div")).click();
			driver.findElement(By.cssSelector("#w2l-sbox-2 > div.w2l-sbox-itemContainer > div > div:nth-child(4) > div")).click();
			
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
			driver.findElement(By.name("search.name")).sendKeys("AEZ 22");
			Thread.sleep(13000);
		
			String searchText = driver.findElement(By.cssSelector("#module-panel > div > div.grid-contents.table-grid > "
					+ "table > tbody > tr.odd > td:nth-child(2) > div > a")).getText();

			System.out.println(searchText + " found");
			Assert.assertEquals(searchText, StaticVariables.country);
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
		
}
