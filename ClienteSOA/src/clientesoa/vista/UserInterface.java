/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesoa.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import ws.Producto;

/**
 *
 * @author jose
 */
public class UserInterface extends JPanel {
    
    private JButton newBtn, editBtn, deleteBtn; 
    private JScrollPane scrollPane;
    private JList<Producto> listaProductos = new JList<>(new Producto[]{});
    
    public UserInterface() {
        
        newBtn = new JButton("NEW");
        editBtn = new JButton("EDIT");
        deleteBtn = new JButton("DELETE");
        
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(newBtn);
        top.add(editBtn);
        top.add(deleteBtn);
        
        scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);       
        scrollPane.remove(listaProductos);
        
        this.setLayout(new BorderLayout());
        this.add(top,BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }
    
    public void setListaProductos(List<Producto> list) {
        listaProductos.setListData((Producto[]) list.toArray());
    }
    
    
}
