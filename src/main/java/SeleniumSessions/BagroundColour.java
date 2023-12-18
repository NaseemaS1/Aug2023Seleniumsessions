package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BagroundColour {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		WebElement element=driver.findElement(By.xpath("//div/input[@value='Login']"));
		
		
		String bgcolor=element.getCssValue("backgroundColor");
		System.out.println(bgcolor);
		
		Rectangle rect=element.getRect();
		System.out.println(rect.getHeight());
		System.out.println(rect.getWidth());
		
		
		System.out.println(rect.getX());
		System.out.println(rect.getY());
		
		int x=element.getLocation().x;
		int y=element.getLocation().y;
	}

}
