package deim.urv.cat.homework2.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private Long id;

    private String nomUsuari, correu;
    private String contrasenya;
    private List<Rental> lloguers;

    public User() {
    }

    public User(Long id, String nomUsuari, String correu, String contrasenya) {
        this.id = id;
        this.nomUsuari = nomUsuari;
        this.correu = correu;
        this.contrasenya = contrasenya;
    }

    public User(String nomUsuari, String correu, String contrasenya) {
        this.nomUsuari = nomUsuari;
        this.correu = correu;
        this.contrasenya = contrasenya;
    }
    
    public User(String nomUsuari, String correu, String contrasenya, List<Rental> lloguers) {
        this.nomUsuari = nomUsuari;
        this.correu = correu;
        this.contrasenya = contrasenya;
        this.lloguers = lloguers;
    }

    public User(Long id, String nomUsuari, String correu, String contrasenya, List<Rental> lloguers) {
        this.id = id;
        this.nomUsuari = nomUsuari;
        this.correu = correu;
        this.contrasenya = contrasenya;
        this.lloguers = lloguers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public List<Rental> getLloguers() {
        return lloguers;
    }

    public void setLloguers(List<Rental> lloguers) {
        this.lloguers = lloguers;
    }
    
    
}
