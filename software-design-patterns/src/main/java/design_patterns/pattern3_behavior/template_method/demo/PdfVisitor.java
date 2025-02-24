package design_patterns.pattern3_behavior.template_method.demo;

public class PdfVisitor extends DocVisitor {

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
