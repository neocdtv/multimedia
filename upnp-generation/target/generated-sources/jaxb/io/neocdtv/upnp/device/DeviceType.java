//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.05.03 um 09:41:16 AM CEST 
//


package io.neocdtv.upnp.device;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für DeviceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DeviceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deviceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="friendlyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="manufacturerURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modelDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modelURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UDN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UPC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iconList" type="{urn:schemas-upnp-org:device-1-0}IconListType" minOccurs="0"/>
 *         &lt;element name="serviceList" type="{urn:schemas-upnp-org:device-1-0}ServiceListType" minOccurs="0"/>
 *         &lt;element name="deviceList" type="{urn:schemas-upnp-org:device-1-0}DeviceListType" minOccurs="0"/>
 *         &lt;element name="presentationURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceType", propOrder = {
    "deviceType",
    "friendlyName",
    "manufacturer",
    "manufacturerURL",
    "modelDescription",
    "modelName",
    "modelNumber",
    "modelURL",
    "serialNumber",
    "udn",
    "upc",
    "iconList",
    "serviceList",
    "deviceList",
    "presentationURL",
    "any"
})
public class DeviceType {

    @XmlElement(required = true)
    protected String deviceType;
    @XmlElement(required = true)
    protected String friendlyName;
    @XmlElement(required = true)
    protected String manufacturer;
    protected String manufacturerURL;
    protected String modelDescription;
    @XmlElement(required = true)
    protected String modelName;
    protected String modelNumber;
    protected String modelURL;
    protected String serialNumber;
    @XmlElement(name = "UDN", required = true)
    protected String udn;
    @XmlElement(name = "UPC")
    protected String upc;
    protected IconListType iconList;
    protected ServiceListType serviceList;
    protected DeviceListType deviceList;
    protected String presentationURL;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Ruft den Wert der deviceType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * Legt den Wert der deviceType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceType(String value) {
        this.deviceType = value;
    }

    /**
     * Ruft den Wert der friendlyName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Legt den Wert der friendlyName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFriendlyName(String value) {
        this.friendlyName = value;
    }

    /**
     * Ruft den Wert der manufacturer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Legt den Wert der manufacturer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Ruft den Wert der manufacturerURL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturerURL() {
        return manufacturerURL;
    }

    /**
     * Legt den Wert der manufacturerURL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturerURL(String value) {
        this.manufacturerURL = value;
    }

    /**
     * Ruft den Wert der modelDescription-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelDescription() {
        return modelDescription;
    }

    /**
     * Legt den Wert der modelDescription-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelDescription(String value) {
        this.modelDescription = value;
    }

    /**
     * Ruft den Wert der modelName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Legt den Wert der modelName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelName(String value) {
        this.modelName = value;
    }

    /**
     * Ruft den Wert der modelNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     * Legt den Wert der modelNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelNumber(String value) {
        this.modelNumber = value;
    }

    /**
     * Ruft den Wert der modelURL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelURL() {
        return modelURL;
    }

    /**
     * Legt den Wert der modelURL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelURL(String value) {
        this.modelURL = value;
    }

    /**
     * Ruft den Wert der serialNumber-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Legt den Wert der serialNumber-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

    /**
     * Ruft den Wert der udn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUDN() {
        return udn;
    }

    /**
     * Legt den Wert der udn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUDN(String value) {
        this.udn = value;
    }

    /**
     * Ruft den Wert der upc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUPC() {
        return upc;
    }

    /**
     * Legt den Wert der upc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUPC(String value) {
        this.upc = value;
    }

    /**
     * Ruft den Wert der iconList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IconListType }
     *     
     */
    public IconListType getIconList() {
        return iconList;
    }

    /**
     * Legt den Wert der iconList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IconListType }
     *     
     */
    public void setIconList(IconListType value) {
        this.iconList = value;
    }

    /**
     * Ruft den Wert der serviceList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ServiceListType }
     *     
     */
    public ServiceListType getServiceList() {
        return serviceList;
    }

    /**
     * Legt den Wert der serviceList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceListType }
     *     
     */
    public void setServiceList(ServiceListType value) {
        this.serviceList = value;
    }

    /**
     * Ruft den Wert der deviceList-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeviceListType }
     *     
     */
    public DeviceListType getDeviceList() {
        return deviceList;
    }

    /**
     * Legt den Wert der deviceList-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceListType }
     *     
     */
    public void setDeviceList(DeviceListType value) {
        this.deviceList = value;
    }

    /**
     * Ruft den Wert der presentationURL-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresentationURL() {
        return presentationURL;
    }

    /**
     * Legt den Wert der presentationURL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresentationURL(String value) {
        this.presentationURL = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
