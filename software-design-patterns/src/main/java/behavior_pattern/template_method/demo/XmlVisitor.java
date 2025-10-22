package behavior_pattern.template_method.demo;

public class XmlVisitor extends DocVisitor {

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
