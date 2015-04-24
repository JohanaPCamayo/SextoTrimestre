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
public class UsuarioTestJPA {

    Usuario us;
    EntityManager em;

    public UsuarioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        us = new Usuario();
        us.setIdUsuario("1");
        us.setContrasena("45421ddd");
        us.setRol("Cliente");
        us.setEstado("1");
        us.setEmail("maicol45op@gmail.com");
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
    public void insertarUsuario() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(us);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarUsuario() {

        String usuId = JOptionPane.showInputDialog("Digite el usuario que va actualizar");
        String usuPas = JOptionPane.showInputDialog("Digite la contraseña para actualizar");

        us.setIdUsuario(usuId);
        us.setContrasena(usuPas);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(us);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void eliminarUsuario() {

        String usuId = JOptionPane.showInputDialog("Digite el usuario que va a eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Usuario.class, usuId));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }

    @Test
    public void BuscarIdUsuario() {

        String idUsuario = JOptionPane.showInputDialog("Digite el Id del usuario");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Usuario.findByIdUsuario");
        query.setParameter("idUsuario", idUsuario);

        List<Usuario> li = query.getResultList();
        for (Usuario li1 : li) {
            System.out.println("idUsuario :" + li1.getIdUsuario()
                    + "| contrasena :" + li1.getContrasena()
                    + "| rol :" + li1.getRol()
                    + "| estado :" + li1.getEstado()
                    + "| email : " + li1.getEmail());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
    @Test
    public void BuscarContrasena() {

        String contrasena = JOptionPane.showInputDialog("Digite la contrasena del usuario");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Usuario.findByContrasena");
        query.setParameter("contrasena", contrasena);

        List<Usuario> li = query.getResultList();
        for (Usuario li1 : li) {
            System.out.println("idUsuario :" + li1.getIdUsuario()
                    + "| contrasena :" + li1.getContrasena()
                    + "| rol :" + li1.getRol()
                    + "| estado :" + li1.getEstado()
                    + "| email : " + li1.getEmail());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
     @Test
    public void BuscarRol() {

        String rol = JOptionPane.showInputDialog("Digite el rol del usuario");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Usuario.findByRol");
        query.setParameter("rol", rol);

        List<Usuario> li = query.getResultList();
        for (Usuario li1 : li) {
            System.out.println("idUsuario :" + li1.getIdUsuario()
                    + "| contrasena :" + li1.getContrasena()
                    + "| rol :" + li1.getRol()
                    + "| estado :" + li1.getEstado()
                    + "| email : " + li1.getEmail());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
     @Test
    public void BuscarEstado() {

        String estado = JOptionPane.showInputDialog("Digite el estado del usuario");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Usuario.findByEstado");
        query.setParameter("estado", estado);

        List<Usuario> li = query.getResultList();
        for (Usuario li1 : li) {
            System.out.println("idUsuario :" + li1.getIdUsuario()
                    + "| contrasena :" + li1.getContrasena()
                    + "| rol :" + li1.getRol()
                    + "| estado :" + li1.getEstado()
                    + "| email : " + li1.getEmail());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
     @Test
    public void BuscarEmail() {

        String email = JOptionPane.showInputDialog("Digite la email del usuario");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Usuario.findByEmail");
        query.setParameter("email", email);

        List<Usuario> li = query.getResultList();
        for (Usuario li1 : li) {
            System.out.println("idUsuario :" + li1.getIdUsuario()
                    + "| contrasena :" + li1.getContrasena()
                    + "| rol :" + li1.getRol()
                    + "| estado :" + li1.getEstado()
                    + "| email : " + li1.getEmail());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
