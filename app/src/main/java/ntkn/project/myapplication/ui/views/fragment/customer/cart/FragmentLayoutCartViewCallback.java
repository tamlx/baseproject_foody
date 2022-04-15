package ntkn.project.myapplication.ui.views.fragment.customer.cart;

import java.util.ArrayList;

import ntkn.project.myapplication.model.customer.OrderDetailModel;

public interface FragmentLayoutCartViewCallback {
    void onBackProgress();

    void goToInfoOrder(ArrayList<OrderDetailModel> arrayList);

}
