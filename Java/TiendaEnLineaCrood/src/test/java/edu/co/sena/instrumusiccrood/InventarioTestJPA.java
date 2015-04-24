/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class InventarioTestJPA {
    
    Inventario inv;
    EntityManager em;
    Calendar hoy = Calendar.getInstance();
    Date fechaActual = new Date();
    
    public InventarioTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        fechaActual = hoy.getTime();
        inv = new Inventario();
        inv.setFecha(fechaActual);
        inv.setCantidad(12);
        inv.setInventarioPK(new InventarioPK(1, "1", "1", "T.I"));
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void insertarInventario(){
    
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(inv);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void actualizarInventario(){
    
        String invId = JOptionPane.showInputDialog("Digite el Id inventario que va actualizar");
        String invId2 = JOptionPane.showInputDialog("Digite el id de producto que va actualizar");
        String invId3 = JOptionPane.showInputDialog("Digite el id del proveedor que va actualizar");
        String invId4 = JOptionPane.showInputDialog("Digite el tipo de documento del proveedor para actualizar");
        String invCa = JOptionPane.showInputDialog("Digite la cantidad");
       
        inv.setInventarioPK(new InventarioPK(Integer.parseInt(invId), invId2, invId3, invId4));
        inv.setCantidad(Integer.valueOf(invCa));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(inv);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    
    }
    
       @Test
    public void eliminarInventario(){
    
        String invId = JOptionPane.showInputDialog("Digite el id del inventario que va a eliminar");
        String invId2 = JOptionPane.showInputDialog("Digite el id del producto del inventario que va a eliminar");
         
        try { 
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        //em.remove(em.find(Inventario.class, new InventarioPK(Integer.parseInt(invId), invId2)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }
}
