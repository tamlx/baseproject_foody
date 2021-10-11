package lxt.project.myapplication.helper.retrofit_cancel_request.repository;

import androidx.lifecycle.MutableLiveData;

import lxt.project.myapplication.model.UserResponseModel;
import lxt.project.myapplication.helper.retrofit_cancel_request.networking.MyCustomApiProvider;
import lxt.project.myapplication.model.BaseResponseModel;
import retrofit2.Call;

public class SearchCustomerAdmin {
    public MyCustomSearchService
            apiService =
            new MyCustomApiProvider().createService(MyCustomSearchService.class);
    public MutableLiveData<BaseResponseModel<UserResponseModel>> searchResultsLiveData = new MutableLiveData<>();
    public Call<BaseResponseModel<UserResponseModel>> searchResultModelCall = null;

    /*
    public MutableLiveData<BaseResponseModel<UserResponseModel>> getSearchResults(RequestListCustomerAdmin.ApiParams params) {
        BaseResponseModel baseResponseModel =
                new BaseResponseModel();

        searchResultsLiveData.postValue(baseResponseModel);
        if (searchResultModelCall != null) {
            searchResultModelCall.cancel();
        }
        MultipartBody.Builder builder = new MultipartBody.Builder();

        if (!TextUtils.isEmpty((params.filter))) {
            builder.addFormDataPart("filter", params.filter);
        }

        if (!TextUtils.isEmpty((params.type_manager))) {
            builder.addFormDataPart("type_manager", params.type_manager);
        }

        params.detect = "customer_manager";
        builder.addFormDataPart("detect", params.detect)
                .setType(MultipartBody.FORM);

        RequestBody requestBody = builder.build();

        searchResultModelCall = apiService.getResult(requestBody);
        searchResultModelCall.enqueue(new Callback<BaseResponseModel<CustomerAdminModel>>() {
            @Override
            public void onResponse(Call<BaseResponseModel<CustomerAdminModel>> call, Response<BaseResponseModel<CustomerAdminModel>> response) {

                searchResultsLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponseModel<CustomerAdminModel>> call, Throwable t) {
                if (!call.isCanceled()) {
                    BaseResponseModel baseResponseModel1 =
                            new BaseResponseModel();
                    baseResponseModel1.setSuccess("false");
                    baseResponseModel1.setMessage(t.getMessage());

                    searchResultsLiveData.postValue(baseResponseModel1);
                }
            }
        });
        return searchResultsLiveData;
    }

    =============== CALL (onRequestSearchWithFilter) ==================

    private SearchCustomerAdmin searchCustomerAdmin = new SearchCustomerAdmin();

    private void startSearching(RequestListCustomerAdmin.ApiParams params) {
        searchCustomerAdmin.getSearchResults(params).observe(this, new Observer<BaseResponseModel<CustomerAdminModel>>() {
            @Override
            public void onChanged(BaseResponseModel<CustomerAdminModel> searchResultModelGenericDataModel) {
                checkAndSetData(searchResultModelGenericDataModel);
            }
        });
    }

    private void checkAndSetData(BaseResponseModel<CustomerAdminModel> result) {
        if (result != null) {
            if (!TextUtils.isEmpty(result.getSuccess()) && result.getSuccess().equalsIgnoreCase("true")) {
                dismissProgress();
                view.clearListData();
                view.setDataList(result);
            }
        }
    }
     */
}
