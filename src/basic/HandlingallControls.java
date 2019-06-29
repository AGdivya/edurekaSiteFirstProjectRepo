package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class HandlingallControls {
	WebDriver driver;

	@BeforeTest
	void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AGRAMIT\\Downloads\\Divya\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

		driver.get("https://www.edureka.co/");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Interrupted Exception Occur");
		}
		System.out.println("landed to Edureka portal");
	}

	@Test
	public void SignUp() {
		driver.findElement(By.linkText("Sign Up")).click();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Signup Exception");
		}
		driver.findElement(By.id("sg_popup_email")).click();
		driver.findElement(By.id("sg_popup_email")).sendKeys("divya9693@gmail.com");
		
		driver.findElement(By.id("sg_popup_phone_no")).click();
		driver.findElement(By.id("sg_popup_phone_no")).sendKeys("9764719206");
		
	    Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.id("new_sign_up_mode")));
		action.moveToElement(driver.findElement(By.xpath("//*[@id='new_sign_up_mode']/div/div/div[2]/div[1]/form/button")));
		action.click();
		System.out.println("Passed>>>>>");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//*[@type='password' or @name='data[User][password]']")));
		action1.sendKeys("12345678");
		action1.click();
		System.out.println("Hello");
		
		//*[@id="new_sign_up_mode"]/div/div/div[2]/div[2]/form/button	
	}
	
	
}
