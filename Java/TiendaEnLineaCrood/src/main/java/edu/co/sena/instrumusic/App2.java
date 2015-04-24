/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic;


import edu.co.sena.instrumusiccrood.Categoria;
import edu.co.sena.instrumusiccrood.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ColsutecR
 */
public class App2 {

    public static void main(String[] args) {

        Categoria c1 = new Categoria();
        c1.setIdCategoria(1);
        c1.setNombreCategoria("guitarras acusticas");
        c1.setActiva(true);
        c1.setPariente(1);
          

        Producto p = new Producto();
        p.setIdProducto("1");
        p.setActivo(true);
        p.setCantidad(10);
        p.setColor("morado");
        p.setDescripcion("Guitarras ");
        p.setDescuento(0);
        p.setMarca("yamaha");
        p.setMaterial("pino");
        p.setPrecioUnitario(560000);
        p.setReferencia("FRT421");
       p.setCategoriaidCategoria(c1);

         Producto p1 = new Producto();
        p1.setIdProducto("2");
        p1.setActivo(true);
        p1.setCantidad(15);
        p1.setColor("fuscia");
        p1.setDescripcion("Guitarras ");
        p1.setDescuento(0);
        p1.setMarca("yamaha");
        p1.setMaterial("pino");
        p1.setPrecioUnitario(560000);
        p1.setReferencia("FJH001");
       p1.setCategoriaidCategoria(c1);

        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("edu.co.sena_TiendaEnLineaCrood_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();

        em1.merge(p);
        em1.merge(p1);

        em1.getTransaction().commit();

        em1.close();
        emf1.close();
    }
}
