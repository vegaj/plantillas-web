/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Producto;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jose
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "ServidorSOAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    public List<Producto> caducadosFecha(Date fecha) {
        TypedQuery<Producto> tq = getEntityManager().createQuery("SELECT p FROM Producto p WHERE p.caducidad < :fecha", Producto.class);
        tq.setParameter("fecha", fecha);
        return tq.getResultList();
    }
    
}
