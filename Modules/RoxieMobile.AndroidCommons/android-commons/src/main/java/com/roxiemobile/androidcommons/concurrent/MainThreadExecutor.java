package com.roxiemobile.androidcommons.concurrent;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * An executor service that executes its tasks on the main thread.
 * <p>
 * Shutting down this executor is not supported.
 */
public final class MainThreadExecutor extends AbstractExecutorService
{
// MARK: - Construction

    public static MainThreadExecutor shared() {
        return SingletonHolder.SHARED_INSTANCE;
    }

    private static class SingletonHolder {
        private static final MainThreadExecutor SHARED_INSTANCE = new MainThreadExecutor();
    }

    private MainThreadExecutor() {
        // Do nothing
    }

// MARK: - Methods

    @Override
    public void execute(@NotNull Runnable runnable) {
        ThreadUtils.runOnUiThread(runnable);
    }

    /**
     * Not supported and throws an exception when used.
     */
    @Deprecated
    @Override
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    /**
     * Not supported and throws an exception when used.
     */
    @Deprecated
    @Override
    public @NotNull List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    /**
     * Not supported and throws an exception when used.
     */
    @Deprecated
    @Override
    public boolean awaitTermination(long l, @NotNull TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }
}
