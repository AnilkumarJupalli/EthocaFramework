
package pageObjects.initializePageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import controllers.BrowserFactory;
import pageObjects.modules.CheckoutWizardPageObjects;

import pageObjects.modules.ItemPageObjects;
import pageObjects.modules.MainPageObjects;
import pageObjects.modules.ShippingPage;
import pageObjects.modules.SignInPageObjects;



public  class PageFactoryInitializer extends BrowserFactory
{
	
    public MainPageObjects mainPage()
    {
    	return PageFactory.initElements(driver,MainPageObjects.class);
    }
    public ItemPageObjects itemPage()
    {
    	return PageFactory.initElements(driver,ItemPageObjects.class);
    }
    public SignInPageObjects signInPage()
    {
    	return PageFactory.initElements(driver,SignInPageObjects.class);
    }
    public CheckoutWizardPageObjects checkoutPage()
    {
    	return PageFactory.initElements(driver,CheckoutWizardPageObjects.class);
    }

    public ShippingPage shipPage()
    {
    	return PageFactory.initElements(driver,ShippingPage.class);
    }

}
