package testCases;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestCase_UserLoginVerify {	

	WebDriver driver = new FirefoxDriver();
//	WebDriver driver = new ChromeDriver();


	@BeforeTest
		public void beforeTesting() throws IOException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
		driver.get(StaticVariables.baseUrl);
		
	}
	
	//User_Login_valid_credentials1
	@Test (priority = 0)
		public void User_Login_valid_credentials0() {
		System.out.println("\nUser_Login_valid_credentials: ");
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(StaticVariables.customerUserName); //valid id
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(StaticVariables.userPwd); //valid pwd
		
		driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();
		
		verifyLoginSucess();		
				
		driver.findElement(By.cssSelector("#header-container > div > a.logout-link")).click();
		//Thread.sleep(3000);
	}

	
	//wrongID_validPWD
	@Test(priority = 1)
		public void wrongID_validPWD1() {
		System.out.println("\nwrongID_validPWD starts: ");
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("wrongId"); //wrong id 
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(StaticVariables.userPwd); //valid pwd
		
		driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();;
		//Thread.sleep(2000);
		verifyLoginFailed();
	}

	//validID_wrongPWD0
	@Test (priority = 2)
		public void validID_wrongPWD2() {
		System.out.println("\nvalidID_wrongPWD starts: ");
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys(StaticVariables.customerUserName); //valid id from Static variables
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("wrongPwd"); //wrong pwd
		
		driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();;
		//Thread.sleep(2000);
		
		verifyLoginFailed();
	}
	
	//wrongID_wrongPWD0
	@Test (priority = 3)
	public void wrongID_wrongPWD3() {
		System.out.println("\nwrongID_wrongPWD starts: ");
		
		driver.findElement(By.name("userName")).sendKeys("wrongId"); //wrong id 
		driver.findElement(By.name("password")).sendKeys("wrongPwd"); //wrong pwd
					
		driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();;
		//Thread.sleep(2000);
		
		verifyLoginFailed();
}
	
	//try emptyfield
	@Test (priority = 4)
	public void tryemptyfield4(){
	try{
		System.out.println("\nsubmit empty fields/ check mandatory fields starts :");
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("password")).clear();
		
		driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();;
		Thread.sleep(2000);
		
		String actual_message;
		String expected_message;
		actual_message = driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(1) > div > span:nth-child(2)")).getText();
		System.out.print(actual_message + "\n");
		
		//String logincheck = driver.findElement(By.cssSelector("#frmUserLogin > div > div > div > span:nth-child(2)")).getText();
		expected_message= "This field is required.";
							
		if(actual_message == expected_message)		
			System.out.println("\nMandatory fields highlited");
		else
			System.out.println("\nSomething found wrong");
			
	}catch (Exception e){
		e.printStackTrace();
		}
	}
	
	
		//login Success verification
		public void verifyLoginSucess() {
		String actual_Text = driver.findElement(By.cssSelector("#body-container > div > div > div > a")).getText();
		Assert.assertEquals(actual_Text, "Home");
		System.out.println(actual_Text + " page found");
		
		System.out.println("Successfully loggedin \n");
		}	
	
		//login failed verification
		public void verifyLoginFailed() {
		String errorText = driver.findElement(By.cssSelector("#login-panel > div ")).getText();
		Assert.assertEquals(errorText, "Login Failed.Please Try Again.");
		System.out.println("error text found: " + errorText);
	}
	
	@AfterTest
	public void afterTesting() throws InterruptedException {
		Thread.sleep(3000);
		//driver.close();
	}
}





