package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MethodLoginOperation {
	
	static void loginOperation(WebDriver driverB){
		try{
		driverB.get(StaticVariables.baseUrl);
		
		driverB.findElement(By.name("userName")).sendKeys(StaticVariables.ADMIN_USER_ID);
		driverB.findElement(By.name("password")).sendKeys(StaticVariables.ADMIN_USER_PASSWORD);
		WebElement button = (WebElement) driverB.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button"));
		
		button.click();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
