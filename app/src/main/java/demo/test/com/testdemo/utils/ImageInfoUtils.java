package demo.test.com.testdemo.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;


import java.util.ArrayList;

import demo.test.com.testdemo.MyApplication;

/**
 * @version 读取手机所有图片工具类
 */
public class ImageInfoUtils {
    // 获取图片的信息
    public ArrayList<ImageInfo> getAllImagePath(int page) {
        ArrayList<ImageInfo> list_img = new ArrayList<ImageInfo>();
        ContentResolver resolver = MyApplication.getInstance().getContentResolver();
        Cursor cursor = resolver.query(Media.EXTERNAL_CONTENT_URI, null,
                null, null, MediaStore.Images.Media._ID + " DESC");
        Loader<Cursor> loader = new Loader<>(MyApplication.getAppContext());
        if (loader.getId() == 0) {
//				cursor.moveToFirst();
            cursor.moveToPosition((page - 1) * 21);
            while (true) {
                if (cursor.isAfterLast())
                    break;
                String DISPLAY_NAME = cursor.getString(cursor.getColumnIndex(Media.DISPLAY_NAME));
                String _ID = cursor.getString(cursor.getColumnIndex(Media._ID));
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(_ID).build();
                String path = ImageUntils.getPath(MyApplication.getAppContext(), uri);
                String size = cursor.getString(cursor.getColumnIndex(Media.SIZE));
                String MIME_TYPE = cursor.getString(cursor.getColumnIndex(Media.MIME_TYPE));
                Log.e("fwj", "DISPLAY_NAME:" + DISPLAY_NAME); // 图片名
                Log.e("fwj", "_ID:" + _ID);
                Log.e("fwj", "uri:" + uri); // 图片路径
                Log.e("fwj", "size:" + size); // 图片大小
                Log.e("fwj", "MIME_TYPE:" + MIME_TYPE); // 图片格式
                Log.e("fwj", "path:" + path); // 图片路径
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setId(_ID);
                imageInfo.setName(DISPLAY_NAME);
                imageInfo.setPath(uri.toString());
                imageInfo.setSize(size);
                imageInfo.setUri(uri);
                list_img.add(imageInfo);
                cursor.moveToNext();
                if (list_img.size() == 21) {
                    break;
                }
            }
            cursor.close();
        }
        Log.e("fwj", "list_img.size():" + list_img.size()); // 图片路径
        return list_img;
    }

    public ArrayList<ImageInfo> getAllImagePath() {
        ArrayList<ImageInfo> list_img = new ArrayList<ImageInfo>();
        ContentResolver resolver = MyApplication.getInstance().getContentResolver();
        Cursor cursor = resolver.query(Media.EXTERNAL_CONTENT_URI, null, null,
                null, MediaStore.Images.Media._ID + " DESC");
        Loader<Cursor> loader = new CursorLoader(MyApplication.getAppContext(),
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null,
                null, null);
        if (loader.getId() == 0) {
            cursor.moveToFirst();
            while (true) {
                if (cursor.isAfterLast())
                    break;
                String DISPLAY_NAME = cursor.getString(cursor.getColumnIndex(Media.DISPLAY_NAME));
                String _ID = cursor.getString(cursor.getColumnIndex(Media._ID));
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().appendPath(_ID).build();
                String path = ImageUntils.getPath(MyApplication.getAppContext(), uri);
                String size = cursor.getString(cursor.getColumnIndex(Media.SIZE));
                String MIME_TYPE = cursor.getString(cursor.getColumnIndex(Media.MIME_TYPE));
                Log.e("fwj", "DISPLAY_NAME:" + DISPLAY_NAME); // 图片名
                Log.e("fwj", "_ID:" + _ID);
                Log.e("fwj", "uri:" + uri); // 图片路径
                Log.e("fwj", "size:" + size); // 图片大小
                Log.e("fwj", "MIME_TYPE:" + MIME_TYPE); // 图片格式
                Log.e("fwj", "path:" + path); // 图片路径
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setId(_ID);
                imageInfo.setName(DISPLAY_NAME);
                imageInfo.setPath(uri.toString());
                imageInfo.setSize(size);
                imageInfo.setUri(uri);
                list_img.add(imageInfo);
                cursor.moveToNext();
            }
            cursor.close();
        }
        Log.e("fwj", "list_img.size():" + list_img.size()); // 图片路径
        return list_img;
    }

    class ImageInfo {
        public String id; // ID
        public String name; // 名称
        public String size; // 大小
        public String path; // 路径
        public Uri uri; // 统一资源标识符
        public String date_added; // 图片存储到手机中的时间
        public String mime_type; // 图片的扩展名
        public String title; // 不带扩展名的图片名

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getMime_type() {
            return mime_type;
        }

        public void setMime_type(String mime_type) {
            this.mime_type = mime_type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Uri getUri() {
            return uri;
        }

        public void setUri(Uri uri) {
            this.uri = uri;
        }

    }
}
