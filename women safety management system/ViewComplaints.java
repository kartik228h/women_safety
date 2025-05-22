import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ViewComplaints extends JFrame {
    public ViewComplaints() {
        setTitle("View Complaints");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);
        try {
            List<String> complaints = FileUtils.readAllComplaints();
            for (String c : complaints) {
                area.append(c + "\n\n");
            }
        } catch (IOException e) {
            area.setText("Unable to read complaints.");
        }

        add(new JScrollPane(area), BorderLayout.CENTER);
        setVisible(true);
    }
}

