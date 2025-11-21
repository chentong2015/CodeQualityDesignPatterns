package behavior_pattern.template_method;

public abstract class TemplateClass {

    private boolean isDone = false;

    // 在继承类中自定义的实现细节
    protected abstract void init();

    protected abstract void work();

    protected abstract void cleanup();

    // 通用的执行逻辑
    public void run() {
        init();
        while (!isDone) {
            work();
        }
        cleanup();
    }

    protected void setDone() {
        isDone = true;
    }
}
