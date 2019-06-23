/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.libreria.Transacciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Noé
 */
@Stateless
public class TransaccionesFacade extends AbstractFacade<Transacciones> implements TransaccionesFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_beans_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionesFacade() {
        super(Transacciones.class);
    }
    
}
