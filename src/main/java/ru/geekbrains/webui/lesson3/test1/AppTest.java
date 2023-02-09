package ru.geekbrains.webui.lesson3.test1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");

        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();
        WebElement webElement2 = driver.findElement(By.xpath(".//input[@id='user']"));
        webElement2.click();
        webElement2.sendKeys("UnioCornberry");
        WebElement webElement3 = driver.findElement(By.xpath(".//input[@id='lj_loginwidget_password']"));
        webElement3.click();
        webElement3.sendKeys("KJU1700dartsCOMP");
        WebElement webElement4 = driver.findElement(By.xpath(".//button[@name='action:login']"));
        webElement4.click();
    }

}
