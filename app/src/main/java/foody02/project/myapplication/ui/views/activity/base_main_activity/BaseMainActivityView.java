package foody02.project.myapplication.ui.views.activity.base_main_activity;

import b.laixuantam.myaarlibrary.base.BaseUiContainer;
import b.laixuantam.myaarlibrary.base.BaseView;
import foody02.project.myapplication.R;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.ui.views.activity.home_activity.HomeActivityViewCallback;

public class BaseMainActivityView extends BaseView<BaseMainActivityView.UIContainer> implements BaseMainActivityViewInterface {

    @Override
    public void init(HomeActivity activity, HomeActivityViewCallback callback) {
    }

    @Override
    public BaseUiContainer getUiContainer() {
        return new BaseMainActivityView.UIContainer();
    }

    @Override
    public int getViewId() {
        return R.layout.layout_base_main_activity_view;
    }

    public static class UIContainer extends BaseUiContainer {

    }
}
