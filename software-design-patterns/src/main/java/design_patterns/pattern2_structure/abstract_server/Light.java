package design_patterns.pattern2_structure.abstract_server;

public class Light implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("Turn on the light");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off the light");
    }
}
