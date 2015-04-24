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
public class PedidoTestJPA {

    Pedido ped;
    EntityManager em;

    public PedidoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        ped = new Pedido();
        ped.setFacturaidFactura(1);
        ped.setTotal(0);
        ped.setSubtotal(0);
        ped.setImpuestos(0);
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
    public void insertarPedido() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(ped);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarPedido() {

        String peId = JOptionPane.showInputDialog("Digite el id de la factura para actualizar el pedido");
        String peSub = JOptionPane.showInputDialog("Digite el subtotal para actualizar");
        String peTo = JOptionPane.showInputDialog("Digite el total para actualizar");

        ped.setFacturaidFactura(Integer.valueOf(peId));
        ped.setSubtotal(Float.valueOf(peSub));
        ped.setTotal(Float.valueOf(peTo));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(ped);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void eliminarPedido() {

        String pedId = JOptionPane.showInputDialog("Digite el id de la factura del pedido que va a eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Pedido.class, Integer.parseInt(pedId)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }

    
     @Test
    public void buscarIdPedido(){
    
        String idPedido = JOptionPane.showInputDialog("Digite el id de la factura del pedido");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Pedido pedi= em.find(Pedido.class, Integer.parseInt(idPedido));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    
        System.out.println(pedi.toString());
    }
    
    
    @Test
    public void BuscarTotal() {

        String total = JOptionPane.showInputDialog("Digite el total del pedido");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Pedido.findByTotal");
        query.setParameter("total", Float.parseFloat(total));

        List<Pedido> li = query.getResultList();
        for (Pedido li1 : li) {
            System.out.println("Factura_idFactura" + li1.getFacturaidFactura()
                    + "| total :" + li1.getTotal()
                    + "| subtotal : " + li1.getSubtotal()
                    + "| impuestos : " + li1.getImpuestos());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
     @Test
    public void BuscarSubtotal() {

        String subtotal = JOptionPane.showInputDialog("Digite el subtotal del pedido");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query query = em.createNamedQuery("Pedido.findBySubtotal");
        query.setParameter("subtotal", Float.parseFloat(subtotal));

        List<Pedido> li = query.getResultList();
        for (Pedido li1 : li) {
            System.out.println("FacturaidFactura" + li1.getFacturaidFactura()
                    + "| total :" + li1.getTotal()
                    + "| subtotal : " + li1.getSubtotal()
                    + "| impuestos : " + li1.getImpuestos());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
     @Test
    public void BuscarImpuesto() {

        String impuestos = JOptionPane.showInputDialog("Digite el impuesto del pedido");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Pedido.findByImpuestos");
        query.setParameter("impuesto", Float.parseFloat(impuestos));

        List<Pedido> li = query.getResultList();
        for (Pedido li1 : li) {
            System.out.println("Factura_idFactura" + li1.getFacturaidFactura()
                    + "| total :" + li1.getTotal()
                    + "| subtotal : " + li1.getSubtotal()
                    + "| impuestos : " + li1.getImpuestos());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
