package com.example.hww.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends Activity {

    TextView tv;

    //private final String url = "http://www.baidu.com";
    // private final String url = "http://192.168.16.127:8080/SSMTest/user/showUser?id=1";
    private final String geturl = "http://192.168.137.1:8080/demo/book/getBook/1";
    private final String posturl = "http://192.168.137.66:8080/demo/book/addBook";
    private final String puturl = "http://192.168.137.66:8080/demo/book/updateBook/3";
    private final String deleteurl = "http://192.168.137.66:8080/demo/book/deleteBook/3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = this.findViewById(R.id.tv);

        final String postjson = "{\"bookName\":\"《机器学习》\",\"bookAuthor\":\"周志华\",\"bookPress\":\"清华出版社\",\"bookPrice\":\"66.2\"}";
        final String putjson = "{\"bookName\":\"《机器学习》\",\"bookAuthor\":\"周志华\",\"bookPress\":\"没有出版社\",\"bookPrice\":\"100.34\"}";

        doGet(geturl);
        //doPost(posturl,postjson);
        // doPut(puturl,putjson);
        //doDelete(deleteurl);

    }

    //测试OKhttp框架
    //GET请求方式
    public void doGet(String requestUrl){
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(requestUrl)
                .build();

        Call call  = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //获得响应头
                Headers headers = response.headers();

                //遍历响应头信息
                for (int i = 0; i < headers.size(); i++){
                    Log.d("tag------",headers.name(i) + "--->" + headers.value(i));
                }

                //获得响应体
               // ResponseBody body = response.body();

                //以字符串的形式获得网络
                //  String result = body.string();

               String  result= response.body().string();

                Log.d("GET+ResponseResult：","GET"+result);

                tv.setText("GET"+result);

                //解析json数据包
                Gson gson = new Gson();
                Book book = gson.fromJson(result,Book.class);

                tv.setText("ID："+book.getId()+"\n"
                        +"Book_Name："+book.getBookName()+"\n"
                        +"Book_Author："+book.getBookAuthor()+"\n"
                        +"Book_Press："+book.getBookPress()+"\n"
                        +"Book_Price："+book.getBookPrice()+"\n");

                // parseJSONWithGSON(result);

            }
        });
    }

    //POST json请求方式
    public void doPost(String requestUrl,String json){
        MediaType JSON=MediaType.parse("application/json; charset=utf-8");

        //申明给服务端传递一个json串
        // 创建一个OkHttpClient对象
         OkHttpClient okHttpClient = new OkHttpClient();
        // 创建一个RequestBody(参数1：数据类型 参数2传递的json串)
         RequestBody requestBody = RequestBody.create(JSON, json);
        // 创建一个请求对象
        Request request = new Request.Builder()
                .url(requestUrl)
                .post(requestBody)
                .build();

        // 发送请求获取响应
        Call call  = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //获得响应头
                Headers headers = response.headers();

                //遍历响应头信息
                for (int i = 0; i < headers.size(); i++){
                    Log.d("tag------",headers.name(i) + "--->" + headers.value(i));
                }


                //打印服务端返回结果
                String  result= response.body().string();
                Log.i("POST+ResponseResult：","POST"+result);
                tv.setText("POST"+result);
            }
        });
    }

    //PUT json请求方式
    public void doPut(String requestUrl,String json){
        MediaType JSON=MediaType.parse("application/json; charset=utf-8");

        //申明给服务端传递一个json串
        // 创建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        // 创建一个RequestBody(参数1：数据类型 参数2传递的json串)
        RequestBody requestBody = RequestBody.create(JSON, json);
        // 创建一个请求对象
        Request request = new Request.Builder() .url(requestUrl) .put(requestBody) .build();

        // 发送请求获取响应
        Call call  = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //获得响应头
                Headers headers = response.headers();

                //遍历响应头信息
                for (int i = 0; i < headers.size(); i++){
                    Log.d("tag------",headers.name(i) + "--->" + headers.value(i));
                }


                //打印服务端返回结果
                String  result= response.body().string();
                Log.i("PUT+ResponseResult：","PUT"+result);
                tv.setText("PUT"+result);
            }
        });
    }

    //DELETE请求方式
    public void doDelete(String requestUrl){
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(requestUrl)
                .delete()
                .build();

        Call call  = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //获得响应头
                Headers headers = response.headers();

                //遍历响应头信息
                for (int i = 0; i < headers.size(); i++){
                    Log.d("tag------",headers.name(i) + "--->" + headers.value(i));
                }

                //获得响应体
                //以字符串的形式
                String  result= response.body().string();

                Log.d("DELETE+ResponseResult：","DELETE"+result);
                tv.setText("DELETE"+result);
            }
        });
    }

    private void parseJSONWithGSON(String jsonData) {
        //使用轻量级的Gson解析得到的json
        Gson gson = new Gson();
        List<Book> appList = gson.fromJson(jsonData, new TypeToken<List<Book>>() {}.getType());
        for (Book book : appList) {
            //控制台输出结果，便于查看
            Log.d("MainActivity", "ID:" + book.getId());
            Log.d("MainActivity", "Book_Name" + book.getBookName());
            Log.d("MainActivity", "Book_Author" + book.getBookAuthor());
            Log.d("MainActivity", "Book_Press" + book.getBookPress());
            Log.d("MainActivity", "Book_Price" + book.getBookPrice());
        }
    }


}


