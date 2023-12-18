package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue) {
		By by = null;
		switch (locatorType.toLowerCase().trim()) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "name":
			by = By.name(locatorValue);
			break;
		case "class":
			by = By.className(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;
		case "css":
			by = By.cssSelector(locatorValue);
			break;
		case "linkText":
			by = By.linkText(locatorValue);
			break;
		case "partialLinkText":
			by = By.partialLinkText(locatorValue);
			break;
		case "tag":
			by = By.tagName(locatorValue);
			break;

		default:
			System.out.println("Wrong locator type is passed:" + locatorType);
			new AutomationException("WRONG LOCATOR TYPE");

		}
		return by;

	}

	public String doGetElementAttribute(By locator, String AttriName) {
		return getElement(locator).getAttribute(AttriName);
	}

	public void doSendKeys(String locatorType, String locatorvalue, String value) {
		getElement(locatorType, locatorvalue).sendKeys(value);
	}

	public void doclick(By locator) {
		getElement(locator).click();
	}

	public void doclick(String locatorType, String locatorvalue) {
		getElement(locatorType, locatorvalue).click();
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doElementGetText(String locatorType, String locatorvalue) {
		return getElement(locatorType, locatorvalue).getText();
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public WebElement getElement(String locatorType, String locatorvalue) {
		return driver.findElement(getBy(locatorType, locatorvalue));

	}

	// **********************Select Drop Down Utils***********************//

	public Select CreateSelect(By locator) {
		Select select = new Select(getElement(locator));
		return select;
	}

	public void doSelectDropDownByIndex(By locator, int Index) {
		// Select select = new Select(getElement(locator));
		CreateSelect(locator).selectByIndex(Index);

	}

	public void doSelectDropDownByVisibletext(By locator, String Visibletext) {

		CreateSelect(locator).selectByVisibleText(Visibletext);

	}

	public void doSelectDropDownByValue(By locator, String Value) {
		CreateSelect(locator).selectByValue(Value);

	}

	public int getDropDownCount(By locator) {
		return CreateSelect(locator).getOptions().size();

	}

	public List<String> getDropDownOption(By locator) {

		List<WebElement> options_List = CreateSelect(locator).getOptions();
		List<String> options_TextList = new ArrayList<String>();
		System.out.println(options_List.size());

		for (WebElement e : options_List) {
			String text = e.getText();
			options_TextList.add(text);

		}
		return options_TextList;
	}

	public void SelectDropDownOption(By locator, String dropDownValue) {

		List<WebElement> options_List = CreateSelect(locator).getOptions();
		System.out.println(options_List.size());

		for (WebElement e : options_List) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("dropDownValue")) {
				e.click();
				break;
			}
		}

	}

	public void selectDropDownValue(By locator, String value) {
		List<WebElement> optionList = driver.findElements(locator);
		for (WebElement e : optionList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	// *****************Actions utils********************//

	public  void doActionsSendKeys(By locator, String value) {

		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();

	}

	public  void doActionsClick(By locator) {

		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();

	}

	public void parentChildMenu(By parentMenuLocator, By ChildMenuLocator) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(getElement(parentMenuLocator)).build().perform();
		Thread.sleep(1000);
		doclick(ChildMenuLocator);

	}

	public void multiMenuHandle(By parentmenuLocator, By firstchildLocator, By SecondMenuLocator, By ThirdMenuLocator)
			throws InterruptedException {

		Actions actions = new Actions(driver);

		doclick(parentmenuLocator);
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(firstchildLocator)).perform();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(SecondMenuLocator)).perform();
		Thread.sleep(1000);
		doclick(ThirdMenuLocator);

	}
	

	public  void doSendKeysWithPause(By locator,String value) {
		Actions act = new Actions(driver);
         char val[]=value.toCharArray();
		
		for(char c:val) {
			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();
		}
}
	
	
	//****************************WaitUtils**************************//
	
	public  WebElement waitForPresenceOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public  WebElement waitForPresenceOfElement(By locator, int timeOut,int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut),Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	public  WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	public  WebElement waitForVisibilityOfElement(By locator, int timeOut,int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut),Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	public  List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public  void DoClickWithWait(By locator, int timeout) {
         waitForVisibilityOfElement(locator, timeout).click();
	}
	
	public  void DoSendKeysWithWait(By locator,String value,int timeout) {
		waitForVisibilityOfElement(locator, timeout).sendKeys(value);
	}

	public  String waitFortitleContains(String titleFraction,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
        	if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
        }
        catch(TimeoutException e) {
        	System.out.println(titleFraction + "title value is not present....");
        	e.printStackTrace();
        }

		return null;
	}
	

	
	public  String waitFortitleIs(String titleFraction,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
        	if (wait.until(ExpectedConditions.titleIs(titleFraction))) {
			return driver.getTitle();
		}
        }
        catch(TimeoutException e) {
        	System.out.println(titleFraction + "title value is not present....");
        	e.printStackTrace();
        }

		return null;
	}

	public  String waitForURLContains(String urlFraction,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
        	if (wait.until(ExpectedConditions.urlToBe(urlFraction))) {
			return driver.getTitle();
		}
        }
        catch(TimeoutException e) {
        	System.out.println(urlFraction + "url value is not present....");
        	e.printStackTrace();
        }

		return null;
	}
	


	
	public  String waitForURLToBe(String urlFraction,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
        	if (wait.until(ExpectedConditions.urlToBe(urlFraction))) {
			return driver.getTitle();
		}
        }
        catch(TimeoutException e) {
        	System.out.println(urlFraction + "url value is not present....");
        	e.printStackTrace();
        }

		return null;
	}
	

	public  Alert waitForJSAlert(int timeout) {

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());	
	}
	
	public  void AcceptJSAlert(int timeout) {
		waitForJSAlert(timeout).accept();
	}
	
	public  void dismissJSAlert(int timeout) {
		waitForJSAlert(timeout).dismiss();
	}
	
	public  String getJSAlertText(int timeout) {
		return waitForJSAlert(timeout).getText();
	}
	public  void enterValueOnJsAlert(int timeout,String value) {
		waitForJSAlert(timeout).sendKeys(value);
	}
	public  void waitForFrameByLocator(By FrameLocator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameLocator));
	}
	public  void waitForFrameByIndex(int frameIndex, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	public  void waitForFrameByIDOrName(String IDOrName, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IDOrName));
	}
	public  void waitForFrameByElement(int frameElement, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public  boolean CheckNewWindowExist(int timeout,int ExpectedNoOfWindows) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		try {
		if(wait.until(ExpectedConditions.numberOfWindowsToBe(timeout))) {
			return true;
		}
		}
		catch(TimeoutException e) {
			System.out.println("windows are not same....");
		}
		return false;
	}
	public void ClickElementWhenReady(By locator,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		try {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}	catch(TimeoutException e) {
		System.out.println("Element is not clickable ");
	}
		
	}
	
	public  WebElement waitForElementWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(intervalTime))
				.withMessage("--time out is done...element is not found....")
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public  void waitForFrameWithFluentWait(String FrameIDOrName, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(intervalTime))
				.withMessage("--time out is done...frame is not found....")
				.ignoring(NoSuchFrameException.class);

		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameIDOrName));
	}

	public  Alert waitForJSAlertWithFluentWait(String FrameIDOrName, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(intervalTime))
				.withMessage("--time out is done...Alert is not appeared....")
				.ignoring(NoAlertPresentException.class);

		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	//****************************Custom wait**********************************//
	
	public  WebElement ReTryingElement(By locator, int timeout) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < timeout) {
			try {
				element = getElement(locator);
				System.out.println("element is found" + locator+ "in attempt" +attempts);
			} catch (NoSuchElementException e) {
				System.out.println("element is not found" + locator + "in attempt" +attempts);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			attempts++;

		}
		
		if(element==null) {
			System.out.println("element is not found..tried for"+timeout+" times " + "with the interval of " +500+ "milliseconds");
			throw new AutomationException("No such element");
		}
		return element;
	}
	public  WebElement ReTryingElement(By locator, int timeout,int intervalTime) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < timeout) {
			try {
				element = getElement(locator);
				System.out.println("element is found" + locator+ "in attempt" +attempts);
			} catch (NoSuchElementException e) {
				System.out.println("element is not found" + locator + "in attempt" +attempts);
				try {
					Thread.sleep(intervalTime);//custom polling time
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			attempts++;

		}
		
		if(element==null) {
			System.out.println("element is not found..tried for"+timeout+" times " + "with the interval of " +500+ "milliseconds");
			throw new AutomationException("No such element");
		}
		return element;
	}

  public boolean isPageLoaded(int timeout) {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
	 String flag= wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'")).toString();
	return Boolean.parseBoolean(flag);
  }
	
	
	
	
	
	
	
	
	
	
	
	
}
