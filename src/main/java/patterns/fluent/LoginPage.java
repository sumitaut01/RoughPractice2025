package patterns.fluent;

public class LoginPage {

    public LoginPage enterUsername(String username) {
        System.out.println("Entering username: " + username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        System.out.println("Entering password: " + password);
        return this;
    }

    public HomePage clickLogin() {
        System.out.println("Clicking Login");
        return new HomePage();
    }
}