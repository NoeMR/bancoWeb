/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Noé
 */
@Entity
@Table(name = "transacciones", catalog = "banco", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t")
    , @NamedQuery(name = "Transacciones.findById", query = "SELECT t FROM Transacciones t WHERE t.id = :id")
    , @NamedQuery(name = "Transacciones.findByMonto", query = "SELECT t FROM Transacciones t WHERE t.monto = :monto")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "monto", nullable = false)
    private double monto;
    @JoinColumn(name = "cuenta_bancaria", referencedColumnName = "id_cuenta", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cuentas cuentaBancaria;
    @JoinColumn(name = "tipo_transaccion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoTransaccion tipoTransaccion;

    public Transacciones() {
    }

    public Transacciones(Integer id) {
        this.id = id;
    }

    public Transacciones(Integer id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Cuentas getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(Cuentas cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.libreria.Transacciones[ id=" + id + " ]";
    }
    
}
