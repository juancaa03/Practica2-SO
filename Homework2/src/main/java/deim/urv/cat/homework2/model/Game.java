/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.model;

import java.util.List;


public class Game {
    private Long id;

    private String nom;
    private String videoconsola;
    private boolean disponibilitat;
    private double preuLloguer;
    private String descripcio;
    private String tipus;
    private String adrecaBotigues;
    private List<Rental> lloguers;

    public Game() {
    }

    public Game(String nom, String videoconsola, boolean disponibilitat, double preuLloguer, String descripcio, String tipus, String adrecaBotigues, List<Lloguer> lloguers) {
        this.nom = nom;
        this.videoconsola = videoconsola;
        this.disponibilitat = disponibilitat;
        this.preuLloguer = preuLloguer;
        this.descripcio = descripcio;
        this.tipus = tipus;
        this.adrecaBotigues = adrecaBotigues;
        this.lloguers = lloguers;
    }

    public Game(String nom, String videoconsola, boolean disponibilitat, double preuLloguer, String descripcio, String tipus, String adrecaBotigues) {
        this.nom = nom;
        this.videoconsola = videoconsola;
        this.disponibilitat = disponibilitat;
        this.preuLloguer = preuLloguer;
        this.descripcio = descripcio;
        this.tipus = tipus;
        this.adrecaBotigues = adrecaBotigues;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVideoconsola() {
        return videoconsola;
    }

    public void setVideoconsola(String videoconsola) {
        this.videoconsola = videoconsola;
    }

    public boolean isDisponibilitat() {
        return disponibilitat;
    }

    public void setDisponibilitat(boolean disponibilitat) {
        this.disponibilitat = disponibilitat;
    }

    public double getPreuLloguer() {
        return preuLloguer;
    }

    public void setPreuLloguer(double preuLloguer) {
        this.preuLloguer = preuLloguer;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getAdrecaBotigues() {
        return adrecaBotigues;
    }

    public void setAdrecaBotigues(String adrecaBotigues) {
        this.adrecaBotigues = adrecaBotigues;
    }

    public List<Lloguer> getLloguers() {
        return lloguers;
    }

    public void setLloguers(List<Lloguer> lloguers) {
        this.lloguers = lloguers;
    }
    
    
}
