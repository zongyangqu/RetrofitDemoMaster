package com.example.administrator.retrofitdemo.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.retrofitdemo.Bean.TodayHistory;
import com.example.administrator.retrofitdemo.R;
import com.example.administrator.retrofitdemo.adapter.TodayHistoryAdapter;
import com.example.administrator.retrofitdemo.base.BaseActivity;
import com.example.administrator.retrofitdemo.client.NetParams;
import com.example.administrator.retrofitdemo.client.RetrofitService;
import com.example.administrator.retrofitdemo.global.LocalConfig;


import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 类描述：多动态参数(MAP)   查询历史上的今天
 * 创建人：quzongyang
 * 创建时间：2016/7/28. 18:26
 * 版本：
 */
public class DynamicParameterMapActivity extends BaseActivity implements View.OnClickListener{
    private EditText edit_month;
    private EditText edit_day;
    private Button btn_search;
    private ListView lv_today_history;
    private TodayHistoryAdapter adapter;
    private String date;
    private String month;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamicparametermap_layout);
        init();
    }

    public void init(){
        edit_month = (EditText) findViewById(R.id.edit_month);
        edit_day = (EditText) findViewById(R.id.edit_day);
        btn_search = (Button) findViewById(R.id.btn_search);
        lv_today_history = (ListView) findViewById(R.id.lv_today_history);
        adapter = new TodayHistoryAdapter(this);
        lv_today_history.setAdapter(adapter);
        btn_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_search:
                date = edit_day.getText().toString();
                month = edit_month.getText().toString();
                if(TextUtils.isEmpty(date) || TextUtils.isEmpty(month)){
                    Toast.makeText(DynamicParameterMapActivity.this,"请输入完整日期",Toast.LENGTH_SHORT).show();
                }else{
                    getTodayHistory();
                }
                break;
        }
    }

    public void getTodayHistory(){
        startLoading();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(LocalConfig.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<TodayHistory> call =  service.getTodayHistory(NetParams.getInstance().getTodayHistory(month,date));
        call.enqueue(new Callback<TodayHistory>() {
            @Override
            public void onResponse(Response<TodayHistory> response, Retrofit retrofit) {
                stopLoading();
                if(response.body().getError_code() == LocalConfig.NET_SUCCESS_CODE){
                    if(null != response.body().getResult()){
                        adapter.setData(response.body().getResult());
                    }else{
                        setLoadingNoData("暂无数据");
                    }
                }

            }

            @Override
            public void onFailure(Throwable t) {
                setLoadingNetError();
                retryButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getTodayHistory();
                    }
                });
            }
        });
    }
}
