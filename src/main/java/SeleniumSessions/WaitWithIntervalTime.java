package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWithIntervalTime {

	public static void main(String[] args) {


		


			WebDriver driver = new ChromeDriver();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");


			By emailId = By.id("input-email");
			By pwd = By.id("input-password");
			By loginButton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
			By AboutUS = By.linkText("About Us");

			
			//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			
			WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofSeconds(2));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(emailId)).sendKeys("test@gmail.com");
	}

}
