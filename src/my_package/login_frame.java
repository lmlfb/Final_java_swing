package my_package;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.Color;

public class login_frame {

	private JFrame frame;
	private JTextField login_field;
	private JTextField pass_field;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void displayWindow() throws Exception {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					login_frame window = new login_frame();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login_frame() {
				
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 273, 283);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
/*
		try {
		    UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
*/
		
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent event) {
		        int retour = showConfirmDialog();
		        if(retour==0)
		         System.exit(0);
		       }
		    });
		
		
		login_field = new JTextField();
		login_field.setBounds(10, 86, 236, 25);
		frame.getContentPane().add(login_field);
		login_field.setColumns(10);
		

		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(10, 63, 114, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 134, 114, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Model_class.Login(Model_class.getConnection(), login_field.getText(), pass_field.getText())) {
					frame.dispose();
					menu_window.afficher_menu();
				}
				else {
					JFrame f=new JFrame();  
					JOptionPane.showMessageDialog(f,"Mauvais Identifiants");  
				}
				
			}
		});
		btnNewButton.setBounds(161, 220, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Gestionnaire \u00E9l\u00E8ves");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(51, 9, 171, 44);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(251,243,219));
		panel.setBounds(0, 49, 269, 161);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		pass_field = new JPasswordField();
		pass_field.setBounds(10, 109, 234, 25);
		panel.add(pass_field);
		pass_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	static int showConfirmDialog(){
		  return JOptionPane.showConfirmDialog(
		       null,
		       "Voulez-vous vraiment quitter?",
	       "Quitter",
	       JOptionPane.YES_NO_OPTION);
	 }
	
}
