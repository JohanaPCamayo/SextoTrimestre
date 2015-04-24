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
public class MunicipioTestJPA {

    Municipio mun;
    EntityManager em;

    public MunicipioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        mun = new Municipio();
        mun.setIdMunicipio("1");
        mun.setNombre("Sabaneta");
        mun.setDepartamentoidDepartamento(new Departamento("1"));
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
    public void insertarMunicipio() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(mun);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarMunicipio() {

        String munId = JOptionPane.showInputDialog("Digite el municipio que va actualizar");
        String munNom = JOptionPane.showInputDialog("Digite el nombre");

        mun.setIdMunicipio(munId);
        mun.setNombre(munNom);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(mun);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void eliminarMunicipio() {
        String munId = JOptionPane.showInputDialog("Digite el Id municipio que va a eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Municipio.class, munId));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }

    @Test
    public void BuscarIdMunicipio() {
        String idMunicipio = JOptionPane.showInputDialog("Digite el Id del municipio");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Municipio.findByIdMunicipio");
        query.setParameter("idMunicipio", idMunicipio);

        List<Municipio> li = query.getResultList();
        for (Municipio li1 : li) {
            System.out.println("idMunicipio" + li1.getIdMunicipio()
                    + "| nombre :" + li1.getNombre()
                    + "| departamentoidDepartamento : " + li1.getDepartamentoidDepartamento());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    
    @Test
    public void BuscarNombreMunicipio() {
        
        String nombreMunicipio = JOptionPane.showInputDialog("Digite el nombre del municipio");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Municipio.findByNombre");
        query.setParameter("nombreMunicipio", nombreMunicipio);

        List<Municipio> li = query.getResultList();
        for (Municipio li1 : li) {
            System.out.println("idMunicipio" + li1.getIdMunicipio()
                    + "| nombre :" + li1.getNombre()
                    + "| departamentoidDepartamento : " + li1.getDepartamentoidDepartamento());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
