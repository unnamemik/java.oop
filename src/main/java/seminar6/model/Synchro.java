package seminar6.model;

import lombok.SneakyThrows;
import seminar6.view.CSVPrinter;

import java.sql.ResultSet;
import java.util.List;

public class Synchro implements CSVPrinter {

    @SneakyThrows
    public void entrySynchro() {
        List<String> result = CSVPrinter.allEntriesPrinter();
        Note note = new Note();
        String [] chain;
        for (String s : result) {
            chain = s.split(",");
            note.firstName = chain[0].substring(1);
            note.secondName = chain[1];

            note.fatherName = chain[2];

            String insertSqlname = String.format("INSERT INTO public.peoples (first_name, second_name, father_name) " +
                    "VALUES (\'%s\'::character varying, \'%s\'::character varying, \'%s\'::character varying) returning null", note.firstName, note.secondName, note.fatherName);
            SQLQuery.querySender(insertSqlname);

            String selectSqlID = "SELECT MAX(peoples_id) AS maxentry FROM peoples";
            ResultSet skResult = SQLQuery.querySender(selectSqlID);
            int secondaryKey = 0;
            if (skResult.next()){secondaryKey = Integer.parseInt(skResult.getString("maxentry"));}

            note.phoneNumber = chain[3];
            String insertSqlNum = String.format("INSERT INTO public.phone_numbers (\"peoples_id_SK\", phone) " +
                    "VALUES (%d::smallint, \'%s\'::character varying) returning null", secondaryKey, note.phoneNumber);
            SQLQuery.querySender(insertSqlNum);

            note.eMail = chain[4];
            String insertSqlMail = String.format("INSERT INTO public.email_address (\"peoples_email_SK\", email) " +
                    "VALUES (%d::smallint, \'%s\'::character varying) returning null", secondaryKey, note.eMail);
            SQLQuery.querySender(insertSqlMail);

            note.addInfo = chain[5].substring(0, chain.length - 1);
            String insertSqlInfo = String.format("INSERT INTO public.additional_info (\"peoples_id_add_SK\", add_info) " +
                    "VALUES (%d::smallint, \'%s\'::character varying) returning null", secondaryKey, note.addInfo);
            SQLQuery.querySender(insertSqlInfo);

        }
    }
}
