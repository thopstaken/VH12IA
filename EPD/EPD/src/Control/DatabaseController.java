package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseController {
    Connection connection = null;

    public void doQuery(String query) {
        Connection connection = makeConnection(query);
        closeConnection(connection);
    }

    public Connection makeConnection(String query) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            this.connection =
                    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                                                "proftaak", "proftaak");

            String sql = query;

            PreparedStatement preStatement =
                this.connection.prepareStatement(sql);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                System.out.println("Current Date from Oracle : " +
                                   result.getString("current_day"));
            }
            System.out.println("done");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.connection;
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}