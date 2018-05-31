package demo.test.com.testdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author 吴克峤
 * @date 20152015年12月23日
 * @version
 * @description 首选项的工具类
 */
public class SPUtil {

	private static SharedPreferences sp;

	private static SharedPreferences getSharedPreferences(Context context) {
		if (sp == null) {
			sp = context.getSharedPreferences("user", Context.MODE_PRIVATE);
		}
		return sp;
	}

	/**
	 * 从首选项中获取int值,默认值为0
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static int getInt(Context context, String key) {
		SharedPreferences sp = getSharedPreferences(context);
		int result = sp.getInt(key, 0);
		return result;
	}

	public static int getInt(Context context, String key, int defValue) {
		SharedPreferences sp = getSharedPreferences(context);
		int result = sp.getInt(key, defValue);
		return result;
	}

	/**
	 * 从首选项中获取String值,默认值为null
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static String getString(Context context, String key) {
		SharedPreferences sp = getSharedPreferences(context);
		String result = sp.getString(key, null);
		return result;
	}

	/**
	 * 从首选项中获取boolean值,默认值为false
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Context context, String key) {
		SharedPreferences sp = getSharedPreferences(context);
		boolean result = sp.getBoolean(key, false);
		return result;
	}

	/**
	 * 向首选项中存储数据(仅限于String,int,boolean三种数据类型)
	 *
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void put(Context context, String key, Object value) {
		SharedPreferences sp = getSharedPreferences(context);
		Editor editor = sp.edit();
		if (value instanceof String) {
			editor.putString(key, (String) value);
		} else if (value instanceof Integer) {
			editor.putInt(key, (Integer) value);
		} else if (value instanceof Boolean) {
			editor.putBoolean(key, (Boolean) value);
		}
		editor.commit();
	}
	/**
	 * 储存list<String>集合
	 * Description
	 */
//	public static void putList(Context context , String key, List<String> list){
//		Gson gson = new Gson();
//		String json = gson.toJson(list);
//		SharedPreferences sharedPreferences = getSharedPreferences(context);
//		SharedPreferences.Editor  editor = sharedPreferences.edit();
//		editor.putString(key,json);
//		editor.commit();
//	}
//
//	public static List<String> getList(Context context, String key){
//		List<String> list =new ArrayList<String>();
//		SharedPreferences sharedPreferences = getSharedPreferences(context);
//		String jsondata = sharedPreferences.getString(key, "null");
//		Gson gson = new Gson();
//		if (!jsondata.equals("null")) {
//			list = gson.fromJson(jsondata, new TypeToken<List<String>>() {}.getType());
//		}
//		return list;
//	}

	/**
	 * 把设备的通讯录信息缓存到Sp文件中
	 */
	public static void putPhoneBook(Context context, String phonebook, String key){
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		SharedPreferences.Editor  editor = sharedPreferences.edit();
		editor.putString(key,phonebook);
		editor.commit();
	}

	public static String getPhoneBook(Context context, String key){
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		String jsondata = sharedPreferences.getString(key, "null");
		return jsondata;
	}

	/**
	 * 用户热度推送
	 */
	public static void RecodeMsg(Context context, String msgId){
		SharedPreferences sharedPreferences = context.getSharedPreferences("msgsetting", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("processMsg"+msgId,msgId);
		editor.commit();
	}

	public static void SetMsgBell(Context context, boolean isbell){
		SharedPreferences sharedPreferences = context.getSharedPreferences("msgsetting", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putBoolean("isbell",isbell);
		editor.commit();
	}

	public static void SetMsgShcok(Context context, boolean isshock){
		SharedPreferences sharedPreferences = context.getSharedPreferences("msgsetting", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putBoolean("isshock",isshock);
		editor.commit();
	}

	public static boolean getMsgBell(Context context){
		SharedPreferences sharedPreferences= context.getSharedPreferences("msgsetting",
				Context.MODE_PRIVATE);
		boolean isBell = sharedPreferences.getBoolean("isbell",true);
		return isBell;
	}

	public static boolean getMsgShock(Context context){
		SharedPreferences sharedPreferences= context.getSharedPreferences("msgsetting",
				Context.MODE_PRIVATE);
		boolean isShock = sharedPreferences.getBoolean("isshock",true);
		return isShock;
	}
}
