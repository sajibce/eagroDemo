package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class XUserLoginVerifydemo extends Application {
	
	/*@Test
	public void openurl() throws InterruptedException	{
		
		if(this.init()){
			//if(this.login(StaticVariables.NON_ADMIN_USER_ID, StaticVariables.NON_ADMIN_USER_PASSWORD)){
				this.testProcess();
			//}else {						
			//	System.out.println("Login failed!");
	//		}
	//	}else{
	//		System.out.println("Driver not initialized!");
		}
		//this.driverClose();
	}
	*/
	
	//verify empty fields/ check mandatory fields
	@Test
	public void tryemptyfield(){
		try{
			System.out.println("\nsubmit empty fields/ check mandatory fields starts :");
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("password")).clear();
			
			driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();;
			Thread.sleep(2000);
			
			String actual_message;
			String expected_message;
			actual_message = driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(1) > div > span:nth-child(2)")).getText();
			System.out.print(actual_message);
			
			//String logincheck = driver.findElement(By.cssSelector("#frmUserLogin > div > div > div > span:nth-child(2)")).getText();
			expected_message= "This field is required.";
								
			if(actual_message == expected_message)
				System.out.println("Mandatory fields highlited");
			else
				System.out.println("Something found wrong");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
		//wrong id & wrong pwd
	@Test
	public void wrongID_pwd(){
	
		try{
			System.out.println("\nwrong id & wrong pwd starts: ");
			String actual_message;
			String expected_message;
			driver.findElement(By.name("userName")).sendKeys("wrongId"); //wrong id 
			driver.findElement(By.name("password")).sendKeys("wrongPwd"); //wrong pwd
						
			driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();;
			Thread.sleep(2000);
			
			actual_message = driver.findElement(By.cssSelector("#login-panel > div ")).getText();
			//String logincheck = driver.findElement(By.cssSelector("#frmUserLogin > div > div > div > span:nth-child(2)")).getText();
			System.out.print("actual_message: "+ actual_message);			
			expected_message= "Login Failed.Please Try Again.";
			Assert.assertEquals(actual_message, expected_message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	
	//valid id & wrong pwd
	@Test
	public void validID_wrongPWD(){
		try{
	
			System.out.println("\nvalid id & wrong pwd starts: ");
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("userName")).sendKeys(StaticVariables.userId); //valid id from Static variables
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys("wrongPwd"); //wrong pwd
			
			driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();;
			Thread.sleep(2000);
			String actual_message;
			String expected_message;
			actual_message = driver.findElement(By.cssSelector("#login-panel > div ")).getText();
			//String logincheck = driver.findElement(By.cssSelector("#frmUserLogin > div > div > div > span:nth-child(2)")).getText();
			expected_message= "Login Failed.Please Try Again.";				
			Assert.assertEquals(actual_message, expected_message);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//wrong id & valid pwd
	@Test
	public void wrongID_validPWD(){
		try{
			System.out.println("\nwrong id & valid pwd starts: ");
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("userName")).sendKeys("wrongId"); //wrong id 
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(StaticVariables.userPwd); //valid pwd
			
			driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();;
			Thread.sleep(2000);
			String actual_message;
			String expected_message;
			actual_message = driver.findElement(By.cssSelector("#login-panel > div ")).getText();
			//String logincheck = driver.findElement(By.cssSelector("#frmUserLogin > div > div > div > span:nth-child(2)")).getText();
			expected_message= "Login Failed.Please Try Again.";				
			Assert.assertEquals(actual_message, expected_message);
			
		} catch (Exception e){
			e.printStackTrace();			
		}
	}
	
	
	//successfull login verification
	@Test
	public void login_verification(){
		try{	
			System.out.println("\nsuccessfull login verification by logout starts: ");
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("userName")).sendKeys(StaticVariables.userId); //valid id
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(StaticVariables.userPwd); //valid pwd
			
			driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();
			Thread.sleep(3000);
			String actual_message;
			String expected_message;
			actual_message = driver.findElement(By.cssSelector("#body-container > div > div > div > a")).getText();
			System.out.println(actual_message + " found");
			expected_message= "Home";
				
			Assert.assertEquals(actual_message, expected_message);
			System.out.println("Successfully loggedin \n");
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//Logout
	public void logout(){
		try{
			driver.findElement(By.cssSelector("#header-container > div > a.logout-link")).click();
			Thread.sleep(3000);
			String actual_message;
			String expected_message;
			
			//driver.findElement(By.cssSelector("#header-container > div > a.logout-link")).click();
			actual_message = driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > a > span")).getText();
			System.out.println(actual_message +" found");
			
			expected_message = "Sign up";        //wrong data
			
			Assert.assertEquals(actual_message, expected_message);{
			System.out.println("logout successfully \n");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void testProcess() {
		try{
			driver.get("http://192.168.100.202:8080/unifiedeagro/auth/login");
			Thread.sleep(3000);
			
			//verify empty fields/ check mandatory fields
			tryemptyfield();
			
			//wrong id & wrong pwd method call
			wrongID_pwd();			
						
			//valid id & wrong pwd
			validID_wrongPWD();
			
			//wrong id & valid pwd
			wrongID_validPWD();	
			
			//successfull login verification
			login_verification();		
			
			//Logout
			logout();								
			
		} catch(Exception e){
			e.printStackTrace();
		
		} 		
		
	}
		
}
