package foody02.project.myapplication.ui.views.fragment.account.forgot_password;

import b.laixuantam.myaarlibrary.base.BaseViewInterface;
import foody02.project.myapplication.activity.HomeActivity;

public interface FragmentForgotPasswordViewInterface extends BaseViewInterface {

    void init(HomeActivity activity, FragmentForgotPasswordViewCallback callback);

    void checkPhoneRegisterSuccessExists();

}
