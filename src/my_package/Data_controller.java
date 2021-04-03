package my_package;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;
     
     
public class Data_controller extends AbstractTableModel   {
    
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
   
    public Data_controller(ResultSet resultSet) {
        this.resultSet = resultSet;       
        try {
          this.resultSetMetaData = resultSet.getMetaData();
        }
        catch (SQLException e) {
          e.printStackTrace();
        }
      }
    
      @Override
      public int getColumnCount() {
        try {
          return resultSetMetaData.getColumnCount();
        }
        catch (SQLException e) {
          e.printStackTrace();
          return 0;
        }
      }
     
      @Override
      public int getRowCount() {
        try {
          resultSet.last();
          return resultSet.getRow();
        }
        catch (SQLException e) {
          e.printStackTrace();
          return 0;
        }
      }
     
      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
        try {
          resultSet.absolute(rowIndex + 1);
          return resultSet.getObject(columnIndex + 1);
        }
        catch (SQLException e)  {
          e.printStackTrace();
          return null;
        }
      }
     
      String[] employee = {"nom", "prénom", "Date naissance", "Lieu naissance", "sexe", "nationalité", "rue", "cp", "ville", "telephone", "mail", "niveau"};

      @Override
      public String getColumnName(int index) {
          return employee[index];
      }
     
}
