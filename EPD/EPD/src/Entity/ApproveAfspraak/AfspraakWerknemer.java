
package Entity.ApproveAfspraak;

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
 *       &lt;attribute name="afspraak_id" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="werknemer_id" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Afspraak_Werknemer")
public class AfspraakWerknemer {

    @XmlAttribute(name = "afspraak_id")
    protected BigDecimal afspraakId;
    @XmlAttribute(name = "werknemer_id")
    protected BigDecimal werknemerId;

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

    /**
     * Gets the value of the werknemerId property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWerknemerId() {
        return werknemerId;
    }

    /**
     * Sets the value of the werknemerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWerknemerId(BigDecimal value) {
        this.werknemerId = value;
    }

}
