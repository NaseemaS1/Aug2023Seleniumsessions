package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframeHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		// page
		driver.get("https://selectorshub.com/iframe-scenario/");

		Thread.sleep(3000);

		// f1
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("inp_val")).sendKeys("first crush");

		// f2
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys("second crush");

		// f3
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("Destiny");

		// f3-->f1--->notvalid
		// f3-->f2-->f1--->not valid
		// driver.switchTo().frame("pact2");

		// driver.switchTo().frame("pact1");

		/*
		 * driver.switchTo().parentFrame();//f3-->f2
		 * driver.findElement(By.id("jex")).sendKeys("second crush");
		 * 
		 * driver.switchTo().parentFrame();
		 * driver.findElement(By.id("inp_val")).sendKeys("first crush1");
		 */

		driver.switchTo().parentFrame();// f3-->f2
		driver.findElement(By.id("jex")).sendKeys("second crush");

		driver.switchTo().parentFrame();
		driver.findElement(By.id("inp_val")).sendKeys("first crush1");
		//driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		
		String header=driver.findElement(By.tagName("h3")).getText();
		System.out.println(header);

	}

}
