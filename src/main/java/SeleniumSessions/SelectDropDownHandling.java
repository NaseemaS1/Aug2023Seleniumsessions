package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// drop down -- htmltag: <select> --> <option>
		// Use Select class
		// single selection
		// multi selection

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");

		By country = By.id("Form_getForm_Country");
		WebElement Country_ele = driver.findElement(country);

		Select select = new Select(Country_ele);
		/*
		 * select.selectByIndex(5);// month:1 to 12 
		 * Thread.sleep(1000);
		 * select.selectByVisibleText("Brazil");
		 *  Thread.sleep(1000);
		 * select.selectByValue("India");
		 */
		
		doSelectDropDownByIndex(country, 5);
		doSelectDropDownByVisibletext(country, "brazil");
	}

				public static WebElement getElement(By locator) {
					return driver.findElement(locator);
				}

	public static void doSelectDropDownByIndex(By locator, int Index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(Index);

	}

	public static void doSelectDropDownByVisibletext(By locator, String Visibletext) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(Visibletext);

	}

	public static void doSelectDropDownByValue(By locator, String Value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(Value);

	}

}
