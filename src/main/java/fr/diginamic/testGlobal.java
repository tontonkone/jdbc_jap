package fr.diginamic;


import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.ArrayList;
import java.util.List;

public class testGlobal {
    public static void main(String[] args) {

        FournisseurDaoJdbc fourntab = new FournisseurDaoJdbc();

        ArrayList<Fournisseur> arrayNew = (ArrayList<Fournisseur>) fourntab.extraire();

        fourntab.insert(new Fournisseur("fff \'' avieddsssd"));

    }
}
