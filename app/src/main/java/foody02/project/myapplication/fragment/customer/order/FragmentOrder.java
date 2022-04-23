package foody02.project.myapplication.fragment.customer.order;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.ui.views.fragment.customer.order.FragmenOrderViewCallback;
import foody02.project.myapplication.ui.views.fragment.customer.order.FragmentOrderView;
import foody02.project.myapplication.ui.views.fragment.customer.order.FragmentOrderViewInterface;

public class FragmentOrder extends BaseFragment<FragmentOrderViewInterface, BaseParameters> implements FragmenOrderViewCallback {

    private HomeActivity homeActivity;

    @Override
    protected void initialize() {
        homeActivity = (HomeActivity) getActivity();
        view.init(homeActivity, this);
    }

    @Override
    protected FragmentOrderViewInterface getViewInstance() {
        return new FragmentOrderView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    public void onBackPress() {
        if (homeActivity != null)
            homeActivity.checkBack();
    }
}
