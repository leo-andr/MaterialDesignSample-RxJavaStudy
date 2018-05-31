package demo.test.com.testdemo.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToolsUtil {

	public static boolean isEmpty(String s) {
		if (null == s)
			return true;
		if (s.length() == 0)
			return true;
		if (s.trim().length() == 0)
			return true;
		return false;
	}

	@SuppressLint("SimpleDateFormat")
	public static Date getDateByString(String time) {
		Date date = null;
		if (time == null)
			return date;
		String date_format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(date_format);
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getShortTime(String timeString) {
		String shortstring = null;
		Date date = getDateByString(timeString);
		if (date == null)
			return shortstring;

		long now = Calendar.getInstance().getTimeInMillis();
		long deltime = (now - date.getTime()) / 1000;
		if (deltime > 365 * 24 * 60 * 60) {
			shortstring = (int) (deltime / (365 * 24 * 60 * 60)) + "年前";
		} else if (deltime > 30 * 24 * 60 * 60) {
			shortstring = (int) (deltime / (30 * 24 * 60 * 60)) + "月前";
		} else if (deltime > 24 * 60 * 60) {
			shortstring = (int) (deltime / (24 * 60 * 60)) + "天前";
		} else if (deltime > 60 * 60) {
			shortstring = (int) (deltime / (60 * 60)) + "小时前";
		} else if (deltime > 60) {
			shortstring = (int) (deltime / (60)) + "分前";
		} else if (deltime > 1) {
			shortstring = deltime + "秒前";
		} else {
			shortstring = "1秒前";
		}
		return shortstring;
	}

	/**
	 * String 转换为 Date,支持yyyy-mm-dd hh:mm:ss格式
	 * 
	 * @param timeString
	 *            时间字符串
	 * @return Date对象
	 */
	public static Date getDateFromString(String timeString) {
		Date chDate = null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			chDate = format.parse(timeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return chDate;
	}

	/**
	 * 返回“08:45 AM”格式
	 * 
	 * @param dateObject
	 *            Date对象
	 * @return
	 */
	public static String getShotStringFromDate(Date dateObject) {
		DateFormat format = new SimpleDateFormat("hh:mm a");
		return format.format(dateObject);
	}

	/**
	 * 转换日期为String【除时间】
	 * 
	 * @param dateObject
	 * @return
	 */
	public static String getDateStringFromDate(Date dateObject) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(dateObject);
	}

	/**
	 * 获得当前日期
	 * 
	 * @return
	 */
	public static String getNowDate() {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return sDateFormat.format(new Date());
	}

	/**
	 * @param dateTime
	 *            yyyy-MM-dd hh:mm格式
	 * @return 是否过期，true为已过期
	 */
	public static boolean compareToNow(String dateTime) {
		boolean isOlder = false;
		Calendar cld = Calendar.getInstance();
		final SimpleDateFormat fmt = new SimpleDateFormat();
		fmt.applyPattern("yyyy-MM-dd hh:mm");
		Date d = null;
		try {
			String alarmDateTime = dateTime;
			d = (Date) fmt.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (null != d) {
			cld.setTimeInMillis(d.getTime());
			if (cld.getTimeInMillis() < System.currentTimeMillis()) {
				isOlder = true;
			}
		}
		return isOlder;
	}

	@SuppressLint({ "UseValueOf", "SimpleDateFormat" })
	public static String timeTick2Date(long timeTick) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(timeTick);
		String d = format.format(time);
		// Date date = format.parse(d);
		return d;
	}

	@SuppressLint({ "UseValueOf", "SimpleDateFormat" })
	public static String timeTick2DateNotSec(long timeTick) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Long time = new Long(timeTick);
		String d = format.format(time);
		// Date date = format.parse(d);
		return d;
	}

	@SuppressLint({ "UseValueOf", "SimpleDateFormat" })
	public static String timeTick2DateForShow(long timeTick) {
		SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
		Long time = new Long(timeTick);
		String d = format.format(time);
		// Date date = format.parse(d);
		return d;
	}

	@SuppressLint({ "UseValueOf", "SimpleDateFormat" })
	public static String timeTick2DateOnly(long timeTick) {
		SimpleDateFormat format = new SimpleDateFormat("MM-dd");
		Long time = new Long(timeTick);
		String d = format.format(time);
		// Date date = format.parse(d);
		return d;
	}

	@SuppressLint({ "UseValueOf", "SimpleDateFormat" })
	public static String timeTick2String(long timeTick) {
		SimpleDateFormat format = new SimpleDateFormat("HH小时mm分钟ss秒");
		Long time = new Long(timeTick);
		String d = format.format(time);
		// Date date = format.parse(d);
		return d;
	}

	/**
	 * 个位左边补0
	 * 
	 * @param t
	 * @return
	 */
	public static String get2TimeFormat(int t) {
		return (t > 9) ? "" + t : "0" + t;
	}

	/**
	 * 显示对话框
	 * 
	 * @param context
	 * @param title
	 * @param content
	 * @param leftString
	 * @param leftOnClickListener
	 * @param rightString
	 * @param rightOnClickListener
	 */
	public static void showDialog(
			Context context,
			String title,
			String content,
			String leftString,
			DialogInterface.OnClickListener leftOnClickListener,
			String rightString,
			DialogInterface.OnClickListener rightOnClickListener) {
		Builder builder = new Builder(context);
		builder.setMessage(content);
		builder.setTitle(title);

		if (leftOnClickListener == null) {
			leftOnClickListener = new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			};
		}
		if (rightOnClickListener == null) {
			rightOnClickListener = new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			};
		}
		builder.setPositiveButton(leftString, leftOnClickListener);
		builder.setNegativeButton(rightString, rightOnClickListener);
		builder.create().show();
	}

	/**
	 * 输入框弹或收起
	 * 
	 */
	public static void onFocusChange(final TextView tv, final boolean isShow) {
		tv.requestFocus();
		(new Handler()).postDelayed(new Runnable() {
			public void run() {
				InputMethodManager imm = (InputMethodManager) tv.getContext()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				if (isShow) {
					imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
				} else {
					imm.hideSoftInputFromWindow(tv.getWindowToken(), 0);
				}
			}
		}, 100);
	}

	/**
	 * 判断是否在控件内
	 * 
	 * @param view
	 * @param rx
	 * @param ry
	 * @return
	 */
	public static boolean isViewContains(View view, int rx, int ry) {
		int[] l = new int[2];
		view.getLocationOnScreen(l);
		Rect rect = new Rect(l[0], l[1], l[0] + view.getWidth(), l[1]
				+ view.getHeight());
		return rect.contains(rx, ry);
	}

	/**
	 * 文件夹中查找文件
	 * 
	 * @param fPath
	 * @param fileName
	 */
	public static boolean findFileInFolder(String fPath, String fileName) {
		boolean retv = false;
		File file = new File(fPath);
		if (file.exists()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				if (file2.isDirectory()) {
					Log.e("文件夹","文件夹:" + file2.getAbsolutePath());
				} else {

					if (file2.getName().equals(fileName)) {
						// 找到
						retv = true;
						break;
					}
				}
			}
		} else {
			Log.e("文件夹","文件不存在!");
		}
		return retv;
	}

	/**
	 * 写入文件
	 * 
	 * @param filePath
	 * @param fileDatas
	 * @return
	 */
	public static boolean writeFile(String filePath, byte[] fileDatas) {
		boolean retv = false;
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(filePath);
			try {
				outputStream.write(fileDatas);
				outputStream.flush();
				retv = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retv;
	}

	// public static String file2B64String(File file) throws Exception {
	// byte[] buffer = null;
	// FileInputStream inputStream = new FileInputStream(file);
	//
	// ByteArrayOutputStream outputStream = new
	// ByteArrayOutputStream(inputStream.available());
	// byte[] by = new byte[1024];
	// int len = 0;
	// while ((len = inputStream.read(by)) != -1) {
	// outputStream.write(by, 0, len);
	// }
	// buffer = outputStream.toByteArray();
	// outputStream.close();
	// inputStream.close();
	// return Base64.encode(buffer);
	//
	// }

	// 把字符串转为日期
	public static Date ConverToDate(String strDate) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.parse(strDate);
	}

//	public static String getFieString(Bitmap mIconBitmap) {
//		String fileString;
//		/**
//		 * 下面注释的方法是将裁剪之后的图片以Base64Coder的字符方式上 传到服务器
//		 */
//		ByteArrayOutputStream stream = new ByteArrayOutputStream();
//		mIconBitmap.compress(Bitmap.CompressFormat.JPEG, 60, stream);
//		byte[] b = stream.toByteArray();
//		// 将图片流以字符串形式存储下来
//		fileString = new String(
//				org.apache.commons.codec.binary.Base64.encodeBase64(b));
//			// module	#android	#useLibrary 'org.apache.http.legacy'
//		return fileString;
//	}

	/**
	 * 我国当前的身份证号分为三种： 一、15位身份证号 二、18位身份证号（前17位位数字，最后一位为字母x） 三、18为身份证号（18位都是数字）
	 * 验证身份证号是否符合规则
	 * 
	 * @param text
	 *            身份证号
	 * @return
	 */
	public static boolean personIdValidation(String text) {
		String regx = "[0-9]{17}x";
		String reg1 = "[0-9]{15}";
		String regex = "[0-9]{18}";
		return text.matches(regx) || text.matches(reg1) || text.matches(regex);
	}

	// 判断手机格式是否正确
	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	// 字符串有多少个指定字符
	public static int getSubCount(String str, String key) {
		int count = 0;
		int index = 0;
		while ((index = str.indexOf(key, index)) != -1) {
			str = str.substring(index + key.length());
			count++;
		}
		return count;
	}

	// 注册时所用密码规范
	public static boolean isPassword(String password) {
		/**
		 * 1.6-16位 2.允许数字+英文+符号 3.数字0-9 4.英文a-z 5.符号 !@#$%^&*_()+-为以上符号；
		 * 6.密码内要包含 数字+英文 或者 数字+符号 或者 英文+符号三种组合；
		 */
		Pattern p = Pattern
				.compile("^(?![a-zA-Z]+$)(?!\\d+$)(?![!@#$%^&*_()+-]+$)[a-zA-Z\\d!@#$%^&*_()+-]{6,16}$");
		Matcher m = p.matcher(password);
		return m.matches();
	}

	// 邮箱的规范
	public static boolean isMail(String email) {
		/**
		 * 1.6-16位 2.允许数字+英文+符号 3.数字0-9 4.英文a-z 5.符号 !@#$%^&*_()+-为以上符号；
		 * 6.密码内要包含 数字+英文 或者 数字+符号 或者 英文+符号三种组合；
		 */
		Pattern p = Pattern
				.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher m = p.matcher(email);
		return m.matches();
	}

	// 校验Tag Alias 只能是数字,英文字母和中文
	public static boolean isValidTagAndAlias(String s) {
		Pattern p = Pattern.compile("^[\u4E00-\u9FA50-9a-zA-Z_-]{0,}$");
		Matcher m = p.matcher(s);
		return m.matches();
	}

	public static boolean isConnected(Context context) {
		ConnectivityManager conn = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = conn.getActiveNetworkInfo();
		return (info != null && info.isConnected());
	}

	/**
	 * 判断应用是否已经启动
	 * 
	 * @param context
	 *            一个context
	 * @param packageName
	 *            要判断应用的包名
	 * @return boolean
	 */
	public static boolean isAppAlive(Context context, String packageName) {
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningAppProcessInfo> processInfos = activityManager
				.getRunningAppProcesses();
		for (int i = 0; i < processInfos.size(); i++) {
			if (processInfos.get(i).processName.equals(packageName)) {
				Log.e("要判断应用的包名", String.format(
						"the %s is running, isAppAlive return true",
						packageName));
				return true;
			}
		}
		Log.e("要判断应用的包名", String.format(
				"the %s is not running, isAppAlive return false", packageName));
		return false;
	}

	/**
	 * 返回app运行状态 1:程序在前台运行 2:程序在后台运行 3:程序未启动 注意：需要配置权限<uses-permission
	 * android:name="android.permission.GET_TASKS" />
	 */

	public static int getAppSatus(Context context, String pageName) {

		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(20);

		// 判断程序是否在栈顶
		if (list.get(0).topActivity.getPackageName().equals(pageName)) {
			return 1;
		} else {
			// 判断程序是否在栈里
			for (ActivityManager.RunningTaskInfo info : list) {
				if (info.topActivity.getPackageName().equals(pageName)) {
					return 2;
				}
			}
			return 3;// 栈里找不到，返回3
		}
	}

	public static String getMoney(Double money){
		String moneyReturn = "";
		DecimalFormat df = new DecimalFormat("######0.00");
		moneyReturn = df.format(money);
		return moneyReturn;

	}

}
