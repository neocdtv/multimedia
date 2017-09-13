//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.10 um 11:44:25 PM CEST 
//


package io.neocdtv.simpleplayer.player.upnp.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für AllowedValueRangeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AllowedValueRangeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="minimum" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="maximum" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="step" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllowedValueRangeType", propOrder = {

})
public class AllowedValueRangeType {

    @XmlElement(required = true)
    protected BigDecimal minimum;
    @XmlElement(required = true)
    protected BigDecimal maximum;
    protected BigDecimal step;

    /**
     * Ruft den Wert der minimum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimum() {
        return minimum;
    }

    /**
     * Legt den Wert der minimum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimum(BigDecimal value) {
        this.minimum = value;
    }

    /**
     * Ruft den Wert der maximum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaximum() {
        return maximum;
    }

    /**
     * Legt den Wert der maximum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaximum(BigDecimal value) {
        this.maximum = value;
    }

    /**
     * Ruft den Wert der step-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStep() {
        return step;
    }

    /**
     * Legt den Wert der step-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStep(BigDecimal value) {
        this.step = value;
    }

}
