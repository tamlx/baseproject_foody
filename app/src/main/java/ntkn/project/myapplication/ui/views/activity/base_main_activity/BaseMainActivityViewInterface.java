package ntkn.project.myapplication.ui.views.activity.base_main_activity;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import ntkn.project.myapplication.activity.HomeActivity;
import ntkn.project.myapplication.ui.views.activity.home_activity.HomeActivityViewCallback;

public interface BaseMainActivityViewInterface extends BaseViewInterface {
    void init(HomeActivity activity, HomeActivityViewCallback callback);

}
