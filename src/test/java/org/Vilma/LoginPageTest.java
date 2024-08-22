package org.Vilma;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LoginPageTest extends BasePageTest {


    @Tag("HappyTest")
    @Test
    void whenVisitorClickRegisterLink_userIsMovedToPageRegister() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.paspaustiSukurtiNaujaPaskyra();
        assertEquals("http://localhost:8080/registruoti", driver.getCurrentUrl(), "Current URL is not as expected");
    }

}