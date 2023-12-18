package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//driver.get("https://classic.freecrm.com/");
		//driver.get("https://app.hubspot.com/login?hubs_signup-url=www.hubspot.com/&hubs_signup-cta=homepage-nav-login&hubs_content=www.hubspot.com/&hubs_content-cta=homepage-nav-login");
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 /* 
		 * String title=js.executeScript("return document.title").toString();
		 * System.out.println(title);
		 */
		
		JavaScriptUtil jsUtil=new JavaScriptUtil(driver);
		/*
		 * String title=jsUtil.getTitleByJs();
		 *  System.out.println(title);
		 */
		
		/*
		 * String URL=jsUtil.getURLByJs(); 
		 * System.out.println(URL);
		 */
		//jsUtil.generateJSAlert("This is naseema");
		
		/*
		 * String Pagetext=js.executeScript("return document.documentElement.innerText").toString(); 
		 * System.out.println(Pagetext);
		 * if(Pagetext.contains("Alerts & Reminders")) {
		 * System.out.println("Alerts & Reminders----pass"); }
		 */
		/*
		 * Thread.sleep(1000);
		 *  jsUtil.ScrollPageDown(); 
		 *  Thread.sleep(1000);
		 * jsUtil.ScrollPageUp();
		 */
		//WebElement CallsEle=driver.findElement(By.xpath("//*[@id=\"details\"]/div/div/div[1]/div/div[6]/h3"));
		//jsUtil.ScrollIntoView(CallsEle);
		//jsUtil.drawBorder(CallsEle);
		//WebElement loginForm=driver.findElement(By.id("hs-login"));
		//jsUtil.flash(loginForm);
		
		/*
		 * WebElement Username=driver.findElement(By.id("username"));
		 * jsUtil.flash(Username); Username.sendKeys("test123@gmail.com");
		 * 
		 * WebElement pwd=driver.findElement(By.id("password")); jsUtil.flash(pwd);
		 * pwd.sendKeys("test123");
		 */
		
	//	WebElement rem = driver.findElement(By.id("remember"));
//		jsUtil.clickElementByJS(rem);
		
		//WebElement userName = driver.findElement(By.id("input-email"));
		jsUtil.sendKeysUsingWithId("input-email", "tom@gmail.com");

		
		
		
		
		
		
		
		
	}

}
