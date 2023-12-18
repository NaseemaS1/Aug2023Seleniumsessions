package myTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {

	@Test(priority = 1)
	public void IsOpenCartLogoISVIsibleTest() {

		boolean flag = driver.findElement(By.xpath("/html/body/header/div/div/div[1]/div/a/img")).isDisplayed();
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 3)
	public void openCartTitleTest() {
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, "Your Store");
	}

	@Test(priority = 2)
	public void openCartURLTest() {
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		Assert.assertTrue(actualUrl.contains("opencart"));
	}

	
}
