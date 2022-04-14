package lxt.project.myapplication.ui.views.fragment.customer.cart;

import java.util.ArrayList;

import lxt.project.myapplication.model.customer.OrderDetailModel;

public interface FragmentLayoutCartViewCallback {
    void onBackProgress();

    void goToInfoOrder(ArrayList<OrderDetailModel> arrayList);

}
