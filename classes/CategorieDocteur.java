package classes;

public class CategorieDocteur{
    int idCategorieDocteur;
    String designation;
    String salaireJournalier;
    
    public CategorieDocteur(int idCategorieDocteur, String designation, String salaireJournalier) {
        this.idCategorieDocteur = idCategorieDocteur;
        this.designation = designation;
        this.salaireJournalier = salaireJournalier;
    }
    public int getIdCategorieDocteur() {
        return idCategorieDocteur;
    }
    public void setIdCategorieDocteur(int idCategorieDocteur) {
        this.idCategorieDocteur = idCategorieDocteur;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getSalaireJournalier() {
        return salaireJournalier;
    }
    public void setSalaireJournalier(String salaireJournalier) {
        this.salaireJournalier = salaireJournalier;
    }
    

    public CategorieDocteur getCategorie( int idCategorieDocteur){
        return null;
    }

}