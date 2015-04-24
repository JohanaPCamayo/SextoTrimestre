/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
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
public class ProductoTestJPA {

    Producto p;
    EntityManager em;

    public ProductoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        p = new Producto();
        p.setIdProducto("1");
        p.setNombre("Guitarra MJ");
        p.setMarca("yahama");
        p.setReferencia("GFT405");
        p.setDescripcion("guitarra liviana");
        p.setMaterial("madera");
        p.setColor("morado");
        p.setCantidad(10);
        p.setActivo(true);
        p.setPrecioUnitario(650000);
        p.setDescuento(0);
        p.setCategoriaidCategoria(new Categoria(1));
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
    public void insertarProducto() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(p);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarProducto() {

        String pId = JOptionPane.showInputDialog("Digite el id del producto que va actualizar");
        String proCol = JOptionPane.showInputDialog("Digite el color para actualizar");
        String proCant = JOptionPane.showInputDialog("Digite la cantidad para actualizar");

        p.setIdProducto(pId);
        p.setColor(proCol);
        p.setCantidad(Integer.parseInt(proCant));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(p);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarProducto() {

        String pId = JOptionPane.showInputDialog("Digite el id del producto que va a eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Producto.class, pId));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("no se pudo realizar la elimnacion por: " + e.getMessage());
        }
    }

    @Test
    public void actualizarPKProducto() {

        em = EntityManagerHelper.getEntityManager();
        String prViId = JOptionPane.showInputDialog("Digite el Id del producto que va a actualizar");
        String prNId2 = JOptionPane.showInputDialog("Digite el nuevo Id del producto para actualizar");
        EntityManagerHelper.beginTransaction();
        Producto p = em.find(Producto.class, prViId);
        p.setIdProducto(prNId2);
        em.merge(p);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarIdProducto() {

        String idProducto = JOptionPane.showInputDialog("Digite el id del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByIdProducto");
        query.setParameter("idProducto", idProducto);

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarNombre() {

        String nombre = JOptionPane.showInputDialog("Digite el nombre del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByNombre");
        query.setParameter("nombre", nombre);

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarMarca() {

        String marca = JOptionPane.showInputDialog("Digite la marca del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByMarca");
        query.setParameter("marca", marca);

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarReferencia() {

        String referencia = JOptionPane.showInputDialog("Digite la referencia del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByReferencia");
        query.setParameter("referencia", referencia);

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarDescripcion() {

        String descripcion = JOptionPane.showInputDialog("Digite la descripcion del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByDescripcion");
        query.setParameter("descripcion", descripcion);

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarMaterial() {

        String material = JOptionPane.showInputDialog("Digite el material del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByMaterial");
        query.setParameter("material", material);

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarColor() {

        String color = JOptionPane.showInputDialog("Digite el color del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByColor");
        query.setParameter("color", color);

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarCantidad() {

        String cantidad = JOptionPane.showInputDialog("Digite la cantidad del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByCantidad");
        query.setParameter("cantidad", Integer.parseInt(cantidad));

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarActivo() {

        String activo = JOptionPane.showInputDialog("Digite el activo del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByActivo");
        query.setParameter("activo", Boolean.parseBoolean(activo));

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarPrecioUnitario() {

        String precioUnitario = JOptionPane.showInputDialog("Digite la precio unitario del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByPrecioUnitario");
        query.setParameter("precioUnitario", Float.parseFloat(precioUnitario));
        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void BuscarDescuento() {

        String descuento = JOptionPane.showInputDialog("Digite el descuento del producto");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Producto.findByDescuento");
        query.setParameter("descuento", Float.parseFloat(descuento));

        List<Producto> li = query.getResultList();
        for (Producto li1 : li) {
            System.out.println("idProducto :" + li1.getIdProducto()
                    + "| nombre :" + li1.getNombre()
                    + "| marca :" + li1.getMarca()
                    + "| referencia :" + li1.getReferencia()
                    + "| descripcion :" + li1.getDescripcion()
                    + "| material :" + li1.getMaterial()
                    + "| color :" + li1.getColor()
                    + "| cantidad :" + li1.getCantidad()
                    + "| activo :" + li1.getActivo()
                    + "| precioUnitario :" + li1.getPrecioUnitario()
                    + "| descuento :" + li1.getDescuento()
                    + "| categoriaidCategoria :" + li1.getCategoriaidCategoria());
        }
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
