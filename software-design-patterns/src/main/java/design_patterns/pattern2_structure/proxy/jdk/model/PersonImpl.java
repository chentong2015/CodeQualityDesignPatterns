package design_patterns.pattern2_structure.proxy.jdk.model;

public class PersonImpl implements Person {

    private String name;

    public PersonImpl(String name) {
        this.name = name;
    }

    @Override
    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void work(String name, String place) {
        System.out.println(name + " goes to " + place);
    }
}
