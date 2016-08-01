package com.example.administrator.retrofitdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.retrofitdemo.Bean.News;
import com.example.administrator.retrofitdemo.R;
import com.example.administrator.retrofitdemo.adapter.NewsAdapter;
import com.example.administrator.retrofitdemo.base.BaseActivity;
import com.example.administrator.retrofitdemo.client.RetrofitService;
import com.example.administrator.retrofitdemo.global.LocalConfig;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 类描述：post请求
 * 创建人：quzongyang
 * 创建时间：2016/7/29. 14:27
 * 版本：
 */
public class POSTFieldActivity extends BaseActivity{
    private ListView lv_news;
    private NewsAdapter adapter;
    private List<News.ResultBean.DataBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postfield_layout);
        init();


    }

    public void init(){
        adapter = new NewsAdapter(this);
        lv_news = (ListView) findViewById(R.id.lv_news);
        lv_news.setAdapter(adapter);
        lv_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(POSTFieldActivity.this,NewsDetailActivity.class);
                intent.putExtra("WEBURL",list.get(position).getUrl());
                startActivity(intent);
            }
        });
        getNews();
    }

    public void getNews(){
        startLoading();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(LocalConfig.BASEURLNEWS).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<News> call = service.getNews("761fc4e2bffe6ed2997b3626a642c3e0","junshi");
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Response<News> response, Retrofit retrofit) {
                stopLoading();
                if(response.body().getError_code() == LocalConfig.NET_SUCCESS_CODE){
                    list = response.body().getResult().getData();
                    adapter.setData(list);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                setLoadingNetError();
                retryButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getNews();
                    }
                });
            }
        });
    }
}
