
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para caducadosDesde complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="caducadosDesde">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="desde" type="{http://ws/}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "caducadosDesde", propOrder = {
    "desde"
})
public class CaducadosDesde {

    protected Date desde;

    /**
     * Obtiene el valor de la propiedad desde.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDesde() {
        return desde;
    }

    /**
     * Define el valor de la propiedad desde.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDesde(Date value) {
        this.desde = value;
    }

}
