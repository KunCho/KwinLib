package kwin.com.kwinlib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhaokun on 2016/9/2 0002.
 */

public class AppUtil {
    public static List<AppInfo> getAppList(Context context){
        List<AppInfo> appInfoList = new ArrayList<>();
        List<PackageInfo> packages = context.getPackageManager().getInstalledPackages(PackageManager.GET_ACTIVITIES);
        for (PackageInfo packageInfo:packages){
            AppInfo appInfo = new AppInfo();
            appInfo.setName(packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
            appInfo.setIcon(packageInfo.applicationInfo.loadIcon(context.getPackageManager()));
            appInfo.setInstallTime(getFormatTime(packageInfo.firstInstallTime));
            appInfo.setVersionCode(packageInfo.versionCode);
            appInfo.setVersionName(packageInfo.versionName);
            appInfoList.add(appInfo);
        }
        return appInfoList;
    }

    public static String getFormatTime(long firstInstallTime) {
        if (firstInstallTime <= 0){
            return "";
        }
        return SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL).format(new Date(firstInstallTime));
    }
}
