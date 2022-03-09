package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Chambre {
    int idChambre;
    String designation;
    int nbLits;
    int tarifs;
    
    public Chambre(int idChambre, String designation, int nbLits, int tarifs) {
        this.idChambre = idChambre;
        this.designation = designation;
        this.nbLits = nbLits;
        this.tarifs = tarifs;
    }
    
    public Chambre() {
    	
    }
    
    public int getIdChambre() {
        return idChambre;
    }
    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public int getNbLits() {
        return nbLits;
    }
    public void setNbLits(int nbLits) {
        this.nbLits = nbLits;
    }
    public int getTarifs() {
        return tarifs;
    }
    public void setTarifs(int tarifs) {
        this.tarifs = tarifs;
    }
    
    public ArrayList<Chambre> getChambresDispo(){
    	ArrayList<Chambre> ret = new ArrayList<Chambre>();
    	try {
            try {
            	Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
            	e.printStackTrace();	
            }
        Connection conn = DriverManager.getConnection(
            	"jdbc:postgresql://localhost:5432/payement","postgres","mdpprom13");
		    
        Statement stmt = conn.createStatement();
        //ResultSet res = stmt.executeQuery("select * from \"Appareil\"");
        ResultSet res = stmt.executeQuery("select * from chambre where nbLits>0");
        while(res.next()) {
            int idChambre = res.getInt("idChambre");
            String designation = res.getString("designation");
            int nbLits = res.getInt("nbLits");
            int tarif = res.getInt("tarif");
            Chambre a = new Chambre(idChambre,designation,nbLits,tarif);
            ret.add(a);
        }
			conn.close();
        } catch (SQLException e) {
			e.printStackTrace();
		}
    	return ret;
    }
           
}
