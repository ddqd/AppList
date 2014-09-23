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
public class AppListAdapter extends ArrayAdapter {
    private List<AppInfo> appList;
    private LayoutInflater inflater;
    public AppListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.appList = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return appList.size();
    }

    @Override
    public Object getItem(int i) {
        return appList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if(view==null)
            vi = inflater.inflate(R.layout.app_info_item, null);
        AppInfo appInfo = appList.get(i);
        TextView appName = (TextView)vi.findViewById(R.id.appName);
        TextView appVersion = (TextView)vi.findViewById(R.id.appVersion);
        appVersion.setText(appInfo.versionName);
        ImageView appIcon = (ImageView)vi.findViewById(R.id.appIcon);
        appIcon.setImageDrawable(appInfo.icon);
        appName.setText(appInfo.name);
        return vi;
    }
}
