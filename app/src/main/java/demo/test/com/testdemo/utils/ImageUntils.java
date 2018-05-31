package demo.test.com.testdemo.utils;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author fangwenjiao
 * @date 20152015年12月16日
 * @version
 * @description 图片工具类
 */
public class ImageUntils {
	/**
	 * 根据图片返回的url 获取路径
	 * 
	 * @param context
	 * @param uri
	 * @return
	 */
	@SuppressLint("NewApi")
	public static String getPath(final Context context, final Uri uri) {
		final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
		if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
			if (isExternalStorageDocument(uri)) {
				final String docId = DocumentsContract.getDocumentId(uri);
				final String[] split = docId.split(":");
				final String type = split[0];

				if ("primary".equalsIgnoreCase(type)) {
					return Environment.getExternalStorageDirectory() + "/" + split[1];
				}
			} else if (isDownloadsDocument(uri)) {
				final String id = DocumentsContract.getDocumentId(uri);
				final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),
						Long.valueOf(id));
				return getDataColumn(context, contentUri, null, null);
			} else if (isMediaDocument(uri)) {
				final String docId = DocumentsContract.getDocumentId(uri);
				final String[] split = docId.split(":");
				final String type = split[0];
				Uri contentUri = null;
				if ("image".equals(type)) {
					contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
				} else if ("video".equals(type)) {
					contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
				} else if ("audio".equals(type)) {
					contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
				}
				final String selection = "_id=?";
				final String[] selectionArgs = new String[] { split[1] };
				return getDataColumn(context, contentUri, selection, selectionArgs);
			}
		} else if ("content".equalsIgnoreCase(uri.getScheme())) {
			if (isGooglePhotosUri(uri))
				return uri.getLastPathSegment();
			return getDataColumn(context, uri, null, null);
		} else if ("file".equalsIgnoreCase(uri.getScheme())) {
			return uri.getPath();
		}
		return null;
	}

	/**
	 * bitmap转为base64
	 * 
	 * @param bitmap
	 * @return
	 */
	public static String bitmapToBase64(Bitmap bitmap) {

		String result = null;
		ByteArrayOutputStream baos = null;
		try {
			if (bitmap != null) {
				baos = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
				baos.flush();
				baos.close();
				byte[] bitmapBytes = baos.toByteArray();
				result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (baos != null) {
					baos.flush();
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 从本地取图片(在cdcard中获取)
	 *
	 * @param url
	 * @return
	 */
	public static Bitmap getLoacalBitmap(String url) {
		File file = new File(url);
		Bitmap bms = null;
		if (file.exists()) {
			BitmapFactory.Options options = new BitmapFactory.Options();
			// 下面这个设置是将图片边界不可调节变为可调节
			options.inJustDecodeBounds = true;
			options.inSampleSize = 5;
			float imagew = 600;
			float imageh = 800;
			int yRatio = (int) Math.ceil(options.outHeight / imageh);
			int xRatio = (int) Math.ceil(options.outWidth / imagew);
			if (yRatio > 1 || xRatio > 1) {
				if (yRatio > xRatio) {
					options.inSampleSize = yRatio;
				} else {
					options.inSampleSize = xRatio;
				}
			}
			options.inJustDecodeBounds = false;
			bms = BitmapFactory.decodeFile(url, options);
		}
		return bms;
	}

	/**
	 * 压缩图片
	 *
	 * @param image
	 *
	 * @return
	 */
	public static Bitmap compBitmap(Bitmap image) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		Log.e("原图", "大小kb：" + (baos.toByteArray().length / 1024));
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		float hh = 480f;
		float ww = 320f;
		int be = 1;// be=1表示不缩放
		if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;// 设置缩放比例
		// 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
		isBm = new ByteArrayInputStream(baos.toByteArray());
		bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		try {
			baos.close();
			isBm.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compressImage(bitmap);// 压缩好比例大小后再进行质量压缩
	}

	/**
	 * 压缩图片
	 *
	 * @param inputStream
	 * @return
	 */
	public static Bitmap compBitmap(InputStream inputStream) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		try {
			while ((len = inputStream.read(buffer)) > -1) {
				baos.write(buffer, 0, len);
			}
			baos.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Log.e("原图", "大小kb：" + (baos.toByteArray().length / 1024));
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		newOpts.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		newOpts.inJustDecodeBounds = false;
		int w = newOpts.outWidth;
		int h = newOpts.outHeight;
		DisplayMetrics metrics = new DisplayMetrics();
		float hh =  metrics.heightPixels;
		float ww = metrics.widthPixels;
		int be = 1;// be=1表示不缩放
		if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
			be = (int) (newOpts.outWidth / ww);
		} else if (w < h && h > hh) {// 如果高度高的话根据宽度固定大小缩放
			be = (int) (newOpts.outHeight / hh);
		}
		if (be <= 0)
			be = 1;
		newOpts.inSampleSize = be;// 设置缩放比例
		Log.e("原图", "压缩比例：" + newOpts.inSampleSize);
		// 重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
		isBm = new ByteArrayInputStream(baos.toByteArray());
		Log.e("fuyao","图片大小+++=="+baos.toByteArray().length/1024);
		if (baos.toByteArray().length / 1024 > 1024 * 0.5) {
			bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
		} else {
			bitmap = BitmapFactory.decodeStream(isBm);
		}
		try {
			baos.close();
			isBm.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.e("fuyao","Imageutils 设置好比例");
		return bitmap;// 压缩好比例大小后再进行质量压缩
	}

	/**
	 * 将bitmap转换成base64字符串
	 *
	 * @param bitmap
	 * @return base64 字符串
	 */

	public static String bitmaptoString(Bitmap bitmap, int bitmapQuality) {

		// 将Bitmap转换成字符串
		String string = null;
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, bitmapQuality, bStream);
		byte[] bytes = bStream.toByteArray();
		string = Base64.encodeToString(bytes, Base64.DEFAULT);
		return string;

	}

	/**
	 * 质量压缩 大于1M继续压缩
	 *
	 * @param image
	 * @return
	 */
	public static Bitmap compressImage(Bitmap image) {
		Log.e("原图", "fsdfdsfsdfsdfsdfsdfsd");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);
		try {
			baos.close();
			isBm.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bitmap;
	}

	/**
	 * @param uri
	 *            The Uri to check.
	 * @return Whether the Uri authority is ExternalStorageProvider.
	 */
	public static boolean isExternalStorageDocument(Uri uri) {
		return "com.android.externalstorage.documents".equals(uri.getAuthority());
	}

	/**
	 * @param uri
	 *            The Uri to check.
	 * @return Whether the Uri authority is DownloadsProvider.
	 */
	public static boolean isDownloadsDocument(Uri uri) {
		return "com.android.providers.downloads.documents".equals(uri.getAuthority());
	}

	/**
	 * @param uri
	 *            The Uri to check.
	 * @return Whether the Uri authority is MediaProvider.
	 */
	public static boolean isMediaDocument(Uri uri) {
		return "com.android.providers.media.documents".equals(uri.getAuthority());
	}

	/**
	 * @param uri
	 *            The Uri to check.
	 * @return Whether the Uri authority is Google Photos.
	 */
	public static boolean isGooglePhotosUri(Uri uri) {
		return "com.google.android.apps.photos.content".equals(uri.getAuthority());
	}

	/**
	 * Get the value of the data column for this Uri. This is useful for
	 * MediaStore Uris, and other file-based ContentProviders.
	 *
	 * @param context
	 *            The context.
	 * @param uri
	 *            The Uri to query.
	 * @param selection
	 *            (Optional) Filter used in the query.
	 * @param selectionArgs
	 *            (Optional) Selection arguments used in the query.
	 * @return The value of the _data column, which is typically a file path.
	 */
	public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {

		Cursor cursor = null;
		final String column = "_data";
		final String[] projection = { column };

		try {
			cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
			if (cursor != null && cursor.moveToFirst()) {
				final int index = cursor.getColumnIndexOrThrow(column);
				return cursor.getString(index);
			}
		} finally {
			if (cursor != null)
				cursor.close();
		}
		return null;
	}

	/**
	 * bitmap保存为文件
	 *
	 * @param bitmap
	 * @param path
	 *            存储图片路径
	 * @return
	 * @throws IOException
	 */
	public static String saveMyBitmap(Bitmap bitmap, String path) {
		String newfile = path + "/" + System.currentTimeMillis() + ".jpg";
		File f = new File(path);
		if (f.exists())
			f.mkdirs();
		FileOutputStream fOut = null;
		File myfile = null;
		try {
			myfile = new File(newfile);
			myfile.createNewFile();
			fOut = new FileOutputStream(myfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
		try {
			fOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		try {
			fOut.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return myfile.toString();
	}

	/**
	 * 检查字符串是否null
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isEmpty(String text) {
		if (text == null || text.equals("") || text.equals("null"))
			return true;
		return false;
	}


	/**
	 * 根据图片原始路径获取图片缩略图
	 *
	 * @param imagePath 图片原始路径
	 * @param width		缩略图宽度
	 * @param height	缩略图高度
	 * @return
	 */
	public static Bitmap getImageThumbnail(String imagePath, int width,
                                           int height) {
		Bitmap bitmap = null;
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;//不加载直接获取Bitmap宽高
		// 获取这个图片的宽和高，注意此处的bitmap为null
		bitmap = BitmapFactory.decodeFile(imagePath, options);
		if(bitmap == null){
			// 计算缩放比
			int h = options.outHeight;
			int w = options.outWidth;
			Log.i("test", "optionsH"+h+"optionsW"+w);
			int beWidth = w / width;
			int beHeight = h / height;
			int rate = 1;
			if (beWidth < beHeight) {
				rate = beWidth;
			} else {
				rate = beHeight;
			}
			if (rate <= 0) {//图片实际大小小于缩略图,不缩放
				rate = 1;
			}
			options.inSampleSize = rate;
			options.inJustDecodeBounds = false;
			// 重新读入图片，读取缩放后的bitmap，注意这次要把options.inJustDecodeBounds 设为 false
			bitmap = BitmapFactory.decodeFile(imagePath, options);
			// 利用ThumbnailUtils来创建缩略图，这里要指定要缩放哪个Bitmap对象
			bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
					ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
		}
		return bitmap;
	}

}
