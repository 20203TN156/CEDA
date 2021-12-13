package utez.gms.eda.cool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root",
                "root"
        );
    }

    public static void main(String[] args) {
        try {
            System.out.println("Abriendo conexión...");
            try (Connection con = Conexion.getConnection()) {
                System.out.println("Conexión establecida");
            }
            System.out.println("Conexión cerrada");
        } catch (SQLException ex) {
            System.out.println("Error de conexión");
        }
    }
}
