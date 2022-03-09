package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import java.sql.*;
import java.util.ArrayList;

public class Docteur {
    int idDocteur;
    String nomPrenom;
    int idCategorieDocteur;
    
    public Docteur(int idDocteur, String nomPrenom, int idCategorieDocteur) {
        this.idDocteur = idDocteur;
        this.nomPrenom = nomPrenom;
        this.idCategorieDocteur = idCategorieDocteur;
    }

    public ArrayList<Docteur> getDocteurs(){
        ArrayList<Docteur> ret = new ArrayList<Docteur>();
        try {
            try {
		Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
		e.printStackTrace();
            }
            Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Hopital","postgres","mdpprom13");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select * from \"Docteur\"");
            while(res.next()) {
				int id = res.getInt("idDocteur");
				String designation = res.getString("nomPrenom");
				int categorie = res.getInt("idCategorieDocteur"); 	
				Docteur a = new Docteur(id,designation,categorie);
				ret.add(a);
            }
		conn.close();
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return ret;
    }

    
}
