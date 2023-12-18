package TestingSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://naveenautomationlabs.com/opencart/");
	}

	@Test(priority=2)
	public void IsOpenCartLogoISVIsibleTest() {
		boolean flag=driver.findElement(By.xpath("/html/body/header/div/div/div[1]/div/a/img")).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=3)
	public void openCartTitleTest() {
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, "Your Store11");
	}
	@Test(priority=1)
	public void openCartURLTest() {
		String actualUrl=driver.getCurrentUrl();
		System.out.println(actualUrl);
		Assert.assertTrue(actualUrl.contains("opencart"));
	}
	@Test()
	public void aTest() {
		System.out.println("atest");
	}
	@Test()
	public void bTest() {
		System.out.println("btest");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
