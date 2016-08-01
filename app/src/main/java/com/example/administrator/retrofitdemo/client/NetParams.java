package com.example.administrator.retrofitdemo.client;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：请求参数封装类
 * 创建人：quzongyang
 * 创建时间：2016/7/28. 18:58
 * 版本：
 */
public class NetParams {
    private static NetParams params = new NetParams();

    private NetParams() {

    }

    public static NetParams getInstance() {
        return params;
    }

    /**
     * 历史上的今天
     *
     * @param month 月份
     * @param day  日期
     * @return
     */
    public Map<String, String> getTodayHistory(String month, String day) {
        Map<String, String> params = new HashMap<>();
        params.put("month", month);
        params.put("day", day);
        return params;
    }

    /**
     * 查询题库
     *	key	 string	您申请的appKey
     *  subject	String	选择考试科目类型，1：科目1；4：科目4
     *  model	string	驾照类型，可选择参数为：c1,c2,a1,a2,b1,b2；当subject=4时可省略
     * @return
     */
    public Map<String, String> getQuestion(String key, String subject, String model) {
        Map<String, String> params = new HashMap<>();
        params.put("key", key);
        params.put("subject", subject);
        params.put("model", model);
        return params;
    }
}
