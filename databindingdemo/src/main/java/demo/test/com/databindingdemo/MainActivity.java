package demo.test.com.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import demo.test.com.databindingdemo.databinding.ActivityMainBinding;


/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

         book = new Book("李漂", 13);
        mainBinding.setBook(book);
        mainBinding.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了~~~tv2", Toast.LENGTH_SHORT).show();
                book.setPage(23);
            }
        });
        mainBinding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了~~~btn1", Toast.LENGTH_SHORT).show();
                book.setPage(23);
            }
        });

    }
}
