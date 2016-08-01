package com.example.administrator.retrofitdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.retrofitdemo.R;

/**
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/28. 15:07
 * 版本：
 */
public class BaseActivity extends Activity {

    private View loading_activity_state;
    private LinearLayout ll_loadding_activity_state_loading;
    private LinearLayout ll_loadding_activity_state_nodata;
    private TextView tv_loadding_activity_state_nodata_text;
    private LinearLayout ll_loadding_activity_state_network_error;
    private TextView tv_loadding_activity_state_network_error_text;
    private Button btn_loadding_activity_state_network_error_retry;
    private TextView tv_loadding_activity_state_loading_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(View _addView) {
        RelativeLayout linear = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        linear.addView(_addView, params);

        //加载进度view
        RelativeLayout.LayoutParams loading_activity_state_params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        loading_activity_state_params.addRule(RelativeLayout.CENTER_IN_PARENT);
        loading_activity_state = LayoutInflater.from(this).inflate(R.layout.loading_status, null);
        findTitleViewLoaddingActivityStateById(loading_activity_state);
        linear.addView(loading_activity_state, loading_activity_state_params);

        super.setContentView(linear);

    }

    @Override
    public void setContentView(int layoutResID) {
        View _mUserView = LayoutInflater.from(this).inflate(layoutResID, null, false);
        setContentView(_mUserView);
    }
    private void findTitleViewLoaddingActivityStateById(View view) {
        ll_loadding_activity_state_loading = (LinearLayout) view.findViewById(R.id.ll_loadding_activity_state_loading);
        tv_loadding_activity_state_loading_text = (TextView) view.findViewById(R.id.tv_loadding_activity_state_loading_text);
        ll_loadding_activity_state_nodata = (LinearLayout) view.findViewById(R.id.ll_loadding_activity_state_nodata);
        tv_loadding_activity_state_nodata_text = (TextView) view.findViewById(R.id.tv_loadding_activity_state_nodata_text);
        ll_loadding_activity_state_network_error = (LinearLayout) view.findViewById(R.id.ll_loadding_activity_state_network_error);
        tv_loadding_activity_state_network_error_text = (TextView) view.findViewById(R.id.tv_loadding_activity_state_network_error_text);
        btn_loadding_activity_state_network_error_retry = (Button) view.findViewById(R.id.btn_loadding_activity_state_network_error_retry);
        view.setVisibility(View.GONE);
    }

    /**
     * 启动加载
     *
     * @param loadingText 加载文本
     */
    public void startLoading(String loadingText) {
        loading_activity_state.setVisibility(View.VISIBLE);
        ll_loadding_activity_state_loading.setVisibility(View.VISIBLE);
        ll_loadding_activity_state_nodata.setVisibility(View.GONE);
        ll_loadding_activity_state_network_error.setVisibility(View.GONE);
        tv_loadding_activity_state_loading_text.setText(loadingText);
    }

    /**
     * 启动加载
     */
    public void startLoading() {
        loading_activity_state.setVisibility(View.VISIBLE);
        ll_loadding_activity_state_loading.setVisibility(View.VISIBLE);
        ll_loadding_activity_state_nodata.setVisibility(View.GONE);
        ll_loadding_activity_state_network_error.setVisibility(View.GONE);
        tv_loadding_activity_state_loading_text.setText("正在加载...");
    }

    /**
     * 停止加载
     */
    public void stopLoading() {
        loading_activity_state.setVisibility(View.GONE);
        ll_loadding_activity_state_loading.setVisibility(View.GONE);
        ll_loadding_activity_state_nodata.setVisibility(View.GONE);
        ll_loadding_activity_state_network_error.setVisibility(View.GONE);
    }

    /**
     * 设置加载无数据
     *
     * @param noDataText 加载无数据文本
     */
    public void setLoadingNoData(String noDataText) {
        loading_activity_state.setVisibility(View.VISIBLE);
        ll_loadding_activity_state_loading.setVisibility(View.GONE);
        ll_loadding_activity_state_nodata.setVisibility(View.VISIBLE);
        ll_loadding_activity_state_network_error.setVisibility(View.GONE);
        tv_loadding_activity_state_nodata_text.setText(noDataText);
    }

    /**
     * 设置加载异常
     *
     * @param netErrorText 加载异常文本
     */
    public void setLoadingNetError(String netErrorText) {
        loading_activity_state.setVisibility(View.VISIBLE);
        ll_loadding_activity_state_loading.setVisibility(View.GONE);
        ll_loadding_activity_state_nodata.setVisibility(View.GONE);
        ll_loadding_activity_state_network_error.setVisibility(View.VISIBLE);
        tv_loadding_activity_state_network_error_text.setText(netErrorText);
        btn_loadding_activity_state_network_error_retry.setText("重试");
    }

    /**
     * 设置加载异常
     */
    public void setLoadingNetError() {
        loading_activity_state.setVisibility(View.VISIBLE);
        ll_loadding_activity_state_loading.setVisibility(View.GONE);
        ll_loadding_activity_state_nodata.setVisibility(View.GONE);
        ll_loadding_activity_state_network_error.setVisibility(View.VISIBLE);
        tv_loadding_activity_state_network_error_text.setText("网络异常,点击按钮重试");
        btn_loadding_activity_state_network_error_retry.setText("重试");
    }


    /***
     * 隐藏空数据视图
     */
    public void hideLoadingNoData() {
        loading_activity_state.setVisibility(View.GONE);
        ll_loadding_activity_state_nodata.setVisibility(View.GONE);
    }

    /**
     * 重新加载按钮
     *
     * @return
     */
    public Button retryButton() {
        return btn_loadding_activity_state_network_error_retry;
    }
}
