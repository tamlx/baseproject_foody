package lxt.project.myapplication.helper.retrofit_cancel_request.networking;

import lxt.project.myapplication.helper.Consts;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyCustomApiProvider {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Consts.HOST_API)
            .client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private OkHttpClient getHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient.build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
