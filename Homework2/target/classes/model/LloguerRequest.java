/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.model;

import java.io.Serializable;


public class LloguerRequest implements Serializable{
    private Game videojoc;
    private User usuari;

    public LloguerRequest() {
    }

    
    public LloguerRequest(Game videojoc, User usuari) {
        this.videojoc = videojoc;
        this.usuari = usuari;
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
