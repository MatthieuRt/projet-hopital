package classes;

import java.sql.*;
public class Connexion{
	Connection con;
	Statement stat;
	ResultSet res;
	ResultSet commit;

    private static String nom = "Pink";
    private static String mdp = "Guy";

	public Connexion(String req){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		 	this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:DBCOURS",nom,mdp);
  			this.stat= this.con.createStatement();
  			this.res=stat.executeQuery(req);

     	}
    	catch(SQLException sqle){sqle.printStackTrace();}
       	catch (Exception e) {e.printStackTrace();}
	}

	public ResultSet getResultset(){
		return this.res;
	}

	public void getCommit() throws Exception
	{

      this.stat.executeQuery("commit");
	}

	public Statement getStat(){
		return this.stat;
	}
}

