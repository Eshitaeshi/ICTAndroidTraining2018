package com.example.alpha.class4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    String[] nameOf;
    int[] imgOf;
    Context lContext;
    public static LayoutInflater inflater = null;

    public CustomAdapter(MainActivity mainActivity, String[] name, int[] img) {

        nameOf = name;
        imgOf = img;
        lContext = mainActivity;
        inflater = (LayoutInflater) lContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return nameOf.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyHolder {
        TextView textView;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomAdapter.MyHolder myHolder = new CustomAdapter.MyHolder();
        View myview;
        myview = inflater.inflate(R.layout.list, null);
        myHolder.textView = myview.findViewById(R.id.lst_txt);
        myHolder.imageView = myview.findViewById(R.id.lst_im);

        myHolder.textView.setText(nameOf[position]);
        myHolder.imageView.setImageResource(imgOf[position]);

        return myview;
    }
}
