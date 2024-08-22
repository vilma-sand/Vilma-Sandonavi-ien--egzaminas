package org.Vilma;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    WebElement prisijungimoVardas;
    @FindBy(id = "password")
    WebElement slaptazodis;
    @FindBy(id = "passwordConfirm")
    WebElement pakartotasSlaptazodis;

    @FindBy(xpath = "//button[(@class = 'btn btn-lg btn-primary btn-block')]")
    WebElement buttonSukurti;


    @FindBy(id = "username.errors")
    WebElement errorMessageVartotojui;

    @FindBy(id = "password.errors")
    WebElement errorMessageSlaptazodziui;

    public void enterPrisijungimoVardas(String inputPrisijungimoVardas) {
        prisijungimoVardas.sendKeys(inputPrisijungimoVardas);
    }
    public void enterSlaptazodis(String inputSlaptazodis) {
        slaptazodis.sendKeys(inputSlaptazodis);
    }
    public void enterPakartotasSlaptazodis(String inputPakartotasSlaptazodis) {
        pakartotasSlaptazodis.sendKeys(inputPakartotasSlaptazodis);
    }
    public void clickButtonSukurti() {buttonSukurti.click();}

    public void clickButtonSukurtiAndWaitUrl() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> buttonSukurti.isDisplayed());
        this.buttonSukurti.click();
        wait.until(d -> driver.getCurrentUrl().equals("http://localhost:5173/"));
    }
    public String  getErrorMessageVartotojui() {
        return errorMessageVartotojui.getText();
    }

    public String getErrorMessageSlaptazodziui() {
        return errorMessageSlaptazodziui.getText();
    }

   }