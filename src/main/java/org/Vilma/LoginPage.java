package org.Vilma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Sukurti naują paskyrą']")
    WebElement sukurtiNaujaPaskyra;

    @FindBy(name = "username")
    WebElement prisijungimoVardas;
    @FindBy(name = "password")
    WebElement slaptazodis;

    @FindBy(xpath = "//button[(@class = 'btn btn-lg btn-primary btn-block')]")
    WebElement buttonPrisijungti;



    public void paspaustiSukurtiNaujaPaskyra() {
       sukurtiNaujaPaskyra.click();
   }
    public void enterPrisijungimoVardas(String inputPrisijungimoVardas) {
        prisijungimoVardas.sendKeys(inputPrisijungimoVardas);
    }
    public void enterSlaptazodis(String inputSlaptazodis) {
        slaptazodis.sendKeys(inputSlaptazodis);
    }
    public void setButtonPrisijungti() {
            this.buttonPrisijungti.click();
        }
    public void clickSukurtiNaujaPaskyraAndWaitUrl() {
        this.sukurtiNaujaPaskyra.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.getCurrentUrl().equals("http://localhost:8080/registruoti"));
    }
}