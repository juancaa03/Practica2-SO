/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.model;

import java.io.Serializable;
import java.sql.Date;


public class RebutLloguer implements Serializable{
    private Long id;
    
    private double preuTotal;
    private Date dataAlquiler;
    private Date dataRetorn;

    public RebutLloguer() {
    }
    
    public RebutLloguer(Long id, Date dataAlquiler, Date dataRetorn, double preuTotal) {
        this.id = id;
        this.dataAlquiler = dataAlquiler;
        this.dataRetorn = dataRetorn;
        this.preuTotal = preuTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(double preuTotal) {
        this.preuTotal = preuTotal;
    }

    public Date getDataAlquiler() {
        return dataAlquiler;
    }

    public void setDataAlquiler(Date dataAlquiler) {
        this.dataAlquiler = dataAlquiler;
    }

    public Date getDataRetorn() {
        return dataRetorn;
    }

    public void setDataRetorn(Date dataRetorn) {
        this.dataRetorn = dataRetorn;
    }
}
