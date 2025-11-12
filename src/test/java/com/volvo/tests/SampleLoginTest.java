package com.volvo.tests;

import com.volvo.base.BaseTest;
import com.volvo.pages.LoginPage;
import org.testng.annotations.Test;

public class SampleLoginTest extends BaseTest {

    @Test
    public void loginTest() {
        String url = dotenv.get("SALESFORCE_URL");
        String user = dotenv.get("SF_USERNAME");
        String pass = dotenv.get("SF_PASSWORD");

        LoginPage login = new LoginPage(driver);
        login.open(url);
        login.login(user, pass);

        // Add assertions here (verify login success)
        // Example: assert driver.getTitle().contains("Home");
    }
}
