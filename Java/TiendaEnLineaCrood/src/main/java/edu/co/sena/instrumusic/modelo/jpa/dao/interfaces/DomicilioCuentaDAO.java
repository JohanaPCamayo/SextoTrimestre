/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;


import edu.co.sena.instrumusiccrood.DomicilioCuenta;
import java.util.List;

/**
 *
 * @author admin
 */
public interface DomicilioCuentaDAO {
 
     public void insert(DomicilioCuentaDAO entity);

    public void update(DomicilioCuentaDAO entity);

    public void delete(DomicilioCuentaDAO entity);    

    public List<DomicilioCuenta> findByAll();
    public List<DomicilioCuenta> findByTelefono(Object telefono);
    public List<DomicilioCuenta> findByDireccion(Object direccion);
    public List<DomicilioCuenta> findByBario(Object barrio);
    public List<DomicilioCuenta> findByLocalidad(Object localidad);

}
