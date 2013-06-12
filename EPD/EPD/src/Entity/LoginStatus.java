package Entity;

import Entity.JAXWS.Users;

public class LoginStatus {
    
    protected Users loginStatus;
    private static LoginStatus instance;
    
    public static LoginStatus getInstance() {
        if (instance != null) {
            return instance;
        }
        else {
            instance = new LoginStatus();
        }
        return instance;
    }
    
    public void updateUserInfo(Users loginStatus) {
        this.loginStatus = loginStatus;
    }
    
    public Users giveUserInfo() {
        return loginStatus;
    }
    
    protected LoginStatus() {
        super();
    }
}
