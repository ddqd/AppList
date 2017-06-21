package im.dema.applist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dgureev on 9/23/14.
 */
class AppListAdapter extends ArrayAdapter<AppInfo> {
    private List<AppInfo> appList;
    private LayoutInflater inflater;

    AppListAdapter(Context context, int resource, List<AppInfo> objects) {
        super(context, resource, objects);
        this.appList = objects;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return appList.size();
    }

    @Override
    public AppInfo getItem(int i) {
        return appList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if (view == null)
            vi = inflater.inflate(R.layout.app_info_item, null);
        AppInfo appInfo = appList.get(i);
        TextView appName = vi.findViewById(R.id.appName);
        TextView appVersion = vi.findViewById(R.id.appVersion);
        appVersion.setText(appInfo.versionName);
        ImageView appIcon = vi.findViewById(R.id.appIcon);
        appIcon.setImageDrawable(appInfo.icon);
        appName.setText(appInfo.name);
        return vi;
    }
}
