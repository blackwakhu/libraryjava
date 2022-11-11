/****************************************************************
 +--------------------------------------------------------------+
 | author derrick shibero wakhu                                 |
 +--------------------------------------------------------------+
 ****************************************************************/

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NewBorrow {
    private static Connection c = null;
    private static Statement stmt = null;
    public static void Register(String bookid, String borrowerid, int day, int month, int year){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lib.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully\ttable member registration");

            stmt = c.createStatement();
            String sql = "INSERT INTO Borrows (BookId, BorrowerId, Day_Borrowed, Month_Borrowed, Year_Borrowed, Returned)"+
                    "VALUES ("+bookid+","+borrowerid+","+day+","+month+","+year+", 0)";
            stmt.executeUpdate(sql);

            int quantity = NewBook.getQuantity(bookid) - 1;

            sql = "UPDATE Books set quantity = "+quantity+" WHERE bookId = "+bookid+";";
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
}
