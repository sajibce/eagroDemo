package testCases;


import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class TestCase_Config_mrittika_FStock {
	
//	WebDriver driver;
	WebDriver driver= new FirefoxDriver();
//	driver= new ChromeDriver();
		
	@Test (priority = 0)
	public void Login()	{
		try{
		MethodLoginOperation.loginOperation(driver);		
		//driver.close();
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	WebElement importPage;
	

	//Add new Region
	@Test (priority = 1)
	public void FertilizerStockTest() {
		try{	
			driver.get(StaticVariables.fertilizerStockURL);
			Thread.sleep(3000);
			
			importPage = (WebElement) driver.findElement(By.cssSelector("#body-container > div > div.toolPanel.button-toolbar > div > div.buttonOuter.no-leftRadious.no-borderLeft > a"));
			importPage.click();
			Thread.sleep(3000);
		
			//select country
			driver.findElement(By.cssSelector("#w2l-sbox-2 > div > div")).click();
			driver.findElement(By.cssSelector("#w2l-sbox-2 > div.w2l-sbox-itemContainer > div > div:nth-child(1) > div")).click();
			
//			//select Region
//			driver.findElement(By.cssSelector("#w2l-sbox-3 > div > div")).click();
//			//driver.findElement(By.cssSelector("#w2l-sbox-3 > div.w2l-sbox-itemContainer > div > div.w2l-sbox-cell.w2l-sbox-hover > div")).click();
//			//Select REGION/AEZ from dropdown list
//			WebElement region = (WebElement) driver.findElement(By.cssSelector("div[title='AEZ 1 RDRS']"));
//			region.click();
//			
//			//select Supplier
//			driver.findElement(By.cssSelector("div[title = 'Type..']")).click();
//			//driver.findElement(By.cssSelector("#w2l-sbox-3 > div.w2l-sbox-itemContainer > div > div.w2l-sbox-cell.w2l-sbox-hover")).click();
//			WebElement supplier = (WebElement) driver.findElement(By.cssSelector("div[title='Email: SQA@email.com,SupplierServer: CSLGSYXI']"));
//			supplier.click();
			
			//Upload xls file for stock
			
			driver.findElement(By.name("importedFile")).sendKeys(StaticVariables.xlsFertiStock);
			
			//Save information
			driver.findElement(By.cssSelector("#frmCreate > div > div.form-row.marL155 > button.btnSubmit")).click();
//			CommonButtonFunctions.closeButton(driver);	
			
	
		}catch (Exception e){
			e.printStackTrace();
		}
		
	
	}
	
	/*
	@Test(priority = 2)
	public void verifySave(){
		try{
		
			System.out.println("inside verify");
			// Search and verify result	
			driver.findElement(By.name("search.name")).sendKeys("AEZ 22");
			Thread.sleep(13000);
		
			String searchText = driver.findElement(By.cssSelector("#module-panel > div > div.grid-contents.table-grid > "
					+ "table > tbody > tr.odd > td:nth-child(2) > div > a")).getText();

			System.out.println(searchText + " found");
			Assert.assertEquals(searchText, StaticVariables.country);
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	*/
		
}
