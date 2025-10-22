package behavior_pattern.mediator.timer.task;

import java.util.Timer;

// java.util.Timer Java类库中的调节器模式
public class DemoMediatorTimer {

    public static void main(String[] args) {
        testMediatorEveryday(3);
    }

    // RemindTask和RemindTaskWithoutBeep对象在完全不知道彼此的情况下
    // 完全由Timer的schedule方法来负责调度
    public static void testMediatorEveryday(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000L);
        timer.schedule(new RemindTaskWithoutBeep(), seconds * 2000L);
    }
}
