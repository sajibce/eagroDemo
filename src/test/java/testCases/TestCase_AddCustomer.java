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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


public class TestCase_AddCustomer extends Application {

	@Test (priority= 0)
	public void openurl() throws InterruptedException	{
		
		if(this.init()){
			if(this.login(StaticVariables.ADMIN_USER_ID, StaticVariables.ADMIN_USER_PASSWORD)){
//				this.testProcess();
//				addCustomerVerify();
/*				this.driverClose();*/				
			}else{
				System.out.println("Login failed!");
			}
		}else{
			System.out.println("Driver not initialized!");
		}
		
	}

	@Test(priority=1)
	@Override
	public void testProcess() {
		// TODO Auto-generated method stub
		try{
						
			//Load user list page
			driver.get("http://192.168.100.202:8080/unifiedeagro/user/list");
			Thread.sleep(3000);
			System.out.println("User list page");
			
			//popup Create user page
			driver.findElement(By.cssSelector("#body-container > div.common-radius > div.toolPanel.button-toolbar > div > div > a")).click();
			Thread.sleep(3000);
			System.out.println("Create user page loaded");
			
			//add customer/user (popup form)
			driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-comboPanel > div.w2l-sbox-comboPanelHandler.w2l-sbox-inb")).click();
			driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-itemContainer > div > div:nth-child(3) > div")).click();
			Thread.sleep(3000);
			
			
			//Select basic info
			driver.findElement(By.name("firstName")).sendKeys(StaticVariables.customerFirstName);  
			
			driver.findElement(By.name("email")).sendKeys(StaticVariables.email);
			driver.findElement(By.name("userName")).sendKeys(StaticVariables.customerUserName);	// Customer id from Static Variable
			driver.findElement(By.name("password")).sendKeys(StaticVariables.userPwd);
			driver.findElement(By.name("rePassword")).sendKeys(StaticVariables.userPwd);
			
			driver.findElement(By.name("phone")).sendKeys("016666");
			driver.findElement(By.name("address1")).sendKeys("address for selenium"); 
			
			//Scrolling down the page by  1000 pixel vertical	
			JavascriptExecutor js = (JavascriptExecutor) driver;
					
			//dropdown selection for country
			driver.findElement(By.cssSelector("#w2l-sbox-8 > div.w2l-sbox-comboPanel > div.w2l-sbox-comboPanelHandler.w2l-sbox-inb")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#w2l-sbox-8 > div.w2l-sbox-itemContainer > div > div:nth-child(1) > div")).click();
			
			//scroll the main web page till end.		
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	//page scroll
			WebElement elementform = driver.findElement(By.id("frmCreate"));	//form scroll
			
			Coordinates cor=((Locatable)elementform).getCoordinates();
			cor.inViewPort();
			Thread.sleep(3000);
			
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
						 
			//Save and close operation 
			WebElement saveClosebutton = (WebElement) driver.findElement(By.className("btnSaveClose"));
			saveClosebutton.click();
			Thread.sleep(3000);
			
			//form close operation 
			WebElement closebutton = (WebElement) driver.findElement(By.className("btnClose"));
			closebutton.click();
			Thread.sleep(3000);
			
			//Logout
			driver.findElement(By.cssSelector("#header-container > div > a.logout-link")).click();
			Thread.sleep(3000);
			System.out.println("Logout done");
			
			//driver.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
				
	}
	
	//Verify add customer
	@Test(priority =2)
	public void addCustomerVerify(){
		try{
		System.out.println("new customer verification started:");
		driver.get(StaticVariables.baseUrl);
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(StaticVariables.customerUserName);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(StaticVariables.userPwd);
		
		WebElement button = (WebElement) driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button"));
		button.click();
		Thread.sleep(3000);
		
		//view profile
		driver.findElement(By.cssSelector("#header-container > div.inner-header > div > span > a")).click();
		Thread.sleep(3000);
		
		//Assert 
		String actualText = driver.findElement(By.cssSelector("#module-panel > div > div.column.col70 > div > div:nth-child(4) > div.value")).getText();
		Assert.assertEquals(actualText, StaticVariables.customerUserName);
		System.out.println(actualText + " user found");
		
//		
//		if(actualText == StaticVariables.customerUserName)	
//			System.out.println("\nuser found");
//		else
//			System.out.println("\nuser not found");
//				
		
		
		
		
		
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
