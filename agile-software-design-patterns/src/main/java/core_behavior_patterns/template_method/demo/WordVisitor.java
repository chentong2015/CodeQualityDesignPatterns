package core_behavior_patterns.template_method.demo;

public class WordVisitor extends DocVisitor {

    @Override
    public boolean prepareDoc() {
        return false;
    }

    @Override
    public String visitDoc() {
        return null;
    }

    @Override
    public boolean restoreDoc() {
        return false;
    }
}
