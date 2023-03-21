package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    static {
        try{
            Class.forName("org.sqlite.JDBC");
        }catch (ClassNotFoundException ex){}
    }
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:lib.db");
        connection.setAutoCommit(true);
        return connection;
    }
    public void closeConnection(Connection connection){
        if (connection == null) return;
        try{
            connection.close();
        }catch (SQLException ex){}
    }
}
