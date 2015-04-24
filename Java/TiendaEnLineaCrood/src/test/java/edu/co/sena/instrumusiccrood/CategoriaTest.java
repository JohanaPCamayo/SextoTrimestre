/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import java.util.List;
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
public class CategoriaTest {
    
    public CategoriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdCategoria method, of class Categoria.
     */
    @Test
    public void testGetIdCategoria() {
        System.out.println("getIdCategoria");
        Categoria instance = new Categoria();
        Integer expResult = null;
        Integer result = instance.getIdCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCategoria method, of class Categoria.
     */
    @Test
    public void testSetIdCategoria() {
        System.out.println("setIdCategoria");
        Integer idCategoria = null;
        Categoria instance = new Categoria();
        instance.setIdCategoria(idCategoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreCategoria method, of class Categoria.
     */
    @Test
    public void testGetNombreCategoria() {
        System.out.println("getNombreCategoria");
        Categoria instance = new Categoria();
        String expResult = "";
        String result = instance.getNombreCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreCategoria method, of class Categoria.
     */
    @Test
    public void testSetNombreCategoria() {
        System.out.println("setNombreCategoria");
        String nombreCategoria = "";
        Categoria instance = new Categoria();
        instance.setNombreCategoria(nombreCategoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActiva method, of class Categoria.
     */
    @Test
    public void testGetActiva() {
        System.out.println("getActiva");
        Categoria instance = new Categoria();
        boolean expResult = false;
        boolean result = instance.getActiva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActiva method, of class Categoria.
     */
    @Test
    public void testSetActiva() {
        System.out.println("setActiva");
        boolean activa = false;
        Categoria instance = new Categoria();
        instance.setActiva(activa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPariente method, of class Categoria.
     */
    @Test
    public void testGetPariente() {
        System.out.println("getPariente");
        Categoria instance = new Categoria();
        int expResult = 0;
        int result = instance.getPariente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPariente method, of class Categoria.
     */
    @Test
    public void testSetPariente() {
        System.out.println("setPariente");
        int pariente = 0;
        Categoria instance = new Categoria();
        instance.setPariente(pariente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductoList method, of class Categoria.
     */
    @Test
    public void testGetProductoList() {
        System.out.println("getProductoList");
        Categoria instance = new Categoria();
        List<Producto> expResult = null;
        List<Producto> result = (List<Producto>) instance.getProductoCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductoList method, of class Categoria.
     */
    @Test
    public void testSetProductoList() {
        System.out.println("setProductoList");
        List<Producto> productoList = null;
        Categoria instance = new Categoria();
        instance.setProductoCollection(productoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Categoria.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Categoria instance = new Categoria();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Categoria.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Categoria instance = new Categoria();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Categoria.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Categoria instance = new Categoria();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
