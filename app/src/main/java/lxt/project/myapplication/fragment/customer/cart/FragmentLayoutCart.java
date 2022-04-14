package lxt.project.myapplication.fragment.customer.cart;


import java.util.ArrayList;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.model.customer.OrderDetailModel;
import lxt.project.myapplication.ui.views.fragment.customer.cart.FragmentLayoutCartView;
import lxt.project.myapplication.ui.views.fragment.customer.cart.FragmentLayoutCartViewCallback;
import lxt.project.myapplication.ui.views.fragment.customer.cart.FragmentLayoutCartViewInterface;

import static lxt.project.myapplication.activity.HomeActivity.PRODUCT_CHOOSE_MODELS;

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
//        if (activity!=null)
//            activity.replaceFragment(new FragmentInfoOrder().newIntance(arrayList,null),true);
    }

}
