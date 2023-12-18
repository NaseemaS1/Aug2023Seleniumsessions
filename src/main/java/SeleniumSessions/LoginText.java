package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginText {
	static WebDriver driver;

	public static void main(String[] args) {

       driver=new ChromeDriver();
       driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
       
       
       String Email_id="input-email";
       String password_id="input-password";
       String LoginBtn_xpath="//*[@id=\"content\"]/div/div[2]/div/form/input";
       String register_linkText="Register";
       
       
       ElementUtil eUtil=new ElementUtil(driver);
       eUtil.doSendKeys("id", Email_id, "Test@gmail.com");
       eUtil.doSendKeys("password", password_id, "Test@1234");
       eUtil.doclick("xpath", LoginBtn_xpath);
      String registervalue= eUtil.doElementGetText("linkText", register_linkText);
      System.out.println(registervalue);
       	}

}
