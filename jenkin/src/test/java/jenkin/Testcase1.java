package jenkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Testcase1 {
	static ExtentReports report;
	static ExtentTest logger;
	static WebDriver driver;
	public static void main(String[] args)
	{
	
	  System.out.println("start");
	  
	  //provide path for generating report
	  String path = "C:\\QAReports\\Report1.html";
   	  report = new ExtentReports(path);
   	  
   	  //call method initalize_driver
	  initialize_driver();
	  
	  //call Launch method
	  Launch("https://login.salesforce.com/");
	  
	  //call mathod Entertext
	  WebElement Uname=driver.findElement(By.id("username"));
	  Entertext(Uname,"username","tr.manjula-kjfb@force.com");
	  /*WebElement Pwd=driver.findElement(By.id("password"));
	  Entertextpassword(Pwd,"pw","helloworld");*/
	  
	  //call method passwordclear
	  WebElement passwordclear=driver.findElement(By.id("password"));
	  passwordclear.clear();
	  
	  //call method Login
	  WebElement login=driver.findElement(By.id("Login"));
	  Login(login,"Login");
	
	}	

	public static void initialize_driver()
	{
    
    System.setProperty("webdriver.chrome.driver", "D:\\chromedrivernew\\chromedriver.exe");
    driver=new ChromeDriver();
	}

	public static void Launch(String url)
	{
		driver.get(url);
		logger = report.startTest("Login to SFDC");

		logger.log(LogStatus.INFO, "salesforce launched successfully");
		logger.log(LogStatus.PASS, "salesforce browser is launched Successfully");
		report.endTest(logger);
		System.out.println("pass:salesforce application is displayed");
	}
	public static void Entertext(WebElement obj,String objName,String textValue)
	{
		
	    obj.sendKeys(textValue);
	    logger = report.startTest("Enter username");
		logger.log(LogStatus.INFO, "username");
		logger.log(LogStatus.PASS, "Username Extered Successfully");
		report.endTest(logger);
		report.flush();
		System.out.println("pass:username is displayed in username field");
	}
	
	/*public static void Entertextpassword(WebElement obj,String objName,String textValue)
	{
		
	    obj.sendKeys(textValue);
	}*/
	public static void passwordclear()
	{
		logger = report.startTest("clear password");
		logger.log(LogStatus.INFO, "password field is clear");
		logger.log(LogStatus.PASS, "password field is empty");
		report.endTest(logger);
		report.flush();
		System.out.println("pass:password field is clear");
	}
	
	public static void Login(WebElement obj,String objName)
	{
		
	    obj.click();
	    logger = report.startTest("click on Login");
		logger.log(LogStatus.INFO, "Login click");
		logger.log(LogStatus.PASS, "Error message is displayed");
		report.endTest(logger);
		report.flush();
		System.out.println("pass:error message is displayed");
		
	}
	
}




