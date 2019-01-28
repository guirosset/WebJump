package br.com.webjump;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.webjump.domain.Buttons;

public class WebJump {

	private final static String URL = "https://webjump-user.github.io/testqa/";
	
	private WebDriver driver;
	private WebElement btnOne;
	private WebElement btnTwo;
	private WebElement linkFour;

	public void run() {
		
		this.driver = beginDriver();
		Buttons buttons = new Buttons("btn_one", "btn_two", "btn_link");
		ResourceBundle bundle = ResourceBundle.getBundle("messages");	
		
		try {			
			findElements(buttons);
	
			scrollRoll();
	
			boolean btnOneDisplay = btnOne.isDisplayed();
			boolean btnTwoDisplay = btnTwo.isDisplayed();
			boolean linkFourDisplay = linkFour.isDisplayed();
	
			System.out.println(btnOneDisplay);
			System.out.println(btnTwoDisplay);
			System.out.println(linkFourDisplay);
	
			driver.switchTo().frame(0);
			
			findElements(buttons);
			
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

	private void mainTop(ResourceBundle bundle) {
		driver.switchTo().defaultContent();
		driver.findElement(By.id(bundle.getString("name1"))).sendKeys(bundle.getString("name2"));
		driver.findElement(By.id(bundle.getString("reset"))).click();
		driver.findElement(By.id(bundle.getString("option"))).click();
		WebElement checkbox = driver.findElement(By.id(bundle.getString("box")));
		Select select = new Select(checkbox);
		select.selectByIndex(1);
		boolean image = driver.findElement(By.xpath(bundle.getString("image"))).isDisplayed();
		System.out.println(image);
	}

	private void scrollRoll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		sleep(1500);
	}

	private WebDriver beginDriver() {
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}
	
	private void sleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}
	
	private void findElements(Buttons buttons) throws InterruptedException {
		btnOne = driver.findElement(By.id(buttons.getBtnOne()));		
		btnTwo = driver.findElement(By.id(buttons.getBtnTwo()));
		linkFour = driver.findElement(By.id(buttons.getBtnLink()));
		
		btnOne.click();
		btnTwo.click();
		sleep(1000);
		linkFour.click();
	}

}
