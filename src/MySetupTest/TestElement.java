package MySetupTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

public class TestElement {
	
	WebDriver driver=new EdgeDriver();
	Random rand=new Random();
	
	
	String [] FNameInput= {
			
			"Amaal",
			"Saja",
			"Sondos"	};
	
   String [] LNameInput= {
			
			"Faisal",
			"Omar",
			"Ziad"	};
	
	
   String PassWL="Amaal8*";
    int randomix=rand.nextInt(FNameInput.length);
    int randoml=rand.nextInt(LNameInput.length);
    
    
	String randfirst=FNameInput[randomix];
	String randlast=LNameInput[randoml];
	
	
	int NumInput=rand.nextInt(9960);
	String TheEmail=randfirst+randlast+NumInput+"@gmail.com";
	String NameForSignup=randfirst+randlast+NumInput;
	
	int randcountry=rand.nextInt(1, 20);
	boolean ExpectedLogoutValue = true ;
	
	
	@BeforeTest
	
	public void MyTestA() {
		
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
	}
	
	

}
