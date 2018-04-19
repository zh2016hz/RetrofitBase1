package com.xiaoniu.finance.retrofit.data.remote;

import com.xiaoniu.finance.retrofit.data.model.SOAnswersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 文件描述：
 * Created by  xn069392
 * 创建时间    2018/4/19
 */
//ttps://api.stackexchange.com/2.2/
//https://api.stackexchange.com/2.2/answers?order=desc&sort=activity&site=stackoverflow
//    http://127.0.0.1/info/data.json
public interface SOService {
/*    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers();*/
    @GET("data.json/data.json")
    Call<List<SOAnswersResponse>> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers(@Query("tagged") String tags);
}
