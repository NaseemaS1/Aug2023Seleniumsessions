package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	public static void main(String[] args) {


		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		List<WebElement> imaagesList= driver.findElements(By.tagName("img"));
		System.out.println(imaagesList.size());
		for(WebElement e:imaagesList) {
			String altValue=e.getAttribute("alt");
			String srcvalue=e.getAttribute("src");
			System.out.println(altValue+"==="+srcvalue);
		}
	}

}
