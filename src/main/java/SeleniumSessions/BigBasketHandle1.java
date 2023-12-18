package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketHandle1 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//span[text()='shop by' or text()='Category'])[2]")).click();
		Thread.sleep(2000);
		
		Actions act=new Actions(driver);

		List<WebElement> mainCategory = driver.findElements(By.xpath("(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[1])[2]/li"));
		System.out.println(mainCategory.size());
		// List<WebElement>itemCategory=driver.findElements(By.xpath("(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[2])[2]"));
		// System.out.println(itemCategory.size());

		// List<WebElement>itemSubCategory=driver.findElements(By.xpath("(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[3])[2]"));
		// System.out.println(itemSubCategory.size());
		for (WebElement e : mainCategory) {
			act.moveToElement(e).perform();
			System.out.println(e.getText());

			List<WebElement>itemCategory=driver.findElements(By.xpath("(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[2])[2]/li"));
			System.out.println(itemCategory.size());
			for (WebElement eitem : itemCategory) {
				act.moveToElement(eitem).perform();
				System.out.println(eitem.getText());

				List<WebElement>itemSubCategory=driver.findElements(By.xpath("(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[3])[2]/li"));
				System.out.println(itemSubCategory.size());
				for (WebElement eSubitem : itemSubCategory) {
					act.moveToElement(eSubitem).perform();
					System.out.println(eSubitem.getText());
				}
			}
			
			

		}
	}

}
