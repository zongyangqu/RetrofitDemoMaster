package com.example.administrator.retrofitdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.retrofitdemo.Bean.Question;
import com.example.administrator.retrofitdemo.Bean.TVShow;
import com.example.administrator.retrofitdemo.R;

import java.util.List;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/29. 16:01
 * 版本：
 */
public class QuestionAdapter extends BaseAdapter {
    private List<Question.ResultBean> list;
    private Context mContext;

    public QuestionAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setData(List<Question.ResultBean> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        if(null == list || list.size() == 0){
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
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_question,null);
            holder.iv_question = (ImageView) convertView.findViewById(R.id.iv_question);
            holder.tv_question = (TextView) convertView.findViewById(R.id.tv_question);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Question.ResultBean resultBean = list.get(position);
        holder.tv_question.setText(resultBean.getExplains());
        Glide.with(mContext).load(resultBean.getUrl()).crossFade().into(holder.iv_question);
        return convertView;
    }


    public static class ViewHolder{
        public ImageView iv_question;
        public TextView tv_question;
    }
}
