package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BrowserUtil brUtil=new BrowserUtil();
		WebDriver driver=brUtil.LuanchBrowser("chrome");
		brUtil.luanchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		String title=brUtil.getPageTitle();
		System.out.println(title);
		
		By eId = By.id("input-email");
		By pwd = By.id("input-password");
		
	
     ElementUtil Eleutil=new ElementUtil(driver);
            Eleutil.doSendKeys(eId, "naseema@gmail.com");
     
				Eleutil .doSendKeys(pwd, "Test@1234");
				
				brUtil.CloseBrowser();

		
		

	}

}
