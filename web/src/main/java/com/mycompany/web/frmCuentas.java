/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.web;

import com.mycompany.beans.CuentasFacadeLocal;
import com.mycompany.libreria.Cuentas;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Noé
 */
@Named(value = "frmCuentas")
@ViewScoped
public class frmCuentas implements Serializable {

    @Inject
    private CuentasFacadeLocal facade;
    
    public frmCuentas() {
    }
    
    public List<Cuentas> todo(){
        return facade.findAll();
    }
    
}
