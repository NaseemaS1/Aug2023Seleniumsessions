package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlertConcept {

	static WebDriver driver;
	public static void main(String[] args) {

		 driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts\r\n");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		 
		System.out.println(alert.getText());
		alert.accept();
	}

	
	public static Alert waitForJSAlert(int timeout) {

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());	
	}
	
	public static void AcceptJSAlert(int timeout) {
		waitForJSAlert(timeout).accept();
	}
	
	public static void dismissJSAlert(int timeout) {
		waitForJSAlert(timeout).dismiss();
	}
	
	public static String getJSAlertText(int timeout) {
		return waitForJSAlert(timeout).getText();
	}
	public static void enterValueOnJsAlert(int timeout,String value) {
		waitForJSAlert(timeout).sendKeys(value);
	}
	
	
}
