package seminar6.view;

import seminar6.model.SQLQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static seminar6.view.Constants.RESET;
import static seminar6.view.Constants.YELLOW;

public interface SQLPrinter extends Printer{
    static ArrayList entryPrinter(ResultSet resultSet) {
        ArrayList arrStr = new ArrayList<>();
        System.out.println();
        try {
            while (resultSet.next()) {
                String txt = (YELLOW + resultSet.getString(1) + " " + resultSet.getString(2) + " "
                        + resultSet.getString(3) + " " + resultSet.getString(4) + RESET);
                System.out.println(txt);
                arrStr.add(txt + "\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrStr;
    }

    static ArrayList fullJoinPrinter(){
        ArrayList arrStr = new ArrayList<>();
        String selectSQLPhone = "SELECT first_name, second_name, father_name, phone FROM peoples " +
        "RIGHT JOIN phone_numbers ON phone_numbers.\"peoples_id_SK\" = peoples.\"peoples_id\"";
        arrStr.add(entryPrinter(SQLQuery.querySender(selectSQLPhone)));
        String selectSQLMail = "SELECT first_name, second_name, father_name, email FROM peoples " +
                "RIGHT JOIN email_address ON email_address.\"peoples_email_SK\" = peoples.\"peoples_id\"";
        arrStr.add(entryPrinter(SQLQuery.querySender(selectSQLMail)));
        String selectSQLInfo = "SELECT first_name, second_name, father_name, add_info FROM peoples " +
                "RIGHT JOIN additional_info ON additional_info.\"peoples_id_add_SK\" = peoples.\"peoples_id\"";
        arrStr.add(entryPrinter(SQLQuery.querySender(selectSQLInfo)));
        return arrStr;
    }

    static void allIdPrinter(){
        String allSQLid = "SELECT * FROM peoples";
        entryPrinter(SQLQuery.querySender(allSQLid));
    }
}
