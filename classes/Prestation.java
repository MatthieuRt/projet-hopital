package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Prestation {
    int idPrestation;
    int idPatient;
    int idDocteur; 
    String datePresation;  
    
    
    public Prestation(int idPrestation, int idPatient, int idDocteur, String datePresation) {
		super();
		this.idPrestation = idPrestation;
		this.idPatient = idPatient;
		this.idDocteur = idDocteur;
		this.datePresation = datePresation;
	}
    
    public Prestation() {
    	
    }


	public int getIdPrestation() {
		return idPrestation;
	}


	public void setIdPrestation(int idPrestation) {
		this.idPrestation = idPrestation;
	}



	public int getIdPatient() {
		return idPatient;
	}



	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}



	public int getIdDocteur() {
		return idDocteur;
	}



	public void setIdDocteur(int idDocteur) {
		this.idDocteur = idDocteur;
	}



	public String getDatePresation() {
		return datePresation;
	}



	public void setDatePresation(String datePresation) {
		this.datePresation = datePresation;
	}



	public void Traiter(int idPatient,int idDocteur) {
    	try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/payement","postgres","mdpprom13");
		    
		    Statement stmt = conn.createStatement();
		    stmt.execute("insert into prestation values(DEFAULT,"+idPatient+","+idDocteur+",now()");
		    conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }


	public Prestation getPrestation(int idDocteur ){
		ArrayList<Prestation> ret = new ArrayList<Prestation>();
        try {
            try {
		Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
		e.printStackTrace();
            }
            Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/EnergieRenouvelable","postgres","mdpprom13");
		    
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select docteur.*, prestation.* from docteur join prestation on prestation.idDocteur = docteur.idDocteur where idDocteur = '"+ idDocteur+"'");
            while(res.next()) {
		int id = res.getInt("idPrestation");
		int id1 = res.getInt("idPatient");
		int id2 = res.getInt("idDocteur");
		String date = res.getString("datePrestation");
		Prestation a = new Prestation(id,id1,id2,date);
		ret.add(a);
        }
		conn.close();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ret;
	}
}
