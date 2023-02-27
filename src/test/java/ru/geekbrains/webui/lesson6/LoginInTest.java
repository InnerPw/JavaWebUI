package ru.geekbrains.webui.lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginInTest extends AbstractTest  {

    @Test
    void loginIn(){
        new MainPage(getWebDriver()).openLoginWindow();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Главное — ЖЖ"), "страница входа недоступна");
        new LoginPage(getWebDriver())
                .setLogin("UnioCornberry")
                .setPassword("KJU1700dartsCOMP")
                .loginIn();
        Assertions.assertEquals("https://uniocornberry.livejournal.com/",getWebDriver().getCurrentUrl(),"Логин не произведен");

    }

    @Test
    void loginInSecond(){
        new MainPage(getWebDriver()).openLoginWindow();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Главное — ЖЖ"), "страница входа недоступна");
        new LoginPage(getWebDriver())
                .loginIn("UnioCornberry","KJU1700dartsCOMP");
        Assertions.assertTrue(getWebDriver().findElement(By.cssSelector(".s-header-item--user")).getText().equals("UNIOCORNBERRY"));
    }



    @AfterEach
    void logout(){
        new MainPage(getWebDriver()).openMyAccountPage();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Главное — ЖЖ"), "страница аккаунта не доступна");
        new AccountPage(getWebDriver()).logOut();
        new WebDriverWait(getWebDriver(),Duration.ofSeconds(5));
        Assertions.assertTrue(getWebDriver().findElement(By.cssSelector(".s-header-item__link--login")).getText().equals("Войти"));
    }






}
