package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisible {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		// driver.get("https://naveenautomationlabs.com/opencart/");
		driver.get("https://classic.freecrm.com/register/");

		/*
		 * WebElement logo=driver.findElement(By.xpath("//img[@title='naveenopencart']"));
		 * System.out.println(logo.isDisplayed()); System.out.println(logo.isEnabled());
		 */
		WebElement submit = driver.findElement(By.id("submitButton"));
		System.out.println(submit.isDisplayed());
		System.out.println(submit.isEnabled());

		boolean f1 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(f1);
		Thread.sleep(2000);
		driver.findElement(By.name("agreeTerms")).click();
		Thread.sleep(2000);
		
		boolean f2 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(f2);

		
		
		
		
		
		

	}

}
