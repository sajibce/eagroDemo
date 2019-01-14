package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaticVariables {
	WebDriver driver;
	public static String baseUrl= "http://192.168.100.202:8080/unifiedeagro/auth/login";
		
	public final static String ADMIN_USER_ID = "gisb_sqa@grameen-intel.com"; 
	public final static String ADMIN_USER_PASSWORD = "AusTin4#";
	
	public final static String NON_ADMIN_USER_ID = "selenium1"; 
	public final static String NON_ADMIN_USER_PASSWORD = "123456";
	
	//Add User page
	public static String email = "sajibce@xy.cc";
	public static String customerFirstName = "Selenium Customer";
	public static String customerUserName = "Sel.cus3t";
	
	public static String entrepName= "Selenium Entrep";
	
	
	
	public static String entrepUserName = "sel.ent";
	public static String userPwd = "123456";
	public static String userListPage= "http://192.168.100.202:8080/unifiedeagro/user/list";
	
	//Config> UserGroup
	public static String userGroup = "SQA Group";
	
	//Config> Country
	public static String country = "Italy";
	public static String countryCode = "ITA";
	public static String iSOcode = "999";
	
	//Config> region
	public static String regionURL = "http://192.168.100.202:8080/unifiedeagro/region/list";
	public static String regionName = "Italy";
	public static String regionCode = "ITA";
	
	//Config>mrittika>  Fertilizer Stock
	public static String fertilizerStockURL = "http://192.168.100.202:8080/unifiedeagro/fertilizerStockSetup/list";
	public static String CountrySelect = "http://192.168.100.202:8080/unifiedeagro/region/list";
	public static String regionSelect = "Italy";
	public static String supplierSelect = "ITA";
	public static String xlsFertiStock = "H:\\GISB\\6 Selenium\\test_data\\FertilizerStock.xlsx";
	
}
