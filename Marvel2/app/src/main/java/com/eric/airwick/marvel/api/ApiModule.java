package com.eric.airwick.marvel.api;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    private final String MARVEL_BASE_URL = "https://gateway.marvel.com/";
    private final String MARVEL_API_KEY = "apikey";
    private final String MARVEL_API_VALUE = "ae786ed483cd0499bfcaaee06726a4c2";
    private final String MARVEL_HASH_KEY = "hash";
    private final String MARVEL_PRIVATE_KEY_VALUE = "";
    private final String MARVEL_TS_KEY = "ts";
    private long MARVEL_TS_VALUE;

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

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                MARVEL_TS_VALUE = System.currentTimeMillis() /1000L;
                HttpUrl url = request.url().newBuilder()
                        .addQueryParameter(MARVEL_TS_KEY, String.valueOf(MARVEL_TS_VALUE))
                        .addQueryParameter(MARVEL_API_KEY, MARVEL_API_VALUE)
                        .addQueryParameter(MARVEL_HASH_KEY, md5Function())
                        .build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        }).addInterceptor(httpLoggingInterceptor)
                .build();

    }

    private String md5Function() {

        String stringToHash =  String.valueOf(MARVEL_TS_VALUE) + MARVEL_PRIVATE_KEY_VALUE + MARVEL_API_VALUE;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(stringToHash.getBytes());
            byte messageDigestByte[] = messageDigest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigestByte) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //TODO:add exception
        return "";
    }
}
