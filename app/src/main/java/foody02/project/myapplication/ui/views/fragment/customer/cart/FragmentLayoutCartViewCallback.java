package foody02.project.myapplication.ui.views.fragment.customer.cart;

import java.util.ArrayList;

import foody02.project.myapplication.model.customer.OrderDetailModel;

public interface FragmentLayoutCartViewCallback {
    void onBackProgress();

    void goToInfoOrder(ArrayList<OrderDetailModel> arrayList);

}
