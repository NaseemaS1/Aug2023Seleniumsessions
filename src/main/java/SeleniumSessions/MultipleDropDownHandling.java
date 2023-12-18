package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropDownHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");

		/*
		 * Select select=new Select(driver.findElement(By.xpath("//select")));
		 * if(select.isMultiple()) { System.out.println("yes,it is multiple drop down");
		 * select.selectByVisibleText("American flamingo");
		 * select.selectByVisibleText("Greater flamingo");
		 * select.selectByVisibleText("Lesser flamingo"); }
		 */
		/*
		 * int selectedCount=select.getAllSelectedOptions().size();
		 * System.out.println(selectedCount);
		 * 
		 * Thread.sleep(3000); select.deselectByVisibleText("Lesser flamingo");
		 * Thread.sleep(3000); select.selectByVisibleText("Lesser flamingo");
		 * Thread.sleep(3000);
		 * 
		 * select.deselectAll();
		 */
		By DropdownLocator = By.xpath("//select");
		By optionLocator=By.xpath("//select/option");
		// TC:
		// 1.MULTIPLEvalues
		// selectDropDownMultipleValues(DropdownLocator,optionLocator,"American flamingo" ,"Greater
		// flamingo","Lesser flamingo");
		// 2.single values
		// selectDropDownMultipleValues(DropdownLocator,optionLocator, "American flamingo");
		// 3.all values
		selectDropDownMultipleValues(DropdownLocator,optionLocator, "all");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static boolean isDropDownMultiple(By locator) {
		Select select = new Select(getElement(locator));
		return select.isMultiple() ? true : false;
	}

	public static void selectDropDownMultipleValues(By locator,By optionLocator, String... values) {
		Select select = new Select(getElement(locator));
		if (isDropDownMultiple(locator)) {

			if (values[0].equalsIgnoreCase("all")) {
				List<WebElement> optionsList = driver.findElements(By.xpath("//select/option"));
				for (WebElement e : optionsList) {
					e.click();
				}
			}

			else {

				for (String Value : values) {
					select.selectByVisibleText(Value);
				}
			}
		}
	}
}
