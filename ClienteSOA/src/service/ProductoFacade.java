package service;

import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import ws.Producto;
import ws.ProductoService;
import ws.ProductoService_Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ProductoFacade {

    private static ProductoFacade singleton;

    public static ProductoFacade getInstance() {
        if (singleton == null) singleton = new ProductoFacade();
        return singleton;
    }



    public static XMLGregorianCalendar currentTime() {
        GregorianCalendar c = new GregorianCalendar();
        c.setTimeInMillis(System.currentTimeMillis());
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Producto productoSimple(String nombre, String vendedor) {
        Producto p = new Producto();
        p.setId(0);
        p.setNombre(nombre);
        p.setVendedor(vendedor);
        p.setCaducidad(currentTime());
        p.setCantidad(0);
        p.setPrecio(0);
        p.setImagen("https://1.bp.blogspot.com/-uzkzs5rLDxs/UYNNYXpt-xI/AAAAAAAAI78/ooSuJHSNu1M/s1600/Cut_Mango_1000.JPG");
        p.setDetalles("");
        return p;
    }

    private ProductoService port;

    public ProductoFacade() {
        try {
            port = new ProductoService_Service().getProductoServicePort();
        } catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Servicio no disponible o inaccesible");
            alert.setContentText("La aplicación se cerrará.");
            alert.showAndWait();
            System.exit(1);
        }
    }


    public void removeProduct(Producto p){
        if (p.getId() == null || p.getId() == 0) {
            throw new OperationException("Producto no válido");
        }

        try {
            port.remove(p);
        } catch (RuntimeException ex) {
            throw new OperationException("Producto no encontrado");
        }

    }

    public List<Producto> findAll(){
        return port.findAll();
    }

    public List<Producto> findCaducados(Date d) {
        return new ArrayList<>();
    }

    public void crear(Producto p) {
        if(!validate(p)) throw new RuntimeException("producto invalido");
        port.create(p);
    }

    public void editar(Producto p){
        if(!validate(p)) throw new RuntimeException("producto invalido");
        port.edit(p);
    }


    private boolean validate(Producto prod) {
        if (prod == null) {
            return false;
        }
        boolean okNombre = notBlank(prod.getNombre());
        boolean okVendedor = notBlank(prod.getVendedor());
        boolean okPrecio = prod.getPrecio() > 0;
        boolean okCantidad = prod.getCantidad() > 0;
        return  okNombre && okVendedor && okCantidad && okPrecio;
    }

    private boolean notBlank(String str) {
        return str != null && !"".equals(str);
    }

}
