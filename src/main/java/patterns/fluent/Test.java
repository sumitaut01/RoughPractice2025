package patterns.fluent;

public class Test {

    HomePage homePage =
            new LoginPage()
                    .enterUsername("admin")
                    .enterPassword("admin123")
                    .clickLogin();
}
