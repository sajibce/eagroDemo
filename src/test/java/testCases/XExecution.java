package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class XExecution {
//	WebDriver driverA;	
	/*
	@Test
	public void login()	{
		try{
			driver= new FirefoxDriver();
//			driver= new ChromeDriver();
		
		
			driver.get("http://192.168.100.202:8080/unifiedeagro/auth/login");
			
			driver.findElement(By.name("userName")).sendKeys("gisb_sqa@grameen-intel.com");
			driver.findElement(By.name("password")).sendKeys("AusTin4#");
			
//			driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();
			
			Xoperation.loginButton();
			
		
			//driver.close();
			
			}catch (Exception e){
				e.printStackTrace();
			}
	
		}
	*/
	
	
	
	WebDriver driverA= new FirefoxDriver();
	@Test
	public void login()	{
		try{
			
//			driver= new ChromeDriver();
		
//			driverA.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();
			
			MethodLoginOperation.loginOperation(driverA);
			
		
			//driver.close();
			
			}catch (Exception e){
				e.printStackTrace();
			}
	
		}
	
	
	}
