/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusiccrood.Usuario;
import java.util.List;

/**
 *
 * @author admin
 */
public interface UsuarioDAO {
    
     public void insert(Usuario entity);

    public void update(Usuario entity);

    public void delete(Usuario entity);

    public Usuario findByIdUsuario();

    public List<Usuario> findByAll();
    public List<Usuario> findByContrasena(Object contrasena);
    public List<Usuario> findByRol(Object rol);
    public List<Usuario> findByEstado(Object estado);
    public List<Usuario> findByEmail(Object email);
}
