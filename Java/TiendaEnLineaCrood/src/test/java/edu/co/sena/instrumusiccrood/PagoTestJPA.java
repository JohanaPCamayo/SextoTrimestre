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
public class PagoTestJPA {

    Pago pag;
    EntityManager em;

    public PagoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pag = new Pago();
        pag.setFacturaidFactura(1);
        pag.setNumTarCredito("454103454210");
        pag.setBanco("Davivienda");
        pag.setTipoCuentaTar("Corriente");
        pag.setTipoTransaccion("ATH");
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
    public void insertarPago() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(pag);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarPago() {

        String pagoId = JOptionPane.showInputDialog("Digite el id de la factura para actualizar el pago");
        String pagoNum = JOptionPane.showInputDialog("Digite el numero de tarjeta de credito para actualizar");

        pag.setFacturaidFactura(Integer.valueOf(pagoId));
        pag.setNumTarCredito(pagoNum);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(pag);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void eliminarPago() {

        String pagId = JOptionPane.showInputDialog("Digite el id de la factura del pago que va a eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Pago.class, Integer.parseInt(pagId)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }

    @Test
    public void BuscarIdFactura() {

       String pagoId = JOptionPane.showInputDialog("Digite el id de la factura del pago");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Pago pago= em.find(Pago.class, Integer.parseInt(pagoId));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();    
        System.out.println(pago.toString());
    }
    
    
     @Test
    public void buscarNumeroDeTarjetaDeCretido() {

        String numTarCredito = JOptionPane.showInputDialog("Digite el tipo de tarjeta de credito");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Pago.findByNumTarCredito");
        query.setParameter("numTarCredito", numTarCredito);

        List<Pago> li = query.getResultList();
        for (Pago li1 : li) {
            System.out.println("facturaidFactura :" + li1.getFactura().getIdFactura()
                    + " | numTarCredito :" + li1.getNumTarCredito()
                    + " | banco : " + li1.getBanco()
                    + " | tipoCuentaTar :" + li1.getTipoCuentaTar()
                    + " | tipoTransaccion :" + li1.getTipoTransaccion()); 
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void buscarBanco() {

        String banco = JOptionPane.showInputDialog("Digite el banco");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Pago.findByBanco");
        query.setParameter("numeroTarjeta", banco);

        List<Pago> lis = query.getResultList();
        for (Pago li1 : lis) {
            System.out.println("facturaidFactura :" + li1.getFactura().getIdFactura()
                    + " | numTarCredito :" + li1.getNumTarCredito()
                    + " | banco : " + li1.getBanco()
                    + " | tipoCuentaTar :" + li1.getTipoCuentaTar()
                    + " | tipoTransaccion :" + li1.getTipoTransaccion());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
     @Test
    public void buscarTipoCuentaTar() {

        String tipoCuentaTar = JOptionPane.showInputDialog("Digite el tipo de cuenta");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Pago.findByTipoCuentaTar");
        query.setParameter("tipoCuentaTar", tipoCuentaTar);

        List<Pago> lis = query.getResultList();
        for (Pago li1 : lis) {
            System.out.println("facturaidFactura :" + li1.getFactura().getIdFactura()
                    + " | numTarCredito :" + li1.getNumTarCredito()
                    + " | banco : " + li1.getBanco()
                    + " | tipoCuentaTar :" + li1.getTipoCuentaTar()
                    + " | tipoTransaccion :" + li1.getTipoTransaccion());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
     @Test
    public void buscarTipoTransaccion() {

        String tipoTransaccion = JOptionPane.showInputDialog("Digite eltipo de trasaccion");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Pago.findByTipoTransaccion");
        query.setParameter("tipoTransaccion", tipoTransaccion);

        List<Pago> lis = query.getResultList();
        for (Pago li1 : lis) {
            System.out.println("facturaidFactura :" + li1.getFactura().getIdFactura()
                    + " | numTarCredito :" + li1.getNumTarCredito()
                    + " | banco : " + li1.getBanco()
                    + " | tipoCuentaTar :" + li1.getTipoCuentaTar()
                    + " | tipoTransaccion :" + li1.getTipoTransaccion());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
