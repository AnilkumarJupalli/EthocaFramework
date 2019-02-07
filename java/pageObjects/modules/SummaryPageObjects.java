package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

public class SummaryPageObjects extends PageFactoryInitializer {

	
	@FindBy(xpath="//tbody/tr/td[@class='cart_description']/small[@class='cart_ref']")
	private static WebElement productDescription;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckout;
	
	@Step("Click on Proceed to Checkout")
	public SignInPageObjects proceedToCheckout() throws Exception
	{   robotScrollDown();
	moveToElement(proceedToCheckout);
		click(proceedToCheckout);
		return PageFactory.initElements(driver,SignInPageObjects.class);
	}
	
	public static  String description() throws Exception
	{  
		return getText(productDescription);
	}
}
