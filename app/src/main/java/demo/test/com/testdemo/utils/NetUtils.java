package demo.test.com.testdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

import demo.test.com.testdemo.MyApplication;

/**
 * @author fangwenjiao
 * @date 20152015年12月22日
 * @version
 * @description 网络连接状况
 */
public class NetUtils {
	/**
	 * WIFI的状态 Description
	 */
	public static boolean isWifiEnabled() {
		Context myContext = MyApplication.getAppContext();
		WifiManager wifiMgr = (WifiManager) myContext.getSystemService(Context.WIFI_SERVICE);
		if (wifiMgr.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
			ConnectivityManager connManager = (ConnectivityManager) myContext
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo wifiInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			return wifiInfo.isConnected();
		} else {
			return false;
		}
	}

	// 判断网络是否连接
	public static boolean isNetworkAvailable() {
		Context context = MyApplication.getAppContext();
		ConnectivityManager mConnectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
		if (mNetworkInfo != null) {
			return mNetworkInfo.isAvailable();
		}

		return false;
	}

//	/**
//	 * 此方法仅仅 WIFI--4g 同步相册 使用
//	 */
//	public static boolean isWifiEnabled() {
//		Context myContext = MyApplication.getAppContext();
//		ConnectivityManager connManager = (ConnectivityManager) myContext
//				.getSystemService(Context.CONNECTIVITY_SERVICE);
//		NetworkInfo wifiInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//		return wifiInfo.isConnected()||isNetworkAvailable();// TODO  加入4g同步后，有4g网页也返回true
//	}

}
