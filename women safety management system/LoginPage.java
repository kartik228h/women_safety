import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("Login");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");
        JButton adminBtn = new JButton("Admin Login");

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            try {
                if (FileUtils.checkUser(user, pass)) {
                    new ComplaintPage(user);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Credentials!");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error during login.");
            }
        });

        registerBtn.addActionListener(e -> {
            new RegisterPage();
            dispose();
        });

        adminBtn.addActionListener(e -> {
            new AdminLoginPage();
            dispose();
        });

        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(loginBtn); add(registerBtn);
        add(adminBtn);
        setVisible(true);
    }
}
