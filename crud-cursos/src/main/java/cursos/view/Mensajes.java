package cursos.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
public class Mensajes {

    public static void info(String texto) {
        mostrar(Alert.AlertType.INFORMATION, texto);
    }

    public static void error(String texto) {
        mostrar(Alert.AlertType.ERROR, texto);
    }

    public static boolean confirmar(String texto) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, texto, ButtonType.YES, ButtonType.NO);
        alerta.setHeaderText(null);
        return alerta.showAndWait().orElse(ButtonType.NO) == ButtonType.YES;
    }

    private static void mostrar(Alert.AlertType tipo, String texto) {
        Alert alerta = new Alert(tipo, texto, ButtonType.OK);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }
}
