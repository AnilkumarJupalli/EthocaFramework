package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

public class ShippingPage extends PageFactoryInitializer {

	@FindBy(className="carrier_title")
	private WebElement title;
	
	@FindBy(xpath="//div[@id='uniform-cgv']")
	private WebElement termsCheckbox;
	
	@FindBy(name="processCarrier") private WebElement proceedToCheckout;
	
	@Step("")
	public ShippingPage proceedToCheckout()
	{
		proceedToCheckout.click();
		return PageFactory.initElements(driver,ShippingPage.class);
	}
	@Step(" To check the terms and conditions")
	public ShippingPage AcceptConditions()
	{
		if(title.isDisplayed())
			click(termsCheckbox);
		return PageFactory.initElements(driver,ShippingPage.class);
	}


	
}
