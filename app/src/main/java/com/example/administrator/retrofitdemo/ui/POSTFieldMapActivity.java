package com.example.administrator.retrofitdemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.retrofitdemo.Bean.Question;
import com.example.administrator.retrofitdemo.R;
import com.example.administrator.retrofitdemo.adapter.QuestionAdapter;
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
 * 类描述：POST请求 查询参数较多时使用@FieldMap传参，请求驾考题库。
 * 创建人：quzongyang
 * 创建时间：2016/7/29. 15:03
 * 版本：
 */
public class POSTFieldMapActivity extends BaseActivity{

    private ListView lv_question;
    private QuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postfieldmap_layout);
        init();

    }


    public void init(){
        lv_question = (ListView) findViewById(R.id.lv_question);
        adapter = new QuestionAdapter(this);
        lv_question.setAdapter(adapter);
        getQuestion();

    }

    public void getQuestion(){
        startLoading();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(LocalConfig.BASEURLQUESTION).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<Question> call =  service.getQuestion(NetParams.getInstance().getQuestion("d9388813115bb6cc1ae6b8d13e2e79c3","1","c1"));
        call.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Response<Question> response, Retrofit retrofit) {
                stopLoading();
                if(response.body().getError_code() == LocalConfig.NET_SUCCESS_CODE){
                    adapter.setData(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                setLoadingNetError();
                retryButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getQuestion();
                    }
                });
            }
        });
    }
}
