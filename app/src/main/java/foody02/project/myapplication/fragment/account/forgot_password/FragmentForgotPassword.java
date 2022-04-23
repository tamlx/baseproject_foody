package foody02.project.myapplication.fragment.account.forgot_password;

import java.util.Objects;

import b.laixuantam.myaarlibrary.base.BaseFragment;
import b.laixuantam.myaarlibrary.base.BaseParameters;
import b.laixuantam.myaarlibrary.helper.KeyboardUtils;
import b.laixuantam.myaarlibrary.widgets.dialog.alert.KAlertDialog;
import foody02.project.myapplication.activity.HomeActivity;
import foody02.project.myapplication.dependency.AppProvider;
import foody02.project.myapplication.model.UserRegisterModel;
import foody02.project.myapplication.ui.views.fragment.account.forgot_password.FragmentForgotPasswordView;
import foody02.project.myapplication.ui.views.fragment.account.forgot_password.FragmentForgotPasswordViewCallback;
import foody02.project.myapplication.ui.views.fragment.account.forgot_password.FragmentForgotPasswordViewInterface;

public class FragmentForgotPassword extends BaseFragment<FragmentForgotPasswordViewInterface, BaseParameters> implements FragmentForgotPasswordViewCallback {
    private HomeActivity activity;
    private UserRegisterModel userRegisterModel;

    @Override
    protected void initialize() {
        activity = (HomeActivity) getActivity();
        view.init(activity, this);

        userRegisterModel = AppProvider.getPreferences().getUserModel();

        KeyboardUtils.setupUI(Objects.requireNonNull(getView()), activity);
    }

    @Override
    protected FragmentForgotPasswordViewInterface getViewInstance() {
        return new FragmentForgotPasswordView();
    }

    @Override
    protected BaseParameters getParametersContainer() {
        return null;
    }

    @Override
    public void onClickBackHeader() {
        if (activity != null)
            activity.checkBack();
    }

    @Override
    public void onRequestCheckPhoneRegister(String phone) {
        if (userRegisterModel != null){
            if (!phone.equalsIgnoreCase(userRegisterModel.getUserPhone())) {
                showAlert("Số điện thoại không đúng!", KAlertDialog.ERROR_TYPE);
                return;
            }
            view.checkPhoneRegisterSuccessExists();
        }else{
            showAlert("Bạn chưa đăng ký tài khoản, vui lòng đăng ký để tiếp tục trải nghiệm", KAlertDialog.WARNING_TYPE);
        }
    }

    @Override
    public void onRequestUpdatePassword(String phone, String newPassword) {
        userRegisterModel.setUserPassword(newPassword);
        AppProvider.getPreferences().saveUserModel(userRegisterModel);
        showAlert("Cập nhật mật khẩu thành công!", KAlertDialog.SUCCESS_TYPE);
        if (activity != null)
            activity.checkBack();
    }
}
