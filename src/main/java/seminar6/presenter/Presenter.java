package seminar6.presenter;

import seminar6.model.NoteSQL;
import seminar6.view.SQLPrinter;

public class Presenter {
    public static void main(String[] args){
        //mainForm();

         SQLPrinter.allIdPrinter();                // Вывод всех абонентов

        //NoteCSV entry = new NoteCSV();            // Новая запись в CSV
        //CSVPrinter.allEntriesPrinter();           // Вывод CSV
        //EditCSV.deleteAllEntries();               // Очистить CSV

        NoteSQL entry = new NoteSQL();            // Новая запись в SQL

        SQLPrinter.fullJoinPrinter();             // Вывод всех связей в SQL

        //SQLPrinter.allIdPrinter();                // Вывод всех абонентов

        //new Synchro().entrySynchro();             // Синхронизация SQL и CSV
        // EditSQL.deleteEntry();                   // Удалить запись в SQL
        //EditSQL.updateEntry();                    // Обновить запись в SQL

        //SQLPrinter.allIdPrinter();                // Вывод всех абонентов

    }
}
