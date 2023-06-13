package fr.diginamic.jdbc.entites;

public class Fournisseur {
    int id;
    String nom ;
    public Fournisseur(int id,String nom){
        this.nom = nom;
        this.id = id;
    }
    public Fournisseur(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Fournisseur " +
                "id=" + id +
                ", nom='" + nom + '\'';
    }
}
