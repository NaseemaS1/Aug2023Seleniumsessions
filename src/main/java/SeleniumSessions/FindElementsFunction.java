package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsFunction {

	static WebDriver driver;
	public static void main(String[] args) {


		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		
		By links=By.tagName("a");
		By images=By.tagName("img");
		
		/*
		 * int LinksCount=getElementsCount(links);
		 *  System.out.println(LinksCount); int
		 * ImageCount=getElementsCount(images);
		 *  System.out.println(ImageCount);
		 * 
		 * List<String>actualLinksTextList=getElementTextList(links);
		 * System.out.println(actualLinksTextList);
		 * 
		 * if(actualLinksTextList.contains("Desktops")) {
		 * System.out.println("checkout--pass"); }
		 * if(actualLinksTextList.contains("About Us")) {
		 * System.out.println("checkout---pass"); }
		 */
		List<String>hrefList=getElementsAttributeList(links, "href");
		for(String e:hrefList) {
		System.out.println(e);
		}
		
	}
	//WAf;capture the texts of all the page links and return List<String>
	public static List<String> getElementTextList(By locator) {
		List <WebElement>eleList=getElements(locator);
		List<String>eleTextList=new ArrayList<String>();
		for(WebElement e:eleList) {
			String text=e.getText();
			
			if(text.length()!=0) {
				eleTextList.add(text);
						
			}
			}
		return eleTextList;
	}

	public static List<String>  getElementsAttributeList(By locator,String attrName) {
		List <WebElement>eleList=getElements(locator);
		List<String>eleAttrtList=new ArrayList<String>();
		  for(WebElement e:eleList) {
			String text=e.getText();
			
			if(text.length()!=0) {
				eleAttrtList.add(text);
						
			}
			}
		return eleAttrtList;
	}
	

		
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
		
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
