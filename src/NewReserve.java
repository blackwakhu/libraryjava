/****************************************************************
 +--------------------------------------------------------------+
 | author derrick shibero wakhu                                 |
 +--------------------------------------------------------------+
 ****************************************************************/

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NewReserve {
    private static Connection c = null;
    private static Statement stmt = null;
    public static void Register(int bookid, int reserverid, int day, int month, int year){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:lib.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully\ttable member registration");

            stmt = c.createStatement();
            String sql = "INSERT INTO Reserves (BookId, ReseverId, Day, Month, Year)"+
                    "VALUES ("+bookid+","+reserverid+","+day+","+month+","+year+")";
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
