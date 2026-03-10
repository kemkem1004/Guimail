import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailClientGUI {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JPanel loginPanel, registerPanel, inboxPanel, composerPanel, notificationPanel;

    public MailClientGUI() {
        frame = new JFrame("Mail Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        tabbedPane = new JTabbedPane();
        
        // Login Panel
        loginPanel = new JPanel();
        loginPanel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField(20);
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField(20);
        loginPanel.add(passwordField);
        JButton loginButton = new JButton("Login");
        loginPanel.add(loginButton);
        
        // Register Panel
        registerPanel = new JPanel();
        registerPanel.add(new JLabel("Register Username:"));
        JTextField registerUsernameField = new JTextField(20);
        registerPanel.add(registerUsernameField);
        registerPanel.add(new JLabel("Password:"));
        JPasswordField registerPasswordField = new JPasswordField(20);
        registerPanel.add(registerPasswordField);
        JButton registerButton = new JButton("Register");
        registerPanel.add(registerButton);
        
        // Inbox Panel
        inboxPanel = new JPanel();
        inboxPanel.setLayout(new BorderLayout());
        String[] columnNames = {"From", "Subject", "Date"};
        Object[][] data = {}; // Data can be fetched from an email service
        JTable inboxTable = new JTable(data, columnNames);
        inboxPanel.add(new JScrollPane(inboxTable), BorderLayout.CENTER);
        
        // Composer Panel
        composerPanel = new JPanel();
        composerPanel.setLayout(new BorderLayout());
        JTextArea composeArea = new JTextArea(10, 40);
        composerPanel.add(new JScrollPane(composeArea), BorderLayout.CENTER);
        JButton sendButton = new JButton("Send Email");
        composerPanel.add(sendButton, BorderLayout.SOUTH);
        
        // Notification Panel
        notificationPanel = new JPanel();
        JLabel notificationLabel = new JLabel("Notifications will appear here");
        notificationPanel.add(notificationLabel);
        
        // Add Panels to Tabbed Pane
        tabbedPane.add("Login", loginPanel);
        tabbedPane.add("Register", registerPanel);
        tabbedPane.add("Inbox", inboxPanel);
        tabbedPane.add("Compose", composerPanel);
        tabbedPane.add("Notifications", notificationPanel);
        
        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MailClientGUI::new);
    }
}