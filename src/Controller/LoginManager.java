package Controller;

public class LoginManager {
    private static LoginManager ourInstance = new LoginManager();

    public static LoginManager getInstance() {
        return ourInstance;
    }

    public void handleLogin(){}

    private LoginManager() {
    }
}
