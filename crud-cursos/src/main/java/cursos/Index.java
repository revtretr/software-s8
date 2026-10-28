package cursos;

import cursos.controller.CursoController;
import cursos.model.Conexion;
import cursos.model.CursoDAO;
import cursos.view.Vistas;
import javafx.application.Application;
import javafx.stage.Stage;
public class Index extends Application {

    @Override
    public void start(Stage ventanaPrincipal) {
        Conexion conexion = new Conexion();
        CursoDAO cursoDAO = new CursoDAO(conexion);
        CursoController cursoController = new CursoController(cursoDAO);
        Vistas vistas = new Vistas(cursoController);
        vistas.abrirIndex(ventanaPrincipal);
    }
}
