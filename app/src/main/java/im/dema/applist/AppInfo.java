package im.dema.applist;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dgureev on 9/23/14.
 */
class AppInfo implements Comparable<AppInfo>{
    String name;
    String versionName;
    Drawable icon;
    private String packageName;
    private int versionCode;

    static List<AppInfo> getAppInfoList(Activity a) {
        ArrayList<AppInfo> appInfoList = new ArrayList<AppInfo>();
        List<PackageInfo> packs = a.getPackageManager().getInstalledPackages(PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
        final int size = packs.size();
        for (int i = 0; i < size; i++) {
            PackageInfo p = packs.get(i);
            if (p.versionName == null) {
                continue;
            }
            AppInfo newInfo = new AppInfo();
            newInfo.name = p.applicationInfo.loadLabel(a.getPackageManager()).toString();
            newInfo.packageName = p.packageName;
            newInfo.versionName = p.versionName;
            newInfo.versionCode = p.versionCode;
            newInfo.icon = p.applicationInfo.loadIcon(a.getPackageManager());
            appInfoList.add(newInfo);
        }

        Collections.sort(appInfoList);
        return appInfoList;
    }

    @Override
    public int compareTo(AppInfo appInfo) {
        return name.compareTo(appInfo.name);
    }
}


