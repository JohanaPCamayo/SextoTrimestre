/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import java.util.Calendar;
import java.util.Date;
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
public class FacturaTestJPA {

    Factura fac;
    EntityManager em;
    Calendar hoy = Calendar.getInstance();
    Date fechaActual = new Date();

    public FacturaTestJPA() {
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
        fac = new Factura();
        fac.setFecha(fechaActual);
        fac.setTotal(0);
        fac.setCuenta(new Cuenta("T.I", "97101306287"));
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
    public void insertarFactura() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(fac);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarFactura() {

        String facId = JOptionPane.showInputDialog("Digite la factura que va actualizar");
        String facId2 = JOptionPane.showInputDialog("Digite la total para actualizar");

        fac.setIdFactura(Integer.valueOf(facId));
        fac.setTotal(Float.valueOf(facId2));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(fac);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void eliminarFactura() {

        String facId = JOptionPane.showInputDialog("Digite el id de la factura que va a eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Factura.class, Integer.parseInt(facId)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }

    @Test
    public void BuscarIdFactura() {

        String idFactura = JOptionPane.showInputDialog("Digite el id de la factura");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Factura fac = em.find(Factura.class, Integer.parseInt(idFactura));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(fac.toString());
    }
    
    
     @Test
    public void buscarFecha() {

        String fecha = JOptionPane.showInputDialog("Digite la fecha de la factura");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Factura.findByFecha");
        query.setParameter("fecha", fecha);

        List<Factura> list = query.getResultList();
        for (Factura list1 : list) {
            System.out.println("ID Factura: " + list1.getIdFactura()
                    + " | Fecha: " + list1.getFecha()
                    + " | Tipo Documento: " + list1.getCuenta().getCuentaPK().getTipoDocumento()
                    + " | Numero Documento: " + list1.getCuenta().getCuentaPK().getNumeroDocumento());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
