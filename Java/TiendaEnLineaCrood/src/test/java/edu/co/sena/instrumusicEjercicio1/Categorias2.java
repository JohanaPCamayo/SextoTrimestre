/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusicEjercicio1;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import edu.co.sena.instrumusiccrood.Categoria;
import edu.co.sena.instrumusiccrood.Departamento;
import edu.co.sena.instrumusiccrood.Municipio;
import edu.co.sena.instrumusiccrood.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ColsutecR
 */
public class Categorias2 {


    Categoria categ;
    Categoria categ2;
    List<Producto> p11;
    Producto p1;
    Producto p2;
    Producto p3;
    Producto p4;
    EntityManager em;

    public Categorias2() {
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
        categ.setIdCategoria(2);
        categ.setNombreCategoria("guitarra ");
        categ.setActiva(true);
        categ.setPariente(1);
        
        categ2 = new Categoria();
        categ2.setIdCategoria(3);
        categ2.setNombreCategoria("Guitarra extremas");
        categ2.setActiva(true);
        categ2.setPariente(1);

        p11 = new ArrayList<>();

        p1 = new Producto();

        p1 = new Producto();
        p1.setIdProducto("2");
        p1.setNombre("Guitarra MJ");
        p1.setMarca("yahama");
        p1.setReferencia("GFT405");
        p1.setDescripcion("guitarra liviana");
        p1.setMaterial("madera");
        p1.setColor("morado");
        p1.setCantidad(10);
        p1.setActivo(true);
        p1.setPrecioUnitario(650000);
        p1.setDescuento(0);
        p1.setCategoriaidCategoria(new Categoria(2));

        p2 = new Producto();

        p2 = new Producto();
        p2.setIdProducto("3");
        p2.setNombre("Guitarra MJ");
        p2.setMarca("yahama");
        p2.setReferencia("GFT405");
        p2.setDescripcion("guitarra liviana");
        p2.setMaterial("madera");
        p2.setColor("morado");
        p2.setCantidad(10);
        p2.setActivo(true);
        p2.setPrecioUnitario(650000);
        p2.setDescuento(0);
        p2.setCategoriaidCategoria(new Categoria(2));

        p3 = new Producto();

        p3 = new Producto();
        p3.setIdProducto("4");
        p3.setNombre("Guitarra MJ");
        p3.setMarca("yahama");
        p3.setReferencia("GFT405");
        p3.setDescripcion("guitarra liviana");
        p3.setMaterial("madera");
        p3.setColor("morado");
        p3.setCantidad(10);
        p3.setActivo(true);
        p3.setPrecioUnitario(650000);
        p3.setDescuento(0);
        p3.setCategoriaidCategoria(new Categoria(2));

        
        p4 = new Producto();

        p4 = new Producto();
        p4.setIdProducto("5");
        p4.setNombre("piano");
        p4.setMarca("yahama");
        p4.setReferencia("GFT405");
        p4.setDescripcion("guitarra liviana");
        p4.setMaterial("madera");
        p4.setColor("morado");
        p4.setCantidad(10);
        p4.setActivo(true);
        p4.setPrecioUnitario(650000);
        p4.setDescuento(0);
        p4.setCategoriaidCategoria(new Categoria(3));
        
        p11.add(p1);
        p11.add(p2);
        p11.add(p3);
    }
    
    @Test
    public void Ejercicio1() {

        categ.setProductoCollection(p11);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(categ);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
    @Test
    public void Ejercicio2() {

        p4.setCategoriaidCategoria(categ2);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(p4);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void Ejercicio3() {

        String munId = JOptionPane.showInputDialog("Digite el municipio");
        
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Departamento d1=em.find(Departamento.class, munId);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        
        List<Municipio> m1= (List<Municipio>) d1.getMunicipioCollection();
        for (Municipio m11 : m1) {
            System.out.println(m11.toString());
        }
     
    }
}
