package Entity;

import javax.xml.ws.WebServiceRef;

public class UserLoginService {
    
    @WebServiceRef
    private static UserAuthService userAuthService;
    
    public UserLoginService() {
    }
    
    public Users getLogin(String username, String password)
    {
      userAuthService = new UserAuthService();
      Execute_ptt execute_ptt = userAuthService.getExecute_pt();
      // Add your code to call the desired methods.
      UserAuthDBAdapterSelectUsernamePassword WSParams = new UserAuthDBAdapterSelectUsernamePassword();
      
      WSParams.setUsername(username);
      WSParams.setPassword(password);
      
      Users response = execute_ptt.execute(WSParams);
      return response;
    }
    
}
