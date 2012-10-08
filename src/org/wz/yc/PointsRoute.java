package org.wz.yc;

import android.os.Bundle;
import android.widget.Button;

import com.baidu.mapapi.BMapManager;
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
		
		YcApp app = (YcApp)this.getApplication();
		if (app.mBMapMan == null) {
			app.mBMapMan = new BMapManager(getApplication());
			app.mBMapMan.init(app.mStrKey, new YcApp.MyGeneralListener());
		}
		app.mBMapMan.start();
        // 初始化baidu地图Activity
        super.initMapActivity(app.mBMapMan);
        
        findViews();
        
        mMapView.setBuiltInZoomControls(true);
        //设置在缩放动画过程中也显示overlay,默认为不绘制
        mMapView.setDrawOverlayWhenZooming(true);
        
        setListensers();
        
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		YcApp app = (YcApp)this.getApplication();
		app.mBMapMan.stop();
		
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		YcApp app = (YcApp)this.getApplication();
		app.mBMapMan.start();
		
		super.onResume();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void findViews() {
		mMapView = (MapView)findViewById(R.id.bmapView);
	}
	
	private void setListensers() {
		
	}

}
