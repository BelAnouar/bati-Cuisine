package org.baticuisine.entities;

import org.baticuisine.enums.TypeComposant;

public class MainOeuvre extends  Composants{
    private double tauxHoraire;
    private double heuresTravail;
    private double productiviteOuvrier;


    public MainOeuvre(){
        super();
    }



    public MainOeuvre(int id, String nom, TypeComposant typeComposant, double tauxTVA, double tauxHoraire, double heuresTravail, double productiviteOuvrier) {
        super(id, nom, typeComposant, tauxTVA);
        this.tauxHoraire = tauxHoraire;
        this.heuresTravail = heuresTravail;
        this.productiviteOuvrier = productiviteOuvrier;
    }
    public MainOeuvre( String nom, TypeComposant typeComposant, double tauxTVA, double tauxHoraire, double heuresTravail, double productiviteOuvrier,Projet projet) {
        super( nom, typeComposant, tauxTVA,projet);
        this.tauxHoraire = tauxHoraire;
        this.heuresTravail = heuresTravail;
        this.productiviteOuvrier = productiviteOuvrier;

    }


    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public double getHeuresTravail() {
        return heuresTravail;
    }

    public void setHeuresTravail(double heuresTravail) {
        this.heuresTravail = heuresTravail;
    }

    public double getProductiviteOuvrier() {
        return productiviteOuvrier;
    }

    public void setProductiviteOuvrier(double productiviteOuvrier) {
        this.productiviteOuvrier = productiviteOuvrier;
    }
    @Override
    public double calculateTotalCost() {
        return (tauxHoraire * heuresTravail) * productiviteOuvrier *(tauxTVA +1);
    }

    @Override
    public String toString() {
        return "MainOeuvre{" +
                "tauxHoraire=" + tauxHoraire +
                ", heuresTravail=" + heuresTravail +
                ", productiviteOuvrier=" + productiviteOuvrier +
                ", nom='" + nom + '\'' +
                ", typeComposant=" + typeComposant +
                ", tauxTVA=" + tauxTVA +
                "projet="+ getProjet() +
                '}';
    }
}