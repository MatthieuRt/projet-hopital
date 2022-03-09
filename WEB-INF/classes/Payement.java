package classes;


import java.sql.*;
import java.util.ArrayList;

public class Payement {
    int idPayement;
    int idSejour;
    double somme;
    public Payement(int idPayement, int idSejour, double somme) {
        this.idPayement = idPayement;
        this.idSejour = idSejour;
        this.somme = somme;
    }    
    public void payer (int idSejour, double somme ) throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = null;
		Statement  stmt = null;
		ResultSet res = null;
		String statement = "insert into payement(idSejour,somme) values ('"+ idSejour+"','"+somme+"')";
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

