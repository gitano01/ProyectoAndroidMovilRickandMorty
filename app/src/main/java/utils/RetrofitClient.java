package utils;

import Interfaces.InvokeService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static RetrofitClient instance = null;
    private InvokeService invoke;

    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(InvokeService.API_CONSUMER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        invoke = retrofit.create(InvokeService.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public InvokeService getInvoke(){
        return invoke;
    }

}
