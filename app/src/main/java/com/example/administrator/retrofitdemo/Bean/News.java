package com.example.administrator.retrofitdemo.Bean;

import java.util.List;

/**
 * 类名称：
 * 类描述：新闻
 * 创建人：quzongyang
 * 创建时间：2016/7/29. 14:29
 * 版本：
 */
public class News {


    private String reason;

    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        private String stat;
        /**
         * title : 德宏军分区在生疏地域组织实弹射击
         * date : 2016-07-29 14:16
         * category : 军事
         * author_name : 新华网
         * thumbnail_pic_s : http://08.imgmini.eastday.com/mobile/20160729/20160729141612_c72d75c4d5df039c7bd70ed9373764e4_1_mwpm_03200403.jpeg
         * url : http://mini.eastday.com/mobile/160729141612299.html?qid=juheshuju
         * thumbnail_pic_s03 : http://08.imgmini.eastday.com/mobile/20160729/20160729141612_c72d75c4d5df039c7bd70ed9373764e4_1_mwpl_05500201.jpeg
         */

        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String thumbnail_pic_s;
            private String url;
            private String thumbnail_pic_s03;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }
}
