package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJSPopUpHandling {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts\r\n");
		//1.alertJS popup
		/*
		 * driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		 *  Alert alert=driver.switchTo().alert();
		 * 
		 * String text=alert.getText(); 
		 * System.out.println(text);
		 * 
		 * Thread.sleep(3000);
		 * 
		 * alert.accept();
		 * 
		 * alert.dismiss();
		 */
		
		//2.confirm popup
		/*
		 * driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click(); 
		 * Alert alert=driver.switchTo().alert();
		 * 
		 * System.out.println(alert.getText()); Thread.sleep(3000); alert.dismiss();
		 */
		
		//3.prompt popup
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert alert=driver.switchTo().alert();
		 System.out.println(alert.getText());
		 alert.sendKeys("automation");
		 Thread.sleep(3000);
		 alert.accept();
		
		
	}

}
