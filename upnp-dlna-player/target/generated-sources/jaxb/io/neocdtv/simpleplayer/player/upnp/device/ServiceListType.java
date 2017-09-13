//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.10 um 11:44:25 PM CEST 
//


package io.neocdtv.simpleplayer.player.upnp.device;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ServiceListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ServiceListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="service" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SCPDURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="controlURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="eventSubURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceListType", propOrder = {
    "service"
})
public class ServiceListType {

    @XmlElement(required = true)
    protected List<ServiceListType.Service> service;

    /**
     * Gets the value of the service property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the service property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceListType.Service }
     * 
     * 
     */
    public List<ServiceListType.Service> getService() {
        if (service == null) {
            service = new ArrayList<ServiceListType.Service>();
        }
        return this.service;
    }


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
     *         &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SCPDURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="controlURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="eventSubURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class Service {

        @XmlElement(required = true)
        protected String serviceType;
        @XmlElement(required = true)
        protected String serviceId;
        @XmlElement(name = "SCPDURL", required = true)
        protected String scpdurl;
        @XmlElement(required = true)
        protected String controlURL;
        @XmlElement(required = true)
        protected String eventSubURL;

        /**
         * Ruft den Wert der serviceType-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceType() {
            return serviceType;
        }

        /**
         * Legt den Wert der serviceType-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceType(String value) {
            this.serviceType = value;
        }

        /**
         * Ruft den Wert der serviceId-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceId() {
            return serviceId;
        }

        /**
         * Legt den Wert der serviceId-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceId(String value) {
            this.serviceId = value;
        }

        /**
         * Ruft den Wert der scpdurl-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSCPDURL() {
            return scpdurl;
        }

        /**
         * Legt den Wert der scpdurl-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSCPDURL(String value) {
            this.scpdurl = value;
        }

        /**
         * Ruft den Wert der controlURL-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getControlURL() {
            return controlURL;
        }

        /**
         * Legt den Wert der controlURL-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setControlURL(String value) {
            this.controlURL = value;
        }

        /**
         * Ruft den Wert der eventSubURL-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEventSubURL() {
            return eventSubURL;
        }

        /**
         * Legt den Wert der eventSubURL-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEventSubURL(String value) {
            this.eventSubURL = value;
        }

    }

}
