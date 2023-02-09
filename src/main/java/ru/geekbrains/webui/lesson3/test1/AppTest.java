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

        //Тест 1
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

        //Тест 2
        WebElement webElement5 = driver.findElement(By.cssSelector(".s-header-item--user"));
        webElement5.click();
        WebElement webElement6 = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--settings"));
        webElement6.click();
        WebElement webElement7 = driver.findElement(By.xpath(".//a[contains(text(),'Редактировать профиль')]"));
        webElement7.click();
        WebElement webElement8 = driver.findElement(By.xpath(".//form[@action='https://www.livejournal.com/manage/profile/?authas=']"));
        webElement8.click();
        WebElement webElement9 = driver.findElement(By.xpath(".//textarea[@name='journal_title']"));
        webElement9.click();
        webElement9.sendKeys("Почти самый лучший журнал");
        WebElement webElement10 = driver.findElement(By.cssSelector(".b-standout > .b-flatbutton"));
        webElement10.click();

        //Тест 3
        WebElement webElement11 = driver.findElement(By.cssSelector(".s-header-item-post--short"));
        webElement11.click();
        WebElement webElement12 = driver.findElement(By.cssSelector(".text-0-2-179"));
        webElement12.click();
        webElement12.sendKeys("Самая первая запись");
        WebElement webElement13 = driver.findElement(By.cssSelector(".public-DraftStyleDefault-block"));
        webElement13.click();
        WebElement webElement14 = driver.findElement(By.cssSelector(".backgroundBlue-0-2-104 > .rootIn-0-2-98"));
        webElement14.click();
        WebElement webElement15 = driver.findElement(By.cssSelector(".rootMaxWidth-0-2-99 > .rootIn-0-2-98"));
        webElement15.click();

        //Тест 4
        WebElement webElement16 = driver.findElement(By.cssSelector(".s-header-item--user"));
        webElement16.click();
        WebElement webElement17 = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        webElement17.click();

    }

}
