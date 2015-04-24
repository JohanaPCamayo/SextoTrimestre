/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusiccrood.Cuenta;
import java.util.List;

/**
 *
 * @author admin
 */
public interface CuentaDAO {
    
    public void insert(Cuenta entity);

    public void update(Cuenta entity);

    public void delete(Cuenta entity);
    
    public List<Cuenta> findByAll();
    public List<Cuenta> findByPrimerNombre(Object primerNombre);
    public List<Cuenta> findBySegundoNombre(Object segundoNombre);
    public List<Cuenta> findByPrimerApellido(Object primerApellido);
    public List<Cuenta> findBySegundoApellido(Object segundoApellido);;
}
