package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) {

		
		//findElement:find the single elment+perform the action
		//findElements:find the multiple elements+no action
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		List<WebElement>textFeildList=driver.findElements(By.className("form-control"));
		System.out.println(textFeildList.size());
	}

}
