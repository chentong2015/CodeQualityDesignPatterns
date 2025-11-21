package behavior_pattern.template_method;

// TODO. 模板方法的常见场景
public abstract class TemplateFileLoader {

    private void initParser() {
        // Define init
    }

    protected abstract int preTreatment();
    protected abstract int initImport();
    protected abstract int parseXml();
    protected abstract int finishImport();

    // 定义文件加载过程的逻辑
    public int loadXml(String parameter) {
        initParser();

        preTreatment();
        initImport();
        parseXml();
        finishImport();

        return 0;
    }
}
