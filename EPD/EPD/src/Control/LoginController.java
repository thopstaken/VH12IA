package Control;

import Entity.JAXWS.Execute_ptt;
import Entity.JAXWS.LoginService;

import Entity.JAXWS.UserDBSelectLoginPassword;
import Entity.JAXWS.Users;

import javax.xml.ws.WebServiceRef;

public class LoginController {
    
    @WebServiceRef
    private static LoginService userAuthService;
    
    public LoginController() {
        
    }
    
    public Users checkLogin(String username, String password) {
        
        Execute_ptt loginService_execute_ptt = userAuthService.getExecute_pt();
        UserDBSelectLoginPassword loginService_params = new UserDBSelectLoginPassword();
        
        loginService_params.setLogin(username);
        loginService_params.setPassword(password);
        
        Users response = loginService_execute_ptt.execute(loginService_params);
        return response;
    }
}
