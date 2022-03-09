package classes;


import java.sql.*;
import java.util.ArrayList;

public class Facture{
    int idFacture;
    Patient idpatient; 
    int montant;
    String dateFacture;
	public int getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}
	public Patient getIdpatient() {
		return idpatient;
	}
	public void setIdpatient(Patient idpatient) {
		this.idpatient = idpatient;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public String getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(String dateFacture) {
		this.dateFacture = dateFacture;
	}
	public Facture(int idFacture, Patient idpatient, int montant, String dateFacture) {
		super();
		this.idFacture = idFacture;
		this.idpatient = idpatient;
		this.montant = montant;
		this.dateFacture = dateFacture;
	}
    
    public Facture() {
    	
    }
}