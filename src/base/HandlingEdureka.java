package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

public class HandlingEdureka 
{
	WebDriver driver;
	@BeforeTest
	void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AGRAMIT\\Downloads\\Divya\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.edureka.co/");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Interrupted Exception Occur");
		}
		System.out.println("landed to Edureka portal");
	}

	@Test
	public void Login() throws InterruptedException 
	{
		driver.findElement(By.linkText("Log In")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("si_popup_email")));
		Thread.sleep(2000);
		action.click();
		action.sendKeys("divya9693@gmail.com");
		Thread.sleep(2000);
		action.build().perform();
		
		action.moveToElement(driver.findElement(By.id("si_popup_passwd")));
		Thread.sleep(2000);
		action.click();
		action.sendKeys("Krishna@9693");
		Thread.sleep(2000);
		action.build().perform();
		
		action.moveToElement(driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']")));
		action.click();
		action.build().perform();
	}
	
	@Test
	public void UpdateProfile() throws InterruptedException
	{
	driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).click();
	Thread.sleep(1000);
	//driver.findElement(By.xpath("//ul[@class='dropdown-menu user-menu profile-xs hidden-sm hidden-xs']//*[@id='header-II']")).click();
	driver.findElement(By.xpath("//*[@id='header-II']/section/nav/div/ul[2]/li[1]/ul/li[1]/a")).click();
	
	driver.findElement(By.xpath("//a[@id='professional_details']//i[contains(@class,'icon-pr-edit')]")).click();
	
	//Select sel = new Select(driver.findElement(By.cssSelector("#collapseOne")));
	Select sel = new Select(driver.findElement(By.xpath("//input[contains(@class,'form-control form-element ng-pristine ng-invalid ng-touched')]//input[@id='collapseOne']")));
	sel.selectByVisibleText("Manual Tester");
			
			//*[@id="collapseOne"]/div/div/form/div[4]/input
	////[@text()='Edureka']
	}
}
