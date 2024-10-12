// import java.util.Scanner;

// class Book {
//     String title;
//     String author;
//     boolean isIssued;

//     Book(String title, String author) {
//         this.title = title;
//         this.author = author;
//         this.isIssued = false;
//     }

//     void issueBook() {
//         if (!isIssued) {
//             isIssued = true;
//             System.out.println(title + " has been issued.");
//         } else {
//             System.out.println(title + " is already issued.");
//         }
//     }

//     void returnBook() {
//         if (isIssued) {
//             isIssued = false;
//             System.out.println(title + " has been returned.");
//         } else {
//             System.out.println(title + " was not issued.");
//         }
//     }

//     void displayDetails() {
//         System.out.println("Title: " + title);
//         System.out.println("Author: " + author);
//         System.out.println("Availability: " + (isIssued ? "Issued" : "Available"));
//     }
// }

// class Library {
//     Book[] books;
//     int count;

//     Library(int size) {
//         books = new Book[size];
//         count = 0;
//     }

//     void addBook(String title, String author) {
//         if (count < books.length) {
//             books[count] = new Book(title, author);
//             count++;
//             System.out.println("Book added: " + title);
//         } else {
//             System.out.println("Library is full, can't add more books.");
//         }
//     }

//     void issueBook(String title) {
//         for (int i = 0; i < count; i++) {
//             if (books[i].title.equalsIgnoreCase(title)) {
//                 books[i].issueBook();
//                 return;
//             }
//         }
//         System.out.println("Book not found in the library.");
//     }

//     void returnBook(String title) {
//         for (int i = 0; i < count; i++) {
//             if (books[i].title.equalsIgnoreCase(title)) {
//                 books[i].returnBook();
//                 return;
//             }
//         }
//         System.out.println("Book not found in the library.");
//     }

//     void displayBooks() {
//         if (count == 0) {
//             System.out.println("No books in the library.");
//         } else {
//             for (int i = 0; i < count; i++) {
//                 books[i].displayDetails();
//                 System.out.println("---------------------");
//             }
//         }
//     }
// }

// public class LibraryManagementSystem {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter the size of the library: ");
//         int size = scanner.nextInt();
//         scanner.nextLine(); // Consume newline

//         Library library = new Library(size);

//         boolean exit = false;
//         while (!exit) {
//             System.out.println("\nLibrary Menu:");
//             System.out.println("1. Add Book");
//             System.out.println("2. Issue Book");
//             System.out.println("3. Return Book");
//             System.out.println("4. Display All Books");
//             System.out.println("5. Exit");
//             System.out.print("Choose an option: ");
//             int choice = scanner.nextInt();
//             scanner.nextLine(); // Consume newline

//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter book title: ");
//                     String title = scanner.nextLine();
//                     System.out.print("Enter book author: ");
//                     String author = scanner.nextLine();
//                     library.addBook(title, author);
//                     break;
//                 case 2:
//                     System.out.print("Enter book title to issue: ");
//                     String issueTitle = scanner.nextLine();
//                     library.issueBook(issueTitle);
//                     break;
//                 case 3:
//                     System.out.print("Enter book title to return: ");
//                     String returnTitle = scanner.nextLine();
//                     library.returnBook(returnTitle);
//                     break;
//                 case 4:
//                     library.displayBooks();
//                     break;
//                 case 5:
//                     exit = true;
//                     break;
//                 default:
//                     System.out.println("Invalid choice. Try again.");
//             }
//         }

//         scanner.close();
//     }
// }


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Book {
    String title;
    String author;
    boolean isIssued;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void issueBook() {
        if (!isIssued) {
            isIssued = true;
            JOptionPane.showMessageDialog(null, title + " has been issued.");
        } else {
            JOptionPane.showMessageDialog(null, title + " is already issued.");
        }
    }

    void returnBook() {
        if (isIssued) {
            isIssued = false;
            JOptionPane.showMessageDialog(null, title + " has been returned.");
        } else {
            JOptionPane.showMessageDialog(null, title + " was not issued.");
        }
    }

    String getDetails() {
        return "Title: " + title + ", Author: " + author + ", Availability: " + (isIssued ? "Issued" : "Available");
    }
}

class Library {
    Book[] books;
    int count;

    Library(int size) {
        books = new Book[size];
        count = 0;
    }

    void addBook(String title, String author) {
        if (count < books.length) {
            books[count] = new Book(title, author);
            count++;
            JOptionPane.showMessageDialog(null, "Book added: " + title);
        } else {
            JOptionPane.showMessageDialog(null, "Library is full, can't add more books.");
        }
    }

    void issueBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                books[i].issueBook();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found in the library.");
    }

    void returnBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                books[i].returnBook();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found in the library.");
    }

    void displayBooks(JTextArea displayArea) {
        displayArea.setText(""); // Clear the area before displaying
        if (count == 0) {
            displayArea.append("No books in the library.\n");
        } else {
            for (int i = 0; i < count; i++) {
                displayArea.append(books[i].getDetails() + "\n---------------------\n");
            }
        }
    }
}

public class LibraryManagementSystemGUI {
    private Library library;
    private JFrame frame;
    private JTextField titleField, authorField;
    private JTextArea displayArea;

    public LibraryManagementSystemGUI(int size) {
        library = new Library(size);
        initialize();
    }

    private void initialize() {
        // Frame setup
        frame = new JFrame("Library Management System");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        
        // Set a custom background color
        frame.getContentPane().setBackground(new Color(230, 230, 250)); // Light Lavender background
        
        // Title panel with gradient background
        JPanel titlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(70, 130, 180); // SteelBlue
                Color color2 = new Color(240, 128, 128); // LightCoral
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        titlePanel.setPreferredSize(new Dimension(800, 80));
        JLabel titleLabel = new JLabel("Library Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Center panel (for display) with borders and soft color
        displayArea = new JTextArea();
        displayArea.setFont(new Font("Serif", Font.PLAIN, 18));
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 2), "Library Books", 2, 2, new Font("Arial", Font.BOLD, 16)));
        scrollPane.getViewport().setBackground(new Color(245, 245, 245)); // Light Gray
        frame.add(scrollPane, BorderLayout.CENTER);

        // Input panel with labels and text fields, modern look
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        titleField = new JTextField();
        authorField = new JTextField();
        inputPanel.add(new JLabel("Book Title:", JLabel.RIGHT));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:", JLabel.RIGHT));
        inputPanel.add(authorField);
        inputPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 2), "Add Book", 2, 2, new Font("Arial", Font.BOLD, 16)));
        inputPanel.setBackground(new Color(240, 255, 255)); // Light Cyan
        frame.add(inputPanel, BorderLayout.WEST);

        // Button panel with modern styled buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(new Color(230, 230, 250)); // Light Lavender
        JButton addBookButton = createStyledButton("Add Book");
        JButton issueBookButton = createStyledButton("Issue Book");
        JButton returnBookButton = createStyledButton("Return Book");
        JButton displayBooksButton = createStyledButton("Display Books");
        JButton exitButton = createStyledButton("Exit");

        buttonPanel.add(addBookButton);
        buttonPanel.add(issueBookButton);
        buttonPanel.add(returnBookButton);
        buttonPanel.add(displayBooksButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel, BorderLayout.EAST);

        // Button Actions
        addBookButton.addActionListener(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            if (!title.isEmpty() && !author.isEmpty()) {
                library.addBook(title, author);
                titleField.setText("");
                authorField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill in both fields.");
            }
        });

        issueBookButton.addActionListener(e -> {
            String title = JOptionPane.showInputDialog(frame, "Enter the title of the book to issue:");
            if (title != null && !title.trim().isEmpty()) {
                library.issueBook(title);
            }
        });

        returnBookButton.addActionListener(e -> {
            String title = JOptionPane.showInputDialog(frame, "Enter the title of the book to return:");
            if (title != null && !title.trim().isEmpty()) {
                library.returnBook(title);
            }
        });

        displayBooksButton.addActionListener(e -> library.displayBooks(displayArea));

        exitButton.addActionListener(e -> frame.dispose());

        // Display the frame
        frame.setVisible(true);
    }

    // Utility method to create a modern styled button
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(150, 50));
        return button;
    }

    public static void main(String[] args) {
        // Show a dialog to get the library size from the user
        String sizeInput = JOptionPane.showInputDialog(null, "Enter the size of the library:");
        if (sizeInput != null) {
            int size = Integer.parseInt(sizeInput);
            new LibraryManagementSystemGUI(size);
        }
    }
}

