package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/slider/default.html\r\n");

		WebElement Slider = driver.findElement(By.id("slider"));

		int Width = Slider.getSize().width;
		System.out.println(Width);

		Actions act = new Actions(driver);
		act.clickAndHold(Slider).moveByOffset((Width/2)-40, 0).build().perform();

	}

}
