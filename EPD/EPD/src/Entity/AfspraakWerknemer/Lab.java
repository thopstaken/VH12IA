
package Entity.AfspraakWerknemer;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="naam" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="soort" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="afspraak_id" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Lab")
public class Lab {

    @XmlAttribute
    protected String naam;
    @XmlAttribute
    protected String soort;
    @XmlAttribute(name = "afspraak_id")
    protected BigDecimal afspraakId;

    /**
     * Gets the value of the naam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Sets the value of the naam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaam(String value) {
        this.naam = value;
    }

    /**
     * Gets the value of the soort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoort() {
        return soort;
    }

    /**
     * Sets the value of the soort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoort(String value) {
        this.soort = value;
    }

    /**
     * Gets the value of the afspraakId property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAfspraakId() {
        return afspraakId;
    }

    /**
     * Sets the value of the afspraakId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAfspraakId(BigDecimal value) {
        this.afspraakId = value;
    }

}
