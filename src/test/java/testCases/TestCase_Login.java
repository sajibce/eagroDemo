package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestCase_Login {


	 WebDriver driver;
	
	@Test
	public void openurl()	{
		try{
		driver= new FirefoxDriver();
//		driver= new ChromeDriver();
		
		MethodLoginOperation.loginOperation(driver);

		//driver.close();
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
		

	private void searchFunction() {
		// TODO Auto-generated method stub
		
	}
}
