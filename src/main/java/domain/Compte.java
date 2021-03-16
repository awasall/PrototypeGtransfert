package domain;

public class Compte {
    private int idC;
    private String numerCompte;
    private int solde;
    private Partenaire partenaire = new Partenaire();

    public Compte() {
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNumerCompte() {
        return numerCompte;
    }

    public void setNumerCompte(String numerCompte) {
        this.numerCompte = numerCompte;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }
}
