
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

    private final static QName _User_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "User");
    private final static QName _UsersCollection_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "UsersCollection");
    private final static QName _UserDBSelectLoginPasswordInputParameters_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "UserDBSelect_login_passwordInputParameters");
    private final static QName _UsersName_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "name");
    private final static QName _UsersEmail_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "email");
    private final static QName _UsersLmodifyDt_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "lmodifyDt");
    private final static QName _UsersPassword_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "password");
    private final static QName _UsersFirstName_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "firstName");
    private final static QName _UsersLogin_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "login");
    private final static QName _UsersLmodifyUser_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", "lmodifyUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Entity.JAXWS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UsersCollection }
     * 
     */
    public UsersCollection createUsersCollection() {
        return new UsersCollection();
    }

    /**
     * Create an instance of {@link UserDBSelectLoginPassword }
     * 
     */
    public UserDBSelectLoginPassword createUserDBSelectLoginPassword() {
        return new UserDBSelectLoginPassword();
    }

    /**
     * Create an instance of {@link Users }
     * 
     */
    public Users createUsers() {
        return new Users();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Users }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "User")
    public JAXBElement<Users> createUser(Users value) {
        return new JAXBElement<Users>(_User_QNAME, Users.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsersCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "UsersCollection")
    public JAXBElement<UsersCollection> createUsersCollection(UsersCollection value) {
        return new JAXBElement<UsersCollection>(_UsersCollection_QNAME, UsersCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDBSelectLoginPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "UserDBSelect_login_passwordInputParameters")
    public JAXBElement<UserDBSelectLoginPassword> createUserDBSelectLoginPasswordInputParameters(UserDBSelectLoginPassword value) {
        return new JAXBElement<UserDBSelectLoginPassword>(_UserDBSelectLoginPasswordInputParameters_QNAME, UserDBSelectLoginPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "name", scope = Users.class)
    public JAXBElement<String> createUsersName(String value) {
        return new JAXBElement<String>(_UsersName_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "email", scope = Users.class)
    public JAXBElement<String> createUsersEmail(String value) {
        return new JAXBElement<String>(_UsersEmail_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "lmodifyDt", scope = Users.class)
    public JAXBElement<XMLGregorianCalendar> createUsersLmodifyDt(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UsersLmodifyDt_QNAME, XMLGregorianCalendar.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "password", scope = Users.class)
    public JAXBElement<String> createUsersPassword(String value) {
        return new JAXBElement<String>(_UsersPassword_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "firstName", scope = Users.class)
    public JAXBElement<String> createUsersFirstName(String value) {
        return new JAXBElement<String>(_UsersFirstName_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "login", scope = Users.class)
    public JAXBElement<String> createUsersLogin(String value) {
        return new JAXBElement<String>(_UsersLogin_QNAME, String.class, Users.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/top/UserDB", name = "lmodifyUser", scope = Users.class)
    public JAXBElement<String> createUsersLmodifyUser(String value) {
        return new JAXBElement<String>(_UsersLmodifyUser_QNAME, String.class, Users.class, value);
    }

}
