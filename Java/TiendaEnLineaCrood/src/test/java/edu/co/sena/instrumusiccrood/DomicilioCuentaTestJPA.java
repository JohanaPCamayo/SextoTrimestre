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
 * @author ColsutecR
 */
public class DomicilioCuentaTestJPA {
    
    DomicilioCuenta domCu;
    EntityManager em;
    
    public DomicilioCuentaTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        domCu = new DomicilioCuenta();
        domCu.setDomicilioCuentaPK(new DomicilioCuentaPK("T.I", "97101306287"));
        domCu.setTelefono("7688011");
        domCu.setDireccion("Crr 1a 78-17 sur");
        domCu.setBarrio("teneriffe");
        domCu.setLocalidad("Usme");
        domCu.setMunicipioidMunicipio(new Municipio("1"));
        
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
    public void insertarDomicilioCuenta(){
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(domCu);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void actualizarDomicilioDeLaCuenta() {

        String doCuId = JOptionPane.showInputDialog("Digite tipo de documento de la cuenta para actualizar");
        String doCud2 = JOptionPane.showInputDialog("Digite numero documento de la cuenta para actualizar");
        String prbarr = JOptionPane.showInputDialog("Digite el barrio para actialuzar");

        domCu.setDomicilioCuentaPK(new DomicilioCuentaPK(doCuId, doCud2));
        domCu.setTelefono(prbarr);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(domCu);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    
      @Test
    public void eliminarDomicilioDeLaCuenta(){
    
        String domCuId = JOptionPane.showInputDialog("Digite el Id del proveedor que va a eliminar");
        
        try {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Proveedor.class, domCuId));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }
}
