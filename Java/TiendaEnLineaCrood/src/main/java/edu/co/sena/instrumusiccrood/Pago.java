/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByFacturaidFactura", query = "SELECT p FROM Pago p WHERE p.facturaidFactura = :facturaidFactura"),
    @NamedQuery(name = "Pago.findByNumTarCredito", query = "SELECT p FROM Pago p WHERE p.numTarCredito = :numTarCredito"),
    @NamedQuery(name = "Pago.findByBanco", query = "SELECT p FROM Pago p WHERE p.banco = :banco"),
    @NamedQuery(name = "Pago.findByTipoCuentaTar", query = "SELECT p FROM Pago p WHERE p.tipoCuentaTar = :tipoCuentaTar"),
    @NamedQuery(name = "Pago.findByTipoTransaccion", query = "SELECT p FROM Pago p WHERE p.tipoTransaccion = :tipoTransaccion")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Factura_idFactura")
    private Integer facturaidFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numTarCredito")
    private String numTarCredito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "banco")
    private String banco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoCuentaTar")
    private String tipoCuentaTar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipoTransaccion")
    private String tipoTransaccion;
    @JoinColumn(name = "Factura_idFactura", referencedColumnName = "idFactura", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Factura factura;

    public Pago() {
    }

    public Pago(Integer facturaidFactura) {
        this.facturaidFactura = facturaidFactura;
    }

    public Pago(Integer facturaidFactura, String numTarCredito, String banco, String tipoCuentaTar, String tipoTransaccion) {
        this.facturaidFactura = facturaidFactura;
        this.numTarCredito = numTarCredito;
        this.banco = banco;
        this.tipoCuentaTar = tipoCuentaTar;
        this.tipoTransaccion = tipoTransaccion;
    }

    public Integer getFacturaidFactura() {
        return facturaidFactura;
    }

    public void setFacturaidFactura(Integer facturaidFactura) {
        this.facturaidFactura = facturaidFactura;
    }

    public String getNumTarCredito() {
        return numTarCredito;
    }

    public void setNumTarCredito(String numTarCredito) {
        this.numTarCredito = numTarCredito;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipoCuentaTar() {
        return tipoCuentaTar;
    }

    public void setTipoCuentaTar(String tipoCuentaTar) {
        this.tipoCuentaTar = tipoCuentaTar;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaidFactura != null ? facturaidFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.facturaidFactura == null && other.facturaidFactura != null) || (this.facturaidFactura != null && !this.facturaidFactura.equals(other.facturaidFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.Pago[ facturaidFactura=" + facturaidFactura + " ]";
    }
    
}
