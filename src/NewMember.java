/****************************************************************
 +--------------------------------------------------------------+
 | author derrick shibero wakhu                                 |
 +--------------------------------------------------------------+
 ****************************************************************/

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewMember {
    private static Connection c = null;
    private static Statement stmt = null;
    public static void Register(String id, String fName, String lName, String gender, String password){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lib.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully\ttable member registration");

            stmt = c.createStatement();
            String sql = "INSERT INTO LibMember (idNumber, FirstName, Gender, LastName, Password)"+
                    "VALUES ('"+id+"','"+fName+"','"+gender+"','"+lName+"','"+password+"')";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
            System.out.println("successfully created the records");

        }catch (Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public static String getFName(String id){
        String fname = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lib.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully\ttable member registration");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LibMember where idNumber='"+id+"';");
            fname = rs.getString("FirstName");

            stmt.close();
            c.commit();
            c.close();
            System.out.println("successfully created the records");

        }catch (Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return fname;
    }
    public static String getPassword(String id){
        String password = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lib.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully\ttable member registration");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LibMember where idNumber='"+id+"';");
            password = rs.getString("Password");

            stmt.close();
            c.commit();
            c.close();
            System.out.println("successfully created the records");

        }catch (Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return password;
    }
}
