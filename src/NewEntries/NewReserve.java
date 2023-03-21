package NewEntries;/*
 * this class is used to deal with issues related to reserving a book to the library
 * it connects the system to the table in the database responsible for the reserves
 */


import database.Config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class NewReserve {
    private static Connection c = null;
    private static Statement stmt = null;
    private static Config config = new Config();

    // deals with issues related to reserving a book
    public static void Register(int bookId, String reserveId, int day, int month, int year){
        try{
            c = config.getConnection();

            stmt = c.createStatement();
            String sql = "INSERT INTO Reserves (BookId, ReseverId, Day, Month, Year)"+
                    "VALUES ("+bookId+","+reserveId+","+day+","+month+","+year+")";
            stmt.executeUpdate(sql);
            stmt.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            config.closeConnection(c);
        }
    }
}