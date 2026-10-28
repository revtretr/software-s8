package cursos.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {

    private final String url =
            "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=bdalumno;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "integratedSecurity=true;";

    public Connection getConexion() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
