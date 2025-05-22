import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class RegisterPage extends JFrame {
    public RegisterPage() {
        setTitle("Register");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back");

        registerBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            try {
                FileUtils.saveUser(user, pass);
                JOptionPane.showMessageDialog(this, "Registered Successfully!");
                new LoginPage();
                dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error while registering.");
            }
        });

        backBtn.addActionListener(e -> {
            new LoginPage();
            dispose();
        });

        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(registerBtn); add(backBtn);
        setVisible(true);
    }
}
