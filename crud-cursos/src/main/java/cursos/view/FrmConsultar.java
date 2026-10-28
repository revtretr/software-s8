package cursos.view;

import cursos.controller.CursoController;
import cursos.model.Curso;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.SQLException;
public class FrmConsultar {

    private final CursoController cursoController;
    private final Vistas vistas;

    @FXML
    private TableView<Curso> tabla;

    public FrmConsultar(CursoController cursoController, Vistas vistas) {
        this.cursoController = cursoController;
        this.vistas = vistas;
    }
    @FXML
    private void initialize() {
        cargarTabla();
    }

    @FXML
    private void onModificar() {
        Curso seleccionado = tabla.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            Mensajes.error("Seleccione un curso de la tabla.");
            return;
        }
        vistas.abrirModificar(seleccionado);
        cargarTabla();
    }

    @FXML
    private void onEliminar() {
        Curso seleccionado = tabla.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            Mensajes.error("Seleccione un curso de la tabla.");
            return;
        }
        if (!Mensajes.confirmar("¿Seguro que desea eliminar el curso \"" + seleccionado.getNomCur() + "\"?")) {
            return;
        }
        try {
            cursoController.eliminar(seleccionado.getId());
            cargarTabla();
        } catch (SQLException e) {
            Mensajes.error("No se pudo eliminar el curso: " + e.getMessage());
        }
    }

    @FXML
    private void onActualizar() {
        cargarTabla();
    }

    @FXML
    private void onCerrar() {
        ((Stage) tabla.getScene().getWindow()).close();
    }
    private void cargarTabla() {
        try {
            tabla.setItems(FXCollections.observableArrayList(cursoController.consultar()));
        } catch (SQLException e) {
            Mensajes.error("No se pudo consultar los cursos: " + e.getMessage());
        }
    }
}
