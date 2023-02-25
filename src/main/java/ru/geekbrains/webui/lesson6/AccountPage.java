package ru.geekbrains.webui.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {


    @FindBy(css = ".s-header-sub-list-item__link--logout")
    private WebElement exit;

    public AccountPage(WebDriver driver){
        super(driver);

    }

    public void logOut(){
        this.exit.click();

    }

}
