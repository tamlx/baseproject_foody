package foody02.project.myapplication.ui.views.fragment.account.forgot_password;

public interface FragmentForgotPasswordViewCallback {
    void onClickBackHeader();

    void onRequestCheckPhoneRegister(String phone);

    void onRequestUpdatePassword(String phone, String newPassword);
}
