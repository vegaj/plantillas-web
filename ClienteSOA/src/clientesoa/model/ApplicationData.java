/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesoa.model;

import java.util.Arrays;
import java.util.List;
import ws.Producto;

/**
 *
 * @author jose
 */
public class ApplicationData {
    
    private List<Producto> listaProductos;
    private User usuario;
    
    public ApplicationData() {
        listaProductos = Arrays.asList(new Producto[]{});
        usuario = null;
    }
    
    public void loggin(String email, String nombre) {
        usuario = new User();
        usuario.email = email;
        usuario.nombre  = nombre;
    }
    
    public boolean logged() {
        return usuario != null;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    
}
