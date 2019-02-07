package pageObjects.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.RandomGenerator;

public class MainPageObjects extends PageFactoryInitializer {

	@FindBy(xpath="//a[@title='Women']")
	private WebElement womenTabXpath;
	
	@FindBy(xpath="(//*[text()='Women'])[1]/..//*[text()='Summer Dresses']")
	private WebElement summerDressesXpath;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	private WebElement cartXpath;
	
	@FindBy(xpath="//*[@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']")
	private WebElement itemXpath;
	
	@FindBy(xpath="//a/span[text()='Quick view']")
	private WebElement quickViewXpath;
	
	@FindBy(xpath="//a[@title='Check out']")
	private WebElement checkout;
	@Step("To Hoverover Women Tab")
	public MainPageObjects navigateToWomenTab() 
	{
		utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, womenTabXpath);
		mousehover(womenTabXpath); 
		return this;
	
	}
	
	@Step("click on cart and click on check out ")
	public SummaryPageObjects checkout()
	{		utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, checkout);

		click(checkout);
		return PageFactory.initElements(driver, SummaryPageObjects.class);
	}
	
	@Step("To Click on SummerDresses")
	public MainPageObjects selectSummerDresses()
	{
		utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, summerDressesXpath);
		click(summerDressesXpath);
		return this;
	}
	@Step("Method to Select cart")
	public MainPageObjects  clickCart() throws Exception
	{  
		utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, cartXpath);
		System.out.print(cartXpath.isEnabled());
		moveToElement(cartXpath);//JSclick(cartXpath);
	  mousehover(cartXpath);// click(cartXpath);
		return this;
	}
	
	@Step("To hoverover on the selected item")
	public MainPageObjects selectItem() throws Exception
	{utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, itemXpath);
	robotScrollDown();moveToElement(itemXpath);
	mousehover(itemXpath);
		return this;
	}
	@Step("To click on QuickView")
	public ItemPageObjects quickView()
	{
		utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, quickViewXpath);
		click(quickViewXpath);
		return PageFactory.initElements(driver,ItemPageObjects.class);
	}
	
	
}
