
package database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author isais
 */
public class Db {
    private Connection connection;
    private String driver;
    private String user;
    private String password;
    private String url;
    
    public Db() {
        this(null, "com.mysql.jdbc.Driver", "root", "", "jdbc:mysql://localhost/arqui_tienda");
    }
    public Db(Connection connection, String driver, String user, String password, String url) {
        this.connection = connection;
        this.driver = driver;
        this.user = user;
        this.password = password;
        this.url = url;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public Connection CreateConnection() {
        connection = null;
        try {
            Class.forName(driver);
            //Conectando a la base de datos
            connection = (Connection) DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexión establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión" + e);
        }
        return connection;
    }
}
