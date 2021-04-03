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

public class Jtable_filiere extends JFrame{
    public Jtable_filiere(){
        super();
        try {
            Connection conn = Model_class.getConnection();
            Statement stmNbFil = (Statement) conn.createStatement();
            ResultSet resNbFil = stmNbFil.executeQuery("SELECT count(idFil) FROM filiere");
            int nbBac=0;
            while (resNbFil.next()){
                nbBac = resNbFil.getInt("count(idFil)");
            }

            Statement stmInfo = (Statement) conn.createStatement();
            String reqInfo = "SELECT * FROM filiere";
            ResultSet resInfo = stmInfo.executeQuery(reqInfo);

            String entetes[] = {"idFil", "nom"};
            String donnees[][] = new String[nbBac][2];

            int i=0;
            while (resInfo.next()) {
                donnees[i][0]= resInfo.getString("idFil");
                donnees[i][1]= resInfo.getString("nom");
                i++;
            }


            DefaultTableModel model = new DefaultTableModel(donnees, entetes);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            TableColumn col = null;
            for (int j = 0; j < 2; j++) {
                col = table.getColumnModel().getColumn(j);
                col.setPreferredWidth(150);
            }
            for (int j=0; j<nbBac;j++){
                table.setRowHeight(j,30);
            }
            table.setFont(new Font("Serif", Font.PLAIN, 20));
            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(10, 10, 386, 213);
            JFrame f = new JFrame("Liste des spécialités");
            f.setResizable(false);




            JPanel panel = new JPanel();
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
            btnNewButton.setBounds(311, 241, 85, 21);
            panel.add(btnNewButton);

            f.setSize(426, 311);
            //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.setLocationRelativeTo(null);
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
        }
    }
}
