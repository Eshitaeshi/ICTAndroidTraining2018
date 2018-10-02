package com.example.alpha.class6_project;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lst);

        String[] names = {"Bangladesh", "Germany", "Canada", "Japan", "Korea", "China"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list,R.id.lst_txt,
                names);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment_bd, fragment_ger;

        if (position == 0) {
            fragment_bd = new BDFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fgt_bd, fragment_bd).commit();
        } if (position == 1){
            fragment_ger = new gerFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fgt_ger, fragment_ger).commit();
        }
    }
}
