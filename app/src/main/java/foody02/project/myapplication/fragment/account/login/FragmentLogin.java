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
                showAlert("S??? ??i???n tho???i kh??ng ????ng!", KAlertDialog.ERROR_TYPE);
                return;
            }
            if (!password.equalsIgnoreCase(userRegisterModel.getUserPassword())) {
                showAlert("M???t kh???u kh??ng ????ng!", KAlertDialog.ERROR_TYPE);
                return;
            }
            AppProvider.getPreferences().saveStatusLogin(true);
            if (activity != null) {
                activity.changeToFragmentProductCategory();
            }
        } else {
            showAlert("B???n ch??a ????ng k?? t??i kho???n, vui l??ng ????ng k?? ????? ti???p t???c tr???i nghi???m", KAlertDialog.WARNING_TYPE);
        }


    }

}
