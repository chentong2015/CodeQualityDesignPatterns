package behavior_pattern.mediator.timer.task;

import java.util.TimerTask;

public class RemindTaskWithoutBeep extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer really up");
    }
}
