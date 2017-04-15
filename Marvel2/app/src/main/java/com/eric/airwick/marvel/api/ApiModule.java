package com.eric.airwick.marvel.api;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by airwick on 15/04/2017.
 */

@Module
public class ApiModule {

    private final String MARVEL_BASE_URL = "http://gateway.marvel.com/";
    private final String MARVEL_API_KEY = "api_key";
    private final String MARVEL_API_VALUE = "ae786ed483cd0499bfcaaee06726a4c2";

    @Provides
    @Singleton
    public MarvelService provideMarvelService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MARVEL_BASE_URL)
                .client(getHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return new MarvelService(retrofit);
    }

    private OkHttpClient getHttpClient() {

        //Sets up HTTP Client

        //adds logging
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder().addQueryParameter(
                        MARVEL_API_KEY, MARVEL_API_VALUE).build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        }).addInterceptor(httpLoggingInterceptor)
                .build();

    }
}
