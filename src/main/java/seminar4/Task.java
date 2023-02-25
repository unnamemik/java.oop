package seminar4;

import java.util.TimerTask;

import static seminar4.Recorder.recorder;

public class Task extends TimerTask {

    public Task(Note note){
        System.out.println("Заметка создана." + note);
        recorder("Заметка создана." + note);
    }

    public void run() {
        try {
            System.out.println("Внимание! Напоминаю о заметке!!! ");
            recorder("Задача выполнена!");
        } catch (Exception ex) {
            System.out.println("Ошибка! " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}