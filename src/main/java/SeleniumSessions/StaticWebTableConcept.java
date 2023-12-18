package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableConcept {
	static WebDriver driver;
	public static void main(String[] args) {


		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		
		int rowcount=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		//contact
		//table[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]/tbody/tr[4]/td[2]
		//*[@id="customers"]/tbody/tr[5]/td[2]
		//*[@id="customers"]/tbody/tr[6]/td[2]
		//*[@id="customers"]/tbody/tr[7]/td[2]
		//country
		//*[@id="customers"]/tbody/tr[2]/td[3]
		//*[@id="customers"]/tbody/tr[3]/td[3]
		//*[@id="customers"]/tbody/tr[4]/td[3]
		//*[@id="customers"]/tbody/tr[5]/td[3]
		//*[@id="customers"]/tbody/tr[6]/td[3]
		//*[@id="customers"]/tbody/tr[7]/td[3]
		
		String beforeXpath="//table[@id=\"customers\"]/tbody/tr[";
		String afterxpath="]/td[2]";
		

		String beforeXpath1="//table[@id=\"customers\"]/tbody/tr[";
		String afterxpath1="]/td[3]";
		
		
		for(int row=2;row<=rowcount;row++) {
			String actXpath=beforeXpath+row+afterxpath;
			//System.out.println(actXpath);
		String ContName=driver.findElement(By.xpath(actXpath)).getText();
		System.out.println(ContName);
		}
		
		for(int row=2;row<=rowcount;row++) {
			String actXpath1=beforeXpath1+row+afterxpath1;
			//System.out.println(actXpath1);
		String CountryName=driver.findElement(By.xpath(actXpath1)).getText();
		System.out.println(CountryName);
		}
		
	}

}
