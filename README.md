## Retrofit入门学习 ##
之前的项目中使用到了Retrofit的网络请求框架，糊里糊涂的使用下来发现其实还有很多的知识点是并不完全清晰的，并且在之前使用时发现网上的一些教程并不完善（好多教程都是Retrofit和RxJava一起使用，单独使用Retrofit的源码很少），入门学习比较有难度。于是决定自己整理下只用Retrofit请求的文章给入门学习的人提供一点我的心得。

#Retrofit 概览
Retrofit 是一个 RESTful 的 HTTP 网络请求框架的封装。注意这里并没有说它是网络请求框架，主要原因在于网络请求的工作并不是 Retrofit 来完成的。Retrofit 2.0 开始内置 OkHttp，前者专注于接口的封装，后者专注于网络请求的高效，二者分工协作，宛如古人的『你耕地来我织布』，小日子别提多幸福了。

#Retrofit的依赖包
compile 'com.squareup.retrofit2:retrofit:2.0.2'
//retrofit封装了OKHttp

compile 'com.squareup.retrofit:converter-gson:2.0.0-beta2'
//解析JSON时使用

#Hello Retrofit
Retrofit的强大之处在于开发时你不必花大量时间去搭建网络请求框架也不必纠结于网络请求使用什么，这一切一切**Retrofit**都已经帮你解决了。
好吧，先来看下Retrofit的核心使用方法。

- 创建一个Retrofit 对象（核心用法一）

    	Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())//解析方法
            .baseUrl("http://japi.juhe.cn")
            .build();

- 接口申明（核心用法二）
	
		public interface RetrofitService {
		/**
     	* 固定参数(获取电视节目)
     	*/
	    @GET("/tv/getCategory?key=b8f4231c7946cd98b9779ffada5c6361")
	    Call<TVShow> TVShow();
			Call<TVShow> TVShow();
			}

- 创建访问API的请求（核心用法三）

		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://japi.juhe.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<TVShow> call = service.TVShow();

- 同步调用(核心用法四)
同步方法需要在子线程中执行
Call是Retrofit中重要的一个概念，代表被封装成单个请求/响应的交互行为
		TVShow tvShow = call.execute();
- 异步调用（核心用法五）
		call.enqueue(new Callback<TVShow>() {
            @Override
            public void onResponse(Response<TVShow> response, Retrofit retrofit) {
                stopLoading();
                List<TVShow.ResultBean> resultBeen =  response.body().getResult();
                adapter.setData(resultBeen);
            }

            @Override
            public void onFailure(Throwable t) {
                setLoadingNetError();
                retryButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getTvShow();
                    }
                });
            }
        });
- 取消请求（核心用法六）
		call.cancel();
完成以上步骤就可以实现一个简单的网络请求了。


看到这估计很多童鞋会开始懵逼了，这TM写的是什么玩意，**@GET("/tv/getCategory?key=b8f4231c7946cd98b9779ffada5c6361")**这是什么鬼啊！！！
别骂我啊，一点点看吧。


#Url 配置
**Retrofit** 支持的协议包括 GET/POST/PUT/DELETE/HEAD/PATCH，当然你也可以直接用 HTTP 来自定义请求。这些协议均以注解的形式进行配置，比如我们已经见过 GET 的用法
@GET 表示当前使用GET请求、@GET括号中的路径表示拼接的请求路径。
下面分为GET、POST、DELETE还有PUT的请求，说明@Path、@Query、@QueryMap、@Body、@Field、@FieldMap的用法。
- ##GET

**用法1（一个简单的get请求，无请求参数）**
http://japi.juhe.cn/tv/getCategory?key=b8f4231c7946cd98b9779ffada5c6361

	@GET("/tv/getCategory?key=b8f4231c7946cd98b9779ffada5c6361")
    Call<TVShow> TVShow();
**用法2（URL中有请求参数，@path 当参数在URL中并且在请求路径的？之前时使用）**
http://japi.juhe.cn/tv/{url}?key=b8f4231c7946cd98b9779ffada5c6361

	@GET("/tv/{url}?key=b8f4231c7946cd98b9779ffada5c6361")
    Call<TVShow> TVShow(@Path("url") String _url);

**用法3（参数在URL问号之后，@Query 当参数在URL中并且在请求路径的？之后时使用）**
http://japi.juhe.cn/qqevaluate/qq?key=e09fdc4b4abd154fbd9abb86bfd94e82&qq=43081438
	
	@GET("/qqevaluate/qq?key=e09fdc4b4abd154fbd9abb86bfd94e82")
    Call<QQConclusion> qqConclusion(@Query("qq")String qqNum);

**用法4（多个参数在URL问号之后且个数不确定	@QueryMap）**
http://api.juheapi.com/japi/toh?key=b6c19a3e19888cd1ed481247f2c8a3f7&v=1.0&key=value&month=8&day=1
	
	@GET("/japi/toh?key=b6c19a3e19888cd1ed481247f2c8a3f7&v=1.0")
    Call<TodayHistory> getTodayHistory(@QueryMap Map<String, String> MapPar);

- ##POST
**注：Post方式提交表单形式的参数需要添加标记@FormUrlEncoded，通过@Field注释添加键值对**

其实我们用 POST 的场景相对较多，绝大多数的服务端接口都需要做加密、鉴权和校验，GET 显然不能很好的满足这个需求。

**用法1（需要补全URL，问号后加入access_token，post的数据只有一条reason）**
http://102.10.10.132/api/Comments/1?access_token=1234123
http://102.10.10.132/api/Comments/{newsId}?access_token={access_token}

	@FormUrlEncoded
    @POST("Comments/{newsId}")
    Call<Comment> reportComment(
        @Path("newsId") String commentId,
        @Query("access_token") String access_token,
        @Field("reason") String reason);

**用法2（@FieldMap  多个请求参数且个数不固定或较多时）**
    
	@FormUrlEncoded
    @POST("/jztk/query")
    Call<Question> getQuestion(@FieldMap Map<String,String> MapPar);

**用法3（@Body	POST提交JSON数据）**
有时提交的数据量比较大时，用键值对的方式提交参数不太方便，Retrofit可以通过@Body注释，直接传递一个对象给请求主体，Retrofit通过JSON转化器，把对象映射成JSON数据。

接口定义：

    @POST("/tasks")
    Call<Task> createTask(@Body Task task);
传递实体需要有Model：

    public class Task {  
	    private long id;
	    private String text;
	
	    public Task() {}
	    public Task(long id, String text) {
	        this.id = id;
	        this.text = text;
	    }
	}
客户端调用：
	
	Task task = new Task(1, "my task title");  
	Call<Task> call = taskService.createTask(task);  
	call.enqueue(new Callback<Task>() {}); 
这样，服务端得到的是JOSN数据：
	
	{
    "id": 1,
    "text": "my task title"
	}
- ##DELETE

**用法1（需要补全URL）**
http://102.10.10.132/api/Comments/1
http://102.10.10.132/api/Comments/{newsId}{access_token}

	@DELETE("Comments/{commentId}")
    Call<ResponseBody> deleteNewsCommentFromAccount(
        @Path("commentId") String commentId);

**用法2（需要补全URL，问号后加入access_token）**
http://102.10.10.132/api/Comments/1?access_token=1234123
http://102.10.10.132/api/Comments/{newsId}?access_token={access_token}

	@DELETE("Comments/{commentId}")
    Call<ResponseBody> deleteNewsCommentFromAccount(
        @Path("accountId") String accountId，
        @Query("access_token") String access_token);

- ##PUT（这个请求很少用到，例子就写一个）

http://102.10.10.132/api/Accounts/1
http://102.10.10.132/api/Accounts/{accountId}

	@PUT("Accounts/{accountId}")
    Call<ExtrasBean> updateExtras(
        @Path("accountId") String accountId,
        @Query("access_token") String access_token,
        @Body ExtrasBean bean);

- ##@Headers、@Header改变请求头

**用法1（固定请求头）**

   
	 @GET("/some/endpoint")
	 @Headers("Accept-Encoding: application/json")
	 Call<SomeResponse> someEndpoint();
	
	 //调用 
	 someService.someEndpoint();
	
	 // GET /some/endpoint HTTP/1.1
	 // Accept-Encoding: application/json

**用法2（动态请求头）**

	 @GET("/some/endpoint")
	 Call<SomeResponse> someEndpoint(
	 @Header("Location") String location);
	
	 //调用 
	 someService.someEndpoint("Droidcon NYC 2015");
	 
	 // GET /some/endpoint HTTP/1.1
	 // Location: Droidcon NYC 2015
**用法3（固定请求头+动态请求头）**
	
	 @GET("/some/endpoint")
	 @Headers("Accept-Encoding: application/json")
	 Call<SomeResponse> someEndpoint(
	 @Header("Location") String location);
	
	 //调用 
	 someService.someEndpoint("Droidcon NYC 2015");
	 
	 // GET /some/endpoint HTTP/1.1
	 // Accept-Encoding: application/json
	 // Location: Droidcon NYC 2015

- ##文件上传

待续。。。。。。。。。。。。。。。。。。

##总结
- @Path：所有在网址中的参数（URL的问号前面），如：
http://japi.juhe.cn/tv/{url}?key=b8f4231c7946cd98b9779ffada5c6361
- @Query：URL问号后面的参数，如：
http://japi.juhe.cn/qqevaluate/qq?key={key_num}
- @QueryMap：相当于多个@Query
http://japi.juhe.cn/qqevaluate/qq?key={key_num}&qq={qq_num}
- @Field：用于POST请求，提交单个数据
- @FieldMap：用于POST请求，提交多个数据，相当于多个@Field
- @Body：相当于多个@Field，以对象的形式通过JSON数据提交
