package lxt.project.myapplication.api.account.login;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import java.util.Objects;

import b.laixuantam.myaarlibrary.api.ApiRequest;
import b.laixuantam.myaarlibrary.api.BaseApiParams;
import lxt.project.myapplication.dependency.AppProvider;
import lxt.project.myapplication.helper.Consts;
import lxt.project.myapplication.model.BaseResponseModel;
import lxt.project.myapplication.model.UserResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@ApiRequest.ApiName("customer_login")
public class LoginRequest extends ApiRequest<LoginRequest.Service, BaseResponseModel<UserResponseModel>, LoginRequest.ApiParams> {

    public LoginRequest() {
        super(LoginRequest.Service.class, RequestOrigin.NONE, Consts.HOST_API, Consts.MODE, Consts.TRUST_CERTIFICATE);
    }

    @Override
    protected void postAfterRequest(BaseResponseModel<UserResponseModel> result) {
        if (result != null && !TextUtils.isEmpty(result.getSuccess()) && Objects.requireNonNull(result.getSuccess()).equalsIgnoreCase("true")) {

            AppProvider.getPreferences().saveStatusLogin(true);
        }
    }

    @Override
    protected Call<BaseResponseModel<UserResponseModel>> call(ApiParams params) {
//        params.detect = "customer_login";
        return getService().call(params);
    }

    interface Service {
        @Headers(Consts.HEADES)
        @POST(Consts.REST_ENDPOINT)
        Call<BaseResponseModel<UserResponseModel>> call(@Body LoginRequest.ApiParams params);
    }

    public static class ApiParams extends BaseApiParams {
        public String detect;
        public String phone_number;
        public String password;
        @Nullable
        public String device_imei;

        @Nullable
        public String username;

    }
}
