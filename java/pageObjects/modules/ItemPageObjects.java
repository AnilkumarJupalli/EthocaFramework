package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

public class ItemPageObjects extends PageFactoryInitializer{

	@FindBy(xpath="//p[@id='product_reference']/span")
	private WebElement productRef;
	@FindBy(name="group_1")
	private WebElement sizeDropdown;
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCart;
	@FindBy(className="fancybox-iframe")
	private WebElement frame;
	
	@Step("To verify product sku")
	public String getProductName() throws Exception
	{
		utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, productRef);
		return getText(productRef);
	}
	@Step("To select specified option")
	public ItemPageObjects selectSize(String size) throws Exception
	{   switchToFrameByWebElement(frame);
		selectByVisibleText(sizeDropdown, size);return this;
	}
	@Step("To click on Add to Cart button")
	public CheckoutWizardPageObjects  AddToCart()
	{utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, addToCart);
		click(addToCart);return PageFactory.initElements(driver,CheckoutWizardPageObjects.class);
	}
	
}
