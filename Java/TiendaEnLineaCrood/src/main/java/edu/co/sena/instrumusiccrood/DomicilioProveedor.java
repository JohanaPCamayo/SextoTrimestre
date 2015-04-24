/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "domicilio_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DomicilioProveedor.findAll", query = "SELECT d FROM DomicilioProveedor d"),
    @NamedQuery(name = "DomicilioProveedor.findByProveedoridProveedor", query = "SELECT d FROM DomicilioProveedor d WHERE d.domicilioProveedorPK.proveedoridProveedor = :proveedoridProveedor"),
    @NamedQuery(name = "DomicilioProveedor.findByProveedortipoDeIdentificacion", query = "SELECT d FROM DomicilioProveedor d WHERE d.domicilioProveedorPK.proveedortipoDeIdentificacion = :proveedortipoDeIdentificacion"),
    @NamedQuery(name = "DomicilioProveedor.findByTelefono", query = "SELECT d FROM DomicilioProveedor d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "DomicilioProveedor.findByDireccion", query = "SELECT d FROM DomicilioProveedor d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DomicilioProveedor.findByBarrio", query = "SELECT d FROM DomicilioProveedor d WHERE d.barrio = :barrio"),
    @NamedQuery(name = "DomicilioProveedor.findByLocalidad", query = "SELECT d FROM DomicilioProveedor d WHERE d.localidad = :localidad")})
public class DomicilioProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DomicilioProveedorPK domicilioProveedorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 100)
    @Column(name = "localidad")
    private String localidad;
    @JoinColumns({
        @JoinColumn(name = "Proveedor_idProveedor", referencedColumnName = "idProveedor", insertable = false, updatable = false),
        @JoinColumn(name = "Proveedor_tipoDeIdentificacion", referencedColumnName = "tipoDeIdentificacion", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Proveedor proveedor;
    @JoinColumn(name = "Municipio_idMunicipio", referencedColumnName = "idMunicipio")
    @ManyToOne(optional = false)
    private Municipio municipioidMunicipio;

    public DomicilioProveedor() {
    }

    public DomicilioProveedor(DomicilioProveedorPK domicilioProveedorPK) {
        this.domicilioProveedorPK = domicilioProveedorPK;
    }

    public DomicilioProveedor(DomicilioProveedorPK domicilioProveedorPK, String telefono, String direccion, String barrio) {
        this.domicilioProveedorPK = domicilioProveedorPK;
        this.telefono = telefono;
        this.direccion = direccion;
        this.barrio = barrio;
    }

    public DomicilioProveedor(String proveedoridProveedor, String proveedortipoDeIdentificacion) {
        this.domicilioProveedorPK = new DomicilioProveedorPK(proveedoridProveedor, proveedortipoDeIdentificacion);
    }

    public DomicilioProveedorPK getDomicilioProveedorPK() {
        return domicilioProveedorPK;
    }

    public void setDomicilioProveedorPK(DomicilioProveedorPK domicilioProveedorPK) {
        this.domicilioProveedorPK = domicilioProveedorPK;
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

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Municipio getMunicipioidMunicipio() {
        return municipioidMunicipio;
    }

    public void setMunicipioidMunicipio(Municipio municipioidMunicipio) {
        this.municipioidMunicipio = municipioidMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domicilioProveedorPK != null ? domicilioProveedorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioProveedor)) {
            return false;
        }
        DomicilioProveedor other = (DomicilioProveedor) object;
        if ((this.domicilioProveedorPK == null && other.domicilioProveedorPK != null) || (this.domicilioProveedorPK != null && !this.domicilioProveedorPK.equals(other.domicilioProveedorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.DomicilioProveedor[ domicilioProveedorPK=" + domicilioProveedorPK + " ]";
    }
    
}
