package demo.test.com.testdemo.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {
    /*PermissionUtils.with(this)
            .addPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .addPermission(Manifest.permission.READ_PHONE_STATE)
                .initPermission().size();
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                String permission = permissions[i];
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    String msg;
                    switch (permission) {
                        case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                            msg = "无法获取到手机存储权限";
                            break;
                        case Manifest.permission.READ_PHONE_STATE:
                            msg = "无法读取到手机唯一标识码";
                            break;
                        default:
                            msg = String.format("请开启%s所需要的权限", getString(R.string.app_name));
                            break;
                    }
                    CommenUtils.showToast(MyApplication.getAppContext(), msg);
                    finish();
                    MyApplication.finishActivity();
                    return;
                }
            }
            init();
        }
    }*/

    public static PermissionUtils.Builder with(Activity activity) {
        return new Builder(activity);
    }

    public static class Builder {

        private Activity mActivity;
        private List<String> permissionList;

        public Builder(@NonNull Activity activity) {
            mActivity = activity;
            permissionList = new ArrayList<>();
        }


        public Builder addPermission(@NonNull String permission) {
            if (!permissionList.contains(permission)) {
                permissionList.add(permission);
            }
            return this;
        }

        public List<String> initPermission() {
            List<String> list = new ArrayList<>();
            for (String permission : permissionList) {
                if (ActivityCompat.checkSelfPermission(mActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                    list.add(permission);
                }
            }
            if (list.size() > 0) {
                ActivityCompat.requestPermissions(mActivity, list.toArray(new String[list.size()]), 1);
            }
            return list;
        }

    }
}
