//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.05.03 um 09:41:16 AM CEST 
//


package io.neocdtv.upnp.avtransport;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                     InstanceID elements identify an individual event instance.
 *                 
 * 
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;group ref="{urn:schemas-upnp-org:metadata-1-0/AVT/}allowed-under-InstanceID"/>
 *       &lt;/choice>
 *       &lt;attribute name="val" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transportStateOrTransportStatusOrPlaybackStorageMedium"
})
@XmlRootElement(name = "InstanceID")
public class InstanceID {

    @XmlElements({
        @XmlElement(name = "TransportState", type = TransportState.class),
        @XmlElement(name = "TransportStatus", type = TransportStatus.class),
        @XmlElement(name = "PlaybackStorageMedium", type = PlaybackStorageMedium.class),
        @XmlElement(name = "RecordStorageMedium", type = RecordStorageMedium.class),
        @XmlElement(name = "PossiblePlaybackStorageMedia", type = PossiblePlaybackStorageMedia.class),
        @XmlElement(name = "PossibleRecordStorageMedia", type = PossibleRecordStorageMedia.class),
        @XmlElement(name = "CurrentPlayMode", type = CurrentPlayMode.class),
        @XmlElement(name = "TransportPlaySpeed", type = TransportPlaySpeed.class),
        @XmlElement(name = "RecordMediumWriteStatus", type = RecordMediumWriteStatus.class),
        @XmlElement(name = "CurrentRecordQualityMode", type = CurrentRecordQualityMode.class),
        @XmlElement(name = "PossibleRecordQualityModes", type = PossibleRecordQualityModes.class),
        @XmlElement(name = "NumberOfTracks", type = NumberOfTracks.class),
        @XmlElement(name = "CurrentTransportActions", type = CurrentTransportActions.class),
        @XmlElement(name = "CurrentTrack", type = CurrentTrack.class),
        @XmlElement(name = "CurrentTrackDuration", type = CurrentTrackDuration.class),
        @XmlElement(name = "CurrentMediaDuration", type = CurrentMediaDuration.class),
        @XmlElement(name = "CurrentTrackURI", type = CurrentTrackURI.class),
        @XmlElement(name = "CurrentTrackMetaData", type = CurrentTrackMetaData.class),
        @XmlElement(name = "AVTransportURI", type = AVTransportURI.class),
        @XmlElement(name = "AVTransportURIMetaData", type = AVTransportURIMetaData.class),
        @XmlElement(name = "NextAVTransportURI", type = NextAVTransportURI.class),
        @XmlElement(name = "NextAVTransportURIMetaData", type = NextAVTransportURIMetaData.class)
    })
    protected List<Object> transportStateOrTransportStatusOrPlaybackStorageMedium;
    @XmlAttribute(name = "val", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long val;

    /**
     * Gets the value of the transportStateOrTransportStatusOrPlaybackStorageMedium property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportStateOrTransportStatusOrPlaybackStorageMedium property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportStateOrTransportStatusOrPlaybackStorageMedium().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportState }
     * {@link TransportStatus }
     * {@link PlaybackStorageMedium }
     * {@link RecordStorageMedium }
     * {@link PossiblePlaybackStorageMedia }
     * {@link PossibleRecordStorageMedia }
     * {@link CurrentPlayMode }
     * {@link TransportPlaySpeed }
     * {@link RecordMediumWriteStatus }
     * {@link CurrentRecordQualityMode }
     * {@link PossibleRecordQualityModes }
     * {@link NumberOfTracks }
     * {@link CurrentTransportActions }
     * {@link CurrentTrack }
     * {@link CurrentTrackDuration }
     * {@link CurrentMediaDuration }
     * {@link CurrentTrackURI }
     * {@link CurrentTrackMetaData }
     * {@link AVTransportURI }
     * {@link AVTransportURIMetaData }
     * {@link NextAVTransportURI }
     * {@link NextAVTransportURIMetaData }
     * 
     * 
     */
    public List<Object> getTransportStateOrTransportStatusOrPlaybackStorageMedium() {
        if (transportStateOrTransportStatusOrPlaybackStorageMedium == null) {
            transportStateOrTransportStatusOrPlaybackStorageMedium = new ArrayList<Object>();
        }
        return this.transportStateOrTransportStatusOrPlaybackStorageMedium;
    }

    /**
     * Ruft den Wert der val-Eigenschaft ab.
     * 
     */
    public long getVal() {
        return val;
    }

    /**
     * Legt den Wert der val-Eigenschaft fest.
     * 
     */
    public void setVal(long value) {
        this.val = value;
    }

}
