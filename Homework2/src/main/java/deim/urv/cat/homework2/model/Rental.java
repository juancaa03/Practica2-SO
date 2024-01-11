/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.model;

import java.sql.Date;


public class Rental {
    private Long id;
    
    private Date dataInici;
    private Date dataFi;
    private Game videojoc;
    private User usuari;

    public Rental() {
    }

    public Rental(Date dataInici, Date dataFi, Game videojoc, User usuari) {
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.videojoc = videojoc;
        this.usuari = usuari;
    }

    public Rental(Date dataInici, Date dataFi) {
        this.dataInici = dataInici;
        this.dataFi = dataFi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public Game getVideojoc() {
        return videojoc;
    }

    public void setVideojoc(Game videojoc) {
        this.videojoc = videojoc;
    }

    public User getUsuari() {
        return usuari;
    }

    public void setUsuari(User usuari) {
        this.usuari = usuari;
    }
    
    
}
