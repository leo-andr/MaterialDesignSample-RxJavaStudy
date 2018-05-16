package demo.test.com.headstretchablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private MyListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, new String[]{
                "张三","李四","王五","赵六","田七"/*, "张三","李四","王五","赵六","田七"*/
        });

        View headerView = View.inflate(this, R.layout.header_listview, null);

        ImageView imageView = headerView.findViewById(R.id.iv);
        listView.setZoneImageView(imageView);
        listView.addHeaderView(headerView);
        listView.setAdapter(arrayAdapter);



    }
}
