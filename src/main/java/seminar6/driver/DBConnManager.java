package seminar6.driver;


import java.sql.*;

public class DBConnManager extends DBKey {
    public ResultSet dbConnector(String querySQL) {
        try (Connection conn = DriverManager.getConnection(super.dbName, super.dbUser, super.dbPass)) {
            //System.out.println("\nСоединение с базой данных установлено!\n");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(querySQL);
            return resultSet;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
