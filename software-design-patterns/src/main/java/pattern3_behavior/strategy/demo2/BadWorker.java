package pattern3_behavior.strategy.demo2;

public class BadWorker implements IWork {

    @Override
    public void init() {
        System.out.println("bad init");
    }

    @Override
    public void work() {
        System.out.println("do not working");
    }

    @Override
    public void cleanup() {
        System.out.println("do not clean up");
    }
}
