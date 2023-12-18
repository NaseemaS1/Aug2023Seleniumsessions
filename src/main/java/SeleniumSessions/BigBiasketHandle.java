package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBiasketHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		
		By parentShopByMenu=By.xpath("(//span[text()='shop by' or text()='Category'])[2]");
		
		By BeveragesSecondMenu=By.linkText("Beverages");
		By TeaThirdMenu=By.linkText("Tea");
		By Greenteafourthmenu=By.linkText("Green Tea");
	
		multiMenuHandle(parentShopByMenu, BeveragesSecondMenu, TeaThirdMenu, Greenteafourthmenu);
		
	}
	
	public static void multiMenuHandle(By parentmenuLocator,By firstchildLocator,By SecondMenuLocator,By ThirdMenuLocator) throws InterruptedException {
	

		Actions actions=new Actions(driver);
		driver.findElement(parentmenuLocator).click();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(firstchildLocator)).perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(SecondMenuLocator)).perform();
		Thread.sleep(1000);
		driver.findElement(ThirdMenuLocator).click();
		
	}
	
	
	
	

}
