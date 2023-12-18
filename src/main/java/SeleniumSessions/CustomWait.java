package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		By ForgotPassword=By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");
		
		ReTryingElement(ForgotPassword, 5,2000).click();	
		
		ElementUtil eleutil=new ElementUtil(driver);
		if(eleutil.isPageLoaded(10)) {
			System.out.println("page is fully loaded");
		}
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}


		
	public static WebElement ReTryingElement(By locator, int timeout) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < timeout) {
			try {
				element = getElement(locator);
				System.out.println("element is found" + locator+ "in attempt" +attempts);
			} catch (NoSuchElementException e) {
				System.out.println("element is not found" + locator + "in attempt" +attempts);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			attempts++;

		}
		
		if(element==null) {
			System.out.println("element is not found..tried for"+timeout+" times " + "with the interval of " +500+ "milliseconds");
			throw new AutomationException("No such element");
		}
		return element;
	}
	public static WebElement ReTryingElement(By locator, int timeout,int intervalTime) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < timeout) {
			try {
				element = getElement(locator);
				System.out.println("element is found" + locator+ "in attempt" +attempts);
			} catch (NoSuchElementException e) {
				System.out.println("element is not found" + locator + "in attempt" +attempts);
				try {
					Thread.sleep(intervalTime);//custom polling time
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			attempts++;

		}
		
		if(element==null) {
			System.out.println("element is not found..tried for"+timeout+" times " + "with the interval of " +500+ "milliseconds");
			throw new AutomationException("No such element");
		}
		return element;
	}

}
