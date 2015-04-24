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
@Table(name = "domicilio_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DomicilioCuenta.findAll", query = "SELECT d FROM DomicilioCuenta d"),
    @NamedQuery(name = "DomicilioCuenta.findByCuentatipoDocumento", query = "SELECT d FROM DomicilioCuenta d WHERE d.domicilioCuentaPK.cuentatipoDocumento = :cuentatipoDocumento"),
    @NamedQuery(name = "DomicilioCuenta.findByCuentanumeroDocumento", query = "SELECT d FROM DomicilioCuenta d WHERE d.domicilioCuentaPK.cuentanumeroDocumento = :cuentanumeroDocumento"),
    @NamedQuery(name = "DomicilioCuenta.findByTelefono", query = "SELECT d FROM DomicilioCuenta d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "DomicilioCuenta.findByDireccion", query = "SELECT d FROM DomicilioCuenta d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DomicilioCuenta.findByBarrio", query = "SELECT d FROM DomicilioCuenta d WHERE d.barrio = :barrio"),
    @NamedQuery(name = "DomicilioCuenta.findByLocalidad", query = "SELECT d FROM DomicilioCuenta d WHERE d.localidad = :localidad")})
public class DomicilioCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DomicilioCuentaPK domicilioCuentaPK;
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
    @JoinColumn(name = "Municipio_idMunicipio", referencedColumnName = "idMunicipio")
    @ManyToOne(optional = false)
    private Municipio municipioidMunicipio;
    @JoinColumns({
        @JoinColumn(name = "Cuenta_tipoDocumento", referencedColumnName = "tipoDocumento", insertable = false, updatable = false),
        @JoinColumn(name = "Cuenta_numeroDocumento", referencedColumnName = "numeroDocumento", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Cuenta cuenta;

    public DomicilioCuenta() {
    }

    public DomicilioCuenta(DomicilioCuentaPK domicilioCuentaPK) {
        this.domicilioCuentaPK = domicilioCuentaPK;
    }

    public DomicilioCuenta(DomicilioCuentaPK domicilioCuentaPK, String telefono, String direccion, String barrio) {
        this.domicilioCuentaPK = domicilioCuentaPK;
        this.telefono = telefono;
        this.direccion = direccion;
        this.barrio = barrio;
    }

    public DomicilioCuenta(String cuentatipoDocumento, String cuentanumeroDocumento) {
        this.domicilioCuentaPK = new DomicilioCuentaPK(cuentatipoDocumento, cuentanumeroDocumento);
    }

    public DomicilioCuentaPK getDomicilioCuentaPK() {
        return domicilioCuentaPK;
    }

    public void setDomicilioCuentaPK(DomicilioCuentaPK domicilioCuentaPK) {
        this.domicilioCuentaPK = domicilioCuentaPK;
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

    public Municipio getMunicipioidMunicipio() {
        return municipioidMunicipio;
    }

    public void setMunicipioidMunicipio(Municipio municipioidMunicipio) {
        this.municipioidMunicipio = municipioidMunicipio;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domicilioCuentaPK != null ? domicilioCuentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioCuenta)) {
            return false;
        }
        DomicilioCuenta other = (DomicilioCuenta) object;
        if ((this.domicilioCuentaPK == null && other.domicilioCuentaPK != null) || (this.domicilioCuentaPK != null && !this.domicilioCuentaPK.equals(other.domicilioCuentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.DomicilioCuenta[ domicilioCuentaPK=" + domicilioCuentaPK + " ]";
    }
    
}
