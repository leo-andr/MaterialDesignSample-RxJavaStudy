package demo.test.com.transition_animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author lipiao
 * @data 2018/5/22.
 * @description 描述
 */
public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void toMain5(View view) {
        startActivity(new Intent(this, Main5Activity.class));
    }

    public void toMain1(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
