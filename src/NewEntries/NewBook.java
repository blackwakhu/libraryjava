package NewEntries;/*
 * this class is used to deal with issues related to book attributes in the library
 * it connects the system to the table in the database responsible for books
 */


import database.Config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewBook {
    private static Connection c = null;
    private static Statement stmt = null;
    private static Config config = new Config();

    // code for adding a new book
    public static void Register(String id, String author, String title, int edition, int isdn, int quantity, int year, String subject){
        try{
            c = config.getConnection();

            stmt = c.createStatement();
            String sql = "INSERT INTO Books (bookId, bookAuthor, bookEdition, bookIsdn, bookTitle, quantity, yearPublished, subject)"+
                    "VALUES ('"+id+"','"+author+"', "+edition+", "+isdn+", '"+title+"', "+quantity+", "+year+", '"+subject+"')";
            stmt.executeUpdate(sql);
            stmt.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            config.closeConnection(c);
        }
    }

    // code for getting the quantity of books to be used to test if the book is available for use
    public static int getQuantity(String id){
        int quantity = 0;
        try{
            c = config.getConnection();

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Books where bookId='"+id+"';");
            quantity = rs.getInt("quantity");

            stmt.close();

        }catch (Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}
        finally {
            config.closeConnection(c);
        }
        return quantity;
    }

    // code for getting the title of a book
    public static String getTitle(String id){
        String title = null;
        try{
            c = config.getConnection();

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Books where bookId='"+id+"';");
            title = rs.getString("bookTitle");

            stmt.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            config.closeConnection(c);
        }
        return title;
    }

}
