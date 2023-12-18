package SeleniumSessions;

public class TopCastingOptions {

	public static void main(String[] args) {

		 //local machine only for the specific browser:valid
		//1.ChromeDriver driver = new ChromeDriver(); 
		
		//valid+recommened :local machine + cross browser
		//WebDriver driver=new ChromeDriver();
		
		
		//valid+not recommened
		//SearchContent driver=new ChromeDriver();
		
		
		//valid+recommened
		//RemoteWebDriver driver=new ChromeDriver();
		
		//valid+recommened:to run tests on grid/remote machine/cloud
		//WebDriver driver= new RemoteWebDriver(ip address of remote machine,capabilities);
		
		
		//valid+not recommened
		//ChromiumDriver driver= new ChromeDriver();
		
	}

}
