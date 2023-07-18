package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static property.BaseProperties.*;

public class ConnectionDB {

    public static ConnectionDB connectionDB = ConnectionDB.getInstance();
    public static ConnectionDB connection;

    private ConnectionDB() {
    }

    public static ConnectionDB getInstance() {
        if (connection == null) {
            connection = new ConnectionDB();
        }
        return connection;
    }

    public Connection getConnection(String dbName) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(DB_HOST + dbName, DB_USER, DB_PASS);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return connection;
    }
}