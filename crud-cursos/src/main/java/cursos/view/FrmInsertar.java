package cursos.view;

import cursos.controller.CursoController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
public class FrmInsertar {

    private final CursoController cursoController;

    @FXML
    private TextField txtCodCur;
    @FXML
    private TextField txtNomCur;
    @FXML
    private ComboBox<String> cboCiclo;
    @FXML
    private TextField txtNumCre;

    public FrmInsertar(CursoController cursoController) {
        this.cursoController = cursoController;
    }

    @FXML
    private void onGuardar() {
        try {
            cursoController.insertar(
                    txtCodCur.getText(),
                    txtNomCur.getText(),
                    cboCiclo.getValue(),
                    txtNumCre.getText());
            Mensajes.info("Curso registrado correctamente.");
            cerrar();
        } catch (IllegalArgumentException e) {
            Mensajes.error(e.getMessage());
        } catch (SQLException e) {
            Mensajes.error("Error en la base de datos: " + e.getMessage());
        }
    }

    @FXML
    private void onCancelar() {
        cerrar();
    }

    private void cerrar() {
        ((Stage) txtCodCur.getScene().getWindow()).close();
    }
}
