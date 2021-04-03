package my_package;

import java.sql.ResultSet;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Vue_class extends JFrame {
	
	ResultSet resset;
	
	int x = 1500;
	int y = 500;
	JFrame myFrame;
	
	static int i = 0;
	
	
	public Vue_class(ResultSet res) {
		
		super();
		this.resset = res;
		
		if(i==0) {
			
			i++;
		
		myFrame = new JFrame("My_jtable_frame");
		myFrame.setBounds(0, 0, x, y);

		myFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		myFrame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent event) {
		        exit();
		    }
		});
		
		JTable liste = new JTable(new Data_controller(res));
		

		JPanel jpanel = new JPanel();

		JScrollPane jScrollPane = new JScrollPane(liste);
		
				
		myFrame.add(jScrollPane);
		
		myFrame.setVisible(true);
		
		}
		
		
	}
	
	public void exit() {
		
		myFrame.dispose();
		i=0;
		menu_window.afficher_menu();
		
	}
	


}
