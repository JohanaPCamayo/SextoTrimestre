/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusiccrood.Departamento;
import java.util.List;

/**
 *
 * @author admin
 */
public interface DepartamentoDAO {
    
     public void insert(Departamento entity);

    public void update(Departamento entity);

    public void delete(Departamento entity);

    public Departamento findByIdDepartamento();

    public List<Departamento> findByAll();
    public List<Departamento> findByNombre(Object nombre);
}
