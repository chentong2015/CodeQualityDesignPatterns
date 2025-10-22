package behavior_pattern.template_method;

public abstract class TemplateClass {

    private boolean isDone = false;

    protected abstract void init();

    protected abstract void work();

    protected abstract void cleanup();

    protected void setDone() {
        isDone = true;
    }

    // 通用的执行逻辑
    public void run() {
        init();
        while (!isDone) {
            work();
        }
        cleanup();
    }
}
