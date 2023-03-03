package seminar6.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static seminar6.view.Constants.filePath;

public interface CSVPrinter {

    static List<String> allEntriesPrinter() {
        System.out.println();
        List<String> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return records;
    }

    static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
