package seminar6.model;

import seminar6.view.UserInput;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static seminar6.view.Constants.filePath;

public class NoteCSV extends Note{
    public NoteCSV() {
        firstName = UserInput.getInputStr("Введите фамилию: ");
        secondName = UserInput.getInputStr("Введите имя: ");
        fatherName = UserInput.getInputStr("Введите отчество: ");
        phoneNumber = UserInput.getInputStr("Введите номер телефона: ");
        eMail = UserInput.getInputStr("Введите е-мэйл: ");
        addInfo = UserInput.getInputStr("Введите комментарий: ");

        try (PrintWriter writer = new PrintWriter(filePath)) {
            StringBuilder sb = new StringBuilder();
            sb.append(firstName).append(',');
            sb.append(secondName).append(',');
            sb.append(fatherName).append(',');
            sb.append(phoneNumber).append(',');
            sb.append(eMail).append(',');
            sb.append(addInfo).append('\n');
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
