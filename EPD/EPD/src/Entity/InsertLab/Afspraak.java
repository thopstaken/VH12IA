
package Entity.InsertLab;

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
 *       &lt;attribute name="approved_ind" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="opmerkingen" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="signed" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="patient_id" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="categorie" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="start_tijd_dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="eind_tijd_dt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Afspraak")
public class Afspraak {

    @XmlAttribute(name = "approved_ind")
    protected String approvedInd;
    @XmlAttribute
    protected String opmerkingen;
    @XmlAttribute
    protected String signed;
    @XmlAttribute(name = "patient_id")
    protected BigDecimal patientId;
    @XmlAttribute
    protected String categorie;
    @XmlAttribute(name = "start_tijd_dt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTijdDt;
    @XmlAttribute(name = "eind_tijd_dt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar eindTijdDt;

    /**
     * Gets the value of the approvedInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovedInd() {
        return approvedInd;
    }

    /**
     * Sets the value of the approvedInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovedInd(String value) {
        this.approvedInd = value;
    }

    /**
     * Gets the value of the opmerkingen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpmerkingen() {
        return opmerkingen;
    }

    /**
     * Sets the value of the opmerkingen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpmerkingen(String value) {
        this.opmerkingen = value;
    }

    /**
     * Gets the value of the signed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSigned() {
        return signed;
    }

    /**
     * Sets the value of the signed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigned(String value) {
        this.signed = value;
    }

    /**
     * Gets the value of the patientId property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPatientId() {
        return patientId;
    }

    /**
     * Sets the value of the patientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPatientId(BigDecimal value) {
        this.patientId = value;
    }

    /**
     * Gets the value of the categorie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * Sets the value of the categorie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorie(String value) {
        this.categorie = value;
    }

    /**
     * Gets the value of the startTijdDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTijdDt() {
        return startTijdDt;
    }

    /**
     * Sets the value of the startTijdDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartTijdDt(XMLGregorianCalendar value) {
        this.startTijdDt = value;
    }

    /**
     * Gets the value of the eindTijdDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEindTijdDt() {
        return eindTijdDt;
    }

    /**
     * Sets the value of the eindTijdDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEindTijdDt(XMLGregorianCalendar value) {
        this.eindTijdDt = value;
    }

}
