package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

       driver=new ChromeDriver();
       driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
       
       //create the webelement + perform the action(click,Sendkeys,gettext,isDisplayed)
      // driver.findElement(By.id("input-email111")).sendKeys("Test@1234");
       
       //NoSuchelementException:no such elemennt:unable to locate element
       
		/*
		 * int totalBill=123; String totalBillAmount=String.valueOf(totalBill);
		 * driver.findElement(By.id("input-email")).sendKeys(totalBillAmount);
		 */
       
       //driver.findElement(By.id("input-email")).sendKeys(null);
       //IllegalArgumentException: Keys to send should be a not null CharSequence
       
       
       StringBuilder sb=new StringBuilder("test");
      // driver.findElement(By.id("input-email")).sendKeys(sb);
       
       driver.findElement(By.id("input-email")).sendKeys(sb+"Automation");
       
       //charSequence(I)<----StringBuilder,StringBuffer,Strimg
       
	}
	

}
