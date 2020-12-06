public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Password IDandPassword = new Password();
        new LoginPage(IDandPassword.getLoginInfo());

    }
}