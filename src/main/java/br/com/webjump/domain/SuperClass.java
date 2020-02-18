package br.com.webjump.domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class SuperClass {

    public WebDriver driver;
    public SuperClass(){
        String path = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\main\\resources\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();

        //WebDriver driver = new ChromeDriver();
        driver.get("https://webjump-user.github.io/testqa/");
        driver.manage().window().maximize();
    }
}
