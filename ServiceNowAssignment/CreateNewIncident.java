package week5.day1.ServiceNowAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewIncident extends ServiceNowBaseClass{
@Test()
		
	public void runCreateNewIncident() throws InterruptedException {
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(10);				
		//handle the frame
		//switch to frame
		WebElement option = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(option);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		//fill the manadatory fields
		shadow.findElementByXPath("//input[@id='incident.short_description']").sendKeys("Create New Option");
		//Get the title
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		//Verify the newly created incident
		if (title.contains("Create")) {
			System.out.println("The incident is created correctly");
		}
		else {
			System.out.println("Incident is not created");
		}
		
		
		
	} 
	

}
/*
 * 1.Create new incident
1. Launch ServiceNow application
2. Login with valid credentials (refer the document to create the instance)
3. Enter Incident in filter navigator and press enter"

4. Click on Create new option and fill the manadatory fields
5. Verify the newly created incident ( copy the incident number and 
paste it in search field and enter then verify the instance number created or not)*/







