package lxt.project.myapplication.ui.views.fragment.account.password_manager;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import lxt.project.myapplication.activity.HomeActivity;

public interface FragmentPasswordManagerViewInterface extends BaseViewInterface {
    void init(HomeActivity activity, FragmentPasswordManagerViewCallback callback);

    void validateUpdatePasswordSuccess();
}
