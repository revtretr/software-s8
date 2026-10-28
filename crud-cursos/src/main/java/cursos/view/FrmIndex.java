package cursos.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
public class FrmIndex {

    private final Vistas vistas;

    public FrmIndex(Vistas vistas) {
        this.vistas = vistas;
    }

    @FXML
    private void onConsultar() {
        vistas.abrirConsultar();
    }

    @FXML
    private void onInsertar() {
        vistas.abrirInsertar();
    }

    @FXML
    private void onSalir() {
        Platform.exit();
    }
}
