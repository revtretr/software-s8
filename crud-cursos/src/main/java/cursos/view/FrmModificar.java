package cursos.view;

import cursos.controller.CursoController;
import cursos.model.Curso;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
public class FrmModificar {

    private final CursoController cursoController;
    private final Curso curso;

    @FXML
    private TextField txtCodCur;
    @FXML
    private TextField txtNomCur;
    @FXML
    private ComboBox<String> cboCiclo;
    @FXML
    private TextField txtNumCre;

    public FrmModificar(CursoController cursoController, Curso curso) {
        this.cursoController = cursoController;
        this.curso = curso;
    }
    @FXML
    private void initialize() {
        txtCodCur.setText(String.valueOf(curso.getCodCur()));
        txtNomCur.setText(curso.getNomCur());
        cboCiclo.setValue(curso.getCiclo());
        txtNumCre.setText(String.valueOf(curso.getNumCre()));
    }

    @FXML
    private void onGuardar() {
        try {
            cursoController.modificar(
                    curso.getId(),
                    txtCodCur.getText(),
                    txtNomCur.getText(),
                    cboCiclo.getValue(),
                    txtNumCre.getText());
            Mensajes.info("Curso modificado correctamente.");
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
