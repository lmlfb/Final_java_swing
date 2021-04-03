package my_package;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JPanel;

import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class menu_window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void afficher_menu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_window window = new menu_window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(251,243,219));
		frame.getContentPane().setBounds(new Rectangle(0, 0, 100, 100));
		frame.setBounds(100, 100, 287, 272);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
		
		    @Override
		    public void windowClosing(WindowEvent event) {
		        int retour = showConfirmDialog();
		        if(retour==0)
		         System.exit(0);
		       }
		    });
		

		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(menu_window.class.getResource("/my_package/logo_anim.gif")));
		lblNewLabel.setBounds(32, 34, 200, 150);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Candidat");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ajout");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				saisir_etudiant.display();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
				
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Suppression");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				delete_window.display();	
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Liste");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//affichage_etudiant.display();	
				/*Vue_class vue = new Vue_class(Model_class.ListerEtudiant(Model_class.getConnection()));
				affichage_eleve affichage_eleve1 = new affichage_eleve();
				affichage_eleve1.rempTab(Model_class.ListerEtudiant(Model_class.getConnection()));
				affichage_eleve1.afficher();/**/
				Jtable_eleves jtable_eleve = new Jtable_eleves();

			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Sp\u00E9cialit\u00E9");
		menuBar.add(mnNewMenu_1);
		
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Ajout");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ajouterSpe ajouterSpe_ = new ajouterSpe();
				ajouterSpe_.display();
			}
		});
		

		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Suppression");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				delete_bac.display();	
				
				
			}
		});

		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Liste");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Jtable_filiere jtable_filiere = new Jtable_filiere();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Fili\u00E8re");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Ajout");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ajouterFiliere add_filiere = new ajouterFiliere();
				add_filiere.display();
			}
		});
		
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Suppression");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				delete_filiere.display();	
				
				
			}
		});
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Liste");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//affichage_etudiant.display();	
				/*Vue_class vue = new Vue_class(Model_class.ListerEtudiant(Model_class.getConnection()));
				affichage_eleve affichage_eleve1 = new affichage_eleve();
				affichage_eleve1.rempTab(Model_class.ListerEtudiant(Model_class.getConnection()));
				affichage_eleve1.afficher();/**/
				Jtable_bac jtable_bac = new Jtable_bac();

			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_3 = new JMenu("Help");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Info");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				info_frame.display();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Quitter");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showConfirmDialog() == JOptionPane.YES_OPTION) {
					frame.dispose();
				}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);
	}
	
	static int showConfirmDialog(){
		  return JOptionPane.showConfirmDialog(
		       null,
		       "Voulez-vous vraiment quitter?",
	       "Quitter",
	       JOptionPane.YES_NO_OPTION);
	 }
}
