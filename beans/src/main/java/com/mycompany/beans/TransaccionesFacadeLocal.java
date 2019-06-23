/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.libreria.Transacciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Noé
 */
@Local
public interface TransaccionesFacadeLocal {

    void create(Transacciones transacciones);

    void edit(Transacciones transacciones);

    void remove(Transacciones transacciones);

    Transacciones find(Object id);

    List<Transacciones> findAll();

    List<Transacciones> findRange(int[] range);

    int count();
    
}
