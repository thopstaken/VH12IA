package Entity.InsertLab;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 091026.1130.19937)

public class Execute_ptClient
{
  @WebServiceRef
  private static InsertLabService insertLabService;

  public static void main(String [] args)
  {
    insertLabService = new InsertLabService();
    Execute_ptt execute_ptt = insertLabService.getExecute_pt();
    // Add your code to call the desired methods.
  }
}
