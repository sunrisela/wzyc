package org.wz.yc;

import android.os.Bundle;
import android.widget.Button;

import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapView;

public class PointsRoute extends MapActivity {
	
	Button mBtnDrive = null;	// 驾车搜索
	MapView mMapView = null;	// 地图View
	MKSearch mSearch = null;	// 搜索模块，也可去掉地图模块独立使用

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.pointsroute);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
