package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMultipleText {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		driver.findElement(By.xpath("(//span[text()='shop by' or text()='Category'])[2]")).click();
		Thread.sleep(1000);
		
		Actions action = new Actions(driver);


		
		List<WebElement> mainCategory = driver.findElements(By.xpath("(//div[contains(@id,'headlessui-menu-items')]/nav/ul[1])[2]/li"));
		System.out.println("All available main category products type count: "+mainCategory.size());

		for (WebElement item : mainCategory) {
			action.moveToElement(item).perform();
			System.out.println(item.getText());
			
				List<WebElement> itemCategory = driver.findElements(By.xpath("(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[2])[2]/li"));
				System.out.println("Sub Category Item Count: "+itemCategory.size());
				
				for (WebElement itemCat : itemCategory) {
					action.moveToElement(itemCat).perform();
					System.out.println(itemCat.getText());
				
					List<WebElement> itemSubCategory = driver.findElements(By.xpath("(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[3])[2]/li"));
					System.out.println("Final sub category item count:"+itemSubCategory.size());
					
						for (WebElement itemSub : itemSubCategory) {
							//action.moveToElement(itemSub).perform();
							System.out.println(itemSub.getText());
						}
			}

		}

		/*
		 * for(int i=0;i<mainCategory.size();i++) { List<WebElement> itemCategory =
		 * driver.findElements(By.xpath(
		 * "(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[2])[2]/li"));
		 * 
		 * }
		 */

		// driver.findElements(By.xpath("(//div[contains(@id,'headlessui-menu-items')]/nav/ul[1])[2]/li)/a"))

		// System.out.println(item.getText());

		/*
		 * 
		 * System.out.println(secondCategory.size());
		 * 
		 * for (WebElement item : secondCategory) {
		 * 
		 * System.out.println(item.getText()); }
		 * 
		 * System.out.println(thirdCategory.size());
		 * 
		 * for (WebElement item : thirdCategory) {
		 * 
		 * System.out.println(item.getText()); }
		 */

		/*
		 * List<WebElement> mainCategory = driver.findElements(By.xpath(
		 * "(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[1])[2]/li"));
		 * List<WebElement> secondCategory = driver.findElements(By.xpath(
		 * "(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[2])[2]/li"));
		 * List<WebElement> thirdCategory = driver.findElements(By.xpath(
		 * "(//div[contains(@id,'headlessui-menu-items-')]/nav/ul[3])[2]/li"));
		 */

		driver.quit();

	}

}
