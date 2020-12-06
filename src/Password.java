import java.util.HashMap;

public class Password {
    HashMap<String, String> logininfo = new HashMap();

    Password() {
        this.logininfo.put("Admin", "123456789");
    }

    protected HashMap getLoginInfo() {
        return this.logininfo;
    }
}
