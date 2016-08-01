package com.example.administrator.retrofitdemo.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.retrofitdemo.Bean.QQConclusion;
import com.example.administrator.retrofitdemo.R;
import com.example.administrator.retrofitdemo.base.BaseActivity;
import com.example.administrator.retrofitdemo.client.RetrofitService;
import com.example.administrator.retrofitdemo.global.LocalConfig;
import com.squareup.okhttp.OkHttpClient;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 类描述：动态参数(URL)的请求类  获取QQ号测吉凶结果
 * 创建人：quzongyang
 * 创建时间：2016/7/28. 16:54
 *
 * 请求头：http://japi.juhe.cn/qqevaluate/qq?key=e09fdc4b4abd154fbd9abb86bfd94e82&qq=43081438
 */
public class DynamicParameterActivity extends BaseActivity implements View.OnClickListener{

    private EditText edit_qq;
    private Button btn_test;
    private TextView tv_conclusion;
    private TextView tv_analysis;
    private String qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamicparameter_layout);
        edit_qq = (EditText) findViewById(R.id.edit_qq);
        btn_test = (Button) findViewById(R.id.btn_test);
        tv_conclusion = (TextView) findViewById(R.id.tv_conclusion);
        tv_analysis = (TextView) findViewById(R.id.tv_analysis);
        btn_test.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test:
                qq = edit_qq.getText().toString();
                if(!TextUtils.isEmpty(qq)){
                    getQQAnalysis();
                }else{
                    Toast.makeText(DynamicParameterActivity.this,"请输入QQ号",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void getQQAnalysis(){
        startLoading();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(LocalConfig.BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<QQConclusion> call = service.qqConclusion(qq);
        call.enqueue(new Callback<QQConclusion>() {
            @Override
            public void onResponse(Response<QQConclusion> response, Retrofit retrofit) {
                stopLoading();
                //调用接口成功
                if(response.body().getError_code() == LocalConfig.NET_SUCCESS_CODE){
                    if(null != response.body().getResult()){
                        String conclusion = response.body().getResult().getData().getConclusion();
                        String analysis = response.body().getResult().getData().getAnalysis();
                        tv_conclusion.setText("QQ号码测试结论:"+conclusion);
                        tv_analysis.setText("结论分析:"+analysis);
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
                        getQQAnalysis();
                    }
                });
            }
        });

    }
}
