package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public abstract class Application {
	protected WebDriver driver= null;

	public boolean init(){
		
		boolean isInitialized = false;
		
		try{
			this.driver= new FirefoxDriver();
			this.driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
			isInitialized = true;
		}catch(Exception e){
			e.printStackTrace();
			isInitialized = false;
		}
		return isInitialized;
	}


	public boolean login(String userID, String password) {
		boolean isLoggedIn = false;
		
		try{
			this.driver.get("http://192.168.100.202:8080/unifiedeagro/auth/login");
			
			driver.findElement(By.name("userName")).sendKeys(userID); //"gisb_sqa@grameen-intel.com"
			driver.findElement(By.name("password")).sendKeys(password); //"AusTin4#"
		
			driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();
			Thread.sleep(3000);
			if(driver.findElement(By.cssSelector("#header-container > div.inner-header > a.logout-link"))!= null ) {
				
				System.out.println("login done");
				isLoggedIn = true;
				
			}else {
				
				System.out.println("login fail");
				isLoggedIn = false;
			}
			
			
						
		}catch(Exception e){
			
			System.out.println("login fail");
			isLoggedIn = false;
			e.printStackTrace(); 
		}
		return isLoggedIn;
	
	}
	
	
	
	public abstract void testProcess();
	
	
	/*
	public boolean driverClose(){
		boolean isdriverClose = false;
			
		try{			
			this.driver.findElement(By.cssSelector("#header-container > div.inner-header > a.logout-link")).click();
			Thread.sleep(5000);
			driver.close();
			isdriverClose = true;
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return isdriverClose;
	}
	*/




}
