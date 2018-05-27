//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.05.03 um 09:41:16 AM CEST 
//


package io.neocdtv.upnp.device;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.neocdtv.upnp.device package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.neocdtv.upnp.device
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceListType }
     * 
     */
    public ServiceListType createServiceListType() {
        return new ServiceListType();
    }

    /**
     * Create an instance of {@link IconListType }
     * 
     */
    public IconListType createIconListType() {
        return new IconListType();
    }

    /**
     * Create an instance of {@link Root }
     * 
     */
    public Root createRoot() {
        return new Root();
    }

    /**
     * Create an instance of {@link SpecVersionType }
     * 
     */
    public SpecVersionType createSpecVersionType() {
        return new SpecVersionType();
    }

    /**
     * Create an instance of {@link DeviceType }
     * 
     */
    public DeviceType createDeviceType() {
        return new DeviceType();
    }

    /**
     * Create an instance of {@link DeviceListType }
     * 
     */
    public DeviceListType createDeviceListType() {
        return new DeviceListType();
    }

    /**
     * Create an instance of {@link ServiceListType.Service }
     * 
     */
    public ServiceListType.Service createServiceListTypeService() {
        return new ServiceListType.Service();
    }

    /**
     * Create an instance of {@link IconListType.Icon }
     * 
     */
    public IconListType.Icon createIconListTypeIcon() {
        return new IconListType.Icon();
    }

}
