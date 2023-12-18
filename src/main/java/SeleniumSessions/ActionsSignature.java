package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsSignature {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();

		driver.get("https://signature-generator.com/draw-signature/\r\n");
		
		Thread.sleep(2000);
		
		WebElement Canvas=driver.findElement(By.id("signature-pad"));
		
		Actions act=new Actions(driver);
		
		Action signature=act.click(Canvas)
				.moveToElement(Canvas, 30, 10)
				.clickAndHold(Canvas)
				.moveToElement(Canvas, -200, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(3, 3)
				.release(Canvas)
				.build();
		
		signature.perform();
		
	}

}
