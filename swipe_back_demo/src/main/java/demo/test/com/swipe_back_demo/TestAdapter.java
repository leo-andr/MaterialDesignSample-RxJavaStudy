package demo.test.com.swipe_back_demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TestAdapter extends FragmentPagerAdapter {

    public TestAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        switch (arg0) {
            case 0:
                return TestFragment.newInstance("1");
            case 1:
                return TestFragment.newInstance("2");
            case 2:
                return TestFragment.newInstance("3");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
