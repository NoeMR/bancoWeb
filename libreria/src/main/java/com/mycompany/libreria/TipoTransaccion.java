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
@Table(name = "tipo_transaccion", catalog = "banco", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransaccion.findAll", query = "SELECT t FROM TipoTransaccion t")
    , @NamedQuery(name = "TipoTransaccion.findById", query = "SELECT t FROM TipoTransaccion t WHERE t.id = :id")
    , @NamedQuery(name = "TipoTransaccion.findByDescripcion", query = "SELECT t FROM TipoTransaccion t WHERE t.descripcion = :descripcion")})
public class TipoTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTransaccion", fetch = FetchType.LAZY)
    private List<Transacciones> transaccionesList;

    public TipoTransaccion() {
    }

    public TipoTransaccion(Integer id) {
        this.id = id;
    }

    public TipoTransaccion(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Transacciones> getTransaccionesList() {
        return transaccionesList;
    }

    public void setTransaccionesList(List<Transacciones> transaccionesList) {
        this.transaccionesList = transaccionesList;
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
        if (!(object instanceof TipoTransaccion)) {
            return false;
        }
        TipoTransaccion other = (TipoTransaccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.libreria.TipoTransaccion[ id=" + id + " ]";
    }
    
}
