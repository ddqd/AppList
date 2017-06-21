package im.dema.applist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends Activity {
    private ListView appListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appListView = findViewById(R.id.appListView);
        getAppList();
    }

    private void getAppList() {
        List<AppInfo> appInfoList = AppInfo.getAppInfoList(this);
        AppListAdapter adapter = new AppListAdapter(this, R.layout.app_info_item, appInfoList);
        appListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
