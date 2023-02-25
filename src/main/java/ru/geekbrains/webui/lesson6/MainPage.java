package ru.geekbrains.webui.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage {

    @FindBy(css = ".s-header-item__link--login")
    private WebElement signIn;

    @FindBy(css = ".s-header-item--user")
    private WebElement myPage;

    public MainPage(WebDriver driver){
        super(driver);

    }

    public void openLoginWindow(){
        signIn.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("livejournal.com"));

    }

    public void openMyAccountPage(){
        myPage.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("uniocornberry.livejournal.com"));

    }

}
