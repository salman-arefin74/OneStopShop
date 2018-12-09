
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class MyDatabaseHandler {
    Connection connect = null;
    
    public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/one_stop_shop","root", "");
            JOptionPane.showMessageDialog(null, "Successfully Connected to Mysql");
           // System.out.println("Successfully Connected to Mysql");
           return connect;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            //System.out.println("Not Connected..");
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet testQuery(){
            ResultSet resultSet = null;
        try{
            String query = "SELECT * FROM student";
            /*String query = "SELECT * FROM student WHERE name =? and id =?";
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setString(1, "Zhang");
            pStatement.setString(2, "00128");
            
           resultSet = pStatement.executeQuery();*/
            
            Statement statement ;
            statement = connect.createStatement();
            resultSet = statement
                   .executeQuery(query);

            System.out.println("Successfully Done Query..");
           
        }catch(Exception e){
            System.out.println("Error in Query..");
            e.printStackTrace();
        }
            
        return resultSet;
    }
    
    public void showResult(ResultSet resultSet) {
        try{
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String dept_name = resultSet.getString("dept_name");
                String total_cred = resultSet.getString("tot_cred");
           
                System.out.println(id + " " + name + " " + dept_name+" "+total_cred);
            
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void insertData(){
        try{
             
            String query = "INSERT INTO student VALUES(?,?,?,?)";
            PreparedStatement pStatement = connect.prepareStatement(query);
            pStatement.setString(1, "123");
            pStatement.setString(2, "ABC");
            pStatement.setString(3, "Comp.Sci.");
            pStatement.setString(4, "105.2");
           
            pStatement.executeUpdate();
            
            System.out.println("Successfully Insert..");
            
            
        }catch(Exception e){
            System.out.println("Error in inserting");
            e.printStackTrace();
        }
    }
}
