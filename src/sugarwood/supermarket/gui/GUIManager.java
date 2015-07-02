package sugarwood.supermarket.gui;

import javafx.scene.control.Alert;

public class GUIManager {
    // Mostra uma caixa de texto exibindo alguma mensagem
    public static void showDialog(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
