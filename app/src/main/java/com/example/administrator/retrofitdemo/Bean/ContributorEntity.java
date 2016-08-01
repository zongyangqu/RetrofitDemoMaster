package com.example.administrator.retrofitdemo.Bean;

import java.util.List;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/26. 15:56
 * 版本：
 */
public class ContributorEntity {

    /**
     * code : 0
     * message : success
     */

    private StatusBean status;
    /**
     * area : 北京科技大学体育场南侧物美超市一层
     * area_id : 110108
     * bdate : 1,0
     * bstarttime : 11:00-21:00
     * city_area : 海淀区
     * city_id : 110000
     * city_name : 北京市
     * distance : 1.7km
     * divide : 100
     * fristtime : 2016-02-17
     * id : 43
     * lat : 39.989083
     * lng : 116.359271
     * message_alert : 请您在48小时内把您的水果领回家。
     * starttime : 2015-03-27
     * store_attr : 1
     * store_status : 0
     * tags : ,学校,自营,
     * telphone : 18515826583
     * title : 北京科技大学提货点
     * type : 1
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
        private String area;
        private String area_id;
        private String bdate;
        private String bstarttime;
        private String city_area;
        private String city_id;
        private String city_name;
        private String distance;
        private String divide;
        private String fristtime;
        private String id;
        private String lat;
        private String lng;
        private String message_alert;
        private String starttime;
        private String store_attr;
        private String store_status;
        private String tags;
        private String telphone;
        private String title;
        private String type;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getBdate() {
            return bdate;
        }

        public void setBdate(String bdate) {
            this.bdate = bdate;
        }

        public String getBstarttime() {
            return bstarttime;
        }

        public void setBstarttime(String bstarttime) {
            this.bstarttime = bstarttime;
        }

        public String getCity_area() {
            return city_area;
        }

        public void setCity_area(String city_area) {
            this.city_area = city_area;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getDivide() {
            return divide;
        }

        public void setDivide(String divide) {
            this.divide = divide;
        }

        public String getFristtime() {
            return fristtime;
        }

        public void setFristtime(String fristtime) {
            this.fristtime = fristtime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getMessage_alert() {
            return message_alert;
        }

        public void setMessage_alert(String message_alert) {
            this.message_alert = message_alert;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getStore_attr() {
            return store_attr;
        }

        public void setStore_attr(String store_attr) {
            this.store_attr = store_attr;
        }

        public String getStore_status() {
            return store_status;
        }

        public void setStore_status(String store_status) {
            this.store_status = store_status;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
