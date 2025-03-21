package design_patterns.pattern1_creation.prototype.types;

public class ContentBlock implements IBlock {

    private String content;

    public ContentBlock(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public IBlock copy() {
        return new ContentBlock(content);
    }
}
