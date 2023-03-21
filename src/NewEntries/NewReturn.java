package NewEntries;/*
* this class is used to deal with issues related to returning a book to the library
* it connects the system to the table in the database responsible for the returns
*/

import NewEntries.NewBook;
import database.Config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class NewReturn {
    private static Connection c = null;
    private static Statement stmt = null;
    private static Config config = new Config();

    // this method shows how the data is entered in the database
    public static void Register(int borrowId, String bookId, String returnerId, int day, int month, int year){
        try{
            c = config.getConnection();

            stmt = c.createStatement();
            String sql = "UPDATE Borrows set Returned = 1, Day_Returned="+day+", Month_Returned="+month+", Year_Returned="+year+" where BorrowId="+borrowId+";";
            stmt.executeUpdate(sql);

            // when a book is returned its quantity is increased
            int quantity = NewBook.getQuantity(bookId) + 1;
            sql = "UPDATE Books set quantity = "+quantity+" WHERE bookId = "+bookId+";";
            stmt.executeUpdate(sql);

            stmt.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            config.closeConnection(c);
        }
    }
}