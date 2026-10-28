package cursos.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CursoDAO {

    private final Conexion conexion;

    public CursoDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    public List<Curso> listar() throws SQLException {
        String sql = "SELECT id, CodCur, NomCur, Ciclo, NumCre FROM tcurso ORDER BY CodCur";
        List<Curso> cursos = new ArrayList<>();

        try (Connection cn = conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getInt("CodCur"),
                        rs.getString("NomCur"),
                        rs.getString("Ciclo"),
                        rs.getInt("NumCre"));
                cursos.add(curso);
            }
        }
        return cursos;
    }
    public void insertar(Curso curso) throws SQLException {
        String sql = "INSERT INTO tcurso (CodCur, NomCur, Ciclo, NumCre) VALUES (?, ?, ?, ?)";

        try (Connection cn = conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, curso.getCodCur());
            ps.setString(2, curso.getNomCur());
            ps.setString(3, curso.getCiclo());
            ps.setInt(4, curso.getNumCre());
            ps.executeUpdate();
        }
    }
    public void modificar(Curso curso) throws SQLException {
        String sql = "UPDATE tcurso SET CodCur = ?, NomCur = ?, Ciclo = ?, NumCre = ? WHERE id = ?";

        try (Connection cn = conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, curso.getCodCur());
            ps.setString(2, curso.getNomCur());
            ps.setString(3, curso.getCiclo());
            ps.setInt(4, curso.getNumCre());
            ps.setInt(5, curso.getId());
            ps.executeUpdate();
        }
    }
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM tcurso WHERE id = ?";

        try (Connection cn = conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    public boolean existeCodigo(int codCur, int idActual) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tcurso WHERE CodCur = ? AND id <> ?";

        try (Connection cn = conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, codCur);
            ps.setInt(2, idActual);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }
}
