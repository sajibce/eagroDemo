/* issue license operation
 * 1. Check button existence
 * 2. check button functions
 * 3. save issue license 
 */

package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.testng.annotations.Test;

public class TestCase_DistributeLicense extends Application {
	
	@Test
	public void distributeLicense() throws InterruptedException	{
		
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
	
		//Method to Scrolling down the page & form
		public void pagescroll(){
			try{
			//Scrolling down the page by 1000 pixel vertical	
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//scroll the main web page till end.		
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	//page scroll
			WebElement elementform = driver.findElement(By.cssSelector("#parentClient > div > div.w2l-sbox-itemContainer "));	//form scroll
			
			Coordinates cor=((Locatable)elementform).getCoordinates();
			cor.inViewPort();
			Thread.sleep(3000);
			}catch (Exception e){
				e.printStackTrace();
			}
		}



	@Override
	public void testProcess() {
		try{
			//Open license page to verify buttons existence and operations
			driver.findElement(By.cssSelector("#header-container > div.inline-itemPanel.top-menu.tac > div:nth-child(3) > a")).click();
			Thread.sleep(3000);
						
			//Assert License Dashboard
			String licensePageLoad = driver.findElement(By.cssSelector("#body-container > div.common-radius > div.breadCrumb > div.tooltip")).getText();
			assertEquals("Licenses Dashboard",licensePageLoad );
			System.out.println(licensePageLoad + " loaded");
			
		//Distribute License popup
			driver.findElement(By.cssSelector("#body-container > div > div.toolPanel.button-toolbar > div > div.buttonOuter.no-leftRadious.no-borderLeft > a")).click();
			Thread.sleep(3000);
			
		//Assert Distribute License popup
			String distLicensePopup = driver.findElement(By.cssSelector("#w2lbox-1 > div.top-left.ui-draggable-handle > div > div > div > div.w2lbox-title")).getText();
			assertEquals("Distribute license",distLicensePopup );
			System.out.println(distLicensePopup + " loaded");
			
			//check mandatory fields
			saveButton();
						
			// check reset button
			resetButton();
			
			//check mandatory fields
			saveClosebutton();
			//Check Close button functions
			closeButton();
			Thread.sleep(2000);
						
			
			//Open license popup to finally Distribute license									
			//Distribute License popup
			driver.findElement(By.cssSelector("#body-container > div > div.toolPanel.button-toolbar > div > div.buttonOuter.no-leftRadious.no-borderLeft > a")).click();
			Thread.sleep(3000);
			
			//Select Customer
			driver.findElement(By.id("parentClient")).click(); 
			Thread.sleep(3000);	
			
			pagescroll();
					
			driver.findElement(By.cssSelector("#parentClient > div > div.w2l-sbox-itemContainer > div > div[title='Email: SQA@email.com'] > div")).click();
			Thread.sleep(3000);
			
			//Select Entrep.
			driver.findElement(By.id("entrepreneur")).click(); 
			Thread.sleep(3000);	
			
			pagescroll();
						
			driver.findElement(By.cssSelector("#entrepreneur > div > div.w2l-sbox-itemContainer > div > div[title='Email: sajibce@gmail.com'] > div")).click();
			
			//Select License package to issue
			driver.findElement(By.id("licensePackage")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#licensePackage > div > div.w2l-sbox-itemContainer > div > div[title='Basic (1 Year) [mrittikā]'] > div")).click();
			Thread.sleep(2000);
									
			//Distribute and Close
//			saveClosebutton();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
