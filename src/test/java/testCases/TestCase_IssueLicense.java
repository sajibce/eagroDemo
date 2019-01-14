/* issue license operation
 * 1. Check button existence
 * 2. check button functions
 * 3. save issue license 
 */

package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.testng.annotations.Test;

public class TestCase_IssueLicense extends Application {
	
	@Test
	public void openurl() throws InterruptedException	{
		
		if(this.init()){
			if(this.login(StaticVariables.ADMIN_USER_ID, StaticVariables.ADMIN_USER_PASSWORD)){
				this.testProcess();
//				this.driverClose();				
			}else{
				System.out.println("Login failed!");
			}
		}else{
			System.out.println("Driver not initialized!");
		}
		
	}
	
	//Method to check refresh the form using Reset
		public void resetButton(){
			try{
			WebElement resetButton = (WebElement) driver.findElement(By.className("btnReset"));
			// reset button finding
			if(!resetButton.isDisplayed()){
				System.out.println(resetButton + " Found");
			} else{
				System.out.println(resetButton + " Not Found");
			}
				
			
			resetButton.click();
			Thread.sleep(3000);	
			System.out.println("\nReset button works ok");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//Method to save the form using Save
		public void saveButton(){
			try{
			//WebElement saveButton = (WebElement) driver.findElement(By.className("btnSubmit"));
			WebElement saveButton = (WebElement) driver.findElement(By.cssSelector("#frmCreate > div.form-row.marL155 > button.btnSubmit"));
			
			//search for Save Button
			if(!saveButton.isDisplayed()){
				System.out.println("saveButton Found");
			} else{
				System.out.println("saveButton  Not Found");
			}
			
			saveButton.click();
			Thread.sleep(3000);	
			System.out.println("\nSave button works ok");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//Method to save the form using Save & Close
		public void saveClosebutton(){
			try{
			WebElement saveClosebutton = (WebElement) driver.findElement(By.className("btnSaveClose"));
			saveClosebutton.click();
			Thread.sleep(3000);	
			System.out.println("\nSave & Close button works ok");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//Method to check close the form using Close
		public void closeButton(){
			try{
			WebElement closeButton = (WebElement) driver.findElement(By.className("btnClose"));
			closeButton.click();
			Thread.sleep(3000);	
			System.out.println("\nClose button works ok");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	

	@Override
	public void testProcess() {
		try{
			//Open license page to verify buttons existance and operatios
			driver.findElement(By.cssSelector("#header-container > div.inline-itemPanel.top-menu.tac > div:nth-child(3) > a")).click();
			Thread.sleep(3000);
						
			//Assert License Dashboard
			String licensePageLoad = driver.findElement(By.cssSelector("#body-container > div.common-radius > div.breadCrumb > div.tooltip")).getText();
			assertEquals("Licenses Dashboard",licensePageLoad );
			System.out.println(licensePageLoad + " loaded");
			
			//issue License popup
			driver.findElement(By.cssSelector("#body-container > div.common-radius > div.toolPanel.button-toolbar > div > div.buttonOuter.no-radious.no-borderLeft > a")).click();
			Thread.sleep(3000);
			
			//check mandatory fields
			saveButton();
						
			// check reset button
			resetButton();
			
			//check mandatory fields
			saveClosebutton();
			//Check Close button functions
			closeButton();
			Thread.sleep(2000);
			
				
			
			//Open license page to finally issue license									
			//issue License
			driver.findElement(By.cssSelector("#body-container > div.common-radius > div.toolPanel.button-toolbar > div > div.buttonOuter.no-radious.no-borderLeft > a")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("issuedTo")).click(); 
			Thread.sleep(3000);	
			
			//Select Customer
			driver.findElement(By.cssSelector("#issuedTo > div > div.w2l-sbox-itemContainer > div > div[title='Email: ekutir@xy.cc'] > div")).click();
			
			// Select Modules
			driver.findElement(By.id("projectModules")).click();
			Thread.sleep(2000);
			
			WebElement moduleCombo = driver.findElement(By
					.cssSelector("#projectModules > div > div.w2l-sbox-itemContainer > div.w2l-sbox-itemDataContainer > div[title='mrittikā'] > div.w2l-sbox-inb > input"));
			moduleCombo.click();
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("#projectModules > div > div.w2l-sbox-itemContainer > div.w2l-sbox-paginationContainer > button ")).click();
			
			//Select License Type
			driver.findElement(By.id("licenseType")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#licenseType > div > div.w2l-sbox-itemContainer > div > div[title='Basic (1 Year)'] > div")).click();
			
			//No of licenses
			driver.findElement(By.id("numberOfLicenses")).sendKeys("5");
						
			//Issue and Close
//			saveClosebutton();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
