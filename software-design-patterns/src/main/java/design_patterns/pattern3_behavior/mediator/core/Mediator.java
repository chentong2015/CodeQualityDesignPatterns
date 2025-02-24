package design_patterns.pattern3_behavior.mediator.core;

import java.util.ArrayList;
import java.util.List;

// TODO: Mediator的作用，将Command和Light进行解耦
//  通过Mediator来"调节器"两者之间的关联
public class Mediator {

    private final List<Light> lights = new ArrayList<>();

    public void registerLight(Light light) {
        this.lights.add(light);
    }

    public void turnOnAllLights() {
        for (Light light : lights) {
            if (!light.isOn()) {
                light.toggle();
            }
        }
    }
}
