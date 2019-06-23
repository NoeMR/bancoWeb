/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreria;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Noé
 */
@Entity
@Table(name = "cuentas", catalog = "banco", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentas.findAll", query = "SELECT c FROM Cuentas c")
    , @NamedQuery(name = "Cuentas.findByIdCuenta", query = "SELECT c FROM Cuentas c WHERE c.idCuenta = :idCuenta")
    , @NamedQuery(name = "Cuentas.findBySaldo", query = "SELECT c FROM Cuentas c WHERE c.saldo = :saldo")})
public class Cuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta", nullable = false)
    private Integer idCuenta;
    @Basic(optional = false)
    @Column(name = "saldo", nullable = false)
    private double saldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaBancaria", fetch = FetchType.LAZY)
    private List<Transacciones> transaccionesList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;

    public Cuentas() {
    }

    public Cuentas(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cuentas(Integer idCuenta, double saldo) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public List<Transacciones> getTransaccionesList() {
        return transaccionesList;
    }

    public void setTransaccionesList(List<Transacciones> transaccionesList) {
        this.transaccionesList = transaccionesList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentas)) {
            return false;
        }
        Cuentas other = (Cuentas) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.libreria.Cuentas[ idCuenta=" + idCuenta + " ]";
    }
    
}
