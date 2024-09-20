package org.baticuisine.entities;

import org.baticuisine.enums.TypeComposant;

public class Materiel extends Composants {
    private double coutUnitaire;
    private double quantite;
    private  double coutTransport;
    private  double coefficientQualite;

    public Materiel(int id, String nom, TypeComposant typeComposant, double tauxTVA, double coutUnitaire, double quantite, double coutTransport, double coefficientQualite) {
        super(id, nom, typeComposant, tauxTVA);
        this.coutUnitaire = coutUnitaire;
        this.quantite = quantite;
        this.coutTransport = coutTransport;
        this.coefficientQualite = coefficientQualite;
    }

    public double getCoutUnitaire() {
        return coutUnitaire;
    }

    public void setCoutUnitaire(double coutUnitaire) {
        this.coutUnitaire = coutUnitaire;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getCoutTransport() {
        return coutTransport;
    }

    public void setCoutTransport(double coutTransport) {
        this.coutTransport = coutTransport;
    }

    public double getCoefficientQualite() {
        return coefficientQualite;
    }

    public void setCoefficientQualite(double coefficientQualite) {
        this.coefficientQualite = coefficientQualite;
    }
}