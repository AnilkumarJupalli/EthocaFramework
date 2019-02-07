package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.RandomGenerator;

public class SignInPageObjects extends PageFactoryInitializer{

	@FindBy(name="email_create")
	public WebElement email;
	
	@FindBy(name="SubmitCreate")
	
	private WebElement createAccount;
	String fname="Test"+RandomGenerator.GenerateRandomSmallLetters(2);
	String lname="Ethoca"+RandomGenerator.GenerateRandomSmallLetters(2);
	String address="Suite 605, 100 Sheppard Ave E, North York";
	String city="QA City";
	String zipcode=RandomGenerator.GenerateRandomNumber(90001,90030);
	String phoneNumber= RandomGenerator.GenerateRandomNumber(10);
	public SignInPageObjects typeIntoEmail() throws Exception
	{   robotScrollDown();
		type(email,RandomGenerator.GenerateRandomEMAILIDs("gmail.com"));
		return this;
	}
	public SignInPageObjects createAccount()
	{
		click(createAccount);return PageFactory.initElements(driver,SignInPageObjects.class);
	}
	//personal information variables 
		@FindBy(xpath="//h3[text()='Your personal information']/..")private WebElement personalInfo;
		@FindBy(name="customer_firstname")private WebElement firstName;
		@FindBy(name="customer_lastname")private WebElement lastName;
		@FindBy(xpath="//input[@type='password']")private WebElement password;
		
		
		public SignInPageObjects FillPersonalInformation()
		{
			type(firstName,fname);
			type(lastName,lname);
			type(password,RandomGenerator.GenerateRandomAlphaNumericCharacters(7));
			return PageFactory.initElements(driver,SignInPageObjects.class);
		}
	
	
	//Addrress information variables 
		
		@FindBy(name="firstname")private WebElement afirstName;
		@FindBy(name="lastname")private WebElement alastName;
		@FindBy(name="address1")private WebElement addressName;
		@FindBy(name="city")private WebElement cityName;
		@FindBy(name="id_state")private WebElement state;
		@FindBy(name="postcode")private WebElement postalCodeName;
		@FindBy(name="id_country")private WebElement country;
		@FindBy(name="phone_mobile")private WebElement phone;
		@FindBy(id="submitAccount") private WebElement register;
		@FindBy(name="processAddress")
		private WebElement ProceedToCheckout;
		public ShippingPage proceedToCheckout()
		{
			click(ProceedToCheckout);
			return PageFactory.initElements(driver,ShippingPage.class);
		}
		@Step("To select the country from the country Dropdown")
		public void selectCountry(String countryName)
		{
			selectByVisibleText(country, countryName);
		}
		@Step("To select the state from the state dropdown")
		public void selectState(String stateName)
		{
			selectByVisibleText(state,stateName);
		}
		
		public SignInPageObjects FillAddressDetails()
		{
			
			type(addressName,address); type(cityName,city);selectState("California");type(postalCodeName,zipcode);
			selectCountry("United States");
			type(phone, phoneNumber);
			click(register);
			return PageFactory.initElements(driver,SignInPageObjects.class);
		}
		
	
	
	
}
