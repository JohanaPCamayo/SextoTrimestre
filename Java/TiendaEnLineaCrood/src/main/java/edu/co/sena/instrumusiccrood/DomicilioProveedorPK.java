/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ColsutecR
 */
@Embeddable
public class DomicilioProveedorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Proveedor_idProveedor")
    private String proveedoridProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Proveedor_tipoDeIdentificacion")
    private String proveedortipoDeIdentificacion;

    public DomicilioProveedorPK() {
    }

    public DomicilioProveedorPK(String proveedoridProveedor, String proveedortipoDeIdentificacion) {
        this.proveedoridProveedor = proveedoridProveedor;
        this.proveedortipoDeIdentificacion = proveedortipoDeIdentificacion;
    }

    public String getProveedoridProveedor() {
        return proveedoridProveedor;
    }

    public void setProveedoridProveedor(String proveedoridProveedor) {
        this.proveedoridProveedor = proveedoridProveedor;
    }

    public String getProveedortipoDeIdentificacion() {
        return proveedortipoDeIdentificacion;
    }

    public void setProveedortipoDeIdentificacion(String proveedortipoDeIdentificacion) {
        this.proveedortipoDeIdentificacion = proveedortipoDeIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedoridProveedor != null ? proveedoridProveedor.hashCode() : 0);
        hash += (proveedortipoDeIdentificacion != null ? proveedortipoDeIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioProveedorPK)) {
            return false;
        }
        DomicilioProveedorPK other = (DomicilioProveedorPK) object;
        if ((this.proveedoridProveedor == null && other.proveedoridProveedor != null) || (this.proveedoridProveedor != null && !this.proveedoridProveedor.equals(other.proveedoridProveedor))) {
            return false;
        }
        if ((this.proveedortipoDeIdentificacion == null && other.proveedortipoDeIdentificacion != null) || (this.proveedortipoDeIdentificacion != null && !this.proveedortipoDeIdentificacion.equals(other.proveedortipoDeIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.DomicilioProveedorPK[ proveedoridProveedor=" + proveedoridProveedor + ", proveedortipoDeIdentificacion=" + proveedortipoDeIdentificacion + " ]";
    }
    
}
