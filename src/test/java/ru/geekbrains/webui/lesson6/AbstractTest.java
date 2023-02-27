package ru.geekbrains.webui.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.example.lesson7.MyWebDriverEventListener;
//import ru.geekbrains.webui.lesson7.MyWebDriverEventListener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    static WebDriver webDriver;

    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        //driver = new ChromeDriver(options);   из 5-го урока, заменено

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);    из 5-го урока, заменено

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://www.livejournal.com"),
                "Страница не доступна");
        Assertions.assertTrue(true);
    }

    @BeforeEach
    void getPage(){
        webDriver.get("https://www.livejournal.com");
    }

    @AfterAll
    public static void exit(){

        if(webDriver !=null) webDriver.quit();
    }

    public WebDriver getWebDriver(){
        return this.webDriver;
    }
}

