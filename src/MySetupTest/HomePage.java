package MySetupTest;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HomePage extends TestElement{
	

	
	@BeforeTest

	public void MySetup() throws InterruptedException {
		MyTestA();
}
	

	@Test(priority = 1,enabled = true)
	public void MyTese() throws InterruptedException {
	
		WebElement Loginorregister=driver.findElement(By.linkText("Login or register"));
		Loginorregister.click();
		
		WebElement CountineButton=driver.findElement(By.xpath("//button[@title='Continue']"));
		CountineButton.click();
		
		// elements
		WebElement FirstNInput=driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastNInput=driver.findElement(By.id("AccountFrm_lastname"));
		WebElement InputEmail=driver.findElement(By.id("AccountFrm_email"));
		WebElement AddressInput=driver.findElement(By.id("AccountFrm_address_1"));
		WebElement CountryInput=driver.findElement(By.id("AccountFrm_country_id"));
		WebElement ZoneStateInput = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement PostalInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginName=driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInp=driver.findElement(By.id("AccountFrm_password"));
		WebElement ConfirmPasswordp=driver.findElement(By.id("AccountFrm_confirm"));
		WebElement AgreeAcount=driver.findElement(By.id("AccountFrm_agree"));
		WebElement CountinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		
		
		// Actions 
		FirstNInput.sendKeys(randfirst);
		LastNInput.sendKeys(randlast);
		InputEmail.sendKeys(TheEmail);
		AddressInput.sendKeys("Amman");
		Select CountrySelect=new Select(CountryInput);
		CountrySelect.selectByValue("108");
		Thread.sleep(3000);
		int randzone = rand.nextInt(ZoneStateInput.findElements(By.tagName("option")).size());
		Select InputState = new Select(ZoneStateInput);
		InputState.selectByIndex(randzone);
		CityInput.sendKeys("RandomCity");
		PostalInput.sendKeys("randomPostal");
		LoginName.sendKeys(randfirst+randlast+NumInput);
		PasswordInp.sendKeys(PassWL);
		ConfirmPasswordp.sendKeys(PassWL);
		AgreeAcount.click();
		CountinueButton.click();
		
		
		// Assertion 
		Assert.assertEquals(driver.getCurrentUrl().contains("success"), true);
		Assert.assertEquals(driver.getPageSource().contains("Congratulations"), true);
		WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));
		//Assert.assertEquals(WelcomeMessageArea.getText().contains(randomFirstName), true);
	
	}
	

	@Test(priority = 2,enabled = true)
	public void Logout() {

   driver.navigate().to("https://automationteststore.com/index.php?rt=account/logout");
   
   WebElement LogOutMessage=driver.findElement(By.xpath("//div[@class='contentpanel']"));
   boolean ActualLogout=LogOutMessage.getText().contains("You have been logged off your account.");
   
   Assert.assertEquals(ActualLogout, ExpectedLogoutValue);
   
   		
	}
	
	@Test(priority = 3,enabled = true)
	public void Login() throws InterruptedException {

		Thread.sleep(5000);
		
		WebElement LoginAndReg=driver.findElement(By.linkText("Login or register"));
		LoginAndReg.click();
		
		WebElement LoginName=driver.findElement(By.id("loginFrm_loginname"));
		WebElement Passw=driver.findElement(By.id("loginFrm_password"));	
		WebElement LoginButton=driver.findElement(By.xpath("//button[@title='Login']"));
   
		
		
		LoginName.sendKeys(NameForSignup);
		Passw.sendKeys(PassWL);
		LoginButton.click();
		
		// Assertion 
				WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));

				Assert.assertEquals(WelcomeMessageArea.getText().contains(randfirst ), true);
   		
	}
	
	
	
	@Test(priority = 4)
	public void AddToCart() {
   		
		driver.navigate().to("https://automationteststore.com/");
		
        int totalItems = driver.findElements(By.className("prdocutname")).size();
        int RandItem=rand.nextInt(totalItems);
        
        driver.findElements(By.className("prdocutname")).get(RandItem).click();
       
        if(driver.getCurrentUrl().contains("product_id=116")){
        	
        	driver.findElement(By.id("option344747")).click();	
        	
        }
        
        driver.findElement(By.className("productpagecart")).click();
        
	}
	
	@Test(priority = 5)
	public void CheckOut() throws InterruptedException {
   		
		WebElement CheckOutButton=driver.findElement(By.id("cart_checkout1"));
		CheckOutButton.click();
	
		WebElement ConfirmButton=driver.findElement(By.id("checkout_btn"));
		ConfirmButton.click();
		Thread.sleep(3000);
		
		String ActualValue=driver.findElement(By.className("heading1")).getText();
		String ExpectedValue="YOUR ORDER HAS BEEN PROCESSED!";
		Assert.assertEquals(ActualValue, ExpectedValue);
		
}}
