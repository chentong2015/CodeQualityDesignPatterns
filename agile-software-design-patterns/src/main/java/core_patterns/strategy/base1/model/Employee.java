package core_patterns.strategy.base1.model;

public abstract class Employee {

    private String name;
    private int workDays;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public int getWorkDays() {
        return workDays;
    }
}
