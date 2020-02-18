package br.com.webjump;

import java.nio.file.Paths;
import java.util.ResourceBundle;

import br.com.webjump.domain.SuperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;



public class WebJump extends SuperClass {

	ResourceBundle bundle = ResourceBundle.getBundle("messages");

	@FindBy(how = How.ID, using= "btn_one")
	public WebElement btnOne;

	@FindBy(how = How.ID, using= "btn_two")
	public WebElement btnTwo;

	@FindBy(how = How.ID, using= "btn_link")
	public WebElement linkFour;

	@FindBy(how = How.ID, using= "first_name")
	public WebElement fieldFirstName;

	@FindBy(how = How.ID, using= "reset_buttons")
	public WebElement btnReset;

	@FindBy(how = How.ID, using= "opt_three")
	public WebElement optThree;

	public void run() {

		try {			

			scrollRoll();

			Assert.assertTrue(btnOne.isDisplayed());

			//boolean btnOneDisplay = btnOne.isDisplayed();
			boolean btnTwoDisplay = btnTwo.isDisplayed();
			boolean linkFourDisplay = linkFour.isDisplayed();

	
			//System.out.println(btnOneDisplay);
			System.out.println(btnTwoDisplay);
			System.out.println(linkFourDisplay);
	
			driver.switchTo().frame(0);

			sleep(1500);
			
			System.out.println(btnOne.isDisplayed());
			System.out.println(btnTwo.isDisplayed());
			System.out.println(linkFour.isDisplayed());
			
			mainTop(bundle);
	
			sleep(6000);
	
		} catch(InterruptedException ex) {
			System.err.println(ex);
		} finally {
			driver.close();
			driver.quit();
		}
	}

	public void mainTop(ResourceBundle bundle) {
		driver.switchTo().defaultContent();
		fieldFirstName.sendKeys(bundle.getString("name2"));
		btnReset.click();
		optThree.click();
		WebElement checkbox = driver.findElement(By.id(bundle.getString("box")));
		Select select = new Select(checkbox);
		select.selectByIndex(1);
		boolean image = driver.findElement(By.xpath(bundle.getString("image"))).isDisplayed();
		System.out.println(image);
	}

	public void scrollRoll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		sleep(1500);
	}
	/*public WebDriver beginDriver() {
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://webjump-user.github.io/testqa/");
		driver.manage().window().maximize();
		return driver;
	}*/

	public void sleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void findElements() throws InterruptedException {

		btnOne.click();
		btnTwo.click();
		sleep(1000);
		linkFour.click();
	}

}
