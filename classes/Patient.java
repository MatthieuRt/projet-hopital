package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Patient{
    int idPatient;
    String nomPrenom;
    String genre;
    String adresse;
    String dateNaissance;
    public Patient(int idPatient, String nomPrenom, String genre, String adresse,String dateNaissance) {
        this.idPatient = idPatient;
        this.nomPrenom = nomPrenom;
        this.genre = genre;
        this.adresse = adresse;
    }
    
    public Patient() {
    	
    }
    
    public int getIdPatient() {
        return idPatient;
    }
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
    public String getNomPrenom() {
        return nomPrenom;
    }
    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public void updatePatient(int idPatient,String nomPrenom, String adresse, String dateDeNaissance) {
    	try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Hopital","postgres","mdpprom13");
		    
		    Statement stmt = conn.createStatement();
		    stmt.execute("update patient set nomPrenom='"+nomPrenom+"', adresse = '"+adresse+"', dateDeNaissance ='"+dateDeNaissance+"' where idPatient = "+idPatient);
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    }


    public void insertPatient(String nomPrenom, String dateDeNaissance,String genre , String adresse, String dateNaissance){
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = null;
		Statement  stmt = null;
		ResultSet res = null;
		String statement = "insert into Patient(nomPrenom,genre,adresse,dateDeNaissance) values ('"+ nomPrenom+"',"+genre+",'"+adresse+"','"+dateNaissance+"')";
		try {
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "moi", "mdpprom13");
			stmt = c.createStatement();
			res = stmt.executeQuery(statement);
		}catch (SQLException e) {
			c.rollback();
		}
        finally {
			if(c != null)
				c.close();
			if(res !=null) {	
				res.close();
			}
		}
    }
    public ArrayList<Patient> getPatient(){
        ArrayList<Patient> ret = new ArrayList<Patient>();
        try {
            try {
		Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
		e.printStackTrace();
            }
            Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/EnergieRenouvelable","postgres","mdpprom13");
		    
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select * from \"Patient\"");
            while(res.next()) {
		int id = res.getInt("idPatient");
		String designation = res.getString("nomPrenom");
		String genre = res.getString("genre"); 	
		String adresse = res.getString("adresse"); 	
		String dateNaissance = res.getString("dateDeNaissance"); 	
		Patient a = new Patient(id,designation,genre,adresse,dateNaissance);
		ret.add(a); 
            }
		conn.close();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ret;
    }
    public ArrayList<Patient> getPatient(int idChambre, String dateEntree ){
        ArrayList<Patient> ret = new ArrayList<Patient>();
        try {
            try {
		Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
		e.printStackTrace();
            }
            Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/EnergieRenouvelable","postgres","mdpprom13");
		    
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select patient.*,sejour.* from sejour join patient on patient.idPatient = sejour.idPatient where sejour.idchambre = '"+ idChambre+"' and sejour.dateentree = '"+dateEntree+"' ");
            while(res.next()) {
		int id = res.getInt("idPatient");
		String designation = res.getString("nomPrenom");
		String genre = res.getString("genre"); 	
		String adresse = res.getString("adresse"); 	
		String dateNaissance = res.getString("dateDeNaissance"); 	
		Patient a = new Patient(id,designation,genre,adresse,dateNaissance);
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