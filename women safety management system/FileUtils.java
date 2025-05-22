import java.io.*;
import java.util.*;

public class FileUtils {

    public static void saveUser(String username, String password) throws IOException {
        FileWriter fw = new FileWriter("users.txt", true);
        fw.write(username + "," + password + "\n");
        fw.close();
    }

    public static boolean checkUser(String username, String password) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("users.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }

    public static void saveComplaint(String username, String complaint) throws IOException {
        FileWriter fw = new FileWriter("complaints.txt", true);
        fw.write("From: " + username + " | Complaint: " + complaint + "\n");
        fw.close();
    }

    public static List<String> readAllComplaints() throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("complaints.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        return list;
    }
}
