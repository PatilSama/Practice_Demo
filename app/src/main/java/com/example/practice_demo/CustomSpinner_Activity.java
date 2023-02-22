package com.example.practice_demo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class CustomSpinner_Activity extends AppCompatActivity {
    int flag[] = {R.drawable.american,R.drawable.china,R.drawable.india};
    String country[] = {"America","China","India"};
    Spinner simpleSpinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customspinner_layout);
        simpleSpinner = findViewById(R.id.simpleSpinner);

        simpleSpinner.setAdapter(new CustomAdapter(getApplicationContext(),flag,country));
    }
}

class CustomAdapter extends BaseAdapter
{
    Context context;
    int[] flag;
    String[] country;
    public CustomAdapter(Context context,int[] flag,String[] country)
    {
        this.context = context;
        this.country = country;
        this.flag = flag;
    }
    @Override
    public int getCount() {
        return flag.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.customspinner_item_layout,null);
        ImageView icon = (ImageView) convertView.findViewById(R.id.imageView);
        TextView names = (TextView) convertView.findViewById(R.id.textView);
        icon.setImageResource(flag[position]);
        names.setText(country[position]);
        names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+country[position], Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}

