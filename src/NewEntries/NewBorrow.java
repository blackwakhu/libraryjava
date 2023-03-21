package NewEntries;/*
 * this class is used to deal with issues related to borrowing a book to the library
 * it connects the system to the table in the database responsible for the borrows
 */


import NewEntries.NewBook;
import database.Config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class NewBorrow {
    private static Connection c = null;
    private static Statement stmt = null;
    private static Config myconfig = new Config();

    // deals with borrowing books
    public static void Register(String bookId, String borrowerId, int day, int month, int year){
        try{
            c = myconfig.getConnection();

            stmt = c.createStatement();
            String sql = "INSERT INTO Borrows (BookId, BorrowerId, Day_Borrowed, Month_Borrowed, Year_Borrowed, Returned)"+
                    "VALUES ("+bookId+","+borrowerId+","+day+","+month+","+year+", 0)";
            stmt.executeUpdate(sql);

            // the quantity of books must reduce after every borrow
            int quantity = NewBook.getQuantity(bookId) - 1;

            sql = "UPDATE Books set quantity = "+quantity+" WHERE bookId = "+bookId+";";
            stmt.executeUpdate(sql);
            stmt.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            myconfig.closeConnection(c);
        }
    }
}