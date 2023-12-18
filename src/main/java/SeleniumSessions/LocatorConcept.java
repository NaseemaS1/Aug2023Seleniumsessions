package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//1.id is an attribute:unique
		//driver.findElement(By.id("input-email")).sendKeys("Test@gmail.com");
		
		//2.name:is an atribute:can be duplicate
		//driver.findElement(By.name("email")).sendKeys("Test@gmail.com");
		
		//3.ClassName:is an atrribute:is dulicate
		//driver.findElement(By.className("form-control")).sendKeys("Test@gmail.com");
		
		//4,xpath:not an atteibuter:adress of the element in the HTML dom
		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("Test@gmail.com");
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Test@1234");
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		/*
		 * By eId=By.id("input-email"); By pwd=By.id("input-password"); By
		 * loginBtn=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
		 * 
		 * doSendKeys(eId, "Test@gmail.com"); doSendKeys(pwd, "Test@1234");
		 * doclick(loginBtn);
		 */
		
		//5.css selector:not an attribute
		/*
		 * driver.findElement(By.cssSelector("#input-email")).sendKeys("Test@gmail.com")
		 * ;
		 * driver.findElement(By.cssSelector("#input-password")).sendKeys("Test@1234");		
		 *  * driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click(
		 * );
		 */
		/*
		 * By emailId=By.cssSelector("#input-email"); By
		 * password=By.cssSelector("#input-password"); By loginbtn=By.
		 * cssSelector("#content > div > div:nth-child(2) > div > form > input");
		 * 
		 * doSendKeys(emailId, "Test@gmail.com"); doSendKeys(password, "Test@1234");
		 * doclick(loginbtn);
		 */
		
		//6.linktext:only for links:not an attribute
		
	 // driver.findElement(By.linkText("Register")).click();
		
//		/*
//		 * By registerLink=By.linkText("Register");
//		 * 
//		 * doclick(registerLink);
//		 */  
		
		//7.partiallinkatext:only for links
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		//forgotten password
		//Fprgotten userId
		
		//8.tagName:html tag
		/*
		 * String header=driver.findElement(By.tagName("h2")).getText();
		 * System.out.println(header);
		 */
		/*
		 * By header=By.tagName("h2"); String headerValue=doElementGetText(header);
		 * if(headerValue.equals("New Customer")) {
		 * System.out.println("header is correct---pass"); } else {
		 * System.out.println("FAil"); }
		 * 
		 */

		By lodgoImage=By.className("img-responsive");
		doclick(lodgoImage);
		
		
		//id-1
		//name-2
		//classname-3
		
		//xpath
		//css
		
		//linktext
		//partiallinktext
		
		//tagname
		
		//id--->#
		//class---->.
	}
	
	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static void doclick(By locator) {
		getElement(locator).click();
	}
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		
		
	}


}

