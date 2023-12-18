package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

public class RelativeLocatorConcept {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();

		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement ele=driver.findElement(By.linkText("Mont Royal, Canada"));
		
		
		//right of ele
		String rightIndex=driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(rightIndex);
		
		//left of ele
		String LefttIndex=driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(LefttIndex);
		
		//above of ele
		String aboveIndex=driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveIndex);
		
		//below of ele
		String belowIndex=driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowIndex);
		
		//near of ele
		String nearIndex=driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(nearIndex);
		
		
		List<WebElement>belowElements=driver.findElements(with(By.xpath("(//div[@id='most_pollutedCitiesRank']/p[2])[1]")).below(ele));
		
		System.out.println(belowElements.size());
		
		for(WebElement e:belowElements) {
			String text=e.getText();
			System.out.println(text);
		}
		
		
	}

}
