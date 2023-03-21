/*
 * password for admin = admin
 * the user is required to enter their id and password inorder to access the system
 * this is the main class of the project.
 * it contains the code for the GUI and also some codes for the workings of swing elements like the buttons
 * the GUI utilizes the use of layouts like the gridbag, border and card layout
 * card is used mostly with the panels and each other and the panels and the frame
 * the GUI has one frame and several panels
 * the border layout has been used in the menu panel
 * the gridbag has been used extensively in the other borders
 */

import Member.Member;
import Miscallenous.Miscallenous;
import Miscallenous.Search;
import NewEntries.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static  final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final JFrame frame = new JFrame("Library Management System");
    private static final CardLayout card1 = new CardLayout();
    private static final JPanel projectPanel = new JPanel();
    private static JTable table1;
    private static JScrollPane sp1;
    private static boolean member_state = false;
    private static final JPanel menuPanel = new JPanel();
    private static final JPanel mainPanel = new JPanel();
    private static final JPanel loginPanel = new JPanel();
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
    private static final JLabel newBookSubjectLabel = new JLabel("enter the subject");
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
    private static final JTextField newBookSubjectEntry = new JTextField(10);
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
    private static final JTextField newMemberEmailEntry = new JTextField(10);
    private static final JTextField newMemberPhoneNumberEntry = new JTextField(10);
    private static final JTextField newMemberAddressEntry = new JTextField(10);
    private static final JTextField newMemberCountyEntry = new JTextField(10);
    private static final JPanel BookReportPanel = new JPanel();
    private static final JButton MemberBorrowReportButton = new JButton("Member Report");
    private static final JButton BookReportButton = new JButton("Book Report");
    private static final JButton BorrowReportButton = new JButton("Borrow Report");
    private static final JButton ReserveReportButton = new JButton("Reserve Report");
    private static final JButton SearchButton  = new JButton("Search");

    private static final JPanel BorrowReportPanel = new JPanel();
    private static final JPanel SearchPanel = new JPanel();
    private static final JPanel ReserveReportPanel = new JPanel();
    private static final JTextField searchEntry = new JTextField(10);
    private static final JButton searchButton = new JButton("submit");
    private static final String[] searchChoices = {"all", "title", "author", "subject"};
    private static final JComboBox searchComboBox = new JComboBox(searchChoices);

    private static boolean isMember = true;

    private static Member member = new Member();
    private static Search mySearch = new Search();
    public Main(){
        mainPanel.setLayout(card);
        JPanel firstPage = new JPanel();
        JLabel Title = new JLabel("welcome to the library system");
        firstPage.add(Title);


        // this is the code for the graphical user interface used when registering a new member i.e. the newMember panel
        newMemberPanel.setLayout(new GridBagLayout());
        newMemberPanel.setBackground(Color.blue);
        libMemberButton.setBackground(Color.green);
        libMemberButton.setBorderPainted(false);
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
        gridbag1.gridx = 0; gridbag1.gridy = 6;
        newMemberPanel.add(new JLabel("enter the email address"), gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 7;
        newMemberPanel.add(new JLabel("enter the phone number"), gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 8;
        newMemberPanel.add(new JLabel("enter the physical address"), gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 9;
        newMemberPanel.add(new JLabel("enter the county of origin"), gridbag1);
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
        gridbag1.gridx = 1; gridbag1.gridy = 6;
        newMemberPanel.add(newMemberEmailEntry, gridbag1);
        gridbag1.gridx = 1; gridbag1.gridy = 7;
        newMemberPanel.add(newMemberPhoneNumberEntry, gridbag1);
        gridbag1.gridx = 1; gridbag1.gridy = 8;
        newMemberPanel.add(newMemberAddressEntry, gridbag1);
        gridbag1.gridx = 1; gridbag1.gridy = 9;
        newMemberPanel.add(newMemberCountyEntry, gridbag1);
        gridbag1.gridx = 0; gridbag1.gridy = 10;
        newMemberPanel.add(newMemberButton, gridbag1);


        // admin interface for adding a new book i.e. the newBook panel
        newBookPanel.setLayout(new GridBagLayout());
        newBookPanel.setBackground(Color.blue);
        libBooksButton.setBackground(Color.green);
        libBooksButton.setBorderPainted(false);
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
        newBookPanel.add(newBookSubjectLabel, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 7;
        newBookPanel.add(newBookQuantityLabel, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 8;
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
        newBookPanel.add(newBookSubjectEntry, gridbag2);
        gridbag2.gridx = 1; gridbag2.gridy = 7;
        newBookPanel.add(newBookQuantityEntry, gridbag2);
        gridbag2.gridx = 1; gridbag2.gridy = 8;
        newBookPanel.add(newBookYearEntry, gridbag2);
        gridbag2.gridx = 0; gridbag2.gridy = 9;
        newBookPanel.add(newBookButton, gridbag2);


        // user interface for borrowing a book i.e. the newBorrows panel
        newBorrowsPanel.setLayout(new GridBagLayout());
        newBorrowsPanel.setBackground(Color.blue);
        libBorrowButton.setBackground(Color.green);
        libBorrowButton.setBorderPainted(false);
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


        // user interface for reserving a book i.e. the newReserves panel
        newReservesPanel.setLayout(new GridBagLayout());
        newReservesPanel.setBackground(Color.blue);
        libReserveButton.setBackground(Color.green);
        libReserveButton.setBorderPainted(false);
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


        // user interface for returning a book i.e. the newReturn panel
        newReturnPanel.setLayout(new GridBagLayout());
        newReturnPanel.setBackground(Color.blue);
        libReturnButton.setBackground(Color.green);
        libReturnButton.setBorderPainted(false);
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

        // this is the graphical user interface consisting of a table showing all the users in the library i.e. the
        // newBorrowReport panel
        String[][] members = new String[100000][9];
        String[] columns1 = {"id", "first name", "last name", "gender", "password", "email", "phone number", "address", "county"};
        table1 = new JTable(members, columns1);
        sp1 = new JScrollPane(table1);
        MemberBorrowReportPanel.setLayout(new BorderLayout());
        MemberBorrowReportPanel.add(new JLabel("Member.Member Report"), BorderLayout.NORTH);
        MemberBorrowReportPanel.add(sp1, BorderLayout.CENTER);
        MemberBorrowReportButton.setBackground(Color.green);
        MemberBorrowReportButton.setBorderPainted(false);
        MemberBorrowReportPanel.setBackground(Color.blue);


        // user interface showing all the data on the books and their attributes in the library in tabular format i.e.
        // the bookReport panel
        String[][] books = new String[100000][8];
        String[] columns2 = {"Id", "Author", "Edition", "ISDN", "Title", "subject", "quantity", "year Published"};
        JTable table2 = new JTable(books, columns2);
        JScrollPane sp2 = new JScrollPane(table2);
        BookReportPanel.setLayout(new BorderLayout());
        BookReportPanel.add(new JLabel("Book Report"), BorderLayout.NORTH);
        BookReportPanel.add(sp2, BorderLayout.CENTER);
        BookReportPanel.setBackground(Color.blue);
        BookReportButton.setBackground(Color.green);
        BookReportButton.setBorderPainted(false);


        // user interface showing all the data on the members and the books they borrowed in tabular format i.e. the
        // borrowReport panel
        String[][] borrow = new String[100000][5];
        String[] columns3 = {"borrow id","borrower id", "first name", "book title", "returned"};
        JTable table3 = new JTable(borrow, columns3);
        JScrollPane sp3 = new JScrollPane(table3);
        BorrowReportPanel.setLayout(new BorderLayout());
        BorrowReportPanel.add(new JLabel("Borrow Report"), BorderLayout.NORTH);
        BorrowReportPanel.add(sp3, BorderLayout.CENTER);
        BorrowReportButton.setBackground(Color.green);
        BorrowReportButton.setBorderPainted(false);
        BorrowReportPanel.setBackground(Color.blue);


        // user interface showing all the data on the members and the books they reserved in tabular format i.e. the
        // reserveReport panel
        String[][] reserves = new String[100000][5];
        String[] columns5 = {"reserve id","reserver id", "first name", "book title"};
        JTable table5 = new JTable(reserves, columns5);
        JScrollPane sp5 = new JScrollPane(table5);
        ReserveReportPanel.setLayout(new BorderLayout());
        ReserveReportPanel.add(new JLabel("Reserve Report"), BorderLayout.NORTH);
        ReserveReportPanel.add(sp5, BorderLayout.CENTER);
        ReserveReportPanel.setBackground(Color.blue);
        ReserveReportButton.setBackground(Color.green);
        ReserveReportButton.setBorderPainted(false);


        // these are the menus in the system being shown in the menu panel
        JButton loginPageButton = new JButton("login");
        JButton homePageButton = new JButton("Home");
        SearchPanel.setBackground(Color.blue);
        SearchButton.setBackground(Color.green);
        SearchButton.setBorderPainted(false);
        SearchPanel.setLayout(new BorderLayout());

        JPanel searchPanel1 = new JPanel();
        searchPanel1.setLayout(new FlowLayout());
        searchPanel1.add(new JLabel("enter the word to be searched"));
        searchPanel1.setBackground(Color.green);
        searchPanel1.add(searchEntry);
        searchPanel1.add(searchComboBox);
        searchPanel1.add(searchButton);

        String[][] searchResults = new String[10000][4];
        String[] searchColumns = {"id", "title", "author", "subject"};
        JTable searchTable = new JTable(searchResults, searchColumns);
        JScrollPane searchPane = new JScrollPane(searchTable);

        SearchPanel.add(searchPanel1, BorderLayout.NORTH);
        SearchPanel.add(searchPane, BorderLayout.CENTER);

        homePageButton.setBorderPainted(false);
        homePageButton.setBackground(Color.green);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.add(homePageButton);
        menuPanel.add(libMemberButton);
        menuPanel.add(libBooksButton);
        menuPanel.add(libBorrowButton);
        menuPanel.add(libReserveButton);
        menuPanel.add(libReturnButton);
        menuPanel.add(MemberBorrowReportButton);
        menuPanel.add(BookReportButton);
        menuPanel.add(BorrowReportButton);
        menuPanel.add(ReserveReportButton);
        menuPanel.add(SearchButton);
        menuPanel.add(loginPageButton);
        menuPanel.setBackground(Color.green);


        // these are the panels of the different displays used by the system
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
        mainPanel.add(SearchPanel, "11");


        // these are the buttons used to control the panels displayed

        // takes the user to the home page
        homePageButton.addActionListener(e -> card.show(mainPanel, "0"));

        // takes the user to the search page
        SearchButton.addActionListener(e -> card.show(mainPanel, "11"));

        // takes to the new members registration panel
        libMemberButton.addActionListener(e -> {
            member_state = false;
            newMemberPanel.setBackground(Color.blue);
            card.show(mainPanel, "1");
        });

        searchButton.addActionListener(e -> {
            String selectedChoice = searchChoices[searchComboBox.getSelectedIndex()];
            String choiceToSearch = searchEntry.getText();
            Miscallenous.getEmptyArray(searchResults, 3);
            switch (selectedChoice){
                case "all":
                    mySearch.getAllBooks(searchResults);
                    break;
                case "title":
                    mySearch.getSpecialSearches(searchResults, "bookTitle", choiceToSearch);
                    break;
                case "author":
                    mySearch.getSpecialSearches(searchResults, "bookAuthor", choiceToSearch);
                    break;
                case "subject":
                    mySearch.getSpecialSearches(searchResults, "subject", choiceToSearch);
                    break;
            }
            SearchPanel.add(searchPane, BorderLayout.CENTER);
        });

        // takes to the new book addition panel
        libBooksButton.addActionListener(e -> card.show(mainPanel, "2"));

        // takes to the reserve panel
        libBorrowButton.addActionListener(e -> {
            card.show(mainPanel, "4");
            if(isMember) {
                newBorrowsBorrowerIdEntry.setVisible(false);
                newBorrowsBorrowerIdLabel.setVisible(false);
            }
            else {
                newBorrowsBorrowerIdEntry.setVisible(true);
                newBorrowsBorrowerIdLabel.setVisible(true);
            }
        });

        // takes to the borrow panel
        libReserveButton.addActionListener(e -> {
            card.show(mainPanel, "3");
            if(isMember) {
                newReserveBorrowerIdEntry.setVisible(false);
                newReservesReserveLabel.setVisible(false);
            }
            else {
                newReserveBorrowerIdEntry.setVisible(true);
                newReservesReserveLabel.setVisible(true);
            }
        });

        // takes to the return panel
        libReturnButton.addActionListener(e -> {
            card.show(mainPanel, "5");
            if(isMember) {
                newReturnBorrowerIdEntry.setVisible(false);
                newReturnReserveLabel.setVisible(false);
            }
            else {
                newReturnBorrowerIdEntry.setVisible(true);
                newReturnReserveLabel.setVisible(true);
            }
        });

        // takes to the book report panel
        BookReportButton.addActionListener(e -> {
            card.show(mainPanel, "7");
            mySearch.getBookReports(books);
        });

        // takes to the member report panel
        MemberBorrowReportButton.addActionListener(e ->{
            card.show(mainPanel,"6");
            mySearch.getMemberReports(members);
        });

        // takes to the borrow report panel
        BorrowReportButton.addActionListener(e -> {
            card.show(mainPanel, "8");
            mySearch.getBorrowReports(borrow);
        });

        // takes to the reserve report panel
        ReserveReportButton.addActionListener(e -> {
            card.show(mainPanel, "10");
            mySearch.getReservesReport(reserves);
        });

        // takes to the new member panel
        newMemberButton.addActionListener(e -> {
            try {
                String Gender = null;
                String fname = newMemberFNameEntry.getText();
                String lname = newMemberLNameEntry.getText();
                String id = newMemberIdEntry.getText();
                String email = newMemberEmailEntry.getText();
                String password = String.valueOf(newMemberPasswordEntry.getPassword());
                String phoneNumber = newMemberPhoneNumberEntry.getText();
                String address = newMemberAddressEntry.getText();
                String county = newMemberCountyEntry.getText();
                if (newMemberMaleEntry.isSelected()) Gender = "Male";
                if (newMemberFemaleEntry.isSelected()) Gender = "Female";
                newMemberFNameEntry.setText("");
                newMemberLNameEntry.setText("");
                newMemberIdEntry.setText("");
                newMemberPasswordEntry.setText("");
                newMemberEmailEntry.setText("");
                newMemberPhoneNumberEntry.setText("");
                newMemberAddressEntry.setText("");
                newMemberCountyEntry.setText("");
                NewMember.Register(id, fname, lname, Gender, password, email, phoneNumber, address, county);
                JOptionPane.showMessageDialog(frame, "saved the records successfully");
                if (member_state) card1.show(projectPanel, "0");
                else card.show(mainPanel, "0");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });

        // takes to the new book panel
        newBookButton.addActionListener(e ->{
            try {
                String author = newBookAuthorEntry.getText();
                newBookAuthorEntry.setText("");
                String title = newBookTitleEntry.getText();
                newBookTitleEntry.setText("");
                int edition = Integer.parseInt(newBookEditionEntry.getText());
                newBookEditionEntry.setText("");
                int isdn = Integer.parseInt(newBookISDNEntry.getText());
                newBookISDNEntry.setText("");
                String id = newBookIdEntry.getText();
                newBookIdEntry.setText("");
                String subject = newBookSubjectEntry.getText();
                newBookSubjectEntry.setText("");
                int year = Integer.parseInt(newBookYearEntry.getValue().toString());
                int quantity = Integer.parseInt(newBookQuantityEntry.getValue().toString());
                NewBook.Register(id, author, title, edition, isdn, quantity, year, subject);

                JOptionPane.showMessageDialog(frame, "successfully added");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });

        // takes the user to the borrow panel
        newBorrowsButton.addActionListener(e ->{
            try{
                String bookid = newBorrowsBookIdEntry.getText();
                String borrowerid;
                if (isMember) borrowerid = member.getId();
                else borrowerid = newBorrowsBorrowerIdEntry.getText();
                int day = Integer.parseInt(newBorrowsDayEntry.getValue().toString());
                int year = Integer.parseInt(newBorrowsYearEntry.getValue().toString());
                int month = newBorrowsMonthEntry.getSelectedIndex() + 1;
                NewBorrow.Register(bookid, borrowerid, day, month, year);
                JOptionPane.showMessageDialog(frame, "successfully added");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });

        // takes the user to the reserve panel
        newReserveButton.addActionListener(e -> {
            try {
                String reserverid;
                int bookid = Integer.parseInt(newReserveBookIdEntry.getText());
                if (isMember) reserverid = member.getId();
                else reserverid = newReserveBorrowerIdEntry.getText();
                int day = Integer.parseInt(newReserveDayEntry.getValue().toString());
                int year = Integer.parseInt(newReserveYearEntry.getValue().toString());
                int month = newReserveMonthEntry.getSelectedIndex() + 1;
                NewReserve.Register(bookid, reserverid, day, month, year);
                JOptionPane.showMessageDialog(frame, "successfully added");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });

        // takes the user to the return panel
        newReturnButton.addActionListener(e -> {
            try {
                String bookid = newReturnBookIdEntry.getText();
                String reserverid;
                if (isMember) reserverid = member.getId();
                else reserverid= newReturnBorrowerIdEntry.getText();
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


        // this is the login panel where the user enters the password and id inorder to access it
        loginPanel.setBackground(Color.pink);
        loginPanel.setLayout(new BorderLayout());
        loginPanel.add(new JLabel("Welcome to the Library System"), BorderLayout.NORTH);
        JPanel logsPanel = new JPanel();
        logsPanel.setBackground(Color.pink);
        loginPanel.add(logsPanel, BorderLayout.CENTER);

        JTextField UserID = new JTextField(10);
        JPasswordField UserPassword = new JPasswordField(10);
        JButton userSubmit = new JButton("User");
        JButton adminSubmit = new JButton("Admin");
        JButton newUser = new JButton("new user");

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
        logsPanel.add(newUser, bagConstraints);

        MainWorkPanel.setLayout(new BorderLayout());
        MainWorkPanel.add(menuPanel, BorderLayout.WEST);
        MainWorkPanel.add(mainPanel, BorderLayout.CENTER);

        projectPanel.setLayout(card1);
        projectPanel.add(loginPanel, "0");
        projectPanel.add(MainWorkPanel, "1");


        // button that contains the instructions of an admin to enter inorder to be admitted to the system
        adminSubmit.addActionListener(e -> {
            String user = "admin";
            String password = "admin";
            String userInput = UserID.getText();
            UserID.setText("");
            isMember = false;
            String passwordInput = String.valueOf(UserPassword.getPassword());
            UserPassword.setText("");
            if (userInput.equals(user) && passwordInput.equals(password)) {
                JOptionPane.showMessageDialog(frame, "welcome");
                card1.show(projectPanel, "1");
                card.show(mainPanel, "0");
                homePageButton.setVisible(true);
                SearchButton.setVisible(true);
                libMemberButton.setVisible(true);
                libBooksButton.setVisible(true);
                libReturnButton.setVisible(true);
                libReserveButton.setVisible(true);
                libBorrowButton.setVisible(true);
                MemberBorrowReportButton.setVisible(true);
                BookReportButton.setVisible(true);
                BorrowReportButton.setVisible(true);
                ReserveReportButton.setVisible(true);
            }else JOptionPane.showMessageDialog(frame, "entered a wrong password or id");

        });

        // button that contains the instructions of a user to enter inorder to be admitted to the system
        userSubmit.addActionListener(e -> {
            String userInput = UserID.getText();
            String password = NewMember.getPassword(userInput);
            UserID.setText("");
            String passwordInput = String.valueOf(UserPassword.getPassword());
            UserPassword.setText("");
            if (passwordInput.equals(password)) {
                JOptionPane.showMessageDialog(frame, "welcome");
                card1.show(projectPanel, "1");
                card.show(mainPanel, "0");
                homePageButton.setVisible(true);
                SearchButton.setVisible(true);
                libMemberButton.setVisible(false);
                libBooksButton.setVisible(false);
                libReturnButton.setVisible(true);
                libReserveButton.setVisible(true);
                libBorrowButton.setVisible(true);
                MemberBorrowReportButton.setVisible(false);
                BookReportButton.setVisible(false);
                BorrowReportButton.setVisible(false);
                ReserveReportButton.setVisible(false);
                mySearch.setMember(userInput);
            }else JOptionPane.showMessageDialog(frame, "entered a wrong password or id");
        });


        // returns the user to the login page
        loginPageButton.addActionListener(e -> card1.show(projectPanel, "0"));


        // takes user to the new member panel for a user to enter their details
        newUser.addActionListener(e -> {
            card1.show(projectPanel, "1");
            card.show(mainPanel, "1");
            member_state = true;
            newMemberPanel.setBackground(Color.pink);
            homePageButton.setVisible(false);
            SearchButton.setVisible(false);
            libMemberButton.setVisible(false);
            libBooksButton.setVisible(false);
            libReturnButton.setVisible(false);
            libReserveButton.setVisible(false);
            libBorrowButton.setVisible(false);
            MemberBorrowReportButton.setVisible(false);
            BookReportButton.setVisible(false);
            BorrowReportButton.setVisible(false);
            ReserveReportButton.setVisible(false);
        });


        // add the panel to the frame
        frame.add(projectPanel);
        frame.setVisible(true);
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        // this method instantiates the class
        new Main();
    }
}
