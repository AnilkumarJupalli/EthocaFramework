package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

public class CheckoutWizardPageObjects extends PageFactoryInitializer {

	
	@FindBy(xpath="//span[@title='Continue shopping']")
	private WebElement continueShopping;
	
	

@Step("To click on Proceed o Checkout")

public MainPageObjects continueShopping()
{
	click(continueShopping);
	return PageFactory.initElements(driver,MainPageObjects.class);
}
}