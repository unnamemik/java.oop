package seminar4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Recorder {
    public static void recorder(String msg) {
        try (FileWriter file = new FileWriter("E:\\git\\java\\java.oop\\src\\main\\java\\logs\\Recorder.log", true)) {
            Date currentTime = new Date();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTime + ": " + msg + "\n");
            file.append(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
