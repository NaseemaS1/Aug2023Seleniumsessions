package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowhandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();

		// fetch the window
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parentWimdowId = it.next();
		System.out.println("Parent Window ID:"+parentWimdowId);
		
		String ChildWindowId=it.next();
		System.out.println("Child Window Id"+ChildWindowId);
		
		//Switching work
		driver.switchTo().window(ChildWindowId);
		System.out.println("Child Window URL: "+driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentWimdowId);
		System.out.println("parent window URL"+driver.getCurrentUrl());
		driver.quit();
		
  	}

}
