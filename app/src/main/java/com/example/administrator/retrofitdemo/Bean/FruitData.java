package com.example.administrator.retrofitdemo.Bean;

import java.util.List;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/27. 11:38
 * 版本：
 */
public class FruitData {

    /**
     * code : 0
     * message : success
     */

    private StatusBean status;
    /**
     * data : [{"classifyid":"2","classifyname":"苹果","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230021627244_100_100.jpg","parent_id":"1"},{"classifyid":"3","classifyname":"香蕉","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022427463_100_100.jpg","parent_id":"1"},{"classifyid":"4","classifyname":"火龙果","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022509964_100_100.jpg","parent_id":"1"},{"classifyid":"5","classifyname":"葡萄&提子","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2015/01/15/20150115062415437_100_100.jpg","parent_id":"1"},{"classifyid":"6","classifyname":"木瓜","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230023651465_100_100.jpg","parent_id":"1"},{"classifyid":"7","classifyname":"橙子","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/08/22/20140822042227797_100_100.jpg","parent_id":"1"},{"classifyid":"8","classifyname":"梨","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022406208_100_100.jpg","parent_id":"1"},{"classifyid":"9","classifyname":"柠檬","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230023610207_100_100.jpg","parent_id":"1"},{"classifyid":"10","classifyname":"猕猴桃&奇异果","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022548303_100_100.jpg","parent_id":"1"},{"classifyid":"11","classifyname":"其他水果","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/08/22/20140822041732601_100_100.jpg","parent_id":"1"},{"classifyid":"12","classifyname":"其他水果","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/08/22/20140822041732601_100_100.jpg","parent_id":"1"},{"classifyid":"13","classifyname":"草莓","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022437397_100_100.jpg","parent_id":"1"},{"classifyid":"14","classifyname":"柑橘","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230024354218_100_100.jpg","parent_id":"1"},{"classifyid":"15","classifyname":"山楂d","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/08/22/20140822041732601_100_100.jpg","parent_id":"1"},{"classifyid":"16","classifyname":"其他","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230035843526_100_100.jpg","parent_id":"1"},{"classifyid":"17","classifyname":"樱桃&车厘子","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022149661_100_100.jpg","parent_id":"1"},{"classifyid":"18","classifyname":"柚子","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022258137_100_100.jpg","parent_id":"1"},{"classifyid":"20","classifyname":"菠萝&凤梨","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022356433_100_100.jpg","parent_id":"1"},{"classifyid":"22","classifyname":"哈密瓜 ","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2015/01/15/20150115062607820_100_100.jpg","parent_id":"1"},{"classifyid":"23","classifyname":"桃子","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2016/01/21/20160121053457492_400_300.jpg","parent_id":"1"},{"classifyid":"24","classifyname":" ","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022246656_100_100.jpg","parent_id":"1"},{"classifyid":"146","classifyname":"火龙果","icon":"http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png","img":"upload/2014/12/30/20141230022509964_100_100.jpg","parent_id":"1"}]
     * name : 水果
     */

    private List<DataBean> data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StatusBean {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class DataBean {
        private String name;
        /**
         * classifyid : 2
         * classifyname : 苹果
         * icon : http://imgcdn.xuxian.com/upload/2016/04/28/20160428111024373.png
         * img : upload/2014/12/30/20141230021627244_100_100.jpg
         * parent_id : 1
         */

        private List<Data_Bean> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Data_Bean> getData() {
            return data;
        }

        public void setData(List<Data_Bean> data) {
            this.data = data;
        }

        public static class Data_Bean {
            private String classifyid;
            private String classifyname;
            private String icon;
            private String img;
            private String parent_id;

            public String getClassifyid() {
                return classifyid;
            }

            public void setClassifyid(String classifyid) {
                this.classifyid = classifyid;
            }

            public String getClassifyname() {
                return classifyname;
            }

            public void setClassifyname(String classifyname) {
                this.classifyname = classifyname;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }
        }
    }
}
