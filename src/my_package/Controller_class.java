package my_package;

import javax.swing.UIManager;



public class Controller_class {

	public static void main(String[] args) throws Exception {
		

	//	try {UIManager.setLookAndFeel( new FlatLightLaf() );} catch( Exception ex ) { System.err.println( "Failed to initialize LaF" );}
		/*delete_window.display();	
		Jtable_eleves jtable_bac = new Jtable_eleves();
		Jtable_filiere jtable_filiere = new Jtable_filiere();
		Jtable_bac jtable_bac1 = new Jtable_bac();*/
		
		
		login_frame login = new login_frame();
		login.displayWindow();


	}

}
