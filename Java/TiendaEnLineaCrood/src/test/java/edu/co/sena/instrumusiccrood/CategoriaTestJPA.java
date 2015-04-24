
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
public class CategoriaTestJPA {
    
    Categoria categ;
    EntityManager em;
    
    public CategoriaTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        categ = new Categoria();
        categ.setIdCategoria(1);
        categ.setNombreCategoria("guitarra ");
        categ.setActiva(true);
        categ.setPariente(1);
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
    public void insertarCategoria(){
    
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(categ);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
    
      @Test
    public void actualizarCategoria() {

        String catId = JOptionPane.showInputDialog("Digite el carrito que va actualizar");
        String catNombre = JOptionPane.showInputDialog("Digite el nonmbre para actualizar");

        categ.setIdCategoria(Integer.valueOf(catId));
        categ.setNombreCategoria(catNombre);
        
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(categ);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        
        
    }
    
    @Test
    public void eliminarCategoria(){
    
        String catId = JOptionPane.showInputDialog("Digite la categoria que va a eliminar");
       
        try { 
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Categoria.class, Integer.parseInt(catId)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }
    
    
     @Test
    public void BuscarIdCategoria() {

        String idCategoria = JOptionPane.showInputDialog("Digite el Id de la categoria de la categoria");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Categoria.findByIdCategoria");
        query.setParameter("idCategoria", Integer.parseInt(idCategoria));

        List<Categoria> li = query.getResultList();
        for (Categoria li1 : li) {
            System.out.println("IdCategoria :" + li1.getIdCategoria()
                    + "| nombreCategoria " + li1.getNombreCategoria()
                    + " | activa: " + li1.getActiva()
                    + "| pariente : " + li1.getPariente());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
      @Test
    public void BuscarNombreCategoria() {

        String nombreCategoria = JOptionPane.showInputDialog("Digite el nombre de la categoria");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Categoria.findByNombreCategoria");
        query.setParameter("nombreCategoria", nombreCategoria);

        List<Categoria> li = query.getResultList();
        for (Categoria li1 : li) {
            System.out.println("IdCategoria :" + li1.getIdCategoria()
                    + "| nombreCategoria " + li1.getNombreCategoria()
                    + " | activa: " + li1.getActiva()
                    + "| pariente : " + li1.getPariente());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
     @Test
    public void BuscarActiva() {

        String activa = JOptionPane.showInputDialog("Digite el activo de categoria");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Categoria.findByActiva");
        query.setParameter("activa", Boolean.parseBoolean(activa));

       List<Categoria> li = query.getResultList();
        for (Categoria li1 : li) {
            System.out.println("IdCategoria :" + li1.getIdCategoria()
                    + "| nombreCategoria :" + li1.getNombreCategoria()
                    + "| activa: " + li1.getActiva()
                    + "| pariente : " + li1.getPariente());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void BuscarPariente() {

        String pariente = JOptionPane.showInputDialog("Digite el activo de categoria");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Categoria.findByPariente");
        query.setParameter("pariente",Integer.parseInt(pariente));

       List<Categoria> li = query.getResultList();
        for (Categoria li1 : li) {
            System.out.println("IdCategoria :"+ li1.getIdCategoria()
                    + "| nombreCategoria :" + li1.getNombreCategoria()
                    + "| activa : " + li1.getActiva()
                    + "| pariente : " + li1.getPariente());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
