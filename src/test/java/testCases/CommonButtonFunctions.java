package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;

public class CommonButtonFunctions {

//	static WebDriver driver;
	
	
	//Method to Scrolling down the page & form
	public static void pagescroll(WebDriver driverB){
		try{
		//Scrolling down the page by 1000 pixel vertical	
		JavascriptExecutor js = (JavascriptExecutor) driverB;
		
		//scroll the main web page till end.		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	//page scroll
		WebElement elementform = driverB.findElement(By.id("frmCreate"));	//form scroll
		
		Coordinates cor=((Locatable)elementform).getCoordinates();
		cor.inViewPort();
		Thread.sleep(3000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//Method to check refresh the form using Reset
	public static void resetButton(WebDriver driverB){
		try{
		WebElement resetButton = (WebElement) driverB.findElement(By.className("btnReset"));
		// reset button finding
		if(!resetButton.isDisplayed()){
			System.out.println(resetButton + " Not Found");
		} else{
			System.out.println(resetButton + " Found");
		}
			
		
		resetButton.click();
		Thread.sleep(3000);	
		System.out.println("\nReset button works ok");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Method to save the form using Save
	public static void saveButton(WebDriver driverB){
		try{
		//WebElement saveButton = (WebElement) driver.findElement(By.className("btnSubmit"));
		WebElement saveButton = (WebElement) driverB.findElement(By.cssSelector("#frmCreate > div.form-row.marL155 > button.btnSubmit"));
		
		//search for Save Button
		if(!saveButton.isDisplayed()){
			System.out.println("saveButton Not Found");
		} else{
			System.out.println("saveButton  Found");
		}
		
		saveButton.click();
		Thread.sleep(3000);	
		System.out.println("\nSave button works ok");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Method to save the form using Save & Close
	public static void saveClosebutton(WebDriver driverB){
		try{
		WebElement saveClosebutton = (WebElement) driverB.findElement(By.className("btnSaveClose"));
		saveClosebutton.click();
		Thread.sleep(3000);	
		System.out.println("\nSave & Close button works ok");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Method to check close the form using Close
	public static void closeButton(WebDriver driverB){
		try{
		WebElement closeButton = (WebElement) driverB.findElement(By.className("btnClose"));
		closeButton.click();
		Thread.sleep(3000);	
		System.out.println("\nClose button works ok");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Search KBHit
	public static void kbHit(WebDriver driverB){
		try{
		//Assign Keyboard object
		Keyboard keyboard = ((HasInputDevices) driverB).getKeyboard();
		
		//press key enter
		keyboard.pressKey(Keys.ENTER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
