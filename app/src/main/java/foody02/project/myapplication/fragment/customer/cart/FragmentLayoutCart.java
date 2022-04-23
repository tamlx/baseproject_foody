package foody02.project.myapplication.fragment.customer.cart;


import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import b.laixuantam.myaarlibrary.widgets.ultils.ConvertDate;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.dependency.AppProvider;
import foody02.project.myapplication.model.customer.OrderDetailModel;
import foody02.project.myapplication.model.customer.OrderHistoryDetailModel;
import foody02.project.myapplication.model.customer.OrderHistoryModel;
import foody02.project.myapplication.model.customer.OrderModel;
import foody02.project.myapplication.ui.views.fragment.customer.cart.FragmentLayoutCartView;
import foody02.project.myapplication.ui.views.fragment.customer.cart.FragmentLayoutCartViewCallback;
import foody02.project.myapplication.ui.views.fragment.customer.cart.FragmentLayoutCartViewInterface;

import static foody02.project.myapplication.activity.HomeActivity.PRODUCT_CHOOSE_MODELS;

public class FragmentLayoutCart extends BaseFragment<FragmentLayoutCartViewInterface, BaseParameters> implements FragmentLayoutCartViewCallback {

    HomeActivity activity;

    @Override
    protected void initialize() {
        activity = (HomeActivity) getActivity();
        view.init(activity, this);

        getData();
    }

    private void getData() {
        ArrayList<OrderDetailModel> arrayList = PRODUCT_CHOOSE_MODELS;
        view.sendData(arrayList);
    }

    @Override
    protected FragmentLayoutCartViewInterface getViewInstance() {
        return new FragmentLayoutCartView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    public void onBackProgress() {
        if (activity != null) {
            activity.checkBack();
        }
    }

    @Override
    public void goToInfoOrder(ArrayList<OrderDetailModel> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            showAlert("Bạn chưa chọn sản phẩm nào!", KAlertDialog.ERROR_TYPE);
            return;
        }
        long timeCurrent = System.currentTimeMillis();
        OrderModel orderModel = new OrderModel();
        orderModel.setId_order(String.valueOf(timeCurrent));
        orderModel.setOrder_date(ConvertDate.getDateFromTimestamp(timeCurrent, "dd/MM/yyyy HH:mm"));

        long totalOrderPrice = 0;
        for (OrderDetailModel item : arrayList) {
            item.setId_order(String.valueOf(timeCurrent));
            totalOrderPrice += (Integer.parseInt(item.getQuantity()) * Integer.parseInt(item.getPrice_sell()));
        }
        orderModel.setOrder_total_price(String.valueOf((int) totalOrderPrice));

        OrderHistoryModel historyModel = AppProvider.getPreferences().getOrderHistoryModel();
        if (historyModel == null){
            historyModel = new OrderHistoryModel();
            ArrayList<OrderModel> listOrderHistory = new ArrayList<>();
            listOrderHistory.add(orderModel);
            historyModel.setListOrderHistory(listOrderHistory);
            AppProvider.getPreferences().saveOrderHistoryModel(historyModel);

        }else{
            historyModel.getListOrderHistory().add(0,orderModel);
            AppProvider.getPreferences().saveOrderHistoryModel(historyModel);
        }

        OrderHistoryDetailModel historyDetailModel = AppProvider.getPreferences().getOrderHistoryDetailModel();
        if (historyDetailModel == null){
            historyDetailModel = new OrderHistoryDetailModel();
            ArrayList<OrderDetailModel> PRODUCT_CHOOSE_MODELS = new ArrayList<>();
            PRODUCT_CHOOSE_MODELS.addAll(arrayList);

            historyDetailModel.setPRODUCT_CHOOSE_MODELS(PRODUCT_CHOOSE_MODELS);
            AppProvider.getPreferences().saveOrderHistoryDetailModel(historyDetailModel);
        }else{
            historyDetailModel.getPRODUCT_CHOOSE_MODELS().addAll(arrayList);
            AppProvider.getPreferences().saveOrderHistoryDetailModel(historyDetailModel);
        }
        showAlert("Đặt hàng thành công!", KAlertDialog.SUCCESS_TYPE);
        if (activity != null)
            activity.changeToFragmentProductCategory();
    }

}
