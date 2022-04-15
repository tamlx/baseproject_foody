package foody02.project.myapplication.ui.views.fragment.customer.cart;

import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.model.customer.OrderDetailModel;

public interface FragmentLayoutCartViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentLayoutCartViewCallback callback);

    void sendData(ArrayList<OrderDetailModel> arrayList);
}
