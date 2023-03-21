package NewEntries;/*
 * this class is used to deal with issues related to members in the library
 * it connects the system to the table in the database responsible members
 */


import Member.Member;
import database.Config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewMember {
    private static Connection c = null;
    private static Statement stmt = null;
    private static final Config config = new Config();
    private static final Member member = new Member();

    // entering general information on the members into the system
    public static void Register(String id, String fName, String lName, String gender, String password, String email,
                                String phoneNumber, String address, String county){
        try{
            c = config.getConnection();

            stmt = c.createStatement();
            String sql = "INSERT INTO LibMember (idNumber, FirstName, Gender, LastName, Password, Email, Phone_number, Address, County)"+
                    "VALUES ('"+id+"','"+fName+"','"+gender+"','"+lName+"','"+password+"','"+email+"', '"+phoneNumber+"', '"+address+"', '"+county+"')";
            stmt.executeUpdate(sql);

            stmt.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally {
            config.closeConnection(c);
        }
    }

    // getting the firstname of the user to be used in the reports
    public static String getFName(String id){
        String fname = null;
        try{
            c = config.getConnection();

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LibMember where idNumber='"+id+"';");
            fname = rs.getString("FirstName");

            stmt.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            config.closeConnection(c);
        }
        return fname;
    }

    // getting the password to be used in the login page
    public static String getPassword(String id){
        String password = null;
        try{
            c = config.getConnection();

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LibMember where idNumber='"+id+"';");
            password = rs.getString("Password");

            stmt.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            config.closeConnection(c);
        }
        return password;
    }

}