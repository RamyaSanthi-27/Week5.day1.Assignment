package week5.day1.ServiceNowAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.sukgu.Shadow;

public class ServiceNowBaseClass {
	public ChromeDriver driver;
	
	@Parameters({"url","username","password"})
    @BeforeMethod
    public void preCondition(String url,String uname,String pwd) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//1. Launch ServiceNow application
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//2. Login with valid credentials (refer the document to create the instance)
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		//3. Enter Incident in filter navigator and press enter"
		//Using Shadow Root
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[contains(@class,'sn-polaris-navigation polaris-header-menu')]/div[text()='All']").click();
				
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Incident");
		shadow.findElementByXPath("//mark[text()='Incident']").click();

	}
	@AfterMethod
    public void postCondition() {
        driver.close();
    }

}
