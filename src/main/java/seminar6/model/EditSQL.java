package seminar6.model;

import seminar6.view.SQLPrinter;
import seminar6.view.UserInput;

public interface EditSQL extends Editor{
    static void deleteEntry(){
        int deleteSQLid = UserInput.getInputInt("\nВведите id для удаления: ");

        String deleteSQLPhone = String.format("DELETE FROM public.phone_numbers WHERE \"peoples_id_SK\" = %d returning null", deleteSQLid);
        SQLQuery.querySender(deleteSQLPhone);
        String deleteSQLMail = String.format("DELETE FROM public.email_address WHERE \"peoples_email_SK\" = %d returning null", deleteSQLid);
        SQLQuery.querySender(deleteSQLMail);
        String deleteSQLInfo = String.format("DELETE FROM public.additional_info WHERE \"peoples_id_add_SK\" =%d returning null", deleteSQLid);
        SQLQuery.querySender(deleteSQLInfo);
        String deleteSQLPeople = String.format("DELETE FROM public.peoples WHERE peoples.peoples_id = %d returning null", deleteSQLid);
        SQLQuery.querySender(deleteSQLPeople);
    }

    static void updateEntry(){
        SQLPrinter.allIdPrinter();
        int updateSQLid = UserInput.getInputInt("\nВведите id для обновления: ");
        int updateSQLentry = UserInput.getInputInt("\nВведите значение поля для обновления: " +
                "\n1. Добавить телефон" +
                "\n2. Добавить электронную почту" +
                "\n3. Добавить комментарий");


        switch (updateSQLentry) {
            case 1 -> {
                String phoneNumber = UserInput.getInputStr("Введите номер телефона: \n");
                String insertSqlNum = String.format("INSERT INTO public.phone_numbers (\"peoples_id_SK\", phone) " +
                        "VALUES (%d::smallint, \'%s\'::character varying) returning null", updateSQLid, phoneNumber);
                SQLQuery.querySender(insertSqlNum);
            }
            case 2 -> {
                String eMail = UserInput.getInputStr("Введите е-мэйл: \n");
                String insertSqlMail = String.format("INSERT INTO public.email_address (\"peoples_email_SK\", email) " +
                        "VALUES (%d::smallint, \'%s\'::character varying) returning null", updateSQLid, eMail);
                SQLQuery.querySender(insertSqlMail);
            }
            case 3 -> {
                String addInfo = UserInput.getInputStr("Введите комментарий: \n");
                String insertSqlInfo = String.format("INSERT INTO public.additional_info (\"peoples_id_add_SK\", add_info) " +
                        "VALUES (%d::smallint, \'%s\'::character varying) returning null", updateSQLid, addInfo);
                SQLQuery.querySender(insertSqlInfo);
            }
            default -> {
            }
        }
    }
}
