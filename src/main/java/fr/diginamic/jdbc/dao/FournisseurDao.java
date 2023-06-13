package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.List;

public interface FournisseurDao {
    List<Fournisseur> extraire();
    void insert(String fournisseur);
    int update(String ancienNom, String nouveauNom);
    void delete(String nom);

}
