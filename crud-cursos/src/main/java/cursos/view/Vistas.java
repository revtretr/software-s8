package cursos.view;

import cursos.controller.CursoController;
import cursos.model.Curso;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UncheckedIOException;
public class Vistas {

    private final CursoController cursoController;

    public Vistas(CursoController cursoController) {
        this.cursoController = cursoController;
    }
    public void abrirIndex(Stage ventanaPrincipal) {
        ventanaPrincipal.setTitle("Sistema de Cursos");
        ventanaPrincipal.setScene(new Scene(cargar("index.fxml", new FrmIndex(this))));
        ventanaPrincipal.show();
    }
    public void abrirConsultar() {
        Stage ventana = new Stage();
        ventana.setTitle("Consultar cursos");
        ventana.setScene(new Scene(cargar("frmConsultar.fxml", new FrmConsultar(cursoController, this))));
        ventana.show();
    }
    public void abrirInsertar() {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Registrar curso");
        ventana.setScene(new Scene(cargar("frmInsertar.fxml", new FrmInsertar(cursoController))));
        ventana.showAndWait();
    }
    public void abrirModificar(Curso curso) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Modificar curso");
        ventana.setScene(new Scene(cargar("frmModificar.fxml", new FrmModificar(cursoController, curso))));
        ventana.showAndWait();
    }
    private Parent cargar(String archivoFxml, Object claseDeLaVista) {
        try {
            FXMLLoader loader = new FXMLLoader(Vistas.class.getResource("/cursos/view/" + archivoFxml));
            loader.setController(claseDeLaVista);
            return loader.load();
        } catch (IOException e) {
            throw new UncheckedIOException("No se pudo cargar " + archivoFxml, e);
        }
    }
}
