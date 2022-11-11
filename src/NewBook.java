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

public class NewBook {
    private static Connection c = null;
    private static Statement stmt = null;
    public static void Register(String id, String author, String title, int edition, int isdn, int quantity, int year){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lib.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully\ttable member registration");

            stmt = c.createStatement();
            String sql = "INSERT INTO Books (bookId, bookAuthor, bookEdition, bookIsdn, bookTitle, quantity, yearPublished)"+
                    "VALUES ('"+id+"','"+author+"', "+edition+", "+isdn+", '"+title+"', "+quantity+", "+year+")";
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
    public static int getQuantity(String id){
        int quantity = 0;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lib.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully\ttable member registration");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Books where bookId='"+id+"';");
            quantity = rs.getInt("quantity");

            stmt.close();
            c.commit();
            c.close();
            System.out.println("successfully created the records");

        }catch (Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return quantity;
    }
    public static String getTitle(String id){
        String title = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lib.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully\ttable member registration");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Books where bookId='"+id+"';");
            title = rs.getString("bookTitle");

            stmt.close();
            c.commit();
            c.close();
            System.out.println("successfully created the records");

        }catch (Exception e){
            System.out.println(e.getClass().getName() +" : "+e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return title;
    }
}
