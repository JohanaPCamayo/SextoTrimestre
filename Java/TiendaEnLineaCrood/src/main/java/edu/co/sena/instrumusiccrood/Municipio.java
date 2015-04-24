/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdMunicipio", query = "SELECT m FROM Municipio m WHERE m.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "Municipio.findByNombre", query = "SELECT m FROM Municipio m WHERE m.nombre = :nombre")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "idMunicipio")
    private String idMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioidMunicipio")
    private Collection<DomicilioCuenta> domicilioCuentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioidMunicipio")
    private Collection<DomicilioProveedor> domicilioProveedorCollection;
    @JoinColumn(name = "Departamento_idDepartamento", referencedColumnName = "idDepartamento")
    @ManyToOne(optional = false)
    private Departamento departamentoidDepartamento;

    public Municipio() {
    }

    public Municipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Municipio(String idMunicipio, String nombre) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<DomicilioCuenta> getDomicilioCuentaCollection() {
        return domicilioCuentaCollection;
    }

    public void setDomicilioCuentaCollection(Collection<DomicilioCuenta> domicilioCuentaCollection) {
        this.domicilioCuentaCollection = domicilioCuentaCollection;
    }

    @XmlTransient
    public Collection<DomicilioProveedor> getDomicilioProveedorCollection() {
        return domicilioProveedorCollection;
    }

    public void setDomicilioProveedorCollection(Collection<DomicilioProveedor> domicilioProveedorCollection) {
        this.domicilioProveedorCollection = domicilioProveedorCollection;
    }

    public Departamento getDepartamentoidDepartamento() {
        return departamentoidDepartamento;
    }

    public void setDepartamentoidDepartamento(Departamento departamentoidDepartamento) {
        this.departamentoidDepartamento = departamentoidDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.Municipio[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
