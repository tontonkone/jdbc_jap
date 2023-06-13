package fr.diginamic;

import fr.diginamic.bdd.DeleteFour;
import fr.diginamic.bdd.ListeFour;
import fr.diginamic.bdd.ModifierFour;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.ArrayList;
import java.util.List;

public class testGlobal {
    public static void main(String[] args) {

        FournisseurDaoJdbc fourntab = new FournisseurDaoJdbc();

        ArrayList<Fournisseur> arrayNew = (ArrayList<Fournisseur>) fourntab.extraire();
        System.out.println(arrayNew);


        fourntab.insert(" L’Espace Création");

    }
}
