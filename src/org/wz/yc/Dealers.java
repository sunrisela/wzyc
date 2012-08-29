package org.wz.yc;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Dealers extends Activity {
	
	ListView mListView = null;
    String mStrDemos[] = {
			"张三",
			"李四",
			"王小虎"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dealers);
		
		mListView = (ListView)findViewById(R.id.dealers_listView); 
        // 添加ListItem，设置事件响应
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < mStrDemos.length; i++) {
			data.add(mStrDemos[i]);
		}
        mListView.setAdapter((ListAdapter) new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data));
	}

}
