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
public class ProveedorTestJPA {
    
    Proveedor prv;
    EntityManager em;
    
    public ProveedorTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        prv = new Proveedor();
        prv.setProveedorPK(new ProveedorPK("T.I", "95080904852"));
        prv.setNombre("Jhon Alex");
        prv.setEmail("Jalexguitierritos@hotmail.com");
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
    public void insertarProveedor(){
    
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(prv);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void actualizarProveedor() {

        String prvId = JOptionPane.showInputDialog("Digite tipo de documento del proveedor para actualizar");
        String prvId2 = JOptionPane.showInputDialog("Digite numero documento del proveedor para actualizar");
        String prvNom = JOptionPane.showInputDialog("Digite el telefono para actialuzar");

        prv.setProveedorPK(new ProveedorPK(prvId, prvId2));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(prv);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    
      @Test
    public void eliminarProveedor(){
    
        String prvId = JOptionPane.showInputDialog("Digite el Id del proveedor que va a eliminar");
        
        try {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Proveedor.class, prvId));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }
    
    @Test
    public void actualizarPKProveedor(){
    
        em = EntityManagerHelper.getEntityManager();
        String prViId = JOptionPane.showInputDialog("Digite el Id del proveedor que va a actualizar");
        String prNId2 = JOptionPane.showInputDialog("Digite el nuevo Id del proveedor para actualizar");
        EntityManagerHelper.beginTransaction();
        Proveedor prv = em.find(Proveedor.class, prViId);
        em.merge(prv);
         EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        
    }
    
    
    @Test
    public void BuscarIdProveedor() {

        String idProveedor = JOptionPane.showInputDialog("Digite el id del proveeedor");
        String idProveedor2 = JOptionPane.showInputDialog("Digite el tipo de docuemnto del proveeedor");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Proveedor.findByIdProveedor");
        query.setParameter("idProveedor", idProveedor);
        query.setParameter("tipoDeIdentidad", idProveedor2);

        List<Proveedor> li = query.getResultList();
        for (Proveedor li1 : li) {
            System.out.println("idProveedor :" + li1.getProveedorPK()
                    + "| nombre :" + li1.getNombre()
                    + "| email :" + li1.getEmail());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
