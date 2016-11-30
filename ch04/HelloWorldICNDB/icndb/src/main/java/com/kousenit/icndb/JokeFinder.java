package com.kousenit.icndb;

import android.os.AsyncTask;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class JokeFinder {
    private TextView jokeView;
    private Retrofit retrofit;
    private AsyncTask<String, Void, String> task;

    interface ICNDB {
        @GET("/jokes/random")
        Call<IcndbJoke> getJoke(@Query("firstName") String firstName,
                                @Query("lastName") String lastName,
                                @Query("limitTo") String limitTo);
    }

    public JokeFinder() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.icndb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getJoke(TextView textView, String first, String last) {
        this.jokeView = textView;

        ICNDB icndb = retrofit.create(ICNDB.class);
        icndb.getJoke(first, last, "[nerdy]").enqueue(new Callback<IcndbJoke>() {
            @Override
            public void onResponse(Call<IcndbJoke> call, Response<IcndbJoke> response) {
                if (!response.isSuccessful()) {
                    System.out.println(call.request().url() + " failed: " + response.code());
                    return;
                }

                jokeView.setText(response.body().getJoke());
            }

            @Override
            public void onFailure(Call<IcndbJoke> call, Throwable t) {
                System.out.println(call.request().url() + " failed: " + t);
            }
        });
    }
}
