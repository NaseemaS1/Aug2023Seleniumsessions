package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePAgination {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		
		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		Thread.sleep(5000);
		
		while(true) {
			if(driver.findElements(By.xpath("//td[text()='naseema']")).size()>0) {
				selectCountry("naseema");
				break;
			}
			else {
				WebElement next=driver.findElement(By.linkText("Next"));
				
				if(next.getAttribute("class").contains("disabled")) {
					System.out.println("Pagination is over...country not found");
					break;
					
				}
				next.click();
				Thread.sleep(1000);
			}
		}
	}
	
	
	public static void selectCountry(String countryName) {
		driver.findElement(By.xpath("//td[text()='"+countryName+"']/preceding-sibling::td/input[@type='checkbox']")).click();
				
	}

}
