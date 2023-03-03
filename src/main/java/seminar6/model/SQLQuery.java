package seminar6.model;

import seminar6.driver.DBConnManager;

import java.sql.ResultSet;

public interface SQLQuery {
    static ResultSet querySender(String selectSql) {
        ResultSet resultSet = new DBConnManager().dbConnector(selectSql);
        if (resultSet != null) {
            return resultSet;
        }
        return null;
    }
}
