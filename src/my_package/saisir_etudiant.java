package my_package;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class saisir_etudiant {

	private JFrame frame;
	JFormattedTextField telephone;
	private JTextField nom;
	private JTextField prenom;
	
	ArrayList<Integer> filiere_index = new ArrayList<Integer>();
	ArrayList<Integer> libelle_index = new ArrayList<Integer>();

	private JTextField lieu_naissance;
	private JTextField nationalite;
	private JTextField Rue;
	private JTextField CP;
	private JTextField ville;
	private JTextField mail;
	private JFormattedTextField date;
	JCheckBox Loisir_Musique;
	JCheckBox Loisir_Lecture;
	JCheckBox Loisir_Voyage;

	
	private String sexe_str = "Homme";
	
	char[] LoisirArray = {'_', '_', '_', '_'};
	
	JComboBox filiere;
	JComboBox bac;
	
	JRadioButton femme;
	private JRadioButton homme;
	private JCheckBox Loisir_Sport;

	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saisir_etudiant window = new saisir_etudiant();

					
					
					
					
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
	public saisir_etudiant() {
		initialize();
		
		ResultSet res1 = Model_class.geFiliereField(Model_class.getConnection());
		try {
			while (res1.next()) {
				 filiere.addItem(res1.getString("nom"));
				 filiere_index.add(Integer.valueOf(res1.getString("idFil")));
				 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet res2 = Model_class.geBacField(Model_class.getConnection());
		try {
			while (res2.next()) {
				 bac.addItem(res2.getString("libelle"));
				 libelle_index.add(Integer.valueOf(res2.getInt("idBac")));
				 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		frame.setBounds(100, 100, 785, 552);
		
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent event) {
		        exit();
		    }
		});
		
		
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		femme = new JRadioButton("femme");
		femme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homme.setSelected(false);
				sexe_str = "Femme";
			}
		});
		femme.setBounds(226, 403, 103, 21);
		frame.getContentPane().add(femme);

		
		mail = new JTextField();
		mail.setBounds(89, 335, 240, 19);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		homme = new JRadioButton("homme");
		homme.setSelected(true);
		homme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				femme.setSelected(false);
				sexe_str = "Homme";
			}
		});
		homme.setBounds(104, 403, 103, 21);
		 frame.getContentPane().add(homme);
		
		
		Loisir_Sport = new JCheckBox("Sport");
		Loisir_Sport.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println("stateChanged");
			}
		});
		Loisir_Sport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("actionPerformed");
				remp_loisir();
			}
		});
		Loisir_Sport.setBounds(83, 453, 68, 21);
		frame.getContentPane().add(Loisir_Sport);
		
		Loisir_Musique = new JCheckBox("Musique");
		Loisir_Musique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remp_loisir();
			}
		});
		Loisir_Musique.setBounds(158, 453, 80, 21);
		frame.getContentPane().add(Loisir_Musique);
		
		Loisir_Voyage = new JCheckBox("Voyage");
		Loisir_Voyage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remp_loisir();
			}
		});
		Loisir_Voyage.setBounds(240, 453, 74, 21);
		frame.getContentPane().add(Loisir_Voyage);
		
		Loisir_Lecture = new JCheckBox("Lecture");
		Loisir_Lecture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remp_loisir();
			}
		});
		Loisir_Lecture.setBounds(316, 453, 93, 21);
		frame.getContentPane().add(Loisir_Lecture);
		
		filiere = new JComboBox();
		
		filiere.setBounds(499, 45, 133, 21);
		frame.getContentPane().add(filiere);
		
		JComboBox niveau = new JComboBox();
		niveau.setModel(new DefaultComboBoxModel(new String[] {"d\u00E9butant", "interm\u00E8diaire", "expert"}));
		niveau.setBounds(499, 89, 133, 21);
		frame.getContentPane().add(niveau);
		
		bac = new JComboBox();
		bac.setBounds(502, 132, 130, 21);
		frame.getContentPane().add(bac);
		
		JTextPane affichage_res = new JTextPane();
		affichage_res.setFont(new Font("Tahoma", Font.PLAIN, 13));
		affichage_res.setBounds(413, 176, 334, 270);
		frame.getContentPane().add(affichage_res);
		
		JLabel lblNewLabel_10 = new JLabel("Filière");
		lblNewLabel_10.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(444, 49, 45, 13);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Niveau");
		lblNewLabel_11.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(444, 93, 45, 13);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("bac");
		lblNewLabel_12.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(447, 136, 45, 13);
		frame.getContentPane().add(lblNewLabel_12);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nom.getText().compareTo("") != 0 && prenom.getText().compareTo("") != 0  && date.getText().compareTo("") != 0   && lieu_naissance.getText().compareTo("") != 0  && nationalite.getText().compareTo("") != 0  && Rue.getText().compareTo("") != 0  && CP.getText().compareTo("") != 0  && ville.getText().compareTo("") != 0    && telephone.getText().compareTo("") != 0    && mail.getText().compareTo("") != 0) {
					
				remp_loisir();
							
				String Loisir_res = String.valueOf(LoisirArray[0])+String.valueOf(LoisirArray[1])+String.valueOf(LoisirArray[2])+String.valueOf(LoisirArray[3]);
				System.out.println("RAS : " + Loisir_res);
				//checker longeur code postal et telephone et date
				
				Model_class.InsertStudent(Model_class.getConnection(), nom.getText(), prenom.getText(), date.getText(),  lieu_naissance.getText(), sexe_str, nationalite.getText(), Rue.getText(), CP.getText(), ville.getText(), telephone.getText(), mail.getText(), String.valueOf(niveau.getSelectedItem()), filiere_index.get(filiere.getSelectedIndex()), Loisir_res, libelle_index.get(bac.getSelectedIndex())); 
				
				frame.dispose();
				saisir_etudiant.display();
				
				}
				else {
					alert("Un des champs du formulaire n'est pas rempli, veuillez le complï¿½ter");

				}
			}
		});
		ok.setBounds(662, 479, 85, 21);
		frame.getContentPane().add(ok);
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				menu_window.afficher_menu();
			}
		});
		annuler.setBounds(567, 479, 85, 21);
		frame.getContentPane().add(annuler);
		
		
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("+## # ## ## ## ##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		mask.setValidCharacters("0123456789"); 
		
		MaskFormatter mask1 = null;
		try {
			mask1 = new MaskFormatter("####-##-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		mask1.setValidCharacters("0123456789"); 
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(0, 40, 403, 341);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		nom = new JTextField();
		nom.setBounds(116, 10, 96, 19);
		panel.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(116, 39, 158, 19);
		panel.add(prenom);
		prenom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 13, 71, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 42, 71, 13);
		panel.add(lblNewLabel_1);
		date = new JFormattedTextField(mask1);
		date.setBounds(116, 65, 69, 19);
		panel.add(date);
		
		JLabel lblNewLabel_2 = new JLabel("Date de naissance");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 68, 133, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Nationalit\u00E9");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 114, 96, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Lieu de naissance");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 91, 133, 13);
		panel.add(lblNewLabel_3);
		

		lieu_naissance = new JTextField();
		lieu_naissance.setBounds(116, 88, 96, 19);
		panel.add(lieu_naissance);
		lieu_naissance.setColumns(10);
		
		nationalite = new JTextField();
		nationalite.setBounds(116, 111, 96, 19);
		panel.add(nationalite);
		nationalite.setColumns(10);
		
		Rue = new JTextField();
		Rue.setBounds(71, 163, 96, 19);
		panel.add(Rue);
		Rue.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Rue");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(36, 166, 45, 13);
		panel.add(lblNewLabel_5);
		
		CP = new JTextField();
		CP.setBounds(222, 163, 96, 19);
		panel.add(CP);
		CP.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CP");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(198, 166, 45, 13);
		panel.add(lblNewLabel_6);
		
		ville = new JTextField();
		ville.setBounds(72, 212, 246, 19);
		panel.add(ville);
		ville.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Ville");
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(36, 215, 45, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Mail");
		lblNewLabel_9.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(51, 298, 45, 13);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("Téléphone");
		lblNewLabel_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(24, 265, 74, 13);
		panel.add(lblNewLabel_8);
		telephone = new JFormattedTextField(mask);
		telephone.setBounds(89, 262, 133, 19);
		panel.add(telephone);
		
		JLabel lblContactEtudiant = new JLabel("Contact Etudiant");
		lblContactEtudiant.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContactEtudiant.setBounds(348, 10, 171, 20);
		frame.getContentPane().add(lblContactEtudiant);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblSexe.setBounds(20, 403, 171, 20);
		frame.getContentPane().add(lblSexe);
		
		JLabel lblLoisirs = new JLabel("Loisirs");
		lblLoisirs.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblLoisirs.setBounds(20, 453, 171, 20);
		frame.getContentPane().add(lblLoisirs);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				remp_loisir();
				str+="Nom : " + nom.getText() + "\n";
				str+="Prénom : " + prenom.getText() + "\n";
				str+="Date naissance : " + date.getText() + "\n";
				str+="Lieu naissance : " + lieu_naissance.getText() + "\n";
				str+="Nationalité : " + nationalite.getText() + "\n";
				str+="Rue : " + Rue.getText() + "\n";
				str+="Code postal : " + CP.getText() + "\n";
				str+="Ville : " + ville.getText() + "\n";
				str+="Téléphone : " + telephone.getText() + "\n";
				str+="Mail : " + mail.getText() + "\n";
				str+="Sexe : " + sexe_str + "\n";
				str+="Loisir : " + LoisirToStr(LoisirArray) + "\n";
				str+="Filière : " +filiere.getSelectedItem().toString() + "\n";
				str+="Niveau : " + niveau.getSelectedItem().toString() + "\n";
				str+="Bac : " + bac.getSelectedItem().toString() + "\n";
				
				affichage_res.setText(str);
				
				/*private JTextField lieu_naissance;
				private JTextField nationalite;
				private JTextField Rue;
				private JTextField CP;
				private JTextField ville;
				private JTextField mail;*/
			}
		});
		btnAfficher.setBounds(472, 479, 85, 21);
		frame.getContentPane().add(btnAfficher);
		
	}
	
	public void alert(String str) {
		JFrame f=new JFrame();  
		JOptionPane.showMessageDialog(f,str);  
	}
	
	public String LoisirToStr(char[] LoisirArray) {
		
		String res = "";
		if(LoisirArray[0] == 'O'){
			res+="Sport,";
		}
		if(LoisirArray[1] == 'O'){
			res+="Musique,";
		}
		if(LoisirArray[2] == 'O'){
			res+="Voyage,";
		}
		if(LoisirArray[3] == 'O'){
			res+="Lecture.";
		}

		return res;
	}
	
	public void remp_loisir(){
		if(Loisir_Sport.isSelected()) {LoisirArray[0] = 'O';	
		}else {LoisirArray[0] = 'N';			
		}
		
		if(Loisir_Musique.isSelected()) {LoisirArray[1] = 'O';
		}else {LoisirArray[1] = 'N';					
		}
		
		if(Loisir_Voyage.isSelected()) {LoisirArray[2] = 'O';					
		}else {LoisirArray[2] = 'N';					
		}
		
		if(Loisir_Lecture.isSelected()) {LoisirArray[3] = 'O';
		}else { LoisirArray[3] = 'N';					
		}
	}
	
	public void exit() {
		
		frame.dispose();
		menu_window.afficher_menu();
		
	}
}
