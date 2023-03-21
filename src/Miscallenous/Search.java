package Miscallenous;

import Member.Member;
import NewEntries.NewBook;
import NewEntries.NewMember;
import database.Config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search {
    private Config config = new Config();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet rs;
    private NewMember newMember= new NewMember();
    private NewBook newBook = new NewBook();
    private Member member = new Member();
    public void getAllBooks(String[][] myArray){
        try{
            connection = config.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT bookId, bookTitle, bookAuthor, subject FROM Books");
            int i = 0;
            while(rs.next()){
                myArray[i][0] = rs.getString("bookId");
                myArray[i][1] = rs.getString("bookTitle");
                myArray[i][2] = rs.getString("bookAuthor");
                myArray[i][3] = rs.getString("subject");
                i = i + 1;
            }
        }catch(SQLException ex){}
        finally {
            config.closeConnection(connection);
        }
    }
    public void getSpecialSearches(String[][] myArray, String column, String keyword){
        try{
            connection = config.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT bookId, bookTitle, bookAuthor, subject FROM Books where "+column+" like '%"+keyword+"%'");
            int i = 0;
            while(rs.next()){
                myArray[i][0] = rs.getString("bookId");
                myArray[i][1] = rs.getString("bookTitle");
                myArray[i][2] = rs.getString("bookAuthor");
                myArray[i][3] = rs.getString("subject");
                i = i + 1;
            }
        }catch (SQLException ex){}
        finally {
            config.closeConnection(connection);
        }
    }
    public void getBookReports(String[][] myArray){
        try {
            connection = config.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM Books");
            int i = 0;
            while(rs.next()){
                myArray[i][0] = rs.getString("bookId");
                myArray[i][1] = rs.getString("bookAuthor");
                myArray[i][2] = ""+rs.getInt("bookEdition");
                myArray[i][3] = ""+rs.getInt("bookIsdn");
                myArray[i][4] = rs.getString("bookTitle");
                myArray[i][5] = rs.getString("subject");
                myArray[i][6] = ""+rs.getInt("quantity");
                myArray[i][7] = ""+rs.getInt("yearPublished");
                i = i + 1;
            }
        }catch (SQLException ex){}
        finally {
            config.closeConnection(connection);
        }
    }
    public void getMemberReports(String[][] members){
        try{
            connection = config.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM LibMember");
            int i = 0;
            while(rs.next()){
                members[i][0] = rs.getString("idNumber");
                members[i][1] = rs.getString("FirstName");
                members[i][2] = rs.getString("LastName");
                members[i][3] = rs.getString("Gender");
                members[i][4] = rs.getString("Password");
                members[i][5] = rs.getString("Email");
                members[i][6] = rs.getString("Phone_number");
                members[i][7] = rs.getString("Address");
                members[i][8] = rs.getString("County");
                i = i + 1;
            }
        }catch(SQLException ex){}
        finally {
            config.closeConnection(connection);
        }
    }
    public void getBorrowReports(String[][] borrow){
        try{
            connection = config.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM Borrows");
            int i = 0;
            while(rs.next()){
                String borrowId = ""+rs.getInt("BorrowId");
                String borrowerId = rs.getString("BorrowerId");
                String bookId = rs.getString("BookId");
                int returned = rs.getInt("Returned");
                String fname =  newMember.getFName(borrowerId);
                String title = newBook.getTitle(bookId);
                borrow[i][0] = borrowId;
                borrow[i][1] = borrowerId;
                borrow[i][2] = fname;
                borrow[i][3] = title;
                if(returned == 0) borrow[i][4] = "no";
                else if(returned == 1) borrow[i][4] = "yes";
                i = i + 1;
            }
        }catch(SQLException ex){}
        finally {
            config.closeConnection(connection);
        }
    }
    public void getReservesReport(String[][] reserves){
        try{
            connection = config.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM Reserves");
            int i = 0;
            while(rs.next()){
                String reserveId = "" + rs.getInt("ReservationId");
                String reserverId = rs.getString("ReseverId");
                String bookId = rs.getString("BookId");
                String fname = newMember.getFName(reserverId);
                String title = newBook.getTitle(bookId);
                reserves[i][0] = reserveId;
                reserves[i][1] = reserverId;
                reserves[i][2] = fname;
                reserves[i][3] = title;
                i = i + 1;
            }
        }catch(SQLException ex){}
        finally {
            config.closeConnection(connection);
        }
    }
    public void setMember(String userInput){
        try{
            connection = config.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM LibMember where idNumber='"+userInput+"';");
            member.setId(userInput);
            member.setfName(rs.getString("FirstName"));
            member.setlName(rs.getString("LastName"));
            member.setPassword(rs.getString("Password"));
            member.setCounty(rs.getString("County"));
            member.setEmail(rs.getString("Email"));
            member.setPhoneNumber(rs.getString("Phone_number"));
            member.setGender(rs.getString("Gender"));
            member.setAddress(rs.getString("Address"));

            statement.close();

        }catch (SQLException ex){}
        finally {
            config.closeConnection(connection);
        }
    }
}
