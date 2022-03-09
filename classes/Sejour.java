package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import java.sql.*;
import java.util.ArrayList;

public class Sejour {

	private static final String nomBase = "GestionEcole";
	private static final String user = "GestionEcole";
	private static final String mdp = "GestionEcole";

    int idSejour;
    int idPatient;
    int idChambre;
    String dateEntree;
    String dateSortie;
    boolean paye;
    
    public Sejour(int idSejour, int idPatient, int idChambre, String dateEntree, String dateSortie, boolean paye) {
		super();
		this.idSejour = idSejour;
		this.idPatient = idPatient;
		this.idChambre = idChambre;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.paye = paye;
	}    
    
    public Sejour() {
    	
    }
    
	public int getIdSejour() {
		return idSejour;
	}
	public void setIdSejour(int idSejour) {
		this.idSejour = idSejour;
	}
	
	public int getIdPatient() {
		return idPatient;
	}


	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}


	public int getIdChambre() {
		return idChambre;
	}


	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}


	public String getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}
	public String getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}
	public boolean isPaye() {
		return paye;
	}
	public void setPaye(boolean paye) {
		this.paye = paye;
	}
	



    public ArrayList<Sejour> getSejours(int idPatient) throws Exception{
    	ArrayList<Sejour> ret = new ArrayList<Sejour>();
    	try {
            try {
            	Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
            	e.printStackTrace();	
            }
        Connection conn = DriverManager.getConnection(
            	"jdbc:postgresql://localhost:5432/EnergieRenouvelable","postgres","mdpprom13");
		    
        Statement stmt = conn.createStatement();
        //ResultSet res = stmt.executeQuery("select * from \"Appareil\"");
        ResultSet res = stmt.executeQuery("select * from sejour where idPatient = "+idPatient);
        while(res.next()) {
            int idSejour = res.getInt("idSejour");
            
            int idChambre = res.getInt("idChambre");
            String dateEntree = res.getString("dateEntree");
            String dateSortie = res.getString("dateSortie");
            Boolean b = res.getBoolean("paye");
            Sejour s = new Sejour(idSejour,idPatient,idChambre,dateEntree,dateSortie,b);
            ret.add(s);
        }
			conn.close();
        } catch (SQLException e) {
			e.printStackTrace();
		}
    	return ret;
    }
    
    public int getTotalAPayer(int idSejour) throws Exception{
    	int ret = 0;
    	try {
            try {
            	Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
            	e.printStackTrace();	
            }
        Connection conn = DriverManager.getConnection(
            	"jdbc:postgresql://localhost:5432/EnergieRenouvelable","postgres","mdpprom13");
		    
        Statement stmt = conn.createStatement();
        //ResultSet res = stmt.executeQuery("select * from \"Appareil\"");
        ResultSet res = stmt.executeQuery("select * from getSommeTotal where idSejour = "+idSejour);
        while(res.next()) {
        	ret = res.getInt(0);
        }
			conn.close();
        } catch (SQLException e) {
			e.printStackTrace();
		}
    	return ret;
    }
    
    public int getResteAPayer(int idSejour) throws Exception {
    	int ret = 0;
    	try {
            try {
            	Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
            	e.printStackTrace();	
            }
        Connection conn = DriverManager.getConnection(
            	"jdbc:postgresql://localhost:5432/EnergieRenouvelable","postgres","mdpprom13");
		    
        Statement stmt = conn.createStatement();
        //ResultSet res = stmt.executeQuery("select * from \"Appareil\"");
        ResultSet res = stmt.executeQuery("select * from resteAPayer where idSejour = "+idSejour);
        while(res.next()) {
        	ret = res.getInt(0);
        }
			conn.close();
        } catch (SQLException e) {
			e.printStackTrace();
		}
    	return ret;
    }
    

	public void payer(int idSejour,int somme) throws Exception{
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/payement","postgres","mdpprom13");
		    
		    Statement stmt = conn.createStatement();
		    stmt.execute("insert into payement values(DEFAULT,"+idSejour+","+somme+"");
		    conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	public void attribuer(int idPatient, int idChambre ) throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = null;
		Statement  stmt = null;
		ResultSet res = null;
		String statement = "insert into sejour(idPatient,idChambre,dateEntree,dateSortie,paye) values ('"+ idPatient+"','"+ idChambre+"', now() , null,false)";
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
    
}
