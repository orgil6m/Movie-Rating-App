public class App {
    public void start(){
        System.out.println("Welcome to Movie Management System");
        System.out.println("Please login to continue");

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.login();
    }
}
