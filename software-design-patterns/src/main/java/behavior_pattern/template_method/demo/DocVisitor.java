package behavior_pattern.template_method.demo;

// Abstract Template
public abstract class DocVisitor {

    abstract boolean prepareDoc();

    abstract String visitDoc();

    abstract boolean restoreDoc();

    // 抽象的模板方法，包含通用的逻辑
    public void readDocument() {
        try {
            if (prepareDoc()) {
                String content = visitDoc();
                System.out.println(content);
            }
        } finally {
            System.out.println(restoreDoc());
        }
    }
}
