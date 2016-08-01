package com.example.administrator.retrofitdemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.retrofitdemo.Bean.TVShow;
import com.example.administrator.retrofitdemo.R;
import com.example.administrator.retrofitdemo.adapter.TvShowAdapter;
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
 * 类描述：替换路径
 * 创建人：quzongyang
 * 创建时间：2016/7/29. 11:17
 * 版本：
 */
public class URLReplaceActivity extends BaseActivity{

    private ListView lv_tv_show;
    private TvShowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fixedparameter_layout);

        lv_tv_show = (ListView) findViewById(R.id.lv_tv_show);
        adapter = new TvShowAdapter(this);
        lv_tv_show.setAdapter(adapter);
        getTvShow();

    }

    public void getTvShow() {
        startLoading();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(LocalConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<TVShow> call = service.TVShow("getCategory");
        call.enqueue(new Callback<TVShow>() {
            @Override
            public void onResponse(Response<TVShow> response, Retrofit retrofit) {
                stopLoading();
                List<TVShow.ResultBean> resultBeen =  response.body().getResult();
                adapter.setData(resultBeen);
            }

            @Override
            public void onFailure(Throwable t) {
                setLoadingNetError();
                retryButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getTvShow();
                    }
                });
            }
        });
    }
}
