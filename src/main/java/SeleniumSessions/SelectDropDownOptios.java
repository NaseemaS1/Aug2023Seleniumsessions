package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownOptios {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");

		By country = By.id("Form_getForm_Country");
		WebElement Country_ele = driver.findElement(country);
		// Select select = new Select(Country_ele);
		/*
		 * SelectDropDownOption(country, "Brazil");
		 *  SelectDropDownOption(country, "India");
		 *   if(getDropDownOption(country).contains("India")) {
		 * System.out.println("India ----pass"); }
		 */
		int countryCount=getDropDownCount(country)-1;
		if(countryCount==232) {
			System.out.println("pass");
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static int getDropDownCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();

	}

	public static List<String> getDropDownOption(By locator) {
		Select select = new Select(getElement(locator));

		List<WebElement> options_List = select.getOptions();
		List<String> options_TextList=new ArrayList<String>();
		System.out.println(options_List.size());

		for (WebElement e : options_List) {
			String text = e.getText();
			options_TextList.add(text);

		}
		return options_TextList;
	}

	public static void SelectDropDownOption(By locator, String dropDownValue) {
		Select select = new Select(getElement(locator));

		List<WebElement> options_List = select.getOptions();
		System.out.println(options_List.size());

		for (WebElement e : options_List) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("dropDownValue")) {
				e.click();
				break;
			}
		}

	}

}
