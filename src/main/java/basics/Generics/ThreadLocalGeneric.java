package basics.Generics;

import java.util.function.Supplier;

public class ThreadLocalGeneric<T> {
    // We mark it private and final for safety
    private final ThreadLocal<T> context = new ThreadLocal<>();

    // Option A: Get the current thread's value
    public T getContext() {
        return context.get();
    }

    // Option B: Set a specific instance
    public void setContext(T value) {
        context.set(value);
    }

    // Option C: Initialize with a factory (to fix the 'new T()' issue)
    public void initContext(Supplier<T> supplier) {
        context.set(supplier.get());
    }

    // Important: Always provide a way to clean up to prevent memory leaks!
    public void remove() {
        context.remove();
    }
}