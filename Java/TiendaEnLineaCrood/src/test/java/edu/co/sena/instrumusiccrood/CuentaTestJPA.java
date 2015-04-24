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
 * @author ColsutecR
 */
public class CuentaTestJPA {

    Cuenta cu;
    EntityManager em;

    public CuentaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        cu = new Cuenta();
        cu.setCuentaPK(new CuentaPK("T.I", "97101306287"));
        cu.setPrimerNombre("Johana");
        cu.setSegundoNombre("Paola");
        cu.setPrimerApellido("Camayo");
        cu.setSegundoApellido("Camayo");
        cu.setUsuarioidUsuario(new Usuario("1"));
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
    public void insertarCuenta() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(cu);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void actualizarCuenta() {

        String cuId = JOptionPane.showInputDialog("Digite tipo de documento de la cuenta que va actualizar");
        String cuId1 = JOptionPane.showInputDialog("Digite numero de documento de la cuenta que va actualizar");
        String cuCorr = JOptionPane.showInputDialog("Digite el correo para actualizar");

        cu.setCuentaPK(new CuentaPK(cuId, cuId1));;
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(cu);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void eliminarCuenta() {

        String cuId = JOptionPane.showInputDialog("Digite el tipo de documento de la cuenta para eliminar");
        String cuId2 = JOptionPane.showInputDialog("Digite el numero de documento de la cuenta para eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Cuenta.class, new CuentaPK(cuId, cuId2)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }

    @Test
    public void actualizarPKCuenta() {

        em = EntityManagerHelper.getEntityManager();
        String cuViId = JOptionPane.showInputDialog("Digite el tipo documento de la cuenta que va a actualizar");
        String cuViId2 = JOptionPane.showInputDialog("Digite el numero documento de la cuenta que va a actualizar");
        String cuNuId2 = JOptionPane.showInputDialog("Digite el nuevo Id de la cuenta para actualizar");
        EntityManagerHelper.beginTransaction();
        Cuenta cu = em.find(Cuenta.class, cuNuId2);
        cu.setCuentaPK(new CuentaPK(cuViId, cuViId2));
        em.merge(cu);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarCuenta() {

        String tipoDocumento = JOptionPane.showInputDialog("Digite el tipo de documento de la cuenta");
        String numeroDocumento = JOptionPane.showInputDialog("Digite el numero de documento de la cuenta");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Cuenta cu = em.find(Cuenta.class, new CuentaPK(tipoDocumento, numeroDocumento));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(cu.toString());
    }

    @Test
    public void BuscarPrimerNombre() {

        String primerNombre = JOptionPane.showInputDialog("Digite el primer nombre de la cuenta");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findByPrimerNombre");
        query.setParameter("primerNombre", primerNombre);

        List<Cuenta> li = query.getResultList();
        for (Cuenta li1 : li) {
            System.out.println("tipoDocuemnto :" 
                    + "| numeroDocumento :" + li1.getClass()
                    + "| primernombre :" + li1.getPrimerNombre()
                    + "| segundoNombre : " + li1.getSegundoNombre()
                    + "| primerApellido :" + li1.getPrimerApellido()
                    + "| segundoApellido :" + li1.getSegundoApellido()
                    + "| usuarioidUsuario :" + li1.getUsuarioidUsuario());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
