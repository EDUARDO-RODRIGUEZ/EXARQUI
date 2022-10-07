package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {

    public static String DBNAME = "paracticaarqui";
    public static String USER = "root";
    public static String PASS = "eduardo";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBNAME, USER, PASS);
        } catch (Exception e) {
            System.out.println("Error Conexion: " + e.getMessage());
            return null;
        }
    }

    public void close(Connection conexion, PreparedStatement pstm) {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion!!!");
        }
    }

}
