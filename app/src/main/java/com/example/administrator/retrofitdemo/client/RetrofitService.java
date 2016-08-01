package com.example.administrator.retrofitdemo.client;

import com.example.administrator.retrofitdemo.Bean.Contributor;
import com.example.administrator.retrofitdemo.Bean.FruitData;
import com.example.administrator.retrofitdemo.Bean.News;
import com.example.administrator.retrofitdemo.Bean.NewsBody;
import com.example.administrator.retrofitdemo.Bean.QQConclusion;
import com.example.administrator.retrofitdemo.Bean.Question;
import com.example.administrator.retrofitdemo.Bean.SomeResponse;
import com.example.administrator.retrofitdemo.Bean.TVShow;
import com.example.administrator.retrofitdemo.Bean.TodayHistory;
import com.squareup.okhttp.ResponseBody;

import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;


/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/7/21. 19:14
 * 版本：
 */
public interface RetrofitService {

    /**
     * 固定参数(获取电视节目)
     */
    @GET("/tv/getCategory?key=b8f4231c7946cd98b9779ffada5c6361")
    Call<TVShow> TVShow();

    /**
     * 路径替换(获取电视节目)
     * 替换URL中的请求路径{url}中的内容
     * http://japi.juhe.cn/tv/_url?key=b8f4231c7946cd98b9779ffada5c6361
     */
    @GET("/tv/{url}?key=b8f4231c7946cd98b9779ffada5c6361")
    Call<TVShow> TVShow(@Path("url") String _url);

    /**
    动态参数(测试QQ号吉凶)   Query是URL问号后面的参数  qq是问号后的请求参数名
     http://japi.juhe.cn/qqevaluate/qq?key=e09fdc4b4abd154fbd9abb86bfd94e82&qq=qqNum
     */
    @GET("/qqevaluate/qq?key=e09fdc4b4abd154fbd9abb86bfd94e82")
    Call<QQConclusion> qqConclusion(@Query("qq")String qqNum);

    /**
    多动态参数(测试QQ号吉凶)  QueryMap相当于多个Query
     http://api.juheapi.com/japi/toh?key=b6c19a3e19888cd1ed481247f2c8a3f7&v=1.0&key=value&month=8&day=1
     */
    @GET("/japi/toh?key=b6c19a3e19888cd1ed481247f2c8a3f7&v=1.0")
    Call<TodayHistory> getTodayHistory(@QueryMap Map<String, String> MapPar);

    /**
     *POST请求 查询参数较少时使用@Field传参
     * 请求新闻头条数据
     */
    @FormUrlEncoded
    @POST("/toutiao/index")
    Call<News> getNews(@Field("key") String key,@Field("type")String type);

    /**
     *POST请求 查询参数较多时使用@FieldMap传参
     * 请求驾考题库
     */
    @FormUrlEncoded
    @POST("/jztk/query")
    Call<Question> getQuestion(@FieldMap Map<String,String> MapPar);

}
