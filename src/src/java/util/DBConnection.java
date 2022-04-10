
package util;

import java.sql.*;

/**
 *
 * @author Umut Karadas
 */
public abstract class DBConnection {

    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/career_website_db", "postgres", "12345");
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
