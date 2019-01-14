package testCases;


import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class TestCase_Config_UserGroup {
	
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
	public void userGroupTest() {
		try{	
	//User Group list page
	driver.get("http://192.168.100.202:8080/unifiedeagro/userGroup/list");
	Thread.sleep(3000);
	//Create User Group popup
	WebElement userGroup = (WebElement) driver.findElement(By.cssSelector("#body-container > div.common-radius > div.toolPanel.button-toolbar > div > div > a"));
	userGroup.click();

	CommonButtonFunctions.saveClosebutton(driver);
	CommonButtonFunctions.resetButton(driver);
	CommonButtonFunctions.saveButton(driver);
	CommonButtonFunctions.closeButton(driver);

	//Add new user group
	userGroup.click();
	driver.findElement(By.name("name")).sendKeys(StaticVariables.userGroup);
	driver.findElement(By.id("parentUserGroupId")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector("div[title='Staff']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("canGetLicense-0")).click();
	
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
	
			driver.findElement(By.name("search.name")).sendKeys("Staff");
			driver.findElement(By.cssSelector("#body-container > div.common-radius > div.breadCrumb > div.tooltip")).click();
		//	CommonButtonFunctions.kbHit(driver);
		
			Thread.sleep(10000);
		
			String searchText = driver.findElement(By.cssSelector("#module-panel > div > div.grid-contents.table-grid > table > tbody > tr:nth-child(1) > td:nth-child(1) > div > a")).getText();
		
			System.out.println(searchText + " found");
			
			Assert.assertEquals(searchText, "Staff");
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
		
}
