package SeleniumSessions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasics {
	static WebDriver driver;
	
	public static void main(String[] args) {
         
		
		//automaton steps
		//ChromeDriver driver=new ChromeDriver();
		//FirefoxDriver driver=new FirefoxDriver(); 
		//EdgeDriver driver=new EdgeDriver();
		
		
		//cross browser logic-with top casting-parallel testing
		String browser="Chrome";
		switch(browser.toLowerCase().trim()) {
		
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "safari":
			driver=new SafariDriver();
			break;
		default:
			System.out.println("Please pass the right browser");
		    break;
		
		}
		
		
		driver.get("https://www.google.com ");
		String actTitle=driver.getTitle();
		System.out.println("title is:"+actTitle);
		
		if(actTitle.equals("Google")) {
			System.out.println("title is correct --PASS");
		}
		else {
			System.out.println("title is not correct --FAIL");
		}
		
		String appUrl=driver.getCurrentUrl();
		System.out.println(appUrl);
		if(appUrl.contains("goggle")) {
			System.out.println("url is correct ----pass");
		}
		
		String pageSource=driver.getPageSource();
		System.out.println(pageSource);
		if(pageSource.contains("Goggle apps")) {
			System.out.println("Pass");
		}
		
		//driver.quit();
		
		
	}

}
