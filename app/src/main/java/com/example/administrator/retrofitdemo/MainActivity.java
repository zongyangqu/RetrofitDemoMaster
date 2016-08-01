package com.example.administrator.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.administrator.retrofitdemo.adapter.ListViewAdapter;
import com.example.administrator.retrofitdemo.ui.DynamicParameterActivity;
import com.example.administrator.retrofitdemo.ui.DynamicParameterMapActivity;
import com.example.administrator.retrofitdemo.ui.FixedParameterActivity;
import com.example.administrator.retrofitdemo.ui.POSTFieldActivity;
import com.example.administrator.retrofitdemo.ui.POSTFieldMapActivity;
import com.example.administrator.retrofitdemo.ui.URLReplaceActivity;


public class MainActivity extends AppCompatActivity{
    private ListView listView;
    private ListViewAdapter adapter;
    private String[] retrofitnames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        retrofitnames = getResources().getStringArray(R.array.retrofitnames);
        adapter = new ListViewAdapter(this,retrofitnames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){//固定查询参数(URL)
                    startActivity(new Intent(MainActivity.this, FixedParameterActivity.class));
                }else if(position == 1){//动态参数
                    startActivity(new Intent(MainActivity.this, DynamicParameterActivity.class));
                }else if(position == 2){//动态参数（Map）
                    startActivity(new Intent(MainActivity.this, DynamicParameterMapActivity.class));
                }else if(position == 3){//替换请求路径
                    startActivity(new Intent(MainActivity.this, URLReplaceActivity.class));
                }else if(position == 4){//Post请求@Field
                    startActivity(new Intent(MainActivity.this, POSTFieldActivity.class));
                }else if(position == 5){//Post请求(多参数)@FieldMap
                    startActivity(new Intent(MainActivity.this, POSTFieldMapActivity.class));
                }

            }
        });
    }

}
