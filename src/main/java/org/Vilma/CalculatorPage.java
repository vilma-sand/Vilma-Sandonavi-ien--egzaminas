package org.Vilma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage {
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sk1")
    WebElement pirmasSkaicius;

    @FindBy(id = "sk2")
    WebElement antrasSkaicius;

    @FindBy(xpath = "//option[@value='/']")
    WebElement buttonFunctionDivide;
    @FindBy(xpath = "//input[@value='skaičiuoti']")
    WebElement buttonSkaiciuoti;

    @FindBy(xpath = "//body/h4")
    WebElement fieldAnswer;

    public void setFieldPirmasSkaicius(int pirmasSkaicius) {
        this.pirmasSkaicius.clear();
        this.pirmasSkaicius.sendKeys(Integer.toString(pirmasSkaicius));
    }
    public void setFieldPirmasSkaiciusNetinkamas(int pirmasSkaicius) {
        this.pirmasSkaicius.clear();

    }
    public void setFieldAntrassSkaicius(int antrasSkaicius) {
        this.antrasSkaicius.clear();
        this.antrasSkaicius.sendKeys(Integer.toString(antrasSkaicius));
    }
    public void setButtonFunctionDivide() {
        this.buttonFunctionDivide.click();
    }
    public void setButtonSkaiciuoti() {
        this.buttonSkaiciuoti.click();
    }
    public String getFieldAnswer() {
        return fieldAnswer.getText();
    }
}
