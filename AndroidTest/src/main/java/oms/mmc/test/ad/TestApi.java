package oms.mmc.test.ad;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oms.mmc.app.BaseMMCActivity;
import oms.mmc.test.android.R;

public class TestApi extends BaseMMCActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);
        ListView listView  = (ListView) findViewById(R.id.test_list_view);
        listView.setAdapter(new TestAdpter(getData()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
                Intent intent = (Intent) item.get("intent");
                startActivity(intent);
            }
        });
    }

    class TestAdpter extends BaseAdapter{
        List<Map<String,Object>> datas = null;

        public TestAdpter(List<Map<String, Object>> datas) {
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder ;
            if(convertView == null){
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.ad_listview_item,null);
                holder = new Holder();
                holder.item = (TextView) convertView.findViewById(R.id.ad_item_tv);
                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }
            String title = (String) datas.get(position).get("title");
            holder.item.setText(title);
            return convertView;
        }
    }

    static class Holder {
        TextView item;
    }
   public List<Map<String,Object>> getData(){
       List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
       Intent intent = new Intent(Intent.ACTION_MAIN);
       intent.addCategory("ad_test_action");
       PackageManager pm = getPackageManager();
       List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
       if (resolveInfos == null) {
           return data;
       }
       for (int i = 0; i < resolveInfos.size(); i++) {
           Map<String, Object> objectMap = new HashMap<String, Object>();
           ResolveInfo info = resolveInfos.get(i);
           String title = info.activityInfo.loadLabel(pm).toString();
           Intent tempIntent = new Intent();
           tempIntent.setClassName(info.activityInfo.packageName, info.activityInfo.name);
           objectMap.put("title", title);
           objectMap.put("intent", tempIntent);
           data.add(objectMap);

       }
        return data;
    }

}
