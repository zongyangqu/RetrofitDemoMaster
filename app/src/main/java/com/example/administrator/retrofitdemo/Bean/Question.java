package com.example.administrator.retrofitdemo.Bean;

import java.util.List;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/29. 15:10
 * 版本：
 */
public class Question {

    /**
     * error_code : 0
     * reason : ok
     * result : [{"answer":"4","explains":"限制最高时速40公里：表示该标志至前方限制速度标志的路段内，机动车行驶速度不得超过标志所示数值。此标志设在需要限制车辆速度的路段的起点。以图为例：限制行驶时速不得超过40公里。","id":12,"item1":"前方40米减速","item2":"最低时速40公里","item3":"限制40吨轴重","item4":"限制最高时速40公里","question":"这个标志是何含义？","url":"http://images.juheapi.com/jztk/c1c2subject1/12.jpg"}]
     */

    private int error_code;
    private String reason;
    /**
     * answer : 4
     * explains : 限制最高时速40公里：表示该标志至前方限制速度标志的路段内，机动车行驶速度不得超过标志所示数值。此标志设在需要限制车辆速度的路段的起点。以图为例：限制行驶时速不得超过40公里。
     * id : 12
     * item1 : 前方40米减速
     * item2 : 最低时速40公里
     * item3 : 限制40吨轴重
     * item4 : 限制最高时速40公里
     * question : 这个标志是何含义？
     * url : http://images.juheapi.com/jztk/c1c2subject1/12.jpg
     */

    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String answer;
        private String explains;
        private int id;
        private String item1;
        private String item2;
        private String item3;
        private String item4;
        private String question;
        private String url;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getExplains() {
            return explains;
        }

        public void setExplains(String explains) {
            this.explains = explains;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getItem1() {
            return item1;
        }

        public void setItem1(String item1) {
            this.item1 = item1;
        }

        public String getItem2() {
            return item2;
        }

        public void setItem2(String item2) {
            this.item2 = item2;
        }

        public String getItem3() {
            return item3;
        }

        public void setItem3(String item3) {
            this.item3 = item3;
        }

        public String getItem4() {
            return item4;
        }

        public void setItem4(String item4) {
            this.item4 = item4;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
