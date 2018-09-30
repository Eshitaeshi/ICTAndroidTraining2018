package com.example.alpha.class4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list_id);

        final int[] imgs = {R.drawable.ic_view_list_black_24dp, R.drawable.ic_wallpaper_black_24dp,
                            R.drawable.ic_visibility_black_24dp, R.drawable.ic_wb_auto_black_24dp,
                            R.drawable.ic_view_list_black_24dp, R.drawable.ic_wallpaper_black_24dp,
                            R.drawable.ic_visibility_black_24dp, R.drawable.ic_wb_auto_black_24dp,
                            R.drawable.ic_view_list_black_24dp, R.drawable.ic_wallpaper_black_24dp,
                            R.drawable.ic_visibility_black_24dp, R.drawable.ic_wb_auto_black_24dp,
                            R.drawable.ic_view_list_black_24dp, R.drawable.ic_wallpaper_black_24dp,
                            R.drawable.ic_visibility_black_24dp, R.drawable.ic_wb_auto_black_24dp};
        final String[] names = {"This", "That", "Who", "Whom", "This", "That", "Who", "Whom",
                                "This", "That", "Who", "Whom", "This", "That", "Who", "Whom",};

        /*ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list, R.id.lst_txt, names);

        list.setAdapter(adapter);
        */
        CustomAdapter adapter = new CustomAdapter(this, names, imgs);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked on "+names[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
