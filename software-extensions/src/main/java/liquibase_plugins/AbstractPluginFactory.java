package liquibase_plugins;

import java.util.*;

public abstract class AbstractPluginFactory<T extends Plugin> {

    protected abstract Class<T> getPluginClass();

    // 判断优先级来决定是否加载plugin
    // Returns the priority of the given object based on the passed args array
    protected abstract int getPriority(T obj, Object... args);

    protected T getPlugin(final Object... args) {
        // ...
        TreeSet<T> applicable = new TreeSet<>((o1, o2) -> {
            Integer o1Priority = getPriority(o1, args);
            Integer o2Priority = getPriority(o2, args);

            int i = o2Priority.compareTo(o1Priority);
            if (i == 0) {
                return o1.getClass().getName().compareTo(o2.getClass().getName());
            }
            return i;
        });

        for (T plugin : findInstances(getPluginClass())) {
            if (getPriority(plugin, args) >= 0) {
                applicable.add(plugin);
            }
        }
        return (applicable.size() != 0) ? applicable.iterator().next() : null;
    }

    // TODO. 使用ServiceLoader加载执行类型的实现
    public <T> List<T> findInstances(Class<T> interfaceType) {
        List<T> allInstances = new ArrayList<>();
        ClassLoader classLoader = this.getClass().getClassLoader();

        // 使用Iterator迭代器来迭代所有接口的实现
        final Iterator<T> services = ServiceLoader.load(interfaceType, classLoader).iterator();
        while (services.hasNext()) {
            try {
                final T service = services.next();
                allInstances.add(service);
            } catch (Exception e) {
                System.out.println("Cannot load service: " + e.getMessage());
            }
        }
        return Collections.unmodifiableList(allInstances);
    }
}
