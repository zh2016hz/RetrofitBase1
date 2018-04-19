package com.xiaoniu.finance.retrofit.data;

import com.xiaoniu.finance.retrofit.data.remote.RetrofitClient;
import com.xiaoniu.finance.retrofit.data.remote.SOService;

public class ApiUtils {

//    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";
    public static final String BASE_URL = "http://127.0.0.1/info/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}