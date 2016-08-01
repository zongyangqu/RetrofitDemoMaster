package com.example.administrator.retrofitdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.retrofitdemo.Bean.TVShow;
import com.example.administrator.retrofitdemo.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/28. 17:21
 * 版本：
 */
public class TvShowAdapter extends BaseAdapter {

    private Context mContext;
    private List<TVShow.ResultBean> tvList;

    public TvShowAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setData(List<TVShow.ResultBean> tvList){
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
            convertView = View.inflate(mContext, R.layout.item_tv_show,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_classify = (TextView) convertView.findViewById(R.id.tv_classify);
            viewHolder.tv_tv_name = (TextView) convertView.findViewById(R.id.tv_tv_name);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        TVShow.ResultBean  resultBean= tvList.get(position);
        viewHolder.tv_classify.setText(resultBean.getId()+"");
        viewHolder.tv_tv_name.setText(resultBean.getName());
        return convertView;
    }

    static class ViewHolder{
        public TextView tv_classify;
        public TextView tv_tv_name;
    }
}
