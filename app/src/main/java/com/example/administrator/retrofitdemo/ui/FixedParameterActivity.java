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
 * 类描述：固定参数(URL)的请求类 获取电视频道信息
 * 创建人：quzongyang
 * 创建时间：2016/7/28. 14:31
 * 请求头：http://japi.juhe.cn/tv/getCategory?key=b8f4231c7946cd98b9779ffada5c6361
 */
public class FixedParameterActivity extends BaseActivity {


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
        Call<TVShow> call = service.TVShow();
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
