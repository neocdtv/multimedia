//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.05.03 um 09:41:16 AM CEST 
//


package io.neocdtv.upnp.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="specVersion" type="{urn:schemas-upnp-org:service-1-0}SpecVersionType"/>
 *         &lt;element name="actionList" type="{urn:schemas-upnp-org:service-1-0}ActionListType" minOccurs="0"/>
 *         &lt;element name="serviceStateTable" type="{urn:schemas-upnp-org:service-1-0}ServiceStateTableType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "scpd")
public class Scpd {

    @XmlElement(required = true)
    protected SpecVersionType specVersion;
    protected ActionListType actionList;
    @XmlElement(required = true)
    protected ServiceStateTableType serviceStateTable;

    /**
     * Ruft den Wert der specVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecVersionType }
     *     
     */
    public SpecVersionType getSpecVersion() {
        return specVersion;
    }

    /**
     * Legt den Wert der specVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecVersionType }
     *     
     */
    public void setSpecVersion(SpecVersionType value) {
        this.specVersion = value;
    }

    /**
     * Ruft den Wert der actionList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ActionListType }
     *     
     */
    public ActionListType getActionList() {
        return actionList;
    }

    /**
     * Legt den Wert der actionList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionListType }
     *     
     */
    public void setActionList(ActionListType value) {
        this.actionList = value;
    }

    /**
     * Ruft den Wert der serviceStateTable-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStateTableType }
     *     
     */
    public ServiceStateTableType getServiceStateTable() {
        return serviceStateTable;
    }

    /**
     * Legt den Wert der serviceStateTable-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStateTableType }
     *     
     */
    public void setServiceStateTable(ServiceStateTableType value) {
        this.serviceStateTable = value;
    }

}
