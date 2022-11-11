/****************************************************************
 +--------------------------------------------------------------+
 | author derrick shibero wakhu                                 |
 +--------------------------------------------------------------+
 ****************************************************************/

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    private static  final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final JFrame frame = new JFrame("Library Management System");
    private static final CardLayout card1 = new CardLayout();
    private static final JPanel projectPanel = new JPanel();
    private static JTable table1;
    private static JScrollPane sp1;
    private static final JPanel menuPanel = new JPanel();
    private static final JPanel mainPanel = new JPanel();
    private static final JPanel logginPanel = new JPanel();
    private static final JPanel MainWorkPanel = new JPanel();
    private static final CardLayout card = new CardLayout();
    private static final JPanel newMemberPanel = new JPanel();
    private static final JLabel newMemberIDLabel = new JLabel("enter your id");
    private static final JLabel newMemberFNameLabel = new JLabel("enter your first name");
    private static final JLabel newMemberLNameLabel = new JLabel("enter your last name");
    private static final JLabel newMemberGenderLabel = new JLabel("enter your gender");
    private static final JLabel newMemberPasswordLabel = new JLabel("enter your desired password");
    private static final JPasswordField newMemberPasswordEntry = new JPasswordField(10);
    private static final JTextField newMemberIdEntry = new JTextField(10);
    private static final JTextField newMemberFNameEntry = new JTextField(10);
    private static final JTextField newMemberLNameEntry = new JTextField(10);
    private static final JCheckBox newMemberMaleEntry = new JCheckBox("male");
    private static final JCheckBox newMemberFemaleEntry = new JCheckBox("female");
    private static final JButton libMemberButton = new JButton("Member");
    private static final JButton libBooksButton = new JButton("Books");
    private static final JButton libBorrowButton = new JButton("Borrow");
    private static final JButton libReserveButton = new JButton("Reserve");
    private static final JButton libReturnButton = new JButton("Return");
    private static final JPanel newBookPanel = new JPanel();
    private static final GridBagConstraints gridbag1 = new GridBagConstraints();
    private static final GridBagConstraints gridbag2 = new GridBagConstraints();
    private static final JLabel newBookIdLabel = new JLabel("enter the id");
    private static final JLabel newBookAuthorLabel = new JLabel("enter the author");
    private static final JLabel newBookEditionLabel = new JLabel("enter the edition");
    private static final JLabel newBookISDNLabel = new JLabel("enter the ISDN");
    private static final JLabel newBookTitleLabel = new JLabel("enter the title");
    private static final JLabel newBookQuantityLabel = new JLabel("enter the quantity");
    private static final JLabel newBookYearLabel = new JLabel("enter the year");
    private static final JTextField newBookIdEntry = new JTextField(10);
    private static final JTextField newBookAuthorEntry = new JTextField(10);
    private static final JTextField newBookEditionEntry = new JTextField(10);
    private static final JTextField newBookISDNEntry = new JTextField(10);
    private static final JTextField newBookTitleEntry = new JTextField(10);
    private static final JSpinner newBookQuantityEntry = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private static final JSpinner newBookYearEntry = new JSpinner(new SpinnerNumberModel(2000, 1700, 2100, 1));
    private static final JPanel newBorrowsPanel = new JPanel();
    private static final GridBagConstraints gridbag3 = new GridBagConstraints();
    private static final JLabel newBorrowsBookIdLabel = new JLabel("enter the book");
    private static final JLabel newBorrowsBorrowerIdLabel = new JLabel("enter the your id");
    private static final JLabel newBorrowsDayLabel = new JLabel("day");
    private static final JLabel newBorrowsMonthLabel = new JLabel("month");
    private static final JLabel newBorrowsYearLabel = new JLabel("year");
    private static final JPanel newReservesPanel = new JPanel();
    private static final GridBagConstraints gridbag4 = new GridBagConstraints();
    private static final JLabel newReservesBookIdLabel = new JLabel("enter the book");
    private static final JLabel newReservesReserveLabel = new JLabel("enter your id");
    private static final JLabel newReservesDayLabel = new JLabel("day");
    private static final JLabel newReservesMonthLabel = new JLabel("month");
    private static final JLabel newReservesYearLabel = new JLabel("year");
    private static final JPanel newReturnPanel = new JPanel();
    private static final GridBagConstraints gridbag5 = new GridBagConstraints();
    private static final JLabel newReturnBookIdLabel = new JLabel("enter the book");
    private static final JLabel newReturnReserveLabel = new JLabel("enter your id");
    private static final JLabel newReturnDayLabel = new JLabel("day");
    private static final JLabel newReturnMonthLabel = new JLabel("month");
    private static final JLabel newReturnYearLabel = new JLabel("year");
    private static final JButton newMemberButton = new JButton("submit");
    private static final JButton newBookButton = new JButton("submit");
    private static final JButton newBorrowsButton = new JButton("submit");
    private static final JTextField newBorrowsBookIdEntry = new JTextField(10);
    private static final JTextField newBorrowsBorrowerIdEntry = new JTextField(10);
    private static final JSpinner newBorrowsDayEntry = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
    private static final JComboBox newBorrowsMonthEntry = new JComboBox(months);
    private static final JSpinner newBorrowsYearEntry = new JSpinner(new SpinnerNumberModel(2000, 2000, 2100, 1));
    private static final JButton newReturnButton = new JButton("submit");
    private static final JTextField newReturnBookIdEntry = new JTextField(10);
    private static final JTextField newReturnBorrowerIdEntry = new JTextField(10);
    private static final JSpinner newReturnDayEntry = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
    private static final JComboBox newReturnMonthEntry = new JComboBox(months);
    private static final JSpinner newReturnYearEntry = new JSpinner(new SpinnerNumberModel(2000, 2000, 2100, 1));
    private static final JButton newReserveButton = new JButton("submit");
    private static final JTextField newReserveBookIdEntry = new JTextField(10);
    private static final JTextField newReserveBorrowerIdEntry = new JTextField(10);
    private static final JSpinner newReserveDayEntry = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
    private static final JComboBox newReserveMonthEntry = new JComboBox(months);
    private static final JSpinner newReserveYearEntry = new JSpinner(new SpinnerNumberModel(2000, 2000, 2100, 1));
    private static final JPanel MemberBorrowReportPanel = new JPanel();
    private static final JLabel newReturnIdLabel = new JLabel("enter the borrow ID");
    private static final JTextField newReturnIdEntry = new JTextField(10);
    private static final JPanel BookReportPanel = new JPanel();
    private static final JButton MemberBorrowReportButton = new JButton("Member Report");
    private static final JButton BookReportButton = new JButton("Book Report");
    private static final JButton BorrowReportButton = new JButton("Borrow Report");
    private static final JButton ReserveReportButton = new JButton("Reserve Report");

    private static final JPanel BorrowReportPanel = new JPanel();
    private static final JPanel ReserveReportPanel = new JPanel();

    private static Connection conn = null;
    private static Statement stmt = null;
    public Main(){
        mainPanel.setLayout(card);
        JPanel firstPage = new JPanel();
        JLabel Title = new JLabel("welcome to the library system");
        firstPage.add(Title);

        newMemberPanel.setLayout(new GridBagLayout());
        newMemberPanel.setBackground(Color.yellow);
        libMemberButton.setBackground(Color.yellow);
        gridbag1.gridx = 0; gridbag1.gridy = 0;
        newMemberPanel.add(new JLabel("new Member"), gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 1;
        newMemberPanel.add(newMemberIDLabel, gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 2;
        newMemberPanel.add(newMemberFNameLabel, gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 3;
        newMemberPanel.add(newMemberLNameLabel, gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 4;
        newMemberPanel.add(newMemberGenderLabel, gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 5;
        newMemberPanel.add(newMemberPasswordLabel, gridbag1);
        gridbag1.gridx = 1; gridbag1.gridy = 1;
        newMemberPanel.add(newMemberIdEntry, gridbag1);
        gridbag1.gridx = 1; gridbag1.gridy = 2;
        newMemberPanel.add(newMemberFNameEntry, gridbag1);
        gridbag1.gridx = 1; gridbag1.gridy = 3;
        newMemberPanel.add(newMemberLNameEntry, gridbag1);
        gridbag1.gridx = 1; gridbag1.gridy = 4;
        newMemberPanel.add(newMemberMaleEntry, gridbag1);
        gridbag1.gridx = 2; gridbag1.gridy = 4;
        newMemberPanel.add(newMemberFemaleEntry, gridbag1);
        gridbag1.gridx = 1; gridbag1.gridy = 5;
        newMemberPanel.add(newMemberPasswordEntry, gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 6;
        newMemberPanel.add(newMemberButton, gridbag1);

        newBookPanel.setLayout(new GridBagLayout());
        newBookPanel.setBackground(Color.CYAN);
        libBooksButton.setBackground(Color.CYAN);
        gridbag2.gridx = 0; gridbag2.gridy = 0;
        newBookPanel.add(new JLabel("new Book"), gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 1;
        newBookPanel.add(newBookIdLabel, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 2;
        newBookPanel.add(newBookAuthorLabel, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 3;
        newBookPanel.add(newBookEditionLabel, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 4;
        newBookPanel.add(newBookISDNLabel, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 5;
        newBookPanel.add(newBookTitleLabel, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 6;
        newBookPanel.add(newBookQuantityLabel, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 7;
        newBookPanel.add(newBookYearLabel, gridbag2);
        gridbag2.gridx = 1; gridbag2.gridy = 1;
        newBookPanel.add(newBookIdEntry, gridbag2);
        gridbag2.gridx = 1; gridbag2.gridy = 2;
        newBookPanel.add(newBookAuthorEntry, gridbag2);
        gridbag2.gridx = 1; gridbag2.gridy = 3;
        newBookPanel.add(newBookEditionEntry, gridbag2);
        gridbag2.gridx = 1; gridbag2.gridy = 4;
        newBookPanel.add(newBookISDNEntry, gridbag2);
        gridbag2.gridx = 1; gridbag2.gridy = 5;
        newBookPanel.add(newBookTitleEntry, gridbag2);
        gridbag2.gridx = 1; gridbag2.gridy = 6;
        newBookPanel.add(newBookQuantityEntry, gridbag2);
        gridbag2.gridx = 1; gridbag2.gridy = 7;
        newBookPanel.add(newBookYearEntry, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 8;
        newBookPanel.add(newBookButton, gridbag2);

        newBorrowsPanel.setLayout(new GridBagLayout());
        newBorrowsPanel.setBackground(Color.GREEN);
        libBorrowButton.setBackground(Color.GREEN);
        gridbag3.gridx = 0; gridbag3.gridy = 0;
        newBorrowsPanel.add(new JLabel("Borrow book"), gridbag3);
        gridbag3.gridx = 0; gridbag3.gridy = 1;
        newBorrowsPanel.add(newBorrowsBookIdLabel, gridbag3);
        gridbag3.gridx = 0; gridbag3.gridy = 2;
        newBorrowsPanel.add(newBorrowsBorrowerIdLabel, gridbag3);
        gridbag3.gridx = 0; gridbag3.gridy = 3;
        newBorrowsPanel.add(newBorrowsDayLabel, gridbag3);
        gridbag3.gridx = 1; gridbag3.gridy = 3;
        newBorrowsPanel.add(newBorrowsMonthLabel, gridbag3);
        gridbag3.gridx = 2; gridbag3.gridy = 3;
        newBorrowsPanel.add(newBorrowsYearLabel, gridbag3);
        gridbag3.gridx = 1; gridbag3.gridy = 1;
        newBorrowsPanel.add(newBorrowsBookIdEntry, gridbag3);
        gridbag3.gridx = 1; gridbag3.gridy = 2;
        newBorrowsPanel.add(newBorrowsBorrowerIdEntry, gridbag3);
        gridbag3.gridx = 0; gridbag3.gridy = 4;
        newBorrowsPanel.add(newBorrowsDayEntry, gridbag3);
        gridbag3.gridx = 1; gridbag3.gridy = 4;
        newBorrowsPanel.add(newBorrowsMonthEntry, gridbag3);
        gridbag3.gridx = 2; gridbag3.gridy = 4;
        newBorrowsPanel.add(newBorrowsYearEntry, gridbag3);
        gridbag3.gridx = 0; gridbag3.gridy = 5;
        newBorrowsPanel.add(newBorrowsButton, gridbag3);

        newReservesPanel.setLayout(new GridBagLayout());
        newReservesPanel.setBackground(Color.MAGENTA);
        libReserveButton.setBackground(Color.MAGENTA);
        gridbag4.gridx = 0; gridbag4.gridy = 0;
        newReservesPanel.add(new JLabel("Reserve book"), gridbag4);
        gridbag4.gridx = 0; gridbag4.gridy = 1;
        newReservesPanel.add(newReservesBookIdLabel, gridbag4);
        gridbag4.gridx = 0; gridbag4.gridy = 2;
        newReservesPanel.add(newReservesReserveLabel, gridbag4);
        gridbag4.gridx = 0; gridbag4.gridy = 3;
        newReservesPanel.add(newReservesDayLabel, gridbag4);
        gridbag4.gridx = 1; gridbag4.gridy = 3;
        newReservesPanel.add(newReservesMonthLabel, gridbag4);
        gridbag4.gridx = 2; gridbag4.gridy = 3;
        newReservesPanel.add(newReservesYearLabel, gridbag4);
        gridbag4.gridx = 1; gridbag4.gridy = 1;
        newReservesPanel.add(newReserveBookIdEntry, gridbag4);
        gridbag4.gridx = 1; gridbag4.gridy = 2;
        newReservesPanel.add(newReserveBorrowerIdEntry, gridbag4);
        gridbag4.gridx = 0; gridbag4.gridy = 4;
        newReservesPanel.add(newReserveDayEntry, gridbag4);
        gridbag4.gridx = 1; gridbag4.gridy = 4;
        newReservesPanel.add(newReserveMonthEntry, gridbag4);
        gridbag4.gridx = 2; gridbag4.gridy = 4;
        newReservesPanel.add(newReserveYearEntry, gridbag4);
        gridbag4.gridx = 0; gridbag4.gridy = 5;
        newReservesPanel.add(newReserveButton, gridbag4);

        newReturnPanel.setLayout(new GridBagLayout());
        newReturnPanel.setBackground(Color.ORANGE);
        libReturnButton.setBackground(Color.ORANGE);
        gridbag5.gridx = 0; gridbag5.gridy = 0;
        newReturnPanel.add(new JLabel("Return book"), gridbag5);
        gridbag5.gridx = 0; gridbag5.gridy = 1;
        newReturnPanel.add(newReturnIdLabel, gridbag5);
        gridbag5.gridx = 0; gridbag5.gridy = 2;
        newReturnPanel.add(newReturnBookIdLabel, gridbag5);
        gridbag5.gridx = 0; gridbag5.gridy = 3;
        newReturnPanel.add(newReturnReserveLabel, gridbag5);
        gridbag5.gridx = 0; gridbag5.gridy = 4;
        newReturnPanel.add(newReturnDayLabel, gridbag5);
        gridbag5.gridx = 1; gridbag5.gridy = 4;
        newReturnPanel.add(newReturnMonthLabel, gridbag5);
        gridbag5.gridx = 2; gridbag5.gridy = 4;
        newReturnPanel.add(newReturnYearLabel, gridbag5);
        gridbag5.gridx = 1; gridbag5.gridy = 1;
        newReturnPanel.add(newReturnIdEntry, gridbag5);
        gridbag5.gridx = 1; gridbag5.gridy = 2;
        newReturnPanel.add(newReturnBookIdEntry, gridbag5);
        gridbag5.gridx = 1; gridbag5.gridy = 3;
        newReturnPanel.add(newReturnBorrowerIdEntry, gridbag5);
        gridbag5.gridx = 0; gridbag5.gridy = 5;
        newReturnPanel.add(newReturnDayEntry, gridbag5);
        gridbag5.gridx = 1; gridbag5.gridy = 5;
        newReturnPanel.add(newReturnMonthEntry, gridbag5);
        gridbag5.gridx = 2; gridbag5.gridy = 5;
        newReturnPanel.add(newReturnYearEntry, gridbag5);
        gridbag5.gridx = 0; gridbag5.gridy = 6;
        newReturnPanel.add(newReturnButton, gridbag5);

        String[][] members = new String[100000][4];
        String[] columns1 = {"id", "first name", "last name", "gender"};
        table1 = new JTable(members, columns1);
        sp1 = new JScrollPane(table1);
        MemberBorrowReportPanel.setLayout(new BorderLayout());
        MemberBorrowReportPanel.add(new JLabel("Member Report"), BorderLayout.NORTH);
        MemberBorrowReportPanel.add(sp1, BorderLayout.CENTER);
        MemberBorrowReportButton.setBackground(Color.yellow);
        MemberBorrowReportPanel.setBackground(Color.yellow);

        String[][] books = new String[100000][7];
        String[] columns2 = {"Id", "Author", "Edition", "ISDN", "Title", "quantity", "year Published"};
        JTable table2 = new JTable(books, columns2);
        JScrollPane sp2 = new JScrollPane(table2);
        BookReportPanel.setLayout(new BorderLayout());
        BookReportPanel.add(new JLabel("Book Report"), BorderLayout.NORTH);
        BookReportPanel.add(sp2, BorderLayout.CENTER);
        BookReportPanel.setBackground(Color.CYAN);
        BookReportButton.setBackground(Color.CYAN);

        String[][] borrow = new String[100000][5];
        String[] columns3 = {"borrow id","borrower id", "first name", "book title", "returned"};
        JTable table3 = new JTable(borrow, columns3);
        JScrollPane sp3 = new JScrollPane(table3);
        BorrowReportPanel.setLayout(new BorderLayout());
        BorrowReportPanel.add(new JLabel("Borrow Report"), BorderLayout.NORTH);
        BorrowReportPanel.add(sp3, BorderLayout.CENTER);
        BorrowReportButton.setBackground(Color.GREEN);
        BorrowReportPanel.setBackground(Color.GREEN);

        String[][] reserves = new String[100000][5];
        String[] columns5 = {"reserve id","reserver id", "first name", "book title"};
        JTable table5 = new JTable(reserves, columns5);
        JScrollPane sp5 = new JScrollPane(table5);
        ReserveReportPanel.setLayout(new BorderLayout());
        ReserveReportPanel.add(new JLabel("Reserve Report"), BorderLayout.NORTH);
        ReserveReportPanel.add(sp5, BorderLayout.CENTER);
        ReserveReportPanel.setBackground(Color.MAGENTA);
        ReserveReportButton.setBackground(Color.MAGENTA);

        JButton loginpageButton = new JButton("loggin");
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.add(libMemberButton);
        menuPanel.add(libBooksButton);
        menuPanel.add(libBorrowButton);
        menuPanel.add(libReserveButton);
        menuPanel.add(libReturnButton);
        menuPanel.add(MemberBorrowReportButton);
        menuPanel.add(BookReportButton);
        menuPanel.add(BorrowReportButton);
        menuPanel.add(ReserveReportButton);
        menuPanel.add(loginpageButton);
        menuPanel.setBackground(Color.BLUE);

        mainPanel.add(firstPage, "0");
        mainPanel.add(newMemberPanel, "1");
        mainPanel.add(newBookPanel, "2");
        mainPanel.add(newReservesPanel, "3");
        mainPanel.add(newBorrowsPanel, "4");
        mainPanel.add(newReturnPanel, "5");
        mainPanel.add(MemberBorrowReportPanel, "6");
        mainPanel.add(BookReportPanel, "7");
        mainPanel.add(BorrowReportPanel, "8");
        mainPanel.add(ReserveReportPanel, "10");

        libMemberButton.addActionListener(e -> card.show(mainPanel, "1"));
        libBooksButton.addActionListener(e -> card.show(mainPanel, "2"));
        libBorrowButton.addActionListener(e -> card.show(mainPanel, "4"));
        libReserveButton.addActionListener(e -> card.show(mainPanel, "3"));
        libReturnButton.addActionListener(e -> card.show(mainPanel, "5"));
        BookReportButton.addActionListener(e -> {
            card.show(mainPanel, "7");
            try{
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:lib.db");
                conn.setAutoCommit(false);
                System.out.println("Opened database successfully\ttable member registration");

                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Books");
                int i = 0;
                while(rs.next()){
                    books[i][0] = ""+rs.getInt("bookId");
                    books[i][1] = rs.getString("bookAuthor");
                    books[i][2] = ""+rs.getInt("bookEdition");
                    books[i][3] = ""+rs.getInt("bookIsdn");
                    books[i][4] = rs.getString("bookTitle");
                    books[i][5] = ""+rs.getInt("quantity");
                    books[i][6] = ""+rs.getInt("yearPublished");
                    i = i + 1;
                }
            }catch(Exception ex){JOptionPane.showMessageDialog(frame, ex.getMessage());}
        });
        MemberBorrowReportButton.addActionListener(e ->{
            card.show(mainPanel,"6");
            try{
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:lib.db");
                conn.setAutoCommit(false);
                System.out.println("Opened database successfully\ttable member registration");

                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM LibMember");
                int i = 0;
                while(rs.next()){
                    members[i][0] = rs.getString("idNumber");
                    members[i][1] = rs.getString("FirstName");
                    members[i][2] = rs.getString("LastName");
                    members[i][3] = rs.getString("Gender");
                    i = i + 1;
                }
            }catch(Exception ex){JOptionPane.showMessageDialog(frame, ex.getMessage());}
        });
        BorrowReportButton.addActionListener(e -> {
            card.show(mainPanel, "8");
            try{
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:lib.db");
                conn.setAutoCommit(false);
                System.out.println("Opened database successfully\ttable member registration");

                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Borrows");
                int i = 0;
                while(rs.next()){
                    String borrowId = ""+rs.getInt("BorrowId");
                    String borrowerId = rs.getString("BorrowerId");
                    String bookId = rs.getString("BookId");
                    int returned = rs.getInt("Returned");
                    String fname =  NewMember.getFName(borrowerId);
                    String title = NewBook.getTitle(bookId);
                    borrow[i][0] = borrowId;
                    borrow[i][1] = borrowerId;
                    borrow[i][2] = fname;
                    borrow[i][3] = title;
                    if(returned == 0) borrow[i][4] = "no";
                    else if(returned == 1) borrow[i][4] = "yes";
                    i = i + 1;
                }
            }catch(Exception ex){JOptionPane.showMessageDialog(frame, ex.getMessage());}
        });
        ReserveReportButton.addActionListener(e -> {
            card.show(mainPanel, "10");
            try{
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:lib.db");
                conn.setAutoCommit(false);
                System.out.println("Opened database successfully\ttable member registration");

                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Reserves");
                int i = 0;
                while(rs.next()) {
                    String reserveId = "" + rs.getInt("ReservationId");
                    String reserverId = rs.getString("ReseverId");
                    String bookId = rs.getString("BookId");
                    String fname = NewMember.getFName(reserverId);
                    String title = NewBook.getTitle(bookId);
                    reserves[i][0] = reserveId;
                    reserves[i][1] = reserverId;
                    reserves[i][2] = fname;
                    reserves[i][3] = title;
                    i = i + 1;
                }
            }catch(Exception ex){JOptionPane.showMessageDialog(frame, ex.getMessage());}
        });
        newMemberButton.addActionListener(e -> {
            try {
                String Gender = null;
                String fname = newMemberFNameEntry.getText();
                String lname = newMemberLNameEntry.getText();
                String id = newMemberIdEntry.getText();
                String password = String.valueOf(newMemberPasswordEntry.getPassword());
                if (newMemberMaleEntry.isSelected()) Gender = "Male";
                if (newMemberFemaleEntry.isSelected()) Gender = "Female";
                NewMember.Register(id, fname, lname, Gender, password);
                JOptionPane.showMessageDialog(frame, "saved the records successfully");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });
        newBookButton.addActionListener(e ->{
            try {
                String author = newBookAuthorEntry.getText();
                String title = newBookTitleEntry.getText();
                int edition = Integer.parseInt(newBookEditionEntry.getText());
                int isdn = Integer.parseInt(newBookISDNEntry.getText());
                String id = newBookIdEntry.getText();
                int year = Integer.parseInt(newBookYearEntry.getValue().toString());
                int quantity = Integer.parseInt(newBookQuantityEntry.getValue().toString());
                NewBook.Register(id, author, title, edition, isdn, quantity, year);
                JOptionPane.showMessageDialog(frame, "successfully added");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });
        newBorrowsButton.addActionListener(e ->{
            try{
                String bookid = newBorrowsBookIdEntry.getText();
                String borrowerid = newBorrowsBorrowerIdEntry.getText();
                int day = Integer.parseInt(newBorrowsDayEntry.getValue().toString());
                int year = Integer.parseInt(newBorrowsYearEntry.getValue().toString());
                int month = newBorrowsMonthEntry.getSelectedIndex() + 1;
                NewBorrow.Register(bookid, borrowerid, day, month, year);
                JOptionPane.showMessageDialog(frame, "successfully added");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });
        newReserveButton.addActionListener(e -> {
            try {
                int bookid = Integer.parseInt(newReserveBookIdEntry.getText());
                int reserverid = Integer.parseInt(newReserveBorrowerIdEntry.getText());
                int day = Integer.parseInt(newReserveDayEntry.getValue().toString());
                int year = Integer.parseInt(newReserveYearEntry.getValue().toString());
                int month = newReserveMonthEntry.getSelectedIndex() + 1;
                NewReserve.Register(bookid, reserverid, day, month, year);
                JOptionPane.showMessageDialog(frame, "successfully added");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });
        newReturnButton.addActionListener(e -> {
            try {
                String bookid = newReturnBookIdEntry.getText();
                String reserverid = newReturnBorrowerIdEntry.getText();
                int day = Integer.parseInt(newReturnDayEntry.getValue().toString());
                int year = Integer.parseInt(newReturnYearEntry.getValue().toString());
                int month = newReturnMonthEntry.getSelectedIndex() + 1;
                int id = Integer.parseInt(newReturnIdEntry.getText());
                NewReturn.Register(id, bookid, reserverid, day, month, year);
                JOptionPane.showMessageDialog(frame, "successfully added");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });

        logginPanel.setBackground(Color.pink);
        logginPanel.setLayout(new BorderLayout());
        logginPanel.add(new JLabel("Welcome to the Library System"), BorderLayout.NORTH);
        JPanel logsPanel = new JPanel();
        logsPanel.setBackground(Color.pink);
        logginPanel.add(logsPanel, BorderLayout.CENTER);

        JTextField UserID = new JTextField(10);
        JPasswordField UserPassword = new JPasswordField(10);
        JButton userSubmit = new JButton("User");
        JButton adminSubmit = new JButton("Admin");
        JButton newuser = new JButton("new user");

        logsPanel.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.gridy = 0; bagConstraints.gridx = 0;
        logsPanel.add(new JLabel("Enter your details to log in"), bagConstraints);
        bagConstraints.gridy = 1; bagConstraints.gridx = 1;
        logsPanel.add(new JLabel("id"), bagConstraints);
        bagConstraints.gridy = 2; bagConstraints.gridx = 1;
        logsPanel.add(new JLabel("password"), bagConstraints);
        bagConstraints.gridy = 1; bagConstraints.gridx = 2;
        logsPanel.add(UserID, bagConstraints);
        bagConstraints.gridy = 2; bagConstraints.gridx = 2;
        logsPanel.add(UserPassword, bagConstraints);
        bagConstraints.gridy = 3; bagConstraints.gridx = 1;
        logsPanel.add(userSubmit, bagConstraints);
        bagConstraints.gridy = 3; bagConstraints.gridx = 2;
        logsPanel.add(adminSubmit, bagConstraints);
        bagConstraints.gridy = 3; bagConstraints.gridx = 3;
        logsPanel.add(newuser, bagConstraints);

        MainWorkPanel.setLayout(new BorderLayout());
        MainWorkPanel.add(menuPanel, BorderLayout.WEST);
        MainWorkPanel.add(mainPanel, BorderLayout.CENTER);

        projectPanel.setLayout(card1);
        projectPanel.add(logginPanel, "0");
        projectPanel.add(MainWorkPanel, "1");

        adminSubmit.addActionListener(e -> {
            String user = "admin";
            String password = "admin";
            String userinput = UserID.getText();
            System.out.println(userinput);
            String passwordinput = String.valueOf(UserPassword.getPassword());
            if (userinput.equals(user) && passwordinput.equals(password)) {
                JOptionPane.showMessageDialog(frame, "welcome");
                card1.show(projectPanel, "1");
                libMemberButton.setVisible(true);
                MemberBorrowReportButton.setVisible(true);
                BookReportButton.setVisible(true);
                BorrowReportButton.setVisible(true);
                ReserveReportButton.setVisible(true);
            }else JOptionPane.showMessageDialog(frame, "entered a wrong password or id");

        });
        userSubmit.addActionListener(e -> {
            String userinput = UserID.getText();
            String password = NewMember.getPassword(userinput);
            System.out.println(userinput);
            String passwordinput = String.valueOf(UserPassword.getPassword());
            if (passwordinput.equals(password)) {
                JOptionPane.showMessageDialog(frame, "welcome");
                card1.show(projectPanel, "1");
                libMemberButton.setVisible(false);
                MemberBorrowReportButton.setVisible(false);
                BookReportButton.setVisible(false);
                BorrowReportButton.setVisible(false);
                ReserveReportButton.setVisible(false);
            }else JOptionPane.showMessageDialog(frame, "entered a wrong password or id");
        });

        loginpageButton.addActionListener(e -> card1.show(projectPanel, "0"));

        newuser.addActionListener(e -> {
            card1.show(projectPanel, "1");
            card.show(mainPanel, "1");
            MemberBorrowReportButton.setVisible(false);
            BookReportButton.setVisible(false);
            BorrowReportButton.setVisible(false);
            ReserveReportButton.setVisible(false);
        });

        frame.add(projectPanel);
        frame.setVisible(true);
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new Main();
    }
}
