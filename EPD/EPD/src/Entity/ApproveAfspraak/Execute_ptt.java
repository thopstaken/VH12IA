package Entity.ApproveAfspraak;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 091026.1130.19937)

@WebService(wsdlLocation="http://ORACLE-SOA-SUITE:8001/soa-infra/services/default/Project1/ApproveAfspraakService?WSDL",
  targetNamespace="http://oracle.com/sca/soapservice/epd/EPDSOA/ApproveAfspraakService",
  name="execute_ptt")
@XmlSeeAlso(
  { Entity.ApproveAfspraak.ObjectFactory.class })
@SOAPBinding(style=Style.DOCUMENT, parameterStyle=ParameterStyle.BARE)
public interface Execute_ptt
{
  @WebMethod(action="execute")
  @SOAPBinding(parameterStyle=ParameterStyle.BARE)
  @Action(input="execute")
  @Oneway
  public void execute(@WebParam(targetNamespace="http://www.example.org",
      partName="request", name="ApproveAfspraak")
    Entity.ApproveAfspraak.ApproveAfspraak request);
}
