package tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.AllureListener;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.modules.ShippingPage;
import pageObjects.modules.SummaryPageObjects;
@Listeners({AllureListener.class})
public class EndToEndTest extends PageFactoryInitializer
{   
  
    public SummaryPageObjects summaryPage;
    public ShippingPage ship;
   
	@Test(priority=0,description="To Select items, Add to cart, Proceed to Checkout and place order upon creating account")
	public void ConfirmOrderTest()throws Exception
	{
		mainPage().navigateToWomenTab().selectSummerDresses()
		.selectItem().quickView().selectSize("M").AddToCart().continueShopping();
	     mainPage().clickCart().checkout().proceedToCheckout()
	    .typeIntoEmail().createAccount()
		.FillPersonalInformation().FillAddressDetails().proceedToCheckout().AcceptConditions().proceedToCheckout();
       	Assert.assertEquals("SKU : demo_5", SummaryPageObjects.description());
		
	}
}
