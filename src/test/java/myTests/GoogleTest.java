package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test(priority = 1)
	public void googleTitleTest() {

		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, "Google");
	}

	@Test(priority = 2)
	public void googleURLTest() {
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualUrl);
		Assert.assertTrue(actualUrl.contains("google"));
	}

}
