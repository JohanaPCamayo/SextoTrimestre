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
public class DomicilioCuentaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Cuenta_tipoDocumento")
    private String cuentatipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Cuenta_numeroDocumento")
    private String cuentanumeroDocumento;

    public DomicilioCuentaPK() {
    }

    public DomicilioCuentaPK(String cuentatipoDocumento, String cuentanumeroDocumento) {
        this.cuentatipoDocumento = cuentatipoDocumento;
        this.cuentanumeroDocumento = cuentanumeroDocumento;
    }

    public String getCuentatipoDocumento() {
        return cuentatipoDocumento;
    }

    public void setCuentatipoDocumento(String cuentatipoDocumento) {
        this.cuentatipoDocumento = cuentatipoDocumento;
    }

    public String getCuentanumeroDocumento() {
        return cuentanumeroDocumento;
    }

    public void setCuentanumeroDocumento(String cuentanumeroDocumento) {
        this.cuentanumeroDocumento = cuentanumeroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentatipoDocumento != null ? cuentatipoDocumento.hashCode() : 0);
        hash += (cuentanumeroDocumento != null ? cuentanumeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioCuentaPK)) {
            return false;
        }
        DomicilioCuentaPK other = (DomicilioCuentaPK) object;
        if ((this.cuentatipoDocumento == null && other.cuentatipoDocumento != null) || (this.cuentatipoDocumento != null && !this.cuentatipoDocumento.equals(other.cuentatipoDocumento))) {
            return false;
        }
        if ((this.cuentanumeroDocumento == null && other.cuentanumeroDocumento != null) || (this.cuentanumeroDocumento != null && !this.cuentanumeroDocumento.equals(other.cuentanumeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.DomicilioCuentaPK[ cuentatipoDocumento=" + cuentatipoDocumento + ", cuentanumeroDocumento=" + cuentanumeroDocumento + " ]";
    }
    
}
