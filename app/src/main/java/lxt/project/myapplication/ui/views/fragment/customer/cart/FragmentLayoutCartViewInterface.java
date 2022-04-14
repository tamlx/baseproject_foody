package lxt.project.myapplication.ui.views.fragment.customer.cart;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.model.customer.OrderDetailModel;

public interface FragmentLayoutCartViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentLayoutCartViewCallback callback);

    void sendData(ArrayList<OrderDetailModel> arrayList);
}
