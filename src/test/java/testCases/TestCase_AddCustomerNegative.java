/*Test Scopes
 * 1. Buttons displayed/exist
 * 2. Buttons Function
 * 3. Duplicate user save check 
 */

package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


public class TestCase_AddCustomerNegative extends Application {

	
//	WebDriver driver;
	
	@Test
	public void addCustomer() throws InterruptedException	{
		
		if(this.init()){
			if(this.login(StaticVariables.ADMIN_USER_ID, StaticVariables.ADMIN_USER_PASSWORD)){
				this.testProcess();
/*				this.driverClose();*/				
			}else{
				System.out.println("Login failed!");
			}
		}else{
			System.out.println("Driver not initialized!");
		}
		
	}
	 
	
	@Override
	public void testProcess() {
		
		try{
						
			//Load user list page
			driver.get(StaticVariables.userListPage);
			Thread.sleep(3000);
			System.out.println("User list page");
			
			//popup Create user page
			driver.findElement(By.cssSelector("#body-container > div.common-radius > div.toolPanel.button-toolbar > div > div > a")).click();
			Thread.sleep(3000);
			System.out.println("Create user page loaded");
			
			//checking mandatory fields
			CommonButtonFunctions.pagescroll(driver);
			CommonButtonFunctions.saveButton(driver);
			CommonButtonFunctions.resetButton(driver);
			CommonButtonFunctions.saveClosebutton(driver);

			//add customer/user (popup form)
			driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-comboPanel > div.w2l-sbox-comboPanelHandler.w2l-sbox-inb")).click();
			driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-itemContainer > div > div:nth-child(3) > div")).click();
			Thread.sleep(3000);

			//Select basic info
			driver.findElement(By.name("firstName")).sendKeys("Selenium Customer1");  
			
			driver.findElement(By.name("email")).sendKeys("sajibce@gmail.com");
			driver.findElement(By.name("userName")).sendKeys("selenium2");		// Customer id
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.name("rePassword")).sendKeys("123456");
			
			driver.findElement(By.name("phone")).sendKeys("016666");
			driver.findElement(By.name("address1")).sendKeys("address for selenium"); 
			
			
					
			//dropdown selection for country
			driver.findElement(By.cssSelector("#w2l-sbox-8 > div.w2l-sbox-comboPanel > div.w2l-sbox-comboPanelHandler.w2l-sbox-inb")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#w2l-sbox-8 > div.w2l-sbox-itemContainer > div > div:nth-child(1) > div")).click();
			
			//Page scroll
			CommonButtonFunctions.pagescroll(driver);
			
			//Select REGION dropdown
			driver.findElement(By.id("regionId")).click();
			Thread.sleep(3000);
			
			//Select REGION/AEZ from dropdown list
			WebElement region = (WebElement) driver.findElement(By.cssSelector("div[title='ACI-AEZ 9']"));
			region.click();
		
			//Select theme dropdown
			driver.findElement(By.id("themeId")).click();
			Thread.sleep(3000);
			
			//Select THEME from dropdown list
			WebElement theme = (WebElement) driver.findElement(By.cssSelector("div[title='Classic']"));
			theme.click();
			
			CommonButtonFunctions.resetButton(driver);
			
//			//Save and close operation 
//			CommonButtonFunctions.saveClosebutton(driver);
			
//			//verify notification message
//			String actual_message = driver.findElement(By.cssSelector(".validation-error > ul:nth-child(1) > li:nth-child(1)")).getText();
//			System.out.println(actual_message +" found");
			

			//form close operation 
			CommonButtonFunctions.closeButton(driver);
			
			//driver.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
