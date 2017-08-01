
package com.pluralsight.schema.order;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderStatutsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrderStatutsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="READY"/>
 *     &lt;enumeration value="FULFILLED"/>
 *     &lt;enumeration value="BACKORDER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OrderStatutsType")
@XmlEnum
public enum OrderStatutsType {

    READY,
    FULFILLED,
    BACKORDER;

    public String value() {
        return name();
    }

    public static OrderStatutsType fromValue(String v) {
        return valueOf(v);
    }

}
