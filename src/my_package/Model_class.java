package my_package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class Model_class {
	
	
	public static Boolean Login(Connection connection, String login, String password) {
		 	int i = 0;
		    try   {	
		        String query = "SELECT * FROM utilisateur WHERE login = ? AND password = ?"; 
		        PreparedStatement myStmt  = connection.prepareStatement(query); 
		        myStmt.setString(1, login); 
		        myStmt.setString(2, password); 
		        ResultSet myRs = myStmt.executeQuery(); 
		        while (myRs.next()) { 
		            String Name = myRs.getString("login"); 
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
	
	public static void InsertFiliere(Connection connection, String filiereAInserer) {
		
	 	int i = 0;
	 
	    try   {
	    	
	        String query = "INSERT INTO `filiere` (`idFil`, `nom`) VALUES (NULL, ?);"; 
	        PreparedStatement myStmt  = connection.prepareStatement(query); 
	        
	        myStmt.setString(1, filiereAInserer); 

	    
	        myStmt.executeUpdate();
	        
	        alert("La filière a bien été insérée");
	        
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	    	alert("Erreur durant l'insertion, veuillez vérifier votre saisi");
	      e.printStackTrace();
	    }
	}
	
	public static void InsertSpe(Connection connection, String SPeAInserer) {
		
	 	int i = 0;
	 
	    try   {
	    	
	        String query = "INSERT INTO `bac` (`idBac`, `libelle`) VALUES (NULL, ?);"; 
	        PreparedStatement myStmt  = connection.prepareStatement(query); 
	        
	        myStmt.setString(1, SPeAInserer); 

	    
	        myStmt.executeUpdate();
	        
	        alert("La spécialité a bien été insérée");
	        
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	    	alert("Erreur durant l'insertion, veuillez vérifier votre saisi");
	      e.printStackTrace();
	    }
	}
	
	public static void InsertStudent(Connection connection, String Nom, String Prenom, String Date_naiss, String Lieu_naiss, String sexe, String nation, String Rue, String Cp, String ville, String telephone, String mail, String niveau, Integer filiere, String loisir, Integer Bac) {
		
	 	int i = 0;
	 
	    try   {
	    	
	        String query = "INSERT INTO `etudiant` "
	        		+ "(`nom`, `prenom`, `dateNaiss`, `lieuNaiss`, `sexe`, `nationalite`, `rue`, `cp`, `ville`, `telephone`, `mail`, `niveau`, `loisir`, `idFil`, `idBac`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	        PreparedStatement myStmt  = connection.prepareStatement(query); 
	        
	        myStmt.setString(1, Nom); 
	        myStmt.setString(2, Prenom); 
	        //myStmt.setString(3, "2021-12-31"); 
	        myStmt.setString(3, Date_naiss); 
	        myStmt.setString(4, Lieu_naiss); 
	        myStmt.setString(5, sexe); 
	        myStmt.setString(6, nation); 
	        myStmt.setString(7, Rue); 
	        myStmt.setString(8, Cp); 
	        myStmt.setString(9, ville); 
	        myStmt.setString(10, telephone); 
	        myStmt.setString(11, mail); 	
	        myStmt.setString(12, niveau); 
	        myStmt.setString(13, loisir); 
	        myStmt.setInt(14, filiere); 
	        myStmt.setInt(15, Bac); 
	        
	        myStmt.executeUpdate();
	        
	        alert("L'étudiant a bien été inséré");
	        
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	    	alert("Erreur durant l'insertion, veuillez vérifier votre saisi");
	      e.printStackTrace();
	    }
	}
	
	public static void supprimerEtudiant(Connection connection, String nomEtu) {
		
	 	int i = 0;
	 
	    try   {
	    	
	    	String query = "DELETE FROM `etudiant` WHERE nom = ?";       
	        PreparedStatement myStmt  = connection.prepareStatement(query); 
	        
	        myStmt.setString(1, nomEtu); 
	    
	        myStmt.executeUpdate();
	        
	        alert("La suppression a bien été effectuée");
	        
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	    	alert("Erreur durant l'insertion, veuillez vérifier votre saisi");
	      e.printStackTrace();
	    }
	}
	
	public static void supprimerFil(Connection connection, String nomEtu) {
		
	 	int i = 0;
	 
	    try   {
	    	
	    	String query = "DELETE FROM `filiere` WHERE nom = ?";       
	        PreparedStatement myStmt  = connection.prepareStatement(query); 
	        
	        myStmt.setString(1, nomEtu); 
	    
	        myStmt.executeUpdate();
	        
	        alert("La suppression a bien été effectuée");
	        
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	    	alert("Erreur durant l'insertion, veuillez vérifier votre saisi");
	      e.printStackTrace();
	    }
	}
	
	public static void supprimerBac(Connection connection, String nomEtu) {
		
	 	int i = 0;
	 
	    try   {
	    	
	    	String query = "DELETE FROM `bac` WHERE libelle = ?";       
	        PreparedStatement myStmt  = connection.prepareStatement(query); 
	        
	        myStmt.setString(1, nomEtu); 
	    
	        myStmt.executeUpdate();
	        
	        alert("La suppression a bien été effectuée");
	        
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	    	alert("Erreur durant l'insertion, veuillez vérifier votre saisi");
	      e.printStackTrace();
	    }
	}
	
	public static ResultSet ListerEtudiant(Connection connection) {
		
		   
		ResultSet rs = null;
		
	    try   {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
	        rs = st.executeQuery( "SELECT `nom`, `prenom`, `dateNaiss`, `lieuNaiss`, `sexe`, `nationalite`, `rue`, `cp`, `ville`, `telephone`, `mail`, `niveau` FROM `etudiant`" );
	        Vue_class vue_class = new Vue_class(rs);
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
    return rs;

}
	
	public static ResultSet geFiliereField(Connection connection) {
		
		ResultSet rs = null;
		
	    try   {
	        Statement st = connection.createStatement();
	        rs = st.executeQuery( "SELECT * FROM filiere" );
	        
	        
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    return rs;

}
	
	public static ResultSet getEtudiantField(Connection connection) {
		
		ResultSet rs = null;
		
	    try   {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
	        rs = st.executeQuery( "SELECT `nom`, `idEtu`, `prenom` FROM `etudiant`" );
	        
	        
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    return rs;

}
	
	public static ResultSet geBacField(Connection connection) {
		
		ResultSet rs = null;
		
	    try   {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
	        rs = st.executeQuery( "SELECT idBac, libelle FROM bac" );
	        
	        
	    }
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    return rs;

}
		
	public static Connection getConnection()
	{
	  Connection connection = null;
	  boolean ok = false;
	  String URL_BDD = "jdbc:mysql://localhost:3306/bddgraph?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
	
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
	
	public static void alert(String str) {
		JFrame f=new JFrame();  
		JOptionPane.showMessageDialog(f,str);  
	}

}


