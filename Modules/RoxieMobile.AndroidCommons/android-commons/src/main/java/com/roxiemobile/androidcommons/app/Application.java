package com.roxiemobile.androidcommons.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

import com.roxiemobile.androidcommons.diagnostics.Guard;
import com.roxiemobile.androidcommons.logging.Logger;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Application extends android.app.Application
{
// MARK: - Methods

    public static @Nullable PackageInfo getPackageInfo(@NotNull Context context) {
        Guard.notNull(context, "context is null");

        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        catch (NameNotFoundException e) {
            Logger.e(TAG, e);
        }
        return packageInfo;
    }

    public static @Nullable String getVersionName(@NotNull Context context) {
        Guard.notNull(context, "context is null");

        PackageInfo packageInfo = getPackageInfo(context);
        return (packageInfo == null) ? null : packageInfo.versionName;
    }

    public static @Nullable Integer getVersionCode(@NotNull Context context) {
        Guard.notNull(context, "context is null");

        PackageInfo packageInfo = getPackageInfo(context);
        return (packageInfo == null) ? null : packageInfo.versionCode;
    }

// MARK: - Constants

    private static final String TAG = Application.class.getSimpleName();
}
