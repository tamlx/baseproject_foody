package lxt.project.myapplication.ui.views.activity.base_main_activity;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import lxt.project.myapplication.activity.HomeActivity;
import lxt.project.myapplication.ui.views.activity.home_activity.HomeActivityViewCallback;

public interface BaseMainActivityViewInterface extends BaseViewInterface {
    void init(HomeActivity activity, HomeActivityViewCallback callback);

}
