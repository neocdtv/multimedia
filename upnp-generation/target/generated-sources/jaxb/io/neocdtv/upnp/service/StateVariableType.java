//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.12 um 11:18:55 AM CEST 
//


package io.neocdtv.upnp.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für StateVariableType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="StateVariableType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allowedValueList" type="{urn:schemas-upnp-org:service-1-0}AllowedValueListType" minOccurs="0"/>
 *         &lt;element name="allowedValueRange" type="{urn:schemas-upnp-org:service-1-0}AllowedValueRangeType" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="sendEvents" type="{http://www.w3.org/2001/XMLSchema}string" default="yes" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StateVariableType", propOrder = {

})
public class StateVariableType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String dataType;
    protected String defaultValue;
    protected AllowedValueListType allowedValueList;
    protected AllowedValueRangeType allowedValueRange;
    @XmlAttribute(name = "sendEvents")
    protected String sendEvents;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der dataType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Legt den Wert der dataType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * Ruft den Wert der defaultValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Legt den Wert der defaultValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultValue(String value) {
        this.defaultValue = value;
    }

    /**
     * Ruft den Wert der allowedValueList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AllowedValueListType }
     *     
     */
    public AllowedValueListType getAllowedValueList() {
        return allowedValueList;
    }

    /**
     * Legt den Wert der allowedValueList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedValueListType }
     *     
     */
    public void setAllowedValueList(AllowedValueListType value) {
        this.allowedValueList = value;
    }

    /**
     * Ruft den Wert der allowedValueRange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AllowedValueRangeType }
     *     
     */
    public AllowedValueRangeType getAllowedValueRange() {
        return allowedValueRange;
    }

    /**
     * Legt den Wert der allowedValueRange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedValueRangeType }
     *     
     */
    public void setAllowedValueRange(AllowedValueRangeType value) {
        this.allowedValueRange = value;
    }

    /**
     * Ruft den Wert der sendEvents-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendEvents() {
        if (sendEvents == null) {
            return "yes";
        } else {
            return sendEvents;
        }
    }

    /**
     * Legt den Wert der sendEvents-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendEvents(String value) {
        this.sendEvents = value;
    }

}
