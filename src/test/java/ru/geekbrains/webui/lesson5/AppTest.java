package ru.geekbrains.webui.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AppTest {

    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void getPage(){
        driver.get("https://www.livejournal.com");
    }

    @Test
    void test1() throws InterruptedException {

        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();
        Thread.sleep(1000);
        WebElement webElement2 = driver.findElement(By.xpath(".//input[@id='user']"));
        webElement2.click();
        webElement2.sendKeys("UnioCornberry");
        WebElement webElement3 = driver.findElement(By.xpath(".//input[@id='lj_loginwidget_password']"));
        webElement3.click();
        webElement3.sendKeys("KJU1700dartsCOMP");
        webElement3.submit(); //вместо поиска кнопки войти и нажатия на нее, нажатие подтверждения
        WebElement webElement4 = driver.findElement(By.cssSelector(".s-header-item--user"));
        webElement4.click();
        Thread.sleep(2000);
        Assertions.assertEquals("https://uniocornberry.livejournal.com/",driver.getCurrentUrl(),"Логин не произведен");
        driver.navigate().back();
        Thread.sleep(2000);

    }

    @Test
    void test2() throws InterruptedException {

        WebElement webElement5 = driver.findElement(By.linkText("UNIOCORNBERRY"));
        Actions actionProviderMove = new Actions(driver);
        // Performs mouse move action onto the element
        actionProviderMove.moveToElement(webElement5).build().perform();
        WebElement webElement6 = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--settings"));
        webElement6.click();
        Thread.sleep(3000);
        WebElement webElement7 = driver.findElement(By.xpath(".//a[contains(text(),'Редактировать профиль')]"));
        webElement7.click();
        Thread.sleep(3000);
        WebElement webElement8 = driver.findElement(By.xpath(".//form[@action='https://www.livejournal.com/manage/profile/?authas=']"));
        webElement8.click();
        WebElement webElement9 = driver.findElement(By.xpath(".//textarea[@name='journal_title']"));
        webElement9.click();
        webElement9.sendKeys("Почти самый лучший журнал");
        WebElement webElement10 = driver.findElement(By.cssSelector(".b-standout > .b-flatbutton"));
        webElement10.click();
        Thread.sleep(3000);

    }

    @Test
    void test3() throws InterruptedException {

        WebElement webElement11 = driver.findElement(By.cssSelector(".s-header-item-post--long"));
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
    }

    @Test
    void test4() throws InterruptedException {

        WebElement webElement16 = driver.findElement(By.cssSelector(".s-header-item--user"));
        Actions actionProviderMove = new Actions(driver);
        // Performs mouse move action onto the element
        actionProviderMove.moveToElement(webElement16).build().perform();
        WebElement webElement17 = driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        webElement17.click();

    }



/*    @AfterAll
    static void close(){
        driver.quit();
    }*/
}
