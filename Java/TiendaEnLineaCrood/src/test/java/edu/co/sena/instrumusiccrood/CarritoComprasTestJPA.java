/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 *
 * @author ColsutecR
 */
public class CarritoComprasTestJPA {

    Carritodecompras carritoCompras;

    EntityManager em;

    public CarritoComprasTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        carritoCompras = new Carritodecompras();
        carritoCompras.setIdCarritoDeCompras("1");
        carritoCompras.setSubtotal(0);
        carritoCompras.setPrecioTotal(0);
        carritoCompras.setImpuestos(0);

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
    public void insertaCarritoCompras() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(carritoCompras);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }

    @Test
    public void actualizarCarritoCompras() {

        String carId = JOptionPane.showInputDialog("Digite el carrito que va actualizar");
        String carPreTo = JOptionPane.showInputDialog("Digite el precio total para actualizar");
        carritoCompras.setIdCarritoDeCompras(carId);
        carritoCompras.setPrecioTotal(Float.valueOf(carPreTo));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(carritoCompras);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void eliminarCarritoDeCompras() {

        String caId = JOptionPane.showInputDialog("Digite el carrito que va a eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Carritodecompras.class, caId));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }

    @Test
    public void buscarCarritoCompras() {

        String idCarritoCompras = JOptionPane.showInputDialog("insertar el ID de carrito de compras");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
    }
    
    
    @Test
    public void BuscarIdCarritoDeCompras() {

        String idCarritoDeCompras = JOptionPane.showInputDialog("Digite el Id de carrito de compras");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Carritodecompras.findByIdCarritoDeCompras");
        query.setParameter("idCarritoDeCompras", idCarritoDeCompras);

        List<Carritodecompras> li = query.getResultList();
        for (Carritodecompras li1 : li) {
            System.out.println("IdCarrito :" + li1.getIdCarritoDeCompras()
                    + "| subtotal :" + li1.getSubtotal()
                    + "| precioTotal: " + li1.getPrecioTotal()
                    + "| impuesto: " + li1.getImpuestos());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarSubtotal() {

        String subtotal = JOptionPane.showInputDialog("Digite el subtotal del carrito de compras");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Carritodecompras.findBySubtotal");
        query.setParameter("subtotal", Float.parseFloat(subtotal));

        List<Carritodecompras> li = query.getResultList();
        for (Carritodecompras li1 : li) {
            System.out.println("IdCarrito :" + li1.getIdCarritoDeCompras()
                    + "| subtotal :" + li1.getSubtotal()
                    + "| precioTotal : " + li1.getPrecioTotal()
                    + "| impuesto :" + li1.getImpuestos());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarPrecioTotal() {

        String precioTotal = JOptionPane.showInputDialog("Digite el precio total del carrito de compras");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Carritodecompras.findByPrecioTotal");
        query.setParameter("precioTotal", Float.parseFloat(precioTotal));

        List<Carritodecompras> li = query.getResultList();
        for (Carritodecompras li1 : li) {
            System.out.println("IdCarrito :" + li1.getIdCarritoDeCompras()
                    + "| subTotal :" + li1.getSubtotal()
                    + " | precioTotal : " + li1.getPrecioTotal()
                    + "| impuestos :" + li1.getImpuestos());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarImpuesto() {

        String impuestos = JOptionPane.showInputDialog("Digite el impuesto del carrito de compras");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Carritodecompras.findByImpuestos");
        query.setParameter("impuestos", Float.parseFloat(impuestos));

        List<Carritodecompras> li = query.getResultList();
        for (Carritodecompras li1 : li) {
            System.out.println("IdCarrito :" + li1.getIdCarritoDeCompras()
                    + "| subTotal :" + li1.getSubtotal()
                    + " | precioTotal : " + li1.getPrecioTotal()
                    + "| impuestos :" + li1.getImpuestos());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
