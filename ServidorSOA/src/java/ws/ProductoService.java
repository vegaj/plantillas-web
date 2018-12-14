/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import beans.ProductoFacadeLocal;
import entity.Producto;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.NoResultException;

/**
 *
 * @author jose
 */
@WebService(serviceName = "ProductoService")
@Stateless()
public class ProductoService {

    @EJB
    private ProductoFacadeLocal ejbRef;

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "producto") Producto producto) {
        if (!validate(producto)) {
            throw new ValidationException("Campos de producto",
                    "Vendedor y Nombre deben estar presente, el precio positivo y la cantidad positiva o 0");
        }
        ejbRef.create(producto);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "producto") Producto producto) {
        ejbRef.edit(producto);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "producto") Producto producto) {
        ejbRef.remove(producto);
    }

    @WebMethod(operationName = "find")
    public Producto find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Producto> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Producto> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
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

    /**
     * 
     * @param id the id of the product to buy.
     * @param amount number of units to buy.
     * @return price to pay;
     */
    @WebMethod(operationName = "compar")
    public Float buyProduct(@WebParam(name="id") Object id, @WebParam(name = "cantidad") final int amount) throws NotAvailableException, NotFoundException, ValidationException {
        
        Producto p;
        try{
            p = find(id);
        } catch(NoResultException e) {
            throw new NotFoundException();
        }
        
        if (amount < 0) {
            throw new ValidationException("cantidad", "es negativa");
        }
        
        if (p.getCantidad() >= amount) {
            p.setCantidad(p.getCantidad() - amount);
            ejbRef.edit(p);
        } else {
            throw new NotAvailableException(amount, p.getCantidad());
        }
        
        return (float) (amount * p.getPrecio());
    }
    
    @WebMethod(operationName = "reponer")
    public void refillProduct(@WebParam(name="id") Object id, @WebParam(name="cantidad")Integer cantidad) throws ValidationException, NotFoundException {
        Producto p;
        try {
            p = find(id);
        } catch(NoResultException e) {
            throw new NotFoundException();
        }
        
        if (cantidad < 0) {
            throw new ValidationException("cantidad", "es negativa");
        }
        
        p.setCantidad(p.getCantidad() + cantidad);
        ejbRef.edit(p);
    }

    @WebMethod(operationName = "caducadosDesde")
    public List<Producto> getCaducados(@WebParam(name = "desde") Date desde) {
        if (desde == null) desde = new Date(System.currentTimeMillis());
        List<Producto> prod = ejbRef.caducadosFecha(desde);
        return prod;
    }    
}
