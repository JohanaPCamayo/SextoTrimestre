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
public class DomicilioProveedorTestJPA {
    
    DomicilioProveedor dompr;
    EntityManager em;
    
    public DomicilioProveedorTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dompr = new DomicilioProveedor();
        dompr.setDomicilioProveedorPK(new DomicilioProveedorPK("T.I", "95080904852"));
        dompr.setTelefono("4510357");
        dompr.setDireccion("Calle 69 B 3 -40 sur");        
        dompr.setBarrio("Aurora");
        dompr.setLocalidad("Usme");
        dompr.setMunicipioidMunicipio(new Municipio("1"));
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
    public void insertarDomicilioProveedor(){
    
        em=EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(dompr);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
    
  @Test
    public void actualizarDomicilioDelProveedor() {

        String prvId = JOptionPane.showInputDialog("Digite tipo de documento del proveedor para actualizar");
        String prvId2 = JOptionPane.showInputDialog("Digite numero documento del proveedor para actualizar");
        String prbarr = JOptionPane.showInputDialog("Digite el barrio para actialuzar");

        dompr.setDomicilioProveedorPK(new DomicilioProveedorPK(prvId, prvId2));
        dompr.setTelefono(prbarr);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(dompr);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    
      @Test
    public void eliminarDomicilioDelProveedor(){
    
        String domprId = JOptionPane.showInputDialog("Digite el Id del proveedor que va a eliminar");
        
        try {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Proveedor.class, domprId));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }
}
