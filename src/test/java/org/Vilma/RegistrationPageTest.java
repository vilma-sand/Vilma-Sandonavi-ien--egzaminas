package org.Vilma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


import static org.junit.jupiter.api.Assertions.*;

public class RegistrationPageTest extends BasePageTest {
    RegistrationPage registrationPage;

    String inputPrisijungimoVardas = "Vilma1";
    String inputSlaptazodis = "Vilmute";
    String inputPakartotasSlaptazodis = "Vilmute";

    public void registrationSteps(String inputPrisijungimoVardas, String inputSlaptazodis, String inputPakartotasSlaptazodis) {
        registrationPage = new RegistrationPage(driver);

        registrationPage.enterPrisijungimoVardas(inputPrisijungimoVardas);
        registrationPage.enterSlaptazodis(inputSlaptazodis);
        registrationPage.enterPakartotasSlaptazodis(inputPakartotasSlaptazodis);
        registrationPage.clickButtonSukurti();
    }

    @Tag("HappyTest")
    @Test
    void PositiveRegistrationForm() {
        registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickSukurtiNaujaPaskyraAndWaitUrl();

        registrationSteps(inputPrisijungimoVardas, inputSlaptazodis, inputPakartotasSlaptazodis);

        // assertTrue(driver.getPageSource().contains("You have registered successfully. You can now log in"), "Success message is not as expected");
        assertEquals("http://localhost:8080/skaiciuotuvas", driver.getCurrentUrl(), "Current URL is not as expected");
    }

    @Tag("UnhappyTest")
    @Test
    void whenVisitorSubmitEmptyRegistrationForm_displayedErrorMessagesForAllRequiredFields() {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        loginPage.clickSukurtiNaujaPaskyraAndWaitUrl();

        registrationPage.clickButtonSukurti();
        assertEquals("Šį laukelį būtina užpildyti\n" + "Privaloma įvesti nuo 3 iki 32 simbolių", registrationPage.getErrorMessageVartotojui(), "Error message is not as expected");
        assertEquals("Šį laukelį būtina užpildyti\n" + "Privaloma įvesti bent 3 simbolius", registrationPage.getErrorMessageSlaptazodziui(), "Error message is not as expected");
//        assertEquals(2, driver.findElements(By.xpath("//*[contains(text(),'Šį laukelį būtina užpildyti')]")).size(), "Number of error messages is not as expected");
//        assertTrue(driver.getPageSource().contains("You must check this in order to continue"), "Šį laukelį būtina užpildyti" +
//                "Privaloma įvesti nuo 3 iki 32 simbolių");
        assertEquals("http://localhost:8080/registruoti", driver.getCurrentUrl(), "Current URL is not as expected");
    }

    @Tag("HappyTest")
    @Test
    void PositiveLoginForm() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPrisijungimoVardas(inputPrisijungimoVardas);
        loginPage.enterSlaptazodis(inputSlaptazodis);
        loginPage.setButtonPrisijungti();

        assertEquals("http://localhost:8080/", driver.getCurrentUrl(), "Current URL is not as expected");
    }

    @Tag("UnhappyTest")
    @Test
    void NegativeLoginForm_MissingPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPrisijungimoVardas(inputPrisijungimoVardas);
        loginPage.setButtonPrisijungti();

        assertTrue(driver.getPageSource().contains("Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi"), "Success message is not as expected");
        assertEquals("http://localhost:8080/prisijungti?error", driver.getCurrentUrl(), "Current URL is not as expected");
    }

    @Tag("HappyTest")
    @Test
    void functionDivide() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPrisijungimoVardas(inputPrisijungimoVardas);
        loginPage.enterSlaptazodis(inputSlaptazodis);
        loginPage.setButtonPrisijungti();

        calculatorPage.setFieldPirmasSkaicius(6);
        calculatorPage.setFieldAntrassSkaicius(2);
        calculatorPage.setButtonFunctionDivide();
        calculatorPage.setButtonSkaiciuoti();
        String expectedAnswer = "6 / 2 = 3";
        Assertions.assertEquals(expectedAnswer, calculatorPage.getFieldAnswer(), "Answer not as expected");
        assertEquals("http://localhost:8080/skaiciuoti", driver.getCurrentUrl(), "Current URL is not as expected");
    }

//    @Tag("UnHappyTest")
//    @Test
//    void functionDivide_missingFirstNumber() {
//        CalculatorPage calculatorPage = new CalculatorPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.enterPrisijungimoVardas(inputPrisijungimoVardas);
//        loginPage.enterSlaptazodis(inputSlaptazodis);
//        loginPage.setButtonPrisijungti();
//
//        calculatorPage.setFieldPirmasSkaiciusNetinkamas;
//        calculatorPage.setFieldAntrassSkaicius(2);
//        calculatorPage.setButtonFunctionDivide();
//        calculatorPage.setButtonSkaiciuoti();
//
//        assertTrue(driver.getPageSource().contains("Failed to convert property value of type java.lang.String to required type int for property sk1; nested exception is java.lang.NumberFormatException: For input string:"), "Success message is not as expected");
//        assertEquals("http://localhost:8080/skaiciuoti", driver.getCurrentUrl(), "Current URL is not as expected");
//    }
}