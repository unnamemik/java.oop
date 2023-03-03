package seminar6.model;

import java.io.IOException;
import java.io.PrintWriter;

import static seminar6.view.Constants.filePath;

public interface EditCSV extends Editor{
    static void deleteAllEntries(){
        try {
            PrintWriter pw = new PrintWriter(filePath);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}