package lxt.project.myapplication.helper.retrofit_cancel_request.repository;

import lxt.project.myapplication.model.UserResponseModel;
import okhttp3.RequestBody;
import lxt.project.myapplication.helper.Consts;
import lxt.project.myapplication.model.BaseResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MyCustomSearchService {

    @Headers(Consts.HEADES)
    @POST(Consts.REST_ENDPOINT)
    Call<BaseResponseModel<UserResponseModel>> getResult(@Body RequestBody params);
}
