package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager instance;

    private final String url = "jdbc:postgresql://localhost:5432/web";
    private final String username = "pgroot";
    private final String password = "1234";

    public static ConnectionManager getInstance() {
        if(instance == null){
            try {
                Class.forName("org.postgresql.Driver");
            } catch ( ClassNotFoundException e ) {
                e.printStackTrace();
            }
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
