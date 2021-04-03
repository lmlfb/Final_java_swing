package my_package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class info_frame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					info_frame window = new info_frame();
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
	public info_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 328, 292);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Gestion \u00E9tudiants");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(95, 10, 150, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane txtpnLogicielDeGestions = new JTextPane();
		txtpnLogicielDeGestions.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnLogicielDeGestions.setText("Logiciel de gestions d\u00E9velopp\u00E9s par Louis-Marie Le Floch\r\n\r\nAjouter et supprimer facilement vos \u00E9tudiants, les bac et les fili\u00E8res\r\n\r\nG\u00E9rer d\u00E8s maintenant plus facilement votre \u00E9tablissement\r\n\r\n");
		txtpnLogicielDeGestions.setBounds(32, 45, 265, 159);
		txtpnLogicielDeGestions.setEditable(false);
		frame.getContentPane().add(txtpnLogicielDeGestions);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				menu_window.afficher_menu();
			}
		});
		btnNewButton.setBounds(212, 224, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
