package seminar4;

import java.util.TimerTask;

public class Task extends TimerTask {

    public Task(Note note){
        System.out.println("Заметка создана." + note);
    }

    public void run() {
        try {
            System.out.println("Внимание! Напоминаю о заметке!!! ");
        } catch (Exception ex) {
            System.out.println("Ошибка! " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}