package org.wz.yc;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class YcMain extends Activity {
	
	ListView mListView = null;
    String mStrDemos[] = {
			"查看异常商户",
			"查看地图"
	};
    Class<?> mActivities[] = {
    		Dealers.class,
    		PointsRoute.class
    };

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.main);
		
		mListView = (ListView)findViewById(R.id.listView); 
        // 添加ListItem，设置事件响应
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < mStrDemos.length; i++) {
			data.add(mStrDemos[i]);
		}
        mListView.setAdapter((ListAdapter) new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data));
        mListView.setOnItemClickListener(new OnItemClickListener() {  
            public void onItemClick(AdapterView<?> arg0, View v, int index, long arg3) {  
            	onListItemClick(index);
            }  
        });
	}

	void onListItemClick(int index) {
		if (index < 0 || index >= mActivities.length+1)
    		return;

    	if( index == mActivities.length)
    	{
    		YcApp app = (YcApp)this.getApplication();
    		if (app.mBMapMan != null) {
    			app.mBMapMan.destroy();
    			app.mBMapMan = null;
    		}
    		return;
    	}

		Intent intent = null;
		intent = new Intent(YcMain.this, mActivities[index]);
		this.startActivity(intent);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		YcApp app = (YcApp)this.getApplication();
		if (app.mBMapMan != null) {
			app.mBMapMan.destroy();
			app.mBMapMan = null;
		}
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		YcApp app = (YcApp)this.getApplication();
		if (!app.m_bKeyRight) {
			TextView text = (TextView)findViewById(R.id.text_Info);
			text.setText("请在YcApp.java文件输入正确的授权Key！\r\n" +
					"申请地址：http://dev.baidu.com/wiki/static/imap/key/");
			text.setTextColor(Color.RED);
		}
		super.onResume();
	}

}
