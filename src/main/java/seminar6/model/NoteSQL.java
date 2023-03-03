package seminar6.model;

import lombok.SneakyThrows;
import seminar6.view.SQLPrinter;
import seminar6.view.UserInput;

import java.sql.ResultSet;

public class NoteSQL extends Note{
    @SneakyThrows
    public NoteSQL() {
        firstName = UserInput.getInputStr("Введите фамилию: ");
        secondName = UserInput.getInputStr("Введите имя: ");
        fatherName = UserInput.getInputStr("Введите отчество: ");

        String insertSqlname = String.format("INSERT INTO public.peoples (first_name, second_name, father_name) " +
                "VALUES (\'%s\'::character varying, \'%s\'::character varying, \'%s\'::character varying) returning null", firstName, secondName, fatherName);
        SQLQuery.querySender(insertSqlname);

        String selectAllSql = "SELECT * FROM peoples";
        SQLPrinter.entryPrinter(SQLQuery.querySender(selectAllSql));

        String selectSqlID = "SELECT MAX(peoples_id) AS maxentry FROM peoples";
        ResultSet skResult = SQLQuery.querySender(selectSqlID);
        int secondaryKey = 0;
        if (skResult.next()){secondaryKey = Integer.parseInt(skResult.getString("maxentry"));}

        phoneNumber = UserInput.getInputStr("Введите номер телефона: ");
        String insertSqlNum = String.format("INSERT INTO public.phone_numbers (\"peoples_id_SK\", phone) " +
                        "VALUES (%d::smallint, \'%s\'::character varying) returning null", secondaryKey, phoneNumber);
        SQLQuery.querySender(insertSqlNum);

        eMail = UserInput.getInputStr("Введите е-мэйл: ");
        String insertSqlMail = String.format("INSERT INTO public.email_address (\"peoples_email_SK\", email) " +
                "VALUES (%d::smallint, \'%s\'::character varying) returning null", secondaryKey, eMail);
        SQLQuery.querySender(insertSqlMail);

        addInfo = UserInput.getInputStr("Введите комментарий: ");
        String insertSqlInfo = String.format("INSERT INTO public.additional_info (\"peoples_id_add_SK\", add_info) " +
                "VALUES (%d::smallint, \'%s\'::character varying) returning null", secondaryKey, addInfo);
        SQLQuery.querySender(insertSqlInfo);
    }
}
