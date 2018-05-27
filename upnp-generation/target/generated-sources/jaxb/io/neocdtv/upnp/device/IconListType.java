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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für IconListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="IconListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="icon" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="mimetype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="depth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "IconListType", propOrder = {
    "icon"
})
public class IconListType {

    @XmlElement(required = true)
    protected List<IconListType.Icon> icon;

    /**
     * Gets the value of the icon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IconListType.Icon }
     * 
     * 
     */
    public List<IconListType.Icon> getIcon() {
        if (icon == null) {
            icon = new ArrayList<IconListType.Icon>();
        }
        return this.icon;
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
     *         &lt;element name="mimetype" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="depth" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class Icon {

        @XmlElement(required = true)
        protected String mimetype;
        protected int width;
        protected int height;
        protected int depth;
        @XmlElement(required = true)
        protected String url;

        /**
         * Ruft den Wert der mimetype-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMimetype() {
            return mimetype;
        }

        /**
         * Legt den Wert der mimetype-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMimetype(String value) {
            this.mimetype = value;
        }

        /**
         * Ruft den Wert der width-Eigenschaft ab.
         * 
         */
        public int getWidth() {
            return width;
        }

        /**
         * Legt den Wert der width-Eigenschaft fest.
         * 
         */
        public void setWidth(int value) {
            this.width = value;
        }

        /**
         * Ruft den Wert der height-Eigenschaft ab.
         * 
         */
        public int getHeight() {
            return height;
        }

        /**
         * Legt den Wert der height-Eigenschaft fest.
         * 
         */
        public void setHeight(int value) {
            this.height = value;
        }

        /**
         * Ruft den Wert der depth-Eigenschaft ab.
         * 
         */
        public int getDepth() {
            return depth;
        }

        /**
         * Legt den Wert der depth-Eigenschaft fest.
         * 
         */
        public void setDepth(int value) {
            this.depth = value;
        }

        /**
         * Ruft den Wert der url-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUrl() {
            return url;
        }

        /**
         * Legt den Wert der url-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUrl(String value) {
            this.url = value;
        }

    }

}
