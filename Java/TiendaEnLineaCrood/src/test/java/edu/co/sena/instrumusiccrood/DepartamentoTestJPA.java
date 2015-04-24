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
public class DepartamentoTestJPA {

    Departamento dep;
    EntityManager em;

    public DepartamentoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        dep = new Departamento();
        dep.setIdDepartamento("1");
        dep.setNombre("Antioquia");
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
    public void insertarDepartamento() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(dep);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarDepartamento() {

        String depId = JOptionPane.showInputDialog("Digite el departamento que va actualizar");
        String depNom = JOptionPane.showInputDialog("Digite el nombre para actualizar");

        dep.setIdDepartamento(depId);
        dep.setNombre(depNom);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(dep);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void eliminarDepartamento() {

        String depId = JOptionPane.showInputDialog("Digite el Id del departamento que va a eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Departamento.class, depId));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }

    @Test
    public void BuscarIdDepartamento() {

        String idDepartamento = JOptionPane.showInputDialog("Digite el id del departamento");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Departamento.findByIdDepartamento");
        query.setParameter("idDepartamento", idDepartamento);

        List<Departamento> li = query.getResultList();
        for (Departamento li1 : li) {
            System.out.println("idDepartamento :" + li1.getIdDepartamento()
                    + "| nombre :" + li1.getNombre());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarNombre() {

        String nombre = JOptionPane.showInputDialog("Digite el nombre del departamento");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Departamento.findByNombre");
        query.setParameter("nombre", nombre);

        List<Departamento> li = query.getResultList();
        for (Departamento li1 : li) {
            System.out.println("idDepartamento :" + li1.getIdDepartamento()
                    + "| nombre :" + li1.getNombre());

            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        }
    }
}
