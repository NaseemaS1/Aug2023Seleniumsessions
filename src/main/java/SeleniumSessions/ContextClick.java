package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightClick_Ele = driver.findElement(By.cssSelector("span.context-menu-one"));

		Actions actions = new Actions(driver);
		actions.contextClick(rightClick_Ele).perform();
		
		List<WebElement>optionsList=driver.findElements(By.cssSelector("li.context-menu-icon"));
		System.out.println(optionsList.size());
		for(WebElement e:optionsList)
		{
			String text=e.getText();
			System.out.println(text);
			if(text.equals("copy")) {
				e.click();
				break;
			}
		}
	}
}
