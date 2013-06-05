
package Entity.JAXWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Entity.JAXWS package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UserDBASelectUSERNAMEPASSWORDInputParameters_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "UserDBASelect_USERNAME_PASSWORDInputParameters");
    private final static QName _UsersCollection_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "UsersCollection");
    private final static QName _User_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "User");
    private final static QName _UsersLogin_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "login");
    private final static QName _UsersLmodifyUser_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "lmodifyUser");
    private final static QName _UsersPassword_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "password");
    private final static QName _UsersFirstName_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "firstName");
    private final static QName _UsersLmodifyDt_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "lmodifyDt");
    private final static QName _UsersName_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "name");
    private final static QName _UsersEmail_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", "email");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Entity.JAXWS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserDBASelectUSERNAMEPASSWORD }
     * 
     */
    public UserDBASelectUSERNAMEPASSWORD createUserDBASelectUSERNAMEPASSWORD() {
        return new UserDBASelectUSERNAMEPASSWORD();
    }

    /**
     * Create an instance of {@link UsersCollection }
     * 
     */
    public UsersCollection createUsersCollection() {
        return new UsersCollection();
    }

    /**
     * Create an instance of {@link Users }
     * 
     */
    public Users createUsers() {
        return new Users();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDBASelectUSERNAMEPASSWORD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "UserDBASelect_USERNAME_PASSWORDInputParameters")
    public JAXBElement<UserDBASelectUSERNAMEPASSWORD> createUserDBASelectUSERNAMEPASSWORDInputParameters(UserDBASelectUSERNAMEPASSWORD value) {
        return new JAXBElement<UserDBASelectUSERNAMEPASSWORD>(_UserDBASelectUSERNAMEPASSWORDInputParameters_QNAME, UserDBASelectUSERNAMEPASSWORD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsersCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "UsersCollection")
    public JAXBElement<UsersCollection> createUsersCollection(UsersCollection value) {
        return new JAXBElement<UsersCollection>(_UsersCollection_QNAME, UsersCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Users }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "User")
    public JAXBElement<Users> createUser(Users value) {
        return new JAXBElement<Users>(_User_QNAME, Users.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "login", scope = Users.class)
    public JAXBElement<String> createUsersLogin(String value) {
        return new JAXBElement<String>(_UsersLogin_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "lmodifyUser", scope = Users.class)
    public JAXBElement<String> createUsersLmodifyUser(String value) {
        return new JAXBElement<String>(_UsersLmodifyUser_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "password", scope = Users.class)
    public JAXBElement<String> createUsersPassword(String value) {
        return new JAXBElement<String>(_UsersPassword_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "firstName", scope = Users.class)
    public JAXBElement<String> createUsersFirstName(String value) {
        return new JAXBElement<String>(_UsersFirstName_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "lmodifyDt", scope = Users.class)
    public JAXBElement<XMLGregorianCalendar> createUsersLmodifyDt(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UsersLmodifyDt_QNAME, XMLGregorianCalendar.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "name", scope = Users.class)
    public JAXBElement<String> createUsersName(String value) {
        return new JAXBElement<String>(_UsersName_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDBA", name = "email", scope = Users.class)
    public JAXBElement<String> createUsersEmail(String value) {
        return new JAXBElement<String>(_UsersEmail_QNAME, String.class, Users.class, value);
    }

}
