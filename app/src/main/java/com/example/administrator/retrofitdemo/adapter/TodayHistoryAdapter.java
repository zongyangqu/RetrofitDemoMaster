package com.example.administrator.retrofitdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.retrofitdemo.Bean.TVShow;
import com.example.administrator.retrofitdemo.Bean.TodayHistory;
import com.example.administrator.retrofitdemo.R;

import java.util.List;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/28. 19:01
 * 版本：
 */
public class TodayHistoryAdapter extends BaseAdapter{
    private Context mContext;
    private List<TodayHistory.ResultBean> tvList;

    public TodayHistoryAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setData(List<TodayHistory.ResultBean> tvList){
        this.tvList = tvList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(null == tvList || tvList.isEmpty()){
            return 0;
        }else{
            return tvList.size();
        }
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
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_tv_today_history,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_des = (TextView) convertView.findViewById(R.id.tv_des);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        TodayHistory.ResultBean  resultBean= tvList.get(position);
        viewHolder.tv_title.setText(resultBean.getTitle());
        viewHolder.tv_des.setText(resultBean.getDes());
        return convertView;
    }

    static class ViewHolder{
        public TextView tv_title;
        public TextView tv_des;
    }
}
