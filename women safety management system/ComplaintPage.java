import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ComplaintPage extends JFrame {
    public ComplaintPage(String username) {
        setTitle("Complaint Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea complaintArea = new JTextArea();
        JButton submitBtn = new JButton("Submit Complaint");
        JButton emergencyBtn = new JButton("Emergency Alert");

        submitBtn.addActionListener(e -> {
            String complaint = complaintArea.getText();
            try {
                FileUtils.saveComplaint(username, complaint);
                JOptionPane.showMessageDialog(this, "Complaint Submitted!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving complaint.");
            }
        });

        emergencyBtn.addActionListener(e -> {
            new EmergencyAlert();
        });

        add(new JScrollPane(complaintArea), BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(submitBtn);
        panel.add(emergencyBtn);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
