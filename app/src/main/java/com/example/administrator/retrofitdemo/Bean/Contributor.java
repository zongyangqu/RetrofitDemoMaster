package com.example.administrator.retrofitdemo.Bean;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/25. 15:40
 * 版本：
 */
public class Contributor {
    public final String login;
    public final int contributions;
    public Contributor(String login, int contributions) {
        this.login = login;
        this.contributions = contributions;
    }
    @Override
    public String toString() {
        return "Contributor{" +
                "login='" + login + '\'' +
                ", contributions=" + contributions +
                '}';
    }
}
