/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
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
public class ItemCarritoTestJPA {
    
    ItemCarrito itc;
    EntityManager em;
    
    public ItemCarritoTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        itc = new ItemCarrito();
        itc.setCantidad(10);
        itc.setCostoUnitario(350000);
        itc.setCostoTotal(420000);
        itc.setItemCarritoPK(new ItemCarritoPK("1", "1"));
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
    public void insertarItemCarrito(){
    
         em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(itc);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
      @Test
    public void actualizarItemCarrito(){
    
        String itcId = JOptionPane.showInputDialog("Digite el id del producto para actualizar");
        String itcId2 = JOptionPane.showInputDialog("Digite el item de carrito que va actualizar");
        String itcCosTo = JOptionPane.showInputDialog("Digite la cantidad que va actualizar");
       
        itc.setItemCarritoPK(new ItemCarritoPK(itcId, itcId2));
        itc.setCostoTotal(Float.valueOf(itcCosTo));

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(itc);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
          
    }
    
       @Test
    public void eliminarItemCarrito(){
    
        String carId = JOptionPane.showInputDialog("Digite el id del producto del item del carrito para eliminar");
        String carId2 = JOptionPane.showInputDialog("Digite el el id del carrito de compras del item del carrito para eliminar");
       
        try { 
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(ItemCarrito.class, new ItemCarritoPK(carId, carId2)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }
}
