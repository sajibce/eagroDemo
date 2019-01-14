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


public class TestCase_AddEntrepreneur extends Application {

	
//	WebDriver driver;
	
	@Test
	public void openurl() throws InterruptedException	{
		
		if(this.init()){
			if(this.login(StaticVariables.ADMIN_USER_ID, StaticVariables.ADMIN_USER_PASSWORD)){
				this.testProcess();
			}else{
				System.out.println("Login failed!");
			}
		}else{
			System.out.println("Driver not initialized!");
		}
/*		this.driverClose(); */
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
			
			//select User Group (dropdown)
			driver.findElement(By.id("userGroupId")).click();
			
			WebElement selectEntrep = (WebElement) driver.findElement(By.cssSelector("div[title='&nbsp;.........Entrepreneur']"));
			selectEntrep.click();
			Thread.sleep(2000);
			
			//select Parent User Group (dropdown)
			driver.findElement(By.id("innerUserGroup")).click();
			
			WebElement parentUserGroup = (WebElement) driver.findElement(By.cssSelector("div[title='Customer']"));
			parentUserGroup.click();
			Thread.sleep(2000);
			
			//select Parent User/customer name  (dropdown)
			driver.findElement(By.id("parentUser")).click();
			
			WebElement parentUserCombo = driver.findElement(By.cssSelector("#parentUser > div > div.w2l-sbox-itemContainer"));
			
			Coordinates cordinate=((Locatable)parentUserCombo).getCoordinates(); 
			cordinate.inViewPort();
			Thread.sleep(3000);
						
			WebElement parentUserItem = (WebElement) driver.findElement(By.cssSelector("div[title='Email: SQA@email.com'] > div"));
			parentUserItem.click();
			Thread.sleep(2000);
			
			//Select basic info
			driver.findElement(By.name("firstName")).sendKeys(StaticVariables.entrepName);
			
			driver.findElement(By.name("email")).sendKeys(StaticVariables.email);
			driver.findElement(By.name("userName")).sendKeys(StaticVariables.entrepUserName);
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
			
			//dropdown selection
			driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-itemContainer > div > div:nth-child(1) > div"));
			System.out.println("found");
			
			//scroll the main web page till end.		
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	//page scroll
			WebElement elementform = driver.findElement(By.id("frmCreate"));	//form scroll
			//js.executeScript("arguments[0].scrollIntoView();", element1);
			
			cordinate=((Locatable)elementform).getCoordinates();
			cordinate.inViewPort();
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
			 
			 // Save and close operation 
			 WebElement saveClosebutton = (WebElement) driver.findElement(By.className("btnSaveClose"));
			 saveClosebutton.click();
			 
			 //Added user verification
			 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	
}
