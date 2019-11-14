package com.roxiemobile.androidcommons.logging;

import java.util.concurrent.Callable;

public final class Logger
{
// MARK: - Construction

    public static Logger shared() {
        return Logger.SingletonHolder.SHARED_INSTANCE;
    }

    private static class SingletonHolder {
        private static final Logger SHARED_INSTANCE = new Logger();
    }

    private Logger() {
        // Do nothing
    }

// MARK: - Properties

    public Logger logger(Logger.Contract logger) {
        synchronized (mSyncLock) {
            mLogger = logger;
        }
        return this;
    }

    private Logger.Contract logger() {
        synchronized (mSyncLock) {
            return mLogger;
        }
    }

    public Logger logLevel(LogLevel level) {
        synchronized (mSyncLock) {
            mLogLevel = level;
        }
        return this;
    }

    public LogLevel logLevel() {
        synchronized (mSyncLock) {
            return mLogLevel;
        }
    }

// MARK: - Methods

    public static void v(String tag, String msg) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Verbose)) {
            logger.v(tag, msg);
        }
    }

    public static void v(String tag, Callable<String> target) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Verbose)) {
            try {
                logger.v(tag, target);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(String tag, String msg) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Debug)) {
            logger.d(tag, msg);
        }
    }

    public static void d(String tag, Callable<String> target) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Debug)) {
            try {
                logger.d(tag, target);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void i(String tag, String msg) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Info)) {
            logger.i(tag, msg);
        }
    }

    public static void i(String tag, Callable<String> target) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Info)) {
            try {
                logger.i(tag, target);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void w(String tag, String msg) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Warning)) {
            logger.w(tag, msg);
        }
    }

    public static void w(String tag, String msg, Throwable err) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Warning)) {
            logger.w(tag, msg, err);
        }
    }

    public static void w(String tag, Throwable err) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Warning)) {
            logger.w(tag, err);
        }
    }

    public static void w(String tag, Callable<String> target) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Warning)) {
            try {
                logger.w(tag, target);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void w(String tag, Callable<String> target, Throwable err) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Warning)) {
            try {
                logger.w(tag, target, err);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void e(String tag, String msg) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Error)) {
            logger.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable err) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Error)) {
            logger.e(tag, msg, err);
        }
    }

    public static void e(String tag, Throwable err) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Error)) {
            logger.e(tag, err);
        }
    }

    public static void e(String tag, Callable<String> target) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Error)) {
            try {
                logger.e(tag, target);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void e(String tag, Callable<String> target, Throwable err) {
        Logger.Contract logger = shared().logger();

        if (logger != null && isLoggable(LogLevel.Error)) {
            try {
                logger.e(tag, target, err);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

// MARK: - Methods

    public static boolean isLoggable(LogLevel level) {
        return level.ordinal() >= shared().logLevel().ordinal();
    }

// MARK: - Inner Types

    public interface Contract
    {
        void v(String tag, String msg);
        void v(String tag, Callable<String> target);
        void d(String tag, String msg);
        void d(String tag, Callable<String> target);
        void i(String tag, String msg);
        void i(String tag, Callable<String> target);
        void w(String tag, String msg);
        void w(String tag, String msg, Throwable err);
        void w(String tag, Throwable err);
        void w(String tag, Callable<String> target);
        void w(String tag, Callable<String> target, Throwable err);
        void e(String tag, String msg);
        void e(String tag, String msg, Throwable err);
        void e(String tag, Throwable err);
        void e(String tag, Callable<String> target);
        void e(String tag, Callable<String> target, Throwable err);
    }

    public enum LogLevel
    {
        // Use Logger.v()
        Verbose,
        // Use Logger.d()
        Debug,
        // Use Logger.i()
        Info,
        // Use Logger.w()
        Warning,
        // Use Logger.e()
        Error,
        // Turn off all logging
        Suppress
    }

// MARK: - Variables

    private Logger.Contract mLogger = null;

    private LogLevel mLogLevel = LogLevel.Info;

    private final Object mSyncLock = new Object();
}
