/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesoa;

import clientesoa.model.ApplicationData;
import clientesoa.vista.UserInterface;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author jose
 */
public class ClienteSOA {

    private static ApplicationData model;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ws.ProductoService port = new ws.ProductoService_Service().getProductoServicePort();
        System.out.println(port.count());
        System.out.println(Arrays.toString(port.findAll().toArray()));
        
        System.out.println("Iniciando...");
        model = new ApplicationData();
        
        UserInterface ui = new UserInterface();
        ui.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        ui.add(new JButton("WEST"), BorderLayout.WEST);
        ui.add(new JButton("EAST"), BorderLayout.EAST);
        
        JFrame f = new JFrame("Cliente SOA");
        f.setSize(new Dimension(800, 480));
        f.setMinimumSize(new Dimension(800, 480));
        f.setContentPane(ui);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
