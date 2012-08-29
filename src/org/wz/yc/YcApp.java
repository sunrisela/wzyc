package org.wz.yc;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKEvent;
import com.baidu.mapapi.MKGeneralListener;

import android.app.Application;
import android.widget.Toast;

public class YcApp extends Application {
	
	static YcApp mYcApp;
	
	//百度MapAPI的管理类
	BMapManager mBMapMan = null;
	
	// 授权Key
	// TODO: 请输入您的Key,
	// 申请地址：http://dev.baidu.com/wiki/static/imap/key/
	String mStrKey = "D4F46D83BF8E904221412E913156B1D7E849F66E";
	boolean m_bKeyRight = true;	// 授权Key正确，验证通过
	
	// 常用事件监听，用来处理通常的网络错误，授权验证错误等
	static class MyGeneralListener implements MKGeneralListener {
		@Override
		public void onGetNetworkState(int iError) {
			Toast.makeText(YcApp.mYcApp.getApplicationContext(), "您的网络出错啦！",
					Toast.LENGTH_LONG).show();
		}

		@Override
		public void onGetPermissionState(int iError) {
			if (iError ==  MKEvent.ERROR_PERMISSION_DENIED) {
				// 授权Key错误：
				Toast.makeText(YcApp.mYcApp.getApplicationContext(), 
						"请在YcApp.java文件输入正确的授权Key！",
						Toast.LENGTH_LONG).show();
				YcApp.mYcApp.m_bKeyRight = false;
			}
		}
		
	}
	
	@Override
    public void onCreate() {
		mYcApp = this;
		mBMapMan = new BMapManager(this);
		mBMapMan.init(this.mStrKey, new MyGeneralListener());
		super.onCreate();
	}
	@Override
	//建议在您app的退出之前调用mapadpi的destroy()函数，避免重复初始化带来的时间消耗
	public void onTerminate() {
		// TODO Auto-generated method stub
		if (mBMapMan != null) {
			mBMapMan.destroy();
			mBMapMan = null;
		}
		super.onTerminate();
	}
}