package Entity;

import Entity.JAXWS.LoginService;
import Entity.JAXWS.Users;

import Entity.JAXWS.UserDBSelectLoginPassword;

import javax.xml.ws.WebServiceRef;

public class UserLoginService {
    
    @WebServiceRef
    private static LoginService userAuthService;
    
    public UserLoginService() {
    }
    
    public Users getLogin(String username, String password)
    {
      userAuthService = new LoginService();
      Entity.JAXWS.Execute_ptt execute_ptt = userAuthService.getExecute_pt();
      // Add your code to call the desired methods.
      UserDBSelectLoginPassword WSParams = new UserDBSelectLoginPassword();
      
      WSParams.setLogin(username);
      WSParams.setPassword(password);
      
      Users response = execute_ptt.execute(WSParams);
      return response;
    }
    
}
