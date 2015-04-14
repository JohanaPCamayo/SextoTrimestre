/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejercici1.unoamuchos;

import edu.co.sena.ejemplo1.relaciones.unoauno.*;
import edu.co.sena.ejercicio1.anotaciones.*;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "Estudiante3")


public class Estudiante3 implements Serializable{
    
    @Id
    @Column(name = "IDESTUDIANTE", length = 50, nullable = false)
    private String idEstudiante;
    
    @Column(name = "NOMBREESTUDIANTE",length = 25, nullable = false)
    private String nombre;
    
    @Column(name = "TIPODOCUMENTO",length = 25, nullable = false)
    private String tipoDocumento;
    
    @Column(name = "NUMERODOCUMENTO",length = 25, nullable = false)
    private String numeroDocumento;
    
    @Column(name = "CORREOELECTRONICO", length = 50, nullable = false)
    private String correoElectronico;
    
    @Column(name = "TELEFONO",length = 50, nullable = false)
    private String telefono;
    
    @Column(name = "DIRECCION", length = 100, nullable = false)
    private String direccion;
    
    @JoinColumn(name = "MATERIA", referencedColumnName = "IDMATERIA" )
    @ManyToOne
    private Materia3 materia;
   
    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }       

    @Override
    public String toString() {
        return "Estudiante1{" + "idEstudiante=" + idEstudiante + ", nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + ", direccion=" + direccion + ", materiaid=" + materia.getIdMateria() + '}';
    }

    public Materia3 getMateria() {
        return materia;
    }

    public void setMateria(Materia3 materia) {
        this.materia = materia;
    }
}
