package design_patterns.pattern1_creation.prototype.types;

import java.time.LocalDateTime;

public class DataTimeBlock implements IBlock {

    private LocalDateTime dateTime;

    public DataTimeBlock(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public IBlock copy() {
        return null;
    }
}
