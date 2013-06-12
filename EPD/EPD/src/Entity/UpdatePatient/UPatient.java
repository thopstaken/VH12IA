
package Entity.UpdatePatient;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="patientid" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="patientnummer" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="voornaam" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tussenvoegsel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="achternaam" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="geboortedatum" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="geslacht">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="man"/>
 *             &lt;enumeration value="vrouw"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="overleden_ind">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="0"/>
 *             &lt;enumeration value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="user_id" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="afdeling_id" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="active_ind">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="0"/>
 *             &lt;enumeration value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "UPatient")
public class UPatient {

    @XmlAttribute
    protected BigDecimal patientid;
    @XmlAttribute
    protected BigDecimal patientnummer;
    @XmlAttribute
    protected String voornaam;
    @XmlAttribute
    protected String tussenvoegsel;
    @XmlAttribute
    protected String achternaam;
    @XmlAttribute
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar geboortedatum;
    @XmlAttribute
    protected String geslacht;
    @XmlAttribute(name = "overleden_ind")
    protected String overledenInd;
    @XmlAttribute(name = "user_id")
    protected BigDecimal userId;
    @XmlAttribute(name = "afdeling_id")
    protected BigDecimal afdelingId;
    @XmlAttribute(name = "active_ind")
    protected BigDecimal activeInd;

    /**
     * Gets the value of the patientid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPatientid() {
        return patientid;
    }

    /**
     * Sets the value of the patientid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPatientid(BigDecimal value) {
        this.patientid = value;
    }

    /**
     * Gets the value of the patientnummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPatientnummer() {
        return patientnummer;
    }

    /**
     * Sets the value of the patientnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPatientnummer(BigDecimal value) {
        this.patientnummer = value;
    }

    /**
     * Gets the value of the voornaam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * Sets the value of the voornaam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoornaam(String value) {
        this.voornaam = value;
    }

    /**
     * Gets the value of the tussenvoegsel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    /**
     * Sets the value of the tussenvoegsel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTussenvoegsel(String value) {
        this.tussenvoegsel = value;
    }

    /**
     * Gets the value of the achternaam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * Sets the value of the achternaam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAchternaam(String value) {
        this.achternaam = value;
    }

    /**
     * Gets the value of the geboortedatum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGeboortedatum() {
        return geboortedatum;
    }

    /**
     * Sets the value of the geboortedatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGeboortedatum(XMLGregorianCalendar value) {
        this.geboortedatum = value;
    }

    /**
     * Gets the value of the geslacht property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeslacht() {
        return geslacht;
    }

    /**
     * Sets the value of the geslacht property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeslacht(String value) {
        this.geslacht = value;
    }

    /**
     * Gets the value of the overledenInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverledenInd() {
        return overledenInd;
    }

    /**
     * Sets the value of the overledenInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverledenInd(String value) {
        this.overledenInd = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUserId(BigDecimal value) {
        this.userId = value;
    }

    /**
     * Gets the value of the afdelingId property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAfdelingId() {
        return afdelingId;
    }

    /**
     * Sets the value of the afdelingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAfdelingId(BigDecimal value) {
        this.afdelingId = value;
    }

    /**
     * Gets the value of the activeInd property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getActiveInd() {
        return activeInd;
    }

    /**
     * Sets the value of the activeInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setActiveInd(BigDecimal value) {
        this.activeInd = value;
    }

}
