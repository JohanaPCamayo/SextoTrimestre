/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
public class ItemTestJPA {
    
    Item it;
    EntityManager em;
    
    public ItemTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        it = new Item();
        it.setItemPK(new ItemPK("1", 1));
        it.setCantidad(10);
        it.setCostoUnitario(40000);
        it.setCostoTotal(500000);
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
    public void insertarItem(){
    
         em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(it);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
     @Test
    public void actualizarItem(){
    
        String itId = JOptionPane.showInputDialog("Digite el id del producto");
        String itId2 = JOptionPane.showInputDialog("Digite el id de la factura para el item que va actualizar");
        String itCosTo = JOptionPane.showInputDialog("Digite el costo total para actualizar");
       
        it.setItemPK(new ItemPK(itId, Integer.valueOf(itId2)));
        it.setCostoTotal(Float.valueOf(itCosTo));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(it);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    
    }
    
     @Test
    public void eliminarItem(){
    
        String itId = JOptionPane.showInputDialog("Digite el id del producto del item que va a eliminar");
        String itId2 = JOptionPane.showInputDialog("Digite el el id del pedido del item que va a eliminar");
       
        try { 
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Item.class, new ItemPK(itId, Integer.parseInt(itId2))));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }
        
    
    @Test
    public void BuscarProductoIdProducto() {

        String productoidProducto = JOptionPane.showInputDialog("Digite el Id del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Carritodecompras.findBySubtotal");
        query.setParameter("productoidProducto", productoidProducto);

        List<Item> li = query.getResultList();
        for (Item li1 : li) {
            System.out.println("productoidProducto :" + li1.getItemPK()
                    + "| subtotal :" + li1.getCantidad()
                    + "| precioTotal : " + li1.getCostoUnitario()
                    + "| impuesto :" + li1.getCostoTotal());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
