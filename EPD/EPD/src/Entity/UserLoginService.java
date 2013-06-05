package Entity;

import Entity.JAXWS.UserAuthService;
import Entity.JAXWS.Users;

import Entity.JAXWS.UserDBASelectUSERNAMEPASSWORD;

import javax.xml.ws.WebServiceRef;

public class UserLoginService {
    
    @WebServiceRef
    private static UserAuthService userAuthService;
    
    public UserLoginService() {
    }
    
    public Users getLogin(String username, String password)
    {
      userAuthService = new UserAuthService();
      Entity.JAXWS.Execute_ptt execute_ptt = userAuthService.getExecute_pt();
      // Add your code to call the desired methods.
      UserDBASelectUSERNAMEPASSWORD WSParams = new UserDBASelectUSERNAMEPASSWORD();
      
      WSParams.setUSERNAME(username);
      WSParams.setPASSWORD(password);
      
      Users response = execute_ptt.execute(WSParams);
      return response;
    }
    
}
