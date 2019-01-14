package testCases;
///*package testCases;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.internal.Coordinates;
//import org.openqa.selenium.interactions.internal.Locatable;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//import org.openqa.selenium.JavascriptExecutor;
//
//
//public class addNewCustomer extends Application {
//
//	
//	WebDriver driver;
//	
//	@Test
//	public void openurl() throws InterruptedException	{
//		
//		if(this.init()){
//			if(this.login()){
//				this.testProcess();
//			}else{
//				System.out.println("Login failed!");
//			}
//		}else{
//			System.out.println("Driver not initialized!");
//		}
//		
//		
//		
//		driver= new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
//		
//		driver.get("http://192.168.100.202:8080/unifiedeagro/auth/login");
//		
//		driver.findElement(By.name("userName")).sendKeys("gisb_sqa@grameen-intel.com");
//		driver.findElement(By.name("password")).sendKeys("AusTin4#");
//		//driver.findElement(By.css("#frmUserLogin>> div:nth-child(4) > button")).click();
//		driver.findElement(By.cssSelector("#frmUserLogin > div > div:nth-child(4) > button")).click();
//		System.out.println("login done");
//		
//		//Load user list page
//		driver.get("http://192.168.100.202:8080/unifiedeagro/user/list");
//		Thread.sleep(3000);
//		System.out.println("User list page");
//		
//		//popup Create user page
//		driver.findElement(By.cssSelector("#body-container > div.common-radius > div.toolPanel.button-toolbar > div > div > a")).click();
//		Thread.sleep(3000);
//		System.out.println("Create user page loaded");
//		
//		//add customer/user (popup form)
//		driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-comboPanel > div.w2l-sbox-comboPanelHandler.w2l-sbox-inb")).click();
//		driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-itemContainer > div > div:nth-child(3) > div")).click();
//		Thread.sleep(3000);
//		/***********
//		//Select basic info
//		driver.findElement(By.name("firstName")).sendKeys("Selenium Customer");
//		
//		driver.findElement(By.name("email")).sendKeys("sajibce@gmail.com");
//		driver.findElement(By.name("userName")).sendKeys("selenium");
//		driver.findElement(By.name("password")).sendKeys("123456");
//		driver.findElement(By.name("rePassword")).sendKeys("123456");
//		
//		driver.findElement(By.name("phone")).sendKeys("016666");
//		driver.findElement(By.name("address1")).sendKeys("address for selenium"); **************/
//		
////Scrolling down the page by  1000 pixel vertical	
//		JavascriptExecutor js = (JavascriptExecutor) driver;
////		
////		js.executeScript("window.scrollBy(0,1000)");
//        
//		//scroll the page till the element is found		
////		 js.executeScript("arguments[0].scrollIntoView();", Element);
//        
////		//scroll the main web page till end.		
////		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//				
////dropdown selection for country
//		driver.findElement(By.cssSelector("#w2l-sbox-8 > div.w2l-sbox-comboPanel > div.w2l-sbox-comboPanelHandler.w2l-sbox-inb")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("#w2l-sbox-8 > div.w2l-sbox-itemContainer > div > div:nth-child(1) > div")).click();
//		
//		
////		//dropdown selection
////		Select drpCountry = new Select(driver.findElement(By.name("country")));
////		drpCountry.selectByVisibleText("Bangladesh");
//		
////dropdown selection for region
////		driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-comboPanel > div.w2l-sbox-input.w2l-sbox-inb")).click();
////		Thread.sleep(3000);
////		driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-itemContainer > div > div.w2l-sbox-cell.w2l-sbox-hover")).click();
//
////		driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-comboPanel > div.w2l-sbox-comboPanelHandler.w2l-sbox-inb")).click();
//		
//		driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-itemContainer > div > div:nth-child(1) > div"));
//		System.out.println("found");
//		
////scroll the main web page till end.		
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	//page scroll
//		WebElement elementform = driver.findElement(By.id("frmCreate"));	//form scroll
////		js.executeScript("arguments[0].scrollIntoView();", element1);
//		Coordinates cor=((Locatable)elementform).getCoordinates();
//		cor.inViewPort();
//		Thread.sleep(3000);
//		
////		driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-comboPanel > div.w2l-sbox-input w2l-sbox-inb")).click();
////		Thread.sleep(3000);
//////Select REGION dropdown///////////
//		driver.findElement(By.id("regionId")).click();
//		Thread.sleep(3000);
//////Select REGION/AEZ from dropdown list///////////
//		 WebElement region = (WebElement) driver.findElement(By.cssSelector("div[title='ACI-AEZ 9']"));
//		 region.click();
//	
//////Select theme dropdown///////////
//		 driver.findElement(By.id("themeId")).click();
//		 Thread.sleep(3000);
//////Select THEME from dropdown list///////////
//		 WebElement theme = (WebElement) driver.findElement(By.cssSelector("div[title='Classic']"));
//		 theme.click();
//		 
//		 
////		WebElement element = driver.findElement(By.className("w2l-sbox-cell w2l-sbox-hover"));
////		WebDriverWait wait = new WebDriverWait(driver, 20); //here, wait time is 20 seconds
////
////		wait.until(ExpectedConditions.visibilityOf(element)); //this will wait for elememt to be visible for 20 seconds
////		element.click(); //now it clicks on element
//		
//		
////		driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-itemContainer > div > div:nth-child(1) > div")).click();
////		driver.findElement(By.xpath("//*[@id=w2l-sbox-11]/div[1]/div[1]")).click();
////		driver.findElement(By.id("regionId")).click();
////		Thread.sleep(3000);
//		
////		driver.findElement(By.cssSelector("#w2l-sbox-11 > div.w2l-sbox-itemContainer > div > div:nth-child(5) > div")).click();
//		
//		
////		WebElement element = driver.findElement(By.xpath("//*[@id='w2l-sbox-11']/div[2]/div/div[1]"));
////		js.executeScript("arguments[0].scrollIntoView();", element);
////		
////		WebElement element1 = driver.findElement(By.className("w2l-sbox-cell"));
////		js.executeScript("arguments[0].scrollIntoView();", element1);
//		
////// Click on an item form dropdown box
////		WebElement mySelectElement = driver.findElement(By.id("regionId"));
////		Select dropdown= new Select(mySelectElement);
////		dropdown.selectByVisibleText("ACI-AEZ 9");
//		
////		w2l-sbox-itemDataContainer
////		driver.findElement(By.xpath("//*[@id='w2l-sbox-11']/div[2]/div/div[1]")).click();
////		driver.findElement(By.className("w2l-sbox-cell")).click();
//		//*[@id="w2l-sbox-11"]/div[2]/div/div[1]/div
//		/*Actions builder = new Actions(driver);
//		builder.moveToElement("tooltip configuration active").perform();
//		builder.moveToElement("administration arrow").click().perform();
//		*/
//		
//		/*
//		//driver.findElement(By.cssSelector("#header-container > > div.inline-item.top-menu.active > a")).click();
//		driver.findElement(By.className("tooltip configuration active")).click();
//		System.out.println("success");
//		*/
//	/*}
//	
//	//////////////add customer//////////
//	
//	public void addCustomer() {
//		*/
//	//	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
//		
//		//driver.findElement(By.cssSelector("#header-container > > div.inline-item.top-menu.active > a")).click();
//		//driver.wait();
//		//driver.findElement(By.xpath("//*[@id='header-container']/div[2]/div[1]/a")).click();
//		//driver.findElement(By.xpath("//*[@id='header-container']/div[2]/div[1]/ul/li[2]/ul/li[3]/a")).click();
//		
//		
//		 WebElement saveClosebutton = (WebElement) driver.findElement(By.className("btnSaveClose"));
//		 saveClosebutton.click();
//		
//	}
//
//	@Override
//	public void testProcess() {
//		// TODO Auto-generated method stub
//		try{
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
//	
//	
//	
//}
//
