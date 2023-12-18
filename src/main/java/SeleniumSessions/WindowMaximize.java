package SeleniumSessions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowMaximize {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().window().fullscreen();

		driver.get("https://www.amazon.com");
	
	}

}
