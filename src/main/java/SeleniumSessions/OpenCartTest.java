package SeleniumSessions;

public class OpenCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BrowserUtil brUtil=new BrowserUtil();
		brUtil.LuanchBrowser("chrome");
		brUtil.luanchUrl("https://naveenautomationlabs.com/opencart/");

		String actTitle=brUtil.getPageTitle();
		if(actTitle.equals("Your Store")) {
			System.out.println("Title is correct---pass");
		}
		else {
			System.out.println("title is incorrect----fail");
		}
		
		String actUrl=brUtil.getPageUrl();
		if(actUrl.contains("opencart")) {
			System.out.println("URL is correct---pass");
			
		}
		else {
			System.out.println("URL is incorrect---fail");
		
		}
		
		brUtil.CloseBrowser();
	}

}
