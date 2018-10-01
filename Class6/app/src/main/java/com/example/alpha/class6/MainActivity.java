package com.example.alpha.class6;

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
        final String[] names = {"This", "That", "Who", "Whom", "This", "That", "Who", "Whom",
                "This", "That", "Who", "Whom", "This", "That", "Who", "Whom"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list, R.id.uy, names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment;

        if (position == 0) {
            fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frg, fragment).commit();
        } if (position == 1){
            Toast.makeText(this, "Text", Toast.LENGTH_SHORT).show();
        }
    }
}
