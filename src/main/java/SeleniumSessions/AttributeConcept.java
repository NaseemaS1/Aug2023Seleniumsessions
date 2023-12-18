package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeConcept {
	static WebDriver driver;

	public static void main(String[] args) {

       driver=new ChromeDriver();
       driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
       
       //WebElement + perform action(getAttribute)
       
       By email_id=By.id("input-email");
       By registrationLink=By.linkText("Register");
		/*
		 * String placeholder=driver.findElement(email_id).getAttribute("placeholder");
		 * System.out.println(placeholder);
		 * 
		 * String hrefVal= driver.findElement(registrationLink).getAttribute("href");
		 * System.out.println(hrefVal);
		 * 
		 * String ClassName= driver.findElement(registrationLink).getAttribute("Class");
		 * System.out.println(ClassName);
		 */
		/*
		 * driver.findElement(email_id).sendKeys("Tom@gmail.com"); String
		 * text=driver.findElement(email_id).getAttribute("value");
		 * System.out.println(text);
		 */
       
       String placeholder=doGetElementAttribute(email_id, "placeholder");
       System.out.println(placeholder);
       
       String hrefVal=doGetElementAttribute(registrationLink, "href");
       System.out.println(hrefVal);
       
       String value=doGetElementAttribute(email_id, "value");
       System.out.println(value);
       
       
       
	}
	
	public static String doGetElementAttribute(By locator,String AttriName) {
		return getElement(locator).getAttribute(AttriName);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		
		
	}

	
	

}
