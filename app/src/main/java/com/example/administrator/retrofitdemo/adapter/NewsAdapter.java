package com.example.administrator.retrofitdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.retrofitdemo.Bean.News;
import com.example.administrator.retrofitdemo.Bean.TVShow;
import com.example.administrator.retrofitdemo.R;
import com.example.administrator.retrofitdemo.base.BaseActivity;

import java.util.List;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/29. 17:59
 * 版本：
 */
public class NewsAdapter extends BaseAdapter {

    private Context mContext;
    private List<News.ResultBean.DataBean> list;

    public NewsAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setData(List<News.ResultBean.DataBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(null == list || list.isEmpty()){
            return 0;
        }else{
            return list.size();
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
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_news,null);
            viewHolder.tv_news_title = (TextView) convertView.findViewById(R.id.tv_news_title);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        News.ResultBean.DataBean data = list.get(position);
        viewHolder.tv_news_title.setText(data.getTitle());
        return convertView;
    }

    public static class ViewHolder{
        private TextView tv_news_title;
    }
}
