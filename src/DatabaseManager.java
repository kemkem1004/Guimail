import java.io.*;
import java.util.*;

public class DatabaseManager {
    private String filePath;

    public DatabaseManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveEmailData(String emailId, String emailContent, Date timestamp) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(emailId + "," + emailContent + "," + timestamp.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> loadEmailData() {
        List<String[]> emailData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                emailData.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emailData;
    }

    public void saveAccountMetadata(String accountId, String accountInfo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(accountId + "," + accountInfo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> loadAccountMetadata() {
        List<String[]> accountData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                accountData.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountData;
    }
}