package SeleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {

		BrowserUtil brUtil=new BrowserUtil();
		brUtil.LuanchBrowser("chrome");
		brUtil.luanchUrl("https://www.amazon.com/");
		String ActTitle = brUtil.getPageTitle();
		if(ActTitle.equals("Amazon.com. Spend less. Smile more.\r\n")) {
			System.out.println("Title is correct");
		}
		else {
			System.out.println("Title is incorrect");
		}
		
		String URL=brUtil.getPageUrl();
		if(URL.contains("amazon")) {
			System.out.println("URL is correct");
		}
		else {
			System.out.println("URL is incorrect");
		}
		
		brUtil.CloseBrowser();
		
	}

}
