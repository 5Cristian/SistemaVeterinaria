package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConexion {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String PASSWORD = "12345678abc";
    private final String USUARIO = "root";
    private final String URL = "jdbc:mysql://localhost:3306/veterinaria";

    public Connection cadena;

    public DBConexion() {
        this.cadena = null;
    }

    public Connection conectarme() {
        try {
            Class.forName(DRIVER);
            this.cadena = DriverManager.getConnection(URL, USUARIO, PASSWORD);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return this.cadena;
    }

    public void desconectar() {
        try {
            this.cadena.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
