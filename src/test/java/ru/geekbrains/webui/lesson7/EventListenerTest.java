package ru.geekbrains.webui.lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.geekbrains.webui.lesson6.LoginPage;
import ru.geekbrains.webui.lesson6.MainPage;

public class EventListenerTest extends AbstractTest {

    @Test
    void test(){
        try {
            getWebDriver().findElement(By.xpath(".//input[@id='user']"));
        } catch (NoSuchElementException e){
            MyUtils.makeScreenshot(getWebDriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
        }

    }


/*    @Test
    void test2(){
        WebElement webElement = getWebDriver().findElement(By.cssSelector(".sb-icon-search"));
        webElement.click();
    }*/

    @Test
    void loginIn(){
        new MainPage(getWebDriver()).openLoginWindow();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Главное — ЖЖ"), "страница входа недоступна");
        new LoginPage(getWebDriver())
                .setLogin("UnioCornberry")
                .setPassword("KJU1700dartsCOMP")
                .loginIn();
        new MainPage(getWebDriver()).openMyAccountPage();
        Assertions.assertEquals("https://uniocornberry.livejournal.com/",getWebDriver().getCurrentUrl(),"Логин не произведен");

    }

}
