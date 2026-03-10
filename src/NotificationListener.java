import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationListener {
    private final JLabel notificationLabel;
    private final ExecutorService executorService;

    public NotificationListener(JLabel notificationLabel) {
        this.notificationLabel = notificationLabel;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public void listenForNotifications() {
        executorService.submit(() -> {
            // Simulate listening for new email notifications
            while (true) {
                try {
                    // Simulating delay for fetching new notifications
                    Thread.sleep(5000);
                    // Simulate receiving a new email alert
                    String newEmailAlert = "New email received at " + java.time.LocalDateTime.now();
                    updateGui(newEmailAlert);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }

    private void updateGui(String message) {
        SwingUtilities.invokeLater(() -> notificationLabel.setText(message));
    }

    public void shutdown() {
        executorService.shutdown();
    }
}