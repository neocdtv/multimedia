//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.12 um 11:18:55 AM CEST 
//


package io.neocdtv.upnp.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SpecVersionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SpecVersionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecVersionType", propOrder = {

})
public class SpecVersionType {

    protected int major;
    protected int minor;

    /**
     * Ruft den Wert der major-Eigenschaft ab.
     * 
     */
    public int getMajor() {
        return major;
    }

    /**
     * Legt den Wert der major-Eigenschaft fest.
     * 
     */
    public void setMajor(int value) {
        this.major = value;
    }

    /**
     * Ruft den Wert der minor-Eigenschaft ab.
     * 
     */
    public int getMinor() {
        return minor;
    }

    /**
     * Legt den Wert der minor-Eigenschaft fest.
     * 
     */
    public void setMinor(int value) {
        this.minor = value;
    }

}
