package foody02.project.myapplication.fragment.account.login;

import android.content.Intent;

import java.util.Objects;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.helper.KeyboardUtils;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.dependency.AppProvider;
import foody02.project.myapplication.model.UserRegisterModel;
import foody02.project.myapplication.ui.views.fragment.account.login.LoginView;
import foody02.project.myapplication.ui.views.fragment.account.login.LoginViewCallback;
import foody02.project.myapplication.ui.views.fragment.account.login.LoginViewInterface;

public class FragmentLogin extends BaseFragment<LoginViewInterface, BaseParameters> implements LoginViewCallback {

    private HomeActivity activity;
    private UserRegisterModel userRegisterModel;

    @Override
    protected void initialize() {
        view.initialize(this);
        activity = (HomeActivity) getActivity();
        KeyboardUtils.setupUI(Objects.requireNonNull(getView()), getActivity());

        userRegisterModel = AppProvider.getPreferences().getUserModel();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClickForgotPassword() {
        if (activity != null) {
            activity.changeToFragmentForgotPassword();
        }
    }

    @Override
    protected LoginViewInterface getViewInstance() {
        return new LoginView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }


    @Override
    public void onClickShowRegister() {
        if (activity != null) {
            activity.changeToFragmentRegister();
        }
    }

    @Override
    public void onClickLogin(String phone, String password, boolean isAdminLogin) {

        if (userRegisterModel != null) {
            if (!phone.equalsIgnoreCase(userRegisterModel.getUserPhone())) {
                showAlert("Số điện thoại không đúng!", KAlertDialog.ERROR_TYPE);
                return;
            }
            if (!password.equalsIgnoreCase(userRegisterModel.getUserPassword())) {
                showAlert("Mật khẩu không đúng!", KAlertDialog.ERROR_TYPE);
                return;
            }
            AppProvider.getPreferences().saveStatusLogin(true);
            if (activity != null) {
                activity.changeToFragmentProductCategory();
            }
        } else {
            showAlert("Bạn chưa đăng ký tài khoản, vui lòng đăng ký để tiếp tục trải nghiệm", KAlertDialog.WARNING_TYPE);
        }


    }

}
