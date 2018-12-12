/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import beans.ProductoFacadeLocal;
import entity.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

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

    /**
     * Tries to buy 
     * @param amount number of units to buy
     * @return price to pay;
     */
    @WebMethod(operationName = "BuyProduct")
    public Float BuyProduct(@WebParam(name = "amount") final int amount) throws NotAvailableException { 
        //TODO write your implementation code here:
        return null;
    }
    
    
    
}
