package my_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class henri {
	
	
	//méthode connexion
	public static Boolean Login(Connection connection, String login, String password) {
	 	int i = 0;
	    try   {	
	        String requete = "SELECT * FROM utilisateur WHERE login = ? AND password = ?"; 
	        PreparedStatement statement_  = connection.prepareStatement(requete); 
	        statement_.setString(1, login); 
	        statement_.setString(2, password); 
	        ResultSet result_ = statement_.executeQuery(); 
	        while (result_.next()) { 
	            i++;
	        }  
	    }
	    catch ( SQLException e )
	    {
	      e.printStackTrace();
	    }   
		if(i==0) {
			return false;
		}
		else {
			return true;
		}			
	}
	
	//methode pour insérer dans la base
	public static void InsertSpe(Connection connection, String SPeAInserer) {	
	 	int i = 0;
	    try{
	        String query = "INSERT INTO `bac` (`idBac`, `libelle`) VALUES (NULL, ?);"; 
	        PreparedStatement myStmt  = connection.prepareStatement(query); 
	        myStmt.setString(1, SPeAInserer); 
	        myStmt.executeUpdate();
	    }
	    catch ( SQLException e )
	    {
	      e.printStackTrace();
	    }
	}
	
	//méthode pour faire un select 
	public static ResultSet geFiliereField(Connection connection) {
		ResultSet rs = null;
	    try   {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
	        rs = st.executeQuery( "SELECT idFil, nom FROM filiere" );    
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return rs;
	}
	
	
	//méthode connextion
	public static Connection getConnection()
	{
	  Connection connection = null;
	  boolean ok = false;
	  String nomBase = "bddgraph";
	  String URL_BDD = "jdbc:mysql://localhost:3306/"+nomBase+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
	
	  try {
	    Class.forName("com.mysql.cj.jdbc.Driver") ;
	    ok = true;
	 }
	 catch ( ClassNotFoundException e ) {
	   System.out.println( "ERREUR chargement du pilote: pilote non trouvé" );
	   e.printStackTrace();
	 }
	
	 if (ok) {
	   try {
	     connection = DriverManager.getConnection(URL_BDD,"root","");
	   }
	   catch ( SQLException e ) {
	     System.out.println( "ERREUR de connexion à la base de données: " + URL_BDD );
	     e.printStackTrace();
	   }
	 }  
	  return connection;
	}
	

}
