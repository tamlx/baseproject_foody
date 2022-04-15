package foody02.project.myapplication.ui.views.activity.base_main_activity;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.ui.views.activity.home_activity.HomeActivityViewCallback;

public interface BaseMainActivityViewInterface extends BaseViewInterface {
    void init(HomeActivity activity, HomeActivityViewCallback callback);

}
