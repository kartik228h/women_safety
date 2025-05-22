import javax.swing.*;
import java.awt.*;

public class AdminLoginPage extends JFrame {
    public AdminLoginPage() {
        setTitle("Admin Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Admin Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Admin Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.equals("admin") && pass.equals("admin123")) {
                new ViewComplaints();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Admin Credentials!");
            }
        });

        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(loginBtn);
        setVisible(true);
    }
}
