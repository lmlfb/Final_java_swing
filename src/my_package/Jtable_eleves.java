package my_package;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jtable_eleves extends JFrame{
    public Jtable_eleves(){
        super();
        try {

            int nombre_colonne = 13;
            Connection conn = Model_class.getConnection();
            Statement stmNbFil = (Statement) conn.createStatement();
            ResultSet resNbFil = stmNbFil.executeQuery("SELECT count(*) FROM etudiant");
            int nbEtudiant=0;
            while (resNbFil.next()){
                nbEtudiant = resNbFil.getInt("count(*)");
            }

            Statement stmInfo = (Statement) conn.createStatement();
            String reqInfo = "SELECT * FROM etudiant";
            ResultSet resInfo = stmInfo.executeQuery(reqInfo);

            String entetes[] = {"idEtu", "nom","prenom", "date Naissance", "lieu Naissance", "sexe", "nationalite", "rue", "code postal", "ville", "telephone", "mail", "niveau"};
            String donnees[][] = new String[nbEtudiant][nombre_colonne];

            int i=0;
            while (resInfo.next()) {
                donnees[i][0]= resInfo.getString("idEtu");
                donnees[i][1]= resInfo.getString("nom");
                donnees[i][2]= resInfo.getString("prenom");
                donnees[i][3]= resInfo.getString("dateNaiss");
                donnees[i][4]= resInfo.getString("lieuNaiss");
                donnees[i][5]= resInfo.getString("sexe");
                donnees[i][6]= resInfo.getString("nationalite");
                donnees[i][7]= resInfo.getString("rue");
                donnees[i][8]= resInfo.getString("cp");
                donnees[i][9]= resInfo.getString("ville");
                donnees[i][10]= resInfo.getString("telephone");
                donnees[i][11]= resInfo.getString("mail");
                donnees[i][12]= resInfo.getString("niveau");

                i++;
            }


            DefaultTableModel model = new DefaultTableModel(donnees, entetes);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            TableColumn col = null;
            for (int j = 0; j < nombre_colonne; j++) {
                col = table.getColumnModel().getColumn(j);
                
                if(j==0){
                	col.setWidth(10);
                }
 
                if(j==10){
                	col.setPreferredWidth(500);
                }
                if(j==11){
                	col.setPreferredWidth(300);
                }
                else {
                	col.setPreferredWidth(200);
                }
                
            }
            int hauteur_pixel = 30;
            int cache_pixel = 60;
            for (int j=0; j<nbEtudiant;j++){
                table.setRowHeight(j,30);
                cache_pixel+=hauteur_pixel;
            }
            table.setFont(new Font("Serif", Font.PLAIN, 15));
            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(0, 39, 1540, 140);
            JFrame f = new JFrame("Liste des etudiants");
            f.setResizable(false);
            JPanel panel = new JPanel();
            panel.setBackground(SystemColor.inactiveCaptionBorder);
            panel.setForeground(SystemColor.info);
            panel.setLayout(null);
            panel.add(pane);
            f.getContentPane().add(panel);
            
            JButton btnNewButton = new JButton("Retour");
            btnNewButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		f.dispose();
            		menu_window.afficher_menu();
            	}
            });
            btnNewButton.setBounds(1455, 189, 85, 21);
            panel.add(btnNewButton);
            
            JLabel lblNewLabel = new JLabel("Liste des \u00E9tudiants");
            lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblNewLabel.setBounds(598, 10, 150, 19);
            panel.add(lblNewLabel);
            f.setSize(1554, 256);
            //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.setLocationRelativeTo(null);
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
        }
    }
}
