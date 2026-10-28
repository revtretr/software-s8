package cursos.controller;

import cursos.model.Curso;
import cursos.model.CursoDAO;

import java.sql.SQLException;
import java.util.List;
public class CursoController {

    private final CursoDAO cursoDAO;

    public CursoController(CursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }

    public List<Curso> consultar() throws SQLException {
        return cursoDAO.listar();
    }

    public void insertar(String codCur, String nomCur, String ciclo, String numCre) throws SQLException {
        Curso curso = armarCurso(0, codCur, nomCur, ciclo, numCre);

        if (cursoDAO.existeCodigo(curso.getCodCur(), 0)) {
            throw new IllegalArgumentException("Ya existe un curso con el código " + curso.getCodCur() + ".");
        }
        cursoDAO.insertar(curso);
    }

    public void modificar(int id, String codCur, String nomCur, String ciclo, String numCre) throws SQLException {
        Curso curso = armarCurso(id, codCur, nomCur, ciclo, numCre);

        if (cursoDAO.existeCodigo(curso.getCodCur(), id)) {
            throw new IllegalArgumentException("Ya existe otro curso con el código " + curso.getCodCur() + ".");
        }
        cursoDAO.modificar(curso);
    }

    public void eliminar(int id) throws SQLException {
        cursoDAO.eliminar(id);
    }
    private Curso armarCurso(int id, String codCur, String nomCur, String ciclo, String numCre) {
        if (codCur == null || codCur.isBlank()
                || nomCur == null || nomCur.isBlank()
                || ciclo == null || ciclo.isBlank()
                || numCre == null || numCre.isBlank()) {
            throw new IllegalArgumentException("Complete todos los campos.");
        }

        int codigo;
        int creditos;
        try {
            codigo = Integer.parseInt(codCur.trim());
            creditos = Integer.parseInt(numCre.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El código y los créditos deben ser números enteros.");
        }

        if (codigo <= 0) {
            throw new IllegalArgumentException("El código debe ser mayor que 0.");
        }
        if (creditos <= 0) {
            throw new IllegalArgumentException("Los créditos deben ser mayor que 0.");
        }
        if (nomCur.trim().length() > 50) {
            throw new IllegalArgumentException("El nombre del curso no puede pasar de 50 caracteres.");
        }
        if (ciclo.trim().length() > 4) {
            throw new IllegalArgumentException("El ciclo no puede pasar de 4 caracteres.");
        }

        return new Curso(id, codigo, nomCur.trim(), ciclo.trim(), creditos);
    }
}
