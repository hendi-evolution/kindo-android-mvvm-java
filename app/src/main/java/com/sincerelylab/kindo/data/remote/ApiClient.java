package com.sincerelylab.kindo.data.remote;

import com.sincerelylab.kindo.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static boolean ENABLE_LOGGING = BuildConfig.DEBUG;

    public static APIService getService() {
        return getRetrofit().create(APIService.class);
    }

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://sincerelylab.com/kpop/")
                .client(generateClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient generateClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (ENABLE_LOGGING) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }
}
