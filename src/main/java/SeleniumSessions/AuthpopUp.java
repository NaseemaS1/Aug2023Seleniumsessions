package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthpopUp {

	public static void main(String[] args) {


		WebDriver driver=new ChromeDriver();
		
		String username="admin";
		String password="admin";
		String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
		
		//driver.get("https://" +username + ":" +password + "@" + "the-internet.herokuapp.com/basic_auth");	
		driver.get(URL);
			
	}

}
