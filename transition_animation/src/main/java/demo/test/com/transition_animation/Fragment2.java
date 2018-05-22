package demo.test.com.transition_animation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author lipiao
 * @data 2018/5/22.
 * @description 描述
 */
public class Fragment2 extends Fragment {

    public static Fragment2 newInstance() {
        return new Fragment2();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }
}
